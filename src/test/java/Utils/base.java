package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class base {

	private WebDriver driver;
	public static String downloadPath=System.getProperty("user.dir")+"\\Downloads\\exportDismissalEmployee";

	public WebDriver initializeDriver(String browser, String processor, String oS) throws IOException
	{

		switch(processor)
		{
			case "x32":
			case "X32":
				switch (oS.toLowerCase())
				{
					case "windows":

						switch (browser.toLowerCase())
						{

							case "chrome":
								WebDriverManager.chromedriver().arch32().win().setup();
								HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
								chromePrefs.put("profile.default_content_settings.popups", 0);
								chromePrefs.put("download.default_directory", downloadPath);
								chromePrefs.put("profile.default_content_settings.popups", 0);
								chromePrefs.put("safebrowsing.enabled", "true");
								ChromeOptions options = new ChromeOptions();
								options.setExperimentalOption("prefs", chromePrefs);
								driver = new ChromeDriver(options);
								break;

							case "firefox":
								WebDriverManager.firefoxdriver().arch32().win().setup();
								driver = new FirefoxDriver();
								break;
							case "edge":
								WebDriverManager.edgedriver().arch32().win().setup();
								driver = new ChromeDriver();
								break;
							case "opera":
								System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/src/main/java/Resources/Drivers/32bitDrivers/windows/opera driver/operadriver.exe");
								driver = new ChromeDriver();
								break;
							default:
								System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/Resources/Drivers/32bitDrivers/windows/chromedriver.exe");
								HashMap<String, Object> chromePrefs1 = new HashMap<String, Object>();
								chromePrefs1.put("profile.default_content_settings.popups", 0);
								chromePrefs1.put("download.default_directory", downloadPath);
								chromePrefs1.put("profile.default_content_settings.popups", 0);
								chromePrefs1.put("safebrowsing.enabled", "true");
								ChromeOptions options1 = new ChromeOptions();
								options1.setExperimentalOption("prefs", chromePrefs1);
								driver = new ChromeDriver(options1);

						}
						break;

					case "Linux":

						switch (browser.toLowerCase())
						{

							case "chrome":
								WebDriverManager.chromedriver().arch32().linux().setup();
								HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
								chromePrefs.put("profile.default_content_settings.popups", 0);
								chromePrefs.put("download.default_directory", downloadPath);
								chromePrefs.put("profile.default_content_settings.popups", 0);
								chromePrefs.put("safebrowsing.enabled", "true");
								ChromeOptions options = new ChromeOptions();
								options.addArguments("--no-sandbox");
								options.addArguments("--headless"); //should be enabled for Jenkins
								options.addArguments("--disable-dev-shm-usage"); //should be enabled for Jenkins
								options.addArguments("--window-size=1920x1080");
								options.setExperimentalOption("prefs", chromePrefs);
								driver = new ChromeDriver(options);
								break;

							case "firefox":
								WebDriverManager.firefoxdriver().arch32().linux().setup();
								driver = new FirefoxDriver();
								break;
							case "edge":
								WebDriverManager.edgedriver().arch32().linux().setup();
								driver = new ChromeDriver();
								break;
							case "opera":
								WebDriverManager.operadriver().arch32().linux().setup();
								driver = new ChromeDriver();
								break;
							default:
								WebDriverManager.chromedriver().arch32().linux().setup();
								HashMap<String, Object> chromePrefs1 = new HashMap<String, Object>();
								chromePrefs1.put("profile.default_content_settings.popups", 0);
								chromePrefs1.put("download.default_directory", downloadPath);
								chromePrefs1.put("profile.default_content_settings.popups", 0);
								chromePrefs1.put("safebrowsing.enabled", "true");
								ChromeOptions options1 = new ChromeOptions();
								options1.setExperimentalOption("prefs", chromePrefs1);
								driver = new ChromeDriver(options1);

						}
				}
				break;


			case "x64":
			case "X64":
				switch (oS.toLowerCase())
				{
					case "windows":

						switch (browser.toLowerCase())
						{

							case "chrome":
								WebDriverManager.chromedriver().arch64().win().setup();
								HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
								chromePrefs.put("profile.default_content_settings.popups", 0);
								chromePrefs.put("download.default_directory", downloadPath);
								chromePrefs.put("profile.default_content_settings.popups", 0);
								chromePrefs.put("safebrowsing.enabled", "true");
								ChromeOptions options = new ChromeOptions();
								options.setExperimentalOption("prefs", chromePrefs);
								driver = new ChromeDriver(options);
								break;

							case "firefox":
								WebDriverManager.firefoxdriver().arch64().win().setup();
								driver = new FirefoxDriver();
								break;
							case "edge":
								WebDriverManager.edgedriver().arch64().win().setup();
								driver = new ChromeDriver();
								break;
							case "opera":
								WebDriverManager.operadriver().arch64().win().setup();
								driver = new ChromeDriver();
								break;
							default:
								WebDriverManager.chromedriver().arch64().win().setup();
								HashMap<String, Object> chromePrefs1 = new HashMap<String, Object>();
								chromePrefs1.put("profile.default_content_settings.popups", 0);
								chromePrefs1.put("download.default_directory", downloadPath);
								chromePrefs1.put("profile.default_content_settings.popups", 0);
								chromePrefs1.put("safebrowsing.enabled", "true");
								ChromeOptions options1 = new ChromeOptions();
								options1.setExperimentalOption("prefs", chromePrefs1);
								driver = new ChromeDriver(options1);
						}
						break;

					case "linux":

						switch (browser.toLowerCase())
						{

							case "chrome":
								WebDriverManager.chromedriver().arch64().linux().setup();
								HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
								chromePrefs.put("profile.default_content_settings.popups", 0);
								chromePrefs.put("download.default_directory", downloadPath);
								chromePrefs.put("profile.default_content_settings.popups", 0);
								chromePrefs.put("safebrowsing.enabled", "true");
								ChromeOptions options = new ChromeOptions();
								options.addArguments("--no-sandbox");
								options.addArguments("--headless"); //should be enabled for Jenkins
								options.addArguments("--disable-dev-shm-usage"); //should be enabled for Jenkins
								options.addArguments("--window-size=1920x1080");
								options.setExperimentalOption("prefs", chromePrefs);
								driver = new ChromeDriver(options);
								break;

							case "firefox":
								WebDriverManager.firefoxdriver().arch64().linux().setup();
								driver = new FirefoxDriver();
								break;
							case "edge":
								WebDriverManager.edgedriver().arch64().linux().setup();
								driver = new ChromeDriver();
								break;
							case "opera":
								WebDriverManager.operadriver().arch64().linux().setup();
								driver = new ChromeDriver();
								break;
							default:
								WebDriverManager.chromedriver().arch64().linux().setup();
								HashMap<String, Object> chromePrefs1 = new HashMap<String, Object>();
								chromePrefs1.put("profile.default_content_settings.popups", 0);
								chromePrefs1.put("download.default_directory", downloadPath);
								chromePrefs1.put("profile.default_content_settings.popups", 0);
								chromePrefs1.put("safebrowsing.enabled", "true");
								ChromeOptions options1 = new ChromeOptions();
								options1.setExperimentalOption("prefs", chromePrefs1);
								driver = new ChromeDriver(options1);

						}
						break;

					default:
						WebDriverManager.chromedriver().arch64().linux().setup();
						HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
						chromePrefs.put("profile.default_content_settings.popups", 0);
						chromePrefs.put("download.default_directory", downloadPath);
						chromePrefs.put("profile.default_content_settings.popups", 0);
						chromePrefs.put("safebrowsing.enabled", "true");
						ChromeOptions options = new ChromeOptions();
						options.setExperimentalOption("prefs", chromePrefs);
						driver = new ChromeDriver(options);
				}
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;

	}

	public byte[] getByteScreenshot(WebDriver driver) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(src);
		return fileContent;

	}

	public boolean isFileDownloaded_Ext(String ext) throws InterruptedException{

		boolean flag=false;
		File dir = new File(downloadPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			flag = false;
		}

		for (int i = 1; i < files.length; i++) {
			if(files[i].getName().contains(ext)) {
				System.out.println(files[i].getName());
				flag=true;
			}
		}
		System.out.println(flag);
		return flag;

	}
	
	public void Clear(WebElement el) throws AWTException
    {
    	el.sendKeys(Keys.CONTROL + "a");
    	el.sendKeys(Keys.BACK_SPACE);
    }
	
	public void windowMinimize(int num) throws Exception
    {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_CONTROL);
        
        for (int i = 0; i < num; i++) {
            r.keyPress(KeyEvent.VK_MINUS);
        }
        
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_MINUS);

    }
	public byte[] getScreenshot(WebDriver driver) throws IOException
    {           
       File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       byte[] filecontent = FileUtils.readFileToByteArray(src);
       return filecontent;
    }
	
	public void MoveToElement(WebElement element) throws Exception
	{
		Actions a = new Actions(driver);
        a.moveToElement(element).perform();
	}

	public void isFileDownloaded() {

		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			ExtentCucumberAdapter.addTestStepLog(dir_contents[i].getName());
			dir_contents[i].delete();
		}
	}
	public void javaScriptClick(WebElement ele) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",ele);			
	}
	
	    	
	
}
