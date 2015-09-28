package ar.edu.unq.model.position;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "position")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="discriminator",
        discriminatorType=DiscriminatorType.STRING
)
public abstract class Position {

    private static Set<Position> instances = new HashSet<>();

    public abstract int getPointsPerGoal();

    public abstract Integer getMaxNumberOfPlayersInATeam();

    public static Position forward() {
        return getInstanceOf(new Forward());
    }

    public static Position midfield() {
        return getInstanceOf(new Midfield());
    }

    public static Position goalKeeper() {
        return getInstanceOf(new GoalKeeper());
    }

    public static Position defender() {
        return getInstanceOf(new Defender());
    }

    private static Position getInstanceOf(Position anInstance) {
        List<Position> results = instances.stream()
                .filter(instance -> instance.getClass().equals(anInstance.getClass()))
                .collect(Collectors.toList());
        Position result;

        if(results.isEmpty()) {
            instances.add(anInstance);
            result = anInstance;
        } else {
            result = results.get(0);
        }

        return result;
    }

    public Integer pointsWhenScored(Integer aNumberOfGoals) {
        return getPointsPerGoal() * aNumberOfGoals;
    }
}
