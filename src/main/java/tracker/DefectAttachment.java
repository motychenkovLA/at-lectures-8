package tracker;

public class DefectAttachment extends Attachment{

    protected final long idDefects;

    public DefectAttachment(long idDefects) {
        this.idDefects = idDefects;
    }

    @Override
    public String asString () {
        return Long.toString(idDefects);
    }
}
