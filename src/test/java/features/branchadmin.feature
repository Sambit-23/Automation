#
#@BranchAdmin
#Feature: BranchAdmin
#
#LOGIN
   #
  #@TC_BranchAdmin_1
  #Scenario: Verify Branch Admin is able to enter login credentials or not   
  #Given Enter Url of BranchAdmin
  #When Enter username and password of BranchAdmin
  #Then Branch admin should be able to enter login credentials
  #
  #@TC_BranchAdmin_2
  #Scenario: Verify Company page is displayed or not
  #Given Enter Url of BranchAdmin
  #When Enter username and password of BranchAdmin
  #And Click on Login button
  #Then Company page should display
  #
  #@TC_BranchAdmin_3
  #Scenario: Verify Branch Admin is able to enter Company name or not
  #Given Enter Url of BranchAdmin
  #When Enter username and password of BranchAdmin
  #And Click on Login button
  #When Select Company name
  #Then Branch admin should be able to select Company name
  #
  #@TC_BranchAdmin_4
  #Scenario: Verify Branch Admin is able to login to application
  #Given Enter Url of BranchAdmin
  #When Enter username and password of BranchAdmin
  #And Click on Login button
  #When Select Company name
  #And Click on continue button
  #Then Branch Admin should be able to login to application
  #
  #@TC_BranchAdmin_5
  #Scenario: Verify Branch Admin is able to get error message by clicking on continue button without selecting company code
  #Given Enter Url of BranchAdmin
  #When Enter username and password of BranchAdmin
  #And Click on Login button
  #And Click on continue button
  #Then Error message should display as "Company id or company code is required"
  