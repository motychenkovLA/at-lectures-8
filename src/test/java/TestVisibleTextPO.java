import PageObject.PageButton;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class TestVisibleTextPO {
    PageButton pageButton;

    @Before
    @Step("Открыли страницу")
    public void openPage() {
        //открывается страница и создается экземпляр класса страницы
        pageButton = open("https://demoqa.com/buttons", PageObject.PageButton.class);
    }
    @Test(expected = NullPointerException.class, timeout = 180000)
    @DisplayName("Проверка кнопки Double click me")
    @Description("Проверка, что при нажатии на кнопку Double click me появится сообщение You have done a double click")
    public void testDoubleClick() {
        //кликнуть на кнопку Double click me
        pageButton.clickButtonDoubleClick();

        //проверка получено ли нужное сообщение
        assertEquals("You have done a double click", pageButton.doubleClickMessageText());
    }

    @Test
    @DisplayName("Проверка кнопки Right click me")
    @Description("Проверка, что при нажатии на кнопку Right click me появится сообщение You have done a right click")
    public void testRightClick() {
        //кликнуть на кнопку Right click me
        pageButton.clickButtonRightClick();

        //проверка получено ли нужное сообщение
        assertEquals("You have done a right click", pageButton.rightClickMessageText());
    }

    @Test
    @DisplayName("Проверка кнопки Click me")
    @Description("Проверка, что при нажатии на кнопку Click me появится сообщение You have done a dynamic click")
    public void testLeftClick() {
        //кликнуть на кнопку Click me
        pageButton.clickButtonClickMe();

        //проверка получено ли нужное сообщение
        assertEquals("You have done a dynamic click", pageButton.dynamicClickMessageText());
    }
}
