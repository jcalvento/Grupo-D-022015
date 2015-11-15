class AddRelationBetweenTeamAndPlayers < ActiveRecord::Migration
  def up
    create_table :players_teams, :id => false do |t|
      t.integer :player_id
      t.integer :team_id
    end

    add_index :players_teams, [:player_id, :team_id]
  end

  def down
    remove_index :players_teams

    drop_table :players_teams
  end
end
