package ar.edu.unq.model;


import ar.edu.unq.model.position.Position;

public class RealTournamentGoal {

    String playersName;
    Position position;
    Integer scoredGoals;

    public RealTournamentGoal (String aPlayersName, Position aPosition, Integer goals){

        playersName = aPlayersName;
        position = aPosition;
        scoredGoals = goals;
    }

    public String getPlayersName() {
        return playersName;
    }

    public Position getPosition() {
        return position;
    }

    public Integer getScoredGoals() {
        return scoredGoals;
    }

}
