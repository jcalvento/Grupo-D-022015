package ar.edu.unq.model;

import ar.edu.unq.model.position.Position;

import java.util.ArrayList;
import java.util.List;

public class DateMatch {

    private List<Match> matches;
    private Integer number;

    public DateMatch(Integer anInteger) {
        number = anInteger;
        matches = new ArrayList<>();
    }

    public void addMatch(Match aMatch) {
        matches.add(aMatch);
        aMatch.setDateMatch(this);
    }

    public void addGoalsOf(Player aPlayer, Position playersPosition, Integer numberOfGoals) {
        new DateMatchGoalCounter(aPlayer, playersPosition, this, numberOfGoals);
    }

    public List<Match> getMatches() {
        return matches;
    }
}
