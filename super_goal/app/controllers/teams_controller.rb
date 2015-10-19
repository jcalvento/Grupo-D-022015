class TeamsController < ApplicationController

  def index
    render json: { teams: Team.all }
  end

  def create
    Team.create!(team_params)

    render json: { }
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

  protected

  def team_params
    params.require(:team).permit(:name, :logo)
  end

end