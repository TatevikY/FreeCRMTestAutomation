package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import com.crm.qa.util.TestUtil;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class ContactsNewPageTest extends TestBase {

    //variables
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    ContactsNewPage contactsNewPage;
    ContactsViewPage contactsViewPage;

    String sheetName = "contacts";

    //constructor
    public ContactsNewPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();//parentic kanchumenq es methody vory es methodi   meji sax exacy kani
        loginPage = new LoginPage(); //LoginPage classi nor object enq haytaratum
        //login enq linum app vor sharunakenq test y es eji vra, aysinq before methodum apahovum enq amen inch vory petqa et test hamar
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        contactsPage = homePage.clickOnContactsLink();
        contactsNewPage = contactsPage.createNewContact();
    }

    @Test(priority = 1)// fail a  gnum .ejy bug uni.
    public void verifyContactNewPageLabelTest() {
        Assert.assertTrue(contactsNewPage.verifyContactNewPageLabel());
    }

    //Create data provider, Test utilum nayel methody
    @DataProvider
    public Object[][] getCRMTestData() {
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 2, dataProvider = "getCRMTestData")
    public void createNewContactTest(String firstName, String lastName, String middleName) {
       // WebDriverWait wait = new WebDriverWait(driver,30);
        contactsViewPage = contactsNewPage.fillNewContactForm(firstName, lastName, middleName);
       // WebDriverWait wait = new WebDriverWait(driver,15);
        contactsPage = homePage.clickOnContactsLink();
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }
}
