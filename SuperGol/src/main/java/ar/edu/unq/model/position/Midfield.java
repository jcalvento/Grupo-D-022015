package ar.edu.unq.model.position;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="position")
@DiscriminatorValue("Midfield")
public class Midfield extends Position {

    @Override
    public int getPointsPerGoal() {
        return 1;
    }

    @Override
    public Integer getMaxNumberOfPlayersInATeam() {
        return 4;
    }
}
