package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.pages.DemoqaAlertsPageClass;
import test.pages.DemoqaBrowserWindowsPageClass;
import test.pages.DemoqaButtontsPageClass;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        firstTask();
        secondTask();
        thirdTask();

    }

    public static void firstTask() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage()
                .timeouts()
                .pageLoadTimeout(Duration.ofSeconds(10));
        webDriver.get("https://demoqa.com/buttons");

        DemoqaButtontsPageClass demoqaButtontsPage = new DemoqaButtontsPageClass(webDriver);

        demoqaButtontsPage.doubleClick();
        demoqaButtontsPage.doubleClickMessageCheck();

        demoqaButtontsPage.contextClick();
        demoqaButtontsPage.rightClickMessageCheck();

        demoqaButtontsPage.click();
        demoqaButtontsPage.dynamicClickMessageCheck();

        webDriver.quit();
    }

    public static void secondTask() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage()
                .timeouts()
                .pageLoadTimeout(Duration.ofSeconds(10));
        webDriver.get("https://demoqa.com/alerts");

        DemoqaAlertsPageClass demoqaAlertsPage = new DemoqaAlertsPageClass(webDriver);

        demoqaAlertsPage.alertAccept();

        demoqaAlertsPage.timerAlertAccept();

        demoqaAlertsPage.alertDismiss();
        demoqaAlertsPage.alertDismissCheck();

        webDriver.quit();
    }

    public static void thirdTask() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        webDriver.get("https://demoqa.com/browser-windows");
        String demoqaID = webDriver.getWindowHandle();

        DemoqaBrowserWindowsPageClass demoqaBrowserWindowsPage = new DemoqaBrowserWindowsPageClass(webDriver);
        demoqaBrowserWindowsPage.tabButtonClick();

        Set<String> handles = webDriver.getWindowHandles();
        handles.remove(demoqaID);
        Iterator<String> iterator = handles.iterator();
        String googleID = iterator.next();

        webDriver.switchTo()
                .window(googleID)
                .get("https://www.google.com/");

        webDriver.switchTo()
                .window(demoqaID);

        webDriver.quit();
    }
}