package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите резюме дефекта");
        String rezume1 = scanner.nextLine();

        System.out.println("Введите критичность дефекта из списка High|Medium|Low");
        String critical1 = scanner.nextLine();

        System.out.println("Введите количество дней на исправление");
        int days1 = scanner.nextInt();

        boolean workdays = days1 > 5;

        System.out.print("|" + "Резюме:"+ rezume1 +"|"+"Серьезность:" + critical1 +"|" + "Количество дней на исправление:" + days1 +"|" + "Займет больше рабочей недели (true/false):" + workdays + "|");


    }
}


