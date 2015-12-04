class AddEndedFlagToDateMatches < ActiveRecord::Migration
  def up
    add_column :date_matches, :ended, :boolean, default: false
  end

  def down
    remove_column :date_matches, :ended
  end
end
