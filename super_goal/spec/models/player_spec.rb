require 'spec_helper'

describe Player do

  let(:player) { build :player }

  it 'should update his name' do
    player.name = 'Changed name'

    expect(player.name).to eq 'Changed name'
  end

  it 'should update his position' do
    player.position = Position.goalkeeper.name

    expect(player.position).to eq Position.goalkeeper
  end

  it 'should update his team' do
    player.team = 'Edited Team'

    expect(player.team).to eq 'Edited Team'
  end

  describe 'validations' do
    it 'should allow only valid positions' do
      %w(Forward forward Midfield midfield Defender defender Goalkeeper goalkeeper).each {
          |position| expect(player).to allow_value(position).for(:position)
      }
    end

    it 'should be invalid when the position is invalid' do
      player.position = 'Invalid Position'

      expect(player.valid?).to be_falsey
    end
  end

end