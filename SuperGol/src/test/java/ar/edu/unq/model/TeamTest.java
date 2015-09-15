package ar.edu.unq.model;

import ar.edu.unq.model.position.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTest {

    private User user;
    private Team team;

    @Before
    public void setUp() {
        user = new User("user");
        makeTeam();
    }

    @Test
    public void itShouldCreateATeamWithTheGivenName() {
        Team team = new Team("All Stars team", user);

        assertEquals(team.getName(), "All Stars team");
    }

    @Test
    public void itShouldCreateATeamWithTheGivenNameAndLogo() {
        Team team = new Team("All Stars", user, "http://team_image.com");

        assertEquals(team.getName(), "All Stars");
        assertEquals(team.getLogo(), "http://team_image.com");
    }

    @Test
    public void itShouldUpdateTheTeamWithTheGivenName() {
        team.setName("Modified team");

        assertEquals(team.getName(), "Modified team");
    }

    @Test
    public void itShouldUpdateTheTeamLogoWithTheGivenOne() {
        team.setLogo("http://new_logo.com");

        assertEquals(team.getLogo(), "http://new_logo.com");
    }

    public void makeTeam() {
        team = new Team("All Stars", user);
    }

    @Test
    public void itShouldAddAForward() throws Exception {
        Player forward = new Player("Palermo", Position.forward());

        team.addPlayer(forward);

        assertTrue(team.getPlayers().contains(forward));
    }

    public void addPlayersWithSamePositionTo(Integer numberOfPlayers, Team aTeam, Position aPosition) throws Exception {
        for (int i = 0; i < numberOfPlayers; i ++)
            aTeam.addPlayer(new Player("Player" + i, aPosition));
    }

    @Test
    public void itShouldFailIfAddsAMidfieldPlayerWhenThereAreFourAlready() throws Exception {
        Position position = Position.midfield();
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
        Position position = Position.forward();
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
        Position position = Position.defender();
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
        Position position = Position.goalKeeper();
        Player goalKeeper = new Player("Gato Sessa", position);
        addPlayersWithSamePositionTo(1, team, position);

        try {
            team.addPlayer(goalKeeper);
        } catch (Exception e) {
            assertEquals(e.getMessage(),
                    "You should remove a " + position + " before adding another one");
        }
        assertFalse(team.getPlayers().contains(goalKeeper));
    }

    @Test
    public void itShouldAssignACaptain() throws Exception {
        Player goalKeeper = getGk();
        team.addPlayer(goalKeeper);

        team.setCaptain(goalKeeper);

        assertEquals(team.getCaptain(), goalKeeper);
    }

    @Test
    public void itShouldFailWhenAssigningAPlayerAsCaptainWhenHeDoesNotBelongToTheTeam() {
        Player goalKeeper = getGk();

        try {
            team.setCaptain(goalKeeper);
        } catch (Exception e) {
            assertEquals(e.getMessage(),
                    goalKeeper.getName() + "doesn't belong to this team");
        }

        assertNotSame(team.getCaptain(), goalKeeper);
    }

    private Player getGk() {
        return new Player("Gato Sessa", Position.goalKeeper());
    }

    @Test
    public void itShouldReassignTheCaptainWhenTheTeamHasAlreadyOne() throws Exception {
        Player goalKeeper = getGk();
        Player defender = new Player("Cristian Castro", Position.defender());
        team.addPlayer(goalKeeper);
        team.addPlayer(defender);
        team.setCaptain(goalKeeper);

        team.setCaptain(defender);

        assertTrue(team.getCaptain().equals(defender));
        assertFalse(team.getCaptain().equals(goalKeeper));
    }
}
