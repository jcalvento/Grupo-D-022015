package ar.edu.unq.model;


import ar.edu.unq.model.position.Position;

import java.util.ArrayList;

public class ModelsFactory {

    public static Team creatBasicTeam(String teamsName, User aUser) throws Exception {
        Team aBasicTeam = new Team(teamsName,aUser);

        Player aGK = new Player("a", Position.goalKeeper());
        aBasicTeam.addPlayer(aGK);

        Player aDF1 = new Player("b", Position.defender());
        Player aDF2 = new Player("c", Position.defender());
        Player aDF3 = new Player("d", Position.defender());
        aBasicTeam.addPlayer(aDF1);
        aBasicTeam.addPlayer(aDF2);
        aBasicTeam.addPlayer(aDF3);

        Player aMF1 = new Player("e", Position.midfield());
        Player aMF2 = new Player("f", Position.midfield());
        Player aMF3 = new Player("g", Position.midfield());
        Player aMF4 = new Player("h", Position.midfield());

        aBasicTeam.addPlayer(aMF1);
        aBasicTeam.addPlayer(aMF2);
        aBasicTeam.addPlayer(aMF3);
        aBasicTeam.addPlayer(aMF4);

        Player aFW1 = new Player("i",Position.forward());
        Player aFW2 = new Player("j",Position.forward());
        Player aFW3 = new Player("k",Position.forward());

        aBasicTeam.addPlayer(aFW1);
        aBasicTeam.addPlayer(aFW2);
        aBasicTeam.addPlayer(aFW3);

        return  aBasicTeam;
    }

    public static ArrayList<RealTournamentGoal> createTestGoalsPerRoundData(){

        ArrayList<RealTournamentGoal> roundScoredGoals = new ArrayList<RealTournamentGoal>();

        RealTournamentGoal playerA = new RealTournamentGoal("a",Position.goalKeeper(),1);
        RealTournamentGoal playerB = new RealTournamentGoal("a",Position.defender(),0);
        RealTournamentGoal playerC = new RealTournamentGoal("a",Position.defender(),1);
        RealTournamentGoal playerD = new RealTournamentGoal("a",Position.defender(),0);
        RealTournamentGoal playerE = new RealTournamentGoal("a",Position.midfield(),0);
        RealTournamentGoal playerF = new RealTournamentGoal("a",Position.midfield(),2);
        RealTournamentGoal playerG = new RealTournamentGoal("a",Position.midfield(),0);
        RealTournamentGoal playerH = new RealTournamentGoal("a",Position.midfield(),1);
        RealTournamentGoal playerI = new RealTournamentGoal("a",Position.forward(),3);
        RealTournamentGoal playerJ = new RealTournamentGoal("a",Position.forward(),2);
        RealTournamentGoal playerK = new RealTournamentGoal("a",Position.forward(),1);

        roundScoredGoals.add(playerA);
        roundScoredGoals.add(playerB);
        roundScoredGoals.add(playerC);
        roundScoredGoals.add(playerD);
        roundScoredGoals.add(playerE);
        roundScoredGoals.add(playerF);
        roundScoredGoals.add(playerG);
        roundScoredGoals.add(playerH);
        roundScoredGoals.add(playerI);
        roundScoredGoals.add(playerJ);
        roundScoredGoals.add(playerK);

        return roundScoredGoals;



    }
}
