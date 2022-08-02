package tracker;

public class CommentAttachment implements Attachment {
    public String commentAttachment;

    public CommentAttachment(String CommentAttachment) {
        this.commentAttachment = CommentAttachment;
    }

    @Override
    public String toString() {
        return " | Комментарий: " + commentAttachment;
    }

}
