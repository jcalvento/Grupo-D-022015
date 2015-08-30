package ar.edu.unq.model;

public class Player {

    private String name;
    private String position;
    private boolean captain;

    public Player(String aName, String aPosition){
        name = aName;
        position = aPosition.toUpperCase();
        captain = false;
    }

    public String getPosition(){
        return position;
    }

    public void assignAsCaptain() {
        captain = true;
    }

    public void removeCaptainWristband() {
        captain = false;
    }

    public boolean isCaptain() {
        return captain;
    }

    public String getName() {
        return name;
    }
}
