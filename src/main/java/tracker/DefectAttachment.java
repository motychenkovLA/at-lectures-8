package tracker;

public class DefectAttachment extends Attachment{

    public long defectAttachment;

    public DefectAttachment (long defectAttachment) {
        this.defectAttachment = defectAttachment;
    }

    @Override
    public String toString() {
        return " | Вложение-ссылка: " + this.defectAttachment;
    }
}
