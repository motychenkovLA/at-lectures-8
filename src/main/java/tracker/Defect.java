package tracker;

public class Defect {
    long id;
    String resumes; // todo 0 - resume, единственное число
    String priorities; // todo 0 - priority, единственное число
    int days;

    static int number = 1000000; // todo ? - не часть 4 лекции, но в следующем дз все равно так будет


    public Defect(String resumes, String priorities, int days) {
        this.resumes = resumes;
        this.priorities = priorities;
        this.days = days;
        id = number++;
    }

    // todo 0 - get defectS, при этом возвращает одну строку а не массив дефектов
    String getDefects() {
        return id + " | " + resumes + " | " + priorities + " | " + days;
    }


}
