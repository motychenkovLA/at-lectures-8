package tracker;

public class Attachment {
    protected String comment;
    protected int idDefect;

    @Override
    public String toString() {
        return comment != null ? comment : String.valueOf(idDefect);
    }

    public Attachment(String comment) {
        this.comment = comment;
    }

    public Attachment(int idDefect) {
        this.idDefect = idDefect;
    }
}
