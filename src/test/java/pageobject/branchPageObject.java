package pageobject;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class branchPageObject {		
		
	//Branch button
	private final By BranchSubM=By.xpath("//span[.='Branch']");
	
	//Branch page
	private final By BranchPage=By.xpath("//span[@class='is-active' and .='Branch']");
	private final By AddButton=By.xpath("//img[@aria-label='Add']/../..");
	
	//headers
	private final By BranchCode=By.xpath("//div[.='Branch Code']/..");
	private final By BranchName=By.xpath("//div[.='Branch Name']/..");
	private final By Country=By.xpath("//div[.='Country']/..");
	private final By Status=By.xpath("//div[.='Status']/..");
	private final By Actions=By.xpath("//span[.='Actions']");
	
	//Add Branch page
	
	private final By AddBranchPage=By.xpath("//span[.='Add Branch']");
	private final By firstName=By.xpath("//input[@name='firstName']");
	private final By lastName=By.xpath("//input[@name='lastName']");
	private final By email=By.xpath("//input[@name='email']");
	private final By companyName=By.xpath("//input[@name='name']");
	private final By country_ABP=By.xpath("//input[@name='country']");
	private final By country_India=By.xpath("//input[@aria-activedescendant='mui-13-option-1']");
	
	private final By SubmitButton=By.xpath("//span[.='Submit']/..");
	private final By CancelButton=By.xpath("//span[.='Cancel']/..");
	
	//Messages
	private final By SuccessMessage=By.xpath("//div[.='Branch Created Successfully' and @role='alert']");
	private final By firstNameIsMandatory=By.xpath("//div[.='First name is mandatory' and @role='alert']");
	private final By emailIsMandatory=By.xpath("//div[.='Email is mandatory' and @role='alert']");
	private final By companyNameIsMandatory=By.xpath("//div[.='Branch name is mandatory' and @role='alert']");
	private final By CountryIsMandatory=By.xpath("//div[.='Country is mandatory' and @role='alert']");
	
	//List
	private final By BranchNameList=By.xpath("//div[@data-field='name' and @role='cell']/span");
	
	//Edit
	private final By editButton=By.xpath("(//div[@aria-label='Edit'])[1]");
	private final By editBranchPage=By.xpath("//span[.='Edit Branch']");
	
	private final By comapanyName=By.xpath("//input[@name='name']");
	private final By industryType=By.xpath("//input[@name='industry']");
	private final By selectCountryDropdown=By.xpath("//input[@name='country']");
	private final By state=By.xpath("//input[@name='state']");
	private final By city=By.xpath("//input[@name='city']");
	private final By zipCode=By.xpath("//input[@name='pincode']");
	
	//
	private final By DeactivateButton=By.xpath("(//button[@aria-label='Deactivate'])[1]");
	private final By confirmDeactivate=By.xpath("//button[.='Deactivate']");
	private final By OneBranchName=By.xpath("(//div[@data-field='name' and @role='cell'])[1]/span");
	
	//
	private final By anyOneUpdateButton=By.xpath("(//div[@aria-label='Update Admin']/..)[1]");
	
	//
	
	
	
	
	public By getCountryListBox(String country) {        
        return By.xpath("//span[.=\""+country+"\"]");      
    }
	    public branchPageObject(WebDriver driver) 
	    {	     
	        PageFactory.initElements(driver,this);
	    }

		public By getBranchSubM() {
			return BranchSubM;
		}

		public By getBranchPage() {
			return BranchPage;
		}

		public By getBranchCode() {
			return BranchCode;
		}

		public By getCountry() {
			return Country;
		}

		public By getStatus() {
			return Status;
		}

		public By getBranchName() {
			return BranchName;
		}

		public By getActions() {
			return Actions;
		}

		public By getAddButton() {
			return AddButton;
		}

		public By getAddBranchPage() {
			return AddBranchPage;
		}

		public By getFirstName() {
			return firstName;
		}

		public By getLastName() {
			return lastName;
		}

		public By getEmail() {
			return email;
		}

		public By getCompanyName() {
			return companyName;
		}

		public By getCountry_ABP() {
			return country_ABP;
		}

		public By getSubmitButton() {
			return SubmitButton;
		}

		public By getCancelButton() {
			return CancelButton;
		}

		public By getCountry_India() {
			return country_India;
		}


		public By getSuccessMessage() {
			return SuccessMessage;
		}
		public By getBranchNameList() {
			return BranchNameList;
		}
		public By getFirstNameIsMandatory() {
			return firstNameIsMandatory;
		}
		public By getEmailIsMandatory() {
			return emailIsMandatory;
		}
		public By getCompanyNameIsMandatory() {
			return companyNameIsMandatory;
		}
		public By getCountryIsMandatory() {
			return CountryIsMandatory;
		}
		public By getEditButton() {
			return editButton;
		}
		public By getEditBranchPage() {
			return editBranchPage;
		}
		public By getComapanyName() {
			return comapanyName;
		}
		public By getIndustryType() {
			return industryType;
		}
		public By getSelectCountryDropdown() {
			return selectCountryDropdown;
		}
		public By getState() {
			return state;
		}
		public By getCity() {
			return city;
		}
		public By getZipCode() {
			return zipCode;
		}
		public By getDeactivateButton() {
			return DeactivateButton;
		}
		public By getConfirmDeactivate() {
			return confirmDeactivate;
		}
		public By getOneBranchName() {
			return OneBranchName;
		}
		public By getAnyOneUpdateButton() {
			return anyOneUpdateButton;
		}
}