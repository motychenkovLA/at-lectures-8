package homeworkSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class HomeWork {
    public static void main(String[] args) {
        //homeWork1();
        //homeWork2();
        //homeWork3();
    }

    public static void homeWork1() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/homeworkSelenium/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.get("https://demoqa.com/buttons");

        ButtonPageClass buttonPage = new ButtonPageClass(webDriver);
        ChecksClass checks = new ChecksClass(webDriver);

        buttonPage.doubleClick();
        if (!checks.checkDoubleClick()) {
            System.out.println("Тест doubleClickCheck пройден");
        } else {
            System.out.println("Тест doubleClickCheck не пройден");
        }

        buttonPage.rightClick();
        if (!checks.checkRightClick()) {
            System.out.println("Тест checkRightClick пройден");
        } else {
            System.out.println("Тест checkRightClick не пройден");
        }

        buttonPage.leftClick();
        if (!checks.checkLeftClick()) {
            System.out.println("Тест checkLeftClick пройден");
        } else {
            System.out.println("Тест checkLeftClick не пройден");
            }

        webDriver.quit();
    }

    public static void homeWork2 () {
        System.setProperty("webdriver.chrome.driver", "src/main/java/homeworkSelenium/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        webDriver.get("https://demoqa.com/alerts");

        AlertPageClass alertPage = new AlertPageClass(webDriver);
        ChecksClass checks = new ChecksClass(webDriver);

        alertPage.alertButtonClick();
        alertPage.timerAlertButtonClick();
        alertPage.confirmButtonClick();

        if (!checks.checkConfirmResult()) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");
        }

        webDriver.quit();
    }

    public static void homeWork3 () {
        System.setProperty("webdriver.chrome.driver", "src/main/java/homeworkSelenium/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://demoqa.com/browser-windows");
        String demoQATab = webDriver.getWindowHandle();

        BrowseNewPageClass newPageClass = new BrowseNewPageClass(webDriver);
        newPageClass.tabButtonClick();

        Set<String> handles = webDriver.getWindowHandles();
        handles.remove(demoQATab);
        Iterator<String> iterator = handles.iterator();
        String newTab = iterator.next();
        webDriver.switchTo().window(newTab);
        webDriver.get("https://google.com");
        webDriver.switchTo().window(demoQATab);

        webDriver.quit();
    }
}
