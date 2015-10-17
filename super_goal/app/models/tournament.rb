class Tournament

  attr_accessor :name, :max_amount_of_teams, :application_deadline_date

  def initialize(a_name='', max_amount_of_teams=0, application_deadline_date=nil)
    @name = a_name
    @max_amount_of_teams = max_amount_of_teams
    @application_deadline_date = application_deadline_date
    @teams = []
  end

  def add_team(a_team)
    validate_i_can_add_a_new_team

    @teams << a_team
  end

  def has_team?(a_team)
    @teams.include? a_team
  end

  protected

  def validate_i_can_add_a_new_team
    validate_application_deadline_has_not_expired
    validate_there_is_room_for_a_new_team
  end

  def validate_application_deadline_has_not_expired
    raise "You can't add more teams, the application deadline date has expired" if application_deadline_date < Date.today
  end

  def validate_there_is_room_for_a_new_team
    raise "You can't add more teams, the teams limit is exceeded" if @teams.size.equal? max_amount_of_teams
  end
end