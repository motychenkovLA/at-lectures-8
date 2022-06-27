package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // todo 0 - название переменной не по код стайлу
        Scanner Talk = new Scanner(System.in);
        // todo 1 - переменная не используется
        String bug;
//process
        System.out.println("Хаюшки! Что у тебя за дефект?");
        // todo 0 - название переменной не по код стайлу
        // todo 3 - лучше использовать nextLine
        String bug_name = Talk.next();
        System.out.println("Укажи критичность дефекта :\n" + "high\n" + "medium\n" + "low");
        // todo 0 - название переменной не по код стайлу
        String bug_level = Talk.next();
        System.out.println("Ожидаемый срок исправления в днях:");
        // todo 0 - название переменной не по код стайлу
        int bug_time = Talk.nextInt();
        // todo 3 - нет переноса курсора чтения после nextInt
        // todo 3 - займет больше недели надо в ту же строку вывести бы
        System.out.println(
                "Ваш дефект:\n" +
                        bug_name + "\n" +
                        "Критичность - " + bug_level + "\n" +
                        "Срок исправления - " + bug_time
        );
        // todo 0 - рабочая неделя 5 дней
        // todo 3 - длина рабочей недели это константа
        // todo 3 - очень сложное преобразование булеана в самого себя
        boolean weekIsEnough = (bug_time > 7) ? false : true;
        System.out.println("Хватит недельки - " + weekIsEnough);
    }
}
