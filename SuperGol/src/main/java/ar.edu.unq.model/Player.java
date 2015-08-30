package ar.edu.unq.model;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "player")
public class Player {

    private Integer id;
    private String name;
    private String position;
    private boolean captain;

    public Player(String aName, String aPosition){
        name = aName;
        position = aPosition.toUpperCase();
        captain = false;
    }

    public void assignAsCaptain() {
        setCaptain(true);
    }

    public void removeCaptainWristband() {
        setCaptain(false);
    }

    @Column(name = "NAME", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    @Column(name = "POSITION")
    public String getPosition(){
        return position;
    }

    public void setPosition(String aPosition) {
        position = aPosition;
    }

    @Column(name = "CAPTAIN")
    public boolean isCaptain() {
        return captain;
    }

    public void setCaptain(Boolean aBool) {
        captain = aBool;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }
}
