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
    puts "GENERATING FIXTURE FOR #{params[:id]}"
    tournament = Tournament.find(params[:id])
    amount_of_teams = tournament.teams.length
    tournament.fixture = Fixture.for(tournament.teams,((amount_of_teams*(amount_of_teams-1))/2))
    tournament.save!

    render json: { fixture: tournament.fixture }
  end

  def fixture
    fixture = Fixture.where(:tournament_id => params[:id]).first

    render json: { fixture: fixture}
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

  protected

  def tournament_params
    params.require(:tournament).permit(:name, :max_amount_of_teams, :application_deadline)
  end

  def goal_params
    params.require(:goal).permit(:number_of_goals, :player_id, :position)
  end

end