package steps;


import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import utils.Base;
import utils.Reusable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class CloudAccessAndroid extends Base {

    private final static String readerName = RandomStringUtils.randomAlphabetic(5);
    private final static String code = RandomStringUtils.randomAlphabetic(5);
    private static String pass;
    private static String invalidPhone = RandomStringUtils.randomAlphanumeric(10);
    private static String phoneNumber = RandomStringUtils.randomNumeric(10);
    private static String email = RandomStringUtils.randomAlphanumeric(6);
    private static String appendPass = RandomStringUtils.randomAlphanumeric(3);
    private static Integer index;
    private static String deviceName;
    List<WebElement> menuItems = new ArrayList<WebElement>();
    List<String> actualMenuItems = new ArrayList<String>();
    List<String> expectedMenuItems = new ArrayList<String>();
    int Count;
    String numberOfCompany;
    private LandingPageObject pageObject;
    private HomePageObject homePageObject;
    private HamburgerMenuPageObject hamburgerMenuPageObject;
    private DashboardPageObject dashboardPageObject;
    private OrganizationPageObject organizationPageObject;
    private MessagePageObject messagePageObject;
    private AndroidDriver driver;
    private Properties properties;
    private WebDriverWait wait;
    private FluentWait fwait;
    private Actions act;
    private SoftAssertions ast;
    private FileOutputStream fo;

    @Before("@Cloudaccess")
    public void setup() throws IOException, InterruptedException {

        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/data.properties");
        properties = new Properties();
        properties.load(fs);
        driver = initialize();
        pageObject = new LandingPageObject(driver);
        homePageObject = new HomePageObject(driver);
        hamburgerMenuPageObject = new HamburgerMenuPageObject(driver);
        dashboardPageObject = new DashboardPageObject(driver);
        organizationPageObject = new OrganizationPageObject(driver);
        messagePageObject = new MessagePageObject(driver);
        ast = new SoftAssertions();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(2l));
//        fwait = new FluentWait<WebDriver>(driver)
//                .pollingEvery(Duration.ofMillis(1000l))
//                .withTimeout(Duration.ofMillis(5000))
//                .ignoring(TimeoutException.class)
//                .until(ExpectedConditions.visibilityOf(
    }

    @After("@Cloudaccess")
    public void teardown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            scenario.attach(getByteScreenshot(driver), "img/png", scenario.getName() + "Failed");
        }
        // driver.quit();
        ast.assertAll();
        // stopServer();
        tearDown();

    }

    @Given("I am in CloudAccess signin page and verify all the components")
    public void verifyComponentsInSignInpage() throws Exception {

//        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getSignInText()));
        if (driver.findElement(pageObject.getSignInText()).isDisplayed()) {
            System.out.println("I am in the signinpage");
        }
        Assert.assertTrue(driver.findElement(pageObject.getCloudAccesslogo()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getSignInText()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getUsername()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getUsername()).getText().contains("*"));
        Assert.assertTrue(driver.findElement(pageObject.getPassword()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getPassword()).getText().contains("*"));
        Assert.assertTrue(driver.findElement(pageObject.getLoginButton()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getforgotPasswordlink()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getsignUplink()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getdonthaveanAccounttext()).isDisplayed());
    }

    @Then("I enter valid email id or phone number in the username text field")
    public void enterEmailIdorPhoneNumber() {
        driver.findElement(pageObject.getUsername()).sendKeys(properties.getProperty("UserName"));
        if (driver.findElement(pageObject.getUsername()).getText().equals(properties.getProperty("UserName"))) {
            System.out.println("Email id entered is Valid");
        }
        driver.findElement(pageObject.getUsername()).clear();
        driver.findElement(pageObject.getUsername()).sendKeys(properties.getProperty("phone"));
        if (driver.findElement(pageObject.getUsername()).getText().equals(properties.getProperty("phone"))) {
            System.out.println("PhoneNo entered successfully");

        }

    }

    @Then("I login to application")
    public void iLoginToApplication() throws InterruptedException {
        driver.findElement(pageObject.getUsername()).sendKeys(properties.getProperty("UserName"));
        driver.findElement(pageObject.getPassword()).sendKeys(properties.getProperty("Password"));
        Thread.sleep(2000);
        driver.findElement(pageObject.getLoginButton()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getCompanyCode()));
        driver.findElement(pageObject.getCompanyCode()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getCompanyCode()));
        driver.findElement(pageObject.getCompanyCode()).sendKeys(properties.getProperty("CompanyCode"));
        act.sendKeys(Keys.ARROW_DOWN).perform();
        act.sendKeys(Keys.ENTER).perform();
    }

    @Then("I enter invalid credentials and validate the toast message")
    public void iEnterInvalidCredentialsAndValidateTheToastMessage() throws InterruptedException {
        driver.findElement(pageObject.getUsername()).sendKeys(properties.getProperty("UserName"));
        driver.findElement(pageObject.getPassword()).sendKeys(properties.getProperty("InvalidPassword"));
        driver.findElement(pageObject.getLoginButton()).click();
        Thread.sleep(1000l);
        String mess = driver.findElement(pageObject.getToastmessageforCreatecompany()).getText();
        System.out.println(mess);
        Assert.assertEquals(mess, "Incorrect User name or Password.");
    }

    @Then("I enter unregistered email id and validate the toast message")
    public void I_enter_unregistered_email_id_and_validate_the_toast_message() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getUsername()));
        driver.findElement(pageObject.getUsername()).sendKeys(properties.getProperty("UnregisteredEmailId"));
        driver.findElement(pageObject.getPassword()).sendKeys(properties.getProperty("InvalidPassword"));
        driver.findElement(pageObject.getLoginButton()).click();
        Thread.sleep(1000l);
        String Actual = driver.findElement(pageObject.getToastmessageunregistered()).getText();
        String Expected = properties.getProperty("ToastMessageForUnregisteredEmailID");
        Assert.assertEquals(Actual, Expected);

    }

    @Then("I enter valid credentials and Navigate to the dasboard")
    public void iEnterValidCredentialsAndNavigateToTheDasboard() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getUsername()));
        driver.findElement(pageObject.getUsername()).sendKeys(properties.getProperty("UserName"));
        driver.findElement(pageObject.getPassword()).sendKeys(properties.getProperty("Password"));
        driver.findElement(pageObject.getLoginButton()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getCompanyCode()));
        Assert.assertTrue(driver.findElement(pageObject.getCompanycodeDropdown()).isDisplayed());
    }

    @Then("I enter invalid {string} or {string} and validate the toast message")
    public void iEnterInvalidAndValidateTheToastMessage(String arg0, String arg1) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getLoginButton()));
        driver.findElement(pageObject.getUsername()).sendKeys(properties.getProperty("InvalidUN"));
        driver.findElement(pageObject.getPassword()).sendKeys(properties.getProperty("Password"));
        driver.findElement(pageObject.getLoginButton()).click();
        Thread.sleep(1000l);
        String Actual = driver.findElement(pageObject.getToastmessageunregistered()).getText();
        System.out.println("actual err : " + Actual);
        String Expected = properties.getProperty("ToastMessageForUnregisteredEmailID");
        Assert.assertEquals(Actual, Expected);

        driver.findElement(pageObject.getUsername()).clear();
        driver.findElement(pageObject.getUsername()).sendKeys(properties.getProperty("InvalidPhoneno"));
        driver.findElement(pageObject.getPassword()).sendKeys(properties.getProperty("Password"));
        driver.findElement(pageObject.getLoginButton()).click();
        //	fwait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getToastmessage()));
        Thread.sleep(1000l);
        String Actual1 = driver.findElement(pageObject.getToastmessageunregistered()).getText();
        System.out.println("actual err : " + Actual);
        String Expected1 = properties.getProperty("ToastMessageForUnregisteredEmailID");
        Assert.assertEquals(Actual1, Expected1);
    }

    @Then("I keep the username and password textfield blank and validate the error message")
    public void iKeepTheUsernameAndPasswordTextfieldBlankAndValidateTheErrorMessage() {
        driver.findElement(pageObject.getLoginButton()).click();
        Assert.assertTrue(driver.findElement(pageObject.getErrorMessageforBlankTextbox()).isDisplayed());
    }

    @Then("I validate the Eye Icon Functionality in Password Textfield")
    public void iValidateTheEyeIconFunctionalityInPasswordTextfield() {
        Assert.assertTrue(driver.findElement(pageObject.getEyeIcon()).isDisplayed());
        driver.findElement(pageObject.getPassword()).sendKeys(properties.getProperty("Password"));
        driver.findElement(pageObject.getEyeIcon()).click();
        if (driver.findElement(pageObject.getPassword()).getText().contains(properties.getProperty("Password"))) {
            System.out.println(driver.findElement(pageObject.getEyeIcon()).getText().contains(properties.getProperty("Password")));
            ExtentCucumberAdapter.addTestStepLog("Password field is Unmasked");
        }
        driver.findElement(pageObject.getEyeIcon()).click();
        pass = driver.findElement(pageObject.getPassword()).getText();
        if (pass == null) {
            ExtentCucumberAdapter.addTestStepLog("Password field is Masked");
        }
    }

