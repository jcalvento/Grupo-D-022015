package ar.edu.unq.model;


import java.util.ArrayList;
import java.util.List;

public class Tournament {

    private List<Team> teamList;
    private int minimumAmountOfTeams;
    private int maximumAmountOfTeams;

    public void Tournament(int aMinimumAmountOfTeams, int aMaximumAmountOfTeams){
        teamList = new ArrayList<Team>();
        minimumAmountOfTeams = aMinimumAmountOfTeams;
        maximumAmountOfTeams = aMaximumAmountOfTeams;
    }

    public void addTeam(Team aTeam){
        if(teamList.size()<maximumAmountOfTeams){
            teamList.add(aTeam);
        }else{
            //throw ex
        }
    }
}
