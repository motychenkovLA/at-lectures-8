package tracker;

import java.util.*;

public class Transition {
    private final Status from;
    private final Status to;

    private static final Set<Transition> transitions = new HashSet<>();

    public Transition(Status from, Status to) {
        this.from = from;
        this.to = to;
    }

    static {
        transitions.add(new Transition(Status.OPEN, Status.REVIEW));
        transitions.add(new Transition(Status.REVIEW, Status.IN_PROGRESS));
        transitions.add(new Transition(Status.IN_PROGRESS, Status.REVIEW));
        transitions.add(new Transition(Status.OPEN, Status.IN_PROGRESS));
        transitions.add(new Transition(Status.OPEN, Status.CLOSE));
        transitions.add(new Transition(Status.REVIEW, Status.CLOSE));
        transitions.add(new Transition(Status.IN_PROGRESS, Status.CLOSE));
    }

    public static boolean checkTransition(Status from, Status to){
        return transitions.contains(new Transition(from, to));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transition that = (Transition) o;
        return from == that.from && to == that.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
