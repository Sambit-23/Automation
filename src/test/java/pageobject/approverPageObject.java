package pageobject;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class approverPageObject {	
	
	//Headers in approver page
	//#1.Name 2.Request Type 3.Branch 4.Employee 5.Status 6.Creation Date 7.Description 8.Actions
	private final By NameHeader=By.xpath("//thead[@class='MuiTableHead-root']/tr/th[1]");
	private final By RequestHeader=By.xpath("//thead[@class='MuiTableHead-root']/tr/th[2]");
	private final By BranchHeader=By.xpath("//thead[@class='MuiTableHead-root']/tr/th[3]");
	private final By EmployeeHeader=By.xpath("//thead[@class='MuiTableHead-root']/tr/th[4]");
	private final By StatusHeader=By.xpath("//thead[@class='MuiTableHead-root']/tr/th[5]");
	private final By CreationDateHeader=By.xpath("//thead[@class='MuiTableHead-root']/tr/th[6]");
	private final By DescriptionHeader=By.xpath("//thead[@class='MuiTableHead-root']/tr/th[7]");
	private final By ActionsHeader=By.xpath("//thead[@class='MuiTableHead-root']/tr/th[8]");

	    public approverPageObject(WebDriver driver) 
	    {	     
	        PageFactory.initElements(driver,this);
	    }

		public By getNameHeader() {
			return NameHeader;
		}

		public By getRequestHeader() {
			return RequestHeader;
		}

		public By getBranchHeader() {
			return BranchHeader;
		}

		public By getEmployeeHeader() {
			return EmployeeHeader;
		}

		public By getStatusHeader() {
			return StatusHeader;
		}

		public By getCreationDateHeader() {
			return CreationDateHeader;
		}

		public By getDescriptionHeader() {
			return DescriptionHeader;
		}

		public By getActionsHeader() {
			return ActionsHeader;
		}

		
}