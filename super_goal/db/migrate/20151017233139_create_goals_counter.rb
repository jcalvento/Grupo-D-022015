class CreateGoalsCounter < ActiveRecord::Migration
  def up
    create_table :goals_counters do |t|
      t.integer :number_of_goals
      t.string :position
      t.belongs_to :player
      t.belongs_to :date_match
    end
  end

  def down
    drop_table :goals_counters
  end
end
