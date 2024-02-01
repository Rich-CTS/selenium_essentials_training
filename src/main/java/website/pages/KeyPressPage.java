package website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KeyPressPage extends BasePage<KeyPressPage> {
    private final Logger logger = LoggerFactory.getLogger(KeyPressPage.class);
    //Elements
    public static final By locName = By.cssSelector("input[type='text']");
    public static final By locButton = By.cssSelector("button[id='button']");

    // Page
    public KeyPressPage(WebDriver driver) {
        super(driver);
    }

    // Methods
    public void openKeyPressPage() {
        try {
            logger.info("Opening KeyPressPage");
            driver.get(BASE_URL + "keypress");
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }

    public void inputName(String input) {
        try {
            logger.info("Entering name: {}", input);
            WebElement element = waitForElement(locName);
            element.sendKeys(input);
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }

    public void clickButton() {
        try {
            logger.info("Clicking button");
            WebElement element = waitForElement(locButton);
            element.click();
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }

}