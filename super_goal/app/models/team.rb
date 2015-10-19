class Team < ActiveRecord::Base

  attr_reader :captain
  has_many :players
  has_one :captain, class_name: 'Player'

  def add_player(a_player)
    validate_there_is_room_for a_player

    players << a_player
  end

  def has_player?(a_player)
    players.include? a_player
  end

  def assign_captain(a_player)
    validate_player_is_in_the_team a_player

    @captain = a_player
  end

  def points_made_in(a_date_match)
    players.collect { |player| player.points_made_in a_date_match }
            .sum
  end

  protected

  def validate_player_is_in_the_team(a_player)
    raise "Couldn't assign #{a_player.name} as captain since he doesn't belong to the team" unless players.include? a_player
  end

  def validate_there_is_room_for(a_player)
    position = a_player.position
    if players_with_position(position).size.equal?(position.max_number_of_players_per_team)
      raise "You must remove a #{position.name} before adding another one"
    end
  end

  def players_with_position(a_position)
    players.select { |player| player.has_position? a_position }
  end
end