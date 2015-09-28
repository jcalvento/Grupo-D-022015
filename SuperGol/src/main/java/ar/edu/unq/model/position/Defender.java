package ar.edu.unq.model.position;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="position")
@DiscriminatorValue("Defender")
public class Defender extends Position {

    @Override
    public int getPointsPerGoal() {
        return 3;
    }

    @Override
    public Integer getMaxNumberOfPlayersInATeam() {
        return 3;
    }
}
