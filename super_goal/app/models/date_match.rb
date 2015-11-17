class DateMatch < ActiveRecord::Base

  has_many :matches
  belongs_to :fixture

  def add_match(a_match)
    matches << a_match
    a_match.date_match = self
  end

  def has_match?(a_match)
    matches.include? a_match
  end

  def add_goals_of(a_player, a_position, a_number_of_goals)
    GoalsCounter.new(player: a_player, position: a_position, date_match: self, number_of_goals: a_number_of_goals)
  end

  def as_json(options = nil)
    json = super options
    json[:matches] = matches
    json
  end

end