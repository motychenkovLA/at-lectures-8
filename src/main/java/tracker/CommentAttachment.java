package tracker;

import java.util.Objects;

public class CommentAttachment extends Attachment {

    public String commentAttachment;

    public CommentAttachment (String commentAttachment) {
        this.commentAttachment = commentAttachment;
    }

    @Override
    public String toString() {
        return " | Вложение-комментарий: " + this.commentAttachment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentAttachment that = (CommentAttachment) o;
        return Objects.equals(commentAttachment, that.commentAttachment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentAttachment);
    }
}
