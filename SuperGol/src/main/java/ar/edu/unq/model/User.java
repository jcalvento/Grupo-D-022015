package ar.edu.unq.model;


public class User {

    private String userName;
    private Team team;

    public User (String name){
        userName = name;
    }

    public void createTeam (String teamsName){
        team = new Team(teamsName,this);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

}
