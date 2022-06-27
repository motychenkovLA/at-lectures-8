package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // todo 0 - транслит лучше не использовать + это не описание, это сканер
        Scanner opisanieDefecta = new Scanner(System.in);
        // todo 1 - объявление оторвано от инициации
        String bug;
//process
        System.out.println("Хаюшки! Что у тебя за дефект?");
        String bugName = opisanieDefecta.nextLine();
        System.out.println("Укажи критичность дефекта :\n" + "high\n" + "medium\n" + "low");
        String bugLevel = opisanieDefecta.nextLine();
        System.out.println("Ожидаемый срок исправления в днях:");
        int bugTime = opisanieDefecta.nextInt();
        opisanieDefecta.nextLine();
        // todo 3 - код стайл не как у констант
        final int rabochayaNedelya = 5;
        bug = "Ваш дефект:\n" + bugName + "\n" + "Критичность - " + bugLevel + "\n" + "Срок исправления - " + bugTime + "\n";
        // todo 3 - if не входит во вторую лекцию
        if (bugTime <= rabochayaNedelya) {
            System.out.println(bug + "Успеем поправить за неделю");
        } else {
            System.out.println(bug + "Потребуется больше рабочей недели на исправление");
        }
    }
}
