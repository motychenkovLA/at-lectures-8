package tracker;

public class CommentAttachment extends Attachment{
public String commentAttachment;

public CommentAttachment (String CommentAttachment) {
this.commentAttachment = CommentAttachment;
}
@Override
public String asString () {
    return " | Комментарий: " + commentAttachment;
}

}
