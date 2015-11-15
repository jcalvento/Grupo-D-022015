require 'spec_helper'

describe 'Fixture' do

  let(:teams) {
    [
        (build :team, id: 1, name: 'Team 1'),
        (build :team, id: 2, name: 'Team 2'),
        (build :team, id: 3, name: 'Team 3'),
        (build :team, id: 4, name: 'Team 4')

    ]
  }

  it 'should create as much date matches as requested' do
    fixture = Fixture.for(teams, 5)

    expect(fixture.date_matches.size).to eq 5
  end

  it 'should creat all matches with a local and a visitor team' do
    fixture = Fixture.for(teams,4)

    fixture.date_matches.each { |date_match| date_match.matches.each { |match|
      expect(match.local).not_to be_nil
      expect(match.visitor).not_to be_nil }}
  end
end