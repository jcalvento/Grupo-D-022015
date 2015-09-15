package ar.edu.unq.model;

import ar.edu.unq.model.position.Position;

public class DateMatchGoalCounter {

    private final Player player;
    private final DateMatch dateMatch;
    private final Position playersPosition;
    private final Integer numberOfGoals;

    public DateMatchGoalCounter(Player aPlayer, Position playersPosition, DateMatch aDateMatch, Integer numberOfGoals) {
        player = aPlayer;
        dateMatch = aDateMatch;
        this.playersPosition = playersPosition;
        this.numberOfGoals = numberOfGoals;
        player.addGoalsInDateMatch(this);
    }

    public Integer getPoints() {
        return playersPosition.pointsWhenScored(numberOfGoals);
    }

    public boolean wasScoredIn(DateMatch aDateMatch) {
        return dateMatch.equals(aDateMatch);
    }
}
