package ar.edu.unq.model;

import javax.persistence.*;

import java.util.GregorianCalendar;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "USERNAME")
})
public class User {

    private Integer id;
    private String userName;
    private Team team;
    private Tournament tournament;

    public User (String name){
        userName = name;
    }

    public void createTournament (int aMinimumAmountOfTeams, int aMaximumAmountOfTeams, GregorianCalendar aDate){
        tournament = new Tournament(aMinimumAmountOfTeams,aMaximumAmountOfTeams,aDate,this);
    }

    public void createTeam (String teamsName){
        team = new Team(teamsName,this);
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

    public void setTeam(Team team) {
        this.team = team;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "owner", cascade = CascadeType.ALL)
    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
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
