package ar.edu.unq.model;

import ar.edu.unq.model.position.Position;

import java.util.HashSet;
import java.util.Set;


public class Player {

    private String name;
    private Position position;
    private Set<DateMatchGoalCounter> goals;
    private Team team;

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

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    public Position getPosition(){
        return position;
    }

    public void setPosition(Position aPosition) {
        position = aPosition;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void addGoalsInDateMatch(DateMatchGoalCounter dateMatchGoalCounter) {
        goals.add(dateMatchGoalCounter);
    }
}
