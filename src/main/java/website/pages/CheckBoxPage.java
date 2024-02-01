package website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckBoxPage extends BasePage<CheckBoxPage> {
    private final Logger logger = LoggerFactory.getLogger(CheckBoxPage.class);

    public static final By locCheckBox1 = By.cssSelector("#checkbox-1");
    public static final By locCheckBox2 = By.cssSelector("#checkbox-2");
    public static final By locCheckBox3 = By.cssSelector("#checkbox-3");

    public static Boolean isChangedCheckBox1 = null;
    public static Boolean isChangedCheckBox2 = null;
    public static Boolean isChangedCheckBox3 = null;

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public void openCheckBoxPage() {
        try {
            logger.info("Opening CheckBoxPage");
            driver.get(BASE_URL + "checkbox");
            isChangedCheckBox1 = Boolean.FALSE;
            isChangedCheckBox2 = Boolean.FALSE;
            isChangedCheckBox3 = Boolean.FALSE;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectCheckBox1() {
        performCheckBoxAction(locCheckBox1, true);
    }

    public void deselectCheckBox1() {
        performCheckBoxAction(locCheckBox1, false);
    }

    public void selectCheckBox2() {
        performCheckBoxAction(locCheckBox2, true);
    }

    public void deselectCheckBox2() {
        performCheckBoxAction(locCheckBox2, false);
    }

    public void selectCheckBox3() {
        performCheckBoxAction(locCheckBox3, true);
    }

    public void deselectCheckBox3() {
        performCheckBoxAction(locCheckBox3, false);
    }

    private void performCheckBoxAction(By checkBoxLocator, boolean select) {
        try {
            WebElement checkBox = waitForElement(checkBoxLocator);
            boolean startingState = checkBox.isSelected();

            if (select && !startingState || !select && startingState) {
                checkBox.click();
                wait.until(ExpectedConditions.elementSelectionStateToBe(checkBoxLocator, select));

                // Set the corresponding isChanged variable
                if (checkBoxLocator.equals(locCheckBox1)) {
                    isChangedCheckBox1 = !isChangedCheckBox1;
                } else if (checkBoxLocator.equals(locCheckBox2)) {
                    isChangedCheckBox2 = !isChangedCheckBox2;
                } else if (checkBoxLocator.equals(locCheckBox3)) {
                    isChangedCheckBox3 = !isChangedCheckBox3;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
