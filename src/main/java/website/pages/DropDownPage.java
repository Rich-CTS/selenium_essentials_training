package website.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DropDownPage extends BasePage<DropDownPage> {
    private final Logger logger = LoggerFactory.getLogger(DropDownPage.class);
    // Elements
    public static final By locDropDownMenu = By.id("dropdownMenuButton");
    public static final By locFileUploadOption = By.partialLinkText("File Upload");

    // Page
    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    public void openDropDownPage() {
        try {
            logger.info("Opening DropDownPage");
            driver.get(BASE_URL + "dropdown");
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }

    // Methods
    public void expandDropDown() {
        try {
            WebElement menu = waitForElement(locDropDownMenu);
            logger.info("Expanding drop-down menu.");
            menu.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void selectOption(By locOption) {
        try {
            WebElement option = waitForElement(locOption);
            logger.info("Select {} option.",option.getText());
            option.click();
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }

}
