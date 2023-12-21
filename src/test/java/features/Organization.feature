@Organization @Regression
Feature: Person and Employee Filter Organization Service V3 API Testing

  @PC @Smoke @personFilter
  Scenario: Generate client token
    Given payload to generate a client token
    When user calls generate client token API with POST http request
    Then validate response code and response message for successfull generation of client token

  @SC @Smoke @personFilter
  Scenario: Generate company token
    Given payload to generate a company token
    And user calls generate company token API with POST http request
    Then validate response code and response message for successfull generation of company token

  @TC_001 @Smoke @Sanity @PersonCreation @personFilter
  Scenario: Verify Person with person type of Employee create is successfull when all required parameter data's are provided
    Given payload to create a Person with person type of employee by providing all required parameter datas
    When user calls create Person API with POST http request
    Then validate response code and response message for successfull Person creation with person type of employee

  @TC_002 @Smoke @Sanity @PersonCreationWithUserId @personFilter
  Scenario: Verify Person with person type of Employee create is successfull when all required parameter data's are provided and createUser as True
    Given payload to create a Person with person type of employee by providing all required parameter datas and createUser as true
    When user calls create Person API with POST http request
    Then validate response code and response message for successfull Person creation with person type of employee with userId

    #PersonFilter

  @TC_01 @personFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Person by the Employee id
    Given payload to filter a Employee by EmployeeId
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_02 @personFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Person by the First Name
    Given payload to filter a Person by FirstName
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_03 @personFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Person by the Last Name
    Given payload to filter a Person by LastName
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_04 @personFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Person by the Email Id
    Given payload to filter a Person by Email
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_05 @personFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Person by the Phone
    Given payload to filter a Person by Phone
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_06 @personFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Person by the Person Code
    Given payload to filter a Person by Person Code
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_07 @personFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Person by the Employee type
    Given payload to filter a Person by Employee Type
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_08 @personFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Person by the User Id
    Given payload to filter a Person by UserId
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_09 @personFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Person by the Validity Time
    Given payload to filter a Person by ValidityTime
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_10 @personFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Person by the Page Number
    Given payload to filter a Person by Page Number
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_11 @personFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Person by the Page Size
    Given payload to filter a Person by Page Size
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_12 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfull by passing invalid employeeid
    Given payload to filter a Person by passing invalid employeeId
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_13 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfull by passing invalid firstname
    Given payload to filter a Person by passing invalid firstname
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_14 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfull by passing invalid lastname
    Given payload to filter a Person by passing invalid lastname
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_15 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfull by passing invalid phone number
    Given payload to filter a Person by passing invalid phone
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_16 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfull by passing invalid person code
    Given payload to filter a Person by passing invalid code
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_17 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfull by passing invalid emailId
    Given payload to filter a Person by passing invalid emailId
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_18 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfull by passing invalid person type
    Given payload to filter a Person by passing invalid persontype
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_19 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfull by passing invalid userId
    Given payload to filter a Person by passing invalid userId
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_20 @personFilter @Smoke @Sanity
  Scenario: verify that user can  able to get list of personwith Acending order
    Given payload to filter list of Person by Ascending Order
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_21 @personFilter @Smoke @Sanity
  Scenario: verify that user can  able to get list of personwith Descending order
    Given payload to filter list of Person by Descending Order
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_22 @personFilter @Smoke @Sanity
  Scenario: verify that user can  able to get  list of  employeeby passing multiple employeeid
    Given payload to filter a Person by Multiple Employee Id
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_23 @personFilter @Smoke @Sanity
  Scenario: verify that user can  able to get  list of  employeeby passing multiple userId
    Given payload to filter a Person by Multiple User Id
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_24 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both employeeid and firstname with operator AND
    Given payload to filter a Person by "EmployeeId" AND "FirstName" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_25 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both employeeid and lastname with operator AND
    Given payload to filter a Person by "EmployeeId" AND "LastName" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_26 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both employeeid and phone with operator AND
    Given payload to filter a Person by "EmployeeId" AND "Phone" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_27 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both employeeid and email with operator AND
    Given payload to filter a Person by "EmployeeId" AND "Email" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_28 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both employeeid and personCode with operator AND
    Given payload to filter a Person by "EmployeeId" AND "PersonCode" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_29 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both employeeid and personType with operator AND
    Given payload to filter a Person by "EmployeeId" AND "PersonType" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_30 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both employeeid and userId with operator AND
    Given payload to filter a Person by "EmployeeId" AND "UserId" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_31 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both FirstName and employeeId with operator AND
    Given payload to filter a Person by "FirstName" AND "EmployeeId" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_32 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both FirstName and lastname with operator AND
    Given payload to filter a Person by "FirstName" AND "LastName" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_33 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both FirstName and phone with operator AND
    Given payload to filter a Person by "FirstName" AND "Phone" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_34 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both FirstName and email with operator AND
    Given payload to filter a Person by "FirstName" AND "Email" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_35 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both FirstName and PersonCode with operator AND
    Given payload to filter a Person by "FirstName" AND "PersonCode" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_36 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both FirstName and PersonType with operator AND
    Given payload to filter a Person by "FirstName" AND "PersonType" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_37 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both FirstName and userId with operator AND
    Given payload to filter a Person by "FirstName" AND "UserId" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_38 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both LastName and employeeid with operator AND
    Given payload to filter a Person by "LastName" AND "EmployeeId" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_39 @personFilterv @Smoke @Sanity
  Scenario: verify filter of person is successfull by both LastName and firstname with operator AND
    Given payload to filter a Person by "LastName" AND "FirstName" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_40 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both LastName and phone with operator AND
    Given payload to filter a Person by "LastName" AND "Phone" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_41 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both LastName and email with operator AND
    Given payload to filter a Person by "LastName" AND "Email" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_42 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both LastName and personCode with operator AND
    Given payload to filter a Person by "LastName" AND "PersonCode" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_43 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both LastName and personType with operator AND
    Given payload to filter a Person by "LastName" AND "PersonType" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_44 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both LastName and userId with operator AND
    Given payload to filter a Person by "LastName" AND "UserId" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_45 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Phone and employeeId with operator AND
    Given payload to filter a Person by "Phone" AND "EmployeeId" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_46 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Phone and firstname with operator AND
    Given payload to filter a Person by "Phone" AND "FirstName" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_47 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Phone and lastname with operator AND
    Given payload to filter a Person by "Phone" AND "LastName" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_48 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Phone and email with operator AND
    Given payload to filter a Person by "Phone" AND "Email" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_49 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Phone and personCode with operator AND
    Given payload to filter a Person by "Phone" AND "PersonCode" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_50 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Phone and PersonType with operator AND
    Given payload to filter a Person by "Phone" AND "PersonType" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_51 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Phone and userId with operator AND
    Given payload to filter a Person by "Phone" AND "UserId" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_52 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Email and employeeId with operator AND
    Given payload to filter a Person by "Email" AND "EmployeeId" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_53 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Email and firstname with operator AND
    Given payload to filter a Person by "Email" AND "FirstName" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_54 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Email and lastname with operator AND
    Given payload to filter a Person by "Email" AND "LastName" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_55 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Email and phone with operator AND
    Given payload to filter a Person by "Email" AND "Phone" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_56 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Email and PersonCode with operator AND
    Given payload to filter a Person by "Email" AND "PersonCode" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_57 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Email and personType with operator AND
    Given payload to filter a Person by "Email" AND "PersonType" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_58 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Email and userId with operator AND
    Given payload to filter a Person by "Email" AND "UserId" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_59 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonCode and employeeId with operator AND
    Given payload to filter a Person by "PersonCode" AND "EmployeeId" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_60 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonCode and firstname with operator AND
    Given payload to filter a Person by "PersonCode" AND "FirstName" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_61 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonCode and lastname with operator AND
    Given payload to filter a Person by "PersonCode" AND "LastName" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_62 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonCode and phone with operator AND
    Given payload to filter a Person by "PersonCode" AND "Phone" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_63 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonCode and email with operator AND
    Given payload to filter a Person by "PersonCode" AND "Email" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_64 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonCode and personType with operator AND
    Given payload to filter a Person by "PersonCode" AND "PersonType" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_65 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonCode and userId with operator AND
    Given payload to filter a Person by "PersonCode" AND "UserId" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_66 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonType and employeeId with operator AND
    Given payload to filter a Person by "PersonType" AND "EmployeeId" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_67 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonType and firstname with operator AND
    Given payload to filter a Person by "PersonType" AND "FirstName" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_68 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonType and lastname with operator AND
    Given payload to filter a Person by "PersonType" AND "LastName" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_69 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonType and phone with operator AND
    Given payload to filter a Person by "PersonType" AND "Phone" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_70 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonType and email with operator AND
    Given payload to filter a Person by "PersonType" AND "Email" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_71 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonType and personCode with operator AND
    Given payload to filter a Person by "PersonType" AND "PersonCode" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_72 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonType and userId with operator AND
    Given payload to filter a Person by "PersonType" AND "UserId" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_73 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both userid and employeeId with operator AND
    Given payload to filter a Person by "UserId" AND "EmployeeId" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_74 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both userId and firstname with operator AND
    Given payload to filter a Person by "UserId" AND "FirstName" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_75 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both userId and lastname with operator AND
    Given payload to filter a Person by "UserId" AND "LastName" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_76 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both userId and phone with operator AND
    Given payload to filter a Person by "UserId" AND "Phone" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_77 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both userId and email with operator AND
    Given payload to filter a Person by "UserId" AND "Email" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_78 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both userId and personCode with operator AND
    Given payload to filter a Person by "UserId" AND "PersonCode" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_79 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both userId and personType with operator AND
    Given payload to filter a Person by "UserId" AND "PersonType" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_80 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid First Name and invalid employeeid with operator as AND
    Given payload to filter a Person by valid "FirstName" AND invalid "PersonId"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_81 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid First Name and invalid Last Name with operator as AND
    Given payload to filter a Person by valid "FirstName" AND invalid "LastName"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_82 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid First Name and invalid PersonCode with operator as AND
    Given payload to filter a Person by valid "FirstName" AND invalid "PersonCode"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_83 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid First Name and invalid Phone with operator as AND
    Given payload to filter a Person by valid "FirstName" AND invalid "Phone"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_84 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid First Name and invalid Email with operator as AND
    Given payload to filter a Person by valid "FirstName" AND invalid "Email"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_85 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid First Name and invalid PersonType with operator as AND
    Given payload to filter a Person by valid "FirstName" AND invalid "PersonType"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_86 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid First Name and invalid UserId with operator as AND
    Given payload to filter a Person by valid "FirstName" AND invalid "UserId"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_87 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid employeeid and invalid FirstName with operator as AND
    Given payload to filter a Person by valid "PersonId" AND invalid "FirstName"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_88 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid employeeid and invalid LastName with operator as AND
    Given payload to filter a Person by valid "PersonId" AND invalid "LastName"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_89 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid employeeid and invalid PersonCode with operator as AND
    Given payload to filter a Person by valid "PersonId" AND invalid "PersonCode"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_90 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid employeeid and invalid Phone with operator as AND
    Given payload to filter a Person by valid "PersonId" AND invalid "Phone"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_91 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid employeeid and invalid Email with operator as AND
    Given payload to filter a Person by valid "PersonId" AND invalid "Email"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_92 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid employeeid and invalid PersonType with operator as AND
    Given payload to filter a Person by valid "PersonId" AND invalid "PersonType"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_93 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid employeeid and invalid UserId with operator as AND
    Given payload to filter a Person by valid "PersonId" AND invalid "UserId"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_94 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid lastName and invalid FirstName with operator as AND
    Given payload to filter a Person by valid "LastName" AND invalid "FirstName"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_95 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid lastName and invalid EmployeeId with operator as AND
    Given payload to filter a Person by valid "LastName" AND invalid "PersonId"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_96 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid lastName and invalid PersonCode with operator as AND
    Given payload to filter a Person by valid "LastName" AND invalid "PersonCode"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_97 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid lastName and invalid Phone with operator as AND
    Given payload to filter a Person by valid "LastName" AND invalid "Phone"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_98 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid lastName and invalid Email with operator as AND
    Given payload to filter a Person by valid "LastName" AND invalid "Email"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_99 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid lastName and invalid PersonType with operator as AND
    Given payload to filter a Person by valid "LastName" AND invalid "PersonType"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_100 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid lastName and invalid UserId with operator as AND
    Given payload to filter a Person by valid "LastName" AND invalid "UserId"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_101 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid Phone and invalid FirstName with operator as AND
    Given payload to filter a Person by valid "Phone" AND invalid "FirstName"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_102 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid Phone and invalid EmployeeId with operator as AND
    Given payload to filter a Person by valid "Phone" AND invalid "PersonId"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_103 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid Phone and invalid PersonCode with operator as AND
    Given payload to filter a Person by valid "Phone" AND invalid "PersonCode"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_104 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid Phone and invalid LastName with operator as AND
    Given payload to filter a Person by valid "Phone" AND invalid "LastName"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_105 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid Phone and invalid Email with operator as AND
    Given payload to filter a Person by valid "Phone" AND invalid "Email"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_106 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid Phone and invalid PersonType with operator as AND
    Given payload to filter a Person by valid "Phone" AND invalid "PersonType"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_107 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid Phone and invalid UserId with operator as AND
    Given payload to filter a Person by valid "Phone" AND invalid "UserId"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_108 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid PersonCode and invalid FirstName with operator as AND
    Given payload to filter a Person by valid "PersonCode" AND invalid "FirstName"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_109 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid PersonCode and invalid EmployeeId with operator as AND
    Given payload to filter a Person by valid "PersonCode" AND invalid "PersonId"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_110 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid PersonCode and invalid lastName with operator as AND
    Given payload to filter a Person by valid "PersonCode" AND invalid "LastName"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_111 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid PersonCode and invalid Phone with operator as AND
    Given payload to filter a Person by valid "PersonCode" AND invalid "Phone"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_112 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid PersonCode and invalid Email with operator as AND
    Given payload to filter a Person by valid "PersonCode" AND invalid "Email"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_113 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid PersonCode and invalid PersonType with operator as AND
    Given payload to filter a Person by valid "PersonCode" AND invalid "PersonType"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_114 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid PersonCode and invalid UserId with operator as AND
    Given payload to filter a Person by valid "PersonCode" AND invalid "UserId"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_115 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid PersonType and invalid FirstName with operator as AND
    Given payload to filter a Person by valid "PersonType" AND invalid "FirstName"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_116 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid PersonType and invalid EmployeeId with operator as AND
    Given payload to filter a Person by valid "PersonType" AND invalid "PersonId"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_117 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid PersonType and invalid lastName with operator as AND
    Given payload to filter a Person by valid "PersonType" AND invalid "LastName"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_118 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid PersonType and invalid Phone with operator as AND
    Given payload to filter a Person by valid "PersonType" AND invalid "Phone"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_119 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid PersonType and invalid Email with operator as AND
    Given payload to filter a Person by valid "PersonType" AND invalid "Email"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_120 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid PersonType and invalid PersonType with operator as AND
    Given payload to filter a Person by valid "PersonType" AND invalid "PersonCode"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_121 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid PersonType and invalid UserId with operator as AND
    Given payload to filter a Person by valid "PersonType" AND invalid "UserId"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_122 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid Email and invalid FirstName with operator as AND
    Given payload to filter a Person by valid "Email" AND invalid "FirstName"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_123 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid Email and invalid EmployeeId with operator as AND
    Given payload to filter a Person by valid "Email" AND invalid "PersonId"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_124 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid Email and invalid lastName with operator as AND
    Given payload to filter a Person by valid "Email" AND invalid "LastName"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_125 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid Email and invalid Phone with operator as AND
    Given payload to filter a Person by valid "Email" AND invalid "Phone"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_126 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid Email and invalid Email with operator as AND
    Given payload to filter a Person by valid "Email" AND invalid "PersonCode"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_127 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid Email and invalid PersonType with operator as AND
    Given payload to filter a Person by valid "Email" AND invalid "PersonType"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_128 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid Email and invalid UserId with operator as AND
    Given payload to filter a Person by valid "Email" AND invalid "UserId"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_129 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid UserId and invalid FirstName with operator as AND
    Given payload to filter a Person by valid "UserId" AND invalid "FirstName"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_130 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid UserId and invalid EmployeeId with operator as AND
    Given payload to filter a Person by valid "UserId" AND invalid "PersonId"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_131 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid UserId and invalid lastName with operator as AND
    Given payload to filter a Person by valid "UserId" AND invalid "LastName"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_132 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid UserId and invalid Phone with operator as AND
    Given payload to filter a Person by valid "UserId" AND invalid "Phone"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_133 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid UserId and invalid Email with operator as AND
    Given payload to filter a Person by valid "UserId" AND invalid "Email"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_134 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid UserId and invalid PersonType with operator as AND
    Given payload to filter a Person by valid "UserId" AND invalid "PersonType"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_135 @personFilter @NegativeTC @Smoke
  Scenario: verify filter of person is not successfully when valid UserId and invalid UserId with operator as AND
    Given payload to filter a Person by valid "UserId" AND invalid "PersonCode"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_136 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "firstname" and case-sensitive "lastname" when case-sensitive is "false" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_137 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "firstname" and case-sensitive "PersonCode" when case-sensitive is "false" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_138 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "firstname" and case-sensitive "email" when case-sensitive is "false" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_139 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "lastname" and case-sensitive "email" when case-sensitive is "false" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_140 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "lastname" and case-sensitive "PersonCode" when case-sensitive is "false" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_141 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "firstname" and case-sensitive "lastname" when case-sensitive is "false" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_142 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "PersonCode" and case-sensitive "firstname" when case-sensitive is "false" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_143 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "PersonCode" and case-sensitive "lastname" when case-sensitive is "false" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_144 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "PersonCode" and case-sensitive "email" when case-sensitive is "false" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_145 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "Email" and case-sensitive "firstname" when case-sensitive is "false" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_146 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "email" and case-sensitive "lastname" when case-sensitive is "false" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_147 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "Email" and case-sensitive "PersonCode" when case-sensitive is "false" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_148 @personFilter @Smoke
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "firstname" and case-sensitive "lastname" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_149 @personFilter @Smoke
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "firstname" and case-sensitive "PersonCode" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_150 @personFilter @Smoke
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "firstname" and case-sensitive "Email" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_151 @personFilter @Smoke
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "lastname" and case-sensitive "Email" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_152 @personFilter @Smoke
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "lastname" and case-sensitive "PersonCode" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_153 @personFilter @Smoke
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "lastName" and case-sensitive "firstName" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_154 @personFilter @Smoke
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "PersonCode" and case-sensitive "firstname" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_155 @personFilter @Smoke
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "PersonCode" and case-sensitive "lastname" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_156 @personFilter @Smoke
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "PersonCode" and case-sensitive "Email" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for unsuccessfull fiter the person

  @TC_157 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "Email" and case-sensitive "firstname" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_158 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "Email" and case-sensitive "lastname" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_159 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a person with case-insensitive "Email" and case-sensitive "PersonCode" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_160 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "firstname" and case-sensitive "lastname" when case-sensitive is "false" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_161 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "firstname" and case-sensitive "PersonCode" when case-sensitive is "false" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_162 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "firstname" and case-sensitive "email" when case-sensitive is "false" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_163 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "lastname" and case-sensitive "email" when case-sensitive is "false" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_164 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "lastname" and case-sensitive "PersonCode" when case-sensitive is "false" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_165 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "firstname" and case-sensitive "lastname" when case-sensitive is "false" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_166 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "PersonCode" and case-sensitive "firstname" when case-sensitive is "false" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_167 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "PersonCode" and case-sensitive "lastname" when case-sensitive is "false" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_168 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "PersonCode" and case-sensitive "email" when case-sensitive is "false" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_169 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "Email" and case-sensitive "firstname" when case-sensitive is "false" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_170 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "email" and case-sensitive "lastname" when case-sensitive is "false" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_171 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "Email" and case-sensitive "PersonCode" when case-sensitive is "false" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_172 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "firstname" and case-sensitive "lastname" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_173 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "firstname" and case-sensitive "PersonCode" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_174 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "firstname" and case-sensitive "Email" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_175 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "lastname" and case-sensitive "Email" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_176 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "lastname" and case-sensitive "PersonCode" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_177 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "lastName" and case-sensitive "firstName" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_178 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "PersonCode" and case-sensitive "firstname" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_179 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "PersonCode" and case-sensitive "lastname" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_180 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "PersonCode" and case-sensitive "Email" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_181 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "Email" and case-sensitive "firstname" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_182 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "Email" and case-sensitive "lastname" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_183 @personFilter @Smoke @Sanity
  Scenario: Verify Person filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a person with case-insensitive "Email" and case-sensitive "PersonCode" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_184 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both employeeid and firstname with operator OR
    Given payload to filter a Person by "EmployeeId" AND "FirstName" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_185 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both employeeid and lastname with operator OR
    Given payload to filter a Person by "EmployeeId" AND "LastName" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_186 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both employeeid and phone with operator OR
    Given payload to filter a Person by "EmployeeId" AND "Phone" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_187 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both employeeid and email with operator OR
    Given payload to filter a Person by "EmployeeId" AND "Email" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_188 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both employeeid and personCode with operator OR
    Given payload to filter a Person by "EmployeeId" AND "PersonCode" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_189 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both employeeid and personType with operator OR
    Given payload to filter a Person by "EmployeeId" AND "PersonType" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_190 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both employeeid and userId with operator OR
    Given payload to filter a Person by "EmployeeId" AND "UserId" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_191 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both FirstName and employeeId with operator OR
    Given payload to filter a Person by "FirstName" AND "EmployeeId" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_192 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both FirstName and lastname with operator OR
    Given payload to filter a Person by "FirstName" AND "LastName" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_193 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both FirstName and phone with operator OR
    Given payload to filter a Person by "FirstName" AND "Phone" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_194 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both FirstName and email with operator OR
    Given payload to filter a Person by "FirstName" AND "Email" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_195 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both FirstName and PersonCode with operator OR
    Given payload to filter a Person by "FirstName" AND "PersonCode" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_196 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both FirstName and PersonType with operator OR
    Given payload to filter a Person by "FirstName" AND "PersonType" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_197 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both FirstName and userId with operator OR
    Given payload to filter a Person by "FirstName" AND "UserId" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_198 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both LastName and employeeid with operator OR
    Given payload to filter a Person by "LastName" AND "EmployeeId" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_199 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both LastName and firstname with operator OR
    Given payload to filter a Person by "LastName" AND "FirstName" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_200 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both LastName and phone with operator OR
    Given payload to filter a Person by "LastName" AND "Phone" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_201 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both LastName and email with operator OR
    Given payload to filter a Person by "LastName" AND "Email" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_202 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both LastName and personCode with operator OR
    Given payload to filter a Person by "LastName" AND "PersonCode" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_203 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both LastName and personType with operator OR
    Given payload to filter a Person by "LastName" AND "PersonType" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_204 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both LastName and userId with operator OR
    Given payload to filter a Person by "LastName" AND "UserId" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_205 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Phone and employeeId with operator OR
    Given payload to filter a Person by "Phone" AND "EmployeeId" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_206 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Phone and firstname with operator OR
    Given payload to filter a Person by "Phone" AND "FirstName" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_207 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Phone and lastname with operator OR
    Given payload to filter a Person by "Phone" AND "LastName" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_208 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Phone and email with operator OR
    Given payload to filter a Person by "Phone" AND "Email" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_209 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Phone and personCode with operator OR
    Given payload to filter a Person by "Phone" AND "PersonCode" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_210 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Phone and PersonType with operator OR
    Given payload to filter a Person by "Phone" AND "PersonType" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_211 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Phone and userId with operator OR
    Given payload to filter a Person by "Phone" AND "UserId" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_212 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Email and employeeId with operator OR
    Given payload to filter a Person by "Email" AND "EmployeeId" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_213 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Email and firstname with operator OR
    Given payload to filter a Person by "Email" AND "FirstName" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_214 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Email and lastname with operator OR
    Given payload to filter a Person by "Email" AND "LastName" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_215 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Email and phone with operator OR
    Given payload to filter a Person by "Email" AND "Phone" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_216 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Email and PersonCode with operator OR
    Given payload to filter a Person by "Email" AND "PersonCode" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_217 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Email and personType with operator OR
    Given payload to filter a Person by "Email" AND "PersonType" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_218 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both Email and userId with operator OR
    Given payload to filter a Person by "Email" AND "UserId" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_219 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonCode and employeeId with operator OR
    Given payload to filter a Person by "PersonCode" AND "EmployeeId" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_220 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonCode and firstname with operator OR
    Given payload to filter a Person by "PersonCode" AND "FirstName" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_221 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonCode and lastname with operator OR
    Given payload to filter a Person by "PersonCode" AND "LastName" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_222 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonCode and phone with operator OR
    Given payload to filter a Person by "PersonCode" AND "Phone" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_223 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonCode and email with operator OR
    Given payload to filter a Person by "PersonCode" AND "Email" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_224 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonCode and personType with operator OR
    Given payload to filter a Person by "PersonCode" AND "PersonType" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_225 @personFilter  @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonCode and userId with operator OR
    Given payload to filter a Person by "PersonCode" AND "UserId" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_226 @personFilter  @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonType and employeeId with operator OR
    Given payload to filter a Person by "PersonType" AND "EmployeeId" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_227 @personFilter  @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonType and firstname with operator OR
    Given payload to filter a Person by "PersonType" AND "FirstName" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_228 @personFilter  @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonType and lastname with operator OR
    Given payload to filter a Person by "PersonType" AND "LastName" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_229 @personFilter  @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonType and phone with operator OR
    Given payload to filter a Person by "PersonType" AND "Phone" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_230 @personFilter  @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonType and email with operator OR
    Given payload to filter a Person by "PersonType" AND "Email" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_231 @personFilter  @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonType and personCode with operator OR
    Given payload to filter a Person by "PersonType" AND "PersonCode" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_232 @personFilter  @Smoke @Sanity
  Scenario: verify filter of person is successfull by both PersonType and userId with operator OR
    Given payload to filter a Person by "PersonType" AND "UserId" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_233 @personFilter  @Smoke @Sanity
  Scenario: verify filter of person is successfull by both userId and employeeId with operator OR
    Given payload to filter a Person by "UserId" AND "EmployeeId" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_234 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both userId and firstname with operator OR
    Given payload to filter a Person by "UserId" AND "FirstName" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_235 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both userId and lastname with operator OR
    Given payload to filter a Person by "UserId" AND "LastName" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_236 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both userId and phone with operator OR
    Given payload to filter a Person by "UserId" AND "Phone" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_237 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both userId and email with operator OR
    Given payload to filter a Person by "UserId" AND "Email" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_238 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both userId and personCode with operator OR
    Given payload to filter a Person by "UserId" AND "PersonCode" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_239 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by both userId and personType with operator OR
    Given payload to filter a Person by "UserId" AND "PersonType" with Operator "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_240 @personFilter @Smoke @Sanity
  Scenario: verify profile photo key is not refecting in the response when togglekey is passed as true
    Given payload to filter a Person by passing toggleKeytoURL is "true"
    When user calls filter person API with POST http request
    Then validate response code and profile photo key as null

  @TC_241 @personFilter @Smoke @Sanity
  Scenario: verify profile photo key is refecting in the response when togglekey is passed as false
    Given payload to filter a Person by passing toggleKeytoURL is "false"
    When user calls filter person API with POST http request
    Then validate response code and profile photo key


   ##New Testcases##

  @TC_242 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid,firstname and last name with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "firstName" and "lastName" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_243 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid,firstname and personCode with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "firstName" and "PersonCode" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_244 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid,firstname and Phone with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "firstName" and "phone" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_245 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid,firstname and Email with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "firstName" and "email" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_246 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid,firstname and person type with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "firstName" and "personType" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_247 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid,firstname and userId with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "firstName" and "userId" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_248 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, lastname and firstname with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "lastName" and "firstName" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_249 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, lastName and personCode with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "lastName" and "PersonCode" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_250 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, lastName and Phone with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "lastName" and "phone" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_251 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, lastName and Email with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "lastName" and "email" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_252 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, lastName and person type with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "lastName" and "personType" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_253 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid,lastName and userId with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "lastName" and "userId" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_254 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonCode and firstname with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "PersonCode" and "firstName" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_255 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonCode and lastname with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "PersonCode" and "lastName" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_256 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonCode and Phone with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "PersonCode" and "phone" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_257 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonCode and Email with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "PersonCode" and "email" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_258 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonCode and person type with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "PersonCode" and "personType" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_259 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonCode and userId with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "PersonCode" and "userId" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_260 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, phone and firstname with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "phone" and "firstName" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_261 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, phone and lastname with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "phone" and "lastName" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_262 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, phone and PersonCode with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "phone" and "personCode" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_263 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, phone and Email with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "phone" and "email" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_264 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, phone and personType with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "phone" and "personType" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_265 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, phone and userId with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "phone" and "userId" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_266 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, email and firstname with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "email" and "firstName" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_267 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, email and lastname with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "email" and "lastName" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_268 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, email and Phone with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "email" and "Phone" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_269 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, email and PersonCode with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "email" and "personCode" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_270 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, email and personType with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "email" and "personType" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_271 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, email and userId with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "email" and "userId" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_272 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonType and firstname with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "PersonType" and "firstName" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_273 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonType and lastname with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "PersonType" and "lastName" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_274 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonType and Phone with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "PersonType" and "Phone" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_275 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonType and PersonCode with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "PersonType" and "personCode" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_276 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonType and email with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "PersonType" and "email" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_277 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonType and userId with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "PersonType" and "userId" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_278 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, userId and firstname with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "userId" and "firstName" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_279 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, userId and lastname with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "userId" and "lastName" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_280 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, userId and Phone with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "userId" and "Phone" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_281 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, userId and PersonCode with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "userId" and "personCode" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_282 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, userId and email with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "userId" and "email" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_283 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, userId and PersonType with operator AND & case as TRUE
    Given payload to filter a person with "employeeId", "userId" and "PersonType" when case-sensitive is "true" and operator is "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_284 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid,firstname and last name with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "firstName" and "lastName" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_285 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid,firstname and personCode with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "firstName" and "PersonCode" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_286 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid,firstname and Phone with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "firstName" and "phone" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_287 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid,firstname and Email with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "firstName" and "email" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_288 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid,firstname and person type with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "firstName" and "personType" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_289 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid,firstname and userId with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "firstName" and "userId" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_290 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, lastname and firstname with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "lastName" and "firstName" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_291 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, lastName and personCode with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "lastName" and "PersonCode" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_292 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, lastName and Phone with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "lastName" and "phone" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_293 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, lastName and Email with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "lastName" and "email" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_294 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, lastName and person type with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "lastName" and "personType" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_295 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid,lastName and userId with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "lastName" and "userId" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_296 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonCode and firstname with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "PersonCode" and "firstName" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_297 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonCode and lastname with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "PersonCode" and "lastName" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_298 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonCode and Phone with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "PersonCode" and "phone" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_299 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonCode and Email with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "PersonCode" and "email" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_300 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonCode and person type with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "PersonCode" and "personType" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_301 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonCode and userId with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "PersonCode" and "userId" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_302 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, phone and firstname with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "phone" and "firstName" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_303 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, phone and lastname with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "phone" and "lastName" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_304 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, phone and PersonCode with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "phone" and "personCode" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_305 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, phone and Email with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "phone" and "email" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_306 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, phone and personType with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "phone" and "personType" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_307 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, phone and userId with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "phone" and "userId" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_308 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, email and firstname with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "email" and "firstName" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_309 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, email and lastname with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "email" and "lastName" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_310 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, email and Phone with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "email" and "Phone" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_311 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, email and PersonCode with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "email" and "personCode" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_312 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, email and personType with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "email" and "personType" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_313 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, email and userId with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "email" and "userId" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_314 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonType and firstname with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "PersonType" and "firstName" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_315 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonType and lastname with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "PersonType" and "lastName" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_316 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonType and Phone with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "PersonType" and "Phone" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_317 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonType and PersonCode with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "PersonType" and "personCode" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_318 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonType and email with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "PersonType" and "email" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_319 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, PersonType and userId with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "PersonType" and "userId" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_320 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, userId and firstname with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "userId" and "firstName" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_321 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, userId and lastname with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "userId" and "lastName" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_322 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, userId and Phone with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "userId" and "Phone" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_323 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, userId and PersonCode with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "userId" and "personCode" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_324 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, userId and email with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "userId" and "email" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_325 @personFilter @Smoke @Sanity
  Scenario: verify filter of person is successfull by employeeid, userId and PersonType with operator OR & case as TRUE
    Given payload to filter a person with "employeeId", "userId" and "PersonType" when case-sensitive is "true" and operator is "OR"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_0000 @DeleteEmployee @personFilter
  Scenario: Verify Person delete is successfull based on employee code
    Given payload to delete created person based on id



