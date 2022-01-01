import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class FetchElementAttributes {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");

        //iOS
        By accessibilty = MobileBy.AccessibilityId("Activity Indicators");
        System.out.println("Text : " + driver.findElement(accessibilty).getText());
        System.out.println("Label : " + driver.findElement(accessibilty).getAttribute("label"));
        System.out.println("Value : " + driver.findElement(accessibilty).getAttribute("value"));
        System.out.println("Enabled : " + driver.findElement(accessibilty).getAttribute("enabled"));
        System.out.println("Selected : " + driver.findElement(accessibilty).getAttribute("selected"));
        System.out.println("Visible : " + driver.findElement(accessibilty).getAttribute("visible"));

        System.out.println("ISSelected : " + driver.findElement(accessibilty).isSelected());
        System.out.println("ISEnabled : " + driver.findElement(accessibilty).isEnabled());
        System.out.println("ISDisplayed : " + driver.findElement(accessibilty).isDisplayed());

        /*//Android
        By accessibilty = MobileBy.AccessibilityId("Accessibility");
        System.out.println("Text : " + driver.findElement(accessibilty).getText());
        System.out.println("Text : " + driver.findElement(accessibilty).getAttribute("text"));
        System.out.println("Checked : " + driver.findElement(accessibilty).getAttribute("checked"));
        System.out.println("Enabled : " + driver.findElement(accessibilty).getAttribute("enabled"));
        System.out.println("Selected : " + driver.findElement(accessibilty).getAttribute("selected"));
        System.out.println("Displayed : " + driver.findElement(accessibilty).getAttribute("displayed"));

        System.out.println("ISSelected : " + driver.findElement(accessibilty).isSelected());
        System.out.println("ISEnabled : " + driver.findElement(accessibilty).isEnabled());
        System.out.println("ISDisplayed : " + driver.findElement(accessibilty).isDisplayed());*/


    }
}
