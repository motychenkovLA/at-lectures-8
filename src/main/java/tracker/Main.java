package tracker;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean run = true;
        final int COUNTOFDEFECTS = 10; //максимальное число хранимых дефектов в программе
        Repository repository = new Repository(COUNTOFDEFECTS);

        while (run) {
            System.out.println("Введите команду для выбора действия. \n add - Добавить новый дефект." +
                    " \n list - Вывод списка дефектов. \n change - Изменить статус дефекта. \n quit - Выход.");
            String choice = scan.nextLine();

            switch (choice) {
                case "add": {
                    if (repository.addNewDefect()) {

                        System.out.println("Введите резюме дефекта:");
                        String resume = scan.nextLine();

                        System.out.println("Введите критичность дефекта:"  + Arrays.toString(Severity.values()));
                        //String severity = scan.nextLine();
                        Severity severity = Severity.valueOf(scan.nextLine());

                        System.out.println("Введите ожидаемое количество дней на исправление дефекта.");
                        int days = scan.nextInt();
                        scan.nextLine();

                        System.out.println("Выберите тип вложения: \n comment - Комментарий. +" +
                                "\n link - Ссылка на другой дефект");
                        String attachmentType = scan.nextLine();
                        Attachment attachment = null;
                        if (attachmentType.equals("comment")) {
                            System.out.println("Введите комментарий к дефекту:");
                            String comment = scan.nextLine();
                            attachment = new CommentAttachment(comment);
                        }
                        else {
                            System.out.println("Введите ссылку на другой дефект:");
                            int link = scan.nextInt();
                            attachment = new DefectAttachment(link);
                            scan.nextLine();
                        }

                        Defect defect = new Defect(resume, severity, days, attachment);
                        System.out.println("Дефект добавлен.");
                        repository.add(defect);
                    }
                    else {
                        System.out.print("Заведено максимальное количество дефектов. ");
                    }
                    break;
                }

                case "list": {
                    Defect [] defectsArray = repository.getAll();
                    for (Defect defForOut: defectsArray) {
                        System.out.println(defForOut.getInfo());
                    }
                    break;
                }

                case "change":{
                    if(repository.getCount() == 0){
                        System.out.println("В системе нет дефектов. ");
                    } else {
                        System.out.println("Введите ссылку на дефект.");
                        long id = scan.nextLong();
                        Defect [] changeStatus = repository.getAll();
                        for (Defect defectForChange : changeStatus)
                            if (id != defectForChange.getID()){
                                System.out.println("Дефекта с такой ссылкой не существует.");
                            } else {
                                System.out.println("Введите критичность дефекта:"  + Arrays.toString(Status.values()));
                                String severity = scan.nextLine();
                                Status status = Status.valueOf(scan.nextLine());
                                defectForChange.setStatus(status);
                                System.out.println("Статус дефекта " + id +" изменён.");
                            }
                    }
                    break;
                }

                case "quit": {
                    run = false;
                    System.out.println("Вы вышли из главного меню. ");
                    break;
                }

                default: {
                    System.out.println("Неверно введена команда. ");
                    break;
                }
            }
        }
    }
}