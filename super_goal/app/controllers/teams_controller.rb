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

  def getPlayers
    render :json => { players: Player.all }
  end

  protected

  def team_params
    params.require(:team).permit(:name, :logo)
  end

end