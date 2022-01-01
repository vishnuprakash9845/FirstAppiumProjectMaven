import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

public class ElementBasicActions {
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        By views = MobileBy.AccessibilityId("Views");
        By textFields = MobileBy.AccessibilityId("TextFields");
        By editText = MobileBy.id("io.appium.android.apis:id/edit");

        driver.findElement(views).click();

        (new TouchAction(driver))
                .press(new PointOption().withCoordinates(371, 1344))
                .moveTo(new PointOption().withCoordinates(371, 281))
                .release()
                .perform();

        (new TouchAction(driver))
                .press(new PointOption().withCoordinates(371, 1344))
                .moveTo(new PointOption().withCoordinates(371, 281))
                .release()
                .perform();

        (new TouchAction(driver))
                .press(new PointOption().withCoordinates(371, 1344))
                .moveTo(new PointOption().withCoordinates(371, 281))
                .release()
                .perform();

        driver.findElement(textFields).click();

        driver.findElement(editText).sendKeys("Test 1");
        Thread.sleep(3000);
        driver.findElement(editText).clear();
    }
}
