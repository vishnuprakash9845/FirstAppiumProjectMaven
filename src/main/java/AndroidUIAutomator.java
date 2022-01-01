import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class AndroidUIAutomator {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        MobileElement myElement = (MobileElement)((FindsByAndroidUIAutomator)driver).findElementByAndroidUIAutomator("new UiSelector().text(\"Accessibility\")");
        System.out.println(myElement.getText());

        myElement = (MobileElement)((FindsByAndroidUIAutomator)driver).findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\")").get(2);
        System.out.println(myElement.getText());

        myElement = (MobileElement)((FindsByAndroidUIAutomator)driver).findElementByAndroidUIAutomator("new UiSelector().description(\"Accessibility\")");
        System.out.println(myElement.getText());

        myElement = (MobileElement)((FindsByAndroidUIAutomator)driver).findElementByAndroidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")");
        System.out.println(myElement.getText());

        /*MobileElement myElement = (MobileElement) driver.findElementByAccessibilityId("Accessibility");
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementsById("android:id/text1").get(1);
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementsByClassName("android.widget.TextView").get(2);
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Accessibility\"]");
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementByXPath("//*[@text=\"Accessibility\"]");
        System.out.println(myElement.getText());*/

    }
}
