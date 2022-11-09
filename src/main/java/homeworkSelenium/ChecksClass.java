package homeworkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChecksClass {
    private static final By doubleClickMessage = By.xpath("//*[@id=\"doubleClickMessage\"]");
    private static final By rightClickMessage = By.xpath("//*[@id=\"rightClickMessage\"]");
    private static final By leftClickMessage = By.xpath("//*[@id=\"dynamicClickMessage\"]");
    private static final By confirmResult = By.xpath("//*[@id=\"confirmResult\"]");

    WebDriver webDriver;

    public ChecksClass(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean checkDoubleClick () {
        return webDriver.findElements(doubleClickMessage).isEmpty();
    }

    public boolean checkRightClick () {
        return webDriver.findElements(rightClickMessage).isEmpty();
    }

    public boolean checkLeftClick () {
        return webDriver.findElements(leftClickMessage).isEmpty();
    }

    public boolean checkConfirmResult () {
        return webDriver.findElements(confirmResult).isEmpty();
    }

}
