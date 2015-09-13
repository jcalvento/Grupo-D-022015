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
    private Team teamEven;
    private User user;
    private ArrayList<Team> teams;
    private ArrayList<Match> matches;

    @Before
    public void setUp(){
        user = new User("TestUser");
        teamA = new Team("a", user);
        teamB = new Team("b", user);
        teamC = new Team("c", user);
        teamD = new Team("d", user);
        teamEven = new Team("evenTeam",user);
        teams = new ArrayList<Team>();
        teams.add(teamA);
        teams.add(teamB);
        teams.add(teamC);
        teams.add(teamD);
        matches = FixtureGenerator.createFixture(teams);
        //fixture = new FixtureGenerator(teams);
    }

    @Test
    public void itShouldCreateAListOfMatchesOnCreation(){

        assertFalse(matches.isEmpty());
    }

    @Test
    public void itShouldCreateTheCorrectNumberOfRoundsAcordingTheAmountOfTeams(){
        int amountOfTeams = matches.size();
        for(Match match : matches){
            assertTrue(match.getRound() <= (amountOfTeams / 2));
        }
    }

    @Test
    public void itShouldNotRepeatTheSameMatchTwice(){
        int matchesThatIncludeTeamAVSTeamB = 0;
        for(Match match : matches){
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
        for(Match match : matches){
            if(match.getLocal().equals(teamA)|| match.getVisitor().equals(teamA) &&
                    match.getRound()==round){
                teamARoundMatches++;
                round++;
            }
        }
        assertEquals(teamARoundMatches,3);

    }

    @Test
    public void GivenAnEvenAmountOfTeamsItShouldCreateAFixtureWithADecoyTeam(){

        teams.add(teamEven);
        ArrayList<Match> fixtureEven = FixtureGenerator.createFixture(teams);
        int decoyTeamRoundMatches = 0;
        int round = 1;
        for(Match match : fixtureEven){
            if(match.getLocal().getName().equals("DecoyTeam") ||
                    match.getVisitor().getName().equals("DecoyTeam") &&
                    match.getRound()==round){
                decoyTeamRoundMatches++;
                round++;
            }
        }
        assertEquals(decoyTeamRoundMatches, 5);
    }
}
