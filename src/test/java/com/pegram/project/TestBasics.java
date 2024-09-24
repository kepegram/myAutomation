package com.pegram.project;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class TestBasics extends Setup {

    @Test
    public void DuplicateTask() throws InterruptedException {
        /*
        Assumes project is already downloaded
        Navigates to tasks
        Selects a task with an active checklist
        Toggles one item approved
        Toggles one item denied
        Duplicates a task
        Returns to task screen and verifies task has been duplicated successfully
        */
        driver.findElement(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"net.fieldwire.app:id/group_title\" and @text=\"Tasks\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"Task\"])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"net.fieldwire.app:id/task_check_item\"])[1]")).click();
        driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"net.fieldwire.app:id/task_check_item\"])[4]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"net.fieldwire.app:id/task_check_item\"])[4]")).click();
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Menu\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"net.fieldwire.app:id/text_view_action\" and @text=\"Duplicate task\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Back\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Back\"]")).click();

        //add code here to verify new task was created


        tearDown();

    }
}
