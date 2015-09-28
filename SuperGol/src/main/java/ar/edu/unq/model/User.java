package ar.edu.unq.model;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
import java.time.LocalDate;

@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = "USERNAME")})
public class User {

    private Integer id;
    private String userName;
    private Team team;
    private Tournament tournament;

    public User(String name) {
        userName = name;
    }

    public void createTeam(String teamsName) {
        team = new Team(teamsName, this);
    }

    public void createTournament(String aName, int aMinimumAmountOfTeams, int aMaximumAmountOfTeams, LocalDate aDate) {
        tournament = new Tournament(aName, aMinimumAmountOfTeams, aMaximumAmountOfTeams, aDate, this);
    }

    @Column(name = "USERNAME", nullable = false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "owner", cascade = CascadeType.ALL)
    public Team getTeam() {
        return team;
    }

    public Tournament getTournament() {
        return tournament;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
