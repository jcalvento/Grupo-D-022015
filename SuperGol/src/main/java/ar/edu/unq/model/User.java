package ar.edu.unq.model;


import java.time.LocalDate;

public class User {

    private String userName;
    private Team team;
    private Tournament tournament;

    public User(String name) {
        userName = name;
    }

    public void createTeam(String teamsName) {
        team = new Team(teamsName, this);
    }

    public void createTournament(String aName, int aMinimumAmountOfTeams, int aMaximumAmountOfTeams, LocalDate aDate) {
        tournament = new Tournament(aName, aMinimumAmountOfTeams, aMaximumAmountOfTeams, aDate, this);
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

    public Tournament getTournament() {
        return tournament;
    }
}
