package tracker;

import java.util.Objects;

public class DefectAttachment extends Attachment{

    public long defectAttachment;

    public DefectAttachment (long defectAttachment) {
        this.defectAttachment = defectAttachment;
    }

    @Override
    public String toString() {
        return " | Вложение-ссылка: " + this.defectAttachment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DefectAttachment)) return false;
        DefectAttachment that = (DefectAttachment) o;
        return defectAttachment == that.defectAttachment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(defectAttachment);
    }
}
