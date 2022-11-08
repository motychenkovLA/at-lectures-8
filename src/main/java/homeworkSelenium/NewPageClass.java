package homeworkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewPageClass {
    private static final By tabButton = By.xpath("//*[@id=\"tabButton\"]");
    WebDriver webDriver;

    public NewPageClass(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void tabButtonClick (){
        WebElement button = webDriver.findElement(tabButton);
        button.click();
    }
}
