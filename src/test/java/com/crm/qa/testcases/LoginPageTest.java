package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import org.apache.log4j.Logger;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LoginPage loginPage; //class level variable enq haytararum u heto setUP() um object haytararum.
    HomePage homePage;

    //constructor of login test class
    public LoginPageTest() {
        super();//es super keywordy kkanchi parent classi constructorin vory init kani propy vortex set upa arac driver settingsy
    }

    Logger log = Logger.getLogger(LoginPageTest.class);

    @BeforeMethod
    public void setUp() {
        initialization();//parentic kanchumenq es methody vory es methodi   meji sax exacy kani
        loginPage = new LoginPage(); //LoginPage classi nor object enq haytaratum

    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        log.info("executing 1st test");
        String title = loginPage.validateLoginPageTitile();
        log.info("title is --->" + title);
        Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small","Login title idn't matched."); //hamematum enq eji stacvac vernagiry expectedi het
    }

    @Test(priority = 2)
    public void crmLogoImageTest() {
        boolean flag = loginPage.validateCRMImage();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginTest() {
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
