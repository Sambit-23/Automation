@Cloudaccess
Feature: ZKBioCloudAccess full suite testing

# Device and Door
# Prerequisite :
# Before run the device and door tag please ensure that,
# 1. Device should added to the particular company and it will reflect in the android application
# 2. Add person and Department to the respective Company.
# 3. Provide the following details in data.properties file
# company=
# Device-Alias=
# Device_Serial_Number=
# editedDeviceName =
# originalDeviceName =
# 3.Delete the device before running the suite ,from the mobile application

 @TC_CloudAccessMobile_01-05 @system
  Scenario: Verify whether user is able to navigate to signin page and able to view all the components
  Given I am in CloudAccess signin page and verify all the components

 @TC_CloudAccessMobile_06 @system
 Scenario: Verify Whether Username text field is accepting Email Id or Phone No
 Given I am in CloudAccess signin page and verify all the components
 Then I enter valid email id or phone number in the username text field

 @TC_CloudAccessMobile_07 @system
 Scenario: Verify whether Error message is displayed for the invalid Email or Phone No
  Given I am in CloudAccess signin page and verify all the components
  Then I enter invalid "email" or "phnone" and validate the toast message

 @TC_CloudAccessMobile_08 @system
 Scenario:Verify Whether password text field is accepting Alphanumeric with atleast one Uppercase letter and special Symbol
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard

 @TC_CloudAccessMobile_09 @system
 Scenario: Verify whether Error message is displayed for the invalid Credentials alphanumeric password
  Given I am in CloudAccess signin page and verify all the components
  Then I enter invalid credentials and validate the toast message

 @TC_CloudAccessMobile_10 @system
 Scenario: Verify whether Error message is displayed for the invalid Credentials alphanumeric password
  Given I am in CloudAccess signin page and verify all the components
  Then I keep the username and password textfield blank and validate the error message

 @TC_CloudAccessMobile_11-13 @system
 Scenario: Verify whether Error message is displayed for the invalid Credentials alphanumeric password
  Given I am in CloudAccess signin page and verify all the components
  Then I validate the Eye Icon Functionality in Password Textfield

 @TC_CloudAccessMobile_14 @system
 Scenario: Verify Whether Error message is displayed for the unregistered Email Id
 Given I am in CloudAccess signin page and verify all the components
 Then I enter unregistered email id and validate the toast message

 @TC_CloudAccessMobile_124-126 @forgotPassword @system
 Scenario: Verify Whether User is able validate all the Forgot password fuctionality
  Given I am in CloudAccess signin page and verify all the components
  When I click on the forgot password link
  Then I should navigate to the forgot password page
  And I add a Email id and send the password to the respective mail id
  And I validate the email sent page

 @TC_CloudAccessMobile_128 @forgotPassword @system
 Scenario: Verify Whether User is able navigate back to signin page when click on back icon
  Given I am in CloudAccess signin page and verify all the components
  When I click on the forgot password link
  Then I should navigate to the forgot password page
  And I click on the back arrow icon
  And I should navigate back to the sign in page

 #SignUp Page

 @TC_CloudAccessMobile_16 @signup @system
 Scenario: Verify Whether User is able to navigate to Sign up page
 Given I am in CloudAccess signin page and verify all the components
 Then I click on signup link
 Then I verify the user navigation to signup page

 @TC_CloudAccessMobile_17&22 @signup @system
 Scenario: Verify Whether User is able verify all the elements in Sign up page
 Given I am in CloudAccess signin page and verify all the components
 Then I click on signup link
 Then I verify all the components in signup page with Astrix symbol in Mandatory field

 @TC_CloudAccessMobile_18 @signup @system
 Scenario: Verify Whether Error message is displayed, when user enters Invalid Email Id
 Given I am in CloudAccess signin page and verify all the components
 Then I click on signup link
 Then I Enter invalid emailid and verify the error message

 @TC_CloudAccessMobile_19 @signup @system
 Scenario: Verify Whether Error message is displayed, when user enters Invalid Phone no
  Given I am in CloudAccess signin page and verify all the components
  Then I click on signup link
  Then I Enter invalid Phone and verify the error message

 @TC_CloudAccessMobile_20_24_25_26 @signup @system
 Scenario: Verify Whether User is able to Perform Signup Action
  Given I am in CloudAccess signin page and verify all the components
  Then I click on signup link
  Then I Enter valid data in all the field and get success Message

 @TC_CloudAccessMobile_21 @signup @system
 Scenario: Verify Whether User is able to view Error message ,While try to signup with previous data
  Given I am in CloudAccess signin page and verify all the components
  Then I click on signup link
  Then I Enter duplicate data in all the field and get error Message

 @TC_CloudAccessMobile_23 @signup @system
 Scenario: Verify Whether User is able to navigate back to Sign In page, when user clicks on Sign In link
  Given I am in CloudAccess signin page and verify all the components
  Then I click on signup link
  Then I click on the Signin Link and Navigate back to Signin Page

 @TC_CloudAccessMobile_27_28 @companyCode @system
 Scenario: Verify Whether User is able to navigate to Select Company page
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I validate all the components in the select Company page

 @TC_CloudAccessMobile_29 @companyCode @system
 Scenario: Verify Whether User is able to view all the company in Company code Dropdown
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I verify all the compamy code in the select company page

 @TC_CloudAccessMobile_30_37 @companyCode @system
 Scenario: Verify Whether User is able to Navigate back to Select company page
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I click on create company link
  And I verify that i navigate back to select company page while click on the back button

 @TC_CloudAccessMobile_31 @companyCode @system
 Scenario: Verify Whether User is able to navigate to the application Successfully
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  Then I should navigate to the dashboard of application

 @TC_CloudAccessMobile_32 @companyCode @system
 Scenario:Verify Whether User is able to get an error message while try to continue without company code
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I click on continue button in select company page and validate the error message

 @TC_CloudAccessMobile_33_34_36 @createCompany @system
 Scenario: Verify Whether User is able to Navigate back to Select company page
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I click on create company link
  And I verify all the components in create company page with Astrix symbol in Mandatory field

 @TC_CloudAccessMobile_35_38 @createCompany @system
 Scenario: Verify Whether User is able to create a company successfully
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I click on create company link
  And I enter all the valid data in the create company page
  And I validate the success message

 @TC_CloudAccessMobile_39 @createCompany @system
 Scenario: Verify Whether User is able to get an Error message while entering invalid Phone number
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I click on create company link
  And I enter all the invalid mobile number in the create company page
  And I validate the error message

 @TC_CloudAccessMobile_40 @createCompany @system
 Scenario: Verify Whether Proper content is displayed, when user clicks on "?" icon
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I click on create company link
  And I click on ? icon to validate the description

 @TC_CloudAccessMobile_41_42 @HomePage @system
 Scenario: Verify Whether User is able to navigate to Device Management page
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  Then I click on the device management option
  And I should able to navigate to the device management page
  And I validate the Device dropdown elements

 @TC_CloudAccessMobile_43-47 @HomePage @Device @system
 Scenario: Verify Whether User is able add the device and validate all the field
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I Switch the company
  Then I click on the device management option
  And I should able to navigate to the device management page
  And I click on the Add device icon
  And I select one Device by the device serial no
  And I click on Add device button and get the success message
  And I validate all the fields in the Added device

 @TC_CloudAccessMobile_48_49 @HomePage @Device @system
 Scenario: Verify Whether User is able select and Deselect all the device
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I Switch the company
  Then I click on the device management option
  And I should able to navigate to the device management page
  And I verify that all the device are selected when I click on select all link
  And I verify that all the device are deselected when I click on deselect all link

 @TC_CloudAccessMobile_50 @HomePage @Device @system
 Scenario: Verify Whether User is able edit the device
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I Switch the company
  Then I click on the device management option
  And I should able to navigate to the device management page
  And I select the device and click on edit icon
  And I edit the device name and click on the save icon
  Then The updated data should displayed

 @TC_CloudAccessMobile_51_52 @HomePage @Device @system
 Scenario: Verify Whether User is able to close the edit window by clicking on "X" icon
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I Switch the company
  Then I click on the device management option
  And I should able to navigate to the device management page
  And I select the device and click on edit icon
  And I click on the close icon
  Then I should navigate to the device list page and I verify for all the previous data are unchaged

 @TC_CloudAccessMobile_53-57 @HomePage @Device @system
 Scenario: Verify whether user is able to filter the Devices based on Device Status and Registered Device and clear the filter
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I Switch the company
  Then I click on the device management option
  And I should able to navigate to the device management page
  And I click on the filter icon
  And I should filter the Device data based on Device Status and Registered Device Status
  And I click on the filter icon
  And I should clear the filter and close the filter page by clicking on the cross icon
  And I navigate back to home page by clicking on the back icon

 @TC_CloudAccessMobile_58_59_61_64-67@HomePage @Door @system
 Scenario: Verify Whether User is able add the device and validate all the field
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I Switch the company
  Then I click on the device management option
  And I should able to navigate to the device management page
  And I click on door from Dropdown
  And I click on the Expand Icon
  And I validate all the values of door
  And I click on the filter icon
  And I should filter the Door data based on Door status
  And I click on the filter icon
  And I should clear the filter and close the filter page by clicking on the cross icon
