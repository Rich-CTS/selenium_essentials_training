package website.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.util.ArrayList;
import java.util.List;

public class WebDriverFactory {
    public static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static List<WebDriver> drivers = new ArrayList<>();

    static {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        // Setup for other browsers if needed
    }

    public static WebDriver getDriver(BrowserType browserType) {
        try {
            WebDriver driver = new ChromeDriver();  // Change to FirefoxDriver as needed
            driverThreadLocal.set(driver);
            drivers.add(driver);
            return driver;
        } catch (Exception e) {
            // Log an error for unexpected exceptions during WebDriver initialization
            e.printStackTrace();
            return null;
        }
    }

    public static void quitDriver() {
        try {
            WebDriver driver = driverThreadLocal.get();
            if (driver != null) {
                driver.quit();
                drivers.remove(driver); // Remove from the list
            }
        } catch (UnreachableBrowserException e) {
            // Log an info message for UnreachableBrowserException (driver already closed)
            System.out.println("WebDriver already closed.");
        } catch (Exception e) {
            // Log an error for unexpected exceptions during quit
            e.printStackTrace();
        } finally {
            driverThreadLocal.remove(); // Ensure ThreadLocal cleanup
        }
    }

    public static void quitAllDrivers() {
        try {
            for (WebDriver driver : drivers) {
                if (driver != null) {
                    driver.quit();
                }
            }
            drivers.clear(); // Clear the list after quitting all drivers
        } catch (Exception e) {
            // Log an error for unexpected exceptions during quitAll
            e.printStackTrace();
        }
    }

    // Enum to specify browser type
    public enum BrowserType {
        CHROME,
        FIREFOX
        // Add more browser types if needed
    }
}
