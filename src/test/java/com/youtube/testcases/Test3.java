package com.youtube.testcases;

import com.youtube.methods.TestMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class Test3 extends TestMethods {

    @Test
    public void task3() {
        try {

            logIn("user1");
            WebElement searchBox = driver.findElement(By.id(OR.getProperty("searchField")));
            searchBox.sendKeys(config.getProperty("songname2"), Keys.ENTER);
            System.out.println("Entered search value :" + config.getProperty("songname2"));
            driver.findElement(By.xpath(OR.getProperty("text1"))).click();
            System.out.println("Pressing on :" + OR.getProperty("text1"));
            Thread.sleep(5000); // so you can see the song is playing
            String actualString = driver.findElement(By.xpath("//*[@id=\"container\"]/h1/yt-formatted-string")).getText();
            assertTrue(actualString.contains("Santana - Maria Maria"));

        } catch (Exception e) {
            fail("Code failed due to an exception");
        }

    }

}
