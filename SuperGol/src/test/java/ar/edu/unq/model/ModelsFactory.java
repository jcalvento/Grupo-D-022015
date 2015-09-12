package ar.edu.unq.model;


import ar.edu.unq.model.position.Position;

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
}
