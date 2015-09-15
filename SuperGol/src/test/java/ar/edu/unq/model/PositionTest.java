package ar.edu.unq.model;

import ar.edu.unq.model.position.Position;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PositionTest {

    @Test
    public void thePointsResultingOfAGoalOfAForwardShouldBeOne() {
        assertEquals(Position.forward().getPointsPerGoal(), 1);
    }

    @Test
    public void thePointsResultingOfAGoalOfADefenderShouldBeThree() {
        assertEquals(Position.defender().getPointsPerGoal(), 3);
    }

    @Test
    public void thePointsResultingOfAGoalOfAMidFieldPlayerShouldBeOne() {
        assertEquals(Position.midfield().getPointsPerGoal(), 1);
    }

    @Test
    public void thePointsResultingOfAGoalOfTheGoalKeeperDoesNotCount() {
        assertEquals(Position.goalKeeper().getPointsPerGoal(), 0);
    }
}
