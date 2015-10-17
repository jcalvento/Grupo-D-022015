require 'spec_helper'

describe 'Match' do

  let(:local_team)  { build :team, name: 'Local Team' }
  let(:visitor_team)  { build :team, name: 'Visitor Team' }
  let(:match1) { build :match, local: local_team, visitor: visitor_team }
  let(:date_match) { DateMatch.new }

  before :each do
    date_match.add_match(match1)
  end

  it 'should create a match with the given teams as local and visitor' do
    local = build :team, name: 'Local Team'
    visitor = build :team, name: 'Visitor Team'

    match = Match.new local, visitor

    expect(match.local).to eq local
    expect(match.visitor).to eq visitor
  end

  describe 'match result' do
    it 'the winner should have three points and the loser zero' do
      player = build :forward_player
      local_team.add_player player

      date_match.add_goals_of(player, Position.forward, 2)

      expect(match1.points_of local_team).to eq 3
      expect(match1.points_of visitor_team).to eq 0
    end

    it 'each team should have one point when they are deuce' do
      expect(match1.points_of local_team).to eq 1
      expect(match1.points_of visitor_team).to eq 1
    end

    it "if non of them scored any point but the local goalkeeper didn't receive any goal then the local team wins" do
      player = build :goalkeeper_player
      local_team.add_player player

      date_match.add_goals_of(player, Position.goalkeeper, 0)

      expect(match1.points_of local_team).to eq 3
      expect(match1.points_of visitor_team).to eq 0
    end
  end

end