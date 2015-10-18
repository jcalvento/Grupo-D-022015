require 'spec_helper'

describe 'Team' do

  let(:team) { build :team }

  it 'should create a team with the given name' do
    expect(Team.new(name: 'Da team').name).to eq 'Da team'
  end

  it 'should create a team with the given name and logo' do
    team = Team.new(name: 'Da team', logo: 'logo image')

    expect(team.name).to eq 'Da team'
    expect(team.logo).to eq 'logo image'
  end

  describe 'adding a player' do
    it 'should add a forward player' do
      player = build :forward_player

      team.add_player player

      expect(team.has_player? player).to be_truthy
    end

    it 'should fail when adding a forward player and there are already three' do
      player = build :forward_player
      position = Position.forward
      add_players_with_position team, 3, position

      assert_it_fails_when_adding(player, position)
    end

    it 'should fail when adding a midfield player and there are already four' do
      player = build :midfield_player
      position = Position.midfield
      add_players_with_position team, 4, position

      assert_it_fails_when_adding(player, position)
    end

    it 'should fail when adding a defender player and there are already three' do
      player = build :defender_player
      position = Position.defender
      add_players_with_position team, 3, position

      assert_it_fails_when_adding(player, position)
    end

    it 'should fail when adding a goalkeeper and there is already one' do
      player = build :goalkeeper_player
      position = Position.goalkeeper
      add_players_with_position team, 1, position

      assert_it_fails_when_adding(player, position)
    end

    def add_players_with_position(team, number_of_players, position)
      number_of_players.times do |i|
        team.add_player Player.new name: "Player #{i}", position: position
      end
    end

    def assert_it_fails_when_adding(player, position)
      expect {
        team.add_player player
      }.to raise_exception "You must remove a #{position.name} before adding another one"
    end
  end

  describe 'assigning a captain' do
    it 'should assign a captain' do
      player = build :goalkeeper_player
      team.add_player player

      team.assign_captain player

      expect(team.captain).to eq player
    end

    it 'should reassign the captain when the team has already one' do
      goalkeeper = build :goalkeeper_player
      forward = build :forward_player
      team.add_player goalkeeper
      team.add_player forward
      team.assign_captain goalkeeper

      team.assign_captain forward

      expect(team.captain).to_not eq goalkeeper
      expect(team.captain).to eq forward
    end

    it "should fail when the player doesn't belong to the team" do
      player = build :goalkeeper_player

      expect{
        team.assign_captain player
      }.to raise_exception "Couldn't assign #{player.name} as captain since he doesn't belong to the team"
    end
  end

end