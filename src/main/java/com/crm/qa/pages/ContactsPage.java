package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactsPage extends TestBase {
    //variables
    @FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
    WebElement contactsLabel;

    @FindBy(xpath = "//a//button[@class='ui linkedin button'][1]//i[@class='edit icon']")
    WebElement createNewContact;

    @FindBy(xpath = "//i[@class='download icon']")
    WebElement exportContactList;

    @FindBy(xpath = "//button[@class='ui linkedin button'][1]")
    WebElement showFilters;

    //constructor
    public ContactsPage() {
        PageFactory.initElements(driver, this); //all vars in this class will be init with this driver
    }

    //methods
    public boolean verifyContactsPageLabel(){
        return contactsLabel.isDisplayed();
    }

    public ContactsNewPage createNewContact() {
       // WebDriverWait wait = new WebDriverWait(driver,30);
        createNewContact.click();
        return new ContactsNewPage();
    }





}
