package website;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import website.utils.WebDriverFactory;

public class BaseTest {
    private ThreadLocal<WebDriver> driverThreadLocal = WebDriverFactory.driverThreadLocal;

    @BeforeMethod
    public void setup() {
        initializeDriver();
    }

    @AfterSuite
    public void tearDownSuite() {
        quitAllDrivers();
    }

    protected void initializeDriver() {
        try {
            WebDriver driver = getDriver(); // Reuse the driver if already initialized
            if (driver == null) {
                driver = WebDriverFactory.getDriver(WebDriverFactory.BrowserType.CHROME);
                // Set the driver to ThreadLocal
                driverThreadLocal.set(driver);
            }
        } catch (Exception e) {
            // Log an error for unexpected exceptions during initialization
            e.printStackTrace();
        }
    }

    protected void quitDriver() {
        try {
            WebDriverFactory.quitDriver();
        } catch (Exception e) {
            // Log an error for unexpected exceptions during quit
            e.printStackTrace();
        }
    }
    @AfterMethod
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
    protected void quitAllDrivers() {
        try {
            WebDriverFactory.quitAllDrivers();
        } catch (Exception e) {
            // Log an error for unexpected exceptions during suite teardown
            e.printStackTrace();
        }
    }

    protected WebDriver getDriver() {
        return driverThreadLocal.get();
    }
}
