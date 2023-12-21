package Utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Utils {

    RequestSpecification req;
    RequestSpecification req1;

    RequestSpecification req3;
    ResponseSpecification res;
    protected final static HashMap<String, String> data = new HashMap<String, String>();

    //static WebDriver driver;
    public RequestSpecification requestSpecification(String token) {
        //PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
        req = new RequestSpecBuilder().setBaseUri("http://authorization.minervaiotdev.com/").
                addHeader("Authorization", token).addHeader("Accept-Language", "en").build().given().log().all();
        return req;
    }


    public RequestSpecification requestSpecification1(String token) {
        req1 = new RequestSpecBuilder().setBaseUri("https://organization.minervaiotdev.com/").
                setContentType(ContentType.JSON).
                addHeader("Authorization", token).addHeader("Accept-Language", "en").build();
        return req1;
    }

    public RequestSpecification requestSpecification3(String token) {
        req3 = new RequestSpecBuilder().setBaseUri("https://location.minervaiotdev.com/").
                setContentType(ContentType.JSON).
                addHeader("Authorization", token).addHeader("Accept-Language", "en")
                .build();
        return req3;
    }


    public ResponseSpecification responseSpecification(int Code) {
        res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(Code).build();
        return res;
    }




    /*
     * public RequestSpecification requestSpecification(String api) throws
     * FileNotFoundException {PrintStream log =new PrintStream(new
     * FileOutputStream("logging.txt")); switch(api) {
     *
     * case "Authorization_Token": req=new
     * RequestSpecBuilder().setBaseUri("http://authorizationdev.minervaiot.com/")
     * .addFilter(RequestLoggingFilter.logRequestTo(log))
     * .addFilter(ResponseLoggingFilter.logResponseTo(log))
     * .setContentType(ContentType.JSON).build(); break;
     *
     * case "Authorization":
     *
     * case "Authorization_userCreation": req=new RequestSpecBuilder().setBaseUri(
     * "http://authorizationdev.minervaiot.com/api/v2.0")
     * .addFilter(RequestLoggingFilter.logRequestTo(log))
     * .addFilter(ResponseLoggingFilter.logResponseTo(log))
     * .setContentType(ContentType.JSON).build(); break;
     *
     *
     * } return req;
     *
     * }
     */

    public String getJsonPath(Response response, String key) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }

    public Object[] getJsonPaths(Response response, String key) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.getList(key).toArray();
    }


    public boolean getJsonPathBoolean(Response response, String booleankey) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.getBoolean(booleankey);
    }


    public static List<String> retreiveClientDetails(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        List<String> returner = new LinkedList<String>();
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\chromedriver.exe");
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
        for (int i = 0; i < Apps.size(); i++) {
            if (Apps.get(i).getText().equalsIgnoreCase("a")) {
                Apps.get(i).click();
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > div > div.root.applicationHomeStyle > div > div > div > div > div > div:nth-child(2) > div")));
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button.MuiButtonBase-root.MuiButton-root.MuiButton-outlined.MuiButton-outlinedPrimary")).click();
        returner.add(driver.findElement(By.cssSelector(".fullWidthTabsStyle>div>div>div > div > div > form > div:nth-child(6) > div > div > div > label > small.applicationDetailsClientIdInfo")).getText());


        List<WebElement> temps = driver.findElements(By.cssSelector(".fullWidthTabsStyle>div>div>div > div > div > form > div:nth-child(7) > div > div > div > label > small"));
        returner.add(temps.get(1).getText());
        for (Object str : returner) {
            System.out.println(str);
        }
        driver.close();
        return returner;


    }


}
