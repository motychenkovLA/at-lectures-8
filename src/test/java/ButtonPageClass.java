import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    @Step("Выполнить двойное клик")
    public void doubleClick () {
        Actions actions = new Actions(webDriver);
        actions.doubleClick(webDriver.findElement(doubleClickBtn))
                .build()
                .perform();
    }

    @Step("Выполнить правый клик")
    public void rightClick () {
        Actions actions = new Actions(webDriver);
        actions.contextClick(webDriver.findElement(rightClickBtn))
                .build()
                .perform();
    }

    @Step("Выполнить левый клик")
    public void leftClick () {
        Actions actions = new Actions(webDriver);
        actions.click(webDriver.findElement(leftClickBtn))
                .build()
                .perform();
    }

    @Step("Получить сообщение после двойного клика")
    public String getDoubleClickMessage (WebDriver webDriver){
        return webDriver.findElement(doubleClickMessage).getText();
    }

    @Step("Получить сообщение после правого клика")
    public String getRightClickMessage (WebDriver webDriver){
        return webDriver.findElement(rightClickMessage).getText();
    }

    @Step("Получить сообщение после левого клика")
    public String getLeftClickMessage (WebDriver webDriver){
        return webDriver.findElement(leftClickMessage).getText();
    }
}