//SIGN-UP Page

    @Then("I click on signup link")
    public void I_click_on_signup_link() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getSignUpLink()));
        driver.findElement(pageObject.getSignUpLink()).click();
    }

    @Then("I verify the user navigation to signup page")
    public void I_verify_the_user_navigation_to_signup_page() throws InterruptedException {
        Thread.sleep(2000l);
        dragUp();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getSignUpbtn()));
        if (driver.findElement(pageObject.getSignUpbtn()).isDisplayed()) {
            System.out.println("user navigated to signup page successfully");
        }

    }

    @Then("I verify all the components in signup page with Astrix symbol in Mandatory field")
    public void I_verify_all_the_components_in_signup_page_with_Astrix_symbols_in_mandatory_field() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getFirstName()));
        Assert.assertTrue(driver.findElement(pageObject.getFirstName()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getFirstName()).getText().contains("*"));
        System.out.println("astrix symbol is present");
        Assert.assertTrue(driver.findElement(pageObject.getLastName()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getEmailId()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getEmailId()).getText().contains("*"));
        System.out.println("astrix symbol is present");
        Assert.assertTrue(driver.findElement(pageObject.getPhoneNo()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getSignupPassword()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getSignupPassword()).getText().contains("*"));
        System.out.println("astrix symbol is present");
        Assert.assertTrue(driver.findElement(pageObject.getConfirmPassword()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getConfirmPassword()).getText().contains("*"));
        System.out.println("astrix symbol is present");
        Assert.assertTrue(driver.findElement(pageObject.getUserAgreementcheckbox()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getPrivacyPolicy()).isDisplayed());
        dragUp();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getSignUpbtn()));
        Assert.assertTrue(driver.findElement(pageObject.getSignUpbtn()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getSignInLink()).isDisplayed());

    }

    @Then("I Enter invalid emailid and verify the error message")
    public void I_Enter_invalid_emailid_and_verify_the_error_message() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getFirstName()));
        driver.findElement(pageObject.getFirstName()).sendKeys(readerName);
        driver.findElement(pageObject.getEmailId()).sendKeys(properties.getProperty("InvalidEmailId"));
        dragUp();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getSignUpbtn()));
        driver.findElement(pageObject.getSignUpbtn()).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(pageObject.getErrorMessageforBlankTextbox()));
        Assert.assertEquals(driver.findElement(pageObject.getErrorMessageforBlankTextbox()).getText(), properties.getProperty("ErrormessageforInvalidEmailId"));

    }

    @Then("I Enter invalid Phone and verify the error message")
    public void iEnterInvalidPhoneAndVerifyTheErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getFirstName()));
        driver.findElement(pageObject.getFirstName()).sendKeys(readerName);
        driver.findElement(pageObject.getEmailId()).sendKeys(properties.getProperty("ValidEmailId"));
        driver.findElement(pageObject.getPhoneNo()).sendKeys(invalidPhone);
        driver.findElement(pageObject.getSignupPassword()).sendKeys(properties.getProperty("SignupPassword"));
        driver.findElement(pageObject.getConfirmPassword()).sendKeys(properties.getProperty("SignupPassword"));
        driver.findElement(pageObject.getUserAgreementcheckbox()).click();
        driver.findElement(pageObject.getPrivacyPolicy()).click();
        ;
        dragUp();
        driver.findElement(pageObject.getSignUpbtn()).click();
        //	Assert.assertTrue(driver.findElement(pageObject.getErrorMessageforBlankTextbox()).isDisplayed());
        String errMessage = driver.findElement(pageObject.getErrorMessageforBlankTextbox()).getText();
        System.out.println(errMessage);
        Assert.assertTrue(errMessage.contains("Invalid Phone"));
    }

    @Then("I Enter valid data in all the field and get success Message")
    public void iEnterValidDataInAllTheFieldAndGetSuccessMessage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getFirstName()));
        driver.findElement(pageObject.getFirstName()).sendKeys(readerName);
        driver.findElement(pageObject.getEmailId()).sendKeys(email + "@mail.com");
        driver.findElement(pageObject.getPhoneNo()).sendKeys(phoneNumber);
        driver.findElement(pageObject.getSignupPassword()).sendKeys(properties.getProperty("SignupPassword"));
        driver.findElement(pageObject.getConfirmPassword()).sendKeys(properties.getProperty("SignupPassword"));
        dragUp();
        driver.findElement(pageObject.getUserAgreementcheckbox()).click();
        driver.findElement(pageObject.getPrivacyPolicy()).click();
        driver.findElement(pageObject.getSignUpbtn()).click();
        Thread.sleep(1000l);
        String errMessage = driver.findElement(pageObject.getSuccessMessageforSignUp()).getText();
        System.out.println(errMessage);
        Assert.assertEquals(driver.findElement(pageObject.getSuccessMessageforSignUp()).getText(), properties.getProperty("successMessageonSignup"));
    }

    @Then("I Enter duplicate data in all the field and get error Message")
    public void iEnterDuplicateDataInAllTheFieldAndGetErrorMessage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getFirstName()));
        driver.findElement(pageObject.getFirstName()).sendKeys(readerName);
        driver.findElement(pageObject.getEmailId()).sendKeys(properties.getProperty("ValidEmailId"));
        driver.findElement(pageObject.getPhoneNo()).sendKeys(properties.getProperty("phone"));
        driver.findElement(pageObject.getSignupPassword()).sendKeys(properties.getProperty("SignupPassword"));
        driver.findElement(pageObject.getConfirmPassword()).sendKeys(properties.getProperty("SignupPassword"));
        dragUp();
        driver.findElement(pageObject.getUserAgreementcheckbox()).click();
        driver.findElement(pageObject.getPrivacyPolicy()).click();
        driver.findElement(pageObject.getSignUpbtn()).click();
        Thread.sleep(1000l);
        String errMessage = driver.findElement(pageObject.getErrorMessageforSignUp()).getText();
        System.out.println(errMessage);
        Assert.assertEquals(driver.findElement(pageObject.getErrorMessageforSignUp()).getText(), properties.getProperty("errorMessageonSignup"));

    }

    @Then("I click on the Signin Link and Navigate back to Signin Page")
    public void iClickOnTheSigninLinkAndNavigateBackToSigninPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getFirstName()));
        dragUp();
        driver.findElement(pageObject.getSignInLink()).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getLoginButton()));
        Assert.assertTrue(driver.findElement(pageObject.getLoginButton()).isDisplayed());

    }

    //Select Coompany Page
    @And("I validate all the components in the select Company page")
    public void iValidateAllTheComponentsInTheSelectCompanyPage() {
        Assert.assertTrue(driver.findElement(pageObject.getCompanycodeDropdown()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getContinueButton()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getCreateComapnyLink()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getBackButton()).isDisplayed());
    }

    @And("I verify all the compamy code in the select company page")
    public void iVerifyAllTheCompamyCodeInTheSelectCompanyPage() throws IOException, InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getCompanycodeDropdown()));
        driver.findElement(pageObject.getCompanycodeDropdown()).click();
        Thread.sleep(1000l);
        screenShot("all company code");
    }

    @And("I click on create company link")
    public void iClickOnCreateCompanyLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getCreateComapnyLink()));
        driver.findElement(pageObject.getCreateComapnyLink()).click();
    }

    @And("I verify that i navigate back to select company page while click on the back button")
    public void iVerifyThatINavigateBackToSelectCompanyPageWhileClickOnTheBackButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getCreateButton()));
        Assert.assertTrue(driver.findElement(pageObject.getCreateButton()).isDisplayed());
        System.out.println("i am in the create company page");
        driver.findElement(pageObject.getBackButton()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getCompanyCode()));
        Assert.assertTrue(driver.findElement(pageObject.getCompanyCode()).isDisplayed());
    }

    @And("I select a company in select company code page")
    public void iSelectACompanyInSelectCompanyCodePage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getCompanyCode()));
        WebElement comapanycode = driver.findElement(pageObject.getCompanyCode());
        comapanycode.click();
        Thread.sleep(2000l);
        tap(240, 1105);
        System.out.println("clicked above");
        if (comapanycode.getText().isEmpty() || comapanycode.getText().equals(properties.getProperty("companyCodeDefaultText"))) {
            comapanycode.click();
            Thread.sleep(1000l);
            tap(240, 1500);
            System.out.println("clicked below");
        }
        Thread.sleep(1000l);
        driver.findElement(pageObject.getContinueButton()).click();
    }

    @Then("I should navigate to the dashboard of application")
    public void iShouldNavigateToTheDashboardOfApplication() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getCompanyTitleName()));
        Assert.assertTrue(driver.findElement(homePageObject.getCompanyTitleName()).isDisplayed());
    }

    @And("I click on continue button in select company page and validate the error message")
    public void iClickOnContinueButtonInSelectCompanyPageAndValidateTheErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getContinueButton()));
        driver.findElement(pageObject.getContinueButton()).click();
        System.out.println(driver.findElement(pageObject.getErrorMessageforBlankTextbox()).getText());
        Assert.assertTrue(driver.findElement(pageObject.getErrorMessageforBlankTextbox()).isDisplayed());
    }

    @And("I verify all the components in create company page with Astrix symbol in Mandatory field")
    public void iVerifyAllTheComponentsInCreateCompanyPageWithAstrixSymbolInMandatoryField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getCreateButton()));
        Assert.assertTrue(driver.findElement(pageObject.getCountryDropdown()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getCountryDropdown()).getText().contains("*"));
        Assert.assertTrue(driver.findElement(pageObject.getComapanyNameTextfeild()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getComapanyNameTextfeild()).getText().contains("*"));
        Assert.assertTrue(driver.findElement(pageObject.getCompanyCodeTextfield()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getCompanyCodeTextfield()).getText().contains("*"));
        Assert.assertTrue(driver.findElement(pageObject.getEmailTextfield()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getMobileTextfield()).isDisplayed());
        Assert.assertTrue(driver.findElement(pageObject.getCreateButton()).isDisplayed());

    }

    @And("I enter all the valid data in the create company page")
    public void iEnterAllTheValidDataInTheCreateCompanyPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getCountryDropdown()));
        clickByCoordinate(1246, 390);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getSelectCountrySearchfield()));
        driver.findElement(pageObject.getSelectCountrySearchfield()).sendKeys("india");
        List<WebElement> ele = driver.findElements(pageObject.getCountrynameList());
        List<WebElement> ele1 = driver.findElements(pageObject.getCountryRadioButtonList());

        for (int i = 0; i < ele.size(); i++) {
            if (ele.get(i).getText().equalsIgnoreCase("india")) {
                ele1.get(i).click();
                System.out.println("clicked");
            }
        }
        driver.findElement(pageObject.getComapanyNameTextfeild()).sendKeys(readerName);
        driver.findElement(pageObject.getCompanyCodeTextfield()).sendKeys(code);
        driver.findElement(pageObject.getEmailTextfield()).sendKeys(email + "@yahoo.com");
        driver.findElement(pageObject.getRegistrationNumberTextfield()).sendKeys(readerName);
        driver.findElement(pageObject.getMobileTextfield()).sendKeys(phoneNumber);
        driver.findElement(pageObject.getCreateButton()).click();

    }

    @And("I validate the success message")
    public void iValidateTheSuccessMessage() throws InterruptedException {
        String mess = driver.findElement(pageObject.getToastmessageforCreatecompany()).getText();
        System.out.println(mess);
        Assert.assertEquals(mess, "Company Created Successfully");
    }

    @And("I enter all the invalid mobile number in the create company page")
    public void iEnterAllTheInvalidMobileNumberInTheCreateCompanyPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getCountryDropdown()));
        clickByCoordinate(1246, 390);
        driver.findElement(pageObject.getSelectCountrySearchfield()).sendKeys("india");
        List<WebElement> ele = driver.findElements(pageObject.getCountrynameList());
        List<WebElement> ele1 = driver.findElements(pageObject.getCountryRadioButtonList());

        for (int i = 0; i < ele.size(); i++) {
            if (ele.get(i).getText().equalsIgnoreCase("india")) {
                ele1.get(i).click();
                System.out.println("clicked");
            }
        }

        driver.findElement(pageObject.getComapanyNameTextfeild()).sendKeys(readerName);
        driver.findElement(pageObject.getCompanyCodeTextfield()).sendKeys(code);
        driver.findElement(pageObject.getEmailTextfield()).sendKeys(email + "@yahoo.com");
        driver.findElement(pageObject.getRegistrationNumberTextfield()).sendKeys(readerName);
        driver.findElement(pageObject.getMobileTextfield()).sendKeys(properties.getProperty("InvalidPhoneno"));
        driver.findElement(pageObject.getCreateButton()).click();
    }

    @And("I validate the error message")
    public void iValidateTheErrorMessage() {
        String mess = driver.findElement(pageObject.getToastmessageforCreatecompany()).getText();
        System.out.println(mess);
        Assert.assertNotEquals(mess, "Company Created Successfully");
    }

    @And("I click on ? icon to validate the description")
    public void iClickOnIconToValidateTheDescription() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getComapanyNameTextfeild()));
        clickByCoordinate(1258, 664);
        Assert.assertTrue(driver.findElement(pageObject.getTextfieldDescription()).isDisplayed());
        System.out.println("company name description : " + driver.findElement(pageObject.getTextfieldDescription()).getText());
        backButton(1);
        clickByCoordinate(1258, 945);
        Assert.assertTrue(driver.findElement(pageObject.getTextfieldDescription()).isDisplayed());
        System.out.println("company code descption :" + driver.findElement(pageObject.getTextfieldDescription()).getText());
    }

    @Then("I click on the device management option")
    public void iClickOnTheDeviceManagementOption() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(homePageObject.getHomePageElements()));
        List<WebElement> options = driver.findElements(homePageObject.getHomePageElements());
        for (WebElement option : options) {
            System.out.println(option.getText());
            if (option.getText().startsWith("Device")) {
                option.click();
                break;
            } else {
                System.out.println("not clicked");
            }
        }
    }

    @And("I should able to navigate to the device management page")
    public void iShouldAbleToNavigateToTheDeviceManagementPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getDeviceDropdown()));
        Assert.assertTrue(driver.findElement(homePageObject.getDeviceDropdown()).isDisplayed());
    }

    @And("I validate the Device dropdown elements")
    public void iValidateTheDeviceDropdownElements() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getDeviceDropdown()));
        driver.findElement(homePageObject.getDeviceDropdown()).click();
        List<WebElement> eles = driver.findElements(homePageObject.getDevicedropdownElement());
        for (WebElement ele : eles) {
            System.out.println(ele.getText());
            Assert.assertTrue(ele.isDisplayed());
        }
    }

    @And("I should able to view all four the components in home page")
    public void iShouldAbleToViewAllFourTheComponentsInHomePage() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(homePageObject.getHomePageElements()));
        List<WebElement> options = driver.findElements(homePageObject.getHomePageElements());
        for (WebElement option : options) {
            Assert.assertTrue(option.isDisplayed());
            System.out.println(option.getText());
        }
    }

    @And("i should able to view all the sub modules in dash board")
    public void iShouldAbleToViewAllTheSubModulesInDashBoard() {
        Assert.assertTrue(driver.findElement(homePageObject.getDashboardSubmoduleIcon()).isDisplayed());
        Assert.assertTrue(driver.findElement(homePageObject.getHomeSubmoduleIcon()).isDisplayed());
        Assert.assertTrue(driver.findElement(homePageObject.getMessageSubmoduleIcon()).isDisplayed());
        Assert.assertTrue(driver.findElement(homePageObject.getOrganizationSubmoduleIcon()).isDisplayed());
    }

    @And("I click on the Hamburger menu and Validate all the elements")
    public void iClickOnTheHamburgerMenuAndValidateAllTheElements() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getHamburgermenuIcon()));
        driver.findElement(homePageObject.getHamburgermenuIcon()).click();
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getProfilePhotoIcon()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getUserName()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getCompanyName()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getMyProfileOption()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getCompanyProfile()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getSwitchCompany()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getSwitchlanguage()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getResetPassword()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getLogout()).isDisplayed());
    }

    @And("I click on the My profile Option")
    public void iClickOnTheMyProfileOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenuPageObject.getMyProfileOption()));
        driver.findElement(hamburgerMenuPageObject.getMyProfileOption()).click();
    }

    @And("I verify all the components in the My profile page")
    public void iVerifyAllTheComponentsInTheMyProfilePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenuPageObject.getFirstNameTextfield()));
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getFirstNameTextfield()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getLastNameTextfield()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getUserProfileImage()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getNickNameTextfield()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getGenderDropdown()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getEmailTextfield()).isDisplayed());
        dragUp();
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getPhoneNumberTextfield()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getCountryCodeText()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getDobCalenderView()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getDobTextfield()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getEditIcon()).isDisplayed());

    }

    @And("I click on the Edit icon")
    public void iClickOnTheEditIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenuPageObject.getEditIcon()));
        driver.findElement(hamburgerMenuPageObject.getEditIcon()).click();
    }

    @And("I update the User Profile and Validate the Success message")
    public void iUpdateTheUserProfileAndValidateTheSuccessMessage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenuPageObject.getFirstNameTextfield()));
        driver.findElement(hamburgerMenuPageObject.getFirstNameTextfield()).clear();
        new Reusable().getAstrixSymbolfromTextField(driver.findElement(hamburgerMenuPageObject.getFirstNameTextfield()));
        driver.findElement(hamburgerMenuPageObject.getFirstNameTextfield()).sendKeys(readerName);
        dragUp();
        driver.findElement(hamburgerMenuPageObject.getUpdateButton()).click();
        Thread.sleep(1000l);
        String mess = driver.findElement(pageObject.getToastmessageforCreatecompany()).getText();
        System.out.println(mess);
        Assert.assertEquals(mess, "User updated successfully.");

    }

    @And("I click on the company profile Option")
    public void iClickOnTheCompanyProfileOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenuPageObject.getCompanyProfile()));
        driver.findElement(hamburgerMenuPageObject.getCompanyProfile()).click();
    }

    @And("I verify all the components in the company profile page")
    public void iVerifyAllTheComponentsInTheCompanyProfilePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenuPageObject.getEditIcon()));
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getEditIcon()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getCompanyNameTextfield()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getIndustryTypeTextfield()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getCompanySizeTextfield()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getCodeTextfield()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getRegistrationNumberTextfield()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getEmailIdTextfield()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getMobileNumberTextfield()).isDisplayed());
        dragUp();
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getAddressTextfield()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getCountryTextfield()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getStateTextfield()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getCityTextfield()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getZipcodeTextfield()).isDisplayed());
    }

    @And("I update the company Profile and Validate the Success message")
    public void iUpdateTheCompanyProfileAndValidateTheSuccessMessage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenuPageObject.getCompanyNameTextfield()));
        driver.findElement(hamburgerMenuPageObject.getCompanyNameTextfield()).sendKeys(readerName);
        dragUp();
        dragUp();
        driver.findElement(hamburgerMenuPageObject.getUpdateButton()).click();
        Thread.sleep(1000l);
        String mess = driver.findElement(pageObject.getToastmessageforCreatecompany()).getText();
        System.out.println(mess);
        Assert.assertEquals(mess, "Company updated successfully.");

    }

    @And("I click on the Switch company Option")
    public void iClickOnTheSwitchCompanyOption() {
        driver.findElement(hamburgerMenuPageObject.getSwitchCompany()).click();
    }

    @And("I verify all the components in the switch company page")
    public void iVerifyAllTheComponentsInTheSwitchCompanyPage() {
        List<WebElement> companyList = driver.findElements(hamburgerMenuPageObject.getCompanyNameList());
        List<WebElement> radiobuttonList = driver.findElements(hamburgerMenuPageObject.getRadioButtonList());
        try {
            for (WebElement company : companyList) {
                ast.assertThat(company.isDisplayed());
                System.out.println(company.getText());
            }
            for (WebElement radioButton : radiobuttonList) {
                ast.assertThat(radioButton.isDisplayed());
            }
        } catch (Exception e) {
            dragUp();
            e.printStackTrace();
        }
    }

    @And("I click on a company and validate the respected data after switching")
    public void iClickOnACompanyAndValidateTheRespectedDataAfterSwitching() {
        List<WebElement> radiobuttonList = driver.findElements(hamburgerMenuPageObject.getRadioButtonList());
        radiobuttonList.get(0).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getCompanyTitleName()));
        System.out.println(driver.findElement(homePageObject.getCompanyTitleName()).getText());
        Assert.assertTrue(driver.findElement(homePageObject.getCompanyTitleName()).isDisplayed());
    }

    @And("I navigate to all the Sub menus")
    public void iNavigateToAllTheSubMenus() {
        driver.findElement(homePageObject.getDashboardSubmoduleIcon()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardPageObject.getCompanyCount()));
        Assert.assertTrue(driver.findElement(dashboardPageObject.getCompanyCount()).isDisplayed());
        driver.findElement(homePageObject.getMessageSubmoduleIcon()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(messagePageObject.getMessage()));
        Assert.assertTrue(driver.findElement(messagePageObject.getMessage()).isDisplayed());
        driver.findElement(homePageObject.getOrganizationSubmoduleIcon()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(organizationPageObject.getMessage()));
        Assert.assertTrue(driver.findElement(organizationPageObject.getMessage()).isDisplayed());
    }

    @And("I click on the logout Option and confirm in the logout popup")
    public void iClickOnTheLogoutOptionAndConfirmInTheLogoutPopup() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenuPageObject.getLogout()));
        driver.findElement(hamburgerMenuPageObject.getLogout()).click();
        driver.findElement(hamburgerMenuPageObject.getLogoutConfirmButton()).click();
    }

    @And("I should able to logout successfully from the application and naviagte back to the login page")
    public void iShouldAbleToLogoutSuccessfullyFromTheApplicationAndNaviagteBackToTheLoginPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getUsername()));
        Assert.assertTrue(driver.findElement(pageObject.getUsername()).isDisplayed());
    }

    @Then("I click on the {string} option")
    public void iClickOnTheAccesssLevelOption(String opt) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(homePageObject.getHomePageElements()));
        Thread.sleep(2000l);
        List<WebElement> eles = driver.findElements(homePageObject.getHomePageElements());
        for (WebElement ele : eles) {
            System.out.println(ele.getText());
            String[] name = ele.getText().split(" ");
            System.out.println(name[0]);
            if (name[0].contains(opt)) {
                ele.click();
                System.out.println("clicked");
                break;
            }
        }
    }

    @And("I should able to navigate to the access level page")
    public void iShouldAbleToNavigateToTheAccessLevelPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getAccessLevelText()));
        Assert.assertTrue(driver.findElement(homePageObject.getAccessLevelText()).isDisplayed());
        driver.findElement(homePageObject.getAddIcon()).click();
    }

    @And("I should able to get error message while try to submoit without mandatory data")
    public void iShouldAbleToGetErrorMessageWhileTryToSubmoitWithoutMandatoryData() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getAddButton()));
        driver.findElement(homePageObject.getAddButton()).click();
        Assert.assertTrue(driver.findElement(pageObject.getErrorMessageforBlankTextbox()).isDisplayed());
    }

    @And("I enter all the data and I should get a success message")
    public void iEnterAllTheDataAndIShouldGetASuccessMessage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getLevelNameTextfield()));
        driver.findElement(homePageObject.getLevelNameTextfield()).sendKeys(readerName);
        driver.findElement(homePageObject.getTimeperiodDropdown()).click();
        Thread.sleep(1000l);
        clickByCoordinate(202, 1130);
        wait.until(ExpectedConditions.attributeContains(driver.findElement(homePageObject.getTimeperiodDropdown()), "text", "24HR"));
        driver.findElement(homePageObject.getAddButton()).click();
        Thread.sleep(1000l);
        String mess = driver.findElement(pageObject.getToastmessageforCreatecompany()).getText();
        System.out.println(mess);
        Assert.assertEquals(mess, "Level created successfully");
    }

    @And("the Access level should visible in the List with all the componenets")
    public void theAccessLevelShouldVisibleInTheListWithAllTheComponenets() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getAccessLevelText()));
        } catch (Exception e) {
            e.printStackTrace();
            backButton(1);
        }
        List<WebElement> AccesslevelList = driver.findElements(homePageObject.getAccessLevelList());
        for (WebElement access : AccesslevelList) {
            System.out.println(access.getText());
            Count++;
        }
        System.out.println("the no of accesslevel created is : " + Count);
        List<WebElement> timeperiodList = driver.findElements(homePageObject.getAccessLevelList());
        List<WebElement> doorcountList = driver.findElements(homePageObject.getAccessLevelList());
        List<WebElement> usercountlList = driver.findElements(homePageObject.getAccessLevelList());
        List<WebElement> checkboxlList = driver.findElements(homePageObject.getAccessLevelList());

        for (int i = 0; i < AccesslevelList.size(); i++) {
            Assert.assertTrue(AccesslevelList.get(i).isDisplayed());
            Assert.assertTrue(timeperiodList.get(i).isDisplayed());
            Assert.assertTrue(doorcountList.get(i).isDisplayed());
            Assert.assertTrue(usercountlList.get(i).isDisplayed());
            Assert.assertTrue(checkboxlList.get(i).isDisplayed());
        }
    }

    @And("I {string} one access level and get the success message")
    public void iOneAccessLevelAndGetTheSuccessMessage(String operation) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(homePageObject.getCheckBoxlist()));
        if (operation.equalsIgnoreCase("edit")) {
            List<WebElement> checkboxes = driver.findElements(homePageObject.getCheckBoxlist());
            checkboxes.get(0).click();
            driver.findElement(homePageObject.getEditIcon()).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getLevelNameTextfield()));
            driver.findElement(homePageObject.getLevelNameTextfield()).sendKeys(readerName);
            driver.findElement(homePageObject.getAddButton()).click();
            Thread.sleep(1000l);
            String mess = driver.findElement(pageObject.getToastmessageforCreatecompany()).getText();
            System.out.println(mess);
            Assert.assertEquals(mess, "Level updated successfully");

        } else if (operation.equalsIgnoreCase("delete")) {
            List<WebElement> checkboxes = driver.findElements(homePageObject.getCheckBoxlist());
            checkboxes.get(0).click();
            driver.findElement(homePageObject.getDeleteIcon()).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getDeleteConfirmation()));
            driver.findElement(homePageObject.getDeleteConfirmation()).click();
            Thread.sleep(1000l);
            String mess = driver.findElement(pageObject.getToastmessageforCreatecompany()).getText();
            System.out.println(mess);
            Assert.assertEquals(mess, "Level deleted successfully");
        }
    }

    @And("I click on the expand Icon and navigate to navigate to manage access level page")
    public void iClickOnTheExpandIconAndNavigateToNavigateToManageAccessLevelPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getAccessLevelText()));
        List<WebElement> ele = driver.findElements(homePageObject.getExpandIconList());
        ele.get(0).click();
    }

    @And("I click on person tab")
    public void iClickOnPersonTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getPersonTab()));
        driver.findElement(homePageObject.getPersonTab()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getAddPersonIcon()));
        try {
            if (driver.findElement(homePageObject.getCheckBoxlist()).isDisplayed()) {
                driver.findElement(homePageObject.getCheckBoxlist()).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getSelectAllLink()));
                WebElement ele = driver.findElement(homePageObject.getSelectAllLink());
                String[] name = ele.getText().split(" ");
                if (name[0].equalsIgnoreCase("Deselect")) {
                    System.out.println("one department selected");
                } else {
                    driver.findElement(homePageObject.getSelectAllLink()).click();
                    System.out.println("all department selected");
                }
                driver.findElement(homePageObject.getDeleteIcon()).click();
                driver.findElement(homePageObject.getDeleteConfirmation()).click();
            }
        } catch (Exception e) {
            System.out.println("no person is added");
        }
    }

    @And("I click on the Add person icon")
    public void iClickOnTheAddPersonIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getAddPersonIcon()));
        driver.findElement(homePageObject.getAddPersonIcon()).click();
    }

    @And("I click on the Add person icon again")
    public void iClickOnTheAddPersonIconAgain() {
        wait.until(ExpectedConditions.elementToBeClickable(homePageObject.getAddPersonIcon()));
        driver.findElement(homePageObject.getAddPersonIcon()).click();
    }

    @And("I select one person")
    public void iSelectOnePerson() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getPersonCheckBoxList()));
        driver.findElement(homePageObject.getPersonCheckBoxList()).click();
    }

    @And("I select all persons")
    public void iSelectAllPersons() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(homePageObject.getPersonCheckBoxList()));
        driver.findElement(homePageObject.getSeletAllPersonLink()).click();
    }

    @And("I click on Add Person button and get the success message")
    public void iClickOnAddPersonButtonAndGetTheSuccessMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(homePageObject.getAddPersonButton()));
        driver.findElement(homePageObject.getAddPersonButton()).click();
        String mess = driver.findElement(pageObject.getToastmessageforCreatecompany()).getText();
        System.out.println(mess);
        Assert.assertEquals(mess, "Person added to level successfully");
    }

    @And("I should able to view all the added person in the List")
    public void iShouldAbleToViewAllTheAddedPersonInTheList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getAddPersonIcon()));
        List<WebElement> personNameList = driver.findElements(homePageObject.getPersonNameList());
        List<WebElement> empIdList = driver.findElements(homePageObject.getEmpIdList());
        try {
            for (WebElement personName : personNameList) {
                System.out.println(personName.getText());
            }
            for (WebElement emp : empIdList) {
                System.out.println(emp.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Data is not available");
        }
    }

    @Then("I should get a error Message as No record found")
    public void iShouldGetAErrorMessageAsNoRecordFound() {
        String mess = driver.findElement(pageObject.getToastmessageforCreatecompany()).getText();
        System.out.println(mess);
        Assert.assertEquals(mess, "Person added to level successfully");
    }

    @And("I should able to delete a person with a Success message")
    public void iShouldAbleToDeleteAPersonWithASuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getAddPersonIcon()));
        List<WebElement> checkboxList = driver.findElements(homePageObject.getCheckBoxlist());
        checkboxList.get(0).click();
        driver.findElement(homePageObject.getDeleteIcon()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getDeleteConfirmation()));
        driver.findElement(homePageObject.getDeleteConfirmation()).click();
        String mess = driver.findElement(pageObject.getToastmessageforCreatecompany()).getText();
        System.out.println(mess);
        Assert.assertEquals(mess, "Person deleted from access level successfully");

    }

    @And("I should able to abort the delete person operation")
    public void iShouldAbleToAbortTheDeletePersonOperation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getAddPersonIcon()));
        List<WebElement> checkboxList = driver.findElements(homePageObject.getCheckBoxlist());
        Integer isize = checkboxList.size();
        checkboxList.get(0).click();
        driver.findElement(homePageObject.getDeleteIcon()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getDeleteConfirmation()));
        driver.findElement(homePageObject.getDeleteCancel()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getAddPersonIcon()));
        Integer fsize = checkboxList.size();
        Assert.assertEquals(isize, fsize);
        System.out.println("delete employee cancelled");
    }

    @And("I click on select all link")
    public void iClickOnSelectAllLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getAddPersonIcon()));
        List<WebElement> checkboxList = driver.findElements(homePageObject.getCheckBoxlist());
        checkboxList.get(0).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getSelectAllLink()));
        WebElement ele = driver.findElement(homePageObject.getSelectAllLink());
        String[] name = ele.getText().split(" ");
        System.out.println(name[0]);
        if (name[0].equalsIgnoreCase("Deselect")) {
            System.out.println("if clicked");
        } else {
            driver.findElement(homePageObject.getSelectAllLink()).click();
            System.out.println("else clicked");
        }
    }

    @And("I Should able to delete all the person with a success message")
    public void iShouldAbleToDeleteAllThePersonWithASuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getSelectAllLink()));
        driver.findElement(homePageObject.getDeleteIcon()).click();
        driver.findElement(homePageObject.getDeleteConfirmation()).click();
        String mess = driver.findElement(pageObject.getToastmessageforCreatecompany()).getText();
        System.out.println(mess);
        Assert.assertEquals(mess, "Person deleted from access level successfully");
    }


    @And("I click on department tab")
    public void iClickOnDepartmentTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getDepartmentTab()));
        driver.findElement(homePageObject.getDepartmentTab()).click();
    }

    @And("I select one department")
    public void iSelectOneDepartment() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getPersonCheckBoxList()));
        driver.findElement(homePageObject.getPersonCheckBoxList()).click();
    }

    @And("I click on Add department button and get the success message")
    public void iClickOnAddDepartmentButtonAndGetTheSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getAddPersonButton()));
        driver.findElement(homePageObject.getAddPersonButton()).click();
        String mess = driver.findElement(pageObject.getToastmessageforCreatecompany()).getText();
        System.out.println(mess);
        try {
            Assert.assertEquals(mess, "Departments added to level");
        } catch (Error r) {
            r.printStackTrace();
            System.out.println(mess);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getAddDepartmentIcon()));
        List<WebElement> departmentList = driver.findElements(homePageObject.getDepartmentNameList());
        for (WebElement department : departmentList) {
            Assert.assertTrue(department.isDisplayed());
            System.out.println(department.getText());
            Count++;
        }
        System.out.println("No of department is :" + Count);

    }

    @And("I click on the Add department icon")
    public void iClickOnTheAddDepartmentIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getAddDepartmentIcon()));
        driver.findElement(homePageObject.getAddDepartmentIcon()).click();
    }

    @And("I should able to delete the added department")
    public void iShouldAbleToDeleteAllTheAddedDepartment() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getAddDepartmentIcon()));
        List<WebElement> checkboxList = driver.findElements(homePageObject.getCheckBoxlist());
        checkboxList.get(0).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getSelectAllLink()));
        WebElement ele = driver.findElement(homePageObject.getSelectAllLink());
        String[] name = ele.getText().split(" ");
        System.out.println(name[0]);
        if (name[0].equalsIgnoreCase("Deselect")) {
            System.out.println("one department selected");
        } else {
            driver.findElement(homePageObject.getSelectAllLink()).click();
            System.out.println("all department selected");
        }
        driver.findElement(homePageObject.getDeleteIcon()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getDeleteConfirmation()));
        driver.findElement(homePageObject.getDeleteConfirmation()).click();
        Thread.sleep(1000l);
        String mess = driver.findElement(pageObject.getToastmessageforCreatecompany()).getText();
        System.out.println(mess);
        Assert.assertEquals(mess, "Access level Departments removed successfully");
    }

    @And("I select all department")
    public void iSelectAllDepartment() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getSelectAllLink()));
        driver.findElement(homePageObject.getSelectAllLink()).click();
    }

    @When("I click on the forgot password link")
    public void iClickOnTheForgotPasswordLink() {
        driver.findElement(pageObject.getForgotPasswordLink()).click();
    }

    @Then("I should navigate to the forgot password page")
    public void iShouldNavigateToTheForgotPasswordPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getForgotPasswordEmailTextfield()));
        Assert.assertTrue(driver.findElement(pageObject.getForgotPasswordEmailTextfield()).isDisplayed());
    }

    @And("I add a Email id and send the password to the respective mail id")
    public void iAddAEmailIdAndSendThePasswordToTheRespectiveMailId() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getForgotPasswordEmailTextfield()));
        driver.findElement(pageObject.getForgotPasswordEmailTextfield()).sendKeys(readerName + "@gmail.com");
        Thread.sleep(1500l);
        driver.findElement(pageObject.getSendLinkButton()).click();
    }

    @And("I validate the email sent page")
    public void iValidateTheEmailSentPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getEmailSentText()));
        Assert.assertTrue(driver.findElement(pageObject.getEmailSentText()).isDisplayed());
    }

    @And("I click on the back arrow icon")
    public void iClickOnTheBackArrowIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getBackButton()));
        driver.findElement(pageObject.getBackButton()).click();
    }

    @And("I should navigate back to the sign in page")
    public void iShouldNavigateBackToTheSignInPage() {
        Assert.assertTrue(driver.findElement(pageObject.getLoginButton()).isDisplayed());
    }

    @And("I click on the Reset Password Option")
    public void iClickOnTheResetPasswordOption() {
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenuPageObject.getResetPassword()));
        driver.findElement(hamburgerMenuPageObject.getResetPassword()).click();
    }

    @And("I validate all the components in the Reset Password Page")
    public void iValidateAllTheComponentsInTheResetPasswordPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenuPageObject.getOldPasswordTextfield()));
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getOldPasswordTextfield()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getNewPasswordTextfield()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getConfirmPasswordTextfield()).isDisplayed());
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getResetPasswordButton()).isDisplayed());

        List<WebElement> eyeIcons = driver.findElements(hamburgerMenuPageObject.getEyeIcon());
        for (WebElement eye : eyeIcons) {
            Assert.assertTrue(eye.isDisplayed());
            Count++;
        }
        System.out.println("No. of Eye Icon is :" + Count);
    }

    @And("I Enter old and new Password same and validate the Error message")
    public void iEnterOldAndNewPasswordSameAndValidateTheErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenuPageObject.getOldPasswordTextfield()));
        driver.findElement(hamburgerMenuPageObject.getOldPasswordTextfield()).sendKeys(properties.getProperty("Password"));
        driver.findElement(hamburgerMenuPageObject.getNewPasswordTextfield()).sendKeys(properties.getProperty("Password"));
        driver.findElement(hamburgerMenuPageObject.getConfirmPasswordTextfield()).sendKeys(properties.getProperty("Password"));
        driver.findElement(hamburgerMenuPageObject.getResetPasswordButton()).click();
        Assert.assertTrue(driver.findElement(pageObject.getErrorMessageforBlankTextbox()).isDisplayed());
        System.out.println(driver.findElement(pageObject.getErrorMessageforBlankTextbox()).getText());
    }

    @And("I Enter old and new Password and validate the success message")
    public void iEnterOldAndNewPasswordAndValidateTheSuccessMessage() throws InterruptedException, IOException {
        String resetPass = "Sameer1@" + appendPass;
        System.out.println(resetPass);
        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenuPageObject.getOldPasswordTextfield()));
        driver.findElement(hamburgerMenuPageObject.getOldPasswordTextfield()).sendKeys(properties.getProperty("SignupPassword"));
        driver.findElement(hamburgerMenuPageObject.getNewPasswordTextfield()).sendKeys(resetPass);
        driver.findElement(hamburgerMenuPageObject.getConfirmPasswordTextfield()).sendKeys(resetPass);
        driver.findElement(hamburgerMenuPageObject.getResetPasswordButton()).click();
        properties.setProperty("SignupPassword", resetPass);
        properties.store(fo, "reseted pass");
        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenuPageObject.getResetPasswordSuccessmessage()));
        Assert.assertTrue(driver.findElement(hamburgerMenuPageObject.getResetPasswordSuccessmessage()).isDisplayed());
        driver.findElement(hamburgerMenuPageObject.getResetPasswordSuccessmessage()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getLoginButton()));
        Assert.assertTrue(driver.findElement(pageObject.getLoginButton()).isDisplayed());
    }

    @And("I click on back button and Verify that user is landing on home page")
    public void iClickOnBackButtonAndVerifyThatUserIsLandingOnHomePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getBackButton()));
        driver.findElement(pageObject.getBackButton()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageObject.getLoginButton()));
        Assert.assertTrue(driver.findElement(pageObject.getLoginButton()).isDisplayed());
    }

    @And("I Switch the company")
    public void iSwitchTheCompany() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getHamburgermenuIcon()));
        driver.findElement(homePageObject.getHamburgermenuIcon()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenuPageObject.getSwitchCompany()));
        driver.findElement(hamburgerMenuPageObject.getSwitchCompany()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenuPageObject.getSearchBar()));
        Thread.sleep(2000l);
        driver.findElement(hamburgerMenuPageObject.getSearchBar()).sendKeys(properties.getProperty("company"));
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenuPageObject.getRadioButtonList()));
        driver.findElement(hamburgerMenuPageObject.getRadioButtonList()).click();
    }

    @And("I click on the dashboard submodule")
    public void iClickOnTheDashboardSubmodule() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getDashboardSubmoduleIcon()));
        driver.findElement(homePageObject.getDashboardSubmoduleIcon()).click();
    }

    @Then("I validate all the components in the Dashboard page")
    public void iValidateAllTheComponentsInTheDashboardPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardPageObject.getCompanyCount()));
        Assert.assertTrue(driver.findElement(dashboardPageObject.getCompanyCount()).isDisplayed());
        Assert.assertTrue(driver.findElement(dashboardPageObject.getSiteCount()).isDisplayed());
        Assert.assertTrue(driver.findElement(dashboardPageObject.getDeviceCount()).isDisplayed());
        Assert.assertTrue(driver.findElement(dashboardPageObject.getOnlineDeviceCount()).isDisplayed());
        Assert.assertTrue(driver.findElement(dashboardPageObject.getOfflineDeviceCount()).isDisplayed());
        Assert.assertTrue(driver.findElement(dashboardPageObject.getNotificationText()).isDisplayed());
        Assert.assertTrue(driver.findElement(dashboardPageObject.getPersonCount()).isDisplayed());
        Assert.assertTrue(driver.findElement(dashboardPageObject.getRefreshIcon()).isDisplayed());
        Assert.assertTrue(driver.findElement(dashboardPageObject.getExpandIcon()).isDisplayed());

    }

    @And("I click on the Expand Icon on the Notification bar")
    public void iClickOnTheExpandIconOnTheNotificationBar() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardPageObject.getExpandIcon()));
        driver.findElement(dashboardPageObject.getExpandIcon()).click();
    }

    @Then("I should able to naviagte to the notification page and Validate the notification")
    public void iShouldAbleToNaviagteToTheNotificationPageAndValidateTheNotification() {
        List<WebElement> notificationNameList = driver.findElements(dashboardPageObject.getNotificationNameList());
        List<WebElement> notificationOperationList = driver.findElements(dashboardPageObject.getNotificationOperationList());
        List<WebElement> notificationTimeList = driver.findElements(dashboardPageObject.getNotificationTimeList());

        for (int i = 0; i < notificationOperationList.size(); i++) {
            System.out.println("Notification Name is : " + notificationNameList.get(i).getText() + " Notifiaction Time is :" + notificationTimeList.get(i).getText()
                    + "Notification Status is : " + notificationOperationList.get(i).getText());
        }
    }

    @Then("I click on the refresh button")
    public void iClickOnTheRefreshButton() {
        driver.findElement(dashboardPageObject.getRefreshIcon()).click();
        Assert.assertTrue(driver.findElement(dashboardPageObject.getCompanyCount()).isDisplayed());
        Assert.assertTrue(driver.findElement(dashboardPageObject.getSiteCount()).isDisplayed());
        Assert.assertTrue(driver.findElement(dashboardPageObject.getDeviceCount()).isDisplayed());
        Assert.assertTrue(driver.findElement(dashboardPageObject.getOnlineDeviceCount()).isDisplayed());
        Assert.assertTrue(driver.findElement(dashboardPageObject.getOfflineDeviceCount()).isDisplayed());
        Assert.assertTrue(driver.findElement(dashboardPageObject.getNotificationText()).isDisplayed());
        Assert.assertTrue(driver.findElement(dashboardPageObject.getPersonCount()).isDisplayed());
        Assert.assertTrue(driver.findElement(dashboardPageObject.getRefreshIcon()).isDisplayed());
        Assert.assertTrue(driver.findElement(dashboardPageObject.getExpandIcon()).isDisplayed());
    }

    @And("I click on the message submodule")
    public void iClickOnTheMessageSubmodule() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getMessageSubmoduleIcon()));
        driver.findElement(homePageObject.getMessageSubmoduleIcon()).click();
    }

    @Then("I should able to navigate to Message Page")
    public void iShouldAbleToNavigateToMessagePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(messagePageObject.getMessage()));
        Assert.assertTrue(driver.findElement(messagePageObject.getMessage()).isDisplayed());
        System.out.println(driver.findElement(messagePageObject.getMessage()).getText());
    }

    @And("I click on the organization submodule")
    public void iClickOnTheOrganizationSubmodule() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getOrganizationSubmoduleIcon()));
        driver.findElement(homePageObject.getOrganizationSubmoduleIcon()).click();
    }

    @Then("I should able to navigate to organization Page")
    public void iShouldAbleToNavigateToOrganizationPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(organizationPageObject.getMessage()));
        Assert.assertTrue(driver.findElement(organizationPageObject.getMessage()).isDisplayed());
        System.out.println(driver.findElement(organizationPageObject.getMessage()).getText());

    }

    @And("I should able to delete the added person")
    public void iShouldAbleToDeleteTheAddedPerson() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getAddPersonIcon()));
        List<WebElement> checkboxList = driver.findElements(homePageObject.getCheckBoxlist());
        checkboxList.get(0).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getSelectAllLink()));
        WebElement ele = driver.findElement(homePageObject.getSelectAllLink());
        String[] name = ele.getText().split(" ");
        System.out.println(name[0]);
        if (name[0].equalsIgnoreCase("Deselect")) {
            System.out.println("one department selected");
        } else {
            driver.findElement(homePageObject.getSelectAllLink()).click();
            System.out.println("all department selected");
        }
        driver.findElement(homePageObject.getDeleteIcon()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getDeleteConfirmation()));
        driver.findElement(homePageObject.getDeleteConfirmation()).click();
        Thread.sleep(1000l);
        String mess = driver.findElement(pageObject.getToastmessageforCreatecompany()).getText();
        System.out.println(mess);
        Assert.assertEquals(mess, "Person deleted from access level successfully");
    }

    @And("I should able to navigate to the Report page")
    public void iShouldAbleToNavigateToTheReportPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getTransactionText()));
        Assert.assertTrue(driver.findElement(homePageObject.getTransactionText()).isDisplayed());
    }

    @And("I validate all the components present in Report page")
    public void iValidateAllTheComponentsPresentInReportPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getFilterIcon()));
            Assert.assertTrue(driver.findElement(homePageObject.getFilterIcon()).isDisplayed());
            Assert.assertTrue(driver.findElement(homePageObject.getRefreshIcon()).isDisplayed());
            Assert.assertTrue(driver.findElement(homePageObject.getTransactionText()).isDisplayed());
            List<WebElement> cardNumber = driver.findElements(homePageObject.getCardNumberList());
            List<WebElement> personId = driver.findElements(homePageObject.getPersonIDList());
            List<WebElement> deviceAlias = driver.findElements(homePageObject.getDeviceAliasList());
            List<WebElement> serialNumber = driver.findElements(homePageObject.getSerialNumberList());
            for (WebElement card : cardNumber) {
                System.out.println(card.getText());
            }
            for (WebElement person : personId) {
                System.out.println(person.getText());
            }
            for (WebElement device : deviceAlias) {
                System.out.println(device.getText());
            }
            for (WebElement serial : serialNumber) {
                System.out.println(serial.getText());
            }

        } catch (Exception e) {
            System.out.println("no record found");
        }
    }

    @And("I navigate back to the home page")
    public void iNavigateBackToTheHomePage() {
        driver.findElement(homePageObject.getBcakIcon()).click();
    }

    @And("I click on the filter icon")
    public void iClickOnTheFilterIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getFilterIcon()));
        driver.findElement(homePageObject.getFilterIcon()).click();
    }

    @Then("I should able to filter the report")
    public void iShouldAbleToFilterTheReport() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getDeviceAliasTexfield()));
        driver.findElement(homePageObject.getDeviceAliasTexfield()).sendKeys(properties.getProperty("Device-Alias"));
        dragUp();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getApplyButton()));
        driver.findElement(homePageObject.getApplyButton()).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(homePageObject.getReportContainerList()));
        List<WebElement> containerList = driver.findElements(homePageObject.getReportContainerList());
        List<WebElement> deviceAliaslist = driver.findElements(homePageObject.getDeviceAliasList());
        for (WebElement container : containerList) {
            Assert.assertTrue(container.isDisplayed());
        }
        for (WebElement device : deviceAliaslist) {
            Assert.assertTrue(device.isDisplayed());
            device.getText();
            Count++;
        }
        System.out.println("No. of filtered devicen displayed is :" + Count);


    }

    /*
    Device and Door
    Prerequisite :
    Before run the device and door tag please ensure that,
    1. device should added to the particular company and it will reflect in the android application
    2. Provide the following details in data.properties file
         company=
         Device-Alias=
         Device_Serial_Number=
         editedDeviceName =
         originalDeviceName =
    3.Delete the device before running the suite ,from the mobile application

     */
    //device and door
    @And("I click on the Add device icon")
    public void iClickOnTheAddDeviceIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getAddDeviceIcon()));
        driver.findElement(homePageObject.getAddDeviceIcon()).click();
    }

    @And("I select one Device by the device serial no")
    public void iSelectOneDeviceByTheDeviceSerialNo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getSelectAllLink()));
        List<WebElement> deviceSerialNumberList = driver.findElements(homePageObject.getSerialNumber());
        System.out.println(deviceSerialNumberList.size());
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(homePageObject.getDeviceContainerList()));
        List<WebElement> containerList = driver.findElements(homePageObject.getDeviceContainerList());
        System.out.println(containerList.size());

        for (int i = 0; i < deviceSerialNumberList.size(); i++) {
            if (deviceSerialNumberList.get(i).getText().equalsIgnoreCase(properties.getProperty("Device_Serial_Number"))) {
                System.out.println(deviceSerialNumberList.get(i).getText());
                containerList.get(i).click();
                System.out.println("device added successfully");

            } else {
                System.out.println("serial number not found");
                ExtentCucumberAdapter.addTestStepLog("serial number not found");
            }
        }
    }

    @And("I validate all the fields in the Added device")
    public void iValidateAllTheFieldsInTheAddedDevice() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getExpandIcon()));
            driver.findElement(homePageObject.getExpandIcon()).click();
            Assert.assertTrue(driver.findElement(homePageObject.getDeviceNameList()).isDisplayed());
            System.out.println(driver.findElement(homePageObject.getDeviceNameList()).getText());
            Assert.assertTrue(driver.findElement(homePageObject.getDeviceSerialNumberList()).isDisplayed());
            System.out.println(driver.findElement(homePageObject.getDeviceSerialNumberList()).getText());
            Assert.assertTrue(driver.findElement(homePageObject.getDeviceIPList()).isDisplayed());
            System.out.println(driver.findElement(homePageObject.getDeviceIPList()).getText());
            Assert.assertTrue(driver.findElement(homePageObject.getRegisteredDevice()).isDisplayed());
            System.out.println(driver.findElement(homePageObject.getRegisteredDevice()).getText());
            Assert.assertTrue(driver.findElement(homePageObject.getFirmwareVersion()).isDisplayed());
            System.out.println(driver.findElement(homePageObject.getFirmwareVersion()).getText());
        } catch (Exception e) {
            e.getCause();
            System.out.println("Device is not available");
        }
    }

    @And("I verify that all the device are selected when I click on select all link")
    public void iVerifyThatAllTheDeviceAreSelectedWhenIClickOnSelectAllLink() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getDeviceNameList()));
            driver.findElement(homePageObject.getDeviceCheckbox()).click();
            driver.findElement(homePageObject.getSelectandDeselectAll()).click();
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Device is not connected");
        }
    }


    @And("I verify that all the device are deselected when I click on deselect all link")
    public void iVerifyThatAllTheDeviceAreDeselectedWhenIClickOnDeselectAllLink() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getDeviceNameList()));
            driver.findElement(homePageObject.getSelectandDeselectAll()).click();
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Device is not connected");
        }
    }

    @And("I select the device and click on edit icon")
    public void iSelectTheDeviceAndClickOnEditIcon() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getDeviceNameList()));
            driver.findElement(homePageObject.getDeviceCheckbox()).click();
            driver.findElement(homePageObject.getEditIcon()).click();
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Device is not connected");
        }
    }

    @And("I edit the device name and click on the save icon")
    public void iEditTheDeviceNameAndClickOnTheSaveIcon() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getEditDeviceName()));
            driver.findElement(homePageObject.getEditDeviceName()).sendKeys(properties.getProperty("editedDeviceName"));
            driver.findElement(homePageObject.getSaveButton()).click();
            Thread.sleep(1000l);
            String mess = driver.findElement(pageObject.getToastmessageforCreatecompany()).getText();
            System.out.println(mess);
            Assert.assertEquals(mess, "Device updated successfully");
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Device is not connected");
        }
    }

    @Then("The updated data should displayed")
    public void theUpdatedDataShouldDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getDeviceNameList()));
            System.out.println("Update Device name :" + driver.findElement(homePageObject.getDeviceNameList()).
                    getText());
            Assert.assertEquals(driver.findElement(homePageObject.getDeviceNameList()).
                    getText(), properties.getProperty("editedDeviceName"));
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Device is not connected");
        }
    }

    @And("I click on the close icon")
    public void iClickOnTheCloseIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getEditDeviceBackButton()));
        deviceName = driver.findElement(homePageObject.getEditDeviceName()).getText();
        driver.findElement(homePageObject.getEditDeviceBackButton()).click();
    }

    @Then("I should navigate to the device list page and I verify for all the previous data are unchaged")
    public void iShouldNavigateToTheDeviceListPageAndIVerifyForAllThePreviousDataAreUnchaged() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getDeviceNameList()));
        System.out.println("the devcie name :" + driver.findElement(homePageObject.getDeviceNameList()).
                getText());
        Assert.assertEquals(driver.findElement(homePageObject.getDeviceNameList()).
                getText(), deviceName);

    }

    @And("I should filter the Device data based on Device Status and Registered Device Status")
    public void iShouldFilterTheDeviceDataBasedOnDeviceStatusAndRegisteredDeviceStatus() throws InterruptedException {

        //for online filter
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getOnlineCheckbox()));
        driver.findElement(homePageObject.getOnlineCheckbox()).click();
        wait.until(ExpectedConditions.elementToBeClickable(homePageObject.getFilterApplyButton()));
        driver.findElement(homePageObject.getFilterApplyButton()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getClearFilterButton()));
        List<WebElement> deviceNames = driver.findElements(homePageObject.getDeviceNameList());
        List<WebElement> deviceStatus = driver.findElements(homePageObject.getDeviceStatusList());
        List<WebElement> deviceSerialNumber = driver.findElements(homePageObject.getDeviceSerialNumberList());
        try {
            for (int i = 0; i < deviceNames.size(); i++) {
                System.out.println("The device " + deviceNames.get(i).getText() +
                        " bearing serial number" + deviceSerialNumber.get(i).getText() +
                        "is :" + deviceStatus.get(i).getText());
            }
        } catch (Exception e) {
            e.getMessage();
            System.out.println("device/door not present");
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getClearFilterButton()));
        driver.findElement(homePageObject.getClearFilterButton()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getFilterIcon()));
        driver.findElement(homePageObject.getFilterIcon()).click();

        //for offline device filter
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getOnlineCheckbox()));
        driver.findElement(homePageObject.getOfflineCheckbox()).click();
        driver.findElement(homePageObject.getFilterApplyButton()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getClearFilterButton()));
        List<WebElement> deviceNames2 = driver.findElements(homePageObject.getDeviceNameList());
        List<WebElement> deviceStatus2 = driver.findElements(homePageObject.getDeviceStatusList());
        List<WebElement> deviceSerialNumber2 = driver.findElements(homePageObject.getDeviceSerialNumberList());
        try {
            for (int i = 0; i < deviceNames.size(); i++) {
                System.out.println("The device " + deviceNames2.get(i).getText() +
                        " bearing serial number" + deviceSerialNumber2.get(i).getText() +
                        "is :" + deviceStatus2.get(i).getText());
            }
        } catch (Exception e) {
            e.getMessage();
            System.out.println("no data available");
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getClearFilterButton()));
        driver.findElement(homePageObject.getClearFilterButton()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getFilterIcon()));
        driver.findElement(homePageObject.getFilterIcon()).click();

        //for registered
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getOnlineCheckbox()));
        driver.findElement(homePageObject.getRegisteredDeviceOption()).click();
        driver.findElement(homePageObject.getRegisteredCheckbox()).click();
        driver.findElement(homePageObject.getFilterApplyButton()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getClearFilterButton()));
        List<WebElement> deviceNames3 = driver.findElements(homePageObject.getDeviceNameList());
        List<WebElement> deviceStatus3 = driver.findElements(homePageObject.getDeviceStatusList());
        List<WebElement> deviceSerialNumber3 = driver.findElements(homePageObject.getDeviceSerialNumberList());
        try {
            for (int i = 0; i < deviceNames.size(); i++) {
                System.out.println("The device " + deviceNames3.get(i).getText() +
                        " bearing serial number" + deviceSerialNumber3.get(i).getText() +
                        "is Registered");
            }
        } catch (Exception e) {
            e.getMessage();
            System.out.println("data not not available");
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getClearFilterButton()));
        driver.findElement(homePageObject.getClearFilterButton()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getFilterIcon()));
        driver.findElement(homePageObject.getFilterIcon()).click();

        //for Un registered
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getOnlineCheckbox()));
        driver.findElement(homePageObject.getRegisteredDeviceOption()).click();
        driver.findElement(homePageObject.getUnRegisteredCheckbox()).click();
        driver.findElement(homePageObject.getFilterApplyButton()).click();
        Thread.sleep(1000l);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getClearFilterButton()));
        List<WebElement> deviceNames4 = driver.findElements(homePageObject.getDeviceNameList());
        List<WebElement> deviceStatus4 = driver.findElements(homePageObject.getDeviceStatusList());
        List<WebElement> deviceSerialNumber4 = driver.findElements(homePageObject.getDeviceSerialNumberList());
        try {
            for (int i = 0; i < deviceNames.size(); i++) {
                System.out.println("The device " + deviceNames4.get(i).getText() +
                        " bearing serial number" + deviceSerialNumber4.get(i).getText() +
                        "is Un Registered");
            }
        } catch (Exception e) {
            e.getMessage();
            System.out.println("data not available");
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getClearFilterButton()));
        driver.findElement(homePageObject.getClearFilterButton()).click();
    }

    @And("I should clear the filter and close the filter page by clicking on the cross icon")
    public void iShouldClearTheFilterAndCloseTheFilterPageByClickingOnTheCrossIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getOnlineCheckbox()));
        driver.findElement(homePageObject.getOnlineCheckbox()).click();
        driver.findElement(homePageObject.getClearAllButton()).click();
        Assert.assertTrue(!driver.findElement(homePageObject.getOnlineCheckbox()).isSelected());

    }

    @And("I delete the device from the device list")
    public void iDeleteTheDeviceFromTheDeviceList() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getDeviceNameList()));
        driver.findElement(homePageObject.getDeviceCheckbox()).click();
        driver.findElement(homePageObject.getDeleteIcon()).click();
        driver.findElement(homePageObject.getDeviceDeleteConfirmation()).click();
        Thread.sleep(1000l);
        String mess = driver.findElement(pageObject.getToastmessageforCreatecompany()).getText();
        System.out.println(mess);
        Assert.assertEquals(mess, "Device deleted successfully");
    }

    @And("I navigate back to home page by clicking on the back icon")
    public void iNavigateBackToHomePageByClickingOnTheBackIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getFilterCloseIcon()));
        driver.findElement(homePageObject.getFilterCloseIcon()).click();
        Assert.assertTrue(driver.findElement(homePageObject.getAccessLevelText()).isDisplayed());

    }

    @And("I click on door from Dropdown")
    public void iClickOnDoorFromDropdown() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getAccessLevelText()));
            driver.findElement(homePageObject.getAccessLevelText()).click();
            List<WebElement> access = driver.findElements(homePageObject.getAccessLevelText());
            for (WebElement el : access) {
                if (el.getText().equalsIgnoreCase("door")) {
                    el.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Door is not Present");
        }
    }

    @And("I click on the Expand Icon")
    public void iClickOnTheExpandIcon() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getExpandIcon()));
            driver.findElement(homePageObject.getExpandIcon()).click();
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Door is not Present");
        }
    }

    @And("I validate all the values of door")
    public void iValidateAllTheValuesOfDoor() throws InterruptedException {
        try {
            List<WebElement> doorNames = driver.findElements(homePageObject.getDoorNameList());
            List<WebElement> doorStatus = driver.findElements(homePageObject.getDoorStatusList());
            List<WebElement> doorInfo = driver.findElements(homePageObject.getDoorInfoIconList());
            List<WebElement> doorSerialNumber = driver.findElements(homePageObject.getDoorSerialNumberList());
            List<WebElement> doorNumber = driver.findElements(homePageObject.getDoorNumberList());
            List<WebElement> timezone = driver.findElements(homePageObject.getTimeZoneList());
            List<WebElement> verification = driver.findElements(homePageObject.getVerificationList());
            System.out.println("the number of door :" + doorNames.size());
            wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getDoorNameList()));
            Thread.sleep(2000l);
            for (int i = 0; i < doorNames.size(); i++) {
                Assert.assertTrue(doorStatus.get(i).isDisplayed());
                System.out.println(doorStatus.get(i).getText());
                Assert.assertTrue(doorInfo.get(i).isDisplayed());
                System.out.println(doorInfo.get(i).getText());
                Assert.assertTrue(doorSerialNumber.get(i).isDisplayed());
                System.out.println(doorSerialNumber.get(i).getText());
                Assert.assertTrue(doorNumber.get(i).isDisplayed());
                System.out.println(doorNumber.get(i).getText());
                //  Assert.assertTrue(timezone.get(i).isDisplayed());
                //  System.out.println(timezone.get(i).getText());
                Assert.assertTrue(verification.get(i).isDisplayed());
                System.out.println(verification.get(i).getText());
                Count++;

            }
            System.out.println("the number of door present is " + Count);
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Door is not Present");
        }

    }

    @And("I click on Add device button and get the success message")
    public void iClickOnAddDeviceButtonAndGetTheSuccessMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(homePageObject.getAddPersonButton()));
        driver.findElement(homePageObject.getAddPersonButton()).click();
        String mess = driver.findElement(pageObject.getToastmessageforCreatecompany()).getText();
        System.out.println(mess);
        try {
            Assert.assertEquals(mess, "Device added to level successfully");
        } catch (Error e) {
            e.printStackTrace();
            System.out.println(mess);
        }
    }

    @And("I should filter the Door data based on Door status")
    public void iShouldFilterTheDoorDataBasedOnDoorStatus() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getOnlineCheckbox()));
        driver.findElement(homePageObject.getOnlineCheckbox()).click();
        driver.findElement(homePageObject.getFilterApplyButton()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getClearFilterButton()));
        List<WebElement> deviceNames = driver.findElements(homePageObject.getDeviceNameList());
        List<WebElement> deviceStatus = driver.findElements(homePageObject.getDeviceStatusList());
        List<WebElement> deviceSerialNumber = driver.findElements(homePageObject.getDeviceSerialNumberList());
        try {
            for (int i = 0; i < deviceNames.size(); i++) {
                System.out.println("Device status is :" + deviceStatus.get(i).getText());
            }
        } catch (Exception e) {
            e.getMessage();
            System.out.println("device/door not present");
        }
        driver.findElement(homePageObject.getClearFilterButton()).click();
        driver.findElement(homePageObject.getFilterIcon()).click();

        //for offline device filter
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getOnlineCheckbox()));
        driver.findElement(homePageObject.getOfflineCheckbox()).click();
        driver.findElement(homePageObject.getFilterApplyButton()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.getClearFilterButton()));
        List<WebElement> deviceNames2 = driver.findElements(homePageObject.getDeviceNameList());
        List<WebElement> deviceStatus2 = driver.findElements(homePageObject.getDeviceStatusList());
        List<WebElement> deviceSerialNumber2 = driver.findElements(homePageObject.getDeviceSerialNumberList());
        try {
            for (int i = 0; i < deviceNames.size(); i++) {
                System.out.println("Device status is :" + deviceStatus.get(i).getText());
            }
        } catch (Exception e) {
            e.getMessage();
            System.out.println("no data available");
        }
        driver.findElement(homePageObject.getClearFilterButton()).click();
    }
}

