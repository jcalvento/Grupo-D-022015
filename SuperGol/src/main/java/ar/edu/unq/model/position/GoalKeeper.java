package ar.edu.unq.model.position;

public class GoalKeeper extends Position {

    @Override
    public int getPointsPerGoal() {
        return 0;
    }

    @Override
    public Integer getMaxNumberOfPlayersInATeam() {
        return 1;
    }

    public Integer pointsWhenScored(Integer aNumberOfGoals) {
        return aNumberOfGoals.equals(0) ? 2 : getPointsPerGoal();
    }
}
