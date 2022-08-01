package tracker;

import java.util.Arrays;
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
                    "\nВернуться в главное меню (введите команду quit)" +
                    "\nИзменить статус дефекта (введите команду change)");
            String command = scan.nextLine();
            switch (command) {
                case "add":
                    if (repository.isNotFull()) {
                        //создаём переменную типа Defect и помещаем её в поле defects переменной repository
                        System.out.println("Введите краткое описание дефекта:");
                        String description = scan.nextLine();
                        System.out.println("Следующий шаг: введите критичность дефекта" +
                                "\n" + Arrays.toString(Severity.values()));
                        Severity severity = Severity.valueOf(scan.nextLine());
                        System.out.println("Следующий шаг: введите ожидаемое количество дней на исправление дефекта: ");
                        int numberOfDays = scan.nextInt();
                        scan.nextLine();
                        Attachment attachment = null;
                        //цикл для вложения
                        while (attachment == null) {
                            System.out.println("Выберите тип вложения: " +
                                    "\n" + "Введите команду comment для ввода комментария" +
                                    "\n" +"Введите команду link для ссылки на другой дефект");
                            String choiceOfAttachment = scan.nextLine();
                            switch (choiceOfAttachment) {
                                case "comment":
                                    System.out.println("Введите коммент к дефекту");
                                    String comment = scan.nextLine();
                                    attachment = new CommentAttachment(comment);
                                    break;
                                case "link":
                                    System.out.println("Введите ссылку на другой дефект");
                                    long link = scan.nextLong();
                                    scan.nextLine();
                                    attachment = new DefectAttachment(link);
                                    break;
                                default:
                                    System.out.println("Вы ввели некорректное значение!" + "\n");
                                    break;
                                }
                        }
                        Defect defect = new Defect(description, severity, numberOfDays, attachment);
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
                        System.out.println("Список заведённых дефектов (описание, критичность, кол-во дней на исправление, id, вложение, статус):");
                        Defect [] defectsForArray = repository.getAll();
                        for (Defect defForOut: defectsForArray) {
                            System.out.println(defForOut.getInfoDefect());
                        }
                    }
                    break;
                case "change":
                    if (repository.getCount() == 0) {
                        System.out.println("Дефектов не заведено!");
                    } else {
                        //меняем статус
                        System.out.println("Ввести id дефекта:");
                        long id = scan.nextLong();
                        scan.nextLine();
                        Defect[] arrayChangeStatus = repository.getAll();
                        for (Defect defForChange : arrayChangeStatus) {
                            if (id == defForChange.getId()) {
                                System.out.println("Ввести новый статус дефекта:" +
                                        "\n" + Arrays.toString(Status.values()));
                                Status status = Status.valueOf(scan.nextLine());
                                defForChange.setStatus(status);
                                System.out.println("Статус успешно изменён!");
                                System.out.println(" ");
                            } else {
                                System.out.println("Такого дефекта нет!");
                            }
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

