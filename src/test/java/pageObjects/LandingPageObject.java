package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class LandingPageObject {

    //Login Page
    private final By username = By.id("com.zkbiocloudaccess:id/txtInput_email");
    private final By password = By.id("com.zkbiocloudaccess:id/edit_password");
    private final By eyeIcon = By.id("com.zkbiocloudaccess:id/text_input_end_icon");
    private final By loginButton = By.id("com.zkbiocloudaccess:id/login_button");
    private final By companycodeDropdown = By.id("com.zkbiocloudaccess:id/companyCode_dropdown");
    private final By companyCode = By.xpath("//android.widget.Spinner[@text='Company Code*']");
    private final By continueButton = By.id("com.zkbiocloudaccess:id/continue_button");
    private final By createComapnyLink = By.id("com.zkbiocloudaccess:id/tv_createCompany");
    private final By backButton = By.id("com.zkbiocloudaccess:id/back");
    private final By valueenteredintheTextfield = By.xpath("//android.widget.EditText[@text='akshay@zkteco.in']");
    private final By signIntext = By.id("com.zkbiocloudaccess:id/signIn_tv");
    private final By forgotPasswordlink = By.id("com.zkbiocloudaccess:id/forget_pass_tv");
    private final By donthaveanAccounttext = By.id("com.zkbiocloudaccess:id/tv_text");
    private final By SignUplink = By.id("com.zkbiocloudaccess:id/tv_signUp");
    private final By CloudAccessLogo = By.id("com.zkbiocloudaccess:id/logo_imageView");
    private final By toastmessage = By.xpath("//android.widget.Toast[@text='Incorrect User Name or password.']");
    private final By toastmessageunregistered = By.xpath("//android.widget.Toast[@text='User does not exist.']");
    private final By errorMessageforBlankTextbox = By.id("com.zkbiocloudaccess:id/textinput_error");
    private final By successMessageforSignUp = By.xpath("//android.widget.Toast[@text='User created successfully.']");
    private final By errorMessageforSignUp = By.xpath("//android.widget.Toast[@text='User already exist.']");
    private final By toastmessageforCreatecompany = By.xpath("//android.widget.Toast[@text]");
    //SignUp page
    private final By signUpLink = By.id("com.zkbiocloudaccess:id/tv_signUp");
    private final By FirstName = By.id("com.zkbiocloudaccess:id/et_firstName");
    private final By LastName = By.id("com.zkbiocloudaccess:id/et_lastName");
    private final By EmailId = By.id("com.zkbiocloudaccess:id/et_email");
    private final By PhoneNo = By.id("com.zkbiocloudaccess:id/et_phone");
    private final By SignupPassword = By.id("com.zkbiocloudaccess:id/et_password");
    private final By ConfirmPassword = By.id("com.zkbiocloudaccess:id/et_confirmPassword");
    private final By UserAgreementcheckbox = By.id("com.zkbiocloudaccess:id/user_agreementcheckbox");
    private final By PrivacyPolicy = By.id("com.zkbiocloudaccess:id/user_privacypolicy");
    private final By signUpbtn = By.id("com.zkbiocloudaccess:id/signUp_button");
    private final By signuptext = By.id("com.zkbiocloudaccess:id/signIn_tv");
    private final By signInLink = By.id("com.zkbiocloudaccess:id/tv_signIn");
    //Create Company
    private final By countryDropdown = By.id("com.zkbiocloudaccess:id/tv_country");
    private final By comapanyNameTextfeild = By.id("com.zkbiocloudaccess:id/et_companyName");
    private final By companyCodeTextfield = By.id("com.zkbiocloudaccess:id/et_companyCode");
    private final By registrationNumberTextfield = By.id("com.zkbiocloudaccess:id/et_registrationNo");
    private final By emailTextfield = By.id("com.zkbiocloudaccess:id/et_email");
    private final By mobileTextfield = By.id("com.zkbiocloudaccess:id/et_phone");
    private final By createButton = By.id("com.zkbiocloudaccess:id/create_button");
    private final By countryName = By.id("com.zkbiocloudaccess:id/txt_country_name");
    private final By countryRadioButtonList = By.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.RadioButton");
    private final By selectCountrySearchfield = By.id("com.zkbiocloudaccess:id/search_edt");
    private final By countrynameList = By.xpath("//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView");
    private final By textfieldDescription = By.id("com.zkbiocloudaccess:id/tvDesc");
    //Forgot Password
    private final By forgotPasswordLink = By.id("com.zkbiocloudaccess:id/forget_pass_tv");
    private final By forgotPasswordEmailTextfield = By.id("com.zkbiocloudaccess:id/et_userName");
    private final By sendLinkButton = By.id("com.zkbiocloudaccess:id/senLink_button");
    private final By emailSentText = By.id("com.zkbiocloudaccess:id/txt1");
    private final By backtoLoginButton = By.id("com.zkbiocloudaccess:id/signIn_button");
    public LandingPageObject(AndroidDriver driver) {

        PageFactory.initElements(driver, this);
    }

    //    Getters
    public By getSignInLink() {
        return signInLink;
    }

    public By getSignuptext() {
        return signuptext;
    }

    public By getSignUpLink() {
        return signUpLink;
    }

    public By getEyeIcon() {
        return eyeIcon;
    }

    public By getSuccessMessageforSignUp() {
        return successMessageforSignUp;
    }

    public By getToastmessage() {
        return toastmessage;
    }

    public By getCompanycodeDropdown() {
        return companycodeDropdown;
    }

    public By getToastmessageunregistered() {
        return toastmessageunregistered;
    }

    public By getUsername() {
        return username;
    }

    public By getErrorMessageforBlankTextbox() {
        return errorMessageforBlankTextbox;
    }

    public By getErrorMessageforSignUp() {
        return errorMessageforSignUp;
    }

    public By getPassword() {
        return password;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public By getCompanyCode() {
        return companyCode;
    }

    public By getCreateButton() {
        return createButton;
    }

    public By getSignInText() {
        return signIntext;
    }

    public By getforgotPasswordlink() {
        return forgotPasswordlink;
    }

    public By getdonthaveanAccounttext() {
        return donthaveanAccounttext;
    }

    public By getsignUplink() {
        return SignUplink;
    }

    public By getCloudAccesslogo() {
        return CloudAccessLogo;
    }

    public By getvalueenteredintheTextfield() {

        return valueenteredintheTextfield;
    }

    public By getFirstName() {
        return FirstName;
    }

    public By getLastName() {
        return LastName;
    }

    public By getPhoneNo() {
        return PhoneNo;
    }

    public By getUserAgreementcheckbox() {
        return UserAgreementcheckbox;
    }

    public By getPrivacyPolicy() {
        return PrivacyPolicy;
    }

    public By getSignUpbtn() {
        return signUpbtn;
    }

    public By getEmailId() {
        return EmailId;
    }

    public By getConfirmPassword() {
        return ConfirmPassword;
    }

    public By getSignupPassword() {
        return SignupPassword;
    }

    public By getContinueButton() {
        return continueButton;
    }

    public By getCreateComapnyLink() {
        return createComapnyLink;
    }

    public By getBackButton() {
        return backButton;
    }

    public By getCountryDropdown() {
        return countryDropdown;
    }

    public By getComapanyNameTextfeild() {
        return comapanyNameTextfeild;
    }

    public By getCompanyCodeTextfield() {
        return companyCodeTextfield;
    }

    public By getRegistrationNumberTextfield() {
        return registrationNumberTextfield;
    }

    public By getEmailTextfield() {
        return emailTextfield;
    }

    public By getMobileTextfield() {
        return mobileTextfield;
    }

    public By getCountryName() {
        return countryName;
    }

    public By getCountryRadioButtonList() {
        return countryRadioButtonList;
    }

    public By getSelectCountrySearchfield() {
        return selectCountrySearchfield;
    }

    public By getCountrynameList() {
        return countrynameList;
    }

    public By getToastmessageforCreatecompany() {
        return toastmessageforCreatecompany;
    }

    public By getTextfieldDescription() {
        return textfieldDescription;
    }

    public By getForgotPasswordLink() {
        return forgotPasswordLink;
    }

    public By getForgotPasswordEmailTextfield() {
        return forgotPasswordEmailTextfield;
    }

    public By getSendLinkButton() {
        return sendLinkButton;
    }

    public By getEmailSentText() {
        return emailSentText;
    }

    public By getBacktoLoginButton() {
        return backtoLoginButton;
    }

}