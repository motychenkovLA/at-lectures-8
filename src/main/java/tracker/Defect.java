package tracker;

public class Defect {
    private long id;
    private String resume;
    private String criticality;
    private int amountForCorrect;

    public Defect(long id, String resume, String criticality, int amountForCorrect) {
        this.id = id;
        this.resume = resume;
        this.criticality = criticality;
        this.amountForCorrect = amountForCorrect;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getCriticality() {
        return criticality;
    }

    public void setCriticality(String criticality) {
        this.criticality = criticality;
    }

    public int getAmountForCorrect() {
        return amountForCorrect;
    }

    public void setAmountForCorrect(int amountForCorrect) {
        this.amountForCorrect = amountForCorrect;
    }
}
