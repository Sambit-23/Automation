package files;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Utils {
	RequestSpecification req;
	protected final static HashMap<String, String> data=new HashMap<String, String>();
	//static WebDriver driver;
	public RequestSpecification requestSpecification() throws FileNotFoundException
	{
		PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
		 req=new RequestSpecBuilder()
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
		.setContentType(ContentType.JSON).build();
		 return req;
	}
	
	public RequestSpecification requestSpecification(String api) throws FileNotFoundException
	{PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
		switch(api)
		{
		case "location":
			req=new RequestSpecBuilder().setBaseUri("http://192.168.11.13:9098/api/v2.0/")
			 .addFilter(RequestLoggingFilter.logRequestTo(log))
			 .addFilter(ResponseLoggingFilter.logResponseTo(log))
			 .setContentType(ContentType.JSON).build();
			break;
			
		case "Authorization_Token":
			req=new RequestSpecBuilder().setBaseUri("http://192.168.11.13:9095/")
			 .addFilter(RequestLoggingFilter.logRequestTo(log))
			 .addFilter(ResponseLoggingFilter.logResponseTo(log))
			 .setContentType(ContentType.JSON).build();
			break;
			
		case "Authorization":
			req=new RequestSpecBuilder().setBaseUri("http://192.168.11.13:9095/api/v2.0")
			 .addFilter(RequestLoggingFilter.logRequestTo(log))
			 .addFilter(ResponseLoggingFilter.logResponseTo(log))
			 .setContentType(ContentType.JSON).build();
			break;
			
		case "Authorization_userCreation":
			req=new RequestSpecBuilder().setBaseUri("http://192.168.11.13:9095/v2.0")
			 .addFilter(RequestLoggingFilter.logRequestTo(log))
			 .addFilter(ResponseLoggingFilter.logResponseTo(log))
			 .setContentType(ContentType.JSON).build();
			break;
			
		case "Organization":
			req=new RequestSpecBuilder().setBaseUri("http://192.168.11.13:9096/api/v2.0")
			 .addFilter(RequestLoggingFilter.logRequestTo(log))
			 .addFilter(ResponseLoggingFilter.logResponseTo(log))
			 .setContentType(ContentType.JSON).build();
			break;
	 
		}
		return req;
		 
	}
	
	public String getJsonPath(Response response,String key)
	{
		String resp=response.asString();
		JsonPath  js = new JsonPath(resp);
		return js.get(key).toString();
	}
	
	public String getJsonPath(ValidatableResponse validateresponseOBJ2, String key) {
		String resp=validateresponseOBJ2.extract().asString();
		JsonPath  js = new JsonPath(resp);
		return js.get(key).toString();
	}

	public static List<String> retreiveClientDetails(WebDriver driver) throws InterruptedException {
		List<String> returner = new LinkedList<String>();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver.exe");
		driver = new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\geckodriver.exe");
//		FirefoxProfile firefoxProfile = new FirefoxProfile();
//        firefoxProfile.setPreference("browser.private.browsing.autostart",true);
//        FirefoxOptions option=new FirefoxOptions();
//        option.setProfile(firefoxProfile);
//		driver = new FirefoxDriver(option);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://192.168.11.13:9090/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//a[contains(@class,'headerLoginBtn')])[1]")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("narasimharao@zkteco.in");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Narasimha@041");
		driver.findElement(By.xpath("//button[contains(@class,'MuiButton-contained')]")).click();
		Thread.sleep(3000);
		List<WebElement> Apps = driver.findElements(By.cssSelector("#root > div > div.root > div.MuiGrid-root > div:nth-child(3) > div> div > div > div > div > div > div > div:nth-child(1) > div > a"));
		for(int i=0; i<Apps.size();i++)
		{
			if(Apps.get(i).getText().equalsIgnoreCase("a"))
			{
				Apps.get(i).click();
				break;
			}
		}
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > div > div.root.applicationHomeStyle > div > div > div > div > div > div:nth-child(2) > div")));
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.MuiButtonBase-root.MuiButton-root.MuiButton-outlined.MuiButton-outlinedPrimary")).click();
		returner.add(driver.findElement(By.cssSelector(".fullWidthTabsStyle>div>div>div > div > div > form > div:nth-child(6) > div > div > div > label > small.applicationDetailsClientIdInfo")).getText());
		

		List<WebElement> temps = driver.findElements(By.cssSelector(".fullWidthTabsStyle>div>div>div > div > div > form > div:nth-child(7) > div > div > div > label > small"));
		returner.add(temps.get(1).getText());
		for(Object str : returner)
		{
			System.out.println(str);
		}
		driver.close();
		return returner;
		
		
	}

	public static String printSubsInDelimeters(String str)
	{
	  String ret = null;
	    // Regex to extract the string
	    // between two delimiters
	    String regex = "\\[(.*?)\\]";
	 
	    // Compile the Regex.
	    Pattern p = Pattern.compile(regex);
	 
	    // Find match between given string
	    // and regular expression
	    // using Pattern.matcher()
	    Matcher m = p.matcher(str);
	 
	    // Get the subsequence
	    // using find() method
	    while (m.find())
	    {
	    	ret = (m.group(1));
	    }
		return ret;
	}
	
	
	

}
