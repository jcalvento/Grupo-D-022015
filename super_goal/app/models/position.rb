class Position

  def self.forward
    find_position_or_create Forward
  end

  def self.goalkeeper
    find_position_or_create GoalKeeper
  end

  def self.defender
    find_position_or_create Defender
  end

  def self.midfield
    find_position_or_create Midfield
  end

  def self.for(a_position_name)
    subclass = all_subclasses.detect { |subclass|
      subclass_name = subclass.name
      subclass_name.slice!('Position::')
      subclass_name.downcase.eql? a_position_name.downcase
    }

    raise "Position #{a_position_name} doesn't exist." unless subclass

    find_position_or_create subclass
  end

  def points_per_goal
    self.subclass_responsibility
  end

  def max_number_of_players_per_team
    self.subclass_responsibility
  end

  def name
    self.subclass_responsibility
  end

  def points_for_goals_amount(a_number_of_goals)
    points_per_goal * a_number_of_goals
  end

  protected

  def self.find_position_or_create(a_position)
    descendant = self.all_instances.detect { |descendant| descendant.instance_of? a_position }
    descendant || a_position.new
  end

  def self.all_instances
    ObjectSpace.each_object(self).to_a
  end

  def self.all_subclasses
    ObjectSpace.each_object(Class).select { |klass| klass < self }
  end

  class Forward < Position
    def points_per_goal
      1
    end

    def max_number_of_players_per_team
      3
    end

    def name
      'Forward'
    end
  end

  class GoalKeeper < Position
    def points_per_goal
      0
    end

    def max_number_of_players_per_team
      1
    end

    def points_for_goals_amount(a_number_of_goals)
      a_number_of_goals.equal?(0) ? 2 : points_per_goal
    end

    def name
      'Goalkeeper'
    end
  end

  class Defender < Position
    def points_per_goal
      3
    end

    def max_number_of_players_per_team
      3
    end

    def name
      'Defender'
    end
  end

  class Midfield < Position
    def points_per_goal
      1
    end

    def max_number_of_players_per_team
      4
    end

    def name
      'Midfield'
    end
  end
end