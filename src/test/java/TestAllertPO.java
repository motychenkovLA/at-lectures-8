import PageObject.PageAllert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.junit.Assert.assertEquals;

import io.qameta.allure.junit4.DisplayName;

public class TestAllertPO {
    PageAllert pageAllert;

    @Before
    public void openPage() {
        //открывается страница и создается экземпляр класса страницы
        pageAllert = open("https://demoqa.com/alerts", PageObject.PageAllert.class);
    }
    @Test
    @DisplayName("Проверка Click Button to see alert")
    public void testAllertButtonOne() {
        //кликнуть на кнопку Click Button to see alert
        pageAllert.clickButtonToSeeAllert();

        //Принять аллерт
        switchTo().alert().accept();
    }

    @Test
    @DisplayName("Проверка On button click, alert will appear after 5 seconds")
    public void testAllertButtonTwo() {
        //кликнуть на кнопку On button click, alert will appear after 5 seconds
        pageAllert.clickButtonAllertAfter5();

        //new WebDriverWait(new ChromeDriver(), 6).until(ExpectedConditions.alertIsPresent());
        new ChromeDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        //Принять аллерт
        switchTo().alert().accept();
    }

    @Test
    @DisplayName("Проверка On button click, confirm box will appear")
    public void testAllertButtonThree() {
        //кликнуть на кнопку On button click, confirm box will appear
        pageAllert.clickButtonAllertThree();

        //Отклонить аллерт
        switchTo().alert().dismiss();

        //проверка получено ли нужное сообщение
        assertEquals("You selected Cancel", pageAllert.closedAllertMessage());
    }
}
