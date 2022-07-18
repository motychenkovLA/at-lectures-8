package tracker;

public class CommentAttachment extends Attachment {

    public String commentAttachment;

    public CommentAttachment (String commentAttachment) {
        this.commentAttachment = commentAttachment;
    }

    @Override
    public String asString() {
        return " | Вложение-комментарий: " + this.commentAttachment;
    }
}
