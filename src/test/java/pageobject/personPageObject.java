package pageobject;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class personPageObject {	
	private final By personButton=By.xpath("//span[.='Person']/..");
		
	
	    public personPageObject(WebDriver driver) 
	    {	     
	        PageFactory.initElements(driver,this);
	    }


		public By getPersonButton() {
			return personButton;
		}

		
}