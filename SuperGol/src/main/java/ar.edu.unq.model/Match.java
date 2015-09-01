package ar.edu.unq.model;


public class Match {

    private int round;
    private Team local;
    private Team visitor;

    public Match (int aRound, Team aTeam, Team anotherTeam){
        round = aRound;
        local = aTeam;
        visitor = anotherTeam;
    }

    public String getMatchFormat(){
        return "Round: "+ round +"=> " + local.getName() + " VS "+ visitor.getName();
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
        aTeam.addGoalOf(aPlayer, this);
    }

    public Integer pointsOf(Team aTeam) {
        return aTeam.pointsMadeIn(this);
    }
}
