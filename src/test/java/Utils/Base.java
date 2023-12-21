package utils;


import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class Base {
    public AppiumDriverLocalService service;
    private AndroidDriver driver;
    private Properties props;

    public AndroidDriver initialize() {

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withAppiumJS(
                        new File("/var/lib/jenkins/workspace/cloudaccess-android/npm/node_modules/appium/build/lib/main.js"))
                .usingDriverExecutable(new File("/var/lib/jenkins/workspace/cloudaccess-android/nodejs/node.exe"))
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "debug");
        service = AppiumDriverLocalService.buildService(builder);

//            AppiumDriverLocalService service = new AppiumServiceBuilder()
//                    .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
//                    .withAppiumJS(new File("C:\\Users\\sambit\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//                    .withIPAddress("127.0.0.1").usingPort(4723).build();

        service.start();
        System.out.println("started.....................................");

//      creating capabilities

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("APPIUM");
        options.setPlatformName("Android");
        options.setCapability("platformVersion", "11.0");
        options.setCapability("avd", "APPIUM");
        options.setCapability("autoGrantPermissions", true);
        options.setAutomationName("UiAutomator2");
        options.setApp(System.getProperty("user.dir") + "/var/lib/jenkins/workspace/cloudaccess-android/src/test/resources/cloudaccess.apk");
        System.out.println(options);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++");

        try {
            driver = new AndroidDriver(service.getUrl(), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (Exception e) {
            System.out.println("unable to start the emulator");
            e.printStackTrace();
            e.getMessage();
            tearDown();
        }
//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100L));
        return driver;
    }

    public void tearDown() {
        driver.quit();
        service.stop();
        System.out.println("terminated................................................");
    }


    public byte[] getByteScreenshot(WebDriver driver) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(src);
        return fileContent;
    }

    public void screenShot(String s) throws IOException {
        File scrnshtFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrnshtFile, new File(System.getProperty("user.dir") + "\\ScreenShots\\" + s + ".png"));
    }

    public void pullDownToRefresh(int num) {
        for (int i = 0; i < num; i++) {
            int deviceHeight = driver.manage().window().getSize().getHeight();
            int deviceWidth = driver.manage().window().getSize().getWidth();
            int midX = deviceWidth / 2;
            int midY = deviceHeight / 2;
            int bottomEdge = (int) (deviceHeight * 0.8);
            new TouchAction(driver).press(point(midX, midY)).waitAction(waitOptions(ofMillis(1000))).moveTo(point(midX, bottomEdge)).release().perform();
        }
    }

    public void backButton(int num) {
        for (int i = 0; i < num; i++) {
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
        }
    }

    public void scrollDownToElement(String Text) {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + Text + "\"));"));
    }

    public void dragUp() {
        int deviceHeight = driver.manage().window().getSize().getHeight();
        int deviceWidth = driver.manage().window().getSize().getWidth();
        int midX = deviceWidth / 2;
        int midY = deviceHeight / 2;
        int bottomEdge = (int) (deviceHeight * 0.001);
        new TouchAction<>(driver).press(point(midX, midY)).waitAction(waitOptions(ofMillis(1000))).moveTo(point(midX, bottomEdge)).release().perform();
    }

    public void clickByCoordinate(int x, int y) {
        new TouchAction(driver).press(PointOption.point(x, y)).release().perform();
    }

    public void tap(int x, int y) {
        new TouchAction(driver).tap(PointOption.point(x, y)).perform();
    }

    public void writePropertiesFile(String key, String data) throws IOException {
        FileOutputStream out = new FileOutputStream("D:\\Automation\\ZKBioCloudAccessAndroid\\src\\test\\resources\\inputdata.properties");
        FileInputStream in = new FileInputStream("D:\\Automation\\ZKBioCloudAccessAndroid\\src\\test\\resources\\inputdata.properties");
        props = new Properties();
        props.load(in);
        in.close();
        props.setProperty("country", "hiii");
        props.store(out, null);
        out.close();
    }


}
