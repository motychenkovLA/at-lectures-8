package homeworkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HomeWork {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/java/homeworkSelenium/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://demoqa.com/buttons");
        WebElement doubleClickBtn = webDriver.findElement(By.xpath("//*[@id=\"doubleClickBtn\"]"));
        WebElement rightClickBtn = webDriver.findElement(By.xpath("//*[@id=\"rightClickBtn\"]"));
        WebElement leftClickBtn = webDriver.findElement(By.xpath("//button[text()=\"Click Me\"]"));
        Actions actions = new Actions(webDriver);
        actions
                .doubleClick(doubleClickBtn)
                .contextClick(rightClickBtn)
                .click(leftClickBtn)
                .build()
                .perform();

        boolean isHaveDoubleClickText = !webDriver.findElements(By.xpath("//*[@id=\"doubleClickMessage\"]")).isEmpty();
        boolean isHaveRightClickText = !webDriver.findElements(By.xpath("//*[@id=\"rightClickMessage\"]")).isEmpty();
        boolean isHaveLeftClickText = !webDriver.findElements(By.xpath("//*[@id=\"dynamicClickMessage\"]")).isEmpty();

        if (isHaveDoubleClickText && isHaveRightClickText && isHaveLeftClickText) {
            System.out.println("Тесты пройдены");
        } else {
            System.out.println("Тесты не пройдены");
        }
        webDriver.quit();
    }
}
