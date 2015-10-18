# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20151017235055) do

  create_table "date_matches", force: :cascade do |t|
    t.date     "date"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.integer  "goal_id"
    t.integer  "fixture_id"
  end

  create_table "fixtures", force: :cascade do |t|
  end

  create_table "goals_counters", force: :cascade do |t|
    t.integer "number_of_goals"
  end

  create_table "matches", force: :cascade do |t|
    t.integer "date_match_id"
  end

  create_table "players", force: :cascade do |t|
    t.string   "name"
    t.string   "team"
    t.integer  "position_id"
    t.datetime "created_at",  null: false
    t.datetime "updated_at",  null: false
    t.integer  "team_id"
    t.integer  "goal_id"
  end

  add_index "players", ["position_id"], name: "index_players_on_position_id"

  create_table "positions", force: :cascade do |t|
    t.string   "type"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.integer  "goal_id"
  end

  create_table "teams", force: :cascade do |t|
    t.string  "name"
    t.string  "logo"
    t.integer "captain_id"
    t.integer "match_id"
    t.integer "tournament_id"
  end

  create_table "tournaments", force: :cascade do |t|
    t.string  "name"
    t.integer "max_amount_of_teams"
    t.date    "application_deadline"
  end

end
