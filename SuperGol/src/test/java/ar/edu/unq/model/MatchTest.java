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
    Player forward, defender, goalkeeper, midfield, rivalDefender;
    DateMatch dateMatch;

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
