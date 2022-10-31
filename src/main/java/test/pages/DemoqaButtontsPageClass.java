package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoqaButtontsPageClass {

    private static final By doubleClickMeButtonLocator = By.xpath("//button[@id=\"doubleClickBtn\"]");
    private static final By rightClickMeButtonLocator = By.xpath("//button[@id=\"rightClickBtn\"]");
    private static final By clickMeButtonLocator = By.xpath("//button[text()=\"Click Me\"]");
    private static final By doubleClickMessageLocator = By.xpath("//p[@id=\"doubleClickMessage\"]");
    private static final By rightClickMessageLocator = By.xpath("//p[@id=\"rightClickMessage\"]");
    private static final By dynamicClickMessage = By.xpath("//p[@id=\"dynamicClickMessage\"]");

    private final WebDriver webDriver;

    public DemoqaButtontsPageClass(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void doubleClick(){
        Actions actions = new Actions(webDriver);
        actions.doubleClick(webDriver.findElement(doubleClickMeButtonLocator))
                .build()
                .perform();
    }

    public void contextClick(){
        Actions actions = new Actions(webDriver);
        actions.contextClick(webDriver.findElement(rightClickMeButtonLocator))
                .build()
                .perform();
    }

    public void click(){
        Actions actions = new Actions(webDriver);
        actions.click(webDriver.findElement(clickMeButtonLocator))
                .build()
                .perform();
    }

    public void doubleClickMessageCheck () {
        if (!webDriver.findElements(doubleClickMessageLocator).isEmpty()) {
            System.out.println("Тест с двойныйм нажатием пройден!");
        } else {
            System.out.println("Тест с двойныйм нажатием провален!");
        }
    }

    public void rightClickMessageCheck () {
        if (!webDriver.findElements(rightClickMessageLocator).isEmpty()) {
            System.out.println("Тест с нажатием правой кнопкой пройден!");
        } else {
            System.out.println("Тест с нажатием правой кнопкой провален!");
        }
    }

    public void dynamicClickMessageCheck () {
        if (!webDriver.findElements(dynamicClickMessage).isEmpty()) {
            System.out.println("Тест с нажатием левой кнопкой пройден!");
        } else {
            System.out.println("Тест с нажатием левой кнопкой провален!");
        }
    }
}
