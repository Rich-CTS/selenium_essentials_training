package website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.Alert;

public class SwitchWindowPage extends BasePage<SwitchWindowPage> {
    private final Logger logger = LoggerFactory.getLogger(SwitchWindowPage.class);
    // Elements
    public static final By locTabButton = By.id("new-tab-button");
    public static final By locAlertButton = By.id("alert-button");
    public static final By locWelcome = By.cssSelector("h1[class='display-3']");
    public Alert alert = null;
    public static String alertText = null;
    public static String originalHandle = null;

    // Page
    public SwitchWindowPage(WebDriver driver) {
        super(driver);
    }

    public void openSwitchWindowPage() {
        try {
            logger.info("Opening SwitchWindowPage");
            driver.get(BASE_URL + "switch-window");
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }

    // Methods
    public void clickNewTabButton() {
        try {
            WebElement element = waitForElement(locTabButton);
            logger.info("Clicking {} button.", element.getText());
            element.click();
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }

    public void switchToNewTab() {
        try {
            originalHandle = driver.getWindowHandle();
            for (String handle1 : driver.getWindowHandles()) {
                driver.switchTo().window(handle1);
            }
            logger.info("Switching to {} tab.", driver.getTitle());
        } catch (Exception e) {
            logger.error("Error switching to new tab: {}", e.getMessage());
        }
    }

    public void switchToOriginalTab() {
        try {
            logger.info("Switching to Original Tab.");
            driver.switchTo().window(originalHandle);
            logger.info("Switching to {} tab.", driver.getTitle());
        } catch (Exception e) {
            logger.error("Error switching to original tab: {}", e.getMessage());
        }
    }

    public void clickAlertButton() {
        try {
            WebElement element = waitForElement(locAlertButton);
            logger.info("Clicking {} button.", element.getText());
            element.click();
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }

    public void switchToAlert() {
        try {
            logger.info("Switching to Alert.");
            alert = driver.switchTo().alert();
            alertText = alert.getText();
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }

    public void acceptAlert() {
        try {
            logger.info("Accepting Alert.");
            alert.accept();
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }

}