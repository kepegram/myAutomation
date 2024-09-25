package com.pegram.project.fieldwire.tasks;

import com.pegram.project.testUtils.Setup;
import com.pegram.project.pageObjects.TasksPage;
import org.testng.annotations.Test;

public class DuplicateTasks extends Setup {

    @Test
    public void DuplicateTask() throws InterruptedException {
        /*
        Assumes project is already downloaded
        Navigates to tasks
        Selects a task
        Duplicates that task
        Returns to task screen and verifies task has been duplicated successfully
        */

        TasksPage tasksPage = new TasksPage(driver);

        tasksPage.selectTasks();
        tasksPage.duplicateTasks();
        tasksPage.assertTaskDuplication("text", "Client approval on colour palette");
    }
}
