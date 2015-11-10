class Fixture < ActiveRecord::Base

  has_many :date_matches

  def self.for(teams, a_number_of_date_matches)
    fixture = self.new
    fixture.send(:create_fixture_with, teams, a_number_of_date_matches)
    fixture
  end

  protected

  def create_fixture_with(teams, a_number_of_date_matches)
    a_number_of_date_matches.times do |index|
      create_round index, teams
      teams.unshift teams.last
      teams.to_a.delete_at(teams.size - 1)
    end
  end

  def create_round(number_of_round, teams)
    middle = teams.size / 2
    l1 = teams[0..middle]
    l2 = teams[middle..teams.size]
    current_date_match = DateMatch.new
    date_matches << current_date_match

    l1.size.times do |index|
      if number_of_round % 2 == 1
        local = l1[index]
        visitor = l2[index]
      else
        local = l2[index]
        visitor = l1[index]
      end

      current_date_match.add_match(Match.new(local: local, visitor: visitor))
    end
  end

end