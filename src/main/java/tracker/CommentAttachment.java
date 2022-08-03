package tracker;

public class CommentAttachment extends Attachment {

    String comment;

    @Override
    public String toString() {
        return comment;
    }

    public CommentAttachment(String comment) {
        this.comment = comment;
    }
}