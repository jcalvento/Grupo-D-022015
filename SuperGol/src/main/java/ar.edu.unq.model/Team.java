package ar.edu.unq.model;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private User owner;
    private ArrayList<Player> players;
    private String logo;


    public Team(String aName, User aUser){
        name = aName;
        owner = aUser;
        players = new ArrayList<Player>();
    }

    public Team(String aName, User aUser, String teamLogo) {
        this(aName, aUser);
        logo = teamLogo;
    }

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }

    public void addPlayer(Player aPlayer) throws Exception {
        String position = aPlayer.getPosition();
        if(getPlayersWithPosition(position).size() == (getLimitFor(position)))
            throw new Exception("You should remove a " + position + " before adding another one");

        players.add(aPlayer);
    }

    public List<Player> getPlayers() {
        return players;
    }

    private List<Player> getPlayersWithPosition(String aPosition) {
        List<Player> playersWithPosition = new ArrayList<Player>();
        for (Player player : players) {
            if(player.getPosition().equals(aPosition))
                playersWithPosition.add(player);
        }

        return playersWithPosition;
    }

    private Integer getLimitFor(String aPosition) {
        if(aPosition.equals("FWD") || aPosition.equals("DEF"))
            return 3;
        else if(aPosition.equals("MED"))
            return 4;
        else
            return 1;
    }
}
