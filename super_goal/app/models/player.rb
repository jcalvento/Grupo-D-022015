class Player < ActiveRecord::Base

  has_many :goals_counters
  has_and_belongs_to_many :teams
  alias_attribute :goals, :goals_counters
  validates_with PositionValidator, field: :position

  def has_position?(a_position)
    position.eql? a_position
  end

  def points_made_in(a_date_match)
    goals.select { |goal| goal.was_scored_in? a_date_match }
          .sum { |goal| goal.points }
  end

  def add_goals_in_date_match(a_goals_counter)
    goals << a_goals_counter
  end

  def as_json(options = nil)
    json = super options
    json[:position] = position.name
    json
  end

  def position
    Position.for self[:position]
  end

end