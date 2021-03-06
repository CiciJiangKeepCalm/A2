package rockets.model;

import com.google.common.collect.Sets;

import java.util.Objects;
import java.util.Set;

public class RocketFamily {
    private String name;

    private Set<Rocket> rockets;

    public RocketFamily(String name) {

        if (onlyCharacter(name) && isInRange(name,20) ) {
            this.name = name;

            rockets = Sets.newLinkedHashSet();// new}
        }
        else {
            throw new IllegalArgumentException("Rocket family name should only contains alphabetic characters and  under 20 characters");
        }
    }

    public boolean isInRange(String input, int i) {

        return input.length()<=i;
    }

    public boolean onlyCharacter(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public String getName() {
        return name;
    }
    public Set<Rocket> getRockets() {
        return rockets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RocketFamily that = (RocketFamily) o;
        return
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
