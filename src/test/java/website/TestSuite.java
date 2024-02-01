package website;

import org.testng.Assert;
import org.testng.annotations.Test;
import website.pages.*;

import java.io.File;

public class TestSuite extends BaseTest {
    //@Test(groups = "toFix")
    //@Test(groups = "investigating")
    @Test(groups = "regression")
    public void keyPressTest() {
        // Var
        String name = "Rich";
        // Initiate e.g.NameOfPage nameOfPage = new NameOfPage(getDriver());
        //              nameOfPage.openNameOfPage();
        KeyPressPage keyPressPage = new KeyPressPage(getDriver());
        keyPressPage.openKeyPressPage();
        // Steps
        keyPressPage.inputName(name);
        keyPressPage.assertElementPresent(KeyPressPage.locName, "Unable to locate Name field.");
        keyPressPage.clickButton();
        keyPressPage.assertElementPresent(KeyPressPage.locButton, "Unable to locate Button.");
    }

    //@Test(groups = "investigating")
    // @Test(groups = "regression")
    @Test(groups = "toFix")
    public void AutoCompleteTest() {
        // Var
        String address = "1555 Park Blvd, Palo Alto, CA";
        // Initiate
        AutoCompletePage autoCompletePage = new AutoCompletePage(getDriver());
        autoCompletePage.openAutoCompletePage();
        // Steps
        autoCompletePage.searchAddress(address);
        autoCompletePage.selectResult();
    }

    //@Test(groups = "investigating")
    @Test(groups = "regression")
    //@Test(groups = "toFix")
    public void ScrollTest() {
        // Var
        String fullName = "Rich C";
        String date = "01/01/2024";
        // Initiate
        ScrollPage scrollPage = new ScrollPage(getDriver());
        scrollPage.openScrollPage();
        // Steps
        scrollPage.moveToFullName();
        scrollPage.inputFullName(fullName);
        scrollPage.assertElementPresent(ScrollPage.locFullName, "Unable to locate Full Name field.");
        scrollPage.inputDate(date);
        scrollPage.assertElementPresent(ScrollPage.locDate, "Unable to locate Date field.");
    }

    //@Test(groups = "investigating")
    @Test(groups = "regression")
    //@Test(groups = "toFix")
    public void SwitchToActiveWindowTest() {
        // Var
        String welcome = "Welcome to Formy";
        // Initiate
        SwitchWindowPage switchWindowPage = new SwitchWindowPage(getDriver());
        switchWindowPage.openSwitchWindowPage();
        // Steps
        switchWindowPage.clickNewTabButton();
        switchWindowPage.switchToNewTab();
        switchWindowPage.assertTextPresent(SwitchWindowPage.locWelcome,welcome,"Unable to locate "+welcome+" text.");
        switchWindowPage.switchToOriginalTab();
        switchWindowPage.assertElementPresent(SwitchWindowPage.locTabButton,"Unable to locate "+ SwitchWindowPage.originalHandle);
        switchWindowPage.clickAlertButton();
        switchWindowPage.switchToAlert();
        Assert.assertEquals(SwitchWindowPage.alertText,"This is a test alert!","Could not locate alert text.");
        switchWindowPage.acceptAlert();
    }

    //@Test(groups = "investigating")
    @Test(groups = "regression")
    //@Test(groups = "toFix")
    public void JavaScriptExecutorTest() {
        // Var
        // Initiate
        JavaScriptExecutorPage javaScriptExecutorPage = new JavaScriptExecutorPage(getDriver());
        javaScriptExecutorPage.openJavaScriptExecutorPage();
        // Steps
        javaScriptExecutorPage.clickModalButton();
        javaScriptExecutorPage.assertElementPresent(JavaScriptExecutorPage.locCloseButton,"Unable to locate Close button.");
        javaScriptExecutorPage.executeScript();
        javaScriptExecutorPage.assertElementPresent(JavaScriptExecutorPage.locModalButton,"Unable to focus on main page.");
    }

