class Fixture < ActiveRecord::Base

  has_many :date_matches

  def self.for(teams, a_number_of_date_matches)
    fixture = self.new
    fixture.send(:create_fixture_with, teams, a_number_of_date_matches)
    fixture
  end

  def as_json(options = nil)
    json = super options
    json[:date_matches] = date_matches
    json
  end

  protected

  def create_fixture_with(teams, a_number_of_date_matches)

    teams = teams
    number_of_rounds = (teams.length-2)+1
    number_of_matches = teams.length/2
    number_of_rounds.times do |round|
      current_date_match = DateMatch.new(:round => round+1)
      date_matches << current_date_match

      number_of_matches.times do |index|
        if round % 2 == 1
          local = teams[index]
          visitor = teams[number_of_rounds - index]
        else
          visitor = teams[index]
          local = teams[number_of_rounds - index]
        end
        match = Match.new(local: local, visitor: visitor)
        current_date_match.add_match(match)
      end
      puts 'antes'
      puts teams.inspect
      teams = teams.unshift teams.last
      teams.to_a.delete_at(teams.to_a.length - 1)
      puts 'despues'
      puts teams.inspect
    end
  end
# def create_fixture_with(teams, a_number_of_date_matches)
#   teams = teams
#   a_number_of_date_matches.times do |index|
#     create_round index, teams
#     puts 'antes'
#     puts teams.inspect
#     teams = teams.unshift teams.last
#     teams.to_a.delete_at(teams.to_a.length - 1)
#     puts 'despues'
#     puts teams.inspect
#   end
# end

# def create_round(number_of_round, teams)
#   teams = teams.to_a
#   middle = teams.size / 2
#   number_of_rounds = (teams.length-2)+1
#   number_of_matches = teams.length/2
#   # l1 = teams[0..(middle-1)]
#   # l2 = teams[middle..teams.size+1]
#   number_of_matches.times do |index|
#     local = teams[index]
#     visitor = teams[number_of_rounds - index]
#     current_date_match = DateMatch.new(:round => number_of_round+1)
#     date_matches << current_date_match
#
#     l1.size.times do |index|
#       # if number_of_round % 2 == 1
#       local = l1[index]
#       visitor = l2[index]
#       # else
#       #   local = l2[index]
#       #   visitor = l1[index]
#       # end
#       if local!=nil || visitor!=nil
#         match = Match.new(local: local, visitor: visitor)
#         current_date_match.add_match(match)
#       end
#     end
#   end
#
end