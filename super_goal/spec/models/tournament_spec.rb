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

  #This tests need persistence
  describe 'ranking' do

    let(:tournament) { build :tournament }
    let(:player) { build :player }

    before :each do
      team1 = create :team, name: 'Team1'
      team2 = create :team, name: 'Team2'
      team3 = create :team, name: 'Team3'
      team4 = create :team, name: 'Team4'
      team1.add_player player
      [team1, team2, team3, team4].map { |team| tournament.add_team team }
      tournament.fixture = Fixture.for tournament.teams, 2
      tournament.save!
    end

    it 'should initialize the tournament with all the teams with zero points' do
      tournament.ranking.map{ |ranking_position|
        expect(ranking_position[1]).to eq 0
      }
    end

    it 'should update ranking after adding a goal and end that date match' do
      date_match = tournament.fixture.date_matches.first
      date_match.add_goals_of player, Position.forward.name, 2
      date_match.ended = true

      tournament.update_ranking

      ranking = tournament.ranking
      expect(ranking.count { |rank_position| rank_position[1] == 3}).to eq 1
      expect(ranking.count { |rank_position| rank_position[1] == 0}).to eq 1
      expect(ranking.count { |rank_position| rank_position[1] == 1}).to eq 2
    end

    it 'should not take account of the still opened date matches' do
      date_match = tournament.fixture.date_matches.first
      date_match.add_goals_of player, Position.forward.name, 2

      tournament.update_ranking

      tournament.ranking.map{ |ranking_position|
        expect(ranking_position[1]).to eq 0
      }
    end
  end
end