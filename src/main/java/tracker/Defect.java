package tracker;

public class Defect {
    long id;
    String resume;
    String priority;
    int days;

    static int number = 1000000;

    public Defect(String resume, String priority, int days) {
        this.resume = resume;
        this.priority = priority;
        this.days = days;
        id = number++;
    }

    // todo 3 - get defectS, при этом возвращает одну строку а не массив дефектов
    String getDefects() {
        return id + " | " + resume + " | " + priority + " | " + days;
    }
}
