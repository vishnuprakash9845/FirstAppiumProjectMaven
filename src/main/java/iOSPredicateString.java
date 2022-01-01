import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByIosNSPredicate;
import io.appium.java_client.MobileElement;

public class iOSPredicateString {
    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");

        MobileElement myElement = (MobileElement) ((FindsByIosNSPredicate)driver).findElementByIosNsPredicate("type == \"XCUIElementTypeStaticText\" AND name == \"Activity Indicators\"");
        System.out.println("By IOS Predicate Type AND Name : "+myElement.getText());

        myElement = (MobileElement) ((FindsByIosNSPredicate)driver).findElementsByIosNsPredicate("name == \"Alert Views\" OR name == \"Activity Indicators\"").get(1);
        System.out.println("By IOS Predicate OR Names : "+myElement.getText());

        myElement = (MobileElement) ((FindsByIosNSPredicate)driver).findElementByIosNsPredicate("name CONTAINS \"Steppers\"");
        System.out.println("By IOS Predicate Name Contains : "+myElement.getText());

        myElement = (MobileElement) ((FindsByIosNSPredicate)driver).findElementByIosNsPredicate("label CONTAINS \"Steppers\"");
        System.out.println("By IOS Predicate label Contains : "+myElement.getText());
    }
}
