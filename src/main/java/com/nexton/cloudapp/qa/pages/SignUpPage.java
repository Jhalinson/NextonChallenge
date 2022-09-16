package com.nexton.cloudapp.qa.pages;

import com.nexton.cloudapp.qa.basePage.BasePage;
import com.nexton.cloudapp.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public class SignUpPage extends BasePage {
    // Repository of elements
    private By emailInp = By.cssSelector("input#email");
    private By passInp = By.cssSelector("input[type=\"password\"]");
    private By signUpBtn = By.xpath("//*[@type=\"submit\" and @name=\"commit\" or @value=\"Sign up\"]");

    // Actions
    public void sendValueEmailInp(String email) {
        doSendKeys(emailInp, email, WaitStrategy.PRESENCE);
    }

    public void sendValuePassInp(String pass) throws InterruptedException {

        doSendKeys(passInp, pass, WaitStrategy.PRESENCE);
    }
    public void clickSignUpBtn() throws InterruptedException {

        doClick(signUpBtn,  WaitStrategy.CLICKABLE);
        Thread.sleep(1000);
    }
}
