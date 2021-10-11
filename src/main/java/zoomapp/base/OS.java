package zoomapp.base;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class OS {
    public static AppiumDriver<?> driver;
    public static String platform = "Android";

    @BeforeMethod
    public static void startTest(String platform) {
//        if(platform.equalsIgnoreCase("Android")) {
//            driver = startAppium_Android();
//        } else {
//            driver = startAppium_IOS();
//        }
        driver = startAppium_Android();
    }

    /*
     * This method is used for initiate the AppiumDriver with caps and connection protocol
     */
    public static AndroidDriver<?> startAppium_Android() {
        // Initializing the Appium driver
        try {
            File appDir = new File("src");
            File app = new File(appDir, "com.linkedin.android.apk");
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
//            cap.setCapability("autoLaunch", false);
            cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 500);
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Returning the instance of the driver to the parent method
        return (AndroidDriver<?>) driver;
    }

}


