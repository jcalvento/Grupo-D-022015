package ar.edu.unq.model;

public class Forward extends Position {
    @Override
    public Integer getPointsPerGoal() {
        return 1;
    }

    @Override
    public Integer getMaxNumberOfPlayersInATeam() {
        return 3;
    }
}
