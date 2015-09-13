package ar.edu.unq.model;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Match {

    private int round;
    private Team local;
    private Team visitor;
    private Map<Team, Integer> scorer;

    public Match (int aRound, Team aTeam, Team anotherTeam){
        round = aRound;
        local = aTeam;
        visitor = anotherTeam;
        scorer = new HashMap<>();
        scorer.put(local, 0);
        scorer.put(visitor, 0);
    }

    public int getRound(){
        return round;
    }

    public Team getLocal(){
        return local;
    }

    public Team getVisitor(){
        return visitor;
    }

    public void addGoal(Team aTeam, Player aPlayer) throws Exception {
        scorer.replace(aTeam, scorer.get(aTeam) + 1);
        aTeam.addGoalOf(aPlayer, this);
    }

    public Integer pointsOf(Team aTeam) {
        Integer points = aTeam.pointsMadeIn(this);
        Team rival = getRivalOf(aTeam);
        Integer rivalGoals = scorer.get(rival);
        if(rivalGoals.equals(0))
            points += 2;
        return points;
    }

    public Integer machtPointsOf(Team aTeam) {

        return scorer.get(aTeam)>scorer.get(getRivalOf(aTeam))? 3 :
                scorer.get(aTeam)<scorer.get(getRivalOf(aTeam))? 0 : 1;

    }
    private Team getRivalOf(Team aTeam) {
        return (Team) Arrays.asList(local, visitor).stream()
                    .filter(team -> !team.equals(aTeam)).findFirst().get();
    }

}
