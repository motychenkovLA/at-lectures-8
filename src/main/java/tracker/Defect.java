package tracker;

public class Defect {
    // todo 3 - дз: Инкапсулировать класс Defect
    long id; // todo 3 - дз: поле id сделать неизменяемым
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

    // todo 1 - подозрительный модификатор доступа
    // todo 1 - все еще не понятно почему название во множественном числе, если возвращается один объект
    String getFields() {
        return id + " | " + resume + " | " + priority + " | " + days;
    }
}
