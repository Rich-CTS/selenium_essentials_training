package website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaScriptExecutorPage extends BasePage<JavaScriptExecutorPage> {
    private final Logger logger = LoggerFactory.getLogger(JavaScriptExecutorPage.class);
    // Elements
    public static final By locModalButton = By.id("modal-button");
    public static final By locCloseButton = By.id("close-button");

    // Page
    public JavaScriptExecutorPage(WebDriver driver) {
        super(driver);
    }

    public void openJavaScriptExecutorPage() {
        try {
            logger.info("Opening JavaScriptExecutorPage");
            driver.get(BASE_URL + "modal");
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }

    // Methods
    public void clickModalButton() {
        try {
            WebElement element = waitForElement(locModalButton);
            logger.info("Clicking {} button.", element.getText());
            element.click();
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }

    public void executeScript() {
        try {
            WebElement element = waitForElement(locCloseButton);
            logger.info("Running JavaScript to click {} button.", element.getText());
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }
}
