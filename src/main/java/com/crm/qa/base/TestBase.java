package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.AsynchronousCloseException;
import java.sql.Time;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    //initialize the webdriver
    public static WebDriver driver;
    public static Properties prop;

    //create TestBase class constructor
    public TestBase() {

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

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));

    }

}