#### EmployeeFilter

  @TC_0101 @Employee @CreateEmployeeWithUserID
  Scenario: Verify Employee and user creation is successfull when create user is passed as true
    Given payload to create a Employee and user by providing create user as true
    When user calls create employee API with POST http request
    Then validate response code and response message for successfull employee creation userid

  @TC_0102 @Employee @CreateEmployee
  Scenario: Verify Employee create is successfull when all required parameter data's are provided
    Given payload to create a employee by providing all required parameter datas
    When user calls create employee API with POST http request
    Then validate response code and response message for successfull employee creation

  @TC_0103 @Employee @CreateEmployee
  Scenario: Verify Employee create is successfull when all required parameter data's are provided
    Given payload to create a employee by providing all required parameter datas and JobType as Temporary
    When user calls create employee API with POST http request
    Then validate response code and response message for successfull employee creation

  @TC_326 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Employee by the Employee id
    Given payload to filter a Employee by EmployeeId
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_327 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Employee by the First Name
    Given payload to filter a Employee by FirstName
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_328 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Employee by the Last Name
    Given payload to filter a Employee by LastName
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_329 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Employee by the Phone
    Given payload to filter a Employee by Phone
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_330 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Employee by the Employee Code
    Given payload to filter a Employee by Employee Code
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_331 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Employee by the Email Id
    Given payload to filter a Employee by Email
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_332 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Employee by the Department Id
    Given payload to filter a Employee by DepartmentId
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_333 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Employee by the User Id
    Given payload to filter a Employee by UserId
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_334 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Employee by the Designation Id
    Given payload to filter a Employee by DesignationId
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_335 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Employee by the Site Id
    Given payload to filter a Employee by SiteId
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_336 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Employee by the Page Size as Zero
    Given payload to filter a Employee by Page Size as Zero
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_337 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Employee by the Page Number
    Given payload to filter a Employee by Page Number
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_338 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of employee is successfull by passing Status as ACTIVE
    Given payload to filter a Employee by passing Status as "Active"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_339 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of employee is successfull by passing Status as INACTIVE
    Given payload to filter a Employee by passing Status as "Inactive"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_340 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of employee is successfull by passing jobtype as PERMANENT
    Given payload to filter a Employee by passing JobType as "PERMANENT"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_341 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of employee is successfull by passing jobtype as CONTRACT
    Given payload to filter a Employee by passing JobType as "CONTRACT"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_342 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of employee is successfull by passing jobtype as TEMPORARY
    Given payload to filter a Employee by passing JobType as "TEMPORARY"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_343 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of employee is not successfull by passing invalid employeeid
    Given payload to filter a Employee by passing invalid employeeId
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_344 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of employee is not successfull by passing invalid first name
    Given payload to filter a Employee by passing invalid first name
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_345 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of employee is not successfull by passing invalid last name
    Given payload to filter a Employee by passing invalid last name
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_346 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of employee is not successfull by passing invalid phone
    Given payload to filter a Employee by passing invalid phone
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_347 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of employee is not successfull by passing invalid employee code
    Given payload to filter a Employee by passing invalid employee code
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_348 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of employee is not successfull by passing invalid email
    Given payload to filter a Employee by passing invalid email
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_349 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of employee is not successfull by passing invalid department id
    Given payload to filter a Employee by passing invalid departmentId
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_350 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of employee is not successfull by passing invalid userid
    Given payload to filter a Employee by passing invalid userId
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_351 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of employee is not successfull by passing invalid designationid
    Given payload to filter a Employee by passing invalid designation Id
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_352 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of employee is not successfull by passing invalid site id
    Given payload to filter a Employee by passing invalid siteId
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_353 @EmployeeFilter @Smoke @Sanity
  Scenario: verify that user can  able to get list of employee with Acending order
    Given payload to filter list of Person by Ascending Order
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_354 @EmployeeFilter @Smoke @Sanity
  Scenario: verify that user can  able to get list of employee with Descending order
    Given payload to filter list of Person by Descending Order
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_355 @EmployeeFilter @Smoke @Sanity
  Scenario: verify that user can  able to get  list of  employee by passing multiple employeeid
    Given payload to filter a Employee by Multiple Employee Id
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_356 @EmployeeFilter @Smoke @Sanity
  Scenario: verify that user can  able to get  list of  employee by passing multiple userId
    Given payload to filter a Employee by Multiple User Id
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_357 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both employeeid and firstname with operator AND
    Given payload to filter a Employee by "EmployeeId" AND "FirstName" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_358 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both employeeid and lastname with operator AND
    Given payload to filter a Employee by "EmployeeId" AND "LastName" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_359 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both employeeid and phone with operator AND
    Given payload to filter a Employee by "EmployeeId" AND "Phone" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_360 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both employeeid and email with operator AND
    Given payload to filter a Employee by "EmployeeId" AND "Email" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_361 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both employeeid and DepartmentId with operator AND
    Given payload to filter a Employee by "EmployeeId" AND "DepartmentId" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_362 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both employeeid and DesignationId with operator AND
    Given payload to filter a Employee by "EmployeeId" AND "DesignationId" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_363 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both employeeid and userId with operator AND
    Given payload to filter a Employee by "EmployeeId" AND "UserId" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_364 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both FirstName and employeeid with operator AND
    Given payload to filter a Employee by "FirstName" AND "EmployeeId" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_365 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both FirstName and lastname with operator AND
    Given payload to filter a Employee by "FirstName" AND "LastName" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_366 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both FirstName and phone with operator AND
    Given payload to filter a Employee by "FirstName" AND "Phone" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_367 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both FirstName and email with operator AND
    Given payload to filter a Employee by "FirstName" AND "Email" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_368 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both FirstName and employeeCode with operator AND
    Given payload to filter a Employee by "FirstName" AND "employeeCode" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_369 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both FirstName and siteId with operator AND
    Given payload to filter a Employee by "FirstName" AND "siteId" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_370 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both FirstName and DepartmentId with operator AND
    Given payload to filter a Employee by "FirstName" AND "DepartmentId" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_371 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both FirstName and DesignationId with operator AND
    Given payload to filter a Employee by "FirstName" AND "DesignationId" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_372 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both FirstName and userId with operator AND
    Given payload to filter a Employee by "FirstName" AND "UserId" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee
