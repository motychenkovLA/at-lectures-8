package tracker;

import java.util.Objects;

public class DefectAttachment extends Attachment{

    protected final long idDefects;

    public DefectAttachment(long idDefects) {
        this.idDefects = idDefects;
    }
    @Override
    public String toString () {
        return Long.toString(idDefects);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefectAttachment that = (DefectAttachment) o;
        return idDefects == that.idDefects;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDefects);
    }
}
