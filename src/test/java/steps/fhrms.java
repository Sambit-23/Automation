package steps;

import static org.junit.Assert.assertArrayEquals;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.model.Report;

import freemarker.ext.jsp.TaglibFactory.ClearMetaInfTldSource;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Duration;
import utils.ReusableFunctions;

//import io.cucumber.java.Scenario;

import utils.base;
import pageobject.branchPageObject;
//pageobjects
import pageobject.loginPageObject;
import pageobject.superAdminPageObject;
import pageobject.branchPageObject;
import pageobject.*;
import pageobject.settingsModule;

public class fhrms extends base {

	private Properties properties;

	// page object
	private loginPageObject login;
	private superAdminPageObject superAdmin;
	private branchPageObject branchPage;
	private dashBoardPageObject dashBoard;
	private approverPageObject approver;
	private reportsPageObject reports;
	private settingsModule settings;
	private ReusableFunctions reuse;
	// static
	public static String CompanyName = "";
	public static String requestcode = "";
	public static String requestType = "";
	
	String approvalWorkflowrequestType;
	
	public WebDriverWait wait;
	private WebDriver driver;
	

	@Before("@FHRMS")
	public void setup() throws Exception {
		driver=initializeDriver("chrome", "x64", "windows");

		// page object
		login = new loginPageObject(driver);
		superAdmin = new superAdminPageObject(driver);
		branchPage = new branchPageObject(driver);
		dashBoard = new dashBoardPageObject(driver);
		approver = new approverPageObject(driver);
		reports = new reportsPageObject(driver);
		settings = new settingsModule(driver);
		reuse = new ReusableFunctions(driver);

		FileInputStream fis1 = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/data.properties");
		properties = new Properties();
		properties.load(fis1);
		driver.manage().window().maximize();
	
		wait = new WebDriverWait(driver, 50);

	}

	@After("@FHRMS")
	public void teardown() {
//		if(scenario.isFailed())
//		{
//			scenario.attach(getScreenshot(driver), "image/png", "screenshot name");
//		}
		//driver.quit();
	}

	// TC_SuperAdmin_1

