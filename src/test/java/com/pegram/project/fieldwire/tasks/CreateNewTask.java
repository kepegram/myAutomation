package com.pegram.project.fieldwire.tasks;

import com.pegram.project.testUtils.Setup;
import com.pegram.project.pageObjects.TasksPage;
import org.testng.annotations.Test;

public class CreateNewTask extends Setup {

    @Test
    public void NewTask() throws InterruptedException {
        /*
        Scrolls to a chosen priority 3 task
        Opens task and adds a new related task
        Sends text to the new task and asserts task creation
        */
        TasksPage tasksPage = new TasksPage(driver);

        tasksPage.selectPrio3Task("Sawcutting sidewalk in progress");
        tasksPage.createRelatedTask("Wash concrete debris");
        tasksPage.assertTaskCreation("text", "Wash concrete debris");
    }
}
