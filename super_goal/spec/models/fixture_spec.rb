require 'spec_helper'

describe 'Fixture' do

  let(:teams) {
    [
        (build :team, name: 'Team 1'),
        (build :team, name: 'Team 2'),
        (build :team, name: 'Team 3'),
        (build :team, name: 'Team 4')
    ]
  }

  it 'should create as much date matches as requested' do
    fixture = Fixture.for(teams, 5)

    expect(fixture.date_matches.size).to eq 5
  end
end