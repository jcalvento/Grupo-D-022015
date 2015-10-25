require 'spec_helper'

describe 'DateMatch' do

  let(:match1) { build :match}
  let(:date_match) { DateMatch.new }

  before :each do
    date_match.add_match match1
  end

  it 'should add a match' do
    expect(date_match.has_match? match1).to be_truthy
  end

  it 'should set goals of the given player' do
    player = build :forward_player

    date_match.add_goals_of(player, Position.forward.name, 2)

    expect(player.points_made_in date_match).to eq 2
  end

end