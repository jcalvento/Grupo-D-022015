package ar.edu.unq.model;


import java.util.GregorianCalendar;

public class User {

    private String userName;
    private Team team;
    private Tournament tournament;

    public User (String name){
        userName = name;
    }

    public void createTeam (String teamsName){
        team = new Team(teamsName,this);
    }

    public void createTournament (int aMinimumAmountOfTeams, int aMaximumAmountOfTeams, GregorianCalendar aDate){
        tournament = new Tournament(aMinimumAmountOfTeams,aMaximumAmountOfTeams,aDate,this);
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

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}
