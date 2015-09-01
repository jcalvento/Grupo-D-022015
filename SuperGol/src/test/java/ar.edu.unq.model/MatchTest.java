package ar.edu.unq.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class MatchTest {

    Match match;
    Team local, visitor;
    Player forward;

    public void makeMatchWithTeams() throws Exception {
        local = new Team("Local", new User("Johnny Bravo"));
        visitor = new Team("Visitor", new User("Bugs Bunny"));
        forward = new Player("Palermo", Position.forward());
        local.addPlayer(forward);
        match = new Match(1, local, visitor);
    }

    @Before
    public void setUp() throws Exception {
        makeMatchWithTeams();
    }

    @Test
    public void itShouldAddOneGoalOfAForwardToTheLocalTeam() throws Exception {
        match.addGoal(local, forward);

        assertTrue(match.pointsOf(local).equals(1));
    }
}