#  And I delete the device from the device list
  And I navigate back to home page by clicking on the back icon

 @TC_CloudAccessMobile_70 @HomePage @system
 Scenario: Verify Whether User is able to view all mentioned functionalities in the home page
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I should able to view all four the components in home page

 @TC_CloudAccessMobile_71 @Dasboard @system
 Scenario: Verify Whether User is able to view all Sub modules in the Dashboard on Bottom
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  Then I should navigate to the dashboard of application
  And i should able to view all the sub modules in dash board

 @TC_CloudAccessMobile_72 @Dasboard @system
 Scenario: Verify Whether User is able to view all Sub modules in the Dashboard on Bottom
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  Then I should navigate to the dashboard of application
  And I click on the Hamburger menu and Validate all the elements

 @TC_CloudAccessMobile_73_76 @Hamburger @My_Profile @system
 Scenario: Verify Whether User is able to view all components in My profile page
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I click on the Hamburger menu and Validate all the elements
  And I click on the My profile Option
  And I verify all the components in the My profile page

 @TC_CloudAccessMobile_74_75 @Hamburger @My_Profile @system
 Scenario: Verify Whether User is able to edit My profile
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I click on the Hamburger menu and Validate all the elements
  And I click on the My profile Option
  And I click on the Edit icon
  And I update the User Profile and Validate the Success message

 @TC_CloudAccessMobile_77_78 @Hamburger @Company_Profile @system
 Scenario: Verify Whether User is able to view all components in Company profile page
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  Then I should navigate to the dashboard of application
  And I click on the Hamburger menu and Validate all the elements
  And I click on the company profile Option
  And I verify all the components in the company profile page

 @TC_CloudAccessMobile_79 @Hamburger @Company_Profile @system
 Scenario: Verify Whether User is able to edit company profile
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  Then I should navigate to the dashboard of application
  And I click on the Hamburger menu and Validate all the elements
  And I click on the company profile Option
  And I click on the Edit icon
  And I update the company Profile and Validate the Success message

 @TC_CloudAccessMobile_80-82 @Hamburger @Swich_company @system
 Scenario: Verify Whether User is able to view all components in Switch Company page
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I click on the Hamburger menu and Validate all the elements
  And I click on the Switch company Option
  And I verify all the components in the switch company page

 @TC_CloudAccessMobile_83_84 @Hamburger @Swich_company @system
 Scenario: Verify Whether User is able to Switch Company
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I click on the Hamburger menu and Validate all the elements
  And I click on the Switch company Option
  And I click on a company and validate the respected data after switching

 @TC_CloudAccessMobile_85-87 @Dashboard @system
 Scenario: Verify Whether User is able naviagte to all the Sub Menus
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I navigate to all the Sub menus

 @TC_CloudAccessMobile_88 @Dashboard @system
 Scenario: Verify Whether User is able logout from the application
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I click on the Hamburger menu and Validate all the elements
  And I click on the logout Option and confirm in the logout popup
  And I should able to logout successfully from the application and naviagte back to the login page

 @TC_CloudAccessMobile_89-92 @HomePage @Report @system
 Scenario: Verify Whether User is able to validate all the components in the Report page
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  Then I click on the "Report" option
  And I should able to navigate to the Report page
  And I validate all the components present in Report page
  And I navigate back to the home page

 @TC_CloudAccessMobile_93 @HomePage @Report @system
 Scenario: Verify Whether User is able to filter the Reports
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I Switch the company
  Then I click on the "Report" option
  And I should able to navigate to the Report page
  And I click on the filter icon
  Then I should able to filter the report

 @TC_CloudAccessMobile_94-96 @HomePage @Access_level @system
 Scenario: Verify Whether User is able to get error message while left any of madatory field for creating a Access Level
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  Then I click on the "Access" option
  And I should able to navigate to the access level page
  And I should able to get error message while try to submoit without mandatory data

 @TC_CloudAccessMobile_97-99 @HomePage @Access_level @system
 Scenario: Verify Whether User is able to create Access level
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  Then I click on the "Access" option
  And I should able to navigate to the access level page
  And I enter all the data and I should get a success message
  And the Access level should visible in the List with all the componenets

 @TC_CloudAccessMobile_100 @HomePage @Access_level @system
 Scenario: Verify Whether User is able to edit Access level
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  Then I click on the "Access" option
  And I "edit" one access level and get the success message

 @TC_CloudAccessMobile_101 @HomePage @Access_level @system
 Scenario: Verify Whether User is able to delete Access level
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  Then I click on the "Access" option
  And I "delete" one access level and get the success message

 @TC_CloudAccessMobile_110_114 @HomePage @Access_level @system
 Scenario: Verify Whether User is able to add a single person to Access level
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  Then I click on the "Access" option
  And I click on the expand Icon and navigate to navigate to manage access level page
  And I click on person tab
  And I click on the Add person icon
  And I select one person
  And I click on Add Person button and get the success message
  And I should able to delete the added person

 @TC_CloudAccessMobile_111_112_116 @HomePage @Access_level @system
 Scenario: Verify Whether User is able to add all persons to Access level
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I Switch the company
  Then I click on the "Access" option
  And I click on the expand Icon and navigate to navigate to manage access level page
  And I click on person tab
  And I click on the Add person icon
  And I select all persons
  And I click on Add Person button and get the success message
  And I should able to view all the added person in the List
  And I should able to delete the added person

