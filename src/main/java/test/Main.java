package test;

import org.junit.*;
import org.junit.rules.Timeout;
import org.openqa.selenium.chrome.ChromeDriver;
import test.pages.DemoqaAlertsPageClass;
import test.pages.DemoqaBrowserWindowsPageClass;
import test.pages.DemoqaButtontsPageClass;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Main {

        private WebDriver webDriver;
        private final String youHaveDoneDoubleClickText = "You have done a double click";
        private final String youHaveDoneRightClickText = "You have done a right click";
        private final String youHaveDoneDynamicClickText = "You have done a dynamic click";
        private final String youSelectedCancelText = "You selected Cancel";

        @Before
        public void chromeDriverConnection () {
            webDriver = new ChromeDriver();
        }

        @After
        public void chromeDriverConnectionClose () {
            if (webDriver != null) webDriver.quit();
        }

        @Rule
        public Timeout globalTimeout = Timeout.seconds(120);


        @Test
        public void firstTask () {
            webDriver.manage()
                    .timeouts()
                    .pageLoadTimeout(Duration.ofSeconds(10));
            webDriver.get("https://demoqa.com/buttons");

            DemoqaButtontsPageClass demoqaButtontsPage = new DemoqaButtontsPageClass(webDriver);

            demoqaButtontsPage.doubleClick();
            Assert.assertEquals("Некорректное сообщение после двойного клика", youHaveDoneDoubleClickText,
                    demoqaButtontsPage.getDoubleClickText(webDriver));

            demoqaButtontsPage.contextClick();
            Assert.assertEquals("Некорректное сообщение после правого клика", youHaveDoneRightClickText,
                    demoqaButtontsPage.getRightClickText(webDriver));

            demoqaButtontsPage.click();
            Assert.assertEquals("Некорректное сообщение после динамического клика", youHaveDoneDynamicClickText,
                    demoqaButtontsPage.getDynamicClickText(webDriver));
        }

        @Test
        public void secondTask () {
            webDriver.manage()
                    .timeouts()
                    .pageLoadTimeout(Duration.ofSeconds(10));
            webDriver.get("https://demoqa.com/alerts");

            DemoqaAlertsPageClass demoqaAlertsPage = new DemoqaAlertsPageClass(webDriver);

            demoqaAlertsPage.alertAccept();

            demoqaAlertsPage.timerAlertAccept();

            demoqaAlertsPage.alertDismiss();
            Assert.assertEquals("Некорректное сообщение после отмены алерта", youSelectedCancelText,
                    demoqaAlertsPage.getSelectedCancelText(webDriver));

        }

        @Test
        public void thirdTask () {
            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            webDriver.get("https://demoqa.com/browser-windows");
            String demoqaID = webDriver.getWindowHandle();

            DemoqaBrowserWindowsPageClass demoqaBrowserWindowsPage = new DemoqaBrowserWindowsPageClass(webDriver);
            demoqaBrowserWindowsPage.tabButtonClick();

            Set<String> handles = webDriver.getWindowHandles();
            handles.remove(demoqaID);
            Iterator<String> iterator = handles.iterator();
            String googleID = iterator.next();

            webDriver.switchTo()
                    .window(googleID)
                    .get("https://www.google.com/");

            webDriver.switchTo()
                    .window(demoqaID);

        }
}

