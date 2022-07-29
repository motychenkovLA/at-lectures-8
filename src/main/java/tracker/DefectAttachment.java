package tracker;

public class DefectAttachment extends Attachment{

    public DefectAttachment(long idDefects) {
        super(idDefects);
    }
    @Override
    public String asString () {
        return Long.toString(idDefects);
    }
}
