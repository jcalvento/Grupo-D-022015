package ar.edu.unq.web.rest;

import ar.edu.unq.model.Team;
import ar.edu.unq.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class RestApi {

    @GET
    @Path("/teams")
    @Produces("application/json")
    public List<Team> findTeams() {
        List<Team> result = new ArrayList<>();
        result.add(new Team("El team", new User("User")));

        return result;
    }

}