    //@Test(groups = "investigating")
    @Test(groups = "regression")
    //@Test(groups = "toFix")
    public void DragAndDropTest() {
        // Var
        // Initiate
        DragAndDropPage dragAndDropPage = new DragAndDropPage(getDriver());
        dragAndDropPage.openDragAndDropPage();
        // Steps
        dragAndDropPage.assertTextPresent(DragAndDropPage.locBoxText,"Drop here","Unexpected text "+DragAndDropPage.strBoxText+" displayed.");
        dragAndDropPage.dragImageToBox();
        dragAndDropPage.assertTextPresent(DragAndDropPage.locBoxText,"Dropped!","Unexpected text "+DragAndDropPage.strBoxText+" displayed.");
    }

    //@Test(groups = "investigating")
    @Test(groups = "regression")
    //@Test(groups = "toFix")
    public void RadioButtonTest() {
        RadioButtonPage radioButtonPage = new RadioButtonPage(getDriver());
        radioButtonPage.openRadioButtonPage();

        radioButtonPage.clickRadioButton1();
        assertRadioButtonState(true, false, false);

        radioButtonPage.clickRadioButton2();
        assertRadioButtonState(false, true, false);

        radioButtonPage.clickRadioButton3();
        assertRadioButtonState(false, false, true);
    }

    private void assertRadioButtonState(boolean expectedState1, boolean expectedState2, boolean expectedState3) {
        Assert.assertEquals(expectedState1, RadioButtonPage.isSelectedRadioButton1, "Radio button 1 state mismatch.");
        Assert.assertEquals(expectedState2, RadioButtonPage.isSelectedRadioButton2, "Radio button 2 state mismatch.");
        Assert.assertEquals(expectedState3, RadioButtonPage.isSelectedRadioButton3, "Radio button 3 state mismatch.");
    }

    //@Test(groups = "investigating")
    @Test(groups = "regression")
    //@Test(groups = "toFix")
    public void CheckBoxTest() {
        // Var
        // Initiate
        CheckBoxPage checkBoxPage = new CheckBoxPage(getDriver());
        checkBoxPage.openCheckBoxPage();
        // Steps
        // Test Case 1
        checkBoxPage.selectCheckBox1();
        checkBoxPage.deselectCheckBox2();
        Assert.assertTrue(CheckBoxPage.isChangedCheckBox1 && !CheckBoxPage.isChangedCheckBox2 && !CheckBoxPage.isChangedCheckBox3);

        // Test Case 2
        checkBoxPage.selectCheckBox1();
        checkBoxPage.selectCheckBox2();
        checkBoxPage.deselectCheckBox3();
        Assert.assertTrue(CheckBoxPage.isChangedCheckBox1 && CheckBoxPage.isChangedCheckBox2 && !CheckBoxPage.isChangedCheckBox3);

        // Test Case 3
        checkBoxPage.deselectCheckBox1();
        checkBoxPage.selectCheckBox3();
        Assert.assertFalse(CheckBoxPage.isChangedCheckBox1 && CheckBoxPage.isChangedCheckBox2 && CheckBoxPage.isChangedCheckBox3);
    }

    //@Test(groups = "investigating")
    @Test(groups = "regression")
    //@Test(groups = "toFix")
    public void DatePickerTest() {
        // Var
        String date = "01/01/2024";
        // Initiate
        DatePickerPage datePickerPage = new DatePickerPage(getDriver());
        datePickerPage.openDatePickerPage();
        // Steps
        datePickerPage.selectDate(date);
        datePickerPage.assertTextEntered(DatePickerPage.locDateField,date,date + " not entered.");
    }

    //@Test(groups = "investigating")
    @Test(groups = "regression")
    //@Test(groups = "toFix")
    public void DropDownTest() {
        // Var

        // Initiate
        DropDownPage dropDownPage = new DropDownPage(getDriver());
        dropDownPage.openDropDownPage();
        // Steps
        dropDownPage.assertElementPresent(DropDownPage.locDropDownMenu,"Drop-down menu not found.");
        dropDownPage.expandDropDown();
        dropDownPage.assertElementPresent(DropDownPage.locFileUploadOption,"File Upload option not found.");
        dropDownPage.selectOption(DropDownPage.locFileUploadOption);
        FileUploadPage fileUploadPage = new FileUploadPage(getDriver());
        fileUploadPage.assertElementPresent(FileUploadPage.locChooseFileButton,"FileUploadPage loaded successfully.");
    }

}