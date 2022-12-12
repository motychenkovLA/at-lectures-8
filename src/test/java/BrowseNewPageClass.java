import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowseNewPageClass {
    private static final By tabButton = By.xpath("//*[@id=\"tabButton\"]");
    WebDriver webDriver;

    public BrowseNewPageClass(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Открыть новую вкладку")
    public void tabButtonClick (){
        WebElement button = webDriver.findElement(tabButton);
        button.click();
    }
}
