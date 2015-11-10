class CreateFixture < ActiveRecord::Migration
  def up
    create_table :fixtures
    add_belongs_to :date_matches, :fixture
    add_belongs_to :fixtures, :tournament
  end

  def down
    drop_table :fixtures
    remove_belongs_to :date_matches, :fixture
    remove_belongs_to :fixtures, :tournament
  end
end
