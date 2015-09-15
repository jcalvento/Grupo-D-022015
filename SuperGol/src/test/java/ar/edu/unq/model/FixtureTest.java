package ar.edu.unq.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FixtureTest {

    private Fixture fixture;
    private Team teamA;
    private Team teamB;
    private Team teamC;
    private Team teamD;
    private Team teamEven;
    private ArrayList<Team> teams;

    @Before
    public void setUp() {
        User user = new User("TestUser");
        teamA = new Team("a", user);
        teamB = new Team("b", user);
        teamC = new Team("c", user);
        teamD = new Team("d", user);
        teamEven = new Team("evenTeam", user);
        teams = new ArrayList<>();
        teams.add(teamA);
        teams.add(teamB);
        teams.add(teamC);
        teams.add(teamD);
        fixture = new Fixture(teams, 4);
    }

    @Test
    public void itShouldCreateAsMuchDateMatchesAsRequested() {
        fixture = new Fixture(teams, 5);

        assertEquals(fixture.getDateMatches().size(), 5);
    }
}
