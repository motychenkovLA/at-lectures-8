package tracker;

public class Attachment {
    protected String comment;
    protected long idDefects;

    public Attachment(String comment) {
        this.comment = comment;

    }
    public Attachment(long idDefects) {
        this.idDefects = idDefects;
    }

    public String asString(){
        return comment + idDefects;
    }
}
