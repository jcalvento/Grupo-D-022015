# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rake db:seed (or created alongside the db with db:setup).
#
# Examples:
#
#   cities = City.create([{ name: 'Chicago' }, { name: 'Copenhagen' }])
#   Mayor.create(name: 'Emanuel', city: cities.first)

Player.create!(name: 'Johnny Bravo', team: 'Test Team', position: Position.forward)
Player.create!(name: 'Ace Ventura', team: 'Test Team', position: Position.midfield)
Player.create!(name: 'Luke Skywalker', team: 'Test Team', position: Position.defender)
Player.create!(name: 'Chewbacca', team: 'Test Team', position: Position.goalkeeper)