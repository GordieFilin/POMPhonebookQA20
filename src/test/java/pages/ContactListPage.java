package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class ContactListPage extends BasePage{
    public ContactListPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@text='Contact list']")
    MobileElement textTitle;
    @FindBy(xpath = "//*[@text='No Contacts. Add One more!']")
    MobileElement contactTitle;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/regBtn']")
    MobileElement btnRegistration;

    @FindBy(xpath = "//*[@resource-id='android:id/alertTitle']")
    MobileElement titleErrorTextAlert;


    public boolean validateContactListOpened() {
        return isTextEqual(textTitle, "Contact list");
    }

    public boolean validateReg() {
        return isTextEqual(contactTitle, "No Contacts. Add One more!");
    }

    public ContactListPage clickRegBtnNegative() {
        clickBase(btnRegistration);
        return this;
    }

    public boolean validateErrorTitleAlertCorrect() {
        return isTextEqual(titleErrorTextAlert, "Error");
    }
}
