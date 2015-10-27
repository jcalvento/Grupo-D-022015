require 'rspec'

describe 'GoalsCounter' do

  describe 'validations' do
    let(:goals_counter) { GoalsCounter.new({player: build(:player)}) }

    it 'should allow only valid positions' do
      %w(Forward forward Midfield midfield Defender defender Goalkeeper goalkeeper).each {
          |position| expect(goals_counter).to allow_value(position).for(:position)
      }
    end

    it 'should be invalid when the position is invalid' do
      goals_counter.position = 'Invalid Position'

      expect(goals_counter.valid?).to be_falsey
    end
  end

end