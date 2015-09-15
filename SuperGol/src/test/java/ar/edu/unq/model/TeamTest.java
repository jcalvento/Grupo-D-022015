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
        user = TestObjectsFactory.getUser();
        team = TestObjectsFactory.getTeam();
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

    @Test
    public void itShouldAddAForward() throws Exception {
        Player forward = TestObjectsFactory.getForward();

        team.addPlayer(forward);

        assertTrue(team.getPlayers().contains(forward));
    }

    public void addPlayersWithSamePositionTo(Integer numberOfPlayers, Team aTeam, Position aPosition) throws Exception {
        for (int i = 0; i < numberOfPlayers; i ++)
            aTeam.addPlayer(new Player("Player" + i, aPosition));
    }

    @Test
    public void itShouldFailIfAddsAMidfieldPlayerWhenThereAreFourAlready() throws Exception {
        Player midfieldPlayer = TestObjectsFactory.getMidfieldPlayer();
        addPlayersWithSamePositionTo(4, team, midfieldPlayer.getPosition());

        try {
            team.addPlayer(midfieldPlayer);
        } catch (Exception e) {
            assertEquals(e.getMessage(),
                    "You should remove a " + midfieldPlayer.getPosition() + " before adding another one");
        }
        assertFalse(team.getPlayers().contains(midfieldPlayer));
    }

    @Test
    public void itShouldFailIfAddsAForwardPlayerWhenThereAreThreeAlready() throws Exception {
        Player forward = TestObjectsFactory.getForward();
        Position position = forward.getPosition();
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
        Player defender = TestObjectsFactory.getDefender();
        Position position = defender.getPosition();
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
        Player goalKeeper = TestObjectsFactory.getGoalKeeper();
        Position position = goalKeeper.getPosition();
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
        Player goalKeeper = TestObjectsFactory.getGoalKeeper();
        team.addPlayer(goalKeeper);

        team.setCaptain(goalKeeper);

        assertEquals(team.getCaptain(), goalKeeper);
    }

    @Test
    public void itShouldFailWhenAssigningAPlayerAsCaptainWhenHeDoesNotBelongToTheTeam() {
        Player goalKeeper = TestObjectsFactory.getGoalKeeper();

        try {
            team.setCaptain(goalKeeper);
        } catch (Exception e) {
            assertEquals(e.getMessage(),
                    goalKeeper.getName() + "doesn't belong to this team");
        }

        assertNotSame(team.getCaptain(), goalKeeper);
    }

    @Test
    public void itShouldReassignTheCaptainWhenTheTeamHasAlreadyOne() throws Exception {
        Player goalKeeper = TestObjectsFactory.getGoalKeeper();
        Player defender = new Player("Cristian Castro", Position.defender());
        team.addPlayer(goalKeeper);
        team.addPlayer(defender);
        team.setCaptain(goalKeeper);

        team.setCaptain(defender);

        assertTrue(team.getCaptain().equals(defender));
        assertFalse(team.getCaptain().equals(goalKeeper));
    }
}
