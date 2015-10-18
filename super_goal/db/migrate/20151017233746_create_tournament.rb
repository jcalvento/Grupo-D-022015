class CreateTournament < ActiveRecord::Migration
  def up
    create_table :tournaments do |t|
      t.string :name
      t.integer :max_amount_of_teams
      t.date :application_deadline
    end

    add_belongs_to :teams, :tournament
  end

  def down
    drop_table :tournaments
    remove_belongs_to :teams, :tournament
  end
end
