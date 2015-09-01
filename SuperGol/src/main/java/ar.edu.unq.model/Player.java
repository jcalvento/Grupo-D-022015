package ar.edu.unq.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "player")
public class Player {

    private Integer id;
    private String name;
    private Position position;
    private boolean captain;
    private Set<Goal> goals;

    public Integer pointsMadeIn(Match aMatch) {
        return goals.stream()
                .filter(goal -> goal.wasScoredIn(aMatch))
                .mapToInt(goal -> goal.getPoints())
                .reduce(0, (a, b) -> a + b);
    }

    public Integer getPointsPerGoal() {
        return position.getPointsPerGoal();
    }

    public Player(String aName, Position aPosition){
        name = aName;
        position = aPosition;
        captain = false;
        goals = new HashSet<>();
    }

    public void assignAsCaptain() {
        setCaptain(true);
    }

    public void removeCaptainWristband() {
        setCaptain(false);
    }

    public void addGoalIn(Match aMatch) {
        goals.add(new Goal(this, aMatch));
    }

    @Column(name = "NAME", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    @Column(name = "POSITION")
    public Position getPosition(){
        return position;
    }

    public void setPosition(Position aPosition) {
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
