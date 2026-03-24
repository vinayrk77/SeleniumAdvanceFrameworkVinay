package com.vinaythetestingacademy.pages.PageFactory.VWO;

import com.vinaythetestingacademy.base.CommonToAllPage;
import com.vinaythetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage_PF extends CommonToAllPage {

    WebDriver driver;

    public DashBoardPage_PF(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locator for logged-in username (update if needed)
    @FindBy(xpath = "//h6[@vwo-ellipsize]")
    private WebElement loggedInUserName;

    // Page Action
    public String getLoggedInUserName() {

        // Better than Thread.sleep
        WaitHelpers.checkVisibility(driver,
                org.openqa.selenium.By.xpath("//h6[@vwo-ellipsize]"), 10);

        return getText(loggedInUserName);
    }
}