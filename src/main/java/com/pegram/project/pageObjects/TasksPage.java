package com.pegram.project.pageObjects;

import com.pegram.project.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TasksPage extends AndroidActions {

    AndroidDriver driver;

    public TasksPage(AndroidDriver driver) {
        // initializes child driver with parent driver (from Android Actions)
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"net.fieldwire.app:id/group_title\" and @text=\"Tasks\"]")
    private WebElement Tasks;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"Task\"])[2]")
    private WebElement SecondTask;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Menu\"]")
    private WebElement Menu;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"net.fieldwire.app:id/text_view_action\" and @text=\"Duplicate task\"]")
    private WebElement Duplicate;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Back\"]")
    private WebElement Back;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"net.fieldwire.app:id/task_title\"])[3]")
    private WebElement NewTask;

    public void selectTasks() throws InterruptedException {
        Tasks.click();
        Thread.sleep(2000);
        SecondTask.click();
        Thread.sleep(1000);
    }

    public void duplicateTasks() throws InterruptedException {
        Menu.click();
        Thread.sleep(1000);
        Duplicate.click();
        Thread.sleep(1000);
        Back.click();
        Back.click();
        Thread.sleep(1000);
    }

    public void assertTaskCreation(String attribute, String expectedText) {
        Assert.assertEquals(NewTask.getAttribute(attribute), expectedText);
    }

}
