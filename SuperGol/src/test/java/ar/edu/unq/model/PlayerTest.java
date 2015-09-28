package ar.edu.unq.model;

import ar.edu.unq.model.position.Position;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PlayerTest {

    Player player;

    @Before
    public void setUp() {
        player = new Player("Palermo", Position.forward());
    }

    @Test
    public void itShouldCreateAPlayerWithTheGivenNameAndPosition() {
        Player testPlayer = new Player("Test Player", Position.forward());

        assertEquals(testPlayer.getName(), "Test Player");
        assertEquals(testPlayer.getPosition(), Position.forward());
    }

    @Test
    public void itShouldUpdateTheNameOfThePlayer() {
        player.setName("Martin Palermo");

        assertEquals(player.getName(), "Martin Palermo");
    }

    @Test
    public void itShouldUpdateThePositionOfThePlayer() {
        player.setPosition(Position.midfield());

        assertEquals(player.getPosition(), Position.midfield());
    }

    @Test
    public void itShouldUpdateTheCurrentTeamOfThePlayer() {
        String team = "Boca Juniors";

        player.setTeam(team);

        assertEquals(player.getTeam(), team);
    }
}
