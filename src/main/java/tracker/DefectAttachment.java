package tracker;

public class DefectAttachment implements Attachment {
    public long defectAttachment;

    public DefectAttachment(long defectAttachment) {
        this.defectAttachment = defectAttachment;
    }

    @Override
    public String toString() {
        return " | ID связанного дефекта: " + defectAttachment;
    }

}


