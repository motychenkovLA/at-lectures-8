package tracker;

public class DefectAttachment extends Attachment{

    protected int link;

    public DefectAttachment(int link) {
        this.link = link;
    }

    @Override
    public String asString() {
        return Integer.toString(link);
    }


}
