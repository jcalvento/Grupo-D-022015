class Match

  attr_accessor :local, :visitor

  def initialize(local_team=nil, visitor_team=nil)
    @local = local_team
    @visitor = visitor_team
  end

  def points_of(a_team)
    points = a_team.points_made_in(@date_match)
    rival = rival_of(a_team)
    rival_points = rival.points_made_in(@date_match)

    if points > rival_points
      3
    else
      points.equal?(rival_points) ? 1 : 0
    end
  end

  def rival_of(a_team)
    [local, visitor].detect { |team| !team.equal? a_team }
  end

  def date_match=(a_date_match)
    @date_match = a_date_match
  end
end