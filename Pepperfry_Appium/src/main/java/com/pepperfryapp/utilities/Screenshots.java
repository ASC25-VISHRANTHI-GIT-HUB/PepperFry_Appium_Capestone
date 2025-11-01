package com.pepperfryapp.utilities;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Screenshots {
    public static String capture(AppiumDriver driver, String fileName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destPath = "src/test/resources/Screenshots/" + fileName + ".png";
        try {
            Files.copy(src.toPath(), new File(destPath).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destPath;
    }
}