	@Given("^Enter Url of SuperAdmin$")
	public void enter_url_of_superadmin() throws InterruptedException {
		driver.get(properties.getProperty("url"));
		By signin = login.getSignIn();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(signin));
	}

	@Then("^Login Page should display$")
	public void login_page_should_display() {
		Assert.assertTrue(driver.findElement(login.getSignIn()).isDisplayed());
		System.out.println(driver.findElement(login.getSignIn()).getText());

	}

	// TC_SuperAdmin_2
	@When("^Enter username and password of Super Admin$")
	public void enter_username_and_password_of_super_admin() {
		driver.findElement(login.getUsername()).sendKeys(properties.getProperty("super_admin_un"));
		driver.findElement(login.getPassword()).sendKeys(properties.getProperty("super_admin_pw"));
	}

	@And("^Click on Login button$")
	public void click_on_login_button() {
		driver.findElement(login.getLogin()).click();
	}

	@Then("^User should be able to login and it should direct to Homepage$")
	public void user_should_be_able_to_login_and_it_should_direct_to_homepage() throws InterruptedException {
		By homepage = login.getHomePageLogo();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(homepage));

		Assert.assertTrue(driver.findElement(login.getHomePageLogo()).isDisplayed());
	}

	// TC_SuperAdmin_3
	@When("^Enter Invalid email_id and password$")
	public void enter_invalid_emailid_and_password() {
		driver.findElement(login.getUsername()).sendKeys("ghysii@ghsw");
		driver.findElement(login.getPassword()).sendKeys("gyddghaj");
	}

	@Then("^It should throw an alert message as Only accepts email$")
	public void it_should_throw_an_alert_message_as_only_accepts_email() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(login.getAlert_valid_email()).isDisplayed());
		System.out.println(driver.findElement(login.getAlert_valid_email()).getText());
	}

	// TC_SuperAdmin_4
	@When("^Enter Unregistered email_id$")
	public void enter_unregistered_emailid() {
//    	driver.findElement(login.getUsername()).sendKeys("dadapeer@zktecodev.com");
		driver.findElement(login.getUsername()).sendKeys("abc@zktecodev.com");
		driver.findElement(login.getPassword()).sendKeys("Zkteco@123");
	}

	@Then("^It should throw an alert message as User does not exist$")
	public void it_should_throw_an_alert_message_as_user_does_not_exist() {
		Assert.assertTrue(driver.findElement(login.getUserDoesNotExist()).isDisplayed());
		System.out.println(driver.findElement(login.getUserDoesNotExist()).getText());
	}

	// TC_SuperAdmin_5
	@When("^Enter valid email_id and invalid password$")
	public void enter_valid_emailid_and_invalid_password() {
		driver.findElement(login.getUsername()).sendKeys("hqsuperadmin@zkteco.in");
		driver.findElement(login.getPassword()).sendKeys("Admin@123");
	}

	@Then("^It should throw an alert message as Invalid password$")
	public void it_should_throw_an_alert_message_as_invalid_password() {
		Assert.assertTrue(driver.findElement(login.getAlert_invalid()).isDisplayed());
		System.out.println(driver.findElement(login.getAlert_invalid()).getText());
	}

	// TC_SuperAdmin_6
	@When("^Enter password$")
	public void enter_password() {
		driver.findElement(login.getPassword()).sendKeys("Admin@123");
	}

	@And("^Click on Eye icon$")
	public void click_on_eye_icon() {
		driver.findElement(login.getEyeicon()).click();
	}

	@Then("^Entered password should be visible$")
	public void entered_password_should_be_visible() {
		WebElement pw = driver.findElement(login.getPassword());
		String Actualtype = pw.getAttribute("type");
		String expectedtype = "text";

		if (Actualtype.equalsIgnoreCase(expectedtype)) {
			System.out.println("Password is visible");
		} else {
			System.out.println("Password is not visible");
			assert false;
		}
	}

	// TC_SuperAdmin_7
	@And("^Double click on Eye icon$")
	public void double_click_on_eye_icon() {
		driver.findElement(login.getEyeicon()).click();
		driver.findElement(login.getEyeicon()).click();
	}

	@Then("^Entered password should be masked$")
	public void entered_password_should_be_masked() {
		WebElement pw = driver.findElement(login.getPassword());
		String Actualtype = pw.getAttribute("type");
		String expectedtype = "password";

		if (Actualtype.equalsIgnoreCase(expectedtype)) {
			System.out.println("Password is masked");
		} else {
			System.out.println("Password is not masked");
			assert false;
		}
	}

	// TC_SuperAdmin_8
	@When("^Copy and paste the value into password textfield$")
	public void copy_and_paste_the_value_into_password_textfield() {
		driver.findElement(login.getUsername()).sendKeys("NewPassWord");
		driver.findElement(login.getUsername()).sendKeys(Keys.CONTROL + "a");
		driver.findElement(login.getUsername()).sendKeys(Keys.chord(Keys.CONTROL, Keys.chord("c")));
		driver.findElement(login.getPassword()).sendKeys(Keys.chord(Keys.CONTROL, "v"));
	}

	@Then("^User should be able to paste the password and password should be masked$")
	public void user_should_be_able_to_paste_the_password_and_password_should_be_masked() throws AWTException {

		String password = driver.findElement(login.getPassword()).getAttribute("value");
		System.out.println("Pasted value is " + password);

		WebElement pw = driver.findElement(login.getPassword());
		String Actualtype = pw.getAttribute("type");
		String expectedtype = "password";

		if (Actualtype.equalsIgnoreCase(expectedtype)) {
			System.out.println("Password is masked");
		} else {
			System.out.println("Password is not masked");
			assert false;
		}
	}

	// TC_SuperAdmin_9
	@Then("^Error message should display as User name is required$")
	public void error_message_should_display_as_user_name_is_required() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(login.getUsernameisrequired()).isDisplayed());
		System.out.println(driver.findElement(login.getUsernameisrequired()).getText());
	}

	// TC_SuperAdmin_10
	@When("^Enter username$")
	public void enter_username() {
		driver.findElement(login.getUsername()).sendKeys("abcde@fghj.com");
	}

	@Then("^Error message should display as Password is required$")
	public void error_message_should_display_as_password_is_required() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(login.getPasswordisrequired()).isDisplayed());
		System.out.println(driver.findElement(login.getPasswordisrequired()).getText());
	}

	// TC_SuperAdmin_11
	@Then("^Dashboard,Approver,Organization,Reports,Settings tabs should display$")
	public void dashboardapproverorganizationreportssettings_tabs_should_display() {
		Assert.assertTrue(driver.findElement(superAdmin.getDashboard_Tab()).isDisplayed());
		System.out.println(driver.findElement(superAdmin.getDashboard_Tab()).getText());
		Assert.assertTrue(driver.findElement(superAdmin.getApprover_Tab()).isDisplayed());
		System.out.println(driver.findElement(superAdmin.getApprover_Tab()).getText());
		Assert.assertTrue(driver.findElement(superAdmin.getOrganization_Tab()).isDisplayed());
		System.out.println(driver.findElement(superAdmin.getOrganization_Tab()).getText());
		Assert.assertTrue(driver.findElement(superAdmin.getReports_Tab()).isDisplayed());
		System.out.println(driver.findElement(superAdmin.getReports_Tab()).getText());
		Assert.assertTrue(driver.findElement(superAdmin.getSettings_Tab()).isDisplayed());
		System.out.println(driver.findElement(superAdmin.getSettings_Tab()).getText());
	}

	// TC_SuperAdmin_12
	@When("^Click on Dashboard button$")
	public void click_on_dashboard_button() {
		driver.findElement(superAdmin.getDashboard_Tab()).click();
	}

	@Then("^Dashboard page should display$")
	public void dashboard_page_should_display() {
		Assert.assertTrue(driver.findElement(superAdmin.getDashboardPage()).isDisplayed());
		System.out.println("We are in " + driver.findElement(superAdmin.getDashboardPage()).getText() + " page");
	}

	// TC_SuperAdmin_13
	@When("^Click on Approver button$")
	public void click_on_approver_button() {
		driver.findElement(superAdmin.getApprover_Tab()).click();
	}

	@Then("^Approver page should display$")
	public void approver_page_should_display() {
		Assert.assertTrue(driver.findElement(superAdmin.getApproverPage()).isDisplayed());
		System.out.println("We are in " + driver.findElement(superAdmin.getApproverPage()).getText() + " page");
	}

	// TC_SuperAdmin_14
	@When("^Click on Reports button$")
	public void click_on_reports_button() {
		driver.findElement(superAdmin.getReports_Tab()).click();
	}

	@Then("^Reports page should display$")
	public void reports_page_should_display() {
		Assert.assertTrue(driver.findElement(superAdmin.getReportsPage()).isDisplayed());
		System.out.println("We are in " + driver.findElement(superAdmin.getReportsPage()).getText() + " page");
	}

	// TC_SuperAdmin_15
	@Then("^Person,Department,Designation,User role,Branch submodules should display$")
	public void persondepartmentdesignationuser_rolebranch_submodules_should_display() {
		Assert.assertTrue(driver.findElement(superAdmin.getPersonSubM()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getDepartmentSubM()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getDesignationSubM()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getUserRoleSubM()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getBranchSubM()).isDisplayed());
	}

	// TC_SuperAdmin_16

	@When("^Click on Settings button$")
	public void click_on_settings_button() {
		driver.findElement(superAdmin.getSettings_Tab()).click();
	}

	@Then("^Above mentioned sub modules should display$")
	public void above_mentioned_sub_modules_should_display() {
		Assert.assertTrue(driver.findElement(superAdmin.getRequestTypesSubM()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getBranchConfigurationsSubM()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getTemplatesSubM()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getTemplateItemsSubM()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getApprovalConditionSubM()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getApprovalWorkflowSubM()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getWorkflowNodeSubM()).isDisplayed());
	}

	// TC_SuperAdmin_17
	@And("^Click on Organization button$")
	public void click_on_organization_button() {
		driver.findElement(superAdmin.getOrganization_Tab()).click();
	}

	@When("^Click on Person button$")
	public void click_on_person_button() {
		driver.findElement(superAdmin.getPersonSubM()).click();
	}

	@Then("^Person page should display$")
	public void person_page_should_display() {
		Assert.assertTrue(driver.findElement(superAdmin.getPersonPage()).isDisplayed());
		System.out.println("We are in " + driver.findElement(superAdmin.getPersonPage()).getText() + " page");
	}

	// TC_SuperAdmin_18
	@When("^Click on Department button$")
	public void click_on_department_button() {
		driver.findElement(superAdmin.getDepartmentSubM()).click();
	}

	@Then("^Department page should display$")
	public void department_page_should_display() {
		Assert.assertTrue(driver.findElement(superAdmin.getDepartmentPage()).isDisplayed());
		System.out.println("We are in " + driver.findElement(superAdmin.getDepartmentPage()).getText() + " page");
	}

	// TC_SuperAdmin_19
	@When("^Click on Designation button$")
	public void click_on_designation_button() {
		driver.findElement(superAdmin.getDesignationSubM()).click();
	}

	@Then("^Designation page should display$")
	public void designation_page_should_display() {
		Assert.assertTrue(driver.findElement(superAdmin.getDesignationPage()).isDisplayed());
		System.out.println("We are in " + driver.findElement(superAdmin.getDesignationPage()).getText() + " page");
	}

	// TC_SuperAdmin_20
	@When("^Click on UserRole button$")
	public void click_on_userrole_button() {
		driver.findElement(superAdmin.getUserRoleSubM()).click();
	}

	@Then("^User Role page should display$")
	public void user_role_page_should_display() {
		Assert.assertTrue(driver.findElement(superAdmin.getUserRolePage()).isDisplayed());
		System.out.println("We are in " + driver.findElement(superAdmin.getUserRolePage()).getText() + " page");
	}

	// TC_SuperAdmin_21
	@When("^Click on Branch button$")
	public void click_on_branch_button() throws InterruptedException {
		driver.findElement(superAdmin.getBranchSubM()).click();
		Thread.sleep(2000);
	}

	@Then("^Branch page should display$")
	public void branch_page_should_display() {
		Assert.assertTrue(driver.findElement(superAdmin.getBranchPage()).isDisplayed());
		System.out.println("We are in " + driver.findElement(superAdmin.getBranchPage()).getText() + " page");
	}

	// TC_SuperAdmin_27
	@When("^Click on Request Type button$")
	public void click_on_request_type_button() {
		driver.findElement(superAdmin.getRequestTypesSubM()).click();
	}

	@Then("^Request Type page should display$")
	public void request_type_page_should_display() {
		Assert.assertTrue(driver.findElement(superAdmin.getRequestTypesPage()).isDisplayed());
		System.out.println("We are in " + driver.findElement(superAdmin.getRequestTypesPage()).getText() + " page");
	}

	// TC_SuperAdmin_23
	@When("^Click on Branch Configuration button$")
	public void click_on_branch_configuration_button() {
		driver.findElement(superAdmin.getBranchConfigurationsSubM()).click();
	}

	@Then("^Branch Configuration page should display$")
	public void branch_configuration_page_should_display() {
		Assert.assertTrue(driver.findElement(superAdmin.getBranchConfigurationsPage()).isDisplayed());
		System.out.println(
				"We are in " + driver.findElement(superAdmin.getBranchConfigurationsPage()).getText() + " page");
	}

	// TC_SuperAdmin_24
	@When("^Click on Templates button$")
	public void click_on_templates_button() {
		driver.findElement(superAdmin.getTemplatesSubM()).click();
	}

	@Then("^Templates page should display$")
	public void templates_page_should_display() {
		Assert.assertTrue(driver.findElement(superAdmin.getTemplatesPage()).isDisplayed());
		System.out.println("We are in " + driver.findElement(superAdmin.getTemplatesPage()).getText() + " page");
	}

	// TC_SuperAdmin_25
	@When("^Click on Template Items button$")
	public void click_on_template_items_button() {
		driver.findElement(superAdmin.getTemplateItemsSubM()).click();
	}

	@Then("^Template Items page should display$")
	public void template_items_page_should_display() {
		Assert.assertTrue(driver.findElement(superAdmin.getTemplateItemsPage()).isDisplayed());
		System.out.println("We are in " + driver.findElement(superAdmin.getTemplateItemsPage()).getText() + " page");
	}

	// TC_SuperAdmin_26
	@When("^Click on Approval Condition button$")
	public void click_on_approval_condition_button() {
		driver.findElement(superAdmin.getApprovalConditionSubM()).click();
	}

	@Then("^Approval Condition page should display$")
	public void approval_condition_page_should_display() {
		Assert.assertTrue(driver.findElement(superAdmin.getApprovalConditionPage()).isDisplayed());
		System.out
				.println("We are in " + driver.findElement(superAdmin.getApprovalConditionPage()).getText() + " page");
	}

	// TC_SuperAdmin_27
	@When("^Click on Approval Workflow button$")
	public void click_on_approval_workflow_button() {
		driver.findElement(superAdmin.getApprovalWorkflowSubM()).click();
	}

	@Then("^Approval Workflow page should display$")
	public void approval_workflow_page_should_display() {
		Assert.assertTrue(driver.findElement(superAdmin.getApprovalWorkflowPage()).isDisplayed());
		System.out.println("We are in " + driver.findElement(superAdmin.getApprovalWorkflowPage()).getText() + " page");
	}

	// TC_SuperAdmin_28
	@When("^Click on Workflow Node button$")
	public void click_on_workflow_node_button() throws Exception {
		windowMinimize(2);
		driver.findElement(superAdmin.getWorkflowNodeSubM()).click();
	}

	@Then("^Workflow Node page should display$")
	public void workflow_node_page_should_display() {
		Assert.assertTrue(driver.findElement(superAdmin.getWorkflowNodePage()).isDisplayed());
		System.out.println("We are in " + driver.findElement(superAdmin.getWorkflowNodePage()).getText() + " page");
	}

	// TC_SuperAdmin_34
	@Then("^UserProfilePicture should display with Name$")
	public void userprofilepicture_should_display_with_name() {
		Assert.assertTrue(driver.findElement(superAdmin.getProfilePictName()).isDisplayed());
		System.out.println(driver.findElement(superAdmin.getProfileName()).getText());
//    	driver.findElement(superAdmin.getTricolon()).click();
//    	Assert.assertTrue(driver.findElement(superAdmin.getSwitchLanguage()).isDisplayed()); 
	}

	// TC_SuperAdmin_35
	@And("^Click on top profile$")
	public void click_on_top_profile() throws Exception {
		windowMinimize(2);
		WebElement ele = driver.findElement(superAdmin.getProfileName());
		wait.until(ExpectedConditions.visibilityOf(ele));
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();

	}

	@Then("^Home,Profile,Switch language,Company Profile,Logout options should display$")
	public void homeprofileswitch_languagecompany_profilelogout_options_should_display() throws InterruptedException {
		WebElement ele = driver.findElement(superAdmin.getHome());
		wait.until(ExpectedConditions.visibilityOf(ele));
		Assert.assertTrue(driver.findElement(superAdmin.getHome()).isDisplayed());
		System.out.println(driver.findElement(superAdmin.getHome()).getText());
		Assert.assertTrue(driver.findElement(superAdmin.getProfile()).isDisplayed());
		System.out.println(driver.findElement(superAdmin.getProfile()).getText());
		Assert.assertTrue(driver.findElement(superAdmin.getSwitchLanguage()).isDisplayed());
		System.out.println(driver.findElement(superAdmin.getSwitchLanguage()).getText());
		Assert.assertTrue(driver.findElement(superAdmin.getCompanyProfile()).isDisplayed());
		System.out.println(driver.findElement(superAdmin.getCompanyProfile()).getText());
		Assert.assertTrue(driver.findElement(superAdmin.getLogout()).isDisplayed());
		System.out.println(driver.findElement(superAdmin.getLogout()).getText());
	}

	// TC_SuperAdmin_36
	@When("^Click on Home button$")
	public void click_on_home_button() {
		driver.findElement(superAdmin.getHome()).click();
	}

	// TC_SuperAdmin_37
	@When("^Click on Profile button$")
	public void click_on_profile_button() {
		driver.findElement(superAdmin.getProfile()).click();
	}

	@Then("^User profile page should display$")
	public void user_profile_page_should_display() {
		Assert.assertTrue(driver.findElement(superAdmin.getUserprofilepage()).isDisplayed());
		System.out.println("We are in " + driver.findElement(superAdmin.getUserprofilepage()).getText() + " page");
	}

	// TC_SuperAdmin_38
	@Then("^Above mentioned options should display in User profile page$")
	public void above_mentioned_options_should_display_in_user_profile_page() {

		Assert.assertTrue(driver.findElement(superAdmin.getFirstName_Profile()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getLastName_Profile()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getNickName_Profile()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getGender_Profile()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getEmail_Profile()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getPhone_Profile()).isDisplayed());
	}

	// TC_SuperAdmin_34
	@When("^Click on CompanyProfile button$")
	public void click_on_companyprofile_button() {
		driver.findElement(superAdmin.getCompanyProfile()).click();
	}

	@Then("^CompanyProfile page should display$")
	public void companyprofile_page_should_display() {
		Assert.assertTrue(driver.findElement(superAdmin.getCompanyProfilePage()).isDisplayed());
		System.out.println("We are in " + driver.findElement(superAdmin.getCompanyProfilePage()).getText() + " page");
	}

	// TC_SuperAdmin_35
	@Then("^Above mentioned options should display in Company Profile page$")
	public void above_mentioned_options_should_display_in_company_profile_page() {
		Assert.assertTrue(driver.findElement(superAdmin.getCompanyname_cp()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getIndustryType_cp()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getCompanySize_cp()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getCode_cp()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getRegistrationNumber_cp()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getEmail_cp()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getPhonenumber_cp()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getAddress_cp()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getCountry_cp()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getState_cp()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getCity_cp()).isDisplayed());
		Assert.assertTrue(driver.findElement(superAdmin.getZipCode_cp()).isDisplayed());
	}

	// TC_SuperAdmin_36
	@When("^Click on Logout button$")
	public void click_on_logout_button() {
		driver.findElement(superAdmin.getLogout()).click();
	}

	// TC_SuperAdmin_37
	@And("^Click on tricolon button$")
	public void click_on_tricolon_button() {
		driver.findElement(superAdmin.getTricolon()).click();
	}

	@When("^Click on SwitchLanguage button$")
	public void click_on_switchlanguage_button() {
		driver.findElement(superAdmin.getSwitchLanguage()).click();
	}

	@Then("^English,Spanish,Chinese languages should display in new window$")
	public void englishspanishchinese_languages_should_display_in_new_window() {
		Assert.assertTrue(driver.findElement(superAdmin.getEnglishLanguage()).isDisplayed());
		System.out.println(driver.findElement(superAdmin.getEnglishLanguage()).getText());
		Assert.assertTrue(driver.findElement(superAdmin.getSpanishLanguage()).isDisplayed());
		System.out.println(driver.findElement(superAdmin.getSpanishLanguage()).getText());
		Assert.assertTrue(driver.findElement(superAdmin.getChineseLanguage()).isDisplayed());
		System.out.println(driver.findElement(superAdmin.getChineseLanguage()).getText());
	}

	// TC_SuperAdmin_38
	@Then("^Dashboard page should contains above mentioned sub tabs$")
	public void dashboard_page_should_contains_above_mentioned_sub_tabs() {
		Assert.assertTrue(driver.findElement(dashBoard.getPendingTab()).isDisplayed());
		Assert.assertTrue(driver.findElement(dashBoard.getApprovedTab()).isDisplayed());
		Assert.assertTrue(driver.findElement(dashBoard.getRejectedTab()).isDisplayed());
		Assert.assertTrue(driver.findElement(dashBoard.getCancelledTab()).isDisplayed());
	}

	// TC_SuperAdmin_39
	@Then("^Pending requests count should display in dashboard page$")
	public void pending_requests_count_should_display_in_dashboard_page() throws InterruptedException {
		Thread.sleep(2000);
		WebElement pendingCount = driver.findElement(dashBoard.getPendingCount());
		Assert.assertTrue(pendingCount.isDisplayed());
		System.out.println("Pending count:" + pendingCount.getText());
	}

	// TC_SuperAdmin_40
	@Then("^Approved requests count should display in dashboard page$")
	public void approved_requests_count_should_display_in_dashboard_page() throws InterruptedException {
		Thread.sleep(2000);
		WebElement approvedCount = driver.findElement(dashBoard.getApprovedCount());
		Assert.assertTrue(approvedCount.isDisplayed());
		System.out.println("Approved count:" + approvedCount.getText());
	}

	// TC_SuperAdmin_41
	@Then("^Rejected requests count should display in dashboard page$")
	public void rejected_requests_count_should_display_in_dashboard_page() throws InterruptedException {
		Thread.sleep(2000);
		WebElement rejectedCount = driver.findElement(dashBoard.getRejectedCount());
		Assert.assertTrue(rejectedCount.isDisplayed());
		System.out.println("Rejected count:" + rejectedCount.getText());
	}

	// TC_SuperAdmin_42
	@Then("^Cancelled requests count should display in dashboard page$")
	public void cancelled_requests_count_should_display_in_dashboard_page() throws InterruptedException {
		Thread.sleep(2000);
		WebElement cancelledCount = driver.findElement(dashBoard.getRejectedCount());
		Assert.assertTrue(cancelledCount.isDisplayed());
		System.out.println("Cancelled count:" + cancelledCount.getText());
	}

	// TC_SuperAdmin_43
	@And("^Click on Pending request tab$")
	public void click_on_pending_request_tab() {
		driver.findElement(dashBoard.getPendingTab()).click();
	}

	@Then("^Only Pending requests should display in Pending request page$")
	public void only_pending_requests_should_display_in_pending_request_page() {
		List<WebElement> statusList = driver.findElements(dashBoard.getStatusList());
		int elementsCount = statusList.size();
		String Status = "PENDING";

		if (elementsCount < 1) {
			System.out.println("Pending request list is empty");
		}
		if (elementsCount > 1) {
			for (WebElement ele : statusList) {
				String text = ele.getText();
				if (Status != text) {
					assert false;
				}
			}
		}
	}

	// TC_SuperAdmin_44
	@And("^Click on Approved request tab$")
	public void click_on_approved_request_tab() {
		driver.findElement(dashBoard.getApprovedTab()).click();
	}

	@Then("^Only Approved requests should display in Approved request page$")
	public void only_approved_requests_should_display_in_approved_request_page() {
		List<WebElement> statusList = driver.findElements(dashBoard.getStatusList());
		int elementsCount = statusList.size();
		String Status = "APPROVED";

		if (elementsCount < 1) {
			System.out.println("Approved request list is empty");
		}
		if (elementsCount > 1) {
			for (WebElement ele : statusList) {
				String text = ele.getText();
				if (Status != text) {
					assert false;
				}
			}
		}
	}

	// TC_SuperAdmin_45
	@And("^Click on Rejected request tab$")
	public void click_on_rejected_request_tab() {
		driver.findElement(dashBoard.getRejectedTab()).click();
	}

	@Then("^Only Rejected requests should display in Rejected request page$")
	public void only_rejected_requests_should_display_in_rejected_request_page() {
		List<WebElement> statusList = driver.findElements(dashBoard.getStatusList());
		int elementsCount = statusList.size();
		String Status = "REJECTED";

		if (elementsCount < 1) {
			System.out.println("Approved request list is empty");
		}
		if (elementsCount > 1) {
			for (WebElement ele : statusList) {
				String text = ele.getText();
				if (Status != text) {
					assert false;
				}
			}
		}
	}

	// TC_SuperAdmin_46
	@And("^Click on Cancelled request tab$")
	public void click_on_cancelled_request_tab() {
		driver.findElement(dashBoard.getCancelledTab()).click();
	}

	@Then("^Only Cancelled requests should display in Cancelled request page$")
	public void only_cancelled_requests_should_display_in_cancelled_request_page() {
		List<WebElement> statusList = driver.findElements(dashBoard.getStatusList());
		int elementsCount = statusList.size();
		String Status = "CANCELLED";

		if (elementsCount < 1) {
			System.out.println("Approved request list is empty");
		}
		if (elementsCount > 1) {
			for (WebElement ele : statusList) {
				String text = ele.getText();
				if (Status != text) {
					assert false;
				}
			}
		}
	}

	// TC_SuperAdmin_53
	@Then("^Branch,RequestType and Status of request headers should display$")
	public void branchrequesttype_and_status_of_request_headers_should_display() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(dashBoard.getBranchHeader()).isDisplayed());
		System.out.println(driver.findElement(dashBoard.getBranchHeader()).getText());
		Assert.assertTrue(driver.findElement(dashBoard.getRequestTypeHeader()).isDisplayed());
		System.out.println(driver.findElement(dashBoard.getRequestTypeHeader()).getText());
		Assert.assertTrue(driver.findElement(dashBoard.getStatusHeader()).isDisplayed());
		System.out.println(driver.findElement(dashBoard.getStatusHeader()).getText());
	}

	// TC_SuperAdmin_51
	// 1.Name 2.Request Type 3.Branch 4.Employee 5.Status 6.Creation Date
	// 7.Description 8.Actions
	@Then("^Above mentioned Headers should display in Approver page$")
	public void above_mentioned_headers_should_display_in_approver_page() throws InterruptedException {
		Thread.sleep(2000);
		WebElement Name = driver.findElement(approver.getNameHeader());
		WebElement RequestType = driver.findElement(approver.getRequestHeader());
		WebElement Branch = driver.findElement(approver.getBranchHeader());
		WebElement Employee = driver.findElement(approver.getEmployeeHeader());
		WebElement Status = driver.findElement(approver.getStatusHeader());
		WebElement CreationDate = driver.findElement(approver.getCreationDateHeader());
		WebElement Description = driver.findElement(approver.getDescriptionHeader());
		WebElement Actions = driver.findElement(approver.getActionsHeader());

		Assert.assertTrue(Name.isDisplayed());
		Assert.assertTrue(RequestType.isDisplayed());
		Assert.assertTrue(Branch.isDisplayed());
		Assert.assertTrue(Employee.isDisplayed());
		Assert.assertTrue(Status.isDisplayed());
		Assert.assertTrue(CreationDate.isDisplayed());
		Assert.assertTrue(Description.isDisplayed());
		Assert.assertTrue(Actions.isDisplayed());

		System.out.println("Headers in approver page");
		System.out.println(Name.getText());
		System.out.println(RequestType.getText());
		System.out.println(Branch.getText());
		System.out.println(Employee.getText());
		System.out.println(Status.getText());
		System.out.println(CreationDate.getText());
		System.out.println(Description.getText());
		System.out.println(Actions.getText());
	}

	// TC_SuperAdmin_72
	@Then("^Approved,Rejected,Cancelled subtabs should display in Reports page$")
	public void approvedrejectedcancelled_subtabs_should_display_in_reports_page() {
		Assert.assertTrue(driver.findElement(reports.getApproved()).isDisplayed());
		System.out.println(driver.findElement(reports.getApproved()).getText());
		Assert.assertTrue(driver.findElement(reports.getRejected()).isDisplayed());
		System.out.println(driver.findElement(reports.getRejected()).getText());
		Assert.assertTrue(driver.findElement(reports.getCancelled()).isDisplayed());
		System.out.println(driver.findElement(reports.getCancelled()).getText());
	}

	// TC_SuperAdmin_73
	@When("^Click on Approved tab in reports page$")
	public void click_on_approved_tab_in_reports_page() {
		driver.findElement(reports.getApproved()).click();
	}

	@Then("^Branch,Request Type,Status headers should display$")
	public void branchrequest_typestatus_headers_should_display() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(reports.getBranchHeader()).isDisplayed());
		System.out.println(driver.findElement(reports.getBranchHeader()).getText());
		Assert.assertTrue(driver.findElement(reports.getRequestTypeHeader()).isDisplayed());
		System.out.println(driver.findElement(reports.getRequestTypeHeader()).getText());
		Assert.assertTrue(driver.findElement(reports.getStatusHeader()).isDisplayed());
		System.out.println(driver.findElement(reports.getStatusHeader()).getText());
	}

	// TC_SuperAdmin_74
	@Then("^Only approved request should display in Approved Request page$")
	public void only_approved_request_should_display_in_approved_request_page() throws InterruptedException {
		By ApprovedWait = By.xpath("//td[@value='APPROVED']");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ApprovedWait));

		List<WebElement> status = driver.findElements(reports.getStatusList());
		String expStatus = "APPROVED";
		for (WebElement ele : status) {
			String ActualStatus = ele.getText();
			System.out.println(ActualStatus);
			if (ActualStatus.equalsIgnoreCase(expStatus)) {
				assert true;
			} else {
				assert false;
			}
		}
	}

	// TC_SuperAdmin_75
	@When("^Click on Rejected tab in reports page$")
	public void click_on_rejected_tab_in_reports_page() {
		driver.findElement(reports.getRejected()).click();
	}

	// TC_SuperAdmin_76
	@Then("^Only Rejected request should display in Rejected Request page$")
	public void only_rejected_request_should_display_in_rejected_request_page() throws InterruptedException {
		By RejectedWait = By.xpath("//td[@value='REJECTED']");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(RejectedWait));

		List<WebElement> status = driver.findElements(reports.getStatusList());
		String expStatus = "REJECTED";
		for (WebElement ele : status) {
			String ActualStatus = ele.getText();
			System.out.println(ActualStatus);
			if (ActualStatus.equalsIgnoreCase(expStatus)) {
				assert true;
			} else {
				assert false;
			}
		}
	}

	// TC_SuperAdmin_77
	@When("^Click on Cancelled tab in reports page$")
	public void click_on_cancelled_tab_in_reports_page() {
		driver.findElement(reports.getCancelled()).click();
	}

	// TC_SuperAdmin_78
	@Then("^Only Cancelled request should display in Cancelled Request page$")
	public void only_cancelled_request_should_display_in_cancelled_request_page() throws InterruptedException {
		By CancelledWait = By.xpath("//td[@value='CANCELLED']");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CancelledWait));

		List<WebElement> status = driver.findElements(reports.getStatusList());
		String expStatus = "CANCELLED";
		for (WebElement ele : status) {
			String ActualStatus = ele.getText();
			System.out.println(ActualStatus);
			if (ActualStatus.equalsIgnoreCase(expStatus)) {
				assert true;
			} else {
				assert false;
			}
		}
	}

	// TC_SuperAdmin_186
	@Then("^Above mentioned options should be present in Branch page$")
	public void above_mentioned_options_should_be_present_in_branch_page() {
		Assert.assertTrue(driver.findElement(branchPage.getBranchCode()).isDisplayed());
		System.out.println(driver.findElement(branchPage.getBranchCode()).getText());
		Assert.assertTrue(driver.findElement(branchPage.getBranchName()).isDisplayed());
		System.out.println(driver.findElement(branchPage.getBranchName()).getText());
		Assert.assertTrue(driver.findElement(branchPage.getCountry()).isDisplayed());
		System.out.println(driver.findElement(branchPage.getCountry()).getText());
		Assert.assertTrue(driver.findElement(branchPage.getStatus()).isDisplayed());
		System.out.println(driver.findElement(branchPage.getStatus()).getText());
		Assert.assertTrue(driver.findElement(branchPage.getActions()).isDisplayed());
		System.out.println(driver.findElement(branchPage.getActions()).getText());
	}

	// TC_SuperAdmin_187
	@Then("^Add button should be present in Branch Page$")
	public void add_button_should_be_present_in_branch_page() {
		Assert.assertTrue(driver.findElement(branchPage.getAddButton()).isDisplayed());
	}

	// TC_SuperAdmin_188
	@And("^Click on Add button in Branch Page$")
	public void click_on_add_button_in_branch_page() {
		driver.findElement(branchPage.getAddButton()).click();
	}

	@Then("^Add branch window should display$")
	public void add_branch_window_should_display() throws InterruptedException {
		Assert.assertTrue(driver.findElement(branchPage.getAddBranchPage()).isDisplayed());
	}

	// TC_SuperAdmin_189
	@Then("^Above mentioned options should display under User profile$")
	public void above_mentioned_options_should_display_under_user_profile() {
		Assert.assertTrue(driver.findElement(branchPage.getFirstName()).isDisplayed());
		Assert.assertTrue(driver.findElement(branchPage.getLastName()).isDisplayed());
		Assert.assertTrue(driver.findElement(branchPage.getEmail()).isDisplayed());
	}

	// TC_SuperAdmin_190
	@Then("^Above mentioned options should display under company profile$")
	public void above_mentioned_options_should_display_under_company_profile() {
		Assert.assertTrue(driver.findElement(branchPage.getCompanyName()).isDisplayed());
		Assert.assertTrue(driver.findElement(branchPage.getCountry_ABP()).isDisplayed());
	}

	// TC_SuperAdmin_191
	@Then("^Submit and Cancel buttons should be present in Add branch page$")
	public void submit_and_cancel_buttons_should_be_present_in_add_branch_page() {
		Assert.assertTrue(driver.findElement(branchPage.getSubmitButton()).isDisplayed());
		System.out.println(driver.findElement(branchPage.getSubmitButton()).getText());
		Assert.assertTrue(driver.findElement(branchPage.getCancelButton()).isDisplayed());
		System.out.println(driver.findElement(branchPage.getCancelButton()).getText());
	}

	// TC_SuperAdmin_192
	@And("^Enter User profile and Company profile details$")
	public void enter_user_profile_and_company_profile_details() throws InterruptedException, AWTException {

		String firstName = RandomStringUtils.randomAlphabetic(4);
		String lastName = RandomStringUtils.randomAlphabetic(4);
		CompanyName = "";
		CompanyName = RandomStringUtils.randomAlphabetic(4);
		driver.findElement(branchPage.getFirstName()).sendKeys(firstName);
		driver.findElement(branchPage.getLastName()).sendKeys(lastName);
		driver.findElement(branchPage.getEmail()).sendKeys(firstName + "@" + CompanyName + ".com");
		driver.findElement(branchPage.getCompanyName()).sendKeys(CompanyName);

		// Contry dropdown
		driver.findElement(branchPage.getCountry_ABP()).sendKeys(properties.getProperty("Country"));
		Thread.sleep(3000);
//        new Actions(driver).moveToElement(driver.findElement(By.xpath("//*[text()='"+properties.getProperty("Country")+"']"))).click().build().perform();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	@And("^Click on Submit button$")
	public void click_on_submit_button() throws InterruptedException {
		driver.findElement(branchPage.getSubmitButton()).click();
	}

	// TC_SuperAdmin_193
	@Then("^Verify created branch is displaying in branch page or not$")
	public void verify_created_branch_is_displaying_in_branch_page_or_not() {
		By branch = By.xpath("//span[.='" + CompanyName + "']");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(branch)));

		int branchcount = 0;
		System.out.println("Added branch is " + CompanyName);

		List<WebElement> BranchName = driver.findElements(branchPage.getBranchNameList());

		for (WebElement ele : BranchName) {
			String branchName = ele.getText();
			if (branchName.equalsIgnoreCase(CompanyName)) {
				branchcount = 1;
				System.out.println("Added Branch is Displayed in Branch List");
				break;
			}
		}
		if (branchcount == 1) {
			assert true;
		} else {
			assert false;
		}
	}

	// TC_SuperAdmin_194
	@And("^Click on Cancel button$")
	public void click_on_cancel_button() {
		driver.findElement(branchPage.getCancelButton()).click();
	}

	@Then("^It should cancel and redirect to Branch page$")
	public void it_should_cancel_and_redirect_to_branch_page() {
		Assert.assertTrue(driver.findElement(branchPage.getBranchPage()).isDisplayed());
	}

	// TC_SuperAdmin_195
	@Then("^Error message should display as First name is mandatory$")
	public void error_message_should_display_as_first_name_is_mandatory() {
		By error = branchPage.getFirstNameIsMandatory();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(error));
		Assert.assertTrue(driver.findElement(branchPage.getFirstNameIsMandatory()).isDisplayed());
		System.out.println(driver.findElement(branchPage.getFirstNameIsMandatory()).getText());
	}

	// TC_SuperAdmin_196
	@And("^Do not enter email into Email text field$")
	public void do_not_eneter_email_into_email_text_field() {
		String firstName = RandomStringUtils.randomAlphabetic(4);
		driver.findElement(branchPage.getFirstName()).sendKeys(firstName);
	}

	@Then("^Error message should display as Email is mandatory$")
	public void error_message_should_display_as_user_email_is_mandatory() {
		By error = branchPage.getEmailIsMandatory();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(error));
		Assert.assertTrue(driver.findElement(branchPage.getEmailIsMandatory()).isDisplayed());
		System.out.println(driver.findElement(branchPage.getEmailIsMandatory()).getText());
	}

	// TC_SuperAdmin_197
	@And("^Do not enter companyName into companyName text field$")
	public void do_not_enter_companyname_into_companyname_text_field() {
		String firstName = RandomStringUtils.randomAlphabetic(4);
		CompanyName = "";
		CompanyName = RandomStringUtils.randomAlphabetic(4);

		driver.findElement(branchPage.getFirstName()).sendKeys(firstName);
		driver.findElement(branchPage.getEmail()).sendKeys(firstName + "@" + CompanyName + ".com");
	}

	@Then("^Error message should display as Branch name is mandatory$")
	public void error_message_should_display_as_company_name_is_mandatory() {
		By error = branchPage.getCompanyNameIsMandatory();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(error));
		Assert.assertTrue(driver.findElement(branchPage.getCompanyNameIsMandatory()).isDisplayed());
		System.out.println(driver.findElement(branchPage.getCompanyNameIsMandatory()).getText());
	}

	// TC_SuperAdmin_198
	@And("^Do not select Country$")
	public void do_not_select_country() {
		String firstName = RandomStringUtils.randomAlphabetic(4);
		String lastName = RandomStringUtils.randomAlphabetic(4);
		CompanyName = "";
		CompanyName = RandomStringUtils.randomAlphabetic(4);
		driver.findElement(branchPage.getFirstName()).sendKeys(firstName);
		driver.findElement(branchPage.getLastName()).sendKeys(lastName);
		driver.findElement(branchPage.getEmail()).sendKeys(firstName + "@" + CompanyName + ".com");
		driver.findElement(branchPage.getCompanyName()).sendKeys(CompanyName);
	}

	@Then("^Error message should display as Country is mandatory$")
	public void error_message_should_display_as_country_is_mandatory() {
		By error = branchPage.getCountryIsMandatory();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(error));
		Assert.assertTrue(driver.findElement(branchPage.getCountryIsMandatory()).isDisplayed());
		System.out.println(driver.findElement(branchPage.getCountryIsMandatory()).getText());
	}

	// TC_SuperAdmin_11

	@When("^Click on \"([^\"]*)\" link$")
	public void click_on_something_link(String strArg1) {
		driver.findElement(By.linkText(strArg1)).click();
	}

	@Then("^\"([^\"]*)\" Window should display$")
	public void something_window_should_display(String strArg1) {
//    	Assert.assertTrue(driver.findElement(By.xpath("//p[.='"+strArg1+"']")).isDisplayed());
//    	System.out.println(driver.findElement(By.xpath("//p[.='"+strArg1+"']")).getText());

		Assert.assertTrue(driver.findElement(login.getForgotPasswordPage()).isDisplayed());
//    	System.out.println(driver.findElement(login.getForgotPasswordPage()).getText());

	}

	// TC_SuperAdmin_12
	@When("^Click on Send Link button$")
	public void click_on_send_link_button() {
		driver.findElement(login.getSendLink()).click();
	}

	@Then("^Error message should display as \"([^\"]*)\"$")
	public void error_message_should_display_as_something(String strArg1) {
		WebElement errorMessage = driver.findElement(By.xpath("//div[.='" + strArg1 + "' and @role='alert']"));
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		Assert.assertTrue(errorMessage.isDisplayed());
		System.out.println(errorMessage.getText());
	}

	// TC_SuperAdmin_13
	@And("^Enter unregistered email address$")
	public void enter_unregistered_email_address() {
		driver.findElement(login.getUsername()).sendKeys("sfijj@kodkg.com");
	}

