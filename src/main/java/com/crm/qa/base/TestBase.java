package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

    //initialize the webdriver
    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;
//    public static Logger log;

    //create TestBase class constructor
    public TestBase() {
//        Logger log = Logger.getLogger(TestBase.class);
        //reading properties, and initializing prop variable
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    // System.getProperty("user.dir") +
                    "src/main/java/com/crm/qa/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //create an initialization method
    public static void initialization() {
        //here from properties config file we get what broweser we are going to use
        //and with if function define what driver to run if we have different browsers
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C://Users//Tatevik Yayloyan//IdeaProjects//FreeCRMTestAutomation//chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "geckodriver");
            driver = new FirefoxDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;


//        log.info("launching chrome broswer");


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
//         driver.get("chrome://settings/clearBrowserData");
//         driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
//        log.info("entering application URL");
//        log.warn("Hey this just a warning message");
//        log.fatal("hey this is just fatal error message");
//        log.debug("this is debug message");

    }

}
