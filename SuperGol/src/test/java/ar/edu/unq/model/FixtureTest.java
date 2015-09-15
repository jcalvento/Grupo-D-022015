package ar.edu.unq.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FixtureTest {

    private List<Team> teams;

    @Before
    public void setUp() {
        Team teamA = TestObjectsFactory.getTeam();
        Team teamB = TestObjectsFactory.getTeam();
        Team teamC = TestObjectsFactory.getTeam();
        Team teamD = TestObjectsFactory.getTeam();
        teams = new ArrayList<>(Arrays.asList(teamA, teamB, teamC, teamD));
    }

    @Test
    public void itShouldCreateAsMuchDateMatchesAsRequested() {
        Fixture fixture = new Fixture(teams, 5);

        assertEquals(fixture.getDateMatches().size(), 5);
    }
}
