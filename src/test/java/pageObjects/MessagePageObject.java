package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class MessagePageObject {
    private final By message = By.id("com.zkbiocloudaccess:id/msg_tv");

    public MessagePageObject(AndroidDriver driver) {

        PageFactory.initElements(driver, this);
    }

    //Getter
    public By getMessage() {
        return message;
    }

}