package homeworkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ButtonPageClass {
    WebDriver webDriver;
    private static final By doubleClickBtn = By.xpath("//*[@id=\"doubleClickBtn\"]");
    private static final By rightClickBtn = By.xpath("//*[@id=\"rightClickBtn\"]");
    private static final By leftClickBtn = By.xpath("//button[text()=\"Click Me\"]");

    private static final By doubleClickMessage = By.xpath("//*[@id=\"doubleClickMessage\"]");
    private static final By rightClickMessage = By.xpath("//*[@id=\"rightClickMessage\"]");
    private static final By leftClickMessage = By.xpath("//*[@id=\"dynamicClickMessage\"]");


    public ButtonPageClass(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void doubleClick () {
        Actions actions = new Actions(webDriver);
        actions.doubleClick(webDriver.findElement(doubleClickBtn))
                .build()
                .perform();
    }

    public void checkDoubleClick () {
        if (!webDriver.findElements(doubleClickMessage).isEmpty()){
            System.out.println("Тест doubleClickCheck пройден");
        } else {
            System.out.println("Тест doubleClickCheck не пройден");
        }
    }

    public void rightClick () {
        Actions actions = new Actions(webDriver);
        actions.contextClick(webDriver.findElement(rightClickBtn))
                .build()
                .perform();
    }

    public void checkRightClick () {
        if (!webDriver.findElements(rightClickMessage).isEmpty()){
            System.out.println("Тест checkRightClick пройден");
        } else {
            System.out.println("Тест checkRightClick не пройден");
        }
    }

    public void leftClick () {
        Actions actions = new Actions(webDriver);
        actions.click(webDriver.findElement(leftClickBtn))
                .build()
                .perform();
    }
    public void checkLeftClick () {
        if (!webDriver.findElements(leftClickMessage).isEmpty()){
            System.out.println("Тест checkLeftClick пройден");
        } else {
            System.out.println("Тест checkLeftClick не пройден");
        }
    }


}
