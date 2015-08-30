package ar.edu.unq.model;

import java.util.ArrayList;

public class Team {

    private String fantasyName;
    private User owner;
    private ArrayList<FutbolPlayer> teamMembers;
    private TeamFormation formation;


    public Team (String aName, User aUser){
        fantasyName = aName;
        owner = aUser;
        teamMembers = new ArrayList<FutbolPlayer>();
        formation = new TeamFormation(1,3,4,3); //default formation
    }

    public void addPlayer(FutbolPlayer aFutbolPlayer) { //throws positionisFullEx
        formation.addNewTeamPleayer(teamMembers, aFutbolPlayer);
    }

    public String getName(){
        return fantasyName;
    }
}
