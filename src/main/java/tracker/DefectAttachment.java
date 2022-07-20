package tracker;

public class DefectAttachment extends Attachment {

    int idDefect;

    @Override
    public String toString() {
        return String.valueOf(idDefect);
    }

    public DefectAttachment(int idDefect) {
        this.idDefect = idDefect;
    }
}
