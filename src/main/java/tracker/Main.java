package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputText = new Scanner(System.in);
        System.out.println("Хаюшки! Что у тебя за дефект?");
        String bugName = inputText.nextLine();
        System.out.println("Укажи критичность дефекта :\n" + "high\n" + "medium\n" + "low");
        String bugLevel = inputText.nextLine();
        System.out.println("Ожидаемый срок исправления в днях:");
        int bugTime = inputText.nextInt();
        inputText.nextLine();
        // todo 3 - не используется
        final int WORKING_WEEK = 5;
        // todo 1 - объявление оторвано от инициации, +1
        String bug;
        // todo 0 - желательно не вылезать за белую полосу (120 символов) / край экрана
        bug = "Ваш дефект:\n" + bugName + "\n" + "Критичность - " + bugLevel + "\n" + "Срок исправления - " + bugTime + "\n";
        // todo 3 - ТЗ: "займет больше рабочей недели (true/false)", нужно выводить boolean, а не String
        String enoughTime = bugTime<=5 ? "Успеем поправить за неделю":"Потребуется больше рабочей недели на исправление";

        System.out.println(bug + enoughTime);
    }
}
