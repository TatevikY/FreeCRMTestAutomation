package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactsNewPage extends TestBase {

    //variables
    @FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
           // @CacheLookup /// variable cahsha  anum broswerum u hajorj angam dimeluc cashica berum .speedi hamar lava.harmara erb vor et variabley shata ogtagorcvum
            // u amen angam browery kanchelu poxaren cacheic kkanchi
            //!!!!!!!bayc ete ejy refresha linum chach memeorun koruma.

    WebElement contactsNewPageLabel;

    @FindBy(xpath = "//input[@name='first_name']")
    WebElement first_name;
    //div[@class='ui fluid container']//form[@class='ui form segment custom-form-container']//input[@name='first_name']

    @FindBy(xpath = "//input[@name='last_name']")
    WebElement last_name;

    @FindBy(xpath = "//input[@name='middle_name']")
    WebElement middle_name;

    @FindBy(xpath = "//div[@name='company']")
    WebElement company;

    @FindBy(xpath = "//button[@class='ui small fluid negative toggle button']")
    WebElement accessButton;

    @FindBy(xpath = "//button[@class='ui linkedin button']")
    WebElement saveButton;

    public ContactsNewPage() {
        PageFactory.initElements(driver, this); //all vars in this class will be init with this driver
    }

    //methods
    public boolean verifyContactNewPageLabel() {
        driver.manage().deleteAllCookies();
        return contactsNewPageLabel.isDisplayed();
    }

    public ContactsViewPage fillNewContactForm(String firstName, String lastName, String middleName) {
        first_name.sendKeys(firstName);
        last_name.sendKeys(lastName);
        middle_name.sendKeys(middleName);
        saveButton.click();
        return new ContactsViewPage();
    }


}
