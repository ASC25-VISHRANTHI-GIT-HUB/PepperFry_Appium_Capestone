package com.pepperfryapp.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.net.URL;

public class BaseTest {

    protected AppiumDriver driver;

    @BeforeClass
    public void setup() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setPlatformVersion("13");
        options.setDeviceName("Vishranthi Arun");
        options.setUdid("192.168.29.75:40153");

        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.app.pepperfry");
        options.setAppActivity("com.app.pepperfry.main.MainActivity");
        options.setNoReset(true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        System.out.println(" Appium session started successfully");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Appium session closed");
        }
    }
}
