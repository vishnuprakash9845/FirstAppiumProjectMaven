import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;

import java.time.Duration;

public class AndInteractionWithKeyboard {
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        By views = MobileBy.AccessibilityId("Views");
        By textFields = MobileBy.AccessibilityId("TextFields");
        By editText = MobileBy.id("io.appium.android.apis:id/edit");

        driver.activateApp("io.appium.android.apis");
        Thread.sleep(3000);
        driver.findElement(views).click();

        Dimension size = driver.manage().window().getSize();

        int startX = size.width/2;
        int endX = startX;
        int startY = (int) (size.height*0.8);
        int endY = (int) (size.height*0.2);

        for(int i=0;i<3;i++)
        {
            TouchAction t=new TouchAction(driver);
            t.press(PointOption.point(startX,startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2500)))
                    .moveTo(PointOption.point(endX, endY))
                    .release()
                    .perform();
        }

        driver.findElement(textFields).click();

        driver.findElement(editText).sendKeys("QWERTY");
        Thread.sleep(3000);

        System.out.println("Is Keyboard shown : "+((AndroidDriver)driver).isKeyboardShown());

        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.C));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.A));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.B));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.D));

        System.out.println("Is Keyboard shown : "+((AndroidDriver)driver).isKeyboardShown());

        Thread.sleep(2000);
        driver.hideKeyboard();

        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.HOME));
        Thread.sleep(2000);
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.CALCULATOR));
        Thread.sleep(2000);
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.CALENDAR));
        driver.getKeyboard().pressKey(Keys.PAGE_DOWN);

        Thread.sleep(2000);

        driver.getKeyboard().pressKey(Keys.HOME);

    }
}
