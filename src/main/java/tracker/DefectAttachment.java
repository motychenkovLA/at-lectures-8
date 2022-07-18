package tracker;

public class DefectAttachment extends Attachment {
    private final long idDefect;

    public DefectAttachment(long idDefect) {
        this.idDefect = idDefect;
    }

    @Override
    public String asString() {
        return "id другого дефекта: "+Long.toString(idDefect);
    }
}
