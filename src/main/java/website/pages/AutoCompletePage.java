package website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutoCompletePage extends BasePage<AutoCompletePage> {
    private final Logger logger = LoggerFactory.getLogger(AutoCompletePage.class);
    // Elements e.g. public static final By locElement = By.cssSelector("input[type='text']");
    public static final By locAutocomplete = By.id("autocomplete");
    public static final By locAutocompleteResult = By.className("pac-item");

    // Page .e.g. public NameOfPage(WebDriver driver) { super(driver); }
    //            public void openNameOfPage() { driver.get(BASE_URL + "nameofpage"); }
    public AutoCompletePage(WebDriver driver) {
        super(driver);
    }

    public void openAutoCompletePage() {
        try {
            logger.info("Opening AutoCompletePage");
            driver.get(BASE_URL + "autocomplete");
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }

    /**
     * Methods e.g. public void inputElement(String input) {
     * WebElement element = waitForElement(locElement);
     * element.sendKeys(input);
     * }
     */
    public void searchAddress(String input) {
        try {
            logger.info("Entering address to search for: {}", input);
            WebElement element = waitForElement(locAutocomplete);
            element.sendKeys(input);
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }

    public void selectResult() {
        try {
            logger.info("Selecting result");
            WebElement element = waitForElement(locAutocompleteResult);
            element.click();
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }

}
