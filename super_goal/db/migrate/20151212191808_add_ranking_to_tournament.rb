class AddRankingToTournament < ActiveRecord::Migration
  def up
    add_column :tournaments, :ranking, :text
  end

  def down
    remove_column :tournaments, :ranking
  end
end
