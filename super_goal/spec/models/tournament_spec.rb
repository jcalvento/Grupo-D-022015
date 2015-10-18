require 'spec_helper'

describe 'Tournament' do

  describe 'adding a team' do
    it 'should add a team' do
      team = build :team
      tournament = build :tournament

      tournament.add_team team

      expect(tournament.has_team? team).to be_truthy
    end

    it 'should fail when adding a team but the limit is exceeded' do
      team = build :team
      tournament = build :tournament, max_amount_of_teams: 0

      expect{
        tournament.add_team team
      }.to raise_exception "You can't add more teams, the teams limit is exceeded"
    end

    it 'should fail when adding a team after the application deadline date' do
      team = build :team
      tournament = build :tournament, application_deadline: Date.yesterday - 7.days

      expect{
        tournament.add_team team
      }.to raise_exception "You can't add more teams, the application deadline date has expired"
    end
  end

end