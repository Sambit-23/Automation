package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageObject {
    private final By companyCount = By.id("com.zkbiocloudaccess:id/txt_company_count");
    private final By siteCount = By.id("com.zkbiocloudaccess:id/txt_site_count");
    private final By deviceCount = By.id("com.zkbiocloudaccess:id/txt_device_count");
    private final By onlineDeviceCount = By.id("com.zkbiocloudaccess:id/txt_device_online");
    private final By offlineDeviceCount = By.id("com.zkbiocloudaccess:id/txt_device_offline");
    private final By personCount = By.id("com.zkbiocloudaccess:id/txt_employees_count");
    private final By notificationText = By.id("com.zkbiocloudaccess:id/lbl_notification");
    private final By expandIcon = By.id("com.zkbiocloudaccess:id/img_expand");
    private final By refreshIcon = By.id("com.zkbiocloudaccess:id/iv_refresh");
    private final By notificationNameList = By.id("com.zkbiocloudaccess:id/txt_notification_name");
    private final By notificationTimeList = By.id("com.zkbiocloudaccess:id/txt_notification_time");
    private final By notificationOperationList = By.id(" com.zkbiocloudaccess:id/txt_operation");
    public DashboardPageObject(AndroidDriver driver) {

        PageFactory.initElements(driver, this);
    }

    //Getter
    public By getCompanyCount() {
        return companyCount;
    }

    public By getSiteCount() {
        return siteCount;
    }

    public By getDeviceCount() {
        return deviceCount;
    }

    public By getOnlineDeviceCount() {
        return onlineDeviceCount;
    }

    public By getOfflineDeviceCount() {
        return offlineDeviceCount;
    }

    public By getPersonCount() {
        return personCount;
    }

    public By getNotificationText() {
        return notificationText;
    }

    public By getExpandIcon() {
        return expandIcon;
    }

    public By getRefreshIcon() {
        return refreshIcon;
    }

    public By getNotificationNameList() {
        return notificationNameList;
    }

    public By getNotificationTimeList() {
        return notificationTimeList;
    }

    public By getNotificationOperationList() {
        return notificationOperationList;
    }

}