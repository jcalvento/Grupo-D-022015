package ar.edu.unq.model;

import ar.edu.unq.model.position.Position;

import java.util.HashSet;
import java.util.Set;


public class Player {

    private int id;

    private String name;
    private Position position;
    private boolean captain;
    private Set<Goal> goals;
    private Team team;
    public Integer pointsMadeIn(Match aMatch) {
        return goals.stream()
                .filter(goal -> goal.wasScoredIn(aMatch))
                .mapToInt(Goal::getPoints)
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
        goals.add(new Goal(this, aMatch, team));
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

    public boolean isCaptain() {
        return captain;
    }

    public void setCaptain(Boolean aBool) {
        captain = aBool;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
