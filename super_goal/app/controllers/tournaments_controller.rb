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

  protected

  def tournament_params
    params.require(:tournament).permit(:name, :max_amount_of_teams, :application_deadline, :teams)
  end
end