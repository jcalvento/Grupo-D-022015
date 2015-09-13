package ar.edu.unq.model;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


import java.util.ArrayList;
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
    public void setUp() throws Exception {
        user = new User("TestUser");
        teamA = ModelsFactory.creatBasicTeam("a",user);
        teamB = ModelsFactory.creatBasicTeam("b",user);
        teamC = ModelsFactory.creatBasicTeam("c",user);
        teamD = ModelsFactory.creatBasicTeam("d",user);
        deadline = new GregorianCalendar(2015,8,31);
        tournament = new Tournament("tournamentTest",2,3,deadline,user);
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

        assertFalse(tournament.getTeams().contains(teamD));

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

        assertFalse(tournament.getTeams().contains(teamA));
        assertEquals(tournament.getTeams().size(), 0);
    }

    @Test
    public void itShouldSetTheResultsOnlyForTheMachThatBelongToTheRound() throws Exception {
        tournament = new Tournament("tournamentTest",2,4,deadline,user);
        tournament.setApplicationDeadline(2016,7,20);
        tournament.addTeam(teamA);
        tournament.addTeam(teamB);
        tournament.addTeam(teamC);
        tournament.addTeam(teamD);
        tournament.generateFixture();
        ArrayList<RealTournamentGoal> scoredGoals = ModelsFactory.createTestGoalsPerRoundData();

        //cargo los goles para la fecha 1, para que tenga el total de goles metidos por equipo
        for(Match match : tournament.getMatches()){
            if(match.getRound()==1){
                for(RealTournamentGoal data : scoredGoals){
                    for(Integer i=0; i<data.getScoredGoals();i++){
                        match.addGoal(match.getLocal(), match.getLocal().findPlayerWithName(data.getPlayersName()));
                        match.addGoal(match.getVisitor(), match.getVisitor().findPlayerWithName(data.getPlayersName()));
                    }
                }
            }
        }

        //calculo los resultados de todos los partidos de la fecha 1 (seteados para que den empates)
        tournament.setResultsOfTheRound(1);


        //me aseguro que todos los partidos de la fecha 1 tengan un resultado que no sea 0-0
        //imposible si se jugo un partido alguno puede tener 0 mientras que el otro tenga 3
        for (Match match : tournament.getMatches()){
            if(match.getRound()==1){
                assertTrue((match.machtPointsOf(match.getLocal())==1)&&
                        (match.machtPointsOf(match.getVisitor()))==1);
            }
        }

    }
}
