class GoalsCounter < ActiveRecord::Base

  belongs_to :player
  belongs_to :date_match
  validates_with PositionValidator, field: :position

  def initialize(attributes = nil, options = {})
    super attributes, options
    player.add_goals_in_date_match self
  end

  def was_scored_in?(a_date_match)
    date_match.equal? a_date_match
  end

  def points
    position_instance = Position.for position

    position_instance.points_for_goals_amount number_of_goals
  end
end