class CreateMatch < ActiveRecord::Migration
  def up
    create_table :date_matches do |t|
      t.date :date
      t.timestamps null: false
    end

    create_table :matches do |t|
      t.belongs_to :date_match
    end

  end

  def down
    drop_table :date_matches
    drop_table :matches
  end
end
