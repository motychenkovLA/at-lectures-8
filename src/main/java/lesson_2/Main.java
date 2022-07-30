package lesson_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // todo 1 - однобуквенное название
        Scanner s = new Scanner(System.in);
        System.out.println("введите резюме деффекта");
        String  resume = s.nextLine();
        System.out.println("введите критичность деффекта");
        System.out.println("блокирующий, критический, незначительный");
        String  critical = s.nextLine();
        System.out.println("введите ожидаемое количество дней на исправление");
        int days = Integer.parseInt(s.nextLine()); // преобразуем кол-во дней из строкового типа в целоцисленный
        // todo 3 - по ТЗ нужно вывести true / false
        // todo 3 - if не входит во вторую лекцию
        // todo 3 - 5 это константа
        String daysOut;
        if (days > 5) {
            daysOut = "займет больше рабочей недели";
        } else {
            daysOut = "займет меньше рабочей недели";
        }
        System.out.println(resume + " | " + critical + " | " + days + " | " + daysOut );
    }
}
