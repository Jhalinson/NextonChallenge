package com.nexton.cloudapp.qa.test;

import com.nexton.cloudapp.qa.baseTest.BaseTest;
import com.nexton.cloudapp.qa.constants.FrameworkConstants;
import com.nexton.cloudapp.qa.utils.ExcelUtils;
import org.testng.annotations.Test;

public class TestDashboardPage extends BaseTest {

//    @Test(priority = 0, description = "Log out of the application")
//    public void logoutScenario() throws Exception {
//        homePage.clickLogInLink();
//        loginPage.sendValueEmailInp(ExcelUtils.getCellStringData("loginData", 0, 0));
//        loginPage.sendValuePassInp(ExcelUtils.getCellStringData("loginData", 0, 1));
//        System.out.println("Password:  "+ExcelUtils.getCellStringData("loginData", 0, 1));
//        loginPage.clickSignInBtn();
//        dashboardPage.clickAvatarLink();
//        String user= dashboardPage.getUserEmail();
//        softAssert.assertEquals(user, "nextontest@yopmail.com");
//        dashboardPage.clickSignOutLink();
//
//    }

    @Test(priority = 1, description = "Change the avatar photo in the profile")
    public void changeAvatarScenario() throws Exception {
        homePage.clickLogInLink();
        loginPage.sendValueEmailInp(ExcelUtils.getCellStringData("loginData", 0, 0));
        loginPage.sendValuePassInp(ExcelUtils.getCellStringData("loginData", 0, 1));
        System.out.println("Password:  " + ExcelUtils.getCellStringData("loginData", 0, 1));
        loginPage.clickSignInBtn();
        dashboardPage.clickAvatarLink();
        dashboardPage.clickSettingsLink();
        dashboardPage.clickChooseFileBtn(FrameworkConstants.getSystemPath()+"/src/test/java/com/nexton/cloudapp/qa/testResources/green-sea-turtle-1-400x400.jpg.optimal.jpg");
        dashboardPage.sendTextUserNameInp(ExcelUtils.getCellStringData("avatarData", 0, 0));
        dashboardPage.sendTextUserCompanyInp(ExcelUtils.getCellStringData("avatarData", 0, 1));
        dashboardPage.clickSubmitBtn();
        String accountUpdatedMsg = dashboardPage.getTextAccountUpdateMessage();
        softAssert.assertEquals(accountUpdatedMsg, "Account updated successfully");

    }
}
