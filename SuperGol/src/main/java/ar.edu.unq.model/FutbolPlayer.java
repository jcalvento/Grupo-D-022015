package ar.edu.unq.model;

public class FutbolPlayer {

    private String name;
    private String pos;
    private String realTeam;

    public FutbolPlayer(String aName,String aPos,String theRealTeam){
        name = aName;
        pos = aPos.toLowerCase();
        realTeam = theRealTeam;
    }

    public String getPos(){
        return pos;
    }
}
