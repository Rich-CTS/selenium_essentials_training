package website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScrollPage extends BasePage<ScrollPage> {
    private final Logger logger = LoggerFactory.getLogger(ScrollPage.class);
    // Elements
    public static final By locFullName = By.id("name");
    public static final By locDate = By.id("date");

    // Page
    public ScrollPage(WebDriver driver) {
        super(driver);
    }

    public void openScrollPage() {
        try {
            logger.info("Opening ScrollPage");
            driver.get(BASE_URL + "scroll");
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }

    // Methods
    public void moveToFullName() {
        try {
            logger.info("Moving to Full Name element");
            moveTo(locFullName);
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }

    public void inputFullName(String input) {
        try {
            logger.info("Entering Full Name: {}", input);
            WebElement element = waitForElement(locFullName);
            element.sendKeys(input);
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }

    public void inputDate(String input) {
        try {
            logger.info("Entering Date: {}", input);
            WebElement element = waitForElement(locDate);
            element.sendKeys(input);
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }

}