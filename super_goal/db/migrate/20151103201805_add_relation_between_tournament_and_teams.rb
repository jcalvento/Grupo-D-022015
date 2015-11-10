class AddRelationBetweenTournamentAndTeams < ActiveRecord::Migration
  def up
    create_table :teams_tournaments, :id => false do |t|
      t.integer :team_id
      t.integer :tournament_id
    end
    add_index :teams_tournaments, [:team_id, :tournament_id]
  end

  def down
    drop_table :teams_tournaments
  end
end
