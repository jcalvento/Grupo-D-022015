class AddRelationBetweenTournamentAndTeams < ActiveRecord::Migration
  def up
    add_belongs_to :teams, :tournament
  end

  def down
    remove_belongs_to :teams, :tournament
  end
end
