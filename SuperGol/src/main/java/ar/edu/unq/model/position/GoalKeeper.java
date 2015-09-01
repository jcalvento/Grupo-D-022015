package ar.edu.unq.model.position;

public class GoalKeeper extends Position {

    @Override
    public Integer getPointsPerGoal() {
        return 0;
    }

    @Override
    public Integer getMaxNumberOfPlayersInATeam() {
        return 1;
    }
}
