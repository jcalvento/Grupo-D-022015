package ar.edu.unq.model;

import ar.edu.unq.model.position.Position;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DateMatchTest {
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
