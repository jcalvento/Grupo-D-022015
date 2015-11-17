class PlayersController < ApplicationController

  def index
    players = Player.all.paginate(page: params[:page], per_page: 5)
    render :json => { players: players }
  end

  def create
    Player.create!(player_params)

    render :json => { }
  end

  def edit
    player = Player.find(params[:id])

    render json: { player: player }
  end

  def update
    player = Player.find(params[:id])
    player.update!(player_params)

    render json: { }
  end

  def destroy
    player = Player.find(params[:id])
    player.destroy

    index
  end

  protected

  def player_params
    params.require(:player).permit(:name, :team, :position)
  end

end