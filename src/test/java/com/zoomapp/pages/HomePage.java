package com.zoomapp.pages;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import zoomapp.base.Testengine;

import java.util.concurrent.TimeUnit;

public class HomePage extends Testengine {
    public AppiumDriver<?> driver;
    public static Boolean assertion = false;

    public HomePage(AppiumDriver<?> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id="btnJoinConf")
    public AndroidElement joinMeetingButton;

    @AndroidFindBy(id="us.zoom.videomeetings:id/btnSignup")
    public AndroidElement signupButton;

    @AndroidFindBy(id="panelConfNumber")
    public AndroidElement meetingIdPanel;

    @AndroidFindBy(id="edtConfNumber")
    public AndroidElement meetingIdField;

    @AndroidFindBy(id="btnJoin")
    public AndroidElement joinButton;

    @AndroidFindBy(id="checkNoVideoToggle")
    public AndroidElement videoToggleRadio;

    @AndroidFindBy(id="txtMsg")
    public AndroidElement invalidMeetingError;

    public boolean getHomePageTitle() {
        signupButton.isDisplayed();
        return joinMeetingButton.isDisplayed();
    }

    public void clickOnJoinMeetingButton() {
        joinMeetingButton.click();
    }

    public void enterMeetingID(String meetingId) {
        meetingIdPanel.click();
        meetingIdField.sendKeys(meetingId);
    }

    public boolean getJoinButtonStatus() {
        return joinButton.isEnabled();
    }

    public void switchToggleVideoButton() {
        videoToggleRadio.click();
    }

    public void clickJoinButton() {
        joinButton.click();
    }

    public String getInvalidMeetingError() {
        return invalidMeetingError.getText();
    }
}
