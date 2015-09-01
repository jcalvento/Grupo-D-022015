package ar.edu.unq.model;

public class Goal {

    private final Player player;
    private final Match match;

    public Goal(Player aPlayer, Match aMatch) {
        player = aPlayer;
        match = aMatch;
    }

    public Player getPlayer() {
        return player;
    }

    public Match getMatch() {
        return match;
    }

    public boolean wasScoredIn(Match aMatch) {
        return match.equals(aMatch);
    }

    public Integer getPoints() {
        return player.getPointsPerGoal();
    }
}
