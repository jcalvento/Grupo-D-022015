class CreatePlayers < ActiveRecord::Migration
  def change
    reversible do |dir|
      dir.up {
        create_table :players do |t|
          t.string :name
          t.string :team
          t.timestamps null: false
        end

        create_table :positions do |t|
          t.string :type
          t.belongs_to :player
          t.timestamps null: false
        end
      }

      dir.down {
        drop_table :players
        drop_table :positions
      }

    end
  end
end
