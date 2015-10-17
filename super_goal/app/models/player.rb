class Player

  attr_accessor :name, :position, :team

  def initialize(name='', position=nil, team='')
    @name = name
    @position = position
    @team = team
    @goals = []
  end

  def has_position?(a_position)
    position.eql? a_position
  end

  def points_made_in(a_date_match)
    @goals.select { |goal| goal.was_scored_in? a_date_match }
          .sum { |goal| goal.points }
  end

  def add_goals_in_date_match(a_goals_counter)
    @goals << a_goals_counter
  end

end