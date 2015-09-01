package ar.edu.unq.model;

public class Defender extends Position {

    @Override
    public Integer getPointsPerGoal() {
        return 3;
    }

    @Override
    public Integer getMaxNumberOfPlayersInATeam() {
        return 3;
    }
}
