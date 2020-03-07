package com.crm.qa.pages;

import com.crm.qa.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Page Factory - OR;

    //username
    @FindBy(name = "email")
    WebElement username;

    //password
    @FindBy(name = "password")
    WebElement password;

    //Login  button on home page
    @FindBy(xpath = "//a[contains(@class,'btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left')]")
    WebElement loginBtn1;

    //Login  button in login page
    @FindBy(xpath = "//div[contains(@class,'ui fluid large blue submit button')]")
    WebElement loginBtn2;

    //sign up button
    @FindBy(xpath = "//button[contains(text(),'Sign up')]")
    WebElement signUpBtn;

    //image
    @FindBy(xpath = "//a[contains(@class,'brand-name')]") // //img[contains(@class,"brand-name")]
    WebElement crmLogo;

    //initialize the elements that are created above.Do that with creating the constructor of this class
    public LoginPage(){
        PageFactory.initElements(driver, this); //all vars in this class will be init with this driver
    }


    //create a method-----------------------------------------------------------------------------------------
    //Actions
    public String validateLoginPageTitile(){
        return driver.getTitle();//qani vor gettitley stringa get berum menq
    }

    public boolean validateCRMImage(){
        return  crmLogo.isDisplayed();
    }

    public HomePage login(String un, String pwd){
        loginBtn1.click();
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn2.click();
        //qani vor loginic heto gnaluya home page ira return type pti lini homepage objecty
        return new HomePage();
    }

    
}
