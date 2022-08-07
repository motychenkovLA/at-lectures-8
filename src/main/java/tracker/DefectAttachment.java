package tracker;

import java.util.Objects;

public class DefectAttachment extends Attachment {
    private final long idDefect;

    public DefectAttachment(long idDefect) {

        this.idDefect = idDefect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefectAttachment that = (DefectAttachment) o;
        return idDefect == that.idDefect;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDefect);
    }

    @Override
    public String toString() {
        return "id другого дефекта: " + Long.toString(idDefect);
    }
}
