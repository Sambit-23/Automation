package pageobject;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;
import com.github.dockerjava.api.model.Driver;

import utils.base;



public class settingsModule {	
	
	SoftAssertions ass = new SoftAssertions();
	 private WebDriver driver;
	
	    public settingsModule(WebDriver driver) 
	    {	
	    	this.driver = driver;
	        PageFactory.initElements(driver,this);
	    }
	    
	    //Create
		private final By AddButton=By.xpath("//div[@class='MuiGrid-root']/div[1]/div[1]/div[2]/div[2]");
		private final By codeTextField=By.xpath("//input[@name='code']");
		private final By nameTextField=By.xpath("//input[@name='name']");
		private final By submitButton=By.xpath("//button[.='Submit']");
		private final By requestTypeCreated=By.xpath("//div[.='Request Type Created Successfully' and @role='alert']");
		private final By invalidRequestType=By.xpath("//div[.='Request type names should be BUDGET/EXTRABUDGET/HR related.' and @role='alert']");
		
		
		//Edit
		private final By anyOneEditButton=By.xpath("(//div[@aria-label='Edit'])[1]");
		private final By codeList=By.xpath("//div[@data-field='code' and @role='cell']/span");
	    
		//Delete
		private final By deleteList=By.xpath("//div[@aria-label='Delete']/..");
		private final By anyonedeletebutton=By.xpath("(//div[@aria-label='Delete'])[1]");
		private final By confirmDelete=By.xpath("(//span[.='Delete'])[2]");
		
		//Branch Configuration
		private final By branchDropdown=By.xpath("//div[@aria-haspopup='listbox' and @id='mui-component-select-companyId']/..");
		private final By selectOneBranch=By.xpath("(//span[@class='MuiTypography-root MuiTypography-noWrap'])[1]/..");
		private final By reqTypeDropdown=By.xpath("//div[@aria-haspopup='listbox' and @id='mui-component-select-requestTypeId']/..");
		private final By selOnerequestType=By.xpath("(//span[@class='MuiTypography-root MuiTypography-noWrap'])[1]/..");
		private final By approvalCriteria=By.xpath("//input[@name='approvalCriteria']");
		
		//Create a approval workflow
		private final By addButton_Awf=By.xpath("//img[@aria-label='Add']/../..");
		private final By requestTypeDropdown=By.xpath("//input[@name='requestTypeId']/..");
		private final By selectFirstOption=By.xpath("(//span[@class='MuiTypography-root MuiTypography-noWrap'])[1]");
		
		
//##Added BY Sambit on 9-Nov-2022 for APPROVAL WORK FLOW & WORK FLOW NODE Sub-Module ##################################################
// from Line no. 52
		
		//Approval Workflow
		private final By settingSubmoduleList = By.xpath("//nav/div[1]/div[5]/div[2]/div/div/div/span");
		private final By approvalWorkflowTitle = By.xpath("//*[@id='root']/div[1]/div/div[2]/div/div/div[1]/div/div");
		private final By approvalWorkflowAddIcon = By.xpath("/html/body/div/div[1]/div/div[2]/div/div/div[1]/div/div[2]/div[2]");
		private final By approvalWorkflowAddButton = By.xpath("//*[@id='root']/div[1]/div/div[2]/div/div/div[1]/div/button");
		private final By approvalWorkflowEditButton = By.xpath("//table/tbody/tr[1]/td[5]/div/button[1]");
		private final By approvalWorkflowDeleteButton = By.xpath("//table/tbody/tr[1]/td[5]/div/button[2]");
		private final By approvalWorkflowSubmitButton = By.xpath("//*[@id='root']/div[1]/div/div[2]/div/div/div/div[2]/div[2]/div/button[2]");
		private final By approvalWorkflowCancelButton = By.xpath("//*[@id='root']/div[1]/div/div[2]/div/div/div/div[2]/div[2]/div/button[1]");
		private final By approvalWorkflowRequestTypeList = By.xpath("//table/tbody/tr/td[4]");
		private final By approvalWorkflowWorkflowCodeList = By.xpath("/html/body/div/div[1]/div/div[2]/div/div/div[3]/div/div[1]/div[2]/div[2]/div/div/div/div/div[1]/span");
		

		private final By approvalWorkflowDeleteOkButton = By.xpath("//div/div[3]/button[1]");
		private final By approvalWorkflowDeleteCancelButton = By.xpath("//div/div[3]/button[2]");
		private final By approvalWorkflowToastMessage = By.xpath("/html/body/div/div[2]/div/div/div[1]");
		
		//Approval Workflow --> Create Approval
		private final By createApprovalWorkflowCodeTextield = By.xpath("//*[@id='root']/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/div/div/div/input");
		private final By createApprovalWorkflowNameTextield = By.xpath("//*[@id='root']/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div/div/div/input");
		private final By createApprovalWorkflowRequestTypeDropdown = By.xpath("//*[contains(@id,'select-requestTypeId')]");
		private final By createApprovalWorkflowrequestTypeDropdownElements = By.xpath("/html/body/div[2]/div[3]/ul/li");
		private final By createApprovalWorkflowDescriptionTextarea = By.xpath("//*[@id='root']/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[4]/div");
		private final By creatApprovalWorkflowRequestTypeText = By.xpath("//*[contains(@id,'select-requestTypeId')]/span");
		
