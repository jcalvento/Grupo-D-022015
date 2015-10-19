class PlayersController < ApplicationController

  def index
    render :json => { players: Player.all }
  end

  def create
    Player.create!(name: player_params[:name], team: player_params[:team], position: position)

    render :json => { }
  end

  def update

  end

  protected

  def player_params
    params.require(:player).permit(:name, :team, :position)
  end

  def position
    Position.send(player_params[:position].downcase.to_sym)
  end
end