###

  @TC_373 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both LastName and employeeid with operator AND
    Given payload to filter a Employee by "LastName" AND "EmployeeId" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_374 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both LastName and lastname with operator AND
    Given payload to filter a Employee by "LastName" AND "FirstName" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_375 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both LastName and phone with operator AND
    Given payload to filter a Employee by "LastName" AND "Phone" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_376 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both LastName and email with operator AND
    Given payload to filter a Employee by "LastName" AND "Email" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_377 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both LastName and employeeCode with operator AND
    Given payload to filter a Employee by "LastName" AND "employeeCode" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_378 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both LastName and siteId with operator AND
    Given payload to filter a Employee by "LastName" AND "siteId" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_379 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both LastName and DepartmentId with operator AND
    Given payload to filter a Employee by "LastName" AND "DepartmentId" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_380 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both LastName and DesignationId with operator AND
    Given payload to filter a Employee by "LastName" AND "DesignationId" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_381 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both LastName and userId with operator AND
    Given payload to filter a Employee by "LastName" AND "UserId" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_382 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Phone and employeeid with operator AND
    Given payload to filter a Employee by "Phone" AND "EmployeeId" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_383 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Phone and lastname with operator AND
    Given payload to filter a Employee by "Phone" AND "FirstName" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_384 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Phone and LastName with operator AND
    Given payload to filter a Employee by "Phone" AND "LastName" with Operator "AND"
    When user calls filter person API with POST http request
    Then validate response code and response message for successfull fiter the person

  @TC_385 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Phone and email with operator AND
    Given payload to filter a Employee by "Phone" AND "Email" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_386 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Phone and employeeCode with operator AND
    Given payload to filter a Employee by "Phone" AND "employeeCode" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_387 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Phone and siteId with operator AND
    Given payload to filter a Employee by "Phone" AND "siteId" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_388 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Phone and DepartmentId with operator AND
    Given payload to filter a Employee by "Phone" AND "DepartmentId" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_389 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Phone and DesignationId with operator AND
    Given payload to filter a Employee by "Phone" AND "DesignationId" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_390 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Phone and userId with operator AND
    Given payload to filter a Employee by "Phone" AND "UserId" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_391 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Email and EmployeeId with operator AND
    Given payload to filter a Employee by "Email" AND "EmployeeId" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_392 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both UserId and EmployeeId with operator AND
    Given payload to filter a Employee by "UserId" AND "EmployeeId" with Operator "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

    ###firstname

  @TC_393 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid First Name and invalid employeeid with operator as AND
    Given payload to filter a Employee by valid "FirstName" AND invalid "EmployeeId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_394 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid First Name and invalid lastname with operator as AND
    Given payload to filter a Employee by valid "FirstName" AND invalid "LastName"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_395 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid First Name and invalid phone with operator as AND
    Given payload to filter a Employee by valid "FirstName" AND invalid "Phone"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_396 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid First Name and invalid email with operator as AND
    Given payload to filter a Employee by valid "FirstName" AND invalid "email"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_397 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid First Name and invalid employee code with operator as AND
    Given payload to filter a Employee by valid "FirstName" AND invalid "EmployeeCode"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_398 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid First Name and invalid DepartmentId with operator as AND
    Given payload to filter a Employee by valid "FirstName" AND invalid "DepartmentId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_399 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid First Name and invalid DesignationId with operator as AND
    Given payload to filter a Employee by valid "FirstName" AND invalid "DesignationId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_400 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid First Name and invalid UserId with operator as AND
    Given payload to filter a Employee by valid "FirstName" AND invalid "UserId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

