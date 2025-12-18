package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void sendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void safeClick(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Exception e) {
            System.out.println("Normal click failed, trying JS click");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }
        pause(500);
    }
    public void waitForModalToClose() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".modal-dialog")));
    }
    public void selectOdooDropdown(By inputLocator, String value) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // 1️⃣ Wait for input field
        WebElement input = wait.until(
                ExpectedConditions.elementToBeClickable(inputLocator)
        );

        // 2️⃣ Click & type
        input.click();
        input.clear();
        input.sendKeys(value);

        // 3️⃣ Wait for dropdown option
        By optionLocator = By.xpath("//ul[contains(@class,'ui-autocomplete')]//li//a");

        WebElement option = wait.until(
                ExpectedConditions.visibilityOfElementLocated(optionLocator)
        );

        // 4️⃣ Select option
        option.click();
    }

}
