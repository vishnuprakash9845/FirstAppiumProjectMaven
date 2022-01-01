import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import io.appium.java_client.android.appmanagement.AndroidTerminateApplicationOptions;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AndInteractionWithApps {
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By views = MobileBy.AccessibilityId("Views");
        driver.findElement(views).click();

        Thread.sleep(2000);
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        driver.terminateApp("io.appium.android.apis");
        Thread.sleep(2000);
        System.out.println(driver.queryAppState("io.appium.android.apis"));

        /*driver.terminateApp("io.appium.android.apis");
        Thread.sleep(2000);
        driver.activateApp("com.android.settings");
        Thread.sleep(2000);
        driver.activateApp("io.appium.android.apis");
        Thread.sleep(2000);*/

        //driver.runAppInBackground(Duration.ofMillis(5000));

        //System.out.println("API Demos App Installed : "+driver.isAppInstalled("io.appium.android.apis"));

        //driver.terminateApp("io.appium.android.apis");

        String andappUrl=System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"ApiDemo-debug.apk";
        //driver.installApp(andappUrl,new AndroidInstallApplicationOptions().withReplaceEnabled());

    }
}
