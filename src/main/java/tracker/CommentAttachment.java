package tracker;

public class CommentAttachment extends Attachment {
    private final String comments;

    public CommentAttachment(String comments) {
        this.comments = comments;
    }

    @Override
    public String asString() {
        // todo 1 - в такой реализации не особо видна разница между комментом и дефектом,
        //  тут бы какой-нибудь префикс типа "коммент: ..."
        return comments;
    }
}
