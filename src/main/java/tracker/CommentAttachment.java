package tracker;

import java.util.Objects;

public class CommentAttachment extends Attachment {
    private final String comments;

    public CommentAttachment(String comments) {

        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentAttachment that = (CommentAttachment) o;
        return comments.equals(that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comments);
    }

    @Override
    public String toString() {
        return "Комментарий: " + comments;
    }
}
