package ar.edu.unq.model;

import ar.edu.unq.model.position.Position;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class MatchTest {

    Match match;
    Team local, visitor;
    Player forward, goalkeeper;
    DateMatch dateMatch;

    public void makeMatchWithTeams() throws Exception {
        local = TestObjectsFactory.getTeam();
        visitor = TestObjectsFactory.getTeam();
        forward = TestObjectsFactory.getForward();
        goalkeeper = TestObjectsFactory.getGoalKeeper();
        local.addPlayer(forward);
        local.addPlayer(goalkeeper);
        dateMatch = new DateMatch(1);
        match = new Match(local, visitor);
        dateMatch.addMatch(match);
    }

    @Before
    public void setUp() throws Exception {
        makeMatchWithTeams();
    }

    @Test
    public void itShouldCreateAMatchWithTheGivenTeamsAsLocalAndVisitorRespectively() {
        match = new Match(local, visitor);

        assertEquals(match.getLocal(), local);
        assertEquals(match.getVisitor(), visitor);
    }

    @Test
    public void theWinnerShouldHaveThreePointsAndTheLoserZero() throws Exception {
        dateMatch.addGoalsOf(forward, Position.forward(), 2);

        assertTrue(match.pointsOf(local).equals(3));
        assertTrue(match.pointsOf(visitor).equals(0));
    }

    @Test
    public void whenTheMatchIsDeuceEachTeamShouldGetOnePoint() throws Exception {
        assertTrue(match.pointsOf(local).equals(match.pointsOf(visitor)));
        assertTrue(match.pointsOf(visitor).equals(1));
    }

    @Test
    public void ifNoneOfTheTeamsScoresButTheLocalGoalKeeperReceivesNoGoalsThenTheLocalTeamWins() {
        dateMatch.addGoalsOf(goalkeeper, Position.goalKeeper(), 0);

        assertTrue(match.pointsOf(local).equals(3));
        assertTrue(match.pointsOf(visitor).equals(0));
    }

}
