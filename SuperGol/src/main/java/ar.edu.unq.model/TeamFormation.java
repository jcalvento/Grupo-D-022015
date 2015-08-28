package ar.edu.unq.model;

import java.util.ArrayList;

public class TeamFormation {

    private int goalKeeper;
    private int defenders;
    private int midfielders;
    private int forwards;

    public TeamFormation(int gk,int def, int mid, int fwrd){
        goalKeeper = gk;
        defenders = def;
        midfielders = mid;
        forwards = fwrd;
    }

    public void addNewTeamPleayer(ArrayList<FutbolPlayer> aTeam, FutbolPlayer aPlayer){
        int posCounter = 0;
        for(FutbolPlayer player: aTeam ){
            if(player.getPos().equals(aPlayer.getPos())){
                posCounter++;
            }
        }
        if(positionIsEmpty(posCounter, aPlayer.getPos())){
            aTeam.add(aPlayer);
        }else{
            //throws ex
        }
    }

    private Boolean positionIsEmpty(int tokenPos, String posId){
        int pos=0;
        if(posId.equals("arq")) pos = goalKeeper;
        if(posId.equals("def")) pos = defenders;
        if(posId.equals("vol")) pos = midfielders;
        if(posId.equals("del")) pos = forwards;
        return tokenPos<pos;
    }
}
