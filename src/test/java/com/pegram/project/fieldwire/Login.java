package com.pegram.project.fieldwire;

import com.pegram.project.testUtils.Setup;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Login extends Setup {

    @Test
    public void HandleLogin() throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Log in\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("net.fieldwire.app:id/email_input"))
                .sendKeys("kepegram@comcast.net");
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Next\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("net.fieldwire.app:id/password_input"))
                .sendKeys("falcons2526!");
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Log in\"]")).click();
        Thread.sleep(2000);
    }
}
