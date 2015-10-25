FactoryGirl.define do
  factory :player do
    name 'Johnny Bravo'
    team 'Test Team'
    position 'Forward'
  end

  factory :forward_player, parent: :player do
    position Position.forward.name
  end

  factory :midfield_player, parent: :player do
    position Position.midfield.name
  end

  factory :defender_player, parent: :player do
    position Position.defender.name
  end

  factory :goalkeeper_player, parent: :player do
    position Position.goalkeeper.name
  end

  factory :team do
    name 'Test Team'
    logo 'Test Team Logo'
  end

  factory :tournament do
    name 'Test Tournament'
    max_amount_of_teams 6
    application_deadline Date.today + 7.days
  end

  factory :match do
    association :local, factory: :team, name: 'Local Team', strategy: :build
    association :visitor, factory: :team, name: 'Visitor Team', strategy: :build
  end

end