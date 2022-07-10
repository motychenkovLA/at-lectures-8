package tracker;

public class Defect {
    long id;
    String resumes;
    String priorities;
    int days;

    static int number = 1000000;


    public Defect(String resumes, String priorities, int days) {
        this.resumes = resumes;
        this.priorities = priorities;
        this.days = days;
        id = number++;
    }

    String getDefects() {
        return id + " | " + resumes + " | " + priorities + " | " + days;
    }


}
