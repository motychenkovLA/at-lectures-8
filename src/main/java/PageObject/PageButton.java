package PageObject;

import com.codeborne.selenide.SelenideElement;
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
    public void clickButtonDoubleClick() {
        buttonDoubleClick.doubleClick();
    }

    //метод клика по кнопке Right click me
    public void clickButtonRightClick() {
        buttonRightClick.contextClick();
    }

    //метод клика по кнопке Click me
    public void clickButtonClickMe() {
        buttonClickMe.click();
    }

    //метод проверки отображаемого текста по кнопке Double click me
    public void correctTextButtonDoubleClick(String doubleClickMessage) {
        assertEquals("You have done a double click", doubleClickMessage);
    }

    //элемент doubleClickMessage
    public String doubleClickMessageText() {
        return doubleClickMessage.getText();
    }

    //метод проверки отображаемого текста по кнопке Right click me
    public void correctTextButtonRightClick(String rightClickMessage) {
        assertEquals("You have done a right click", rightClickMessage);
    }

    //элемент rightClickMessage
    public String rightClickMessageText() {
        return rightClickMessage.getText();
    }

    //метод проверки отображаемого текста по кнопке click me
    public void correctTextButtonClickMe(String dynamicClickMessage) {
        assertEquals("You have done a dynamic click", dynamicClickMessage);
    }

    //элемент dynamicClickMessage
    public String dynamicClickMessageText() {
        return dynamicClickMessage.getText();
    }
}
