class GoalsCounter

  attr_accessor :player, :position, :date_match, :number_of_goals

  def initialize(a_player, a_position, a_date_match, a_number_of_goals)
    @player = a_player
    @position = a_position
    @date_match = a_date_match
    @number_of_goals = a_number_of_goals

    player.add_goals_in_date_match self
  end

  def was_scored_in?(a_date_match)
    date_match.equal? a_date_match
  end

  def points
    position.points_for_goals_amount number_of_goals
  end
end