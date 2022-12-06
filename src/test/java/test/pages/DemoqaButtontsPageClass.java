package test.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoqaButtontsPageClass {

    public static final By doubleClickMeButtonLocator = By.xpath("//button[@id=\"doubleClickBtn\"]");
    public static final By rightClickMeButtonLocator = By.xpath("//button[@id=\"rightClickBtn\"]");
    static final By clickMeButtonLocator = By.xpath("//button[text()=\"Click Me\"]");
    static final By doubleClickMessageLocator = By.xpath("//p[@id=\"doubleClickMessage\"]");
    static final By rightClickMessageLocator = By.xpath("//p[@id=\"rightClickMessage\"]");
    static final By dynamicClickMessage = By.xpath("//p[@id=\"dynamicClickMessage\"]");

    private final WebDriver webDriver;

    public DemoqaButtontsPageClass(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Совершить двойной клик")
    public void doubleClick(){
        Actions actions = new Actions(webDriver);
        actions.doubleClick(webDriver.findElement(doubleClickMeButtonLocator))
                .build()
                .perform();
    }

    @Step("Совершить клик правой кнопкой")
    public void contextClick(){
        Actions actions = new Actions(webDriver);
        actions.contextClick(webDriver.findElement(rightClickMeButtonLocator))
                .build()
                .perform();
    }

    @Step("Совершить клик левой кнопкой")
    public void click(){
        Actions actions = new Actions(webDriver);
        actions.click(webDriver.findElement(clickMeButtonLocator))
                .build()
                .perform();
    }

    @Step("Получить текст, который появляется после двойного клика")
    public String getDoubleClickText(WebDriver webDriver) {
        return webDriver.findElement(doubleClickMessageLocator).getText();
    }

    @Step("Получить текст, который появляется после клика правой кнопкой")
    public String getRightClickText(WebDriver webDriver) {
        return webDriver.findElement(rightClickMessageLocator).getText();
    }

    @Step("Получить текст, который появляется после клика левой кнопкой")
    public String getDynamicClickText(WebDriver webDriver) {
        return webDriver.findElement(dynamicClickMessage).getText();
    }
}
