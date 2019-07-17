package com.youtube.testcases;

import com.youtube.methods.TestMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class Test4 extends TestMethods {

    @Test
    public void task4() {
        try {

            logIn("user2");
            Actions action = new Actions(driver);
            WebElement we = driver.findElement(By.cssSelector(OR.getProperty("clipImg")));
            System.out.println("Locating an clip");
            action.moveToElement(we).moveToElement(driver.findElement(By.xpath(OR.getProperty("mouseOverlay")))).build().perform();
            System.out.println("Hovering with the mouse over the clip image");
            takeScreenshot(); //file appears under resources/Screenshots/scr.png

        } catch (Exception e) {
            fail("Code failed due to an exception");
        }
    }

}
