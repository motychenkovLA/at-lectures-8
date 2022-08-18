package tracker;

import java.util.HashSet;
import java.util.Set;

public class TransitionAction {

    Set<Transition> transitions = new HashSet<>();

    public TransitionAction(){
        transitions.add(new Transition(StatusDefect.OPEN, StatusDefect.ANALYSIS));
        transitions.add(new Transition(StatusDefect.OPEN, StatusDefect.CORRECTION));
        transitions.add(new Transition(StatusDefect.OPEN, StatusDefect.TESTING));
        transitions.add(new Transition(StatusDefect.OPEN, StatusDefect.CLOSE));
        transitions.add(new Transition(StatusDefect.ANALYSIS, StatusDefect.CORRECTION));
        transitions.add(new Transition(StatusDefect.ANALYSIS, StatusDefect.CLOSE));
        transitions.add(new Transition(StatusDefect.CORRECTION, StatusDefect.TESTING));
        transitions.add(new Transition(StatusDefect.CORRECTION, StatusDefect.TESTING));
        transitions.add(new Transition(StatusDefect.TESTING, StatusDefect.ANALYSIS));
        transitions.add(new Transition(StatusDefect.TESTING, StatusDefect.CORRECTION));
        transitions.add(new Transition(StatusDefect.TESTING, StatusDefect.CLOSE));
        transitions.add(new Transition(StatusDefect.CLOSE, StatusDefect.OPEN));
    }

    public boolean correctTransition(StatusDefect fromStatus, StatusDefect toStatus) {
        for (Transition transition : transitions) {
            if (transition.getFromStatus().equals(fromStatus) && transition.getToStatus().equals(toStatus)) {
                return true;
            }
        }
        return false;
    }

}
