package tracker;

public class CommentAttachment extends Attachment {
    private final String comments;

    public CommentAttachment(String comments) {

        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Комментарий: "+comments;
    }
}
