package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoqaBrowserWindowsPageClass {

    private static final By tabButtonLocator = By.xpath("//button[@id=\"tabButton\"]");
    private final WebDriver webDriver;

    public DemoqaBrowserWindowsPageClass(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void tabButtonClick () {
        WebElement tabButton = webDriver.findElement(tabButtonLocator);
        tabButton.click();
    }
}
