import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class CreateBrowserSession {

    public static AppiumDriver initializeDriver(String platformName) throws Exception{
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
        caps.setCapability("newCommandTimeout","300");

        URL url=new URL("http://0.0.0.0:4723/wd/hub");

        switch(platformName){
            case "Android":
                caps.setCapability(MobileCapabilityType.DEVICE_NAME,"mototrola one");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
                caps.setCapability(MobileCapabilityType.UDID,"ZF6224FRBT");
                String andappUrl=System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"ApiDemo.apk";
                //caps.setCapability(MobileCapabilityType.APP,andappUrl);
                caps.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
                caps.setCapability("unlockType","password");
                caps.setCapability("unlockKey","West@123");
                caps.setCapability("chromedriverExecutable","/Users/muniswamyv/Downloads/chromedriver");

                return new AndroidDriver(url,caps);
            case "iOS":
                caps.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 12 Pro Max");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
                caps.setCapability(MobileCapabilityType.UDID,"5BAD0A39-328A-4E98-A073-37AB492270BD");
                String iosappUrl=System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"UIKitCatalog-iphonesimulator.app";
                //caps.setCapability(MobileCapabilityType.APP,iosappUrl);
                caps.setCapability("simulatorStartupTimeout",180000);
                caps.setCapability(MobileCapabilityType.BROWSER_NAME,"Safari");
                caps.setCapability("includeSafariInWebviews",true);

               /* caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Vishnu Prakash M");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
                caps.setCapability(MobileCapabilityType.UDID,"524b89b424c613c5996ac14a6b9b769d05296fe0");
                caps.setCapability("simulatorStartupTimeout",30000);
                caps.setCapability(MobileCapabilityType.BROWSER_NAME,"Safari");
                caps.setCapability("includeSafariInWebviews",true);*/
                return new IOSDriver(url,caps);
            default:
                throw new Exception("invalid platoform");
        }
    }
}