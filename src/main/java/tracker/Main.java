package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int counter_defect = 10;
        String[] rezume1 = new String[counter_defect];
        String[] critical1 = new String[counter_defect];
        int[] workdays = new int[counter_defect];
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        int count1 = 0;
        while (run) {

            System.out.println("Главное меню:" + " Добавить новый дефект (add)" + "|" + "Вывести список дефектов (list)" + "|" + "Выйти из программы (quit)" + "|");
            switch (sc.nextLine()) {

                case "add":
                    if(count1 >= counter_defect) {
                        System.out.println("Достигнуто максимальное количество дефектов");
                        System.out.println();
                        break;
                    }
                    System.out.println("Введите резюме дефекта");
                    rezume1[count1] = sc.nextLine();
                    System.out.println("Введите критичность дефекта из списка High|Medium|Low");
                    critical1[count1] = sc.nextLine();
                    System.out.println("Введите количество дней на исправление");
                    workdays[count1] = sc.nextInt();
                    sc.nextLine();
                    count1++;
                    break;

                case "list":
                    for(int a = 0;a < count1;a++) {
                        System.out.println(rezume1[a] + "|" + critical1[a] + "|" +workdays[a]);
                    }
                    break;

                case "quit":
                    run = false;
                    break;
            }
        }

    }
}


