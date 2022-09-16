package com.nexton.cloudapp.qa.pages;

import com.nexton.cloudapp.qa.basePage.BasePage;
import com.nexton.cloudapp.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {
    // Repository of elements
    private By avatarlink = By.id("main-menu");
    private By userEmail = By.xpath("//span[@class='dropdown-item' and contains(text(), 'nexton')]");
    private By signOutLink = By.xpath("//*[contains(text(),'Sign out')]");
    private By settingsLink = By.xpath("//a[contains(text(),'Settings')]");
    private By chooseFileBtn = By.xpath("//input[@type='file' and @id='user_avatar']");
    private By userNameInp = By.id("user_name");
    private By userCompanyInp = By.id("user_company");
    private By submitBtn = By.xpath("//div[@id=\"home\"]/preceding::input[@class='btn btn-primary']");
    private By accountUpdateMessage = By.xpath("//div[@class='toast-body' or contains(text(),'Account updated')]");

    // Actions
    public String getTextAccountUpdateMessage(){
        return getText(accountUpdateMessage, WaitStrategy.VISIBLE);
    }

    public void sendTextUserNameInp(String name) throws InterruptedException {

        doSendKeys(userNameInp, name, WaitStrategy.PRESENCE);
    }
    public void sendTextUserCompanyInp(String company) throws InterruptedException {

        doSendKeys(userCompanyInp, company, WaitStrategy.PRESENCE);
    }
    public void clickSubmitBtn() throws InterruptedException {
        doClick(submitBtn, WaitStrategy.CLICKABLE);
    }

    public void clickAvatarLink() {
        doClick(avatarlink, WaitStrategy.CLICKABLE);

    }

    public String getUserEmail() {
        return getText(userEmail, WaitStrategy.VISIBLE);

    }

    public void clickSignOutLink() {
        doClick(signOutLink, WaitStrategy.CLICKABLE);

    }
    public void clickSettingsLink() {
        doClick(settingsLink, WaitStrategy.CLICKABLE);

    }
    public void clickChooseFileBtn(String file){
        doSendKeys(chooseFileBtn, file, WaitStrategy.VISIBLE);

    }
}
