package ar.edu.unq.model;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


import java.util.GregorianCalendar;


public class TournamentTest {

    private Team teamA;
    private Team teamB;
    private Team teamC;
    private Team teamD;
    private User user;
    private Tournament tournament;
    private GregorianCalendar deadline;

    @Before
    public void setUp(){
        user = new User("TestUser");
        teamA = new Team("a", user);
        teamB = new Team("b", user);
        teamC = new Team("c", user);
        teamD = new Team("d", user);
        deadline = new GregorianCalendar(2015,8,31);
        tournament = new Tournament(2,3,deadline);
    }

    @Test
    public void itShouldNotBeAbleToAddLastTeamBecauseOfTheMaxLimit() throws Exception{

        tournament.addTeam(teamA);
        tournament.addTeam(teamB);
        tournament.addTeam(teamC);
        try {
            tournament.addTeam(teamD);
        } catch (Exception e) {
            assertEquals(e.getMessage(),
                    "You can´t add more Teams");
        }

        assertFalse(tournament.getTeamList().contains(teamD));

    }

    @Test
    public void itShouldNotBeAbleToAddAnyOfTheTeamsBecauseOfTheExpirationDate() throws Exception{

        tournament.setApplicationDeadline(2015, 7, 20);
        try {
            tournament.addTeam(teamA);
        } catch (Exception e) {
            assertEquals(e.getMessage(),
                    "You can´t add more Teams");
        }

        assertFalse(tournament.getTeamList().contains(teamA));
        assertEquals(tournament.getTeamList().size(), 0);
    }
}
