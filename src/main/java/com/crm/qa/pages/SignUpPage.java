package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends TestBase {
    //variables
    @FindBy(xpath = "//div[@class='ui three bottom attached steps']")
    WebElement stepPanel;

    @FindBy(xpath = "//input[@name='email']")
    WebElement signUpEmail;

    @FindBy(xpath = "//input[@class='search']")
    WebElement countryCodeSearch;

    @FindBy(xpath = "//input[@name='phone']")
    WebElement mobileNumber;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    WebElement notRobotCheckbox;

    @FindBy(xpath = "//button[@type='submit'][@name='action'][@class=\"ui fluid large blue submit button\"]")
    WebElement signupbutton;

    //constructor
    public SignUpPage(){
        PageFactory.initElements(driver, this);
    }

    //methods
//check page
    //enter email
    // choose country code
    // enter phone number
    //click check box of termas
    //chlick checkbox of not robot
    // chicl sign up


}
