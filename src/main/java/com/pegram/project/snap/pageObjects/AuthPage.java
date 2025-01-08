package com.pegram.project.snap.pageObjects;

import com.google.common.collect.ImmutableMap;
import com.pegram.project.fieldwire.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AuthPage extends AndroidActions {

    AndroidDriver driver;

    public AuthPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void Signup() throws InterruptedException {
        openSnapApp();
        Thread.sleep(3000);
        SignUp.click();
        Thread.sleep(1000);

        //Name
        NameField.sendKeys("Sylvester Tester");
        Continue.click();

        //Birthday
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 1200,
                "direction", "up",
                "percent", 0.75
        ));


    }

    public void Login() throws InterruptedException {
        openSnapApp();
        Thread.sleep(1000);
    }

    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"com.snapchat.android:id/bottom_button\"]")
    private WebElement SignUp;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.snapchat.android:id/display_name_first_name_field\"]")
    private WebElement NameField;

    @AndroidFindBy(xpath = "(//android.widget.FrameLayout[@resource-id=\"com.snapchat.android:id/0_resource_name_obfuscated\"])[2]/android.widget.LinearLayout")
    private WebElement Continue;
}
