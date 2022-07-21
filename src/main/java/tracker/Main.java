package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int MAX_DEFECTS = 10;
        Repository repository = new Repository(MAX_DEFECTS);
        boolean work = true;
        while (work) {
            System.out.println("Вы находитесь в главном меню багтрекинговой системы. Выберите действие:" +
                    "\nДобавить новый дефект (введите команду add)" +
                    "\nВывести список дефектов (введите команду list)" +
                    "\nВернуться в главное меню (введите команду quit)");
            String command = scan.nextLine();
            switch (command) {
                case "add":
                    if (repository.isFilled()) {
                        //создаём переменную типа Defect и помещаем её в поле defects переменной repository
                        System.out.println("Введите краткое описание дефекта:");
                        String description = scan.nextLine();
                        System.out.println("Следующий шаг: введите критичность дефекта" +
                                "\n(Доступны следующие варианты: Тривиальный, Незначительный, Значительный, Критический, Блокирующий)");
                        String severity = scan.nextLine();
                        System.out.println("Следующий шаг: введите ожидаемое количество дней на исправление дефекта: ");
                        int numberOfDays = scan.nextInt();
                        scan.nextLine();
                        Defect defect = new Defect(description, severity, numberOfDays);
                        System.out.println("Вы ввели следующий дефект:");
                        System.out.println(defect.getInfoDefect());
                        repository.add(defect);
                    } else {
                        System.out.println("Закончилось место для заведения дефектов!");
                    }
                    break;
                case "list":
                    if (repository.getCount() == 0) {
                        System.out.println("Дефектов не заведено!");
                    } else {
                        System.out.println("Список заведённых дефектов (описание, критичность, кол-во дней на исправление):");
                        Defect [] defectsForArray = repository.getAll();
                        for (Defect defForOut: defectsForArray) {
                            System.out.println(defForOut.getInfoDefect());
                        }
                    }
                    break;
                case "quit":
                    System.out.println("Завершение работы программы");
                    work = false;
                    break;
                default:
                    System.out.println("Введена некорректная команда, возврат в главное меню");
                    break;
            }
        }
    }
}

