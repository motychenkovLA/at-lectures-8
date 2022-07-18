package tracker;

public class Attachment {
    protected String comment;
    protected int idDefect;

    public String asString() {
        return comment != null ? comment : String.valueOf(idDefect);
    }

    public Attachment(String comment) {
        this.comment = comment;
    }

    public Attachment(int idDefect) {
        this.idDefect = idDefect;
    }
}
