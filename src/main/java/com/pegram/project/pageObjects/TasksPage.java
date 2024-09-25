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

    // duplicating task methods

    public void selectTasks() throws InterruptedException {
        openApp();
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
        Thread.sleep(1000);
        Back.click();
        Thread.sleep(1000);
    }

    public void assertTaskDuplication(String attribute, String expectedText) {
        Assert.assertEquals(DuplicatedTask.getAttribute(attribute), expectedText);
    }

    // creating new task methods

    public void selectPrio3Task(String prio3Task) throws InterruptedException {
        scrollToText(prio3Task);
        Thread.sleep(1000);
        Prio3Task.click();
    }

    public void createRelatedTask(String task) throws InterruptedException {
        AttachButton.click();
        RelatedTaskButton.click();
        CreateNewTaskButton.click();
        Thread.sleep(1000);
        NewTaskInput.sendKeys(task);
        ConfirmButton.click();
    }

    public void assertTaskCreation(String attribute, String expectedText) throws InterruptedException {
        Assert.assertEquals(NewTask.getAttribute(attribute), expectedText);
        Thread.sleep(1000);
        resetApp();
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
    private WebElement DuplicatedTask;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"net.fieldwire.app:id/task_title\" and @text=\"Sawcutting sidewalk in progress\"]")
    private WebElement Prio3Task;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"net.fieldwire.app:id/attach\"]")
    private WebElement AttachButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"net.fieldwire.app:id/text\" and @text=\"Related task\"]")
    private WebElement RelatedTaskButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"net.fieldwire.app:id/text\" and @text=\"Create new task\"]")
    private WebElement CreateNewTaskButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"net.fieldwire.app:id/text_input\"]")
    private WebElement NewTaskInput;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"net.fieldwire.app:id/positive_button\"]")
    private WebElement ConfirmButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"net.fieldwire.app:id/task_title\" and @text=\"Wash concrete debris\"]")
    private WebElement NewTask;

}
