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

ActiveRecord::Schema.define(version: 20151204183534) do

  create_table "date_matches", force: :cascade do |t|
    t.integer  "round"
    t.date     "date"
    t.datetime "created_at",                 null: false
    t.datetime "updated_at",                 null: false
    t.integer  "fixture_id"
    t.boolean  "ended",      default: false
  end

  create_table "fixtures", force: :cascade do |t|
    t.integer "tournament_id"
  end

  create_table "goals_counters", force: :cascade do |t|
    t.integer "number_of_goals"
    t.string  "position"
    t.integer "player_id"
    t.integer "date_match_id"
  end

  create_table "matches", force: :cascade do |t|
    t.integer "date_match_id"
    t.integer "local_id"
    t.integer "visitor_id"
  end

  create_table "players", force: :cascade do |t|
    t.string   "name"
    t.string   "team"
    t.string   "position"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "players_teams", id: false, force: :cascade do |t|
    t.integer "player_id"
    t.integer "team_id"
  end

  add_index "players_teams", ["player_id", "team_id"], name: "index_players_teams_on_player_id_and_team_id"

  create_table "teams", force: :cascade do |t|
    t.string  "name"
    t.string  "logo"
    t.integer "captain_id"
  end

  create_table "teams_tournaments", id: false, force: :cascade do |t|
    t.integer "team_id"
    t.integer "tournament_id"
  end

  add_index "teams_tournaments", ["team_id", "tournament_id"], name: "index_teams_tournaments_on_team_id_and_tournament_id"

  create_table "tournaments", force: :cascade do |t|
    t.string  "name"
    t.integer "max_amount_of_teams"
    t.date    "application_deadline"
  end

  create_table "users", force: :cascade do |t|
    t.string   "email",                  default: "", null: false
    t.string   "encrypted_password",     default: "", null: false
    t.string   "reset_password_token"
    t.datetime "reset_password_sent_at"
    t.datetime "remember_created_at"
    t.integer  "sign_in_count",          default: 0,  null: false
    t.datetime "current_sign_in_at"
    t.datetime "last_sign_in_at"
    t.string   "current_sign_in_ip"
    t.string   "last_sign_in_ip"
  end

  add_index "users", ["email"], name: "index_users_on_email", unique: true
  add_index "users", ["reset_password_token"], name: "index_users_on_reset_password_token", unique: true

end