		//Approval Workflow --> Edit Approval
		private final By editApprovalWorkflowCodeTextfield = By.xpath("//form/div/div[1]/div/div/div/input");
		private final By editApprovalWorkflowNameTextfield = By.xpath("//form/div/div[2]/div/div/div/input");
		private final By editApprovalWorkflowRequestTypeDropdown = By.xpath("//*[contains(@id,'select-requestTypeId')]");
		private final By editApprovalWorkflowDescriptionTextarea = By.xpath("//form/div/div[4]/div/div/div");
		
		//Getters
		
		public By getApprovalWorkflowAddIcon() {
			return approvalWorkflowAddIcon;
		}
		public By getApprovalWorkflowTitle() {
			return approvalWorkflowTitle;
		}
		public By getApprovalWorkflowAddButton() {
			return approvalWorkflowAddButton;
		}
		public By getApprovalWorkflowEditButton() {
			return approvalWorkflowEditButton;
		}
		public By getApprovalWorkflowDeleteButton() {
			return approvalWorkflowDeleteButton;
		}

		public By getApprovalWorkflowSubmitButton() {
			return approvalWorkflowSubmitButton;
		}
		public By getApprovalWorkflowCancelButton() {
			return approvalWorkflowCancelButton;
		}
		public By getApprovalWorkflowRequestTypeList() {
			return approvalWorkflowRequestTypeList;
		}
		public By getApprovalWorkflowDeleteOkButton() {
			return approvalWorkflowDeleteOkButton;
		}
		public By getApprovalWorkflowDeleteCancelButton() {
			return approvalWorkflowDeleteCancelButton;
		}
		public By getCreateApprovalWorkflowCodeTextield() {
			return createApprovalWorkflowCodeTextield;
		}
		public By getCreateApprovalWorkflowNameTextield() {
			return createApprovalWorkflowNameTextield;
		}
		public By getCreateApprovalWorkflowRequestTypeDropdown() {
			return createApprovalWorkflowRequestTypeDropdown;
		}
		public By getCreateApprovalWorkflowDescriptionTextarea() {
			return createApprovalWorkflowDescriptionTextarea;
		}
		public By getEditApprovalWorkflowCodeTextfield() {
			return editApprovalWorkflowCodeTextfield;
		}
		public By getEditApprovalWorkflowNameTextfield() {
			return editApprovalWorkflowNameTextfield;
		}
		public By getEditApprovalWorkflowRequestTypeDropdown() {
			return editApprovalWorkflowRequestTypeDropdown;
		}
		public By getEditApprovalWorkflowDescriptionTextarea() {
			return editApprovalWorkflowDescriptionTextarea;
		}
		public By getCreateApprovalWorkflowrequestTypeDropdownElements() {
			return createApprovalWorkflowrequestTypeDropdownElements;
		}
		public By getApprovalWorkflowToastMessage() {
			return approvalWorkflowToastMessage;
		}
		public By getCreatApprovalWorkflowRequestTypeText() {
			return creatApprovalWorkflowRequestTypeText;
		}
		public By getApprovalWorkflowWorkflowCodeList() {
			return approvalWorkflowWorkflowCodeList;
		}


		
		//Methods
		
		public void selectSubmodule(String Name) {
			System.out.println(Name);
			List<WebElement> submodules = driver.findElements(settingSubmoduleList);
			for(WebElement submodule : submodules ) {
				if(submodule.getText().equalsIgnoreCase(Name)) {
					submodule.click();
				}
			}
		}
		
		
		
		
		
		
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		 public By getAddButton() {
				return AddButton;
			}


		public By getCodeTextField() {
			return codeTextField;
		}


		public By getNameTextField() {
			return nameTextField;
		}


		public By getSubmitButton() {
			return submitButton;
		}


		public By getRequestTypeCreated() {
			return requestTypeCreated;
		}


		public By getInvalidRequestType() {
			return invalidRequestType;
		}


		public By getAnyOneEditButton() {
			return anyOneEditButton;
		}


		public By getCodeList() {
			return codeList;
		}


		public By getDeleteList() {
			return deleteList;
		}


		public By getConfirmDelete() {
			return confirmDelete;
		}


		public By getAnyonedeletebutton() {
			return anyonedeletebutton;
		}


		public By getAddButton_Awf() {
			return addButton_Awf;
		}


		public By getRequestTypeDropdown() {
			return requestTypeDropdown;
		}


		public By getSelectFirstOption() {
			return selectFirstOption;
		}


		public By getBranchDropdown() {
			return branchDropdown;
		}


		public By getSelectOneBranch() {
			return selectOneBranch;
		}


		public By getReqTypeDropdown() {
			return reqTypeDropdown;
		}


		public By getSelOnerequestType() {
			return selOnerequestType;
		}


		public By getApprovalCriteria() {
			return approvalCriteria;
		}
	    
}
	    