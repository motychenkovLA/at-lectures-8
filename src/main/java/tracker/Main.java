package tracker;

//public class Main {
//      public static void main(String[] args) {
//        System.out.println("Hello world!!!!");
//    }

import java.util.Scanner; // импорт сканнера

public class Main {
    public static void main(String[] args) {
        boolean MainMenu = true;
        String[] massivD = new String[10];
        int i = 0;
        while (MainMenu) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите необходимое действие: \n" +
                    "add - добавить новый дефект \n" +
                    "list - вывести список зарегистрированных дефектов \n" +
                    "quit - выйти из программы");
            String defectAction = sc.nextLine();
            switch (defectAction) {
                case "add":
                    if (i >= 10) {
                        System.out.println("Вы ввели максимальное количество дефектов ");
                    } else {
                        System.out.println("Введите резолюцию по дефекту: ");
                        String defectResolution = sc.nextLine(); //считывает введеную строку в defectResolution
                        System.out.println("Введите критичность дефекта, выбери из списка: Критичный, Высокий, Средний, Низкий ");
                        String defectCritical = sc.nextLine();
                        System.out.println("Введите количество дней, необходимое на исправление дефекта: ");
                        int fixDay = sc.nextInt();//считывает число и присваивает значение в аixDay
                        massivD[i] = (defectResolution + "\n " + defectCritical + "\n на исправление уйдет " + fixDay + " дней");
                        i = ++i;
                        System.out.println("Дефект зарегистрирован! ");
                    }
                    break;
                case "list":
                    for (String a : massivD)
                        if (a != null)
                            System.out.println("Зарегистрирован дефект: \n" + a);
                    break;
                case "quit":
                    System.out.println("Пока!!! ");
                    break;
            }
        }
        //System.out.println("Вы ввели информацию по дефекту: " + DefectResolution);
        //System.out.println("Критичность дефекта: " + DefectCritical);
        //System.out.println("На его исправление потребуется " + FixDay + " дней ");
        //boolean Sravnenie = FixDay > 7;
        //System.out.println("Исправление по дефекту займет больше недели: " + Sravnenie);
    }
}


