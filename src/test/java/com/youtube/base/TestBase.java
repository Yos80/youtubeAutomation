package com.youtube.base;

import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;


    //@BeforeMethod
    @BeforeClass
    public void setUp() {

        if (driver == null) {

            FileInputStream fis = null;
            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/properties/Config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                config.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/properties/OR.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                OR.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (config.getProperty("browser").equals("firefox")) {

                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/executables/geckodriver");
                driver = new FirefoxDriver();

            } else if (config.getProperty("browser").equals("chrome")) {

                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/executables/chromedriver");
                driver = new ChromeDriver();

            } else if (config.getProperty("browser").equals("ie")) {

                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/src/main/resources/executables/IEDriverServer");
                driver = new InternetExplorerDriver();

            }
            driver.get(config.getProperty("testsiteurl"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);

        }


    }


    //@AfterMethod
    @AfterClass
    public void tearDown() {

        if (driver == null) {
            return;
        }
        driver.quit();
        driver = null;
    }
}
