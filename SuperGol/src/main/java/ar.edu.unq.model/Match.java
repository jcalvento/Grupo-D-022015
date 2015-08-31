package ar.edu.unq.model;


public class Match {

    private int round;
    private Team local;
    private Team visitor;

    public Match (int aRound, Team aLocalTeam, Team aVisitorTeam){
        round = aRound;
        local = aLocalTeam;
        visitor = aVisitorTeam;
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
}
