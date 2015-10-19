class TeamsController < ApplicationController

  def index
    render :json => { players: Team.all }
  end

  def new

  end

  def create

  end

  def edit

  end

  def update

  end

end