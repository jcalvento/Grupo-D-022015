package ar.edu.unq.model;

import ar.edu.unq.model.position.Position;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DateMatchTest {
    Match match;
    Team local, visitor;
    Player forward;
    DateMatch dateMatch;

    public void makeMatchWithTeams() throws Exception {
        local = TestObjectsFactory.getTeam();
        visitor = TestObjectsFactory.getTeam();
        forward = TestObjectsFactory.getForward();
        local.addPlayer(forward);
        match = new Match(local, visitor);
    }

    @Before
    public void setUp() throws Exception {
        makeMatchWithTeams();
        dateMatch = new DateMatch(1);
    }

    @Test
    public void itShouldAddAMatchToTheGivenDateMatch() {
        dateMatch.addMatch(match);

        assertTrue(dateMatch.getMatches().contains(match));
    }

    @Test
    public void itShouldSetGoalsOfTheGivenPlayerInTheGivenDateMatch() {
        dateMatch.addMatch(match);

        dateMatch.addGoalsOf(forward, Position.forward(), 2);

        assertEquals(forward.pointsMadeIn(dateMatch), 2);
    }
}
