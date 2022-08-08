package tracker;

import java.util.Objects;

public class CommentAttachment extends Attachment {

    // todo * - private final
    String comment;

    @Override
    public String toString() {
        return comment;
    }

    // todo * - конструкторы объявляют до методов
    public CommentAttachment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CommentAttachment that = (CommentAttachment) o;
        return comment.equals(that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), comment);
    }
}
