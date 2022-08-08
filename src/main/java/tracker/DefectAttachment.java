package tracker;

import java.util.Objects;

public class DefectAttachment extends Attachment {

    // todo * - private final
    int idDefect;

    @Override
    public String toString() {
        return String.valueOf(idDefect);
    }

    // todo * - конструкторы объявляют до методов
    public DefectAttachment(int idDefect) {
        this.idDefect = idDefect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DefectAttachment that = (DefectAttachment) o;
        return idDefect == that.idDefect;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idDefect);
    }
}
