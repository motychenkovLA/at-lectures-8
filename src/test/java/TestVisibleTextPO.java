import PageObject.PageButton;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class TestVisibleTextPO {
    PageButton pageButton;

    @Before
    public void openPage() {
        //открывается страница и создается экземпляр класса страницы
        pageButton = open("https://demoqa.com/buttons", PageObject.PageButton.class);
    }
    @Test(expected = NullPointerException.class, timeout = 180000)
    public void testDoubleClick() {
        //кликнуть на кнопку Double click me
        pageButton.clickButtonDoubleClick();

        //проверка получено ли нужное сообщение
        pageButton.correctTextButtonDoubleClick(pageButton.doubleClickMessageText());
    }

    @Test
    public void testRightClick() {
        //кликнуть на кнопку Right click me
        pageButton.clickButtonRightClick();

        //проверка получено ли нужное сообщение
        pageButton.correctTextButtonRightClick(pageButton.rightClickMessageText());
    }

    @Test
    public void testLeftClick() {
        //кликнуть на кнопку Click me
        pageButton.clickButtonClickMe();

        //проверка получено ли нужное сообщение
        pageButton.correctTextButtonClickMe(pageButton.dynamicClickMessageText());
    }
}
