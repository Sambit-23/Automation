
@FHRMS
Feature: SuperAdmin

#LOGIN
   
  @SystemTesting @TC_SuperAdmin_1
  Scenario: Verify wherther login screen is displayed or not when user enter the url    
  Given Enter Url of SuperAdmin
  Then Login Page should display
  
  @SystemTesting @TC_SuperAdmin_2
  Scenario: Verify whether Super_Admin is able to login into application  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  Then User should be able to login and it should direct to Homepage
    
  @SystemTesting @TC_SuperAdmin_3
  Scenario: Verify whether user is able to login with invalid email id or not  
  Given Enter Url of SuperAdmin
  When Enter Invalid email_id and password
  And Click on Login button
  Then It should throw an alert message as Only accepts email
  
  @SystemTesting @TC_SuperAdmin_4
  Scenario: Verify whether user is able to login with Unregistered email id or not
  Given Enter Url of SuperAdmin
  When Enter Unregistered email_id
  And Click on Login button
  Then It should throw an alert message as User does not exist
  
  @SystemTesting @TC_SuperAdmin_5
  Scenario: Verify whether user is able to login with valid email id and invalid password or not
  
  Given Enter Url of SuperAdmin
  When Enter valid email_id and invalid password
  And Click on Login button
  Then It should throw an alert message as Invalid password
  
  @SystemTesting @TC_SuperAdmin_6
  Scenario: Verify password is visible or not when user clicks on Eye icon
  
  Given Enter Url of SuperAdmin
  When Enter password
  And Click on Eye icon
  Then Entered password should be visible
  
  @SystemTesting @TC_SuperAdmin_7
  Scenario: Verify password is masked or hidden when user double click on Eye icon
  
  Given Enter Url of SuperAdmin
  When Enter password
  And Double click on Eye icon
  Then Entered password should be masked
  
  @SystemTesting @TC_SuperAdmin_8
  Scenario: Verify the user is able to copy & paste the password into password textfield
  
  Given Enter Url of SuperAdmin
  When Copy and paste the value into password textfield
  Then User should be able to paste the password and password should be masked
  
  @SystemTesting @TC_SuperAdmin_9
  Scenario: Verify error message is displayed or not when username textfield is empty
  
  Given Enter Url of SuperAdmin
  And Click on Login button
  Then Error message should display as User name is required
  
  @SystemTesting @TC_SuperAdmin_10
  Scenario: Verify error message is displayed or not when password textfield is empty    
  Given Enter Url of SuperAdmin
  When Enter username
  And Click on Login button
  Then Error message should display as Password is required   
  
  @SystemTesting @TC_SuperAdmin_11
  Scenario: Verify wheather user able to navigate to forgot password window by clicking on forgot password link
  Given Enter Url of SuperAdmin  
  When Click on "Forgot Password" link
  Then "Forgot Password" Window should display  
  
  @SystemTesting @TC_SuperAdmin_12
  Scenario: Verify error message is displayed when user clicks on send link without entering email adress
  Given Enter Url of SuperAdmin  
  When Click on "Forgot Password" link
  When Click on Send Link button
  Then Error message should display as "Email Id is mandatory"
  
  @SystemTesting @TC_SuperAdmin_13
  Scenario: Verify wheather user is able to get error message while trying to put unregistered email adress on forgot password
  Given Enter Url of SuperAdmin
  When Click on "Forgot Password" link
  And Enter unregistered email address
  When Click on Send Link button
  Then Error message should display as "User does not exist."
  
  #@SystemTesting @TC_SuperAdmin_14 
  #@SystemTesting @TC_SuperAdmin_15
  
  
  #Left Navigation bar
  
  @SystemTesting @TC_SuperAdmin_16
  Scenario: Verify presence of left navigation bar with clickable buttons
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  Then Dashboard,Approver,Organization,Reports,Settings tabs should display
  
  @SystemTesting @TC_SuperAdmin_17
  Scenario: Verify whether user is able to redirect to Dashboard page by clicking on Dashboard major tab
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  When Click on Dashboard button
  Then Dashboard page should display
  
  @SystemTesting @TC_SuperAdmin_18
  Scenario: Verify whether user is able to redirect to Approver page by clicking on Approver major tab
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  When Click on Approver button
  Then Approver page should display
  
  @SystemTesting @TC_SuperAdmin_19
  Scenario: Verify whether user is able to redirect to Reports page by clicking on Reports major tab
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  When Click on Reports button
  Then Reports page should display
  
  @SystemTesting @TC_SuperAdmin_20
  Scenario: Verify presence of Person,Department,Designation,User role,Branch submodules
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  When Click on Organization button
  Then Person,Department,Designation,User role,Branch submodules should display
  
  @SystemTesting @TC_SuperAdmin_21
  Scenario: Verify presence of RequestTypes,BranchConfigurations,Templates,TemplateItems,ApprovalCondition,ApprovalWorkflow,WorkflowNode submodules
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  When Click on Settings button
  Then Above mentioned sub modules should display  
  
  @SystemTesting @TC_SuperAdmin_22
  Scenario: Verify whether user is able to redirect to Person page by clicking on Person sub module
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Person button
  Then Person page should display
  
  @SystemTesting @TC_SuperAdmin_23
  Scenario: Verify whether user is able to redirect to Department page by clicking on Department sub module
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Department button
  Then Department page should display
  
  @SystemTesting @TC_SuperAdmin_24
  Scenario: Verify whether user is able to redirect to Designation page by clicking on Designation sub module
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Designation button
  Then Designation page should display
  
  @SystemTesting @TC_SuperAdmin_25
  Scenario: Verify whether user is able to redirect to Membership page by clicking on UserRole sub module
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on UserRole button
  Then User Role page should display
  
  @SystemTesting @TC_SuperAdmin_26
  Scenario: Verify whether user is able to redirect to Branch page by clicking on Branch sub module
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  Then Branch page should display
  
  @SystemTesting @TC_SuperAdmin_27
  Scenario: Verify whether user is able to redirect to RequestType Page by clicking on RequestType sub module
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  When Click on Settings button
  When Click on Request Type button
  Then Request Type page should display
  
  @SystemTesting @TC_SuperAdmin_28
  Scenario: Verify whether user is able to redirect to BranchConfiguration page by clicking on BranchConfiguration sub module
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  When Click on Settings button
  When Click on Branch Configuration button
  Then Branch Configuration page should display
  
  @SystemTesting @TC_SuperAdmin_29
  Scenario: Verify whether user is able to redirect to Templates page by clicking on Templates sub module
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  When Click on Settings button
  When Click on Templates button
  Then Templates page should display
  
  @SystemTesting @TC_SuperAdmin_30
  Scenario: Verify whether user is able to redirect to TemplateItems page by clicking on TemplateItems sub module
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  When Click on Settings button
  When Click on Template Items button
  Then Template Items page should display
  
  @SystemTesting @TC_SuperAdmin_31
  Scenario: Verify whether user is able to redirect to ApprovalCondition page by clicking on ApprovalCondition sub module
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  When Click on Settings button
  When Click on Approval Condition button
  Then Approval Condition page should display
  
  @SystemTesting @TC_SuperAdmin_32
  Scenario: Verify whether user is able to redirect to ApprovalWorkflow page by clicking on ApprovalWorkflow sub module
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  When Click on Settings button
  When Click on Approval Workflow button
  Then Approval Workflow page should display
  
  @SystemTesting @TC_SuperAdmin_33
  Scenario: Verify whether user is able to redirect to Workflow Node page by clicking on Workflow Node sub module
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  When Click on Settings button
  When Click on Workflow Node button
  Then Workflow Node page should display
  
  #Top Profile Bar
    
  @SystemTesting @TC_SuperAdmin_34
  Scenario: Verify presence of UserProfilePicture with userName,switchLanguage options in top profile bar
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  Then UserProfilePicture should display with Name
  
  @SystemTesting @TC_SuperAdmin_35
  Scenario: Verify whether the user is able to see the Top profile bar options
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on top profile
  Then Home,Profile,Switch language,Company Profile,Logout options should display
  
  @SystemTesting @TC_SuperAdmin_36
  Scenario: Verify whether user is able to redirect to Dashboard page by clicking on the Home button
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on top profile
  When Click on Home button
  Then Dashboard page should display
  
  @SystemTesting @TC_SuperAdmin_37
  Scenario: Verify whether user is able to redirect to user profile page by clicking on the Profile button
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on top profile
  When Click on Profile button
  Then User profile page should display
  
  @SystemTesting @TC_SuperAdmin_38
  Scenario: Verify Below mentioned options are displayed in User profile page
  #1. First name 2. Last name 3. Nick name 4. Email 5. Gender 6.Phone number with country code
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on top profile
  When Click on Profile button
  Then Above mentioned options should display in User profile page
  
  @SystemTesting @TC_SuperAdmin_39
  Scenario: Verify whether user is able to redirect to CompanyProfile page by clicking on the CompanyProfile button
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on top profile
  When Click on CompanyProfile button
  Then CompanyProfile page should display
  
  @SystemTesting @TC_SuperAdmin_40
  Scenario: Verify Below mentioned options are displayed in CompanyProfile page
  #1. Company name 2. Industry Type 3. Company Size 4. Code 5. Registration Number 6. Email
  #7. Phone number with country code 8. Address 9. Country 10. State 11. City 12. Zip Code
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on top profile
  When Click on CompanyProfile button
  Then Above mentioned options should display in Company Profile page
  
  @SystemTesting @TC_SuperAdmin_41
  Scenario: Verify whether user is able to redirect to login page by clicking on the logout button
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on top profile
  When Click on Logout button
  Then Login Page should display
  
  @SystemTesting @TC_SuperAdmin_42
  Scenario: Verify whether the user is able to view language options by clicking on SwitchLanguage button
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on top profile
  #And Click on tricolon button
  When Click on SwitchLanguage button
  Then English,Spanish,Chinese languages should display in new window
  
  #TC_SuperAdmin_43
  
  #DashBoard
  
  @SystemTesting @TC_SuperAdmin_44
  Scenario: Verify Dashboard page contains below mentioned sub tabs
  #1.Pending 2.Approved 3.Rejected 4.Cancelled
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  When Click on Dashboard button
  Then Dashboard page should contains above mentioned sub tabs
  
  @SystemTesting @TC_SuperAdmin_45
  Scenario: Verify whether pending requests count is displaying in dashboard page or not
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  When Click on Dashboard button
  Then Pending requests count should display in dashboard page
  
  @SystemTesting @TC_SuperAdmin_46
  Scenario: Verify whether approved requests count is displaying in dashboard page or not
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  When Click on Dashboard button
  Then Approved requests count should display in dashboard page
  
  @SystemTesting @TC_SuperAdmin_47
  Scenario: Verify whether rejected requests count is displaying in dashboard page or not
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  When Click on Dashboard button
  Then Rejected requests count should display in dashboard page
  
  @SystemTesting @TC_SuperAdmin_48
  Scenario: Verify whether cancelled requests count is displaying in dashboard page or not
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  When Click on Dashboard button
  Then Cancelled requests count should display in dashboard page
  
  @SystemTesting @TC_SuperAdmin_49
  Scenario: Verify only Pending requests are displaying in Pending requests page
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  When Click on Dashboard button
  And Click on Pending request tab
  Then Only Pending requests should display in Pending request page
  
  @SystemTesting @TC_SuperAdmin_50
  Scenario: Verify only Approved requests are displaying in Approved requests page
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  When Click on Dashboard button
  And Click on Approved request tab
  Then Only Approved requests should display in Approved request page
  
  @SystemTesting @TC_SuperAdmin_51
  Scenario: Verify only Approved requests are displaying in Rejected requests page
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  When Click on Dashboard button
  And Click on Rejected request tab
  Then Only Rejected requests should display in Rejected request page
  
  @SystemTesting @TC_SuperAdmin_52
  Scenario: Verify only Approved requests are displaying in Cancelled requests page
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  When Click on Dashboard button
  And Click on Cancelled request tab
  Then Only Cancelled requests should display in Cancelled request page
  
  @SystemTesting @TC_SuperAdmin_53
  Scenario: verify Branch,Request type and status of request are displaying in Pending request page
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  #When Click on Dashboard button
  And Click on Pending request tab
  Then Branch,RequestType and Status of request headers should display
  
  @SystemTesting @TC_SuperAdmin_54
  Scenario: verify Branch,Request type and status of request are displaying in Approved request page
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  #When Click on Dashboard button
  And Click on Approved request tab
  Then Branch,RequestType and Status of request headers should display
  
  @SystemTesting @TC_SuperAdmin_55
  Scenario: verify Branch,Request type and status of request are displaying in Rejected request page
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  #When Click on Dashboard button
  And Click on Rejected request tab
  Then Branch,RequestType and Status of request headers should display
  
  @SystemTesting @TC_SuperAdmin_56
  Scenario: verify Branch,Request type and status of request are displaying in Cancelled request page
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  #When Click on Dashboard button
  And Click on Cancelled request tab
  Then Branch,RequestType and Status of request headers should display
  
  #Approver
  
  #@SystemTesting @TC_SuperAdmin_57
  #Scenario: Verify Below mentioned Headers are displayed in Approver page
  #1.Name 2.Request Type 3.Branch 4.Employee 5.Status 6.Creation Date 7.Description 8.Actions
    #
  #Given Enter Url of SuperAdmin
  #When Enter username and password of Super Admin
  #And Click on Login button
  #When Click on Approver button
  #Then Above mentioned Headers should display in Approver page
  
  
  #Reports 78 to 83
  
  #@SystemTesting @TC_SuperAdmin_78
  #Scenario: Verify Below mentioned Subtabs are displayed in Reports page
  #1.Approved 2.Rejected 3.Cancelled
  #
  #Given Enter Url of SuperAdmin
  #When Enter username and password of Super Admin
  #And Click on Login button
  #When Click on Reports button
  #Then Approved,Rejected,Cancelled subtabs should display in Reports page
  #
  #@SystemTesting @TC_SuperAdmin_79
  #Scenario: Verify Below mentioned headers are displayed or not when user click on Approved sub tab
  #1.Branch 2.Request Type 3.Status
  #
  #Given Enter Url of SuperAdmin
  #When Enter username and password of Super Admin
  #And Click on Login button
  #When Click on Reports button
  #When Click on Approved tab in reports page
  #Then Branch,Request Type,Status headers should display
  #
  #@SystemTesting @TC_SuperAdmin_80
  #Scenario: Verify whether only approved request are displayed in Approved Request page  
  #Given Enter Url of SuperAdmin
  #When Enter username and password of Super Admin
  #And Click on Login button
  #When Click on Reports button
  #When Click on Approved tab in reports page
  #Then Only approved request should display in Approved Request page
  #
  #
  #@SystemTesting @TC_SuperAdmin_81
  #Scenario: Verify whether only rejected request are displayed in Rejected Request page  
  #Given Enter Url of SuperAdmin
  #When Enter username and password of Super Admin
  #And Click on Login button
  #When Click on Reports button
  #When Click on Rejected tab in reports page
  #Then Only Rejected request should display in Rejected Request page 
  #
  #@SystemTesting @TC_SuperAdmin_82
  #Scenario: Verify Below mentioned headers are displayed or not when user click on Cancelled sub tab
  #1.Branch 2.Request Type 3.Status
  #
  #Given Enter Url of SuperAdmin
  #When Enter username and password of Super Admin
  #And Click on Login button
  #When Click on Reports button
  #When Click on Cancelled tab in reports page
  #Then Branch,Request Type,Status headers should display
  #
  #@SystemTesting @TC_SuperAdmin_83
  #Scenario: Verify whether only Cancelled request are displayed in Cancelled Request page  
  #Given Enter Url of SuperAdmin
  #When Enter username and password of Super Admin
  #And Click on Login button
  #When Click on Reports button
  #When Click on Cancelled tab in reports page
  #Then Only Cancelled request should display in Cancelled Request page 
     
  
  #Organization-Branch
  
  @SystemTesting @TC_SuperAdmin_192
  Scenario: Verify Add button is present or not in Branch page
    
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  Then Add button should be present in Branch Page
  
  @SystemTesting @TC_SuperAdmin_193
  Scenario: Verify Add branch window is displayed or not by clicking on Add button in Branch page
      
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And Click on Add button in Branch Page
  Then Add branch window should display
  
  @SystemTesting @TC_SuperAdmin_194
  Scenario: Verify presence of below mentioned options in Add branch page under User profile
  #1. first name 2.last name 3. email
      
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And Click on Add button in Branch Page
  Then Above mentioned options should display under User profile
  
  @SystemTesting @TC_SuperAdmin_195
  Scenario: Verify presence of below mentioned options in Add branch page under Company profile
  #1. Company Name 2.Country
      
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And Click on Add button in Branch Page
  Then Above mentioned options should display under company profile
  
  @SystemTesting @TC_SuperAdmin_196
  Scenario: Verify presence of submit and cancel buttons in Add branch page
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And Click on Add button in Branch Page
  Then Submit and Cancel buttons should be present in Add branch page
 
  @SystemTesting @TC_SuperAdmin_197
  Scenario: Verify whether user is able to add branch or not
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And Click on Add button in Branch Page
  And Enter User profile and Company profile details
  And Click on Submit button
  Then Success message should display as "Branch Created Successfully"
  
  @SystemTesting @TC_SuperAdmin_198  
  Scenario: Verify whether user is able to add branch or not
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And Click on Add button in Branch Page
  And Enter User profile and Company profile details
  And Click on Submit button
  Then Verify created branch is displaying in branch page or not
  
  @SystemTesting @TC_SuperAdmin_199
  Scenario: Verify whether user is able to cancel in Add branch page
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And Click on Add button in Branch Page
  And Enter User profile and Company profile details
  And Click on Cancel button
  Then It should cancel and redirect to Branch page
  
  @SystemTesting @TC_SuperAdmin_200
  Scenario: Verify firstName text field is mandatory or not in Add branch page
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And Click on Add button in Branch Page
  And Click on Submit button
  Then Error message should display as First name is mandatory
  
  @SystemTesting @TC_SuperAdmin_201
  Scenario: Verify email text field is mandatory or not in Add branch page
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And Click on Add button in Branch Page
  And Do not enter email into Email text field
  And Click on Submit button
  Then Error message should display as Email is mandatory
  
  @SystemTesting @TC_SuperAdmin_202
  Scenario: Verify Company name text field is mandatory or not in Add branch page
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And Click on Add button in Branch Page
  And Do not enter companyName into companyName text field
  And Click on Submit button
  Then Error message should display as Branch name is mandatory

  @SystemTesting @TC_SuperAdmin_203
  Scenario: Verify Country dropDown is mandatory or not in Add branch page
    
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And Click on Add button in Branch Page
  And Do not select Country
  And Click on Submit button
  Then Error message should display as Country is mandatory
  
  @SystemTesting @TC_SuperAdmin_204
  Scenario: Verify last name text field is not mandatory in Add branch page
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And Click on Add button in Branch Page
  And Enter data into all mandatory fields and do not enter data into last name textfield
  And Click on Submit button
  Then Admin should be able to add Branch without last name
  
  @SystemTesting @TC_SuperAdmin_205
  Scenario: Verify  error message is displayed or not when user enter invalid data into first name text field 
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And Click on Add button in Branch Page
  And Enter invalid data into first name text field
  And Click on Submit button
  Then Error message should display as "Please enter valid First Name"
  
  @SystemTesting @TC_SuperAdmin_206
  Scenario: Verify  error message is displayed or not when user enter invalid id into email text field
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And Click on Add button in Branch Page
  And Enter invalid id into Email text field
  And Click on Submit button
  Then Error message should display as "Invalid Email"
  
  @SystemTesting @TC_SuperAdmin_207
  Scenario: verify whether super admin is able to view list of all branches
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  Then Added branch should list in Branch page
  
  @SystemTesting @TC_SuperAdmin_208
  Scenario: Verify User is able to move to Update branch Popup by clicking on Edit button in branch page
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And click on Edit button of any one branch
  Then "Edit Branch" page should display
  
  @SystemTesting @TC_SuperAdmin_209
  Scenario: Verify Below mentioned options should be present and editable in Update Branch page
  #1.Company Name 2.Industry Type 3.Select Country 4. State 5.City 6.Zip Code
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And click on Edit button of any one branch
  Then Above mentioned components should be present and enabled in Edit branch page
  
  @SystemTesting @TC_SuperAdmin_210
  Scenario: verify whether super admin is able to edit branch
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And click on Edit button of any one branch
  And Change company name
  And Click on Submit button
  Then Success message should display as "Branch Updated Successfully"  
  
  @SystemTesting @TC_SuperAdmin_211
  Scenario: Verify whether super admin is able to view edited branch in branch page
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And click on Edit button of any one branch
  And Change company name
  And Click on Submit button
  Then Updated branch should display in branch page
  
  @SystemTesting @TC_SuperAdmin_212
  Scenario: verify whether super admin is able to deactivate branch
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And Click on Deactivate button
  And Click on Deactivate button Deactivate confirmation popup
  Then Success message should display as "Branch Deactivated Successfully"  
  
  @SystemTesting @TC_SuperAdmin_213
  Scenario: Verify branch is removed from branch page or not when super admin deactivate the branch
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And Click on Deactivate button
  And Click on Deactivate button Deactivate confirmation popup
  Then Deactivated branch should be removed from the branch page
  
  @SystemTesting @TC_SuperAdmin_214
  Scenario: Verify when super admin able to update branch admin
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And click on Update admin button of any one branch
  And Enter mandatory fields in Update admin page
  And Click on Submit button
  Then Success message should display as "Branch admin updated."  
  
  @SystemTesting @TC_SuperAdmin_215
  Scenario: Verify when super admin able to get error message while updating branch with invalid email adress.
   
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And click on Update admin button of any one branch
  And Enter invalid emaild id in Update admin page
  And Click on Submit button
  Then Error message should display as "Invalid Email"  
  
  @SystemTesting @TC_SuperAdmin_216
  Scenario: Verify when super admin able to get error message while updating branch with invalid First name
     
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And click on Update admin button of any one branch
  And Enter invalid first name in Update admin page
  And Click on Submit button
  Then Error message should display as "Please enter valid First Name"
  
  @SystemTesting @TC_SuperAdmin_217
  Scenario: Verify when super admin able to get error message while updating branch without filling mandatory field.
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Organization button
  When Click on Branch button
  And click on Update admin button of any one branch
  And Click on Submit button
  Then Error message should display as "First name is mandatory"
  And Enter only first name in Update admin page
  And Click on Submit button
  Then Error message should display as "Email is mandatory"
  
  #@SystemTesting @TC_SuperAdmin_218
  #Scenario: Verify wheather updated branch admin getting Email notification for appointed as branch owner.
  
  #//Settings-Request-Type
  
  @SystemTesting @TC_SuperAdmin_219
  Scenario: Verify wheather user able to create the following types of request
  #1.BUDGET 2.EXTRABUDGET 3.HR
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Settings button
  When Click on Request Type button
  Then User should be able to create "BUDGET" request type
  Then User should be able to create "EXTRABUDGET" request type
  Then User should be able to create "HR" request type
  Then User should not be able to create other than above request types
  
  @SystemTesting @TC_SuperAdmin_220
  Scenario: Verify wheather Super admin is able to Update request Type.
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Settings button
  When Click on Request Type button
  When Click on Edit button
  And Edit code and name
  Then Updated request type should display in request type list 
    
  @SystemTesting @TC_SuperAdmin_221
  Scenario: Verify wheather Super admin able to get success message after Updating the request Type.
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Settings button
  When Click on Request Type button
  When Click on Edit button
  And Edit code and name
  Then Success message should display as "Request Type Updated Successfully"
  
  @SystemTesting @TC_SuperAdmin_222
  Scenario: Verify wheather Super admin able to delete the request Type.
      
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Settings button
  When Click on Request Type button
  Then User should be able to create "BUDGET" request type
  Then Click on delete button of request type which is not in use
  Then Request type should be deleted
    
  @SystemTesting @TC_SuperAdmin_223
  Scenario: Verify  wheather Super admin is able to get success message as "Request type deleted successfully" after deleting  the  Request Type.
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Settings button
  When Click on Request Type button
  Then User should be able to create "BUDGET" request type
  Then Click on delete button of request type which is not in use
  Then Success message should display as "Request Type Deleted Successfully" 
  
  @SystemTesting @TC_SuperAdmin_224
  Scenario: Verify  wheather Super admin able to get error  message while deleting  the  request Type that is mapped to Approval Workflow 
   
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Settings button
  When Click on Request Type button
  Then User should be able to create "BUDGET" request type
  And Click on Settings button
  When Create a Approval Workflow  
  And Click on Settings button
  And Click on Settings button
  When Click on Request Type button
  Then Click on delete button of request type which is mapped to Approval Workflow 
  Then Error message should display as "Request type can't be deleted since it is in use"
  
  @SystemTesting @TC_SuperAdmin_225
  Scenario: Verify wheather user is unable to create other than 
  #1.BUDGET 2.EXTRABUDGET 3.HR request type
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Settings button
  When Click on Request Type button
  Then User should not be able to create other than above request types
  
  @SystemTesting @TC_SuperAdmin_226
  Scenario: Verify whether code is mandatory or not to create "Request Types"
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Settings button
  When Click on Request Type button
  And Click on Add button in Request Types page
  And Click on submit button without entering code in Create Request Type page
  Then Error message should display as "Code is mandatory"
  
  @SystemTesting @TC_SuperAdmin_227
  Scenario: Verify whether name is mandatory or not to create "Request Types"
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Settings button
  When Click on Request Type button
  And Click on Add button in Request Types page
  And Click on submit button without entering name in Create Request Type page
  Then Error message should display as "Name is mandatory"
  
  @SystemTesting @TC_SuperAdmin_228
  Scenario: Verify Description is not mandatory to create Request Type
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Settings button
  When Click on Request Type button
  And Click on Add button in Request Types page
  And Click on submit button without entering Description in Create Request Type page
  Then Success message should display as "Request Type Created Successfully"
  
  @SystemTesting @TC_SuperAdmin_229
  Scenario: Verify wheather Super admin is able to create branch configuration
    
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Settings button
  When Click on Branch Configuration button
  And Click on Add button in Branch configuration page
  And Select a branch
  And Select a Request Type
  And Enter Approval criteria in Approval criteria text field
  And Click on Submit button
  Then Success message should display as "Branch Configuration Created Successfully"
  
  
  # Codes from Line No 1032 are Added By Sambit on 09-nov-2022
  # Settings -> Approval Workflow
  
  @SystemTesting @TC_SuperAdmin_263 @Settings
  Scenario: Verify wheather super admin is able to create approval workflow
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Settings button
  And Click on "Approval Workflow" Submodule
  And I click on the Add icon
  And I add Data to all the Fields
  And I click on Submit button
  Then I should get a Popup Message as "Approval Workflow Created Successfully"
  And The data should display in the Approval Workflow Dashboard
  
  @SystemTesting @TC_SuperAdmin_264 @Settings
  Scenario: Verify Super Admin is able to Update the Approval Workflow
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Settings button
  And Click on "Approval Workflow" Submodule
  And I click on the Edit Icon
  And I edit all data in Edit Approval Workflow Window
  And I click on Submit button
  Then I should get a Popup Message as "Approval Workflow Updated Successfully"
  And The Edited data should display in Approval workflow Dashboard
  
  @SystemTesting @TC_SuperAdmin_265
  Scenario: Verify wheather Approval workflow created automatically while user creating request type.
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Settings button
  When Click on Request Type button
  And Click on Add button in Request Types page
  And I Add data to all the Fields of create Request type Page
  And I click on Submit button
  Then the Same Request type should be Reflect in the Approval workflow Dashboard
  
  @SystemTesting @TC_SuperAdmin_266
  Scenario: Verify wheather super admin is able to get warning message Approval workflow cannot be deleted since it is in use
  while trying to delete approval workflow.
  
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Settings button
  When Click on Request Type button
  And Click on Add button in Request Types page
  And I Add data to all the Fields of create Request type Page
  And I click on Submit button
  And Click on "Approval_Workflow" Submodule
  And I click on the Delete icon
  And I click on Ok button
  Then I should get a Popup Message as "Approval workflow can't be deleted since it is in use" 
  
  @SystemTesting @TC_SuperAdmin_268 @Settings
  Scenario: Verify Super Admin is able to Delete the Approval Workflow
  Given Enter Url of SuperAdmin
  When Enter username and password of Super Admin
  And Click on Login button
  And Click on Settings button
  And Click on "Approval_Workflow" Submodule
  And I click on the Delete icon
  And I click on Ok button
  Then I should get a Popup Message as "Approval Workflow Deleted Successfully"
  And The Data should remove from Approval workflow Dashboard
  
  
  
  