##employee id

  @TC_401 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Employeeid and invalid FirstName with operator as AND
    Given payload to filter a Employee by valid "Employeeid" AND invalid "FirstName"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_402 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Employeeid and invalid lastname with operator as AND
    Given payload to filter a Employee by valid "Employeeid" AND invalid "LastName"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_403 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Employeeid and invalid phone with operator as AND
    Given payload to filter a Employee by valid "Employeeid" AND invalid "Phone"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_404 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Employeeid and invalid email with operator as AND
    Given payload to filter a Employee by valid "Employeeid" AND invalid "email"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_405 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Employeeid and invalid employee code with operator as AND
    Given payload to filter a Employee by valid "Employeeid" AND invalid "EmployeeCode"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_406 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Employeeid and invalid DepartmentId with operator as AND
    Given payload to filter a Employee by valid "Employeeid" AND invalid "DepartmentId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_407 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Employeeid and invalid DesignationId with operator as AND
    Given payload to filter a Employee by valid "Employeeid" AND invalid "DesignationId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_408 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Employeeid and invalid UserId with operator as AND
    Given payload to filter a Employee by valid "Employeeid" AND invalid "UserId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

##lastname

  @TC_409 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid LastName and invalid EmployeeId with operator as AND
    Given payload to filter a Employee by valid "LastName" AND invalid "EmployeeId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_410 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid LastName and invalid firstname with operator as AND
    Given payload to filter a Employee by valid "LastName" AND invalid "FirstName"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_411 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid LastName and invalid phone with operator as AND
    Given payload to filter a Employee by valid "LastName" AND invalid "Phone"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_412 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid LastName and invalid email with operator as AND
    Given payload to filter a Employee by valid "LastName" AND invalid "email"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_413 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid LastName and invalid employee code with operator as AND
    Given payload to filter a Employee by valid "LastName" AND invalid "EmployeeCode"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_414 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid LastName and invalid DepartmentId with operator as AND
    Given payload to filter a Employee by valid "LastName" AND invalid "DepartmentId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_415 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid LastName and invalid DesignationId with operator as AND
    Given payload to filter a Employee by valid "LastName" AND invalid "DesignationId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_416 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid LastName and invalid UserId with operator as AND
    Given payload to filter a Employee by valid "LastName" AND invalid "UserId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

    ##phone

  @TC_417 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Phone and invalid EmployeeId with operator as AND
    Given payload to filter a Employee by valid "Phone" AND invalid "EmployeeId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_418 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Phone and invalid firstname with operator as AND
    Given payload to filter a Employee by valid "Phone" AND invalid "FirstName"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_419 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Phone and invalid Lastname with operator as AND
    Given payload to filter a Employee by valid "Phone" AND invalid "Lastname"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_420 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Phone and invalid email with operator as AND
    Given payload to filter a Employee by valid "Phone" AND invalid "email"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_421 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Phone and invalid employee code with operator as AND
    Given payload to filter a Employee by valid "Phone" AND invalid "EmployeeCode"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_422 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Phone and invalid DepartmentId with operator as AND
    Given payload to filter a Employee by valid "Phone" AND invalid "DepartmentId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_423 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Phone and invalid DesignationId with operator as AND
    Given payload to filter a Employee by valid "Phone" AND invalid "DesignationId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_424 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Phone and invalid UserId with operator as AND
    Given payload to filter a Employee by valid "Phone" AND invalid "UserId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

    ## code

  @TC_425 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid EmployeeCode and invalid EmployeeId with operator as AND
    Given payload to filter a Employee by valid "EmployeeCode" AND invalid "EmployeeId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_426 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid EmployeeCode and invalid firstname with operator as AND
    Given payload to filter a Employee by valid "EmployeeCode" AND invalid "FirstName"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_427 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid EmployeeCode and invalid lastName code with operator as AND
    Given payload to filter a Employee by valid "EmployeeCode" AND invalid "LastName"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_428 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid EmployeeCode and invalid phone with operator as AND
    Given payload to filter a Employee by valid "EmployeeCode" AND invalid "Phone"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_429 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid EmployeeCode and invalid email with operator as AND
    Given payload to filter a Employee by valid "EmployeeCode" AND invalid "email"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_430 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid EmployeeCode and invalid DepartmentId with operator as AND
    Given payload to filter a Employee by valid "EmployeeCode" AND invalid "DepartmentId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_431 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid EmployeeCode and invalid DesignationId with operator as AND
    Given payload to filter a Employee by valid "EmployeeCode" AND invalid "DesignationId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_432 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid EmployeeCode and invalid UserId with operator as AND
    Given payload to filter a Employee by valid "EmployeeCode" AND invalid "UserId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

    ## desgn id

  @TC_433 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid DesignationId and invalid EmployeeId with operator as AND
    Given payload to filter a Employee by valid "DesignationId" AND invalid "EmployeeId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_434 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid DesignationId and invalid firstname with operator as AND
    Given payload to filter a Employee by valid "DesignationId" AND invalid "FirstName"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_435 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid DesignationId and invalid LastName with operator as AND
    Given payload to filter a Employee by valid "DesignationId" AND invalid "LastName"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_436 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid DesignationId and invalid phone with operator as AND
    Given payload to filter a Employee by valid "DesignationId" AND invalid "Phone"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_437 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid DesignationId and invalid email with operator as AND
    Given payload to filter a Employee by valid "DesignationId" AND invalid "email"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_438 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid DesignationId and invalid DesignationId with operator as AND
    Given payload to filter a Employee by valid "DesignationId" AND invalid "EmployeeCode"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_439 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid DesignationId and invalid DepartmentId with operator as AND
    Given payload to filter a Employee by valid "DesignationId" AND invalid "DepartmentId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_440 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid DesignationId and invalid UserId with operator as AND
    Given payload to filter a Employee by valid "DesignationId" AND invalid "UserId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

    ##email

  @TC_441 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Email and invalid EmployeeId with operator as AND
    Given payload to filter a Employee by valid "Email" AND invalid "EmployeeId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_442 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Email and invalid firstname with operator as AND
    Given payload to filter a Employee by valid "Email" AND invalid "FirstName"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_443 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Email and invalid lastName with operator as AND
    Given payload to filter a Employee by valid "Email" AND invalid "lastName"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_444 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Email and invalid phone with operator as AND
    Given payload to filter a Employee by valid "Email" AND invalid "Phone"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_445 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Email and invalid employee code with operator as AND
    Given payload to filter a Employee by valid "Email" AND invalid "EmployeeCode"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_446 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Email and invalid DepartmentId with operator as AND
    Given payload to filter a Employee by valid "Email" AND invalid "DepartmentId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_447 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Email and invalid DesignationId with operator as AND
    Given payload to filter a Employee by valid "Email" AND invalid "DesignationId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_448 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid Email and invalid UserId with operator as AND
    Given payload to filter a Employee by valid "Email" AND invalid "UserId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

    ##department id

  @TC_449 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid DepartmentId and invalid EmployeeId with operator as AND
    Given payload to filter a Employee by valid "DepartmentId" AND invalid "EmployeeId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_450 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid DepartmentId and invalid firstname with operator as AND
    Given payload to filter a Employee by valid "DepartmentId" AND invalid "FirstName"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_451 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid DepartmentId and invalid LastName with operator as AND
    Given payload to filter a Employee by valid "DepartmentId" AND invalid "LastName"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_452 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid DepartmentId and invalid phone with operator as AND
    Given payload to filter a Employee by valid "DepartmentId" AND invalid "Phone"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_453 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid DepartmentId and invalid email with operator as AND
    Given payload to filter a Employee by valid "DepartmentId" AND invalid "email"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_454 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid DepartmentId and invalid employee code with operator as AND
    Given payload to filter a Employee by valid "DepartmentId" AND invalid "EmployeeCode"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_455 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid DepartmentId and invalid DesignationId with operator as AND
    Given payload to filter a Employee by valid "DepartmentId" AND invalid "DesignationId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_456 @EmployeeFilter @NegativeTC @Smoke
  Scenario: verify filter of Employee is not successfully when valid DepartmentId and invalid UserId with operator as AND
    Given payload to filter a Employee by valid "DepartmentId" AND invalid "UserId"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_457 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is AND
    Given payload to filter a Employee with case-insensitive "firstname" and case-sensitive "lastname" when case-sensitive is "false" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_458 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive first name and case-sensitive Employee Code when case-sensitive is false and operator is AND
    Given payload to filter a Employee with case-insensitive "firstname" and case-sensitive "EmployeeCode" when case-sensitive is "false" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_459 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive first name and case-sensitive email when case-sensitive is false and operator is AND
    Given payload to filter a Employee with case-insensitive "firstname" and case-sensitive "email" when case-sensitive is "false" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_460 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive last name and case-sensitive email when case-sensitive is false and operator is AND
    Given payload to filter a Employee with case-insensitive "lastname" and case-sensitive "email" when case-sensitive is "false" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_461 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive last name and case-sensitive Employee Code when case-sensitive is false and operator is AND
    Given payload to filter a Employee with case-insensitive "lastname" and case-sensitive "EmployeeCode" when case-sensitive is "false" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_462 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive last name and case-sensitive firstname when case-sensitive is false and operator is AND
    Given payload to filter a Employee with case-insensitive "lastname" and case-sensitive "firstname" when case-sensitive is "false" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_463 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive Employee Code and case-sensitive firstname when case-sensitive is false and operator is AND
    Given payload to filter a Employee with case-insensitive "EmployeeCode" and case-sensitive "firstname" when case-sensitive is "false" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_464 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive EmployeeCode and case-sensitive Lastname when case-sensitive is false and operator is AND
    Given payload to filter a Employee with case-insensitive "EmployeeCode" and case-sensitive "lastname" when case-sensitive is "false" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_465 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive EmployeeCode and case-sensitive Email when case-sensitive is false and operator is AND
    Given payload to filter a Employee with case-insensitive "EmployeeCode" and case-sensitive "email" when case-sensitive is "false" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

