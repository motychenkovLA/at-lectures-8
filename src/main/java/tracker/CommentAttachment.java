package tracker;

public class CommentAttachment extends Attachment {

    public CommentAttachment(String comment) {
        super(comment);
    }

    @Override
    public String asString() {
        return comment;
    }
}
