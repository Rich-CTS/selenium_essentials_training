package website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RadioButtonPage extends BasePage<RadioButtonPage> {
    private final Logger logger = LoggerFactory.getLogger(RadioButtonPage.class);
    // Elements
    public static final By locRadioButton1 = By.id("radio-button-1");
    public static final By locRadioButton2 = By.cssSelector("input[value='option2']");
    public static final By locRadioButton3 = By.xpath("//div[3]/input");
    public static Boolean isSelectedRadioButton1 = null;
    public static Boolean isSelectedRadioButton2 = null;
    public static Boolean isSelectedRadioButton3 = null;

    // Page
    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }

    public void openRadioButtonPage() {
        try {
            logger.info("Opening RadioButtonPage");
            driver.get(BASE_URL + "radiobutton");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Methods
    public void clickRadioButton1() {
        try {
            WebElement element1 = waitForElement(locRadioButton1);
            WebElement element2 = waitForElement(locRadioButton2);
            WebElement element3 = waitForElement(locRadioButton3);
            element1.click();
            isSelectedRadioButton1 = element1.isSelected();
            isSelectedRadioButton2 = element2.isSelected();
            isSelectedRadioButton3 = element3.isSelected();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickRadioButton2() {
        try {
            WebElement element1 = waitForElement(locRadioButton1);
            WebElement element2 = waitForElement(locRadioButton2);
            WebElement element3 = waitForElement(locRadioButton3);
            element2.click();
            isSelectedRadioButton1 = element1.isSelected();
            isSelectedRadioButton2 = element2.isSelected();
            isSelectedRadioButton3 = element3.isSelected();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickRadioButton3() {
        try {
            WebElement element1 = waitForElement(locRadioButton1);
            WebElement element2 = waitForElement(locRadioButton2);
            WebElement element3 = waitForElement(locRadioButton3);
            element3.click();
            isSelectedRadioButton1 = element1.isSelected();
            isSelectedRadioButton2 = element2.isSelected();
            isSelectedRadioButton3 = element3.isSelected();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
