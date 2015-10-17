require 'spec_helper'

describe 'Position' do

  describe 'Forward' do
    it 'should make one point when scoring' do
      expect(Position.forward.points_per_goal).to eq 1
    end
  end

  describe 'Midfield' do
    it 'should make one point when scoring' do
      expect(Position.midfield.points_per_goal).to eq 1
    end
  end

  describe 'Defender' do
    it 'should make three points when scoring' do
      expect(Position.defender.points_per_goal).to eq 3
    end
  end

  describe 'Goalkeeper' do
    it "goals doesn't count"  do
      expect(Position.goalkeeper.points_per_goal).to eq 0
    end
  end
end