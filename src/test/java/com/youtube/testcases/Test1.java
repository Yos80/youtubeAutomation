package com.youtube.testcases;

import com.youtube.methods.TestMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;


public class Test1 extends TestMethods {


    @Test
    public void task1() {
        try {


            logIn("user1");
            WebElement searchBox = driver.findElement(By.id(OR.getProperty("searchField")));
            searchBox.sendKeys(config.getProperty("songname1"));
            System.out.println("Entered search value :" + config.getProperty("songname1"));
            searchBox.sendKeys(Keys.RETURN);
            driver.findElements(By.xpath("//ytd-video-renderer[@class='style-scope ytd-item-section-renderer']")).get(2).click();
            System.out.println("Clicking on the item in list according to index number");
            Thread.sleep(3000);

        } catch (Exception e) {
            fail("Code failed due to an exception");
        }

        //------Tried opening in a new tab/window using this code but didn't work on my MacBook----//
        //WebElement oWE= driver.findElements(By.xpath("//ytd-video-renderer[@class='style-scope ytd-item-section-renderer']")).get(3);
        //Actions oAction=new Actions(driver);
        //oAction.moveToElement(oWE);
        //oAction.contextClick(oWE).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();


    }

}