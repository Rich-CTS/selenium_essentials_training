package website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class FileUploadPage extends BasePage<FileUploadPage> {
    private final Logger logger = LoggerFactory.getLogger(FileUploadPage.class);
    // Elements
    public static final By locChooseFileButton = By.id("file-upload-field");
    public static final String filePath = new File("src/test/resources/files/your-file.txt").getAbsolutePath();
    // Page
    public FileUploadPage(WebDriver driver) {
        super(driver);
    }
    public void openFileUploadPage() {
        try {
            logger.info("Opening FileUploadPage");
            driver.get(BASE_URL + "fileupload");
        } catch (Exception e) {
            // Handle page open exception
            e.printStackTrace();
        }
    }
    // Methods
    public void uploadFile() {
        try {
            logger.info("Uploading file");
            WebElement element = waitForElement(locChooseFileButton);
            element.sendKeys(filePath);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

}
