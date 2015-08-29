package ar.edu.unq.model;

public class Player {

    private String name;
    private String position;

    public Player(String aName, String aPosition){
        name = aName;
        position = aPosition.toUpperCase();
    }

    public String getPosition(){
        return position;
    }
}
