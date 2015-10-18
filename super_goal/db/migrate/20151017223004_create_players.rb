class CreatePlayers < ActiveRecord::Migration
  def change
    reversible do |dir|
      dir.up {
        create_table :positions do |t|
          t.string :type
          t.timestamps null: false
        end

        create_table :players do |t|
          t.string :name
          t.string :team
          t.belongs_to :position, index: true
          t.timestamps null: false
        end
      }

      dir.down {
        drop_table :positions
        drop_table :players
      }

    end
  end
end
