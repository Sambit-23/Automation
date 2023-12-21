package pageobject;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class loginPageObject {
		
		
	//Login Page
	private final By SignIn=By.xpath("//h2[.='Login']");
//	private final By SignIn=By.xpath("//h2[.='Sign In']");
    private final By username = By.xpath("//input[@id='email']");
    private final By password = By.xpath("//input[@id='password']");
    private final By Login = By.xpath("//span[.='Login']");
    private final By HomePageLogo =By.xpath("//img[@class='header-logo']"); 
    private final By alert_valid_email=By.xpath("//div[.='Only accepts email']");    
    private final By alert_invalid=By.xpath("//div[.='Invalid password']");
    private final By userDoesNotExist=By.xpath("//div[.='User does not exist.']");
//    private final By unregistered_email=By.xpath("//div[.='Email is not registered']");
//    private final By invalid_password=By.xpath("//div[.='Please enter the Valid Password']");
    private final By eyeicon=By.xpath("//button[@type='button']");
    private final By usernameisrequired=By.xpath("//div[.='User name is required']");
    private final By passwordisrequired=By.xpath("//div[.='Password is required']");
    
    //Forgot password
    private final By SendLink=By.xpath("//span[.='Send Link']/..");
    private final By errorEmail=By.xpath("//div[.='Email Id is required' and @role='alert']");
    private final By forgotPasswordPage=By.xpath("//div[@class='MuiGrid-root center_div MuiGrid-container']");
    
  
	    public loginPageObject(WebDriver driver) 
	    {	     
	        PageFactory.initElements(driver,this);
	    }
		public By getUsername() {
			return username;
		}
		public By getPassword() {
			return password;
		}
		public By getLogin() {
			return Login;
		}
		public By getHomePageLogo() {
			return HomePageLogo;
		}
		public By getSignIn() {
			return SignIn;
		}
		public By getAlert_valid_email() {
			return alert_valid_email;
		}
//		public By getUnregistered_email() {
//			return unregistered_email;
//		}
//		public By getInvalid_password() {
//			return invalid_password;
//		}
		public By getEyeicon() {
			return eyeicon;
		}
		public By getUsernameisrequired() {
			return usernameisrequired;
		}
		public By getPasswordisrequired() {
			return passwordisrequired;
		}
		public By getAlert_invalid() {
			return alert_invalid;
		}
		public By getSendLink() {
			return SendLink;
		}
		public By getErrorEmail() {
			return errorEmail;
		}
		public By getForgotPasswordPage() {
			return forgotPasswordPage;
		}
		public By getUserDoesNotExist() {
			return userDoesNotExist;
		}
	
		
}


