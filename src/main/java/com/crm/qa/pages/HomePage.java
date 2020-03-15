package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.Normalizer;

public class HomePage extends TestBase {
    //elements
    @FindBy(xpath = "//span[@class='user-display']")
    WebElement userNameLabel;

    @FindBy(xpath = "//a[@href='/home']")
    WebElement homeLink;

    @FindBy(xpath = "//a[@href='/calendar']")
    WebElement calendarLink;

    @FindBy(xpath = "//a[@href='/contacts']")
    WebElement contactsLink;

    @FindBy(xpath = "//a[@href='/companies']")
    WebElement companiesLink;

    @FindBy(xpath = "//a[@href='/deals']")
    WebElement dealsLink;

    @FindBy(xpath = "//a[@href='/tasks']")
    WebElement tasksLink;

    @FindBy(xpath = "//a[@href='/cases']")
    WebElement casesLink;

    @FindBy(xpath = "//a[@href='/calls']")
    WebElement callsLink;

    @FindBy(xpath = "//a[@href='/documents']")
    WebElement documentsLink;

    @FindBy(xpath = "//a[@href='/email']")
    WebElement emailLink;

    @FindBy(xpath = "//a[@href='/campaigns']")
    WebElement campaignsLink;

    @FindBy(xpath = "//a[@href='/forms']")
    WebElement formLink;

    //constructor
    public HomePage() {
        PageFactory.initElements(driver, this); //all vars in this class will be init with this driver
    }

    //methods
    public String verifyHomePageTile() {
        return driver.getTitle();
    }

    public boolean verifyUserNameLabel(){
        return userNameLabel.isDisplayed();
    }

    public HomePage clickOnHomePageLink() {
        homeLink.click();
        return new HomePage();
    }

    public CalendarPage clickOnCalendarLink() {
        calendarLink.click();
        return new CalendarPage();
    }

    public ContactsPage clickOnContactsLink() {
        contactsLink.click();
        return new ContactsPage();
    }

    public CompaniesPage clickOnCompaniesLink() {
        companiesLink.click();
        return new CompaniesPage();
    }

    public DealsPage clickOnDealsLink() {
        dealsLink.click();
        return new DealsPage();
    }

    public TasksPage clickOnTasksLink() {
        tasksLink.click();
        return new TasksPage();
    }

    public CasesPage clickOnCasesLink() {
        casesLink.click();
        return new CasesPage();
    }

    public CallsPage clickOnCallsLink() {
        callsLink.click();
        return new CallsPage();
    }

    public DocumentsPage clickOnDocumentsLink() {
        documentsLink.click();
        return new DocumentsPage();
    }

    public EmailPage clickOnEmailLink() {
        emailLink.click();
        return new EmailPage();
    }

    public CampaignsPage clickOnCampaignsLink() {
        campaignsLink.click();
        return new CampaignsPage();
    }

    public FormsPage clickOnFormsLink() {
        formLink.click();
        return new FormsPage();
    }


}
