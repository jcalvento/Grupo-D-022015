require 'spec_helper'

describe 'Player' do

  let(:player) { build :player }

  it 'should update his name' do
    player.name = 'Changed name'

    expect(player.name).to eq 'Changed name'
  end

  it 'should update his position' do
    player.position = Position.goalkeeper

    expect(player.position).to eq Position.goalkeeper
  end

  it 'should update his team' do
    player.team = 'Edited Team'

    expect(player.team).to eq 'Edited Team'
  end
end