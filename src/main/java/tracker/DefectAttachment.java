package tracker;

public class DefectAttachment extends Attachment {

    public DefectAttachment(int idDefect) {
        super(idDefect);
    }

    @Override
    public String asString() {
        return String.valueOf(idDefect);
    }
}
