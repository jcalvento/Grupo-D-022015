class GoalsCounter < ActiveRecord::Base

  attr_accessor :player, :position, :date_match, :number_of_goals
  belongs_to :player
  has_one :position
  belongs_to :date_match

  def initialize(attributes = nil, options = {})
    super attributes, options
    player.add_goals_in_date_match self
  end

  def was_scored_in?(a_date_match)
    date_match.equal? a_date_match
  end

  def points
    position.points_for_goals_amount number_of_goals
  end
end