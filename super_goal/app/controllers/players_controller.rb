class PlayersController < ApplicationController

  def index
    render :json => { players: Player.all }
  end

  def create
    Player.create!(name: player_params[:name], team: player_params[:team], position: position)

    render :json => { }
  end

  def edit
    player = Player.find(params[:id])

    render json: { player: player }
  end

  def update
    player = Player.find(params[:id])
    player.update!(name: player_params[:name], team: player_params[:team], position: position)

    render json: { }
  end

  protected

  def player_params
    params.require(:player).permit(:name, :team, :position)
  end

  def position
    Position.send(player_params[:position].downcase.to_sym)
  end
end