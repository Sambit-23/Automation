package pageobject;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class reportsPageObject {	
	
	//Sub tabs 
	private final By Approved=By.xpath("//span[.='Approved']/..");
	private final By Rejected=By.xpath("//span[.='Rejected']/..");
	private final By Cancelled=By.xpath("//span[.='Cancelled']/..");
	
	//Headers
	private final By branchHeader=By.xpath("//thead[@class='MuiTableHead-root']/tr/th[1]");
	private final By requestTypeHeader=By.xpath("//thead[@class='MuiTableHead-root']/tr/th[2]");
	private final By statusHeader=By.xpath("//thead[@class='MuiTableHead-root']/tr/th[3]");
	
	//Status
	private final By StatusList=By.xpath("//tbody[@class='MuiTableBody-root']/tr/td[3]");
  
	    public reportsPageObject(WebDriver driver) 
	    {	     
	        PageFactory.initElements(driver,this);
	    }


		public By getApproved() {
			return Approved;
		}


		public By getRejected() {
			return Rejected;
		}


		public By getCancelled() {
			return Cancelled;
		}


		public By getBranchHeader() {
			return branchHeader;
		}


		public By getRequestTypeHeader() {
			return requestTypeHeader;
		}


		public By getStatusHeader() {
			return statusHeader;
		}

		public By getStatusList() {
			return StatusList;
		}
	    
	    
	  
	  
}


