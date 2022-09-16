package com.nexton.cloudapp.qa.listeners;

import com.nexton.cloudapp.qa.reports.ExtentLogger;
import com.nexton.cloudapp.qa.reports.ExtentReport;
import org.testng.*;

import java.util.Arrays;

public class ListenerClass implements ITestListener, ISuiteListener {
    public void onStart(ISuite arg0) {
        try {
            ExtentReport.initReports();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void onFinish(ISuite arg0) {
//        try {
//            ExtentReport.flushReports();
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }

    }

    public void onFinish(ITestContext arg0) {
        /*
         * We don't have any special implementation
         */
    }

    public void onStart(ITestContext arg0) {
        /*
         * We don't have any special implementation
         */

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        /*
         * For now, it won't be used.
         */

    }

    public void onTestFailure(ITestResult result) {

        try {
            ExtentLogger.fail(result.getMethod().getMethodName() + " is failed", true);
            ExtentLogger.fail(result.getThrowable().toString());
            ExtentLogger.fail(result.getThrowable().getMessage());
            ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped");

    }

    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());

    }

    public void onTestSuccess(ITestResult result) {


        try {
            ExtentLogger.pass(result.getMethod().getMethodName() + " is passed", true);
            ExtentLogger.pass(result.getTestName());

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
