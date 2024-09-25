package com.pegram.project.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class AndroidActions {

    AndroidDriver driver;

    public AndroidActions(AndroidDriver driver) {
        this.driver = driver;
    }

    public void scrollToText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())." +
                "scrollIntoView(text(\""+text+"\"));"));
    }

    public void openApp() throws InterruptedException {

        //opens app on home screen (do not have access to apk file)
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Fieldwire\"]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]")).click();
    }

    public void resetApp() throws InterruptedException {

        // manually removes added and duplicated tasks and kills/closes the app
        driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"net.fieldwire.app:id/entry_task_container\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Menu\"]")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"net.fieldwire.app:id/text_view_action\" and @text=\"Delete task\"]")).click();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Back\"]")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())." +
                "scrollIntoView(text(\"Client approval on color palette\"));"));
        driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"Task\"])[3]")).click();
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Menu\"]")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"net.fieldwire.app:id/text_view_action\" and @text=\"Delete task\"]")).click();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();

        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 1200,
                "direction", "up",
                "percent", 0.75
        ));
    }

    public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException {
        File source = driver.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + testCaseName + ".png";
        FileHandler.copy(source, new File(destinationFile));

        return destinationFile;
    }
}
