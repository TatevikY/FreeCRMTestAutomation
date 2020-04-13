package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {
    //variables
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;

    //constructor
    public ContactsPageTest() {
        super();
    }


    @BeforeMethod
    public void setUp() {
        initialization();//parentic kanchumenq es methody vory es methodi   meji sax exacy kani
        loginPage = new LoginPage(); //LoginPage classi nor object enq haytaratum
        //login enq linum app vor sharunakenq test y es eji vra, aysinq before methodum apahovum enq amen inch vory petqa et test hamar
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        contactsPage = homePage.clickOnContactsLink();
    }

    @Test(priority = 1)
    public void verifyContactsPageLabelTest() {
        //kam sen c kam nerqevini nman
        //  boolean username = homePage.verifyUserNameLabel();
        //  Assert.assertTrue(username);
        Assert.assertTrue(contactsPage.verifyContactsPageLabel());
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
