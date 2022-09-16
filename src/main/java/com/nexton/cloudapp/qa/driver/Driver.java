package com.nexton.cloudapp.qa.driver;

import com.nexton.cloudapp.qa.constants.FrameworkConstants;
import com.nexton.cloudapp.qa.enums.ConfigProperties;
import com.nexton.cloudapp.qa.utils.ReaderPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver() {
    }

    public static void initDriver(String browser) throws Exception {

        if (Objects.isNull(DriverManager.getDriver())) {

            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                DriverManager.setDriver(new ChromeDriver());

            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                DriverManager.setDriver(new FirefoxDriver());

            } else if (browser.equalsIgnoreCase("ie")) {
                WebDriverManager.iedriver().setup();
                DriverManager.setDriver(new InternetExplorerDriver());

            } else if (browser.equalsIgnoreCase("opera")) {
                WebDriverManager.operadriver().setup();
                DriverManager.setDriver(new OperaDriver());

            } else if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                DriverManager.setDriver(new EdgeDriver());

            }

            DriverManager.getDriver().get(ReaderPropertyFile.getValue(ConfigProperties.URL));
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().deleteAllCookies();
            DriverManager.getDriver().manage().timeouts().getPageLoadTimeout();
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unLoad();

        }

    }
}
