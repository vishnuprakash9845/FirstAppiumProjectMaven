import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waits {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        By alertViews = MobileBy.AccessibilityId("Alert Views");
        By okayCancelLink = MobileBy.AccessibilityId("Okay / Cancel");

        WebDriverWait wait =new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertViews)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(okayCancelLink)).click();
        //driver.findElement(alertViews).click();
        //driver.findElement(okayCancelLink).click();

    }
}
