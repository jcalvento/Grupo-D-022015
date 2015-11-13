class Match < ActiveRecord::Base

  belongs_to :date_match
  belongs_to :local, class_name: 'Team'
  belongs_to :visitor, class_name: 'Team'

  def points_of(a_team)
    points = a_team.points_made_in(date_match)
    rival = rival_of(a_team)
    rival_points = rival.points_made_in(date_match)

    if points > rival_points
      3
    else
      points.equal?(rival_points) ? 1 : 0
    end
  end

  def rival_of(a_team)
    [local, visitor].detect { |team| !team.equal? a_team }
  end

  def as_json(options = nil)
    json = super options
    json[:local] = local
    json[:visitor] = visitor
    json
  end
end