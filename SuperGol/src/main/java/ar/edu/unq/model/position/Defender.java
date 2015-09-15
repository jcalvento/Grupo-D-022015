package ar.edu.unq.model.position;

public class Defender extends Position {

    @Override
    public int getPointsPerGoal() {
        return 3;
    }

    @Override
    public Integer getMaxNumberOfPlayersInATeam() {
        return 3;
    }
}
