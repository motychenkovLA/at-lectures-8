package homeworkSelenium;

import org.junit.*;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class MainTest {
    private WebDriver webDriver;

    @Before
    public void connectDriver () {
        System.setProperty("webdriver.chrome.driver", "src/main/java/homeworkSelenium/chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @After
    public void closeDriver () {
        if (webDriver!= null) webDriver.quit();
    }

    @Rule
    public Timeout globalTimeout = Timeout.seconds(180);

    @Test
    public void homeWork1() {

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.get("https://demoqa.com/buttons");

        ButtonPageClass buttonPage = new ButtonPageClass(webDriver);

        buttonPage.doubleClick();
        Assert.assertEquals("Ошибка, результаты не совпадают", "You have done a double click", buttonPage.getDoubleClickMessage(webDriver));


        buttonPage.rightClick();
        Assert.assertEquals("Ошибка, результаты не совпадают", "You have done a right click", buttonPage.getRightClickMessage(webDriver));

        buttonPage.leftClick();
        Assert.assertEquals("Ошибка, результаты не совпадают", "You have done a dynamic click", buttonPage.getLeftClickMessage(webDriver));

    }

    @Test
    public void homeWork2 () {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://demoqa.com/alerts");

        AlertPageClass alertPage = new AlertPageClass(webDriver);

        alertPage.alertButtonClick();
        alertPage.timerAlertButtonClick();
        alertPage.confirmButtonClick();

        Assert.assertEquals("Ошибка, результаты не совпадают", "You selected Cancel", alertPage.getConfirmResult(webDriver));

    }

    @Test
    public void homeWork3 () {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://demoqa.com/browser-windows");
        String demoQATab = webDriver.getWindowHandle();

        BrowseNewPageClass newPageClass = new BrowseNewPageClass(webDriver);
        newPageClass.tabButtonClick();

        Set<String> handles = webDriver.getWindowHandles();
        handles.remove(demoQATab);
        Iterator<String> iterator = handles.iterator();
        String newTab = iterator.next();
        webDriver.switchTo().window(newTab);
        webDriver.get("https://google.com");
        webDriver.switchTo().window(demoQATab);

    }

}
