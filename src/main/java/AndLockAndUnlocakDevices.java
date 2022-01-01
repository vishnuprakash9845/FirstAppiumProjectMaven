import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AndLockAndUnlocakDevices {
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("Is Mobile Locked: "+ ((AndroidDriver) driver).isDeviceLocked());

        ((AndroidDriver)driver).lockDevice(Duration.ofSeconds(5));

        System.out.println("Is Mobile Locked: "+ ((AndroidDriver) driver).isDeviceLocked());

        ((AndroidDriver)driver).unlockDevice();
    }
}
