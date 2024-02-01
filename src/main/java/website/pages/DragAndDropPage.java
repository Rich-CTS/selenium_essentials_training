package website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DragAndDropPage extends BasePage<DragAndDropPage> {
    private final Logger logger = LoggerFactory.getLogger(DragAndDropPage.class);
    // Elements
    public static final By locImage = By.id("image");
    public static final By locBox = By.id("box");
    public static final By locBoxText = By.cssSelector("#box > p");
    public static String strBoxText = null;
    WebElement boxText = null;

    // Page
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public void openDragAndDropPage() {
        try {
            logger.info("Opening DragAndDropPage");
            driver.get(BASE_URL + "dragdrop");
            boxText = waitForElement(locBoxText);
            strBoxText = boxText.getText();
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }

    // Methods
    public void dragImageToBox() {
        try {
            WebElement image = waitForElement(locImage);
            WebElement box = waitForElement(locBox);
            //boxText = waitForElement(locBoxText);
            logger.info("Dragging {} image to {} box.", image.getAttribute("src"), box.getText());
            Actions actions = new Actions(driver);
            actions.dragAndDrop(image, box).build().perform();
            strBoxText = boxText.getText();
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }

}
