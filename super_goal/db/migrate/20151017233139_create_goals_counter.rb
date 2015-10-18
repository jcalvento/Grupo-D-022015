class CreateGoalsCounter < ActiveRecord::Migration
  def up
    create_table :goals_counters do |t|
      t.integer :number_of_goals
    end

    add_belongs_to :players, :goal
    add_belongs_to :positions, :goal
    add_belongs_to :date_matches, :goal
  end

  def down
    drop_table :goals_counters

    remove_belongs_to :players, :goal
    remove_belongs_to :positions, :goal
    remove_belongs_to :date_matches, :goal
  end
end
