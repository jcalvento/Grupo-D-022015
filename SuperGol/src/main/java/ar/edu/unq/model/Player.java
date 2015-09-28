package ar.edu.unq.model;

import ar.edu.unq.model.position.Position;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player {

    private Integer id;
    private String name;
    private Position position;
    //Me parece que la posicion puede ser un string, se usa solo cuando carga los goles
    private Set<DateMatchGoalCounter> goals;
    private String team;

    public int pointsMadeIn(DateMatch aDateMatch) {
        return goals.stream()
                .filter(goal -> goal.wasScoredIn(aDateMatch))
                .mapToInt(DateMatchGoalCounter::getPoints)
                .reduce(0, (a, b) -> a + b);
    }

    public Player(String aName, Position aPosition){
        name = aName;
        position = aPosition;
        goals = new HashSet<>();
    }

    @Column(name = "NAME", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    @ManyToOne
    public Position getPosition(){
        return position;
    }

    public void setPosition(Position aPosition) {
        position = aPosition;
    }

    @Column(name = "TEAM")
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
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

    public void addGoalsInDateMatch(DateMatchGoalCounter dateMatchGoalCounter) {
        goals.add(dateMatchGoalCounter);
    }
}
