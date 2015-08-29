package ar.edu.unq.model;

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
}
