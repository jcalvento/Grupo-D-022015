class TeamsController < ApplicationController

  def index
    render :json => { teams: Team.all }
  end

  def create
    Team.create!(team_params)

    render :json => { }
  end

  def edit
    team = Team.find(params[:id])

    render json: { team: team }
  end

  def update
    team = Team.find(params[:id])
    team.update!(team_params)

    render json: { }
  end

  def destroy
    team = Team.find(params[:id])
    team.destroy

    index
  end

  def available_players
    team = Team.find(params[:id])
    team_players = team.players
    all_players = Player.all
    available_players = all_players.reject { |player| team_players.include? player }

    render :json => { players: available_players }
  end

  def add_player
    team = Team.find(params[:id])
    player = Player.find(params[:player_id])
    team.add_player player
    team.save!

    available_players

  rescue Exception => e
    render json: { error: e.message }, status: :internal_server_error
  end

  def remove_player
    team = Team.find(params[:id])
    player = Player.find(params[:player_id])
    team.players.delete player
    team.save!

    render json: { team: team }
  end

  protected

  def team_params
    params.require(:team).permit(:name, :logo)
  end

end