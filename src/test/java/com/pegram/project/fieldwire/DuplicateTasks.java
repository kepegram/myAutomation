package com.pegram.project.fieldwire;

import com.pegram.project.Setup;
import com.pegram.project.pageObjects.TasksPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DuplicateTasks extends Setup {

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
        TasksPage tasksPage = new TasksPage(driver);
        tasksPage.selectTasks();
        tasksPage.duplicateTasks();

        //asserts if new task was created
        tasksPage.assertTaskCreation("text", "Client approval on color palette");

        tearDown();

    }
}
