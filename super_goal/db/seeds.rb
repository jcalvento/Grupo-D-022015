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

orion = Player.create!(name: 'Agustin Orion', team: 'Boca Jrs', position: goalkeeper)
sara = Player.create!(name: 'Guillermo Sara', team: 'Boca Jrs', position: goalkeeper)
diaz = Player.create!(name: 'Daniel Diaz', team: 'Boca Jrs', position: defender)
monzon = Player.create!(name: 'Fabian Monzon', team: 'Boca Jrs', position: defender)
peruzzi = Player.create!(name: 'Gino Peruzzi', team: 'Boca Jrs', position: defender)
marin = Player.create!(name: 'Leandro Marin', team: 'Boca Jrs', position: defender)
magallan = Player.create!(name: 'Lisandro Magallan', team: 'Boca Jrs', position: defender)
gago = Player.create!(name: 'Fernando Gago', team: 'Boca Jrs', position: midfield)
perez = Player.create!(name: 'Pablo Perez', team: 'Boca Jrs', position: midfield)
lodeiro = Player.create!(name: 'Nicolas Lodeiro', team: 'Boca Jrs', position: midfield)
meli = Player.create!(name: 'Marcelo Meli', team: 'Boca Jrs', position: midfield)
colazo = Player.create!(name: 'Nicolas Colazo', team: 'Boca Jrs', position: midfield)
erbes = Player.create!(name: 'Cristian Erbes', team: 'Boca Jrs', position: midfield)
tevez = Player.create!(name: 'Carlos Tevez', team: 'Boca Jrs', position: forward)
chavez = Player.create!(name: 'Andres Chavez', team: 'Boca Jrs', position: forward)
caleri = Player.create!(name: 'Jonathan Caleri', team: 'Boca Jrs', position: forward)
palacios = Player.create!(name: 'Sebastian Palacios', team: 'Boca Jrs', position: forward)
barovero = Player.create!(name: 'Marcelo Barovero', team: 'River Plate', position: goalkeeper)
batalla = Player.create!(name: 'Augusto Batalla', team: 'River Plate', position: goalkeeper)
maidana = Player.create!(name: 'Jonathan Maidana', team: 'River Plate', position: defender)
mammana = Player.create!(name: 'Emanuel Mammana', team: 'River Plate', position: defender)
vangioni = Player.create!(name: 'Leonel Vangioni', team: 'River Plate', position: defender)
balanta  = Player.create!(name: 'Eder Alvarez Balanta', team: 'River Plate', position: defender)
mercado = Player.create!(name: 'Gabriel Mercado', team: 'River Plate', position: defender)
sanchez = Player.create!(name: 'Carlos Sanchez', team: 'River Plate', position: midfield)
kraneviter = Player.create!(name: 'Matias Kranevitter', team: 'River Plate', position: midfield)
ponzio = Player.create!(name: 'Leonardo Ponzio', team: 'River Plate', position: midfield)
gonzalez = Player.create!(name: 'Luis Gonzalez', team: 'River Plate', position: midfield)
pisculichi = Player.create!(name: 'Leonardo Pisculichi', team: 'River Plate', position: midfield)
saviola = Player.create!(name: 'Javier Saviola', team: 'River Plate', position: forward)
alario = Player.create!(name: 'Lucas Alario', team: 'River Plate', position: forward)
driussi = Player.create!(name: 'Sebastian Driussi', team: 'River Plate', position: forward)
mora = Player.create!(name: 'Rodrigo Mora', team: 'River Plate', position: forward)

team_list_a = [orion,diaz,magallan,mercado,meli,lodeiro,ponzio,gonzalez,tevez,mora,chavez]
team_list_b = [barovero,maidana,mammana,marin,colazo,erbes,kraneviter,pisculichi,saviola,caleri,palacios]
team_list_c = [sara,monzon,peruzzi,batalla,sanchez,perez,gago,kraneviter,driussi,alario,tevez]
team_list_d = [orion,vangioni,balanta,magallan,gago,meli,sanchez,erbes,chavez,saviola,caleri]

Team.create!(name: 'ricky team', logo: 'https://pbs.twimg.com/media/B7y4GjNIcAA-DmN.jpg',
players: team_list_b)
Team.create!(name: 'team 2', logo: 'http://dummyimage.com/80x80/000/fff&text=B',
players: team_list_a)
Team.create!(name: 'team 3', logo: 'http://dummyimage.com/80x80/000/fff&text=C',
players: team_list_c)
Team.create!(name: 'team 4', logo: 'http://dummyimage.com/80x80/000/fff&text=D',
players: team_list_d)
