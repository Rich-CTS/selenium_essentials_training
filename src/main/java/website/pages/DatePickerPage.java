package website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatePickerPage extends BasePage<DatePickerPage> {
    private final Logger logger = LoggerFactory.getLogger(DatePickerPage.class);
    // Elements
    public static final By locDateField = By.id("datepicker");

    // Page
    public DatePickerPage(WebDriver driver) {
        super(driver);
    }
    public void openDatePickerPage() {
        try {
            logger.info("Opening DatePickerPage");
            driver.get(BASE_URL + "datepicker");
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }
    // Methods
    public void selectDate(String date) {
        try {
            WebElement element = waitForElement(locDateField);
            logger.info("Selecting {} in date field.", date);
            element.sendKeys(date);
            element.sendKeys(Keys.RETURN);
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }

}
