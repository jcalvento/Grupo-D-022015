package ar.edu.unq.model;

import ar.edu.unq.model.position.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Team {

    private String name;
    private User owner;
    private Set<Player> players;
    private String logo;


    public Team(String aName, User aUser){
        name = aName;
        owner = aUser;
        players = new HashSet<>();
    }

    public Team(String aName, User aUser, String teamLogo) {
        this(aName, aUser);
        logo = teamLogo;
    }

    public void addPlayer(Player aPlayer) throws Exception {
        Position position = aPlayer.getPosition();
        if(getPlayersWithPosition(position).size() == (position.getMaxNumberOfPlayersInATeam()))
            throw new Exception("You should remove a " + position + " before adding another one");

        players.add(aPlayer);
    }

    public void assignAsCaptain(Player aPlayer) throws Exception {
        validatePlayerIsInTheTeam(aPlayer);
        removeCurrentCaptain();

        aPlayer.assignAsCaptain();
    }

    public void addGoalOf(Player aPlayer, Match aMatch) throws Exception {
        validatePlayerIsInTheTeam(aPlayer);

        aPlayer.addGoalIn(aMatch);
    }

    //Getters - Setters
    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String aLogo) {
        logo = aLogo;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public User getOwner() {
        return owner;
    }

    //Private
    private List<Player> getPlayersWithPosition(Position aPosition) {
        return players.stream()
                .filter(player -> player.getPosition().equals(aPosition))
                .collect(Collectors.toList());
    }

    private void removeCurrentCaptain() {
        players.forEach(player -> {
            if(player.isCaptain())
                player.removeCaptainWristband();
        });
    }

    private void validatePlayerIsInTheTeam(Player aPlayer) throws Exception {
        if(!players.contains(aPlayer))
            throw new Exception(aPlayer.getName() + "doesn't belong to this team");
    }

    public Integer pointsMadeIn(Match aMatch) {
        return players.stream()
                .map(player -> player.pointsMadeIn(aMatch))
                .reduce(0, (a, b) -> a + b);
    }
}