package com.pegram.project;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class Setup {

    public AndroidDriver driver;
//    public AppiumDriverLocalService service;

    @BeforeClass
    public void ConfigureAppium() throws URISyntaxException, InterruptedException, MalformedURLException {

        // starts appium server locally (need to change filepath when on mac)
//        service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//KAYPC//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
//                .withIPAddress("127.0.0.1").usingPort(4723).build();
//        service.start();

        // initialize Android options & driver
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 8 Pro API 30");
//        options.setApp("C://Users//KAYPC//Desktop//personal-projects//appium-project//src//test//java//com//pegram//project//resources//ApiDemos-debug.apk");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);

        //opens app on home screen (do not have access to apk file)
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Fieldwire\"]")).click();
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
//        service.stop();
    }
}
