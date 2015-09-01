package ar.edu.unq.model;

import ar.edu.unq.model.position.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class MatchTest {

    Match match;
    Team local, visitor;
    Player forward, defender, goalkeeper, midfield, rivalDefender;

    public void makeMatchWithTeams() throws Exception {
        local = new Team("Local", new User("Johnny Bravo"));
        visitor = new Team("Visitor", new User("Bugs Bunny"));
        forward = new Player("Forward", Position.forward());
        defender = new Player("Defender", Position.defender());
        rivalDefender = new Player("DefenderR", Position.defender());
        goalkeeper = new Player("GK", Position.goalKeeper());
        midfield = new Player("Midfield", Position.midfield());
        local.addPlayer(forward);
        local.addPlayer(defender);
        local.addPlayer(goalkeeper);
        local.addPlayer(midfield);
        visitor.addPlayer(rivalDefender);
        match = new Match(1, local, visitor);
    }

    @Before
    public void setUp() throws Exception {
        makeMatchWithTeams();
    }

    @Test
    public void itShouldAddOneGoalOfAForwardToTheLocalTeamAndEqualOnePoint() throws Exception {
        match.addGoal(visitor, rivalDefender);
        match.addGoal(local, forward);

        assertTrue(match.pointsOf(local).equals(1));
    }

    @Test
    public void itShouldAddOneGoalOfADefenderToTheLocalTeamAndEqualOnePoint() throws Exception {
        match.addGoal(visitor, rivalDefender);
        match.addGoal(local, midfield);

        assertTrue(match.pointsOf(local).equals(1));
    }

    @Test
    public void itShouldAddOneGoalOfADefenderToTheLocalTeamAndEqualThreePoints() throws Exception {
        match.addGoal(visitor, rivalDefender);
        match.addGoal(local, defender);

        assertTrue(match.pointsOf(local).equals(3));
    }

    @Test
    public void itShouldHaveTwoPointsWhenTheGoalKeeperDidNotReceiveAnyGoals() throws Exception {
        assertTrue(match.pointsOf(local).equals(2));
    }

    @Test
    public void itShouldHaveNoPointsForTheGoalKeeperWhenTheRivalScoredAtLeastOneGoal() throws Exception {
        match.addGoal(visitor, rivalDefender);

        assertFalse(match.pointsOf(local).equals(2));
    }
}
