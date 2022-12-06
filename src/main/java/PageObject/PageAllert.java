package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;

public class PageAllert {
    //локатор кнопки для аллерта Click Button to see alert
    @FindBy(how = How.XPATH,using = ".//button[(@class='btn btn-primary' and @id='alertButton')]")
    private SelenideElement buttonToSeeAllert;

    //локатор кнопки для аллерта On button click, alert will appear after 5 seconds
    @FindBy(how = How.XPATH,using = "//button[(@class='btn btn-primary' and @id='timerAlertButton')]")
    private SelenideElement buttonAllertAfter5;

    //локатор кнопки для аллерта On button click, confirm box will appear
    @FindBy(how = How.XPATH,using = ".//button[(@class='btn btn-primary' and @id='confirmButton')]")
    private SelenideElement buttonAllertThree;

    //локатор текста You selected Ok
    @FindBy(how = How.ID,using = "confirmResult")
    private SelenideElement closedAllertMessage;

    //метод клика по кнопке для аллерта Click Button to see alert
    @Step("Нажали на кнопку Click Button to see alert")
    public void clickButtonToSeeAllert() {
        buttonToSeeAllert.click();
    }

    //метод клика по кнопке для аллерта On button click, alert will appear after 5 seconds
    @Step("Нажали на кнопку On button click, alert will appear after 5 seconds")
    public void clickButtonAllertAfter5() {
        buttonAllertAfter5.click();
    }

    //метод клика по кнопке для аллерта On button click, confirm box will appear
    @Step("Нажали на кнопку On button click, confirm box will appear")
    public void clickButtonAllertThree() {
        buttonAllertThree.click();
    }

    //элемент You selected Cancel
    @Step("Получаем текст элемента после закрытия алерта")
    public String closedAllertMessage() {
        return closedAllertMessage.getText();
    }

}
