class Fixture < ActiveRecord::Base

  has_many :date_matches
  belongs_to :tournament

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
    a_number_of_date_matches.times do |index|
      create_round index, teams
      teams.unshift teams.last
      teams.to_a.delete_at(teams.size - 1)
    end
  end

  def create_round(number_of_round, teams)
    middle = teams.size / 2
    l1 = teams[0..(middle-1)]
    l2 = teams[middle..teams.size]
    current_date_match = DateMatch.new(:round => number_of_round+1)
    date_matches << current_date_match

    l1.size.times do |index|
      if number_of_round % 2 == 1
        local = l1[index]
        visitor = l2[index]
      else
        local = l2[index]
        visitor = l1[index]
      end
      if local!=nil || visitor!=nil
        match = Match.new(local: local, visitor: visitor)
        current_date_match.add_match(match)
      end
    end
  end

end