########## 06-03-2023

  @TC_466 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive email Code and case-sensitive firstname when case-sensitive is false and operator is AND
    Given payload to filter a Employee with case-insensitive "email" and case-sensitive "firstname" when case-sensitive is "false" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_467 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive email and case-sensitive Lastname when case-sensitive is false and operator is AND
    Given payload to filter a Employee with case-insensitive "email" and case-sensitive "lastname" when case-sensitive is "false" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_468 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive email and case-sensitive Employee code when case-sensitive is false and operator is AND
    Given payload to filter a Employee with case-insensitive "email" and case-sensitive "EmployeeCode" when case-sensitive is "false" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

    ############

  @TC_469 @EmployeeFilter @Smoke @Sanity @NegativeTC
  Scenario: Verify Employee filter is not successfull with case-insensitive first name and case-sensitive last name when case-sensitive is true and operator is AND
    Given payload to filter a Employee with case-insensitive "firstname" and case-sensitive "lastname" when case-sensitive is "true" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_470 @EmployeeFilter @Smoke @Sanity @NegativeTC
  Scenario: Verify Employee filter is not successfull with case-insensitive first name and case-sensitive employee code when case-sensitive is true and operator is AND
    Given payload to filter a Employee with case-insensitive "firstname" and case-sensitive "EmployeeCode" when case-sensitive is "true" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_471 @EmployeeFilter @Smoke @Sanity @NegativeTC
  Scenario: Verify Employee filter is not successfull with case-insensitive first name and case-sensitive email when case-sensitive is true and operator is AND
    Given payload to filter a Employee with case-insensitive "firstname" and case-sensitive "email" when case-sensitive is "true" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee


  @TC_472 @EmployeeFilter @Smoke @Sanity @NegativeTC
  Scenario: Verify Employee filter is not successfull with case-insensitive last name and case-sensitive employee code when case-sensitive is true and operator is AND
    Given payload to filter a Employee with case-insensitive "lastname" and case-sensitive "EmployeeCode" when case-sensitive is "true" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_473 @EmployeeFilter @Smoke @Sanity @NegativeTC
  Scenario: Verify Employee filter is not successfull with case-insensitive last name and case-sensitive email when case-sensitive is true and operator is AND
    Given payload to filter a Employee with case-insensitive "lastname" and case-sensitive "email" when case-sensitive is "true" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_474 @EmployeeFilter @Smoke @Sanity @NegativeTC
  Scenario: Verify Employee filter is not successfull with case-insensitive last name and case-sensitive first name when case-sensitive is true and operator is AND
    Given payload to filter a Employee with case-insensitive "lastname" and case-sensitive "firstName" when case-sensitive is "true" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_475 @EmployeeFilter @Smoke @Sanity @NegativeTC
  Scenario: Verify Employee filter is not successfull with case-insensitive employee code and case-sensitive first name when case-sensitive is true and operator is AND
    Given payload to filter a Employee with case-insensitive "EmployeeCode" and case-sensitive "FirstName" when case-sensitive is "true" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_476 @EmployeeFilter @Smoke @Sanity @NegativeTC
  Scenario: Verify Employee filter is not successfull with case-insensitive employee code and case-sensitive last name when case-sensitive is true and operator is AND
    Given payload to filter a Employee with case-insensitive "EmployeeCode" and case-sensitive "lastName" when case-sensitive is "true" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_477 @EmployeeFilter @Smoke @Sanity @NegativeTC
  Scenario: Verify Employee filter is not successfull with case-insensitive employee code and case-sensitive email when case-sensitive is true and operator is AND
    Given payload to filter a Employee with case-insensitive "EmployeeCode" and case-sensitive "Email" when case-sensitive is "true" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee


  @TC_478 @EmployeeFilter @Smoke @Sanity @NegativeTC
  Scenario: Verify Employee filter is not successfull with case-insensitive email and case-sensitive first name when case-sensitive is true and operator is AND
    Given payload to filter a Employee with case-insensitive "Email" and case-sensitive "FirstName" when case-sensitive is "true" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_479 @EmployeeFilter @Smoke @Sanity @NegativeTC
  Scenario: Verify Employee filter is not successfull with case-insensitive email and case-sensitive last name when case-sensitive is true and operator is AND
    Given payload to filter a Employee with case-insensitive "Email" and case-sensitive "lastName" when case-sensitive is "true" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_480 @EmployeeFilter @Smoke @Sanity @NegativeTC
  Scenario: Verify Employee filter is not successfull with case-insensitive email and case-sensitive employee code when case-sensitive is true and operator is AND
    Given payload to filter a Employee with case-insensitive "Email" and case-sensitive "EmployeeCode" when case-sensitive is "true" and operator is "AND"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for unsuccessfull fiter the Employee

  @TC_481 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive first name and case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a Employee with case-insensitive "firstname" and case-sensitive "lastname" when case-sensitive is "false" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_482 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive first name and case-sensitive employee code when case-sensitive is false and operator is OR
    Given payload to filter a Employee with case-insensitive "firstname" and case-sensitive "EmployeeCode" when case-sensitive is "false" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_483 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive first name and case-sensitive email when case-sensitive is false and operator is OR
    Given payload to filter a Employee with case-insensitive "firstname" and case-sensitive "Email" when case-sensitive is "false" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee
