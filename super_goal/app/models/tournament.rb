class Tournament < ActiveRecord::Base

  has_many :teams
  has_one :fixture

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
    json
  end

  protected

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