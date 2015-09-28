package ar.edu.unq.model;


import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fixture")
public class Fixture {

    private final Integer dateMatchesQuantity;
    private List<DateMatch> dateMatches;

    public Fixture(List<Team> teams, Integer dateMatchesQuantity) {
        this.dateMatchesQuantity = dateMatchesQuantity;
        dateMatches = new ArrayList<>();
        createFixture(teams);
    }

    private void createFixture(List<Team> teams) {
        for (int i = 0; i < dateMatchesQuantity; i++) {
            createOneRound(i, teams);
            // Move last item to first
            teams.add(1, teams.get(teams.size() - 1));
            teams.remove(teams.size() - 1);
        }

    }

    private void createOneRound(int round, List<Team> teams) {
        int middle = teams.size() / 2;
        List<Team> l1 = teams.subList(0, middle);
        List<Team> l2 = teams.subList(middle, teams.size());
        DateMatch currentDateMatch = new DateMatch(round);
        dateMatches.add(currentDateMatch);

        for (int index = 0; index < l1.size(); index++) {
            Team local;
            Team visitor;
            if (round % 2 == 1) {
                local = l1.get(index);
                visitor = l2.get(index);
            } else {
                local = l2.get(index);
                visitor = l1.get(index);
            }

            currentDateMatch.addMatch(new Match(local, visitor));
        }
    }

    @ManyToMany
    public List<DateMatch> getDateMatches() {
        return dateMatches;
    }
}
