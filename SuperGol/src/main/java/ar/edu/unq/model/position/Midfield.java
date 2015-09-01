package ar.edu.unq.model.position;

public class Midfield extends Position {

    @Override
    public Integer getPointsPerGoal() {
        return 1;
    }

    @Override
    public Integer getMaxNumberOfPlayersInATeam() {
        return 4;
    }
}
