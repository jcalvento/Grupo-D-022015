class Tournament < ActiveRecord::Base

  has_and_belongs_to_many :teams
  has_one :fixture
  serialize :ranking, Hash
  before_create :create_ranking

  def add_team(a_team)
    validate_i_can_add_a_new_team

    teams << a_team
  end

  def has_team?(a_team)
    teams.include? a_team
  end

  def as_json(options = nil)
    json = super options
    json[:teams] = teams
    json[:fixture] = fixture
    json
  end

  def players
    teams.collect(&:players).flatten.uniq
  end

  def update_ranking
    fixture.ended_date_matches.collect(&:matches).flatten.map { |match|
      local_team = match.local
      visitor_team = match.visitor
      self[:ranking][local_team.id] = self[:ranking][local_team.id] + match.points_of(local_team)
      self[:ranking][visitor_team.id] = self[:ranking][visitor_team.id] + match.points_of(visitor_team)
    }
  end

  def ranking
    rank = {}
    self[:ranking].map { |key, value| rank[Team.find(key).name] = value }
    rank.sort_by{ |name, points| points }.reverse
  end

  protected

  def create_ranking
    rank = {}
    teams.map { |team| rank[team.id] = 0 }
    self.ranking = rank
  end

  def validate_i_can_add_a_new_team
    validate_application_deadline_has_not_expired
    validate_there_is_room_for_a_new_team
  end

  def validate_application_deadline_has_not_expired
    raise "You can't add more teams, the application deadline date has expired" if application_deadline < Date.today
  end

  def validate_there_is_room_for_a_new_team
    raise "You can't add more teams, the teams limit is exceeded" if teams.size.equal? max_amount_of_teams
  end
end