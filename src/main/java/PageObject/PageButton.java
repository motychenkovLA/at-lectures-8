package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static org.junit.Assert.assertEquals;

public class PageButton {
    //локатор кнопки Double click me
    @FindBy(how = How.ID,using = "doubleClickBtn")
    private SelenideElement buttonDoubleClick;

    //локатор кнопки Right click me
    @FindBy(how = How.ID,using = "rightClickBtn")
    private SelenideElement buttonRightClick;

    //локатор кнопки Click me
    @FindBy(how = How.XPATH,using = ".//button[(@class='btn btn-primary' and text()='Click Me')]")
    private SelenideElement buttonClickMe;

    //локатор текста "You have done a double click"
    @FindBy(how = How.ID,using = "doubleClickMessage")
    private SelenideElement doubleClickMessage;

    //локатор текста "You have done a right click"
    @FindBy(how = How.ID,using = "rightClickMessage")
    private SelenideElement rightClickMessage;

    //локатор текста "You have done a dynamic click"
    @FindBy(how = How.ID,using = "dynamicClickMessage")
    private SelenideElement dynamicClickMessage;

    //метод клика по кнопке Double click me
    @Step("Нажали на кнопку Double click me")
    public void clickButtonDoubleClick() {
        buttonDoubleClick.doubleClick();
    }

    //метод клика по кнопке Right click me
    @Step("Нажали на кнопку Right click me")
    public void clickButtonRightClick() {
        buttonRightClick.contextClick();
    }

    //метод клика по кнопке Click me
    @Step("Нажали на кнопку Click me")
    public void clickButtonClickMe() {
        buttonClickMe.click();
    }

    //элемент doubleClickMessage
    @Step("Получаем текст элемента после нажатия Double click me")
    public String doubleClickMessageText() {
        return doubleClickMessage.getText();
    }

    //элемент rightClickMessage
    @Step("Получаем текст элемента после нажатия Right click me")
    public String rightClickMessageText() {
        return rightClickMessage.getText();
    }

    //элемент dynamicClickMessage
    @Step("Получаем текст элемента после нажатия Click me")
    public String dynamicClickMessageText() {
        return dynamicClickMessage.getText();
    }
}
