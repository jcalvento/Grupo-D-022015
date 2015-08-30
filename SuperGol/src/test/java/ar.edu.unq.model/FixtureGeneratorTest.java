package ar.edu.unq.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FixtureGeneratorTest {

    private FixtureGenerator fixture;
    private Team teamA;
    private Team teamB;
    private Team teamC;
    private Team teamD;
    private User user;
    private ArrayList<Team> teams;

    @Before
    public void setUp(){
        user = new User("TestUser");
        teamA = new Team("a", user);
        teamB = new Team("b", user);
        teamC = new Team("c", user);
        teamD = new Team("d", user);
        teams = new ArrayList<Team>();
        teams.add(teamA);
        teams.add(teamB);
        teams.add(teamC);
        teams.add(teamD);
        fixture = new FixtureGenerator(teams);
    }

    @Test
    public void itShouldCreateAListOfMatchesOnCreation(){
        assertTrue(!fixture.getMatches().isEmpty());
        //for(Match match : fixture.getMatches()){
        //    System.out.println(match.getMatchFormat());
        //} visual test ;)

    }

    @Test
    public void itShouldCreateTheCorrectNumberOfRoundsAcordingTheAmountOfTeams(){
        int amountOfTeams = fixture.getMatches().size();
        for(Match match : fixture.getMatches()){
            assertTrue(match.getRound() <= (amountOfTeams / 2));
        }
    }

    @Test
    public void itShouldNotRepeatTheSameMatchTwice(){
        int matchesThatIncludeTeamAVSTeamB = 0;
        for(Match match : fixture.getMatches()){
            if(match.getLocal().equals(teamA)&&match.getVisitor().equals(teamB)||
                    match.getLocal().equals(teamB)&&match.getVisitor().equals(teamA)){
                matchesThatIncludeTeamAVSTeamB++;
            }
        }
        assertEquals(matchesThatIncludeTeamAVSTeamB, 1);
    }

    @Test
    public void aTeamShouldBeIncludeInAllTheRounds(){
        int teamARoundMatches = 0;
        int round = 1;
        for(Match match : fixture.getMatches()){
            if(match.getLocal().equals(teamA)||match.getVisitor().equals(teamA)&&
                match.getRound()==round){
                teamARoundMatches++;
                round++;
            }
        }
        assertEquals(teamARoundMatches,3);

    }
}
