package ar.edu.unq.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tournament")
public class Tournament {

    private String name;
    private List<Team> teams;
    private int minimumAmountOfTeams;
    private int maximumAmountOfTeams;
    private LocalDate applicationDeadline;
    private Fixture fixture;
    private User owner;

    public Tournament(String aName, int aMinimumAmountOfTeams, int aMaximumAmountOfTeams, LocalDate aDate, User aUser) {
        name = aName;
        teams = new ArrayList<>();
        minimumAmountOfTeams = aMinimumAmountOfTeams;
        maximumAmountOfTeams = aMaximumAmountOfTeams;
        applicationDeadline = aDate;
        owner = aUser;
    }

    public void addTeam(Team aTeam) throws Exception {
        if (canSubscribeATeam()) {
            teams.add(aTeam);
        } else {
            throw new Exception("You can´t add more Teams");
        }
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tournament", cascade = CascadeType.ALL)
    public List<Team> getTeams() {
        return teams;
    }

    public void setApplicationDeadline(LocalDate aDate) {
        applicationDeadline = aDate;
    }

    private boolean canSubscribeATeam() {
        return teams.size() < maximumAmountOfTeams && applicationDeadline.isAfter(LocalDate.now());
    }

}
