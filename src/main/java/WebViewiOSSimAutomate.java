import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.io.File;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebViewiOSSimAutomate {
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Dimension size = driver.manage().window().getSize();
        int startX = size.width/2;
        int endX = startX;
        int startY = (int)(size.height*0.8);
        int endY = (int)(size.height*0.2);

        for (int i=0;i<2;i++)
        {
            TouchAction t = new TouchAction(driver);
            t.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(endX, endY))
                    .release()
                    .perform();
        }
        By activityIndicators = MobileBy.AccessibilityId("Web View");
        driver.findElement(activityIndicators).click();
        Thread.sleep(2000);
        Set<String> contextHandles = driver.getContextHandles();
        for(String contextHandle : contextHandles)
        {
            System.out.println("Currnt Context : "+contextHandle);
        }

        driver.context(contextHandles.toArray()[1].toString());
        System.out.println("By CSS Selector : "+driver.findElement(By.cssSelector("body > h1")).getText());
        System.out.println("By XPath : "+driver.findElement(By.xpath("//h1")).getText());
        System.out.println("By Tag Name : "+driver.findElement(By.tagName("h1")).getText());

        driver.context("NATIVE_APP");

        By backButton = MobileBy.xpath("//XCUIElementTypeButton[@name=\"UIKitCatalog\"]");
        driver.findElement(backButton).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
