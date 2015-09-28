package ar.edu.unq.model;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "match")
public class Match {

    private DateMatch dateMatch;
    private Team local;
    private Team visitor;
    private Map<Team, Integer> scorer;

    public Match(Team aTeam, Team anotherTeam){
        local = aTeam;
        visitor = anotherTeam;
        scorer = new HashMap<>();
        scorer.put(local, 0);
        scorer.put(visitor, 0);
    }

    @ManyToOne
    public Team getLocal(){
        return local;
    }

    @ManyToOne
    public Team getVisitor(){
        return visitor;
    }

    public Integer pointsOf(Team aTeam) {
        Integer points = aTeam.pointsMadeIn(dateMatch);
        Team rival = getRivalOf(aTeam);
        Integer rivalGoals = scorer.get(rival);
        Integer rivalPoints = rival.pointsMadeIn(dateMatch);

        return points > rivalGoals ? 3 : points.equals(rivalPoints) ? 1 : 0;
    }

    private Team getRivalOf(Team aTeam) {
        return Arrays.asList(local, visitor).stream()
                    .filter(team -> !team.equals(aTeam)).findFirst().get();
    }

    public void setDateMatch(DateMatch aDateMatch) {
        dateMatch = aDateMatch;
    }
}
