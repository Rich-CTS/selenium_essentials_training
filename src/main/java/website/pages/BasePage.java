package website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage<T> {
    // Create a logger
    private final Logger logger = LoggerFactory.getLogger(BasePage.class);
    public static final String BASE_URL = "https://formy-project.herokuapp.com/";
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement waitForElement(By locator) {
        // Log information
        logger.info("Waiting for element: {}", locator);

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (org.openqa.selenium.TimeoutException e) {
            // Log a custom error message if the element is not found within the specified timeout
            logger.error("Element {} was not found within the specified timeout", locator);
            captureScreenshot("waitForElementTimeout_" + System.currentTimeMillis());
            throw new TimeoutException(e.getMessage(), e.getCause());
        }
    }

    public void moveTo(By locator) {
        Actions actions = new Actions(driver);
        WebElement element = waitForElement(locator);
        actions.moveToElement(element).build().perform();
    }

    public void assertElementPresent(By locator, String failureMessage) {
        logger.info("Asserting element {} is present", locator);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement element = waitForElement(locator);
        try {
            Assert.assertTrue(element.isDisplayed(), failureMessage);
        } catch (AssertionError e) {
            // Assertion failed, capture a screenshot
            captureScreenshot("assertElementPresentFailure_" + System.currentTimeMillis());

            // Rethrow the assertion error to propagate the failure
            throw e;
        }
    }

    public void assertTextPresent(By locator, String expectedText, String failureMessage) {
        logger.info("Asserting text {} is present from element {}", expectedText, locator);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement element = waitForElement(locator);
        String actualText = element.getText();
        if (!actualText.equals(expectedText)) {
            By partialTextLocator = By.partialLinkText(expectedText);
            element = waitForElement(partialTextLocator);
            actualText = element.getText();
        }
        try {
            Assert.assertEquals(actualText, expectedText, failureMessage);
        } catch (AssertionError e) {
            // Assertion failed, capture a screenshot
            captureScreenshot("assertTextPresentFailure_" + System.currentTimeMillis());

            // Rethrow the assertion error to propagate the failure
            throw e;
        }
    }

    public void assertTextEntered(By locator, String expectedText, String failureMessage) {
        logger.info("Asserting text {} is entered in element {}", expectedText, locator);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement element = waitForElement(locator);
        String actualText = element.getAttribute("value");
        String datePickerValue = element.getAttribute("data-date");

        if (datePickerValue != null && !datePickerValue.isEmpty()) {
            actualText = datePickerValue;
        }

        try {
            Assert.assertEquals(actualText, expectedText, failureMessage);
        } catch (AssertionError e) {
            // Assertion failed, capture a screenshot
            captureScreenshot("assertTextEnteredFailure_" + System.currentTimeMillis());

            // Rethrow the assertion error to propagate the failure
            throw e;
        }
    }

    // Method to capture and save a screenshot
    public void captureScreenshot(String screenshotName) {
        try {
            // Capture screenshot as File
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Set the destination path with timestamped filename
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotPath = "logs/screenshots/" + screenshotName + "_" + timestamp + ".png";

            // Copy the screenshot file to the destination path
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));

            logger.info("Screenshot saved: {}", screenshotPath);
        } catch (IOException e) {
            logger.error("Failed to capture screenshot: {}", e.getMessage());
        }
    }

}