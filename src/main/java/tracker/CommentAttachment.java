package tracker;

public class CommentAttachment extends Attachment {

    protected final String comment;

    public CommentAttachment(String comment) {
        this.comment = comment;
    }

    // todo 1 - выравнивание
    @Override
        public String asString () {
            return comment;
        }
    }