#######

  @TC_484 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive last name and case-sensitive first name when case-sensitive is false and operator is OR
    Given payload to filter a Employee with case-insensitive "lastname" and case-sensitive "firstName" when case-sensitive is "false" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_485 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive last name and case-sensitive employee code when case-sensitive is false and operator is OR
    Given payload to filter a Employee with case-insensitive "lastname" and case-sensitive "EmployeeCode" when case-sensitive is "false" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_486 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive last name and case-sensitive email when case-sensitive is false and operator is OR
    Given payload to filter a Employee with case-insensitive "lastname" and case-sensitive "Email" when case-sensitive is "false" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_487 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive Employee code and case-sensitive first name when case-sensitive is false and operator is OR
    Given payload to filter a Employee with case-insensitive "EmployeeCode" and case-sensitive "firstName" when case-sensitive is "false" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_488 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive Employee code case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a Employee with case-insensitive "EmployeeCode" and case-sensitive "lastName" when case-sensitive is "false" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_489 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive Employee code and case-sensitive email when case-sensitive is false and operator is OR
    Given payload to filter a Employee with case-insensitive "EmployeeCode" and case-sensitive "Email" when case-sensitive is "false" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee


  @TC_490 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive Email and case-sensitive first name when case-sensitive is false and operator is OR
    Given payload to filter a Employee with case-insensitive "Email" and case-sensitive "firstName" when case-sensitive is "false" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_491 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive Email case-sensitive last name when case-sensitive is false and operator is OR
    Given payload to filter a Employee with case-insensitive "Email" and case-sensitive "lastName" when case-sensitive is "false" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_492 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive Email and case-sensitive employee code when case-sensitive is false and operator is OR
    Given payload to filter a Employee with case-insensitive "Email" and case-sensitive "EmployeeCode" when case-sensitive is "false" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

