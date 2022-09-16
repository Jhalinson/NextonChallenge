package com.nexton.cloudapp.qa.pages;

import com.nexton.cloudapp.qa.basePage.BasePage;
import com.nexton.cloudapp.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public class OnboardingPage extends BasePage {
    // Repository of elements
    private By messageAccountCreated = By.xpath("//div[@class='toast-body' or contains(text(),'Account created successfully')]");
    private By messageValidationFailed = By.xpath("//div[@class='flash alert alert-danger' or contains(text(),'Validation failed: Email has already been taken')]");

    // Actions
    public String getTextMessage(){
        return getText(messageAccountCreated, WaitStrategy.VISIBLE);
    }
    public String getTextMessageValidationFailed(){
        return getText(messageValidationFailed, WaitStrategy.VISIBLE);
    }
}
