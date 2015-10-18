class AddRelationBetweenTeamAndPlayers < ActiveRecord::Migration
  def up
    add_belongs_to :players, :team
  end

  def down
    remove_belongs_to :players, :team
  end
end
