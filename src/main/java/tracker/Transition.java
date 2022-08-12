package tracker;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Transition {

    private final Status from;
    private final Status to;
    private static final Set <Transition> listTransition = new HashSet<>();

    static {

        listTransition.add(new Transition(Status.OPEN, Status.PROGRESS));
        listTransition.add(new Transition(Status.OPEN, Status.CLOSED));
        listTransition.add(new Transition(Status.PROGRESS, Status.TESTING));
        listTransition.add(new Transition(Status.TESTING, Status.CLOSED));
        listTransition.add(new Transition(Status.TESTING, Status.PROGRESS));

    }

    public Transition(Status from, Status to) {
        this.from = from;
        this.to = to;
    }

    public Status getFrom() {
        return from;
    }

    public Status getTo() {
        return to;
    }

     public static boolean checkTransitions(Status statusFrom, Status statusTo) {
         return listTransition.contains(new Transition(statusFrom, statusTo));
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
