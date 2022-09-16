package com.nexton.cloudapp.qa.baseTest;

import com.nexton.cloudapp.qa.driver.Driver;
import com.nexton.cloudapp.qa.enums.ConfigProperties;
import com.nexton.cloudapp.qa.pages.*;
import com.nexton.cloudapp.qa.utils.ReaderPropertyFile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

@Listeners(com.nexton.cloudapp.qa.listeners.ListenerClass.class)
public class BaseTest {

    protected SoftAssert softAssert = new SoftAssert();
    protected HomePage homePage = new HomePage();
    protected SignUpPage signUpPage = new SignUpPage();
    protected OnboardingPage onboardingPage = new OnboardingPage();
    protected LoginPage loginPage = new LoginPage();
    protected DashboardPage dashboardPage = new DashboardPage();

    @BeforeMethod
    protected void setUp() throws Exception {

        Driver.initDriver(ReaderPropertyFile.getValue(ConfigProperties.BROWSER));

    }


    @AfterMethod
    protected void tearDown() {

        Driver.quitDriver();
    }
}
