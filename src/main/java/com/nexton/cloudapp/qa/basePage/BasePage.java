package com.nexton.cloudapp.qa.basePage;

import com.nexton.cloudapp.qa.driver.DriverManager;
import com.nexton.cloudapp.qa.enums.ActionsStrategy;
import com.nexton.cloudapp.qa.enums.AlertsStrategy;
import com.nexton.cloudapp.qa.enums.JavaScriptExecutorStrategy;
import com.nexton.cloudapp.qa.enums.WaitStrategy;
import com.nexton.cloudapp.qa.factories.ActionsFactory;
import com.nexton.cloudapp.qa.factories.AlertsFactory;
import com.nexton.cloudapp.qa.factories.ExplicitWaitFactory;
import com.nexton.cloudapp.qa.factories.JavaScriptExecutorFactory;
import com.nexton.cloudapp.qa.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {
    protected String getTitle() {
        return DriverManager.getDriver().getTitle();
    }

    protected void doClick(By locator, WaitStrategy waitStrategy) {
        ExplicitWaitFactory.performExplicitWait(waitStrategy, locator).click();
        ExtentLogger.pass(getTitle());

    }

    protected void doSendKeys(By locator, String text, WaitStrategy waitStrategy) {
        ExplicitWaitFactory.performExplicitWait(waitStrategy, locator).sendKeys(text);

    }

    protected void doClearField(By locator, WaitStrategy waitStrategy) {
        ExplicitWaitFactory.performExplicitWait(waitStrategy, locator).clear();

    }

    protected boolean getDisplayedImage(By locator, WaitStrategy waitStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, locator);
        return element.isDisplayed();

    }

    protected void getActions(By locator, ActionsStrategy actionsStrategy) {

        ActionsFactory.performActions(actionsStrategy, locator);

    }

    protected void getJS(By locator, JavaScriptExecutorStrategy javaScriptExecutorStrategy) {

        JavaScriptExecutorFactory.performJavaScript(javaScriptExecutorStrategy, locator);

    }

    protected void getAlerts(By locator, AlertsStrategy alertsStrategy) {
        AlertsFactory.performAlerts(alertsStrategy, locator);
    }

    protected String getAlertsText(By locator, AlertsStrategy alertsStrategy) {
        return AlertsFactory.performAlertsGetText(alertsStrategy, locator);
    }

    protected String getText(By locator, WaitStrategy waitStrategy) {
        return ExplicitWaitFactory.performExplicitWait(waitStrategy, locator).getText();

    }

    protected List<WebElement> getMultipleElementsText(By locator) {

        List<WebElement> elements = DriverManager.getDriver().findElements(locator);

        return elements;

    }
}
