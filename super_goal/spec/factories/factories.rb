FactoryGirl.define do
  factory :player do
    name 'Johnny Bravo'
    team 'Test Team'
  end

  factory :forward_player, parent: :player do
    position Position.forward
  end

  factory :midfield_player, parent: :player do
    position Position.midfield
  end

  factory :defender_player, parent: :player do
    position Position.defender
  end

  factory :goalkeeper_player, parent: :player do
    position Position.goalkeeper
  end

  factory :team do
    name 'Test Team'
    logo 'Test Team Logo'
  end

  factory :tournament do
    name 'Test Tournament'
    max_amount_of_teams 6
    application_deadline_date Date.today + 7.days
  end

  factory :match do
    association :local, factory: :team, name: 'Local Team', strategy: :build
    association :visitor, factory: :team, name: 'Visitor Team', strategy: :build
  end

end