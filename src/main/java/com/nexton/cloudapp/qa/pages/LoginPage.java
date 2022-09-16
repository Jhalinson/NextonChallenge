package com.nexton.cloudapp.qa.pages;

import com.nexton.cloudapp.qa.basePage.BasePage;
import com.nexton.cloudapp.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // Repository of elements
    private By emailInp = By.cssSelector("input#email");
    private By passInp = By.cssSelector("input[type='password']");
    private By signInBtn = By.xpath("//*[@type='submit' and @name='commit' or @value='Sign in']");
    private By invalidMessageAlert = By.xpath("//div[@class='alert alert-danger' and contains(text(), 'Invalid email / password combination')]");

    // Actions
    public void sendValueEmailInp(String email) {
        doSendKeys(emailInp, email, WaitStrategy.PRESENCE);
    }

    public void sendValuePassInp(String pass) throws InterruptedException {

        doSendKeys(passInp, pass, WaitStrategy.PRESENCE);
    }
    public void clickSignInBtn() throws InterruptedException {

        doClick(signInBtn,  WaitStrategy.CLICKABLE);
        Thread.sleep(1000);
    }
    public String getInvalidMessageAlert(){
        return getText(invalidMessageAlert, WaitStrategy.VISIBLE);
    }
}
