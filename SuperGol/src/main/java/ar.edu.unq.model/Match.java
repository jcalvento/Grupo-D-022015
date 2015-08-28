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

}
