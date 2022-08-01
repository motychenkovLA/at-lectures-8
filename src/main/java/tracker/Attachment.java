package tracker;

// todo 5 - выполняет роль всех возможных аттачментов сразу, не понятно зачем тогда вообще наследники
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
