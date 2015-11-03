class CreateTournament < ActiveRecord::Migration
  def up
    create_table :tournaments do |t|
      t.string :name
      t.integer :max_amount_of_teams
      t.date :application_deadline
    end
  end

  def down
    drop_table :tournaments
  end
end
