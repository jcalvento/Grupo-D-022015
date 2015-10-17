class Fixture

  attr_reader :date_matches

  def initialize(teams, a_number_of_date_matches)
    @date_matches = []
    @number_of_date_matches = a_number_of_date_matches
    create_fixture_with teams
  end

  protected

  def create_fixture_with(teams)
    @number_of_date_matches.times do |index|
      create_round index, teams
      teams.unshift teams.last
      teams.delete_at(teams.size - 1)
    end
  end

  def create_round(number_of_round, teams)
    middle = teams.size / 2
    l1 = teams[0..middle]
    l2 = teams[middle..teams.size]
    current_date_match = DateMatch.new
    @date_matches << current_date_match

    l1.size.times do |index|
      if number_of_round % 2 == 1
        local = l1[index]
        visitor = l2[index]
      else
        local = l2[index]
        visitor = l1[index]
      end

      current_date_match.add_match(Match.new(local, visitor))
    end
  end
  # int middle = teams.size() / 2;
  # List<Team> l1 = teams.subList(0, middle);
  # List<Team> l2 = teams.subList(middle, teams.size());
  # DateMatch currentDateMatch = new DateMatch(round);
  # dateMatches.add(currentDateMatch);
  #
  # for (int index = 0; index < l1.size(); index++) {
  #     Team local;
  # Team visitor;
  # if (round % 2 == 1) {
  #     local = l1.get(index);
  # visitor = l2.get(index);
  # } else {
  #     local = l2.get(index);
  # visitor = l1.get(index);
  # }
  #
  # currentDateMatch.addMatch(new Match(local, visitor));
  # }
end