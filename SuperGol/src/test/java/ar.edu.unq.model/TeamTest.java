package ar.edu.unq.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TeamTest {

    private User user;
    private Team team;

    @Before
    public void setUp() {
        user = new User("user");
    }

    @Test
    public void itShouldCreateATeamWithTheGivenName() {
        makeTeam();

        assertEquals(team.getName(), "All Stars");
    }

    @Test
    public void itShouldCreateATeamWithTheGivenNameAndLogo() {
        Team team = new Team("All Stars", user, "http://team_image.com");

        assertEquals(team.getName(), "All Stars");
        assertEquals(team.getLogo(), "http://team_image.com");
    }

    public void makeTeam() {
        team = new Team("All Stars", user);
    }

    @Test
    public void itShouldAddAForward() throws Exception {
        makeTeam();
        Player forward = new Player("Palermo", "FWD");

        team.addPlayer(forward);

        assertTrue(team.getPlayers().contains(forward));
    }

    public void addPlayersWithSamePositionTo(Integer numberOfPlayers, Team aTeam, String aPosition) throws Exception {
        for (int i = 0; i < numberOfPlayers; i ++)
            aTeam.addPlayer(new Player("midfieldPlayer" + i, aPosition));
    }

    @Test
    public void itShouldFailIfAddsAMidfieldPlayerWhenThereAreFourAlready() throws Exception {
        makeTeam();
        String position = "MED";
        Player midfieldPlayer = new Player("Chicho Serna", position);
        addPlayersWithSamePositionTo(4, team, position);

        try {
            team.addPlayer(midfieldPlayer);
        } catch (Exception e) {
            assertEquals(e.getMessage(),
                    "You should remove a " + position + " before adding another one");
        }
        assertFalse(team.getPlayers().contains(midfieldPlayer));
    }

    @Test
    public void itShouldFailIfAddsAForwardPlayerWhenThereAreThreeAlready() throws Exception {
        makeTeam();
        String position = "FWD";
        Player forward = new Player("Palermo", position);
        addPlayersWithSamePositionTo(3, team, position);

        try {
            team.addPlayer(forward);
        } catch (Exception e) {
            assertEquals(e.getMessage(),
                    "You should remove a " + position + " before adding another one");
        }
        assertFalse(team.getPlayers().contains(forward));
    }

    @Test
    public void itShouldFailIfAddsADefenderWhenThereAreThreeAlready() throws Exception {
        makeTeam();
        String position = "DEF";
        Player defender = new Player("Defender", position);
        addPlayersWithSamePositionTo(3, team, position);

        try {
            team.addPlayer(defender);
        } catch (Exception e) {
            assertEquals(e.getMessage(),
                    "You should remove a " + position + " before adding another one");
        }
        assertFalse(team.getPlayers().contains(defender));
    }

    @Test
    public void itShouldFailIfAddsAGoalKeeperWhenThereIsOneAlready() throws Exception {
        makeTeam();
        String position = "GK";
        Player goalKeeper = new Player("Palermo", position);
        addPlayersWithSamePositionTo(1, team, position);

        try {
            team.addPlayer(goalKeeper);
        } catch (Exception e) {
            assertEquals(e.getMessage(),
                    "You should remove a " + position + " before adding another one");
        }
        assertFalse(team.getPlayers().contains(goalKeeper));
    }
}
