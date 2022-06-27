package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // todo 0 - транслит лучше не использовать + это не описание, это сканер
        //done
        Scanner inputText = new Scanner(System.in);
        System.out.println("Хаюшки! Что у тебя за дефект?");
        String bugName = inputText.nextLine();
        System.out.println("Укажи критичность дефекта :\n" + "high\n" + "medium\n" + "low");
        String bugLevel = inputText.nextLine();
        System.out.println("Ожидаемый срок исправления в днях:");
        int bugTime = inputText.nextInt();
        inputText.nextLine();
        // todo 3 - код стайл не как у констант
        //done
        final int WORKING_WEEK = 5;
        // todo 1 - объявление оторвано от инициации
        //done
        String bug;
        bug = "Ваш дефект:\n" + bugName + "\n" + "Критичность - " + bugLevel + "\n" + "Срок исправления - " + bugTime + "\n";
        // todo 3 - if не входит во вторую лекцию
        //done
        String enoughTime = bugTime<=5 ? "Успеем поправить за неделю":"Потребуется больше рабочей недели на исправление";

        System.out.println(bug + enoughTime);
    }
}
