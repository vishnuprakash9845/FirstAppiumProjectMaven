import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class iOSFindElements {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");

        MobileElement myElement = (MobileElement) driver.findElementByAccessibilityId("Activity Indicators");
        System.out.println("By Accessibility Id : "+myElement.getText());

        myElement = (MobileElement) driver.findElementsByClassName("XCUIElementTypeStaticText").get(1);
        System.out.println("By ClassName : "+myElement.getText());

        myElement = (MobileElement) driver.findElementByName("Activity Indicators");
        System.out.println("By Name: "+myElement.getText());

        myElement = (MobileElement) driver.findElementById("Activity Indicators");
        System.out.println("By Id : "+myElement.getText());

        myElement = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Activity Indicators\"]");
        System.out.println("By XPath : "+myElement.getText());



        /*myElement = (MobileElement) driver.findElementByTagName("Activity Indicators");
        System.out.println("By Tag : "+myElement.getText());*/
    }
}
