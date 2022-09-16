package com.nexton.cloudapp.qa.test;

import com.nexton.cloudapp.qa.baseTest.BaseTest;
import com.nexton.cloudapp.qa.utils.ExcelUtils;
import org.testng.annotations.Test;

public class TestSignUpPage extends BaseTest {
    @Test(priority = 0, description = "Register with the correct email and password")
    public void signUpScenario() throws Exception {
        homePage.clickSignUpBtn();
        signUpPage.sendValueEmailInp(ExcelUtils.getCellStringData("signUpData", 1, 0));
        System.out.println("EMail: "+ExcelUtils.getCellStringData("signUpData", 1, 0));
        signUpPage.sendValuePassInp(ExcelUtils.getCellStringData("signUpData", 0, 1));
        System.out.println("Password:  "+ExcelUtils.getCellStringData("signUpData", 0, 1));
        signUpPage.clickSignUpBtn();
        String m =onboardingPage.getTextMessage();
        softAssert.assertEquals(m, "Account created successfully");
    }

    @Test(priority = 1, description = "Register with a registered email address")
    public void signUpSameEmailScenario() throws Exception {
        homePage.clickSignUpBtn();
        signUpPage.sendValueEmailInp(ExcelUtils.getCellStringData("signUpData", 0, 0));
        System.out.println("EMail: "+ExcelUtils.getCellStringData("signUpData", 0, 0));
        signUpPage.sendValuePassInp(ExcelUtils.getCellStringData("signUpData", 0, 1));
        System.out.println("Password:  "+ExcelUtils.getCellStringData("signUpData", 0, 1));
        signUpPage.clickSignUpBtn();
        String m =onboardingPage.getTextMessageValidationFailed();
        softAssert.assertEquals(m, "Validation failed: Email has already been taken");
    }
}
