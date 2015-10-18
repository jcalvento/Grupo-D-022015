class CreateTeams < ActiveRecord::Migration
  def up
    create_table :teams do |t|
      t.string :name
      t.string :logo
      t.integer :captain_id
      t.belongs_to :match
    end
  end

  def down
    drop_table :teams
  end
end
