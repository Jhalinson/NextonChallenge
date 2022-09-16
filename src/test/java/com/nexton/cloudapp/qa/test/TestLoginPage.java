package com.nexton.cloudapp.qa.test;

import com.nexton.cloudapp.qa.baseTest.BaseTest;
import com.nexton.cloudapp.qa.utils.ExcelUtils;
import org.testng.annotations.Test;

public class TestLoginPage extends BaseTest {

    @Test(priority = 0, description = "Successful login")
    public void loginScenario() throws Exception {
        homePage.clickLogInLink();
        loginPage.sendValueEmailInp(ExcelUtils.getCellStringData("loginData", 0, 0));
        loginPage.sendValuePassInp(ExcelUtils.getCellStringData("loginData", 0, 1));
        System.out.println("Password:  "+ExcelUtils.getCellStringData("loginData", 0, 1));
        loginPage.clickSignInBtn();
        dashboardPage.clickAvatarLink();
        String user= dashboardPage.getUserEmail();
        softAssert.assertEquals(user, "nextontest@yopmail.com");
    }
    @Test(priority = 1, description = "Invalid login")
    public void invalidLoginScenario() throws Exception {
        homePage.clickLogInLink();
        loginPage.sendValueEmailInp(ExcelUtils.getCellStringData("loginData", 0, 0));
        loginPage.sendValuePassInp(ExcelUtils.getCellStringData("loginData", 0, 0));
        System.out.println("Password:  "+ExcelUtils.getCellStringData("loginData", 0, 1));
        loginPage.clickSignInBtn();
        String invalidEmailMessage = loginPage.getInvalidMessageAlert();
        softAssert.assertEquals(invalidEmailMessage, "Invalid email / password combination");
    }
}
