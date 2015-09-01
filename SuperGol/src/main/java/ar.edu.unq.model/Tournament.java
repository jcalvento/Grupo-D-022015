package ar.edu.unq.model;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Tournament {

    private List<Team> teamList;
    private int minimumAmountOfTeams;
    private int maximumAmountOfTeams;
    private GregorianCalendar applicationDeadline;
    private User owner;

    public Tournament(int aMinimumAmountOfTeams, int aMaximumAmountOfTeams, GregorianCalendar aDate, User aUser){
        teamList = new ArrayList<Team>();
        minimumAmountOfTeams = aMinimumAmountOfTeams;
        maximumAmountOfTeams = aMaximumAmountOfTeams;
        applicationDeadline = aDate;
        owner = aUser;
    }

    public void addTeam(Team aTeam) throws Exception{
        if(canSubscribeATeam()){
            teamList.add(aTeam);
        }else{
            throw new Exception("You can´t add more Teams");
        }
    }

    public List<Team> getTeamList(){
        return teamList;
    }

    public void setApplicationDeadline(int year,int month,int day){
        applicationDeadline = new GregorianCalendar(year, month, day);
    }

    private boolean canSubscribeATeam(){
        return teamList.size()<maximumAmountOfTeams &&
                applicationDeadline.after(
                        GregorianCalendar.from(ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault())));
    }

}
