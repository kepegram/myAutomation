package com.pegram.project.snap.userAuth;

import com.pegram.project.snap.pageObjects.AuthPage;
import com.pegram.project.testUtils.Setup;
import org.testng.annotations.Test;

public class SnapAuth extends Setup {

    @Test (description = "First time user sign up")
    public void Signup() throws InterruptedException {
        AuthPage authPage = new AuthPage(driver);

        authPage.Signup();
    }

//    @Test
//    public void Login() throws InterruptedException {
//        AuthPage authPage = new AuthPage(driver);
//
//        authPage.openSnapApp();
//    }
}
