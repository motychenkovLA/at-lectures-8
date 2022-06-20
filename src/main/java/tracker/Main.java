package tracker;

import java.util.Scanner;

public class Main {public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Добрый день! Вас приветствует Система автоматизированного заведения дефектов. Введите краткое описание дефекта:");
    String description = scan.nextLine();

    System.out.println("Отлично! Следующий шаг: введите критичность дефекта: ");
    System.out.println("(Доступны следующие варианты: Тривиальный, Незначительный, Значительный, Критический, Блокирующий)");
    String severity = scan.nextLine();

    System.out.println("Замечательно! Следующий шаг: введите ожидаемое количество дней на исправление дефекта: ");
    int numberOfDays = scan.nextInt();
    scan.nextLine();
    final int WORKWEEK = 5;
    boolean term = numberOfDays>WORKWEEK;

    System.out.println("Великолепно! Вы ввели следующую информацию по дефекту: ");
    System.out.println("Описание дефекта: " + description);
    System.out.println("Критичность дефекта: " + severity);
    System.out.println("Количество дней на исправление: " + numberOfDays);
    System.out.println("Исправление займёт больше рабочей недели: " + term);


}
}
