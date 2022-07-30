package defect;

public class Main {
    public static void main(String[] args) {
        Defect defect = new Defect("не отображается кнопка просмотр", "критичный", 5);
        defect.getInfo();
        Defect defect_2 = new Defect("не отображается кнопка send", "критичный", 7);
        defect_2.getInfo();
    }
}
