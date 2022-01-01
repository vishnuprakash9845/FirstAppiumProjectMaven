import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentWaysOfDefiningElements {

    @AndroidFindBy(xpath="//*[@text=\"Accessibility\"]")
    @iOSXCUITFindBy(accessibility = "Activity Indicators")
    @FindBy(css = "ForWeb")
    private static MobileElement myElement4;

    public DifferentWaysOfDefiningElements(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");

        DifferentWaysOfDefiningElements differentWaysOfDefiningElements = new DifferentWaysOfDefiningElements(driver);
        System.out.println("By Pagefactory : "+myElement4.getText());


       /* By myElement2 = By.xpath("//*[@text=\"Accessibility\"]");
        System.out.println("By Class : "+driver.findElement(myElement2).getText());

        By myElement3 = MobileBy.AccessibilityId("Accessibility");
        System.out.println("MobileBy : "+driver.findElement(myElement3).getText());

        MobileElement myElement = (MobileElement) driver.findElementByAccessibilityId("Accessibility");
        System.out.println("By Mobile Element : "+myElement.getText());

        WebElement myElement1 = driver.findElementByAccessibilityId("Accessibility");
        System.out.println("By WebElement : "+myElement1.getText());

        driver.findElement(myElement2).click();*/
    }
}
