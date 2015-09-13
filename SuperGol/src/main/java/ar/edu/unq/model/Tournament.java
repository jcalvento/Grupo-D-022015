package ar.edu.unq.model;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Tournament {

    private String name;
    private ArrayList<Team> teams;
    private int minimumAmountOfTeams;
    private int maximumAmountOfTeams;
    private GregorianCalendar applicationDeadline;
    private User owner;
    private ArrayList<Match> matches;

    public Tournament(String aName, int aMinimumAmountOfTeams, int aMaximumAmountOfTeams, GregorianCalendar aDate, User aUser){
        name = aName;
        teams = new ArrayList<Team>();
        minimumAmountOfTeams = aMinimumAmountOfTeams;
        maximumAmountOfTeams = aMaximumAmountOfTeams;
        applicationDeadline = aDate;
        owner = aUser;
    }

    public void addTeam(Team aTeam) throws Exception{
        if(canSubscribeATeam(aTeam)){
            teams.add(aTeam);
        }else{
            throw new Exception("You can´t add more Teams");
        }
    }

    public List<Team> getTeams(){
        return teams;
    }

    public void setApplicationDeadline(int year,int month,int day){
        applicationDeadline = new GregorianCalendar(year, month, day);
    }

    public void generateFixture(){
        matches = FixtureGenerator.createFixture(teams);
    }

    public void setResultsOfTheRound(int aRound){

        for(Match match : matches){
            if(match.getRound()==aRound){
                match.machtPointsOf(match.getLocal());
                match.machtPointsOf(match.getVisitor());
            }
        }

    }

    public ArrayList<Match> getMatches(){
        return matches;
    }
    private boolean canSubscribeATeam(Team aTeam){
        return teams.size()<maximumAmountOfTeams &&
                aTeam.isComplete() &&
                applicationDeadline.after(
                        GregorianCalendar.from(ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault())));
    }
}
