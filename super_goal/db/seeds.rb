# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rake db:seed (or created alongside the db with db:setup).
#
# Examples:
#
#   cities = City.create([{ name: 'Chicago' }, { name: 'Copenhagen' }])
#   Mayor.create(name: 'Emanuel', city: cities.first)

# Player.create!(name: 'Johnny Bravo', team: 'Test Team', position: Position.forward)
# Player.create!(name: 'Ace Ventura', team: 'Test Team', position: Position.midfield)
# Player.create!(name: 'Luke Skywalker', team: 'Test Team', position: Position.defender)
# Player.create!(name: 'Chewbacca', team: 'Test Team', position: Position.goalkeeper)

goalkeeper = Position.goalkeeper.name
defender = Position.defender.name
midfield = Position.midfield.name
forward = Position.forward.name

Player.create!(name: 'Agustin Orion', team: 'Boca Jrs', position: goalkeeper)
Player.create!(name: 'Guillermo Sara', team: 'Boca Jrs', position: goalkeeper)
Player.create!(name: 'Daniel Diaz', team: 'Boca Jrs', position: defender)
Player.create!(name: 'Fabian Monzon', team: 'Boca Jrs', position: defender)
Player.create!(name: 'Gino Peruzzi', team: 'Boca Jrs', position: defender)
Player.create!(name: 'Leandro Marin', team: 'Boca Jrs', position: defender)
Player.create!(name: 'Lisandro Magallan', team: 'Boca Jrs', position: defender)
Player.create!(name: 'Fernando Gago', team: 'Boca Jrs', position: midfield)
Player.create!(name: 'Pablo Perez', team: 'Boca Jrs', position: midfield)
Player.create!(name: 'Nicolas Lodeiro', team: 'Boca Jrs', position: midfield)
Player.create!(name: 'Marcelo Meli', team: 'Boca Jrs', position: midfield)
Player.create!(name: 'Nicolas Colazo', team: 'Boca Jrs', position: midfield)
Player.create!(name: 'Cristian Erbes', team: 'Boca Jrs', position: midfield)
Player.create!(name: 'Carlos Tevez', team: 'Boca Jrs', position: forward)
Player.create!(name: 'Andres Chavez', team: 'Boca Jrs', position: forward)
Player.create!(name: 'Jonathan Caleri', team: 'Boca Jrs', position: forward)
Player.create!(name: 'Sebastian Palacios', team: 'Boca Jrs', position: forward)
Player.create!(name: 'Marcelo Barovero', team: 'River Plate', position: goalkeeper)
Player.create!(name: 'Augusto Batalla', team: 'River Plate', position: goalkeeper)
Player.create!(name: 'Jonathan Maidana', team: 'River Plate', position: defender)
Player.create!(name: 'Emanuel Mammana', team: 'River Plate', position: defender)
Player.create!(name: 'Leonel Vangioni', team: 'River Plate', position: defender)
Player.create!(name: 'Eder Alvarez Balanta', team: 'River Plate', position: defender)
Player.create!(name: 'Gabriel Mercado', team: 'River Plate', position: defender)
Player.create!(name: 'Carlos Sanchez', team: 'River Plate', position: midfield)
Player.create!(name: 'Matias Kranevitter', team: 'River Plate', position: midfield)
Player.create!(name: 'Leonardo Ponzio', team: 'River Plate', position: midfield)
Player.create!(name: 'Luis Gonzalez', team: 'River Plate', position: midfield)
Player.create!(name: 'Leonardo Pisculichi', team: 'River Plate', position: midfield)
Player.create!(name: 'Javier Saviola', team: 'River Plate', position: forward)
Player.create!(name: 'Lucas Alario', team: 'River Plate', position: forward)
Player.create!(name: 'Sebastian Driussi', team: 'River Plate', position: forward)
Player.create!(name: 'Rodrigo Mora', team: 'River Plate', position: forward)

# Team.create!(name: 'ricky team' , logo: 'https://pbs.twimg.com/media/B7y4GjNIcAA-DmN.jpg')