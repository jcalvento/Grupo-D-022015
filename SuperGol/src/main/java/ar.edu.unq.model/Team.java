package ar.edu.unq.model;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "team", uniqueConstraints = {
        @UniqueConstraint(columnNames = "NAME")
})
public class Team {

    private Integer id;
    private String name;
    private User owner;
    private Set<Player> players;
    private String logo;


    public Team(String aName, User aUser){
        name = aName;
        owner = aUser;
        players = new HashSet<Player>();
    }

    public Team(String aName, User aUser, String teamLogo) {
        this(aName, aUser);
        logo = teamLogo;
    }

    public void addPlayer(Player aPlayer) throws Exception {
        String position = aPlayer.getPosition();
        if(getPlayersWithPosition(position).size() == (getLimitFor(position)))
            throw new Exception("You should remove a " + position + " before adding another one");

        players.add(aPlayer);
    }

    public void assignAsCaptain(Player aPlayer) throws Exception {
        if(!players.contains(aPlayer))
            throw new Exception(aPlayer.getName() + "doesn't belong to this team");
        removeCurrentCaptain();

        aPlayer.assignAsCaptain();
    }

    //Getters - Setters
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "NAME", unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    @Column(name = "LOGO", unique = true, nullable = true)
    public String getLogo() {
        return logo;
    }
    public void setLogo(String aLogo) {
        logo = aLogo;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> aSetOfPlayers) {
        players = aSetOfPlayers;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "team", cascade = CascadeType.ALL)
    public void setOwner(User aUser) {
        owner = aUser;
    }

    public User getOwner() {
        return owner;
    }

    //Private
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

    private void removeCurrentCaptain() {
        for(Player player : players) {
            if(player.isCaptain())
                player.removeCaptainWristband();
        }
    }

    public String getName(){
        return fantasyName;
    }
}
