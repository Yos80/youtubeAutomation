package com.youtube.methods;

import com.youtube.base.TestBase;
import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;

public class TestMethods extends TestBase {

    public void logIn(String user) {
        if (user == "user1") {
            driver.findElement(By.linkText(OR.getProperty("text4"))).click();
            WebElement username = driver.findElement(By.id(OR.getProperty("userNameField")));
            username.sendKeys(config.getProperty("user1"));
            username.sendKeys(Keys.ENTER);
            WebElement password = driver.findElement(By.name(OR.getProperty("passWordField")));
            password.sendKeys(config.getProperty("pass1"));
            password.sendKeys(Keys.ENTER);
            System.out.println("User1 is logged in");
        } else if (user == "user2") {
            driver.findElement(By.linkText(OR.getProperty("text4"))).click();
            WebElement username = driver.findElement(By.id(OR.getProperty("userNameField")));
            username.sendKeys(config.getProperty("user2"));
            username.sendKeys(Keys.ENTER);
            WebElement password = driver.findElement(By.name(OR.getProperty("passWordField")));
            password.sendKeys(config.getProperty("pass2"));
            password.sendKeys(Keys.ENTER);
            System.out.println("User2 is logged in");

        } else {
            driver.quit();
        }

    }

    public void takeScreenshot(){
        // Take screenshot and store as a file format
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            // now copy the  screenshot to desired location using copyFile //method
            FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "/src/main/resources/Screenshots/scr.png"));
        }

        catch (IOException e)
        {
            System.out.println(e.getMessage());

        }
    }


}
