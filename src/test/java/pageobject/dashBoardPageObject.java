package pageobject;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class dashBoardPageObject {	
	
	//Dashboard Major tabs
	private final By pendingTab=By.xpath("//h2[.='Pending']/../../..");
	private final By approvedTab=By.xpath("//h2[.='Approved']/../../..");
	private final By rejectedTab=By.xpath("//h2[.='Rejected']/../../..");
	private final By cancelledTab=By.xpath("//h2[.='Cancelled']/../../..");		
	
	//Counts
	private final By pendingCount=By.xpath("(//*[@class='font-weight-bold']/span)[1]");
	private final By approvedCount=By.xpath("(//*[@class='font-weight-bold']/span)[2]");
	private final By rejectedCount=By.xpath("(//*[@class='font-weight-bold']/span)[3]");
	private final By cancelledCount=By.xpath("(//*[@class='font-weight-bold']/span)[4]");
	
	//Status of request in list
	private final By statusList=By.xpath("//tr[@class='MuiTableRow-root']/td[3]");
	
	//Headers
//	private final By branchHeader=By.xpath("//div[.='Branch']");	
//	private final By requestTypeHeader=By.xpath("//div[.='Request Type']");
//	private final By statusHeader=By.xpath("//div[.='Status']");
	
	private final By branchHeader=By.xpath("//div[@role='columnheader' and @aria-label='Branch']");
	private final By requestTypeHeader=By.xpath("//div[@role='columnheader' and @aria-label='Request type']");
	private final By statusHeader=By.xpath("//div[@role='columnheader' and @aria-label='Status']");
	
	    public dashBoardPageObject(WebDriver driver) 
	    {	     
	        PageFactory.initElements(driver,this);
	    }


		public By getPendingTab() {
			return pendingTab;
		}


		public By getApprovedTab() {
			return approvedTab;
		}


		public By getRejectedTab() {
			return rejectedTab;
		}


		public By getCancelledTab() {
			return cancelledTab;
		}


		public By getPendingCount() {
			return pendingCount;
		}


		public By getApprovedCount() {
			return approvedCount;
		}


		public By getRejectedCount() {
			return rejectedCount;
		}


		public By getCancelledCount() {
			return cancelledCount;
		}


		public By getStatusList() {
			return statusList;
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



		
}