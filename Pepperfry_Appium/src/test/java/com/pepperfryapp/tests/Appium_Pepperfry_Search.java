package com.pepperfryapp.tests;

import com.pepperfryapp.base.BaseTest;
import com.pepperfryapp.utilities.ExtentManager;
import com.aventstack.extentreports.*;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.annotations.Test;

public class Appium_Pepperfry_Search extends BaseTest {

    @Test
    public void testSearchAndSelectItem() {
        ExtentReports extent = ExtentManager.getInstance();
        ExtentTest test = extent.createTest("Pepperfry Search & Select Item Test");

        try {
            // Wait setup
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

            //  Click search bar
            wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.id("com.app.pepperfry:id/etSearch"))).click();
            test.info("Clicked on search bar");

            //  Enter search keyword
            driver.findElement(AppiumBy.id("com.app.pepperfry:id/etSearch"))
                  .sendKeys("Table");
            test.info("Entered search text: Table");

            //  Click first suggestion (ensure id is correct — usually tvCategoryName or similar)
            wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.id("com.app.pepperfry:id/tvCategoryName"))).click();
            test.info("Clicked on first search suggestion");

            //  Wait for search results and click the first product image
            wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.app.pepperfry:id/tvProductName\"])[3]"))).click();
            test.pass("Clicked on the first product successfully");

        } catch (Exception e) {
            test.fail("Test failed due to: " + e.getMessage());
            e.printStackTrace();
        } finally {
            extent.flush();
        }
    }
}
