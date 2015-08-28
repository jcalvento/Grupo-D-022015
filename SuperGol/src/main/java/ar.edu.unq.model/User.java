package ar.edu.unq.model;

import java.util.ArrayList;

public class User {

    private String userName;
    private Team team;

    public User (String name){
        userName = name;
    }

    public Team getTeam(){
        return team;
    }

    public void createTeam (String teamsName){
        team = new Team(teamsName,this);
    }

    public void addPlayer(FutbolPlayer aPlayer){
        team.addPlayer(aPlayer);
    }
}
