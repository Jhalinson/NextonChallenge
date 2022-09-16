package com.nexton.cloudapp.qa.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.nexton.cloudapp.qa.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.util.Objects;

public class ExtentReport {
    public static ExtentReports extent;

    private ExtentReport() {

    }

    public static void initReports() throws Exception {

        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentreportpath());
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("My Store Report");
            extent.attachReporter(spark);
        }
        extent.setSystemInfo("Company Name", "Nexton");
        extent.setSystemInfo("Project Name", "CloudApp");
        extent.setSystemInfo("Department Name", "QA");
        extent.setSystemInfo("SDET Name", "Jhalinson Acosta");


    }

//    public static void flushReports() throws Exception {
//        if (Objects.nonNull(extent)) {
//            extent.flush();
//        }
//        try {
//            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentreportpath()).toURI());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    public static void createTest(String testCaseName) {

        ExtentManager.setExtentTest(extent.createTest(testCaseName));
    }
}
