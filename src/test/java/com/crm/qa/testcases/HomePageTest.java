package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    //variables
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;


    //constructor
    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();//parentic kanchumenq es methody vory es methodi   meji sax exacy kani
        loginPage = new LoginPage(); //LoginPage classi nor object enq haytaratum
        //login enq linum app vor sharunakenq test y es eji vra, aysinq before methodum apahovum enq amen inch vory petqa et test hamar
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1 /*, enabled = true, groups = { "sanity" }*/)
    public void verifyHomePageTitleTest() {
        String homePageTitle = homePage.verifyHomePageTile();
        Assert.assertEquals(homePageTitle, "Cogmento CRM", "This is for reporting ! /home page/");
    }

    @Test(priority = 2)
    public void verifyUserNameLabelTest() {
        //kam sen c kam nerqevini nman
        //  boolean username = homePage.verifyUserNameLabel();
        //  Assert.assertTrue(username);
        Assert.assertTrue(homePage.verifyUserNameLabel());
    }

    @Test(priority = 3)
    public void verifyContactsLinkTest(){
        contactsPage = new ContactsPage();
        contactsPage = homePage.clickOnContactsLink();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
