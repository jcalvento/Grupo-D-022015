package ar.edu.unq.model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;


public class UserTest {

    private User testUser;

    @Before
    public void setUp(){
        testUser = new User("User");
    }


    @Test
    public void itShouldCreateAUserWithTheGivenName() {
        User user = new User("Test User");

        assertEquals(user.getUserName(), "Test User");
    }

    @Test
    public void itShouldUpdateHisUserName() {
        testUser.setUserName("New User Name");

        assertEquals(testUser.getUserName(), "New User Name");
    }

    @Test
    public void itShouldCreateATeamWithNameTestTeam(){
        testUser.createTeam("TestTeam");

        assertEquals(testUser.getTeam().getName(),"TestTeam");
    }

    @Test
    public void itShouldAssociateTheUserThatCreatesTheTeamWithIt(){
        testUser.createTeam("My Team");

        assertEquals(testUser.getTeam().getOwner(),testUser);
    }

    @Test
    public void itShouldCreateAnEmptyTournament(){
        testUser.createTournament("tournamentTest", 2, 3, LocalDate.of(2015, 9, 10));

        assertTrue(testUser.getTournament().getTeams().isEmpty());
    }
}
