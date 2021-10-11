package test;


import com.zoomapp.pages.HomePage;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import zoomapp.base.Testengine;



public class SmokeTest extends Testengine implements ITestListener {
    public static HomePage homePage;

    Actions actions = new Actions();

    @BeforeClass
    public static void initiateDrivers() {
        homePage = new HomePage(driver);
    }

    private void waitSync() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testZoomApp() {

        // Verify if the home page is displayed
        waitSync();
        Assert.assertTrue(homePage.getHomePageTitle());

        //Click on the join meeting button
        waitSync();
        homePage.clickOnJoinMeetingButton();

        //Enter 9 digit meeting id
        waitSync();
        homePage.enterMeetingID("123456789");

        //Validate if the join button gets enabled
        waitSync();
        Assert.assertTrue(homePage.getJoinButtonStatus());

        //Toggle on the "turn off video" button
        waitSync();
        actions.swipeScreen(Actions.Direction.UP);
        homePage.switchToggleVideoButton();

        //Click on join button
        waitSync();
        homePage.clickJoinButton();

        //Validate the error message for invalid meeting id
        waitSync();
        String errorMsg = homePage.getInvalidMeetingError();
        Assert.assertEquals("Invalid meeting ID. Please check and try again.", errorMsg);

        //Put the app in background
        waitSync();
        actions.runAppInBackGround();

        //Make app available in foreground
        actions.activateApp();


    }


    public void onTestStart(ITestResult result) {
        log.info("Test case started successfully");
        log.info("Trying to launch the Application under Test");
    }

    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub

    }
}
