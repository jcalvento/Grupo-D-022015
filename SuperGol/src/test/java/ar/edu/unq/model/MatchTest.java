package ar.edu.unq.model;

import ar.edu.unq.model.position.Position;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class MatchTest {

    Match match, match2;
    Team local, visitor, local2, visitor2;
    Player forward, defender, goalkeeper, midfield, rivalDefender;
    ArrayList<RealTournamentGoal> scoredGoals;

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
        match = new Match(1, local, visitor);
        local2= ModelsFactory.creatBasicTeam("local2",new User("testUserLocal"));
        visitor2= ModelsFactory.creatBasicTeam("visitor2", new User("testUserVisitor"));
        scoredGoals = ModelsFactory.createTestGoalsPerRoundData();
        match2 = new Match(1,local2,visitor2);
    }

    @Before
    public void setUp() throws Exception {
        makeMatchWithTeams();
    }

    @Test
    public void itShouldAddOneGoalOfAForwardToTheLocalTeamAndEqualOnePoint() throws Exception {
        match.addGoal(visitor, rivalDefender);
        match.addGoal(local, forward);

        assertTrue(match.pointsOf(local).equals(1));
    }

    @Test
    public void itShouldAddOneGoalOfADefenderToTheLocalTeamAndEqualOnePoint() throws Exception {
        match.addGoal(visitor, rivalDefender);
        match.addGoal(local, midfield);

        assertTrue(match.pointsOf(local).equals(1));
    }

    @Test
    public void itShouldAddOneGoalOfADefenderToTheLocalTeamAndEqualThreePoints() throws Exception {
        match.addGoal(visitor, rivalDefender);
        match.addGoal(local, defender);

        assertTrue(match.pointsOf(local).equals(3));
    }

    @Test
    public void itShouldHaveTwoPointsWhenTheGoalKeeperDidNotReceiveAnyGoals() throws Exception {
        assertTrue(match.pointsOf(local).equals(2));
    }

    @Test
    public void itShouldHaveNoPointsForTheGoalKeeperWhenTheRivalScoredAtLeastOneGoal() throws Exception {
        match.addGoal(visitor, rivalDefender);

        assertFalse(match.pointsOf(local).equals(2));
    }

    @Test
    public void givenTheGoalsOfTheRealTournamentItShouldGiveTheTotalScoredForEachTeam() throws Exception {

        for(RealTournamentGoal data : scoredGoals){
            for(Integer i=0; i<data.getScoredGoals();i++){
                match2.addGoal(local2, local2.findPlayerWithName(data.getPlayersName()));
                match2.addGoal(visitor2,visitor2.findPlayerWithName(data.getPlayersName()));
            }
        }

        assertTrue(match2.pointsOf(local2).equals(12));
        assertTrue(match2.pointsOf(visitor2).equals(12));

    }

    @Test
    public void givenTheGoalsOfTheRealTournamentItShouldGiveTheFinalResultOfTheMach() throws Exception {

        for(RealTournamentGoal data : scoredGoals){
            for(Integer i=0; i<data.getScoredGoals();i++){
                match2.addGoal(local2, local2.findPlayerWithName(data.getPlayersName()));
                match2.addGoal(visitor2,visitor2.findPlayerWithName(data.getPlayersName()));
            }
        }

        assertTrue(match2.machtPointsOf(local2).equals(1));
        assertTrue(match2.machtPointsOf(visitor2).equals(1));
    }
}
