package com.nexton.cloudapp.qa.utils;

import com.nexton.cloudapp.qa.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotsUtils {
    private ScreenshotsUtils() {

    }

    public static String getBase64Image() {


        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

    }
}
