package pageobject;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class superAdminPageObject {	
	
	  //Major tabs
	private final By Dashboard_Tab=By.xpath("//span[.='Dashboard']");
    private final By Approver_Tab=By.xpath("//span[.='Approver']");
//	private final By Approver_Tab=By.xpath("//span[.='Approver']/../../..");
    private final By Organization_Tab=By.xpath("//span[.='Organization']");
    private final By Reports_Tab=By.xpath("//span[.='Reports']");
    private final By Settings_Tab=By.xpath("//span[.='Settings']");
	
	  //Major tabs
//	  private final By Dashboard_Tab=By.xpath("//*[@id='root']/div[1]/div/div[1]/div[2]/div/div[1]/nav/div[1]/div[1]");
//      private final By Approver_Tab=By.xpath("//*[@id='root']/div[1]/div/div[1]/div[2]/div/div[1]/nav/div[1]/div[2]");
//      private final By Organization_Tab=By.xpath("//*[@id='root']/div[1]/div/div[1]/div[2]/div/div[1]/nav/div[1]/div[3]");
//      private final By Reports_Tab=By.xpath("//*[@id='root']/div[1]/div/div[1]/div[2]/div/div[1]/nav/div[1]/div[4]");
//      private final By Settings_Tab=By.xpath("//*[@id='root']/div[1]/div/div[1]/div[2]/div/div[1]/nav/div[1]/div[5]");      
      //Pages  
      private final By DashboardPage=By.xpath("//div[@class='app_container1']//span[.='Dashboard']");
      private final By ApproverPage=By.xpath("//span[@class='is-active' and .='Approver']");
      private final By ReportsPage=By.xpath("//span[@class='is-active' and .='Reports']");
      
      //Organization-Buttons
      private final By PersonSubM=By.xpath("//span[.='Person']");
      private final By DepartmentSubM=By.xpath("//span[.='Department']");
      private final By DesignationSubM=By.xpath("//span[.='Designation']");
      private final By UserRoleSubM=By.xpath("//span[.='User Role']");
      private final By BranchSubM=By.xpath("//span[.='Branch']");
      
      //Organization-Pages
      private final By PersonPage=By.xpath("//span[@class='is-active' and .='Person']");
      private final By DepartmentPage=By.xpath("//span[@class='is-active' and .='Department']");
      private final By DesignationPage=By.xpath("//span[@class='is-active' and .='Designation']");
      private final By UserRolePage=By.xpath("//span[@class='is-active' and .='User Role']");
      private final By BranchPage=By.xpath("//span[@class='is-active' and .='Branch']");
      
      //Setting-Buttons
      private final By RequestTypesSubM=By.xpath("//span[.='Request Types']");
      private final By BranchConfigurationsSubM=By.xpath("//span[.='Branch Configurations']");
      private final By TemplatesSubM=By.xpath("//span[.='Templates']");
      private final By TemplateItemsSubM=By.xpath("//span[.='Template Items']");
      private final By ApprovalConditionSubM=By.xpath("//span[.='Approval Condition']");
      private final By ApprovalWorkflowSubM=By.xpath("//span[.='Approval Workflow']");
      private final By WorkflowNodeSubM=By.xpath("(//span[.='Workflow Node'])[1]");
      
     //Setting-Pages
      private final By RequestTypesPage=By.xpath("//span[.='Request type']");
      private final By BranchConfigurationsPage=By.xpath("//span[.='Branch Configuration']");
      private final By TemplatesPage=By.xpath("//span[@class='is-active' and .='Templates']");
      private final By TemplateItemsPage=By.xpath("//span[@class='is-active' and .='Template Items']");
      private final By ApprovalConditionPage=By.xpath("//span[@class='is-active' and .='Approval Condition']");
      private final By ApprovalWorkflowPage=By.xpath("//span[@class='is-active' and .='Approval Workflow']");
      private final By WorkflowNodePage=By.xpath("//span[@class='is-active' and .='Workflow Node']");
      
      //User profile
      private final By ProfilePictName=By.xpath("//span[@class='MuiButton-label']/..");
      private final By ProfileName=By.xpath("//span[@class='MuiButton-label']/div[2]/div");
    
      private final By Home=By.xpath("//span[.='Home']");
      private final By Profile=By.xpath("//span[.='Profile']");
//    private final By SwitchLanguage=By.xpath("//p[.='Switch Language']");
      private final By SwitchLanguage=By.xpath("//ul[@role='menu']/div/div[4]");
      private final By CompanyProfile=By.xpath("//span[.='Company Profile']");
      private final By logout=By.xpath("//span[.='Logout']");
           
      
      //Switch language
      private final By tricolon=By.xpath("//*[@id='root']/div[1]/header/div[2]/div[2]/span/button");
//      private final By switchLanguage=By.xpath("//*[@id='simple-popover']/div[3]/div/ul");
      private final By EnglishLanguage=By.xpath("//li[@value='en']");
      private final By SpanishLanguage=By.xpath("(//li[@value='es'])[1]");
      private final By ChineseLanguage=By.xpath("(//li[@value='es'])[2]");
      
      //profile - page
      private final By userprofilepage=By.xpath("//span[.='Profile']");
      
      private final By FirstName_Profile=By.xpath("//span[.='First Name']");
      private final By LastName_Profile=By.xpath("//span[.='Last Name']");
      private final By NickName_Profile=By.xpath("//span[.='Nick Name']");
      private final By Gender_Profile=By.xpath("//span[.='Gender']");
      private final By Email_Profile=By.xpath("//span[.='Email']");
      private final By Phone_Profile=By.xpath("//span[.='Mobile']");
      
      //Edit profile
      private final By FirstName=By.xpath("//input[@placeholder='Enter First Name']");
      private final By LastName=By.xpath("//input[@placeholder='Enter Last Name']");
      private final By NickName=By.xpath("//input[@placeholder='Nick Name']");
      private final By Gender=By.xpath("//div[@id='mui-component-select-gender']");
      private final By Email=By.xpath("//input[@name='email']");
      private final By Countrycode=By.xpath("//input[@type='tel']");
      private final By Phone=By.xpath("//input[@name='phone']");
      
      //CompanyProfile - page
      private final By companyProfilePage=By.xpath("//span[.='Company Profile']");
      
      private final By Companyname_cp=By.xpath("//span[.='Company Name']");
      private final By IndustryType_cp=By.xpath("//span[.='Industry Type']");
      private final By CompanySize_cp=By.xpath("//span[.='Company Size']");
      private final By Code_cp=By.xpath("//span[.='Code']");
      private final By RegistrationNumber_cp=By.xpath("//span[.='Registration Number']");
      private final By Email_cp=By.xpath("//span[.='Email']");
      private final By Phonenumber_cp=By.xpath("//span[.='Phone']");
      private final By Address_cp=By.xpath("//span[.='Address']");
      private final By Country_cp=By.xpath("//span[.='Country']");
      private final By State_cp=By.xpath("//span[.='State']");
      private final By City_cp=By.xpath("//span[.='City']");
      private final By ZipCode_cp=By.xpath("//span[.='Zip Code']");
      
      
    //Edit CompanyProfile - page
//      private final By companyProfilePage=By.xpath("//span[.='Company Profile']");
//      private final By Companyname_cp=By.xpath("//input[@name='name']");
//      private final By IndustryType_cp=By.xpath("//input[@name='industry']");
//      private final By CompanySize_cp=By.xpath("//div[@id='mui-component-select-companySize']");
//      private final By Code_cp=By.xpath("//input[@name='code']");
//      private final By RegistrationNumber_cp=By.xpath("//input[@name='registrationNumber']");
//      private final By Email_cp=By.xpath("//input[@name='email']");
//      private final By countrycode_cp=By.xpath("//input[@type='tel']");
//      private final By Phonenumber_cp=By.xpath("//input[@name='phone']");
//      private final By Address_cp=By.xpath("//input[@name='address']");
//      private final By Country_cp=By.xpath("//input[@name='country']");
//      private final By State_cp=By.xpath("//input[@name='state']");
//      private final By City_cp=By.xpath("//input[@name='city']");
//      private final By ZipCode_cp=By.xpath("//input[@name='pincode']");
  
	    public superAdminPageObject(WebDriver driver) 
	    {	     
	        PageFactory.initElements(driver,this);
	    }
	    
	    
	  //Major Tabs
	    
	    public By getDashboard_Tab() {
			return Dashboard_Tab;
		}

		public By getApprover_Tab() {
			return Approver_Tab;
		}

		public By getOrganization_Tab() {
			return Organization_Tab;
		}

		public By getReports_Tab() {
			return Reports_Tab;
		}

		public By getSettings_Tab() {
			return Settings_Tab;
		}


		public By getDashboardPage() {
			return DashboardPage;
		}


		public By getApproverPage() {
			return ApproverPage;
		}


		public By getReportsPage() {
			return ReportsPage;
		}


		public By getPersonPage() {
			return PersonPage;
		}


		public By getDepartmentPage() {
			return DepartmentPage;
		}


		public By getDesignationPage() {
			return DesignationPage;
		}


		public By getUserRolePage() {
			return UserRolePage;
		}


		public By getBranchPage() {
			return BranchPage;
		}


		public By getPersonSubM() {
			return PersonSubM;
		}


		public By getDepartmentSubM() {
			return DepartmentSubM;
		}


		public By getDesignationSubM() {
			return DesignationSubM;
		}


		public By getUserRoleSubM() {
			return UserRoleSubM;
		}


		public By getBranchSubM() {
			return BranchSubM;
		}


		public By getRequestTypesSubM() {
			return RequestTypesSubM;
		}


		public By getBranchConfigurationsSubM() {
			return BranchConfigurationsSubM;
		}


		public By getTemplatesSubM() {
			return TemplatesSubM;
		}


		public By getTemplateItemsSubM() {
			return TemplateItemsSubM;
		}


		public By getApprovalConditionSubM() {
			return ApprovalConditionSubM;
		}


		public By getApprovalWorkflowSubM() {
			return ApprovalWorkflowSubM;
		}


		public By getWorkflowNodeSubM() {
			return WorkflowNodeSubM;
		}


		public By getRequestTypesPage() {
			return RequestTypesPage;
		}


		public By getBranchConfigurationsPage() {
			return BranchConfigurationsPage;
		}


		public By getTemplatesPage() {
			return TemplatesPage;
		}


		public By getTemplateItemsPage() {
			return TemplateItemsPage;
		}


		public By getApprovalConditionPage() {
			return ApprovalConditionPage;
		}


		public By getApprovalWorkflowPage() {
			return ApprovalWorkflowPage;
		}


		public By getWorkflowNodePage() {
			return WorkflowNodePage;
		}


		public By getProfilePictName() {
			return ProfilePictName;
		}


		public By getTricolon() {
			return tricolon;
		}



		public By getEnglishLanguage() {
			return EnglishLanguage;
		}


		public By getChineseLanguage() {
			return ChineseLanguage;
		}


		public By getSpanishLanguage() {
			return SpanishLanguage;
		}


		public By getHome() {
			return Home;
		}


		public By getProfile() {
			return Profile;
		}


		public By getCompanyProfile() {
			return CompanyProfile;
		}


		public By getLogout() {
			return logout;
		}


		public By getUserprofilepage() {
			return userprofilepage;
		}


		public By getCompanyProfilePage() {
			return companyProfilePage;
		}


		public By getFirstName() {
			return FirstName;
		}


		public By getLastName() {
			return LastName;
		}


		public By getNickName() {
			return NickName;
		}


		public By getGender() {
			return Gender;
		}

		public By getPhone() {
			return Phone;
		}


		public By getEmail() {
			return Email;
		}


		public By getCountrycode() {
			return Countrycode;
		}


		public By getCompanyname_cp() {
			return Companyname_cp;
		}


		public By getIndustryType_cp() {
			return IndustryType_cp;
		}


		public By getCompanySize_cp() {
			return CompanySize_cp;
		}


		public By getCode_cp() {
			return Code_cp;
		}


		public By getRegistrationNumber_cp() {
			return RegistrationNumber_cp;
		}


		public By getEmail_cp() {
			return Email_cp;
		}




		public By getPhonenumber_cp() {
			return Phonenumber_cp;
		}


		public By getAddress_cp() {
			return Address_cp;
		}


		public By getCountry_cp() {
			return Country_cp;
		}


		public By getState_cp() {
			return State_cp;
		}


		public By getCity_cp() {
			return City_cp;
		}


		public By getZipCode_cp() {
			return ZipCode_cp;
		}


		public By getProfileName() {
			return ProfileName;
		}


		public By getSwitchLanguage() {
			return SwitchLanguage;
		}


		public By getFirstName_Profile() {
			return FirstName_Profile;
		}


		public By getLastName_Profile() {
			return LastName_Profile;
		}


		public By getNickName_Profile() {
			return NickName_Profile;
		}


		public By getGender_Profile() {
			return Gender_Profile;
		}


		public By getEmail_Profile() {
			return Email_Profile;
		}


		public By getPhone_Profile() {
			return Phone_Profile;
		}    
	  
}


