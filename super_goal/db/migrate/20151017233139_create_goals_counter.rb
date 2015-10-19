class CreateGoalsCounter < ActiveRecord::Migration
  def up
    create_table :goals_counters do |t|
      t.integer :number_of_goals
      t.belongs_to :player
      t.belongs_to :date_match
    end

    add_belongs_to :positions, :goals_counter
  end

  def down
    drop_table :goals_counters

    remove_belongs_to :positions, :goals_counter
  end
end
