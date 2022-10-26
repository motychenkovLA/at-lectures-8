package selenium;

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

public class Main {

    public static void main(String[] args) {

        firstTask();
        secondTask();
        thirdTask();

    }

    public static void firstTask() {

        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        webDriver.get("https://demoqa.com/buttons");
        WebElement doubleClickMeButton = webDriver.findElement(By.xpath("//button[@id=\"doubleClickBtn\"]"));
        WebElement rightClickMeButton = webDriver.findElement(By.xpath("//button[@id=\"rightClickBtn\"]"));
        WebElement clickMeButton = webDriver.findElement(By.xpath("//button[text()=\"Click Me\"]"));

        Actions actions = new Actions(webDriver);
        actions.doubleClick(doubleClickMeButton)
                .build()
                .perform();

        actions.contextClick(rightClickMeButton)
                .build()
                .perform();

        actions.click(clickMeButton)
                .build()
                .perform();

        if (!webDriver.findElements(By.xpath("//p[@id=\"doubleClickMessage\"]")).isEmpty()) {
            System.out.println("Тест с двойныйм нажатием пройден!");
        } else {
            System.out.println("Тест с двойныйм нажатием провален!");
        }

        if (!webDriver.findElements(By.xpath("//p[@id=\"rightClickMessage\"]")).isEmpty()) {
            System.out.println("Тест с нажатием правой кнопкой пройден!");
        } else {
            System.out.println("Тест с нажатием правой кнопкой провален!");
        }

        if (!webDriver.findElements(By.xpath("//p[@id=\"dynamicClickMessage\"]")).isEmpty()) {
            System.out.println("Тест с нажатием левой кнопкой пройден!");
        } else {
            System.out.println("Тест с нажатием левой кнопкой провален!");
        }

        webDriver.quit();
    }

    public static void secondTask() {

        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        webDriver.get("https://demoqa.com/alerts");

        WebElement alertButton = webDriver.findElement(By.xpath("//button[@id=\"alertButton\"]"));
        alertButton.click();
        webDriver.switchTo().alert().accept();

        WebElement timerAlertButton = webDriver.findElement(By.xpath("//button[@id=\"timerAlertButton\"]"));
        timerAlertButton.click();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo().alert().accept();

        WebElement confirmButton = webDriver.findElement(By.xpath("//button[@id=\"confirmButton\"]"));
        confirmButton.click();
        webDriver.switchTo().alert().dismiss();

        if (!webDriver.findElements(By.xpath("//span[@id=\"confirmResult\"]")).isEmpty()) {
            System.out.println("Текст 'You selected Cancel' появился!");
        } else {
            System.out.println("Текст 'You selected Cancel' не появился!");
        }
        webDriver.quit();
    }

    public static void thirdTask() {

        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        webDriver.get("https://demoqa.com/browser-windows");
        String demoqaID = webDriver.getWindowHandle();

        WebElement tabButton = webDriver.findElement(By.xpath("//button[@id=\"tabButton\"]"));
        tabButton.click();

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