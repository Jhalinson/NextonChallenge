package com.nexton.cloudapp.qa.pages;

import com.nexton.cloudapp.qa.basePage.BasePage;
import com.nexton.cloudapp.qa.enums.JavaScriptExecutorStrategy;
import com.nexton.cloudapp.qa.enums.WaitStrategy;
import com.nexton.cloudapp.qa.factories.JavaScriptExecutorFactory;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    // Repository of elements
    private By signUpBtn = By.xpath("//*[@class='elementor-button-text' and contains(text(),'Sign Up Free')]");
    private By logInLink = By.xpath("//div[@class='jet-menu-title' and contains(text(), 'Log in')][1]");

    // Actions
    public void clickSignUpBtn() throws InterruptedException {
        JavaScriptExecutorFactory.performJavaScript(JavaScriptExecutorStrategy.DOWN, signUpBtn);
        Thread.sleep(3000);
        doClick(getSignUpBtn(), WaitStrategy.CLICKABLE);
    }

    public void clickLogInLink() throws InterruptedException {
        doClick(logInLink, WaitStrategy.CLICKABLE);
    }

    public By getSignUpBtn() {
        return signUpBtn;
    }
}
