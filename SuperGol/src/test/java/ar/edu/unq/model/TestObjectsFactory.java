package ar.edu.unq.model;

import ar.edu.unq.model.position.Position;

public class TestObjectsFactory {

    private static int counter = 0;

    public static Player getForward() {
        return new Player("Forward-" + counter, Position.forward());
    }

    public static Player getDefender() {
        return new Player("Defender-" + counter, Position.defender());
    }

    public static Player getMidfieldPlayer() {
        return new Player("Midfield-" + counter, Position.midfield());
    }

    public static Player getGoalKeeper() {
        return new Player("GoalKeeper-" + counter, Position.goalKeeper());
    }

    public static User getUser() {
        return new User("Test User " + counter);
    }

    public static Team getTeam() {
        return getTeamFor(getUser());
    }

    public static Team getTeamFor(User anUser) {
        return new Team("TestTeam-" + counter, anUser);
    }
}
