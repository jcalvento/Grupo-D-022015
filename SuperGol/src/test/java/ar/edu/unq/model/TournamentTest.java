package ar.edu.unq.model;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.cglib.core.Local;

import static org.junit.Assert.*;


import java.time.LocalDate;
import java.util.GregorianCalendar;


public class TournamentTest {

    private Team teamA;
    private Team teamB;
    private Team teamC;
    private Team teamD;
    private Tournament tournament;

    @Before
    public void setUp() {
        User user = TestObjectsFactory.getUser();
        teamA = TestObjectsFactory.getTeamFor(user);
        teamB = TestObjectsFactory.getTeamFor(user);
        teamC = TestObjectsFactory.getTeamFor(user);
        teamD = TestObjectsFactory.getTeamFor(user);
        tournament = new Tournament("tournamentTest", 2, 3, LocalDate.of(2016, 8, 31), user);
    }

    @Test
    public void itShouldNotBeAbleToAddLastTeamBecauseOfTheMaxLimit() throws Exception {
        tournament.addTeam(teamA);
        tournament.addTeam(teamB);
        tournament.addTeam(teamC);

        try {
            tournament.addTeam(teamD);
        } catch (Exception e) {
            assertEquals(e.getMessage(),
                    "You can´t add more Teams");
        }

        assertFalse(tournament.getTeams().contains(teamD));

    }

    @Test
    public void itShouldNotBeAbleToAddAnyOfTheTeamsBecauseOfTheExpirationDate() throws Exception {
        tournament.setApplicationDeadline(LocalDate.of(2014, 7, 20));

        try {
            tournament.addTeam(teamA);
        } catch (Exception e) {
            assertEquals(e.getMessage(),
                    "You can´t add more Teams");
        }

        assertFalse(tournament.getTeams().contains(teamA));
        assertEquals(tournament.getTeams().size(), 0);
    }
}
