import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class iOSInteractsWithApps {
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By activityIndicators = MobileBy.AccessibilityId("Activity Indicators");
        driver.findElement(activityIndicators).click();

        Thread.sleep(3000);
        System.out.println(driver.queryAppState("com.example.apple-samplecode.UICatalog"));
        Thread.sleep(3000);
        driver.terminateApp("com.example.apple-samplecode.UICatalog");
        Thread.sleep(3000);
        System.out.println(driver.queryAppState("com.example.apple-samplecode.UICatalog"));


        String iosappUrl=System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"UIKitCatalog-iphonesimulator.app";
        //driver.installApp(iosappUrl);
        //driver.runAppInBackground(Duration.ofMillis(5000));

        //driver.activateApp("com.apple.Preferences");
        Thread.sleep(3000);
        //driver.activateApp("com.example.apple-samplecode.UICatalog");


    }
}
