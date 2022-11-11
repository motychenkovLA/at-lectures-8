package homeworkSelenium;

public class ChecksClass {

    public static void check (boolean param) {
        if (!param) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");
        }
    }

//    public static void check (String expectedResult, String actualResult) {
//        if (expectedResult.equals(actualResult)) {
//            System.out.println("Тест пройден");
//        } else {
//            System.out.println("Тест не пройден");
//        }
//    }
}
