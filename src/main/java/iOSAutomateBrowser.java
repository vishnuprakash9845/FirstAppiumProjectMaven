import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class iOSAutomateBrowser {
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateBrowserSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://tesla.com");
        Thread.sleep(10000);

        driver.findElement(By.className("tds-site-nav-item-text")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"tds-consumer-global-header\"]/dialog/ol/li[1]/a[3]/span")).click();
        Thread.sleep(10000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//*[@id=\"tesla-hero-showcase-6682\"]/div[2]/div/div/div[2]/div/div[5]/a/span"))).click();
        //      driver.findElement(By.xpath("//*[@id=\"tesla-hero-showcase-1838\"]/div/div[1]/div/div[2]/div/div[6]")).click();
        Thread.sleep(10000);
        Dimension size = driver.manage().window().getSize();

        for(int i=0;i<2;i++){
            TouchAction t = new TouchAction(driver);
            t.press(PointOption.point(size.width / 2, (int) (size.height * 0.8)))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(size.width / 2, (int) (size.height * 0.2)))
                    .release()
                    .perform();
        }
        Thread.sleep(3000);

        driver.quit();
    }
}
