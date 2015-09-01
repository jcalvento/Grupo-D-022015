package ar.edu.unq.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class UserTest {

    private User testUser;

    @Before
    public void setUp(){
        testUser = new User("User");
    }

    @Test
    public void itShouldCreateATeamWithNameTestTeam(){
        testUser.createTeam("TestTeam");

        assertEquals(testUser.getTeam().getName(),"TestTeam");
    }

    @Test
    public void itShouldAsociateTheUserThatCreatesTheTeamWithIt(){
        testUser.createTeam("My Team");

        assertEquals(testUser.getTeam().getOwner(),testUser);
    }
}
