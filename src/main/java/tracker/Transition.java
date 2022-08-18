package tracker;

public class Transition {

    private StatusDefect fromStatus;
    private StatusDefect toStatus;

    public Transition(StatusDefect fromStatus, StatusDefect toStatus){
        this.fromStatus = fromStatus;
        this.toStatus = toStatus;
    }

    public StatusDefect getFromStatus(){
        return fromStatus;
    }

    public StatusDefect getToStatus(){
        return toStatus;
    }

}
