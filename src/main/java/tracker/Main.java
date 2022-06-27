package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // todo 0 - название переменной не по код стайлу
        //изменила на opisanieDefecta
        Scanner opisanieDefecta = new Scanner(System.in);
        // todo 1 - переменная не используется
        //заиспользовала
        String bug;
//process
        System.out.println("Хаюшки! Что у тебя за дефект?");
        // todo 0 - название переменной не по код стайлу
        // todo 3 - лучше использовать nextLine
        //поменяла на bugName
        String bugName = opisanieDefecta.nextLine();
        System.out.println("Укажи критичность дефекта :\n" + "high\n" + "medium\n" + "low");
        // todo 0 - название переменной не по код стайлу
        //поменяла на bugLevel
        String bugLevel = opisanieDefecta.nextLine();
        System.out.println("Ожидаемый срок исправления в днях:");
        // todo 0 - название переменной не по код стайлу
        //поменяла на bugTime
        int bugTime = opisanieDefecta.nextInt();
        // todo 3 - нет переноса курсора чтения после nextInt
        opisanieDefecta.nextLine();
        // todo 0 - рабочая неделя 5 дней
        // todo 3 - длина рабочей недели это константа
        // todo 3 - очень сложное преобразование булеана в самого себя
        final int rabochayaNedelya = 5;
        bug = "Ваш дефект:\n" + bugName + "\n" + "Критичность - " + bugLevel + "\n" + "Срок исправления - " + bugTime + "\n";
        // todo 3 - займет больше недели надо в ту же строку вывести бы
        if (bugTime <= rabochayaNedelya) {
            System.out.println(bug + "Успеем поправить за неделю");
        } else {
            System.out.println(bug + "Потребуется больше рабочей недели на исправление");
        }
    }
}
