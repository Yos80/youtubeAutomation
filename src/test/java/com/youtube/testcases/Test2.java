package com.youtube.testcases;

import com.youtube.methods.TestMethods;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class Test2 extends TestMethods {

    @Test
    public void task2() {
        try {

            logIn("user2");
            driver.findElement(By.linkText(OR.getProperty("myplaylistBtn"))).click();
            System.out.println("Pressing on :" + OR.getProperty("myplaylistBtn"));
            driver.findElement(By.linkText(OR.getProperty("playallBtn"))).click();
            System.out.println("Pressing on :" + OR.getProperty("playallBtn"));
            Thread.sleep(3000);
            driver.findElements(By.xpath("//ytd-playlist-panel-video-renderer[@class='style-scope ytd-playlist-panel-renderer']")).get(3).click();
            System.out.println("Clicking on another playlist item according to index number");
            Thread.sleep(3000);

        } catch (Exception e) {
            fail("Code failed due to an exception");
        }

    }

}
