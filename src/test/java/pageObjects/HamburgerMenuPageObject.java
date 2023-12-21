package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class HamburgerMenuPageObject {

    //Hamburger
    private final By profilePhotoIcon = By.id("com.zkbiocloudaccess:id/profile_iv");
    private final By userName = By.id("com.zkbiocloudaccess:id/tv_userName");
    private final By companyName = By.id("com.zkbiocloudaccess:id/tv_companyName");
    private final By myProfileOption = By.id("com.zkbiocloudaccess:id/rl_myProfile");
    private final By companyProfile = By.id("com.zkbiocloudaccess:id/rl_companyProfile");
    private final By switchCompany = By.id("com.zkbiocloudaccess:id/rl_switchCompany");
    private final By switchlanguage = By.id("com.zkbiocloudaccess:id/rl_switchLanguage");
    private final By resetPassword = By.id("com.zkbiocloudaccess:id/rl_resetPassword");
    private final By logout = By.id("com.zkbiocloudaccess:id/rl_logout");
    //My Profile (Hamburger -> MyProfile)
    private final By editIcon = By.id("com.zkbiocloudaccess:id/tvEdit");
    private final By userProfileImage = By.id("com.zkbiocloudaccess:id/profile_image");
    private final By firstNameTextfield = By.id("com.zkbiocloudaccess:id/et_firstName");
    private final By lastNameTextfield = By.id("com.zkbiocloudaccess:id/et_lastName");
    private final By nickNameTextfield = By.id("com.zkbiocloudaccess:id/et_nickName");
    private final By genderDropdown = By.id("com.zkbiocloudaccess:id/et_gender");
    private final By emailTextfield = By.id("com.zkbiocloudaccess:id/et_email");
    private final By phoneNumberTextfield = By.id("com.zkbiocloudaccess:id/et_phone");
    private final By countryCodeText = By.id("com.zkbiocloudaccess:id/tvCountryCode");
    private final By countryCodeDropdown = By.id("com.zkbiocloudaccess:id/ivArrow");
    private final By dobTextfield = By.id("com.zkbiocloudaccess:id/et_dob");
    private final By dobCalenderView = By.id("com.zkbiocloudaccess:id/iv_calender");
    private final By cancelButton = By.id("com.zkbiocloudaccess:id/cancel_tv");
    private final By updateButton = By.id("com.zkbiocloudaccess:id/tv_update");
    //Company Profile (Hamburger -> Company Profile)
    private final By companyNameTextfield = By.id("com.zkbiocloudaccess:id/et_company_name");
    private final By industryTypeTextfield = By.id("com.zkbiocloudaccess:id/et_industrytype");
    private final By companySizeTextfield = By.id("com.zkbiocloudaccess:id/et_companysize");
    private final By codeTextfield = By.id("com.zkbiocloudaccess:id/et_code");
    private final By registrationNumberTextfield = By.id("com.zkbiocloudaccess:id/et_registrationnumber");
    private final By emailIdTextfield = By.id("com.zkbiocloudaccess:id/et_emil");
    private final By mobileNumberTextfield = By.id("com.zkbiocloudaccess:id/et_phone");
    private final By addressTextfield = By.id("com.zkbiocloudaccess:id/et_address");
    private final By countryTextfield = By.id("com.zkbiocloudaccess:id/et_country");
    private final By stateTextfield = By.id("com.zkbiocloudaccess:id/et_state");
    private final By cityTextfield = By.id("com.zkbiocloudaccess:id/et_city");
    private final By zipcodeTextfield = By.id("com.zkbiocloudaccess:id/et_zipcode");
    //Switch Company (Hamburger -> Switch Company)
    private final By companyNameList = By.id("com.zkbiocloudaccess:id/txt_name");
    private final By radioButtonList = By.id("com.zkbiocloudaccess:id/iv_checked");
    private final By logoutConfirmButton = By.id("com.zkbiocloudaccess:id/tv_logout");
    private final By searchBar = By.id("com.zkbiocloudaccess:id/et_search_company");
    //Reset Password (Hamburger -> Reset Password)
    private final By oldPasswordTextfield = By.id("com.zkbiocloudaccess:id/et_oldPassword");
    private final By newPasswordTextfield = By.id("com.zkbiocloudaccess:id/et_newPassword");
    private final By confirmPasswordTextfield = By.id("com.zkbiocloudaccess:id/et_confirmPassword");
    private final By resetPasswordButton = By.id("com.zkbiocloudaccess:id/resetPassword_button");
    private final By eyeIcon = By.id("com.zkbiocloudaccess:id/text_input_end_icon");
    private final By resetPasswordSuccessmessage = By.id("com.zkbiocloudaccess:id/txt_msg");
    public HamburgerMenuPageObject(AndroidDriver driver) {

        PageFactory.initElements(driver, this);
    }

    //Getters
    public By getProfilePhotoIcon() {
        return profilePhotoIcon;
    }

    public By getUserName() {
        return userName;
    }

    public By getCompanyName() {
        return companyName;
    }

    public By getMyProfileOption() {
        return myProfileOption;
    }

    public By getCompanyProfile() {
        return companyProfile;
    }

    public By getSwitchCompany() {
        return switchCompany;
    }

    public By getSwitchlanguage() {
        return switchlanguage;
    }

    public By getResetPassword() {
        return resetPassword;
    }

    public By getLogout() {
        return logout;
    }

    public By getUserProfileImage() {
        return userProfileImage;
    }

    public By getFirstNameTextfield() {
        return firstNameTextfield;
    }

    public By getLastNameTextfield() {
        return lastNameTextfield;
    }

    public By getNickNameTextfield() {
        return nickNameTextfield;
    }

    public By getGenderDropdown() {
        return genderDropdown;
    }

    public By getEmailTextfield() {
        return emailTextfield;
    }

    public By getPhoneNumberTextfield() {
        return phoneNumberTextfield;
    }

    public By getCountryCodeText() {
        return countryCodeText;
    }

    public By getCountryCodeDropdown() {
        return countryCodeDropdown;
    }

    public By getDobTextfield() {
        return dobTextfield;
    }

    public By getDobCalenderView() {
        return dobCalenderView;
    }

    public By getEditIcon() {
        return editIcon;
    }

    public By getCancelButton() {
        return cancelButton;
    }

    public By getUpdateButton() {
        return updateButton;
    }

    public By getCompanyNameTextfield() {
        return companyNameTextfield;
    }

    public By getIndustryTypeTextfield() {
        return industryTypeTextfield;
    }

    public By getCompanySizeTextfield() {
        return companySizeTextfield;
    }

    public By getCodeTextfield() {
        return codeTextfield;
    }

    public By getRegistrationNumberTextfield() {
        return registrationNumberTextfield;
    }

    public By getEmailIdTextfield() {
        return emailIdTextfield;
    }

    public By getMobileNumberTextfield() {
        return mobileNumberTextfield;
    }

    public By getAddressTextfield() {
        return addressTextfield;
    }

    public By getCountryTextfield() {
        return countryTextfield;
    }

    public By getStateTextfield() {
        return stateTextfield;
    }

    public By getCityTextfield() {
        return cityTextfield;
    }

    public By getZipcodeTextfield() {
        return zipcodeTextfield;
    }

    public By getCompanyNameList() {
        return companyNameList;
    }

    public By getLogoutConfirmButton() {
        return logoutConfirmButton;
    }

    public By getOldPasswordTextfield() {
        return oldPasswordTextfield;
    }

    public By getNewPasswordTextfield() {
        return newPasswordTextfield;
    }

    public By getConfirmPasswordTextfield() {
        return confirmPasswordTextfield;
    }

    public By getResetPasswordButton() {
        return resetPasswordButton;
    }

    public By getEyeIcon() {
        return eyeIcon;
    }

    public By getResetPasswordSuccessmessage() {
        return resetPasswordSuccessmessage;
    }

    public By getSearchBar() {
        return searchBar;
    }

    public By getRadioButtonList() {
        return radioButtonList;
    }


}