package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Talk = new Scanner(System.in);
        String bug;
//process
        System.out.println("Хаюшки! Что у тебя за дефект?");
        String bug_name = Talk.next();
        System.out.println("Укажи критичность дефекта :\n" + "high\n" + "medium\n" + "low");
        String bug_level = Talk.next();
        System.out.println("Ожидаемый срок исправления в днях:");
        int bug_time = Talk.nextInt();
        System.out.println(
                "Ваш дефект:\n" +
                        bug_name + "\n" +
                        "Критичность - " + bug_level + "\n" +
                        "Срок исправления - " + bug_time
        );
        boolean weekIsEnough = (bug_time > 7) ? false : true;
        System.out.println("Хватит недельки - " + weekIsEnough);
    }
}
