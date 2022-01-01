import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AndAutomateBrowser {

    public static void main(String[] args) throws Exception {
        //Android
        AppiumDriver driver = CreateBrowserSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://tesla.com");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"tds-site-header\"]/ol/li/button/span")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"tds-consumer-global-header\"]/dialog/ol/li[1]/a[3]/span")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"tesla-hero-showcase-6682\"]/div[2]/div/div/div[2]/div/div[5]/a")).click();
        Thread.sleep(15000);

        Dimension size = driver.manage().window().getSize();
        int startX = size.width/2;
        int endX = startX;
        int startY = (int)(size.height*0.8);
        int endY = (int)(size.height*0.2);

        for (int i=0;i<5;i++)
        {
            TouchAction t = new TouchAction(driver);
            t.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(endX, endY))
                    .release()
                    .perform();
        }

    }
}
