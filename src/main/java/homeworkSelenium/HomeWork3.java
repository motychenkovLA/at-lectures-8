package homeworkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class HomeWork3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/java/homeworkSelenium/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://demoqa.com/browser-windows");
        String demoQATab = webDriver.getWindowHandle();

        WebElement tabButton = webDriver.findElement(By.xpath("//*[@id=\"tabButton\"]"));
        Actions actions = new Actions(webDriver);
        actions.click(tabButton).build().perform();

        Set<String> handles = webDriver.getWindowHandles();
        handles.remove(demoQATab);
        Iterator <String> iterator = handles.iterator();
        String newTab = iterator.next();
        webDriver.switchTo().window(newTab);
        webDriver.get("https://google.com");
        webDriver.switchTo().window(demoQATab);

        webDriver.quit();
    }
}
