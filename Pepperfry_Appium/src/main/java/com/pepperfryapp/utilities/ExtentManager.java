package com.pepperfryapp.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }

    private static void createInstance() {
        try {
            // ✅ Save inside src/test/resources/Reports/
            String reportPath = System.getProperty("user.dir") +
                    "/src/test/resources/Reports/Pepperfry_Test_Report.html";

            File reportFile = new File(reportPath);
            reportFile.getParentFile().mkdirs(); // create Reports folder if missing

            ExtentSparkReporter spark = new ExtentSparkReporter(reportFile);
            spark.config().setDocumentTitle("Pepperfry Appium Automation Report");
            spark.config().setReportName("Pepperfry Appium Test Execution");
            spark.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Tester", "Vishranthi");
            extent.setSystemInfo("Platform", "Android");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
