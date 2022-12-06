package tracker;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Transition {

    private final Status from;
    private final Status to;
    public static final Set<Transition> SET_TRANSITION = new HashSet<>();

    public Transition(Status from, Status to) {
        this.from = from;
        this.to = to;
    }

    static {
        SET_TRANSITION.add(new Transition(Status.OPEN, Status.ASSIGNED));
        SET_TRANSITION.add(new Transition(Status.ASSIGNED, Status.FIXED));
        SET_TRANSITION.add(new Transition(Status.FIXED, Status.VERIFIED));
        SET_TRANSITION.add(new Transition(Status.VERIFIED, Status.CLOSED));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transition transition = (Transition) o;
        return from == transition.from && to == transition.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}