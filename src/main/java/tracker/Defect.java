package tracker;

import java.util.Objects;

public class Defect {
    // todo * - немного обманывающие названия, лучше last/next/currentId для static и просто id для самого дефекта
    private static long id = 1000000;
    private final long objectId = id; // todo * - objectId инициализируется здесь,
                                      //   а id увеличивается в конструкторе, связанная логика разорвана по разным местам
    private String resume;
    private Criticality criticality;
    private int amountForCorrect;
    private Attachment attachment;
    private StatusDefect status = StatusDefect.OPEN;

    public Defect(String resume, Criticality criticality, int amountForCorrect, Attachment attachment) {
        this.resume = resume;
        this.criticality = criticality;
        this.amountForCorrect = amountForCorrect;
        this.attachment = attachment;
        id++;
    }

    // todo * - дефект не должен ничего печатать, консоль не его ответственность
    public void printCriticality() {
        for (Criticality criticalityDefect : Criticality.values()) {
            System.out.println(criticalityDefect);
        }
    }

    public long getId() {
        return objectId;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Criticality getCriticality() {
        return criticality;
    }

    public void setCriticality(Criticality criticality) {
        this.criticality = criticality;
    }

    public int getAmountForCorrect() {
        return amountForCorrect;
    }

    public void setAmountForCorrect(int amountForCorrect) {
        this.amountForCorrect = amountForCorrect;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public StatusDefect getStatus() {
        return status;
    }

    public void setStatus(StatusDefect status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Defect defect = (Defect) o;
        return objectId == defect.objectId
                && amountForCorrect == defect.amountForCorrect
                && resume.equals(defect.resume)
                && criticality == defect.criticality
                && attachment.equals(defect.attachment)
                && status == defect.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectId, resume, criticality, amountForCorrect, attachment, status);
    }
}