# @TC_CloudAccessMobile_113 @HomePage @Access_level @issueFromBackend
# Scenario: Verify whether all Person are added into Person Details window & user clicks on "Add" icon "No Records Found" should display
#  Given I am in CloudAccess signin page and verify all the components
#  Then I enter valid credentials and Navigate to the dasboard
#  And I select a company in select company code page
#  Then I click on the "Access" level option
#  And I click on the expand Icon and navigate to navigate to manage access level page
#  And I click on person tab
#  And I click on the Add person icon
#  And I select all persons
#  And I click on Add button and get the success message
#  And I click on the Add person icon again
#  Then I should get a error Message as No record found

 @TC_CloudAccessMobile_115 @HomePage @Access_level @system
 Scenario: Verify Whether User is able to abort the delete person operation by click on cancel button
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  Then I click on the "Access" option
  And I click on the expand Icon and navigate to navigate to manage access level page
  And I click on person tab
  And I click on the Add person icon
  And I select one person
  And I click on Add Person button and get the success message
  And I should able to abort the delete person operation
  And I should able to delete the added person

 @TC_CloudAccessMobile_117_122 @HomePage @Access_level @system
 Scenario: Verify Whether User is able to add a single department
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  Then I click on the "Access" option
  And I click on the expand Icon and navigate to navigate to manage access level page
  And I click on department tab
  And I click on the Add department icon
  And I select one department
  And I click on Add department button and get the success message
  And I should able to delete the added department

 @TC_CloudAccessMobile_119_120_123 @HomePage @Access_level @system
 Scenario: Verify Whether User is able to add all departments to Access level and View it in List
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  Then I click on the "Access" option
  And I click on the expand Icon and navigate to navigate to manage access level page
  And I click on department tab
  And I click on the Add department icon
  And I select all department
  And I click on Add department button and get the success message
  And I should able to delete the added department

 @TC_CloudAccessMobile_133-136 @Hamburger @Reset_Password @system
 Scenario: Verify Whether User is able to validate the Reset Password Page
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I click on the Hamburger menu and Validate all the elements
  And I click on the Reset Password Option
  And I validate all the components in the Reset Password Page

 @TC_CloudAccessMobile_137 @Hamburger @Reset_Password @system
 Scenario: Verify Whether User is able to get the error message when old and new passwords are same
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I click on the Hamburger menu and Validate all the elements
  And I click on the Reset Password Option
  And I Enter old and new Password same and validate the Error message

 @TC_CloudAccessMobile_138 @Hamburger @Reset_Password  @gettingissue @system
 Scenario: Verify Whether User is able to reset the password Successfully
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I click on the Hamburger menu and Validate all the elements
  And I click on the Reset Password Option
  And I Enter old and new Password and validate the success message

 @TC_CloudAccessMobile_139 @Hamburger @Reset_Password @system
 Scenario: Verify Whether User is able to naviagte back on clicking on back button
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I click on the Hamburger menu and Validate all the elements
  And I click on the Reset Password Option
  And I click on back button and Verify that user is landing on home page

 @TC_CloudAccessMobile_140-144&146_147 @Dasboard @system
 Scenario: Verify Whether User is able to validate all the components in the dashboard page
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I Switch the company
  And I click on the dashboard submodule
  Then I validate all the components in the Dashboard page

 @TC_CloudAccessMobile_145_148 @Dasboard @system
 Scenario: Verify Whether User is able to navigate to notification page
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I Switch the company
  And I click on the dashboard submodule
  And I click on the Expand Icon on the Notification bar
  Then I should able to naviagte to the notification page and Validate the notification

 @TC_CloudAccessMobile_149 @Dasboard @system
 Scenario: Verify Whether User is able to refresh the dashboard page
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I Switch the company
  And I click on the dashboard submodule
  Then I click on the refresh button

 @TC_CloudAccessMobile_150 @Message @system
 Scenario: Verify Whether User is able to navigate to message page
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I click on the message submodule
  Then I should able to navigate to Message Page

 @TC_CloudAccessMobile_151 @Organization @system
 Scenario: Verify Whether User is able to navigate to organization page
  Given I am in CloudAccess signin page and verify all the components
  Then I enter valid credentials and Navigate to the dasboard
  And I select a company in select company code page
  And I click on the organization submodule
  Then I should able to navigate to organization Page

