class TournamentsController < ApplicationController

  def index
    render :json => { tournaments: Tournament.all }
  end

  def create
    Tournament.create!(tournament_params)

    render :json => {}
  end

  def edit
    tournament = Tournament.find(params[:id])

    render json: { tournament: tournament }
  end

  def update
    tournament = Tournament.find(params[:id])
    tournament.update!(tournament_params)

    render json: { }
  end

  def destroy
    tournament = Tournament.find(params[:id])
    tournament.destroy

    index
  end

  def available_teams
    tournament = Tournament.find(params[:id])
    tournament_teams = tournament.teams
    all_teams = Team.all
    available_teams = all_teams.reject { |team| tournament_teams.include? team }

    render :json => { teams: available_teams }
  end

  def add_team
    tournament = Tournament.find(params[:id])
    team = Team.find(params[:team_id])
    tournament.add_team team
    tournament.save!

    available_teams
  end

  def remove_team
    tournament = Tournament.find(params[:id])
    team = Team.find(params[:team_id])
    tournament.teams.delete team
    tournament.save!

    render json: { tournament: tournament }
  end

  def generate_fixture
    tournament = Tournament.find(params[:id])
    amount_of_teams = tournament.teams.length
    tournament.fixture = Fixture.for(tournament.teams,((amount_of_teams*(amount_of_teams-1))/2))
    tournament.save!

    render json: { fixture: tournament.fixture }
  end

  def fixture
    fixture = Fixture.where(:tournament_id => params[:id]).first

    render json: { fixture: fixture }
  end

  def date_match_goals
    date_match = DateMatch.find(params[:date_match_id])
    goals = GoalsCounter.where(date_match_id: date_match.id)
    players = date_match.fixture.tournament.players

    render json: { goals: goals, players: players }
  end

  def add_date_match_goal
    date_match = DateMatch.find(params[:date_match_id])
    player = Player.find(goal_params[:player_id])
    date_match.add_goals_of(player, goal_params[:position], goal_params[:number_of_goals]).save!

    date_match_goals
  end

  def end_date_match
    date_match = DateMatch.find(params[:date_match_id])
    date_match.update_attributes! ended: true
    tournament = date_match.fixture.tournament
    tournament.update_ranking
    tournament.save!

    render json: { date_match: date_match }
  end

  def add_date_match_from_csv
    date_match = DateMatch.find(params[:date_match_id])
    csv_text = params[:csv_file]
    csv_text.each do |row|
      player = Player.find_by_name(row['name'])
      date_match.add_goals_of(player, row['position'], row['goal']).save!
    end

    date_match_goals
  end

  def date_match_details
    date_match = DateMatch.find(params[:date_match_id])

    render json: {
        matches: date_match.matches,
        players_points: date_match.matches.inject({}) {
            |memo, match| memo.merge match.players_points
        }
    }
  end

  def ranking
    tournament = Tournament.find(params[:id])

    render json: { ranking: tournament.ranking }
  end

  protected

  def tournament_params
    params.require(:tournament).permit(:name, :max_amount_of_teams, :application_deadline)
  end

  def goal_params
    params.require(:goal).permit(:number_of_goals, :player_id, :position)
  end

end