package ar.edu.unq.model.position;

public class Forward extends Position {
    @Override
    public int getPointsPerGoal() {
        return 1;
    }

    @Override
    public Integer getMaxNumberOfPlayersInATeam() {
        return 3;
    }
}
