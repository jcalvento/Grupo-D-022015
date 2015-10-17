class DateMatch

  def initialize
    @matches = []
  end

  def add_match(a_match)
    @matches << a_match
    a_match.date_match = self
  end

  def has_match?(a_match)
    @matches.include? a_match
  end

  def add_goals_of(a_player, a_position, a_number_of_goals)
    GoalsCounter.new(a_player, a_position, self, a_number_of_goals)
  end

end