###########

  @TC_493 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive Lastname and case-sensitive First Name when case-sensitive is true and operator is OR
    Given payload to filter a Employee with case-insensitive "lastName" and case-sensitive "FirstName" when case-sensitive is "true" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_494 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive EmployeeCode and case-sensitive First Name when case-sensitive is true and operator is OR
    Given payload to filter a Employee with case-insensitive "EmployeeCode" and case-sensitive "FirstName" when case-sensitive is "true" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_495 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive Email and case-sensitive First Name when case-sensitive is true and operator is OR
    Given payload to filter a Employee with case-insensitive "Email" and case-sensitive "FirstName" when case-sensitive is "true" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_496 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive firstname and case-sensitive last Name when case-sensitive is true and operator is OR
    Given payload to filter a Employee with case-insensitive "firstName" and case-sensitive "LastName" when case-sensitive is "true" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_497 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive EmployeeCode and case-sensitive last Name when case-sensitive is true and operator is OR
    Given payload to filter a Employee with case-insensitive "EmployeeCode" and case-sensitive "LastName" when case-sensitive is "true" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_498 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive Email and case-sensitive last Name code when case-sensitive is true and operator is OR
    Given payload to filter a Employee with case-insensitive "Email" and case-sensitive "LastName" when case-sensitive is "true" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee


  @TC_499 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive firstname and case-sensitive Employee code when case-sensitive is true and operator is OR
    Given payload to filter a Employee with case-insensitive "firstName" and case-sensitive "EmployeeCode" when case-sensitive is "true" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_500 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive Last Name and case-sensitive Employee code when case-sensitive is true and operator is OR
    Given payload to filter a Employee with case-insensitive "LastName" and case-sensitive "EmployeeCode" when case-sensitive is "true" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_501 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive Email and case-sensitive Employee code when case-sensitive is true and operator is OR
    Given payload to filter a Employee with case-insensitive "Email" and case-sensitive "EmployeeCode" when case-sensitive is "true" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_502 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive firstname and case-sensitive Email when case-sensitive is true and operator is OR
    Given payload to filter a Employee with case-insensitive "firstName" and case-sensitive "Email" when case-sensitive is "true" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_503 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive Last Name and case-sensitive Email when case-sensitive is true and operator is OR
    Given payload to filter a Employee with case-insensitive "LastName" and case-sensitive "Email" when case-sensitive is "true" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_504 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify Employee filter is successfull with case-insensitive Employee Code and case-sensitive Email when case-sensitive is true and operator is OR
    Given payload to filter a Employee with case-insensitive "EmployeeCode" and case-sensitive "Email" when case-sensitive is "true" and operator is "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

    #### 07-03-2023

  ## Emp id

  @TC_505 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both employeeid or firstname with operator OR
    Given payload to filter a Employee by "EmployeeId" OR "FirstName" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_506 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both employeeid or lastname with operator OR
    Given payload to filter a Employee by "EmployeeId" OR "LastName" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_507 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both employeeid or Phone with operator OR
    Given payload to filter a Employee by "EmployeeId" OR "Phone" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_508 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both employeeid or Email with operator OR
    Given payload to filter a Employee by "EmployeeId" OR "Email" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_509 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both employeeid or EmployeeCode with operator OR
    Given payload to filter a Employee by "EmployeeId" OR "EmployeeCode" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_510 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both employeeid or DesignationId with operator OR
    Given payload to filter a Employee by "EmployeeId" OR "DesignationId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_512 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both employeeid or DepartmentId with operator OR
    Given payload to filter a Employee by "EmployeeId" OR "DepartmentId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_513 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both employeeid or UserId with operator OR
    Given payload to filter a Employee by "EmployeeId" OR "UserId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

    ## first Name

  @TC_514 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both FirstName or Employeeid with operator OR
    Given payload to filter a Employee by "FirstName" OR "EmployeeId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_515 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both FirstName or lastname with operator OR
    Given payload to filter a Employee by "FirstName" OR "lastName" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_516 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both FirstName or Phone with operator OR
    Given payload to filter a Employee by "FirstName" OR "Phone" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_517 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both FirstName or Email with operator OR
    Given payload to filter a Employee by "FirstName" OR "Email" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_518 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both FirstName or EmployeeCode with operator OR
    Given payload to filter a Employee by "FirstName" OR "EmployeeCode" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_519 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both FirstName or DesignationId with operator OR
    Given payload to filter a Employee by "FirstName" OR "DesignationId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_520 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both FirstName or DepartmentId with operator OR
    Given payload to filter a Employee by "FirstName" OR "DepartmentId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_521 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both FirstName or UserId with operator OR
    Given payload to filter a Employee by "FirstName" OR "UserId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

    ## last Name

  @TC_522 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both LastName or Employeeid with operator OR
    Given payload to filter a Employee by "LastName" OR "EmployeeId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_523 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both LastName or firstName with operator OR
    Given payload to filter a Employee by "LastName" OR "FirstName" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_524 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both LastName or Phone with operator OR
    Given payload to filter a Employee by "LastName" OR "Phone" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_525 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both LastName or Email with operator OR
    Given payload to filter a Employee by "LastName" OR "Email" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_526 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both LastName or EmployeeCode with operator OR
    Given payload to filter a Employee by "LastName" OR "EmployeeCode" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_527 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both LastName or DesignationId with operator OR
    Given payload to filter a Employee by "LastName" OR "DesignationId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_528 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both LastName or SiteId with operator OR
    Given payload to filter a Employee by "LastName" OR "SiteId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_529 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both LastName or DepartmentId with operator OR
    Given payload to filter a Employee by "LastName" OR "DepartmentId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_530 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both LastName or UserId with operator OR
    Given payload to filter a Employee by "LastName" OR "UserId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

     ## Phone

  @TC_531 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Phone or Employeeid with operator OR
    Given payload to filter a Employee by "Phone" OR "EmployeeId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_532 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Phone or firstName with operator OR
    Given payload to filter a Employee by "Phone" OR "FirstName" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_533 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Phone or LastName with operator OR
    Given payload to filter a Employee by "Phone" OR "LastName" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_534 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Phone or Email with operator OR
    Given payload to filter a Employee by "Phone" OR "Email" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_535 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Phone or EmployeeCode with operator OR
    Given payload to filter a Employee by "Phone" OR "EmployeeCode" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_536 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Phone or DesignationId with operator OR
    Given payload to filter a Employee by "Phone" OR "DesignationId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_537 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Phone or DepartmentId with operator OR
    Given payload to filter a Employee by "Phone" OR "DepartmentId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_538 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Phone or SiteId with operator OR
    Given payload to filter a Employee by "Phone" OR "SiteId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_539 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Phone or UserId with operator OR
    Given payload to filter a Employee by "Phone" OR "UserId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

       ## Email

  @TC_540 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Email or Employeeid with operator OR
    Given payload to filter a Employee by "Email" OR "EmployeeId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_541 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Email or firstName with operator OR
    Given payload to filter a Employee by "Email" OR "FirstName" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_542 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Email or LastName with operator OR
    Given payload to filter a Employee by "Email" OR "LastName" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_543 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Email or Phone with operator OR
    Given payload to filter a Employee by "Email" OR "Phone" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_544 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Email or EmployeeCode with operator OR
    Given payload to filter a Employee by "Email" OR "EmployeeCode" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_545 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Email or DesignationId with operator OR
    Given payload to filter a Employee by "Email" OR "DesignationId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_546 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Email or DepartmentId with operator OR
    Given payload to filter a Employee by "Email" OR "DepartmentId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_547 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Email or SiteId with operator OR
    Given payload to filter a Employee by "Email" OR "SiteId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_548 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both Email or UserId with operator OR
    Given payload to filter a Employee by "Email" OR "UserId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

      ## Designation Id

  @TC_549 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both DesignationId or Employeeid with operator OR
    Given payload to filter a Employee by "DesignationId" OR "EmployeeId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_550 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both DesignationId or firstName with operator OR
    Given payload to filter a Employee by "DesignationId" OR "FirstName" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_551 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both DesignationId or LastName with operator OR
    Given payload to filter a Employee by "DesignationId" OR "LastName" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_552 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both DesignationId or Phone with operator OR
    Given payload to filter a Employee by "DesignationId" OR "Phone" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_553 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both DesignationId or Email with operator OR
    Given payload to filter a Employee by "DesignationId" OR "Email" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_554 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both DesignationId or EmployeeCode with operator OR
    Given payload to filter a Employee by "DesignationId" OR "EmployeeCode" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_555 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both DesignationId or DepartmentId with operator OR
    Given payload to filter a Employee by "DesignationId" OR "DepartmentId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_556 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both DesignationId or UserId with operator OR
    Given payload to filter a Employee by "DesignationId" OR "UserId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

        ## Department Id

  @TC_557 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both DepartmentId or Employeeid with operator OR
    Given payload to filter a Employee by "DepartmentId" OR "EmployeeId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_558 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both DepartmentId or firstName with operator OR
    Given payload to filter a Employee by "DepartmentId" OR "FirstName" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_559 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both DepartmentId or LastName with operator OR
    Given payload to filter a Employee by "DepartmentId" OR "LastName" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_560 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both DepartmentId or Phone with operator OR
    Given payload to filter a Employee by "DepartmentId" OR "Phone" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_561 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both DepartmentId or Email with operator OR
    Given payload to filter a Employee by "DepartmentId" OR "Email" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_562 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both DepartmentId or EmployeeCode with operator OR
    Given payload to filter a Employee by "DepartmentId" OR "EmployeeCode" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_563 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both DepartmentId or DesignationId with operator OR
    Given payload to filter a Employee by "DepartmentId" OR "DesignationId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_564 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both DepartmentId or SiteId with operator OR
    Given payload to filter a Employee by "DepartmentId" OR "SiteId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_565 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both DepartmentId or UserId with operator OR
    Given payload to filter a Employee by "DepartmentId" OR "UserId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

        ## User Id

  @TC_566 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both UserId or Employeeid with operator OR
    Given payload to filter a Employee by "UserId" OR "EmployeeId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_567 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both UserId or firstName with operator OR
    Given payload to filter a Employee by "UserId" OR "FirstName" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_568 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both UserId or LastName with operator OR
    Given payload to filter a Employee by "UserId" OR "LastName" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_569 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both UserId or Phone with operator OR
    Given payload to filter a Employee by "UserId" OR "Phone" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_570 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both UserId or Email with operator OR
    Given payload to filter a Employee by "UserId" OR "Email" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_571 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both UserId or EmployeeCode with operator OR
    Given payload to filter a Employee by "UserId" OR "EmployeeCode" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_572 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both UserId or DesignationId with operator OR
    Given payload to filter a Employee by "UserId" OR "DesignationId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_573 @EmployeeFilter @Smoke @Sanity
  Scenario: verify filter of Employee is successfull by both UserId or DepartmentId with operator OR
    Given payload to filter a Employee by "UserId" OR "DepartmentId" with Operator "OR"
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee

  @TC_574 @EmployeeFilter @Smoke @Sanity
  Scenario: verify profile photo key is not refecting in the response when togglekey is passed as true
    Given payload to filter a Employee by passing toggleKeytoURL is "true"
    When user calls filter Employee API with POST http request
    Then validate response code and profile photo key as null

  @TC_575 @EmployeeFilter @Smoke @Sanity
  Scenario: verify profile photo key is refecting in the response when togglekey is passed as false
    Given payload to filter a Employee by passing toggleKeytoURL is "false"
    When user calls filter Employee API with POST http request
    Then validate response code and profile photo key

  @TC_0001 @DeleteEmployee @personFilter
  Scenario: Verify Employee delete is successfull based on employee code
    Given payload to delete created employee based on id




  @TC_0101 @Site @CreateEmployeeWithUserID
  Scenario: Verify site and user creation is successfull when create user is passed as true
    Given payload to create a site and user by providing create user as true
    When user calls create site API with POST http request
    Then validate response code and response message for successfull site creation userid

  @TC_0001 @Site @DeleteSite
  Scenario: Verify site delete is successfull based on employee code
    Given payload to delete created site based on id


  @TC_326 @EmployeeFilter @Smoke @Sanity
  Scenario: Verify user is able to filter a Employee by the Employee id
    Given payload to filter a Employee by EmployeeId
    When user calls filter Employee API with POST http request
    Then validate response code and response message for successfull fiter the Employee