//    //
//    @Given("^Enter Url of BranchAdmin$")
//    public void enter_url_of_branchadmin() throws Throwable {
//        throw new PendingException();
//    }
//
//    @When("^Enter username and password of BranchAdmin$")
//    public void enter_username_and_password_of_branchadmin() throws Throwable {
//        throw new PendingException();
//    }
//
//    @Then("^Branch admin should be able to enter login credentials$")
//    public void branch_admin_should_be_able_to_enter_login_credentials() throws Throwable {
//        throw new PendingException();
//    }

	// TC_SuperAdmin_204
	@And("^Enter data into all mandatory fields and do not enter data into last name textfield$")
	public void enter_data_into_all_mandatory_fields_and_do_not_enter_data_into_last_name_textfield()
			throws InterruptedException, AWTException {
		String firstName = RandomStringUtils.randomAlphabetic(4);

		CompanyName = "";
		CompanyName = RandomStringUtils.randomAlphabetic(4);
		driver.findElement(branchPage.getFirstName()).sendKeys(firstName);

		driver.findElement(branchPage.getEmail()).sendKeys(firstName + "@" + CompanyName + ".com");
		driver.findElement(branchPage.getCompanyName()).sendKeys(CompanyName);

		// Contry dropdown
		driver.findElement(branchPage.getCountry_ABP()).sendKeys(properties.getProperty("Country"));
		Thread.sleep(3000);
//        new Actions(driver).moveToElement(driver.findElement(By.xpath("//*[text()='"+properties.getProperty("Country")+"']"))).click().build().perform();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	// TC_SuperAdmin_204
	@Then("^Admin should be able to add Branch without last name$")
	public void admin_should_be_able_to_add_branch_without_last_name() {
		WebElement msg = driver.findElement(branchPage.getSuccessMessage());
		wait.until(ExpectedConditions.visibilityOf(msg));
		Assert.assertTrue(msg.isDisplayed());
		System.out.println(msg.getText());
	}

	// TC_SuperAdmin_205
	@And("^Enter invalid data into first name text field$")
	public void enter_invalid_data_into_first_name_text_field() {
		driver.findElement(branchPage.getFirstName()).sendKeys("123456");
	}

	// TC_SuperAdmin_206
	@And("^Enter invalid id into Email text field$")
	public void enter_invalid_id_into_email_text_field() {
		String firstName = RandomStringUtils.randomAlphabetic(4);
		driver.findElement(branchPage.getFirstName()).sendKeys(firstName);
		driver.findElement(branchPage.getEmail()).sendKeys("sdfghj");
	}

	// TC_SuperAdmin_207
	@Then("^Added branch should list in Branch page$")
	public void added_branch_should_list_in_branch_page() {
		List<WebElement> branchList = driver.findElements(branchPage.getBranchNameList());
		if (branchList.size() == 0) {
			System.out.println("No records found");
		}
		if (branchList.size() > 0) {
			System.out.println(branchList.size());
		}
	}

	// TC_SuperAdmin_208

	@And("^click on Edit button of any one branch$")
	public void click_on_edit_button_of_any_one_branch() {
		List<WebElement> branchList = driver.findElements(branchPage.getBranchNameList());
		WebElement ele = driver.findElement(branchPage.getEditButton());
		wait.until(ExpectedConditions.visibilityOf(ele));

		if (branchList.size() == 0) {
			System.out.println("No records found");
		}
		if (branchList.size() > 0) {
			ele.click();
		}
	}

	@Then("^\"([^\"]*)\" page should display$")
	public void something_page_should_display(String strArg1) {
		WebElement page = driver.findElement(By.xpath("//span[.='" + strArg1 + "']"));
		if (page.isDisplayed()) {
			System.out.println(strArg1 + " page is displayed");
		} else if (driver.findElement(By.xpath("//span[.='No Records Found']")).isDisplayed()) {
			System.out.println("No Records Found");
		} else {
			assert false;
		}
	}

	// TC_SuperAdmin_209
	@Then("^Above mentioned components should be present and enabled in Edit branch page$")
	public void above_mentioned_components_should_be_present_and_enabled_in_edit_branch_page() {
		WebElement comapanyName = driver.findElement(branchPage.getComapanyName());
		WebElement industryType = driver.findElement(branchPage.getIndustryType());
		WebElement selectCountryDropdown = driver.findElement(branchPage.getSelectCountryDropdown());
		WebElement state = driver.findElement(branchPage.getState());
		WebElement city = driver.findElement(branchPage.getCity());
		WebElement zipCode = driver.findElement(branchPage.getZipCode());

		Assert.assertTrue(comapanyName.isDisplayed());
		Assert.assertTrue(industryType.isDisplayed());
		Assert.assertTrue(selectCountryDropdown.isDisplayed());
		Assert.assertTrue(state.isDisplayed());
		Assert.assertTrue(city.isDisplayed());
		Assert.assertTrue(zipCode.isDisplayed());

		Assert.assertTrue(comapanyName.isEnabled());
		Assert.assertTrue(industryType.isEnabled());
		Assert.assertTrue(selectCountryDropdown.isEnabled());
		Assert.assertTrue(state.isEnabled());
		Assert.assertTrue(city.isEnabled());
		Assert.assertTrue(zipCode.isEnabled());

	}

	// TC_SuperAdmin_210
	@And("^Change company name$")
	public void change_company_name() throws Throwable {
		CompanyName = "";
		WebElement branchName = driver.findElement(branchPage.getComapanyName());
		CompanyName = branchName.getAttribute("value");
		Clear(branchName);
		branchName.sendKeys(CompanyName + "a");
		CompanyName = branchName.getAttribute("value");
	}

	@Then("^Success message should display as \"([^\"]*)\"$")
	public void success_message_should_display_as_something(String strArg1) {
		WebElement msg = driver.findElement(By.xpath("//div[.='" + strArg1 + "' and @role='alert']"));
		wait.until(ExpectedConditions.visibilityOf(msg));
		Assert.assertTrue(msg.isDisplayed());
		System.out.println(msg.getText());
	}

	// TC_SuperAdmin_211
	@Then("^Updated branch should display in branch page$")
	public void updated_branch_should_display_in_branch_page() {
		WebElement branch = driver.findElement(By.xpath("//span[.='" + CompanyName + "']"));
		wait.until(ExpectedConditions.visibilityOf(branch));
		Assert.assertTrue(branch.isDisplayed());
	}

	// TC_SuperAdmin_212

	@And("^Click on Deactivate button$")
	public void click_on_deactivate_button() {

		WebElement deactivate = driver.findElement(branchPage.getDeactivateButton());
		wait.until(ExpectedConditions.visibilityOf(deactivate));

		CompanyName = "";
		CompanyName = driver.findElement(branchPage.getOneBranchName()).getText();

		deactivate.click();
	}

	@And("^Click on Deactivate button Deactivate confirmation popup$")
	public void click_on_deactivate_button_deactivate_confirmation_popup() {
		driver.findElement(branchPage.getConfirmDeactivate()).click();
	}

	// TC_SuperAdmin_213
	@Then("^Deactivated branch should be removed from the branch page$")
	public void deactivated_branch_should_be_removed_from_the_branch_page() {
		driver.navigate().refresh();
		WebElement ele = driver.findElement(branchPage.getOneBranchName());
		wait.until(ExpectedConditions.visibilityOf(ele));

		try {
			WebElement branch = driver.findElement(By.xpath("//span[.='" + CompanyName + "']"));
			Assert.assertFalse(branch.isDisplayed());
		} catch (Exception e) {
			System.out.println("Branch is removed");
		}

	}

	// TC_SuperAdmin_214
	@And("^click on Update admin button of any one branch$")
	public void click_on_update_admin_button_of_any_one_branch() {
		WebElement ele = driver.findElement(branchPage.getAnyOneUpdateButton());
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
	}

	@And("^Enter mandatory fields in Update admin page$")
	public void enter_mandatory_fields_in_update_admin_page() {
		String firstName = RandomStringUtils.randomAlphabetic(4);
		driver.findElement(branchPage.getFirstName()).sendKeys(firstName);
		driver.findElement(branchPage.getEmail()).sendKeys(firstName + "@ZKT.com");
	}

	// TC_SuperAdmin_215
	@And("^Enter invalid emaild id in Update admin page$")
	public void enter_invalid_emaild_id_in_update_admin_page() {
		String firstName = RandomStringUtils.randomAlphabetic(4);
		driver.findElement(branchPage.getFirstName()).sendKeys(firstName);
		driver.findElement(branchPage.getEmail()).sendKeys(firstName);
	}

	// TC_SuperAdmin_216
	@And("^Enter invalid first name in Update admin page$")
	public void enter_invalid_first_name_in_update_admin_page() {
		driver.findElement(branchPage.getFirstName()).sendKeys("123456");
	}

	// TC_SuperAdmin_217
	@And("^Enter only first name in Update admin page$")
	public void enter_only_first_name_in_update_admin_page() {
		String firstName = RandomStringUtils.randomAlphabetic(4);
		driver.findElement(branchPage.getFirstName()).sendKeys(firstName);
	}

	// TC_SuperAdmin_219
	@Then("^User should be able to create \"([^\"]*)\" request type$")
	public void user_should_be_able_to_create_something_request_type(String strArg1) {
		driver.findElement(settings.getAddButton()).click();

		requestcode = "";

		requestcode = RandomStringUtils.randomAlphabetic(6);
		driver.findElement(settings.getCodeTextField()).sendKeys(requestcode);
		driver.findElement(settings.getNameTextField()).sendKeys(strArg1 + "_" + requestcode);
		driver.findElement(settings.getSubmitButton()).click();

		WebElement ele = driver.findElement(settings.getRequestTypeCreated());
		wait.until(ExpectedConditions.visibilityOf(ele));
		Assert.assertTrue(ele.isDisplayed());

		System.out.println(strArg1 + " " + ele.getText());

		driver.navigate().refresh();

	}

	@Then("^User should not be able to create other than above request types$")
	public void user_should_not_be_able_to_create_other_than_above_request_types() {
		driver.findElement(settings.getAddButton()).click();
		String code = RandomStringUtils.randomAlphabetic(6);
		driver.findElement(settings.getCodeTextField()).sendKeys(code);
		driver.findElement(settings.getNameTextField()).sendKeys("xcvbdfgh");
		driver.findElement(settings.getSubmitButton()).click();

		WebElement ele = driver.findElement(settings.getInvalidRequestType());
		wait.until(ExpectedConditions.visibilityOf(ele));
		Assert.assertTrue(ele.isDisplayed());

		System.out.println(ele.getText());
	}

	/// TC_SuperAdmin_220
	@When("^Click on Edit button$")
	public void click_on_edit_button() {
		WebElement ele = driver.findElement(settings.getAnyOneEditButton());
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
	}

	@And("^Edit code and name$")
	public void edit_code_and_name() {
		driver.findElement(settings.getCodeTextField()).sendKeys("A");
		driver.findElement(settings.getNameTextField()).sendKeys("A");
		requestcode = driver.findElement(settings.getCodeTextField()).getAttribute("value");
		driver.findElement(settings.getSubmitButton()).click();
	}

	@Then("^Updated request type should display in request type list$")
	public void updated_request_type_should_display_in_request_type_list() {
		WebElement updatedRequest = driver.findElement(By.xpath("//span[.='" + requestcode + "']"));
		wait.until(ExpectedConditions.visibilityOf(updatedRequest));

		List<WebElement> codeList = driver.findElements(settings.getCodeList());
		for (WebElement ele : codeList) {
			if (ele.getText().equalsIgnoreCase(requestcode)) {
				System.out.println("Updated request type is displayed in request type list ");
				break;
			} else {
				assert false;
			}
		}
	}

	//
	@Then("^Click on delete button of request type which is not in use$")
	public void click_on_delete_button_of_request_type_which_is_not_in_use() throws InterruptedException {

		driver.findElement(settings.getAnyonedeletebutton()).click();
		driver.findElement(settings.getConfirmDelete()).click();

	}

	// 222
	@Then("^Request type should be deleted$")
	public void request_type_should_be_deleted() {
		try {
			WebElement deletedRequest = driver.findElement(By.xpath("//span[.='" + requestcode + "']"));
			wait.until(ExpectedConditions.visibilityOf(deletedRequest));
			if (deletedRequest.isDisplayed()) {
				assert false;
			}
		} catch (Exception e) {
			System.out.println("Request Type Deleted successfully");
		}
	}

	// 224
	@When("^Create a Approval Workflow$")
	public void create_a_approval_workflow() {
		try {
			driver.findElement(superAdmin.getApprovalWorkflowSubM()).click();

			driver.findElement(settings.getAddButton_Awf()).click();

			driver.findElement(settings.getRequestTypeDropdown()).click();
			WebElement requestTy = driver.findElement(settings.getSelectFirstOption());
			requestTy.click();
			requestType = requestTy.getText();

			String code = RandomStringUtils.randomAlphabetic(4);
			driver.findElement(settings.getCodeTextField()).sendKeys(code);

			String name = RandomStringUtils.randomAlphabetic(4);
			driver.findElement(settings.getNameTextField()).sendKeys(name);

			driver.findElement(settings.getSubmitButton()).click();
		} catch (Exception e) {
			System.out.println("Approval workflow has already been defined for this request type.");
		}

	}

	@Then("^Click on delete button of request type which is mapped to Approval Workflow$")
	public void click_on_delete_button_of_request_type_which_is_mapped_to_approval_workflow() {
		WebElement deleteButtonOfRequestType = driver
				.findElement(By.xpath("//span[.='" + requestType + "']//..//..//div[4]//button[2]"));
		deleteButtonOfRequestType.click();
		driver.findElement(settings.getConfirmDelete()).click();

	}

	// 226
	@And("^Click on Add button in Request Types page$")
	public void click_on_add_button_in_request_types_page() {
		driver.findElement(settings.getAddButton()).click();
	}

	@And("^Click on submit button without entering code in Create Request Type page$")
	public void click_on_submit_button_without_entering_code_in_create_request_type_page() {
		driver.findElement(settings.getSubmitButton()).click();
	}

	// 227
	@And("^Click on submit button without entering name in Create Request Type page$")
	public void click_on_submit_button_without_entering_name_in_create_request_type_page() {
		String code = RandomStringUtils.randomAlphabetic(6);
		driver.findElement(settings.getCodeTextField()).sendKeys(code);
		driver.findElement(settings.getSubmitButton()).click();
	}

	// 228
	@And("^Click on submit button without entering Description in Create Request Type page$")
	public void click_on_submit_button_without_entering_description_in_create_request_type_page() {
		requestcode = "";
		requestcode = RandomStringUtils.randomAlphabetic(6);
		driver.findElement(settings.getCodeTextField()).sendKeys(requestcode);
		driver.findElement(settings.getNameTextField()).sendKeys("HR_" + requestcode);
		driver.findElement(settings.getSubmitButton()).click();
	}

	// 229
	@And("^Click on Add button in Branch configuration page$")
	public void click_on_add_button_in_branch_configuration_page() {
		driver.findElement(settings.getAddButton()).click();
	}

	@And("^Select a branch$")
	public void select_a_branch() {
		driver.findElement(settings.getBranchDropdown()).click();
		driver.findElement(settings.getSelectOneBranch()).click();
	}

	@And("^Select a Request Type$")
	public void select_a_request_type() {
		driver.findElement(settings.getReqTypeDropdown()).click();
		driver.findElement(settings.getSelOnerequestType()).click();
	}

	@And("^Enter Approval criteria in Approval criteria text field$")
	public void enter_approval_criteria_in_approval_criteria_text_field() {
		String ApprovalCriteria = RandomStringUtils.randomAlphabetic(6);
		driver.findElement(settings.getApprovalCriteria()).sendKeys(ApprovalCriteria);
	}

	// Below Lines of Codes From Line no 1547 are Scripted By Sambit on 9-Nov-2022

	// TC_263
	@And("Click on {string} Submodule")
	public void click_on_approval_workflow_submodule(String submodule) throws Throwable {
		settings.selectSubmodule(submodule);
	}

	@And("^I click on the Add icon$")
	public void i_click_on_the_add_icon() throws Throwable {
		
		driver.findElement(settings.getApprovalWorkflowAddIcon()).click();
	}

	@And("^I add Data to all the Fields$")
	public void i_add_data_to_all_the_fields() throws Throwable {
		
		driver.findElement(settings.getCreateApprovalWorkflowCodeTextield()).sendKeys(properties.getProperty("code"));
		driver.findElement(settings.getCreateApprovalWorkflowNameTextield()).sendKeys(properties.getProperty("name"));
		driver.findElement(settings.getCreateApprovalWorkflowRequestTypeDropdown()).click();
		List<WebElement> li = driver.findElements(settings.getCreateApprovalWorkflowrequestTypeDropdownElements());
		
		System.out.println(li.size());
		Thread.sleep(2000);
		li.get(li.size()-1).click();
//		reuse.robotArrowDown(1);
//		reuse.robotEnter();
		approvalWorkflowrequestType = driver.findElement(settings.getCreatApprovalWorkflowRequestTypeText()).getText();
		driver.findElement(settings.getCreateApprovalWorkflowDescriptionTextarea()).click();
	
	}

	@And("^I click on Submit button$")
	public void i_click_on_submit_button() throws Throwable {
		driver.findElement(settings.getApprovalWorkflowSubmitButton()).click();
	}

	@And("^The data should display in the Approval Workflow Dashboard$")
	public void the_data_should_display_in_the_approval_workflow_dashboard() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(settings.getApprovalWorkflowTitle())));
		Thread.sleep(2000);
		reuse.checkTheCodeInApprovalDashboard(properties.getProperty("code"));
	}

	// TC_264

	@And("^I click on the Edit Icon$")
	public void i_click_on_the_edit_icon() throws Throwable {
		
		
	}

	@And("^I edit all data in Edit Approval Workflow Window$")
	public void i_edit_all_data_in_edit_approval_workflow_window() throws Throwable {
		throw new PendingException();
	}

	@And("^The Edited data should display in Approval workflow Dashboard$")
	public void the_edited_data_should_display_in_approval_workflow_dashboard() throws Throwable {
		throw new PendingException();
	}

	// TC_265

	@And("^I Add data to all the Fields of create Request type Page$")
	public void i_add_data_to_all_the_fields_of_create_request_type_page() throws Throwable {
		throw new PendingException();
	}

	@Then("^the Same Request type should be Reflect in the Approval workflow Dashboard$")
	public void the_same_request_type_should_be_reflect_in_the_approval_workflow_dashboard() throws Throwable {
		throw new PendingException();
	}

	// TC_266

//	@And("^I click on the Delete icon$")
//	public void i_click_on_the_delete_icon() throws Throwable {
//		throw new PendingException();
//	}

	@And("^I click on Ok button$")
	public void i_click_on_ok_button() throws Throwable {
		
		
	}

//	@Then("^I should get a Popup Message as \"([^\"]*)\"$")
//	public void i_should_get_a_error_popup_message_as_something(String popupMessage) throws Throwable {
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(settings.getApprovalWorkflowToastMessage())));
//		//System.out.println(driver.findElement(settings.getApprovalWorkflowToastMessage()).getText());
//		reuse.toastMessageValidation(popupMessage);
//	}

	// TC_267
	@And("^The Data should remove from Approval workflow Dashboard$")
	public void the_data_should_remove_from_approval_workflow_dashboard() throws Throwable {
		throw new PendingException();
	}

}
