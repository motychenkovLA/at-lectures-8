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
        final int WORKING_WEEK = 5;
        String bug = "Ваш дефект:\n" + bugName + "\n" + "Критичность - " + bugLevel + "\n"
                + "Срок исправления - " + bugTime + "\n";
        // todo 3 - булеан превращается сам в себя
        boolean enoughTime = bugTime<=WORKING_WEEK ? true:false;

        System.out.println(bug + "Будет исправлено в течение рабочей недели (5 дн) - " + enoughTime);
    }
}
