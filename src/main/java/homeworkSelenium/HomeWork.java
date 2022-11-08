package homeworkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class HomeWork {
    public static void main(String[] args) {
        homeWork1();
        homeWork2();
        homeWork3();
    }

    public static void homeWork1() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/homeworkSelenium/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.get("https://demoqa.com/buttons");

        ButtonPageClass buttonPage = new ButtonPageClass(webDriver);
        buttonPage.doubleClick();
        buttonPage.checkDoubleClick();

        buttonPage.rightClick();
        buttonPage.checkRightClick();

        buttonPage.leftClick();
        buttonPage.checkLeftClick();

        webDriver.quit();
    }

    public static void homeWork2 () {
        System.setProperty("webdriver.chrome.driver", "src/main/java/homeworkSelenium/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        webDriver.get("https://demoqa.com/alerts");

        AlertPageClass alertPage = new AlertPageClass(webDriver);
        alertPage.alertButtonClick();
        alertPage.timerAlertButtonClick();
        alertPage.confirmButtonClick();

        alertPage.checkConfirmResult();

        webDriver.quit();
    }

    public static void homeWork3 () {
        System.setProperty("webdriver.chrome.driver", "src/main/java/homeworkSelenium/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://demoqa.com/browser-windows");
        String demoQATab = webDriver.getWindowHandle();

        NewPageClass newPageClass = new NewPageClass(webDriver);
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
