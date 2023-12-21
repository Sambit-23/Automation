package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import groovyjarjarantlr4.v4.runtime.atn.SemanticContext;
import io.cucumber.java.Before;
import io.restassured.http.ContentType;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import Payloads.Payloads;
import Utils.ReusableFunctions;
import Utils.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class Organization extends Utils {
    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    static Response validation_responseObj;
    static Response responseObj;
    static String userFname;
    WebDriver driver;
    Utils utils;
    ReusableFunctions reusable;
    final static String company_code = RandomStringUtils.randomAlphanumeric(5);
    final static String company_name = RandomStringUtils.randomAlphabetic(6);
    final static String clientID = "1b2d1578cc924626805efb39d6fc1211";
    final static String clientSecret = "Dok8iJPddLnXuXB2GOm5UtmG01vSdCuaxTvUKYPtKoVeSbcq4wPIPLUb3xkGnWyeOsvqLRWrBDKBw3S3VfbXXvib087tGkGfuq09x3yUW70i3K1PU9c0W8vnPxeaFYq3";
    static ValidatableResponse validateresponseOBJ;
    static String response;
    static String oAuthToken;
    static String adminToken;
    static String companyToken;
    static String companyID;
    static String userID;
    static String roleID;
    static String membershipId;
    static String PersonUserId;
    ReusableFunctions res = new ReusableFunctions();
    String fname = RandomStringUtils.randomAlphabetic(4);
    String lname = RandomStringUtils.randomAlphabetic(4);
    private String contact = RandomStringUtils.randomNumeric(10);
    private String email = (RandomStringUtils.randomAlphabetic(5)).toLowerCase() + "@zk.in";
    static String userEmail;
    private static String Company_token;
    private static String Client_token;
    private Properties properties;
    private static String employeeId;
    private static String ResCode;
    private static String ResEmail;
    private String parentdepartmentID;
    private String parentdesignationID;
    private String lengthyData = RandomStringUtils.randomAlphabetic(25);
    private String code = RandomStringUtils.randomNumeric(5);
    private String Phone = RandomStringUtils.randomNumeric(10);

    private static List<String> departmentCodes = new ArrayList<String>();
    private static List<String> designationCodes = new ArrayList<String>();

    //Person
    private static List<String> PersonIDs = new ArrayList<String>();
    private static List<String> Personcodes = new ArrayList<String>();
    private static List<String> PersonEmails = new ArrayList<String>();
    private static List<String> Personphones = new ArrayList<String>();
    private static List<String> PersonUserIds = new ArrayList<>();
    private static List<String> PersonFirstName = new ArrayList<String>();
    private static List<String> PersonLastName = new ArrayList<String>();
    private static List<String> PersonType = new ArrayList<String>();

    //Employee

    private static List<String> EmployeeIDs = new ArrayList<String>();
    private static List<String> EmployeeCodes = new ArrayList<String>();
    private static List<String> EmployeeEmails = new ArrayList<String>();
    private static List<String> Employeephones = new ArrayList<String>();
    private static List<String> EmployeeUserIds = new ArrayList<>();
    private static List<String> EmployeeFirstName = new ArrayList<String>();
    private static List<String> EmployeeLastName = new ArrayList<String>();
    private static List<String> EmployeeType = new ArrayList<String>();
    private static List<String> EmployeeJobType = new ArrayList<>();
    private static List<String> EmployeeDesignationId = new ArrayList<>();
    private static List<String> EmployeeDepartmentId = new ArrayList<>();
    private static List<String> EmployeeSiteId = new ArrayList<>();
    private static List<String> EmployeeStatus = new ArrayList<>();

    private String UserName = "sambit34@zkteco.in";
    private String Password = "Root@123";

    /////////   AWS Parent Company details ##############
    private String CompanyID = "8a8194f186edf0600186fd51333e01f2";

    ///////  AWS Non-parent relartion company ///////

    private String N_CompanyCode = "praa";

    private String client_encoded = "MWIyZDE1NzhjYzkyNDYyNjgwNWVmYjM5ZDZmYzEyMTE6RG9rOGlKUGRkTG5YdVhCMkdPbTVVdG1HMDF2U2RDdWF4VHZVS1lQdEtvVmVTYmNxNHdQSVBMVWIzeGtHbld5ZU9zdnFMUldyQkRLQnczUzNWZmJYWHZpYjA4N3RHa0dmdXEwOXgzeVVXNzBpM0sxUFU5YzBXOHZuUHhlYUZZcTM=";

    @Before
    public void setup() throws IOException {

        FileInputStream fis1 = new FileInputStream(
                System.getProperty("user.dir") + "/src/main/java/Resources/data.properties");
        properties = new Properties();
        properties.load(fis1);
    }

    //Added by Sambit

    @Given("^payload to generate a client token$")
    public void payload_to_generate_a_client_token() throws Throwable {
        reqSpec = given().log().all().
                spec(requestSpecification("Basic " + client_encoded))
                .contentType(ContentType.URLENC).formParam("grant_type", "client_credentials");
    }
    @When("^user calls generate client token API with POST http request$")
    public void user_calls_generate_client_token_api_with_post_http_request() throws Throwable {
        validation_responseObj = reqSpec.post("/oauth/token");


    }
    @Then("^validate response code and response message for successfull generation of client token$")
    public void validate_response_code_and_response_message_for_successfull_generation_of_client_token() throws Throwable {
        validation_responseObj.then().log().all().spec(responseSpecification(200));
        Client_token = getJsonPath(validation_responseObj, "access_token");
    }
    @Given("^payload to generate a company token$")
    public void payload_to_generate_a_company_token() {
        reqSpec = given().log().all().
                spec(requestSpecification("Basic " + client_encoded)).contentType(ContentType.JSON)
                .body(Payloads.switchCompany(UserName, Password, CompanyID));
    }
    @When("^user calls generate company token API with POST http request$")
    public void user_calls_generate_company_token_with_post_http_request() throws Throwable {
        validation_responseObj = reqSpec.post("/api/v3/oauth/token");
    }

    @Then("^validate response code and response message for successfull generation of company token$")
    public void validate_response_code_and_response_message_for_successfull_generation_of_company_token() {
        validation_responseObj.then().log().all().spec(responseSpecification(200)).body("message", equalTo("Company Switched successfully."));
        Company_token = getJsonPath(validation_responseObj, "data.access_token");

    }

    @Given("^payload to create a Person with person type of employee by providing all required parameter datas$")
    public void payload_to_create_a_person_with_person_type_of_employee_by_providing_all_required_parameter_datas() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token))
                .body(Payloads.addPerson("Per" + fname, "Per" + lname, "Nname", "M", "123", "Per" + code, "04-01-1995", "Employee", "per" + email, "+91", contact, "01-01-2023", "permanent", "\"\"", "hindu", "", "", "active", true, "img.jpg", false, ""));
    }

    @Given("payload to create a Person with person type of employee by providing all required parameter datas and createUser as true")
    public void payloadToCreateAPersonWithPersonTypeOfEmployeeByProvidingAllRequiredParameterDatasAndCreateUserAsTrue() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token))
                .body(Payloads.addPerson("Per" + fname, "Per" + lname, "Nname", "M", "123", "Per" + code, "04-01-1995", "Employee", "per" + email, "+91", contact, "01-01-2023", "permanent", "\"\"", "hindu", "", "", "active", false, "", false, ""));
    }


    @When("^user calls create Person API with POST http request$")
    public void user_calls_create_person_api_with_post_http_request() {
        validation_responseObj = reqSpec.post("api/v3/person");
    }

    //Create a Person

    @Then("^validate response code and response message for successfull Person creation with person type of employee$")
    public void validate_response_code_and_response_message_for_successfull_person_creation_with_person_type_of_Employee() throws Exception {
        ValidatableResponse re = validation_responseObj.then().log().all().spec(responseSpecification(200)).body("message", equalTo("Person Created successfully."));
        Personcodes.add(0, getJsonPath(validation_responseObj, "data.code"));
        PersonIDs.add(0, getJsonPath(validation_responseObj, "data.id"));
        PersonEmails.add(0, getJsonPath(validation_responseObj, "data.email"));
        Personphones.add(0, getJsonPath(validation_responseObj, "data.phone"));
        PersonType.add(0, getJsonPath(validation_responseObj, "data.personType"));
        PersonFirstName.add(0, getJsonPath(validation_responseObj, "data.firstName"));
        PersonLastName.add(0, getJsonPath(validation_responseObj, "data.lastName"));
        PersonUserIds.add(0, getJsonPath(validation_responseObj, "data.userId"));

    }

    //Create a Person with User Id

    @Then("validate response code and response message for successfull Person creation with person type of employee with userId")
    public void validateResponseCodeAndResponseMessageForSuccessfullPersonCreationWithPersonTypeOfEmployeeWithUserId() {

        validation_responseObj.then().log().all().spec(responseSpecification(200)).body("message", equalTo("Person Created successfully."));
        Personcodes.add(1, getJsonPath(validation_responseObj, "data.code"));
        PersonIDs.add(1, getJsonPath(validation_responseObj, "data.id"));
        PersonEmails.add(1, getJsonPath(validation_responseObj, "data.email"));
        Personphones.add(1, getJsonPath(validation_responseObj, "data.phone"));
        PersonType.add(1, getJsonPath(validation_responseObj, "data.personType"));
        PersonFirstName.add(1, getJsonPath(validation_responseObj, "data.firstName"));
        PersonLastName.add(1, getJsonPath(validation_responseObj, "data.lastName"));

        System.out.println("no of person in the list " + PersonIDs.size());
        for (int i = 0; i < PersonIDs.size(); i++) {
            System.out.println("Person id with userID is " + PersonIDs.get(i));
        }
    }

    @Given("payload to filter a Person by EmployeeId")
    public void payload_To_Filter_A_Person_By_Employee_Id() {
        System.out.println("Emp id" + PersonIDs.get(0));
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("personId", PersonIDs.get(0));
    }

    @When("user calls filter person API with POST http request")
    public void user_Calls_Filter_Person_API_With_POST_Http_Request() {
        validation_responseObj = reqSpec.post("/api/v3/person/list");
    }

    @Then("validate response code and response message for successfull fiter the person")
    public void validate_Response_Code_AndResponse_Message_For_Successfull_Fiter_The_Person() {
        List<String> id = validation_responseObj.jsonPath().getList("data.person.id");
        List<String> code = validation_responseObj.jsonPath().getList("data.person.code");
        List<String> fname = validation_responseObj.jsonPath().getList("data.person.firstName");
        List<String> lname = validation_responseObj.jsonPath().getList("data.person.lastName");
        List<String> email = validation_responseObj.jsonPath().getList("data.person.email");
        List<String> phone = validation_responseObj.jsonPath().getList("data.person.phone");
        int totalCount = validation_responseObj.jsonPath().get("data.totalCount");
        int currentPage = validation_responseObj.jsonPath().get("data.currentPage");
        int totalPages = validation_responseObj.jsonPath().get("data.totalPages");
        int pageSize = validation_responseObj.jsonPath().get("data.pageSize");
        validation_responseObj.then().log().all().spec(responseSpecification(200))
                .body("message", equalTo("Success."))
                .body("data.totalCount", equalTo(totalCount))
                .body("data.currentPage", equalTo(currentPage))
                .body("data.totalPages", equalTo(totalPages))
                .body("data.pageSize", equalTo(pageSize))
                .body("data.person.id", equalTo(id))
                .body("data.person.code", equalTo(code))
                .body("data.person.firstName", equalTo(fname))
                .body("data.person.lastName", equalTo(lname))
                .body("data.person.email", equalTo(email))
                .body("data.person.phone", equalTo(phone));

    }

    @Given("payload to filter a Person by FirstName")
    public void payload_To_Filter_A_Person_By_FirstName() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("firstName", PersonFirstName.get(0));

    }

    @Given("payload to filter a Person by LastName")
    public void payloadToFilterAPersonByLastName() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("lastName", PersonLastName.get(0));
    }

    @Given("payload to filter a Person by Email")
    public void payload_To_Filter_A_Person_By_Email() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("email", PersonEmails.get(0));

    }

    @Given("payload to filter a Person by Phone")
    public void payload_To_Filter_A_Person_By_Phone() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("phone", Personphones.get(0));

    }

    @Given("payload to filter a Person by Person Code")
    public void payload_To_Filter_A_Person_By_Person_Code() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("code", Personcodes.get(0));

    }

    @Given("payload to filter a Person by Employee Type")
    public void payload_To_Filter_A_Person_By_Employee_Type() {
        System.out.println("Total emp id is " + PersonIDs.size());
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("personType", PersonType.get(0));

    }

    @Given("payload to filter a Person by UserId")
    public void payloadToFilterAPersonByUserId() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("userId", PersonUserIds.get(0));
    }

    @Given("payload to filter a Person by ValidityTime")
    public void payloadToFilterAPersonByValidityTime() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("validityPeriod", "1");
    }

    @Given("payload to filter a Person by Page Number")
    public void payloadToFilterAPersonByPageNumber() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("pageNumber", "1");
    }

    @Given("payload to filter a Person by Page Size")
    public void payloadToFilterAPersonByPageSize() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("pageSize", 1);
    }

    @Given("payload to filter a Person by passing invalid employeeId")
    public void payloadToFilterAPersonByPassingInvalidEmployeeId() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("personId", properties.getProperty("invalidEmpId"));
    }

    @Then("validate response code and response message for unsuccessfull fiter the person")
    public void validateResponseCodeAndResponseMessageForUnsuccessfullFiterThePerson() {
        validation_responseObj.then().log().all().spec(responseSpecification(200))
                .body("message", equalTo("Success."))
                .body("data.totalCount", equalTo(0))
                .body("data.currentPage", equalTo(1))
                .body("data.totalPages", equalTo(0))
                .body("data.pageSize", equalTo(0));

    }

    @Given("payload to filter a Person by passing invalid firstname")
    public void payloadToFilterAPersonByPassingInvalidFirstname() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("firstName", properties.getProperty("invalidFirstName"));
    }

    @Given("payload to filter a Person by passing invalid lastname")
    public void payloadToFilterAPersonByPassingInvalidLastname() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("lastName", properties.getProperty("invalidLastName"));
    }

    @Given("payload to filter a Person by passing invalid phone")
    public void payloadToFilterAPersonByPassingInvalidPhone() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("phone", properties.getProperty("invalidPhone"));
    }

    @Given("payload to filter a Person by passing invalid code")
    public void payloadToFilterAPersonByPassingInvalidCode() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("code", properties.getProperty("invalidPersonCode"));
    }

    @Given("payload to filter a Person by passing invalid emailId")
    public void payloadToFilterAPersonByPassingInvalidEmailId() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("email", properties.getProperty("invalidEmailId"));
    }

    @Given("payload to filter a Person by passing invalid persontype")
    public void payloadToFilterAPersonByPassingInvalidPersontype() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("personType", properties.getProperty("invalidPersonType"));
    }

    @Given("payload to filter a Person by passing invalid userId")
    public void payloadToFilterAPersonByPassingInvalidUserId() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("userId", properties.getProperty("invalidUserId"));
    }

    @Given("payload to filter list of Person by Ascending Order")
    public void payloadToFilterListOfPersonByAscendingOrder() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("sort", "createdAt|asc");
    }

    @Given("payload to filter list of Person by Descending Order")
    public void payloadToFilterListOfPersonByDescendingOrder() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("sort", "createdAt|desc");

    }

    @Then("validate response code and response message for successfull fiter of personList")
    public void validateResponseCodeAndResponseMessageForSuccessfullFiterOfPersonList() {
        validation_responseObj.then().log().all().spec(responseSpecification(200))
                .body("message", equalTo("Success."));
    }

    @Given("payload to filter a Person by Multiple Employee Id")
    public void payloadToFilterAPersonByMultipleEmployeeId() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("personId", PersonIDs.get(0)).queryParam("personId", PersonIDs.get(1));
    }

    @Given("payload to filter a Person by Multiple User Id")
    public void payloadToFilterAPersonByMultipleUserId() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("userId", PersonUserIds.get(0)).queryParam("userId", PersonUserIds.get(0));
    }

    @Given("payload to filter a Person by {string} AND {string} with Operator {string}")
    public void payloadToFilterAPersonByANDWithOperator(String arg0, String arg1, String operator) {

        if (arg1.equalsIgnoreCase("firstname") && arg0.equalsIgnoreCase("EmployeeId") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personId", PersonIDs.get(0)).queryParam("firstName", PersonFirstName.get(0));
        } else if (arg1.equalsIgnoreCase("lastname") && arg0.equalsIgnoreCase("EmployeeId") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personId", PersonIDs.get(0)).queryParam("lastName", PersonLastName.get(0));
        } else if (arg1.equalsIgnoreCase("phone") && arg0.equalsIgnoreCase("EmployeeId") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personId", PersonIDs.get(0)).queryParam("phone", Personphones.get(0));
        } else if (arg1.equalsIgnoreCase("email") && arg0.equalsIgnoreCase("EmployeeId") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personId", PersonIDs.get(0)).queryParam("email", PersonEmails.get(0));
        } else if (arg1.equalsIgnoreCase("PersonCode") && arg0.equalsIgnoreCase("EmployeeId") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personId", PersonIDs.get(0)).queryParam("code", Personcodes.get(0));
        } else if (arg1.equalsIgnoreCase("PersonType") && arg0.equalsIgnoreCase("EmployeeId") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personId", PersonIDs.get(0)).queryParam("personType", PersonType.get(0));
        } else if (arg1.equalsIgnoreCase("UserId") && arg0.equalsIgnoreCase("EmployeeId") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personId", PersonIDs.get(0)).queryParam("userId", PersonUserIds.get(0));
        } else if (arg1.equalsIgnoreCase("EmployeeId") && arg0.equalsIgnoreCase("firstname") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("personId", PersonIDs.get(0));
        } else if (arg1.equalsIgnoreCase("LastName") && arg0.equalsIgnoreCase("firstname") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("lastName", PersonLastName.get(0));
        } else if (arg1.equalsIgnoreCase("Phone") && arg0.equalsIgnoreCase("firstname") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("phone", Personphones.get(0));
        } else if (arg1.equalsIgnoreCase("email") && arg0.equalsIgnoreCase("firstname") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("email", PersonEmails.get(0));
        } else if (arg1.equalsIgnoreCase("PersonCode") && arg0.equalsIgnoreCase("firstname") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("code", Personcodes.get(0));
        } else if (arg1.equalsIgnoreCase("PersonType") && arg0.equalsIgnoreCase("firstname") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("personType", PersonType.get(0));
        } else if (arg1.equalsIgnoreCase("UserId") && arg0.equalsIgnoreCase("firstname") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("userId", PersonUserIds.get(0));
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("employeeId") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("personId", PersonIDs.get(0));
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("firstname") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("firstName", PersonFirstName.get(0));
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("phone") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("phone", Personphones.get(0));
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("email") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("email", PersonEmails.get(0));
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("personType") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("personType", PersonType.get(0));
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("PersonCode") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("code", Personcodes.get(0));
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("UserId") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("userId", PersonUserIds.get(0));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("employeeId") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("phone", Personphones.get(0)).queryParam("personId", PersonIDs.get(0));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("firstname") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("phone", Personphones.get(0)).queryParam("firstName", PersonFirstName.get(0));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("LastName") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("phone", Personphones.get(0)).queryParam("lastName", PersonLastName.get(0));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("email") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("phone", Personphones.get(0)).queryParam("email", PersonEmails.get(0));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("personType") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("phone", Personphones.get(0)).queryParam("personType", PersonType.get(0));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("PersonCode") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("phone", Personphones.get(0)).queryParam("code", Personcodes.get(0));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("UserId") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("phone", PersonEmails.get(0)).queryParam("userId", PersonUserIds.get(0));
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("employeeId") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("email", PersonEmails.get(0)).queryParam("personId", PersonIDs.get(0));
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("firstname") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("email", PersonEmails.get(0)).queryParam("firstName", PersonFirstName.get(0));
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("lastname") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("email", PersonEmails.get(0)).queryParam("lastName", PersonLastName.get(0));
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("phone") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("email", PersonEmails.get(0)).queryParam("phone", Personphones.get(0));
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("personType") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("email", PersonEmails.get(0)).queryParam("personType", PersonType.get(0));
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("PersonCode") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("email", PersonEmails.get(0)).queryParam("code", Personcodes.get(0));
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("UserId") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("email", PersonEmails.get(0)).queryParam("userId", PersonUserIds.get(0));
        } else if (arg0.equalsIgnoreCase("personCode") && arg1.equalsIgnoreCase("employeeId") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("code", Personcodes.get(0)).queryParam("personId", PersonIDs.get(0));
        } else if (arg0.equalsIgnoreCase("personCode") && arg1.equalsIgnoreCase("firstname") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("code", Personcodes.get(0)).queryParam("firstName", PersonFirstName.get(0));
        } else if (arg0.equalsIgnoreCase("personCode") && arg1.equalsIgnoreCase("lastName") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("code", Personcodes.get(0)).queryParam("lastName", PersonLastName.get(0));
        } else if (arg0.equalsIgnoreCase("personCode") && arg1.equalsIgnoreCase("phone") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("code", Personcodes.get(0)).queryParam("phone", Personphones.get(0));
        } else if (arg0.equalsIgnoreCase("personCode") && arg1.equalsIgnoreCase("personType") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("code", Personcodes.get(0)).queryParam("personType", PersonType.get(0));
        } else if (arg0.equalsIgnoreCase("personCode") && arg1.equalsIgnoreCase("Email") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("code", Personcodes.get(0)).queryParam("email", PersonEmails.get(0));
        } else if (arg0.equalsIgnoreCase("personCode") && arg1.equalsIgnoreCase("UserId") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("code", Personcodes.get(0)).queryParam("userId", PersonUserIds.get(0));
        } else if (arg0.equalsIgnoreCase("personType") && arg1.equalsIgnoreCase("employeeId") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personType", PersonType.get(0)).queryParam("personId", PersonIDs.get(0));
        } else if (arg0.equalsIgnoreCase("personType") && arg1.equalsIgnoreCase("firstname") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personType", PersonType.get(0)).queryParam("firstName", PersonFirstName.get(0));
        } else if (arg0.equalsIgnoreCase("personType") && arg1.equalsIgnoreCase("lastName") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personType", PersonType.get(0)).queryParam("lastName", PersonLastName.get(0));
        } else if (arg0.equalsIgnoreCase("personType") && arg1.equalsIgnoreCase("phone") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personType", PersonType.get(0)).queryParam("phone", Personphones.get(0));
        } else if (arg0.equalsIgnoreCase("personType") && arg1.equalsIgnoreCase("PersonCode") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personType", PersonType.get(0)).queryParam("code", Personcodes.get(0));
        } else if (arg0.equalsIgnoreCase("personType") && arg1.equalsIgnoreCase("email") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personType", PersonType.get(0)).queryParam("eamil", PersonEmails.get(0));
        } else if (arg0.equalsIgnoreCase("personType") && arg1.equalsIgnoreCase("UserId") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personType", PersonType.get(0)).queryParam("userId", PersonUserIds.get(0));
        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("employeeId") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("userId", PersonUserIds.get(0)).queryParam("personId", PersonIDs.get(1));
        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("firstname") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("userId", PersonUserIds.get(0)).queryParam("firstName", PersonFirstName.get(1));
        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("lastName") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("userId", PersonUserIds.get(0)).queryParam("lastName", PersonLastName.get(1));
        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("phone") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("userId", PersonUserIds.get(0)).queryParam("phone", Personphones.get(0));
        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("PersonCode") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("userId", PersonUserIds.get(0)).queryParam("code", Personcodes.get(0));
        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("email") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("userId", PersonUserIds.get(0)).queryParam("eamil", PersonEmails.get(0));
        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("PersonType") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("userId", PersonUserIds.get(0)).queryParam("personType", PersonType.get(0));
        } else if (arg1.equalsIgnoreCase("firstname") && arg0.equalsIgnoreCase("EmployeeId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("personId", PersonIDs.get(0)).queryParam("firstName", PersonFirstName.get(0));
        } else if (arg1.equalsIgnoreCase("lastname") && arg0.equalsIgnoreCase("EmployeeId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("personId", PersonIDs.get(0)).queryParam("lastName", PersonLastName.get(0));
        } else if (arg1.equalsIgnoreCase("phone") && arg0.equalsIgnoreCase("EmployeeId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("personId", PersonIDs.get(0)).queryParam("phone", Personphones.get(0));
        } else if (arg1.equalsIgnoreCase("email") && arg0.equalsIgnoreCase("EmployeeId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("personId", PersonIDs.get(0)).queryParam("email", PersonEmails.get(0));
        } else if (arg1.equalsIgnoreCase("PersonCode") && arg0.equalsIgnoreCase("EmployeeId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("personId", PersonIDs.get(0)).queryParam("code", Personcodes.get(0));
        } else if (arg1.equalsIgnoreCase("PersonType") && arg0.equalsIgnoreCase("EmployeeId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("personId", PersonIDs.get(0)).queryParam("personType", PersonType.get(0));
        } else if (arg1.equalsIgnoreCase("UserId") && arg0.equalsIgnoreCase("EmployeeId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("personId", PersonIDs.get(0)).queryParam("userId", PersonUserIds.get(0));
        } else if (arg1.equalsIgnoreCase("EmployeeId") && arg0.equalsIgnoreCase("firstname") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("personId", PersonIDs.get(0));
        } else if (arg1.equalsIgnoreCase("LastName") && arg0.equalsIgnoreCase("firstname") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("lastName", PersonLastName.get(0));
        } else if (arg1.equalsIgnoreCase("Phone") && arg0.equalsIgnoreCase("firstname") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("phone", Personphones.get(0));
        } else if (arg1.equalsIgnoreCase("email") && arg0.equalsIgnoreCase("firstname") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("email", PersonEmails.get(0));
        } else if (arg1.equalsIgnoreCase("PersonCode") && arg0.equalsIgnoreCase("firstname") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("code", Personcodes.get(0));
        } else if (arg1.equalsIgnoreCase("PersonType") && arg0.equalsIgnoreCase("firstname") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("personType", PersonType.get(0));
        } else if (arg1.equalsIgnoreCase("UserId") && arg0.equalsIgnoreCase("firstname") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("userId", PersonUserIds.get(0));
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("employeeId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("personId", PersonIDs.get(0));
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("firstname") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("firstName", PersonFirstName.get(0));
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("phone") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("phone", Personphones.get(0));
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("email") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("email", PersonEmails.get(0));
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("personType") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("personType", PersonType.get(0));
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("PersonCode") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("code", Personcodes.get(0));
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("UserId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("userId", PersonUserIds.get(0));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("employeeId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("phone", Personphones.get(0)).queryParam("personId", PersonIDs.get(0));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("firstname") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("phone", Personphones.get(0)).queryParam("firstName", PersonFirstName.get(0));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("LastName") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("phone", Personphones.get(0)).queryParam("lastName", PersonLastName.get(0));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("email") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("phone", Personphones.get(0)).queryParam("email", PersonEmails.get(0));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("personType") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("phone", Personphones.get(0)).queryParam("personType", PersonType.get(0));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("PersonCode") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("phone", Personphones.get(0)).queryParam("code", Personcodes.get(0));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("UserId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("phone", PersonEmails.get(0)).queryParam("userId", PersonUserIds.get(0));
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("employeeId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("email", PersonEmails.get(0)).queryParam("personId", PersonIDs.get(0));
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("firstname") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("email", PersonEmails.get(0)).queryParam("firstName", PersonFirstName.get(0));
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("lastname") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("email", PersonEmails.get(0)).queryParam("lastName", PersonLastName.get(0));
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("phone") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("email", PersonEmails.get(0)).queryParam("phone", Personphones.get(0));
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("personType") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("email", PersonEmails.get(0)).queryParam("personType", PersonType.get(0));
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("PersonCode") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("email", PersonEmails.get(0)).queryParam("code", Personcodes.get(0));
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("UserId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("email", PersonEmails.get(0)).queryParam("userId", PersonUserIds.get(0));
        } else if (arg0.equalsIgnoreCase("personCode") && arg1.equalsIgnoreCase("employeeId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("code", Personcodes.get(0)).queryParam("personId", PersonIDs.get(0));
        } else if (arg0.equalsIgnoreCase("personCode") && arg1.equalsIgnoreCase("firstname") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("code", Personcodes.get(0)).queryParam("firstName", PersonFirstName.get(0));
        } else if (arg0.equalsIgnoreCase("personCode") && arg1.equalsIgnoreCase("lastName") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("code", Personcodes.get(0)).queryParam("lastName", PersonLastName.get(0));
        } else if (arg0.equalsIgnoreCase("personCode") && arg1.equalsIgnoreCase("phone") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("code", Personcodes.get(0)).queryParam("phone", Personphones.get(0));
        } else if (arg0.equalsIgnoreCase("personCode") && arg1.equalsIgnoreCase("personType") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("code", Personcodes.get(0)).queryParam("personType", PersonType.get(0));
        } else if (arg0.equalsIgnoreCase("personCode") && arg1.equalsIgnoreCase("Email") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("code", Personcodes.get(0)).queryParam("email", PersonEmails.get(0));
        } else if (arg0.equalsIgnoreCase("personCode") && arg1.equalsIgnoreCase("UserId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("code", Personcodes.get(0)).queryParam("userId", PersonUserIds.get(0));
        } else if (arg0.equalsIgnoreCase("personType") && arg1.equalsIgnoreCase("employeeId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("personType", PersonType.get(0)).queryParam("personId", PersonIDs.get(0));
        } else if (arg0.equalsIgnoreCase("personType") && arg1.equalsIgnoreCase("firstname") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("personType", PersonType.get(0)).queryParam("firstName", PersonFirstName.get(0));
        } else if (arg0.equalsIgnoreCase("personType") && arg1.equalsIgnoreCase("lastName") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("personType", PersonType.get(0)).queryParam("lastName", PersonLastName.get(0));
        } else if (arg0.equalsIgnoreCase("personType") && arg1.equalsIgnoreCase("phone") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("personType", PersonType.get(0)).queryParam("phone", Personphones.get(0));
        } else if (arg0.equalsIgnoreCase("personType") && arg1.equalsIgnoreCase("PersonCode") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("personType", PersonType.get(0)).queryParam("code", Personcodes.get(0));
        } else if (arg0.equalsIgnoreCase("personType") && arg1.equalsIgnoreCase("email") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("personType", PersonType.get(0)).queryParam("eamil", PersonEmails.get(0));
        } else if (arg0.equalsIgnoreCase("personType") && arg1.equalsIgnoreCase("UserId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("personType", PersonType.get(0)).queryParam("userId", PersonUserIds.get(0));
        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("employeeId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("userId", PersonUserIds.get(0)).queryParam("personId", PersonIDs.get(0));
        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("firstname") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("userId", PersonUserIds.get(0)).queryParam("firstName", PersonFirstName.get(0));
        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("lastName") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("userId", PersonUserIds.get(0)).queryParam("lastName", PersonLastName.get(0));
        } else if (arg0.equalsIgnoreCase("UserId") && arg1.equalsIgnoreCase("phone") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("userId", PersonUserIds.get(0)).queryParam("phone", Personphones.get(0));
        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("PersonCode") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("userId", PersonUserIds.get(0)).queryParam("code", Personcodes.get(0));
        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("email") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("userId", PersonUserIds.get(0)).queryParam("eamil", PersonEmails.get(0));
        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("PersonType") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "OR")
                    .queryParam("userId", PersonUserIds.get(0)).queryParam("personType", PersonType.get(0));
        } else {
            System.out.println("none of the combinations are matched.");
        }
    }

    @Given("payload to filter a Person by valid {string} AND invalid {string}")
    public void payloadToFilterAPersonByValidANDInvalid(String arg0, String arg1) {
        if (arg0.equalsIgnoreCase("FirstName") && arg1.equalsIgnoreCase("personId")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("personId", properties.getProperty("invalidEmpId"));
        } else if (arg0.equalsIgnoreCase("FirstName") && arg1.equalsIgnoreCase("LastName")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("lastName", properties.getProperty("invalidLastName"));

        } else if (arg0.equalsIgnoreCase("FirstName") && arg1.equalsIgnoreCase("phone")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("phone", properties.getProperty("invalidPhone"));

        } else if (arg0.equalsIgnoreCase("FirstName") && arg1.equalsIgnoreCase("email")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("email", properties.getProperty("invalidEmailId"));

        } else if (arg0.equalsIgnoreCase("FirstName") && arg1.equalsIgnoreCase("PersonCode")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("code", properties.getProperty("invalidPersonCode"));

        } else if (arg0.equalsIgnoreCase("FirstName") && arg1.equalsIgnoreCase("personType")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("personType", properties.getProperty("invalidPersonType"));

        } else if (arg0.equalsIgnoreCase("FirstName") && arg1.equalsIgnoreCase("UserId")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("userId", properties.getProperty("invalidUserId"));
        } else if (arg0.equalsIgnoreCase("PersonId") && arg1.equalsIgnoreCase("FirstName")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personId", PersonIDs.get(0))
                    .queryParam("firstName", properties.getProperty("invalidFirstName"));
        } else if (arg0.equalsIgnoreCase("PersonId") && arg1.equalsIgnoreCase("LastName")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personId", PersonIDs.get(0))
                    .queryParam("lastName", properties.getProperty("invalidLastName"));

        } else if (arg0.equalsIgnoreCase("PersonId") && arg1.equalsIgnoreCase("phone")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personId", PersonIDs.get(0))
                    .queryParam("phone", properties.getProperty("invalidPhone"));

        } else if (arg0.equalsIgnoreCase("PersonId") && arg1.equalsIgnoreCase("email")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personId", PersonIDs.get(0))
                    .queryParam("email", properties.getProperty("invalidEmailId"));

        } else if (arg0.equalsIgnoreCase("PersonId") && arg1.equalsIgnoreCase("PersonCode")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personId", PersonIDs.get(0))
                    .queryParam("code", properties.getProperty("invalidPersonCode"));

        } else if (arg0.equalsIgnoreCase("PersonId") && arg1.equalsIgnoreCase("personType")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personId", PersonIDs.get(0))
                    .queryParam("personType", properties.getProperty("invalidPersonType"));

        } else if (arg0.equalsIgnoreCase("PersonId") && arg1.equalsIgnoreCase("UserId")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personId", PersonIDs.get(0))
                    .queryParam("userId", properties.getProperty("invalidUserId"));

        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("FirstName")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("firstName", properties.getProperty("invalidFirstName"));

        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("personId")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("personId", properties.getProperty("invalidEmpId"));

        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("phone")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("phone", properties.getProperty("invalidPhone"));

        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("email")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("email", properties.getProperty("invalidEmailId"));

        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("PersonCode")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("code", properties.getProperty("invalidPersonCode"));

        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("personType")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("personType", properties.getProperty("invalidPersonType"));

        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("UserId")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("userId", properties.getProperty("invalidUserId"));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("FirstName")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("firstName", properties.getProperty("invalidFirstName"));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("personId")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("personId", properties.getProperty("invalidEmpId"));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("lastName")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("lastName", properties.getProperty("invalidLastName"));

        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("email")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("email", properties.getProperty("invalidEmailId"));

        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("PersonCode")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("code", properties.getProperty("invalidPersonCode"));

        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("personType")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("personType", properties.getProperty("invalidPersonType"));

        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("UserId")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("userId", properties.getProperty("invalidUserId"));
        } else if (arg0.equalsIgnoreCase("personCode") && arg1.equalsIgnoreCase("FirstName")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("firstName", properties.getProperty("invalidFirstName"));
        } else if (arg0.equalsIgnoreCase("personCode") && arg1.equalsIgnoreCase("personId")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("personId", properties.getProperty("invalidEmpId"));

        } else if (arg0.equalsIgnoreCase("personCode") && arg1.equalsIgnoreCase("lastName")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("lastName", properties.getProperty("invalidLastName"));

        } else if (arg0.equalsIgnoreCase("personCode") && arg1.equalsIgnoreCase("email")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("email", properties.getProperty("invalidEmailId"));

        } else if (arg0.equalsIgnoreCase("personCode") && arg1.equalsIgnoreCase("phone")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("phone", properties.getProperty("invalidPhone"));

        } else if (arg0.equalsIgnoreCase("personCode") && arg1.equalsIgnoreCase("personType")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("personType", properties.getProperty("invalidPersonType"));

        } else if (arg0.equalsIgnoreCase("personCode") && arg1.equalsIgnoreCase("UserId")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("userId", properties.getProperty("invalidUserId"));

        } else if (arg0.equalsIgnoreCase("personType") && arg1.equalsIgnoreCase("FirstName")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("firstName", properties.getProperty("invalidFirstName"));

        } else if (arg0.equalsIgnoreCase("personType") && arg1.equalsIgnoreCase("personId")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("personId", properties.getProperty("invalidEmpId"));

        } else if (arg0.equalsIgnoreCase("personType") && arg1.equalsIgnoreCase("lastName")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("lastName", properties.getProperty("invalidLastName"));

        } else if (arg0.equalsIgnoreCase("personType") && arg1.equalsIgnoreCase("email")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("email", properties.getProperty("invalidEmailId"));

        } else if (arg0.equalsIgnoreCase("personType") && arg1.equalsIgnoreCase("phone")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("phone", properties.getProperty("invalidPhone"));

        } else if (arg0.equalsIgnoreCase("personType") && arg1.equalsIgnoreCase("personCode")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("code", properties.getProperty("invalidPersonCode"));

        } else if (arg0.equalsIgnoreCase("personType") && arg1.equalsIgnoreCase("UserId")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("userId", properties.getProperty("invalidUserId"));
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("FirstName")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("firstName", properties.getProperty("invalidFirstName"));

        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("personId")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("personId", properties.getProperty("invalidEmpId"));

        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("lastName")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personType", PersonEmails.get(0))
                    .queryParam("lastName", properties.getProperty("invalidLastName"));

        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("PersonType")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("personType", properties.getProperty("invalidPersonType"));

        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("phone")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personType", PersonEmails.get(0))
                    .queryParam("phone", properties.getProperty("invalidPhone"));

        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("personCode")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personType", PersonEmails.get(0))
                    .queryParam("code", properties.getProperty("invalidPersonCode"));

        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("UserId")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("personType", PersonEmails.get(0))
                    .queryParam("userId", properties.getProperty("invalidUserId"));
        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("FirstName")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("firstName", properties.getProperty("invalidFirstName"));

        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("personId")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("personId", properties.getProperty("invalidEmpId"));

        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("lastName")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("lastName", properties.getProperty("invalidLastName"));

        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("email")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("userId", PersonType.get(0))
                    .queryParam("email", properties.getProperty("invalidEmailId"));

        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("phone")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("phone", properties.getProperty("invalidPhone"));

        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("personType")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("personType", properties.getProperty("invalidPersonType"));

        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("PersonCode")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("operator", "AND")
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("code", properties.getProperty("invalidPersonCode"));
        }
    }

    @Given("payload to filter a person with case-insensitive {string} and case-sensitive {string} when case-sensitive is {string} and operator is {string}")
    public void payloadToFilterAPersonWithCaseInsensitiveAndCaseSensitiveWhenCaseSensitiveIsAndOperatorIs(String arg0, String arg1, String caseSensitive, String operator) {
        if (arg0.equalsIgnoreCase("firstname") && arg1.equalsIgnoreCase("lastname") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", PersonFirstName.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("firstname") && arg1.equalsIgnoreCase("PersonCode") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", PersonFirstName.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("firstname") && arg1.equalsIgnoreCase("email") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", PersonFirstName.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("email") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", PersonLastName.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("PersonCode") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", PersonLastName.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", PersonLastName.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("PersonCode") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("code", Personcodes.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("PersonCode") && arg1.equalsIgnoreCase("lastName") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("code", Personcodes.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("PersonCode") && arg1.equalsIgnoreCase("email") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("code", Personcodes.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("Email") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", PersonEmails.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("Email") && arg1.equalsIgnoreCase("lastName") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", PersonEmails.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("Email") && arg1.equalsIgnoreCase("PersonCode") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", PersonEmails.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("firstname") && arg1.equalsIgnoreCase("lastname") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", PersonFirstName.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("firstname") && arg1.equalsIgnoreCase("PersonCode") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", PersonFirstName.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("firstname") && arg1.equalsIgnoreCase("email") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", PersonFirstName.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("email") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", PersonLastName.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("PersonCode") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", PersonLastName.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", PersonLastName.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("PersonCode") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("code", Personcodes.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("PersonCode") && arg1.equalsIgnoreCase("lastName") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("code", Personcodes.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("PersonCode") && arg1.equalsIgnoreCase("email") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("code", Personcodes.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("Email") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", PersonEmails.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("Email") && arg1.equalsIgnoreCase("lastName") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", PersonEmails.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("Email") && arg1.equalsIgnoreCase("PersonCode") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", PersonEmails.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("firstname") && arg1.equalsIgnoreCase("lastname") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", PersonFirstName.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("firstname") && arg1.equalsIgnoreCase("PersonCode") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", PersonFirstName.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("firstname") && arg1.equalsIgnoreCase("email") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", PersonFirstName.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("email") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", PersonLastName.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("PersonCode") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", PersonLastName.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", PersonLastName.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("PersonCode") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("code", Personcodes.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("PersonCode") && arg1.equalsIgnoreCase("lastName") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("code", Personcodes.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("PersonCode") && arg1.equalsIgnoreCase("email") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("code", Personcodes.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("Email") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", PersonEmails.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("Email") && arg1.equalsIgnoreCase("lastName") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", PersonEmails.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("Email") && arg1.equalsIgnoreCase("PersonCode") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", PersonEmails.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("firstname") && arg1.equalsIgnoreCase("lastname") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", PersonFirstName.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("firstname") && arg1.equalsIgnoreCase("PersonCode") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", PersonFirstName.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("firstname") && arg1.equalsIgnoreCase("email") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", PersonFirstName.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("email") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", PersonLastName.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("PersonCode") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", PersonLastName.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", PersonLastName.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("PersonCode") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("code", Personcodes.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("PersonCode") && arg1.equalsIgnoreCase("lastName") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("code", Personcodes.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("PersonCode") && arg1.equalsIgnoreCase("email") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("code", Personcodes.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("Email") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", PersonEmails.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("Email") && arg1.equalsIgnoreCase("lastName") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", PersonEmails.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("Email") && arg1.equalsIgnoreCase("PersonCode") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", PersonEmails.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        }

    }

    @Given("payload to filter a Person by passing toggleKeytoURL is {string}")
    public void payloadToFilterAPersonByPassingToggleKeytoURLIs(String arg0) {
        if (arg0.equalsIgnoreCase("true")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("personId", PersonIDs.get(1))
                    .queryParam("toggleKeyToURL", "true");
        } else if (arg0.equalsIgnoreCase("false")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("personId", PersonIDs.get(0))
                    .queryParam("toggleKeyToURL", "false");
        }
    }

    @Then("validate response code and profile photo key")
    public void validateResponseCodeAndProfilePhotoKey() {
        List<String> profilePhoto = validation_responseObj.jsonPath().getList("data.person.profilePhotoKey");
        validation_responseObj.then().log().all().spec(responseSpecification(200))
                .body("message", equalTo("Success."))
                .body("data.person.profilePhotoKey", equalTo(profilePhoto));

    }

    @Then("validate response code and profile photo key as null")
    public void validateResponseCodeAndProfilePhotoKeyAsNull() {
        List<String> profilePhoto = validation_responseObj.jsonPath().getList("data.person.profilePhotoKey");
        validation_responseObj.then().log().all().spec(responseSpecification(200))
                .body("message", equalTo("Success."))
                .body("data.person.profilePhotoKey", equalTo(profilePhoto));
    }


    @Given("payload to filter a person with {string}, {string} and {string} when case-sensitive is {string} and operator is {string}")
    public void payloadToFilterAPersonWithAndWhenCaseSensitiveIsAndOperatorIs(String arg0, String arg1, String arg2, String arg3, String arg4) {
        if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("firstName") &&
                arg2.equalsIgnoreCase("lastName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("firstName") &&
                arg2.equalsIgnoreCase("phone") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("firstName") &&
                arg2.equalsIgnoreCase("personCode") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("firstName") &&
                arg2.equalsIgnoreCase("email") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("firstName") &&
                arg2.equalsIgnoreCase("PersonType") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("firstName") &&
                arg2.equalsIgnoreCase("UserId") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");

        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("lastName") &&
                arg2.equalsIgnoreCase("firstName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("lastName") &&
                arg2.equalsIgnoreCase("phone") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("lastName") &&
                arg2.equalsIgnoreCase("personCode") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("lastName") &&
                arg2.equalsIgnoreCase("email") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("lastName") &&
                arg2.equalsIgnoreCase("PersonType") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("lastName") &&
                arg2.equalsIgnoreCase("UserId") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");

        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personCode") &&
                arg2.equalsIgnoreCase("firstName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personCode") &&
                arg2.equalsIgnoreCase("phone") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personCode") &&
                arg2.equalsIgnoreCase("lastName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personCode") &&
                arg2.equalsIgnoreCase("email") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personCode") &&
                arg2.equalsIgnoreCase("PersonType") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personCode") &&
                arg2.equalsIgnoreCase("UserId") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");

        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("phone") &&
                arg2.equalsIgnoreCase("firstName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("phone") &&
                arg2.equalsIgnoreCase("personCode") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("phone") &&
                arg2.equalsIgnoreCase("lastName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("phone") &&
                arg2.equalsIgnoreCase("email") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("phone") &&
                arg2.equalsIgnoreCase("PersonType") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("phone") &&
                arg2.equalsIgnoreCase("UserId") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");

        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("email") &&
                arg2.equalsIgnoreCase("firstName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("email") &&
                arg2.equalsIgnoreCase("personCode") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("email") &&
                arg2.equalsIgnoreCase("lastName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("email") &&
                arg2.equalsIgnoreCase("phone") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("email") &&
                arg2.equalsIgnoreCase("PersonType") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("email") &&
                arg2.equalsIgnoreCase("UserId") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personType") &&
                arg2.equalsIgnoreCase("firstName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personType") &&
                arg2.equalsIgnoreCase("personCode") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personType") &&
                arg2.equalsIgnoreCase("lastName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personType") &&
                arg2.equalsIgnoreCase("phone") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personType") &&
                arg2.equalsIgnoreCase("email") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personType") &&
                arg2.equalsIgnoreCase("UserId") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");

        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("userId") &&
                arg2.equalsIgnoreCase("firstName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("userId") &&
                arg2.equalsIgnoreCase("personCode") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("userId") &&
                arg2.equalsIgnoreCase("lastName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("userId") &&
                arg2.equalsIgnoreCase("phone") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("userId") &&
                arg2.equalsIgnoreCase("email") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("userId") &&
                arg2.equalsIgnoreCase("personType") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("firstName") &&
                arg2.equalsIgnoreCase("lastName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("firstName") &&
                arg2.equalsIgnoreCase("phone") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("firstName") &&
                arg2.equalsIgnoreCase("personCode") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("firstName") &&
                arg2.equalsIgnoreCase("email") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("firstName") &&
                arg2.equalsIgnoreCase("PersonType") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("firstName") &&
                arg2.equalsIgnoreCase("UserId") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");

        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("lastName") &&
                arg2.equalsIgnoreCase("firstName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("lastName") &&
                arg2.equalsIgnoreCase("phone") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("lastName") &&
                arg2.equalsIgnoreCase("personCode") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("lastName") &&
                arg2.equalsIgnoreCase("email") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("lastName") &&
                arg2.equalsIgnoreCase("PersonType") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("lastName") &&
                arg2.equalsIgnoreCase("UserId") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");

        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personCode") &&
                arg2.equalsIgnoreCase("firstName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personCode") &&
                arg2.equalsIgnoreCase("phone") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personCode") &&
                arg2.equalsIgnoreCase("lastName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personCode") &&
                arg2.equalsIgnoreCase("email") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personCode") &&
                arg2.equalsIgnoreCase("PersonType") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personCode") &&
                arg2.equalsIgnoreCase("UserId") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");

        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("phone") &&
                arg2.equalsIgnoreCase("firstName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("phone") &&
                arg2.equalsIgnoreCase("personCode") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("phone") &&
                arg2.equalsIgnoreCase("lastName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("phone") &&
                arg2.equalsIgnoreCase("email") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("phone") &&
                arg2.equalsIgnoreCase("PersonType") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("phone") &&
                arg2.equalsIgnoreCase("UserId") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");

        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("email") &&
                arg2.equalsIgnoreCase("firstName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("email") &&
                arg2.equalsIgnoreCase("personCode") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("email") &&
                arg2.equalsIgnoreCase("lastName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("email") &&
                arg2.equalsIgnoreCase("phone") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("email") &&
                arg2.equalsIgnoreCase("PersonType") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("email") &&
                arg2.equalsIgnoreCase("UserId") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personType") &&
                arg2.equalsIgnoreCase("firstName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personType") &&
                arg2.equalsIgnoreCase("personCode") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personType") &&
                arg2.equalsIgnoreCase("lastName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personType") &&
                arg2.equalsIgnoreCase("phone") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personType") &&
                arg2.equalsIgnoreCase("email") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("personType") &&
                arg2.equalsIgnoreCase("UserId") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");

        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("userId") &&
                arg2.equalsIgnoreCase("firstName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("firstName", PersonFirstName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("userId") &&
                arg2.equalsIgnoreCase("personCode") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("code", Personcodes.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("userId") &&
                arg2.equalsIgnoreCase("lastName") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("lastName", PersonLastName.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("userId") &&
                arg2.equalsIgnoreCase("phone") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("phone", Personphones.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("userId") &&
                arg2.equalsIgnoreCase("email") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("email", PersonEmails.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("employeeid") && arg1.equalsIgnoreCase("userId") &&
                arg2.equalsIgnoreCase("personType") && arg3.equalsIgnoreCase("true") && arg4.equalsIgnoreCase("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("employeeId", PersonIDs.get(0).toLowerCase())
                    .queryParam("userId", PersonUserIds.get(0))
                    .queryParam("personType", PersonType.get(0))
                    .queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        }


    }

    @Given("payload to delete created person based on id")
    public void payloadToDeleteCreatedPersonBasedOnId() {
        validation_responseObj.then().log().all();
        List<String> code = validation_responseObj.jsonPath().getList("data.person.id");
        for (int i = 0; i < code.size(); i++) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token));
            validation_responseObj = reqSpec.delete("api/v3/person/" + code.get(i));
            validation_responseObj.then().log().all().body("message", equalTo("Person Deleted successfully."));
        }

    }

//Employee Filte Added By Sambit on 01st Mar 2023

    //Employee Creation

    @Given("payload to create a Employee and user by providing create user as true")
    public void payloadToCreateAEmployeeAndUserByProvidingCreateUserAsTrue() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token))
                .body(Payloads.addEmployee("Dev" + fname, "Ls" + lname, "perr" + email, Phone, "M", "12-01-2022", "hindu", "", "", "ii" + code, "", "Active", "Permanent", "\"\"", "+91-", "04-01-1999", "", "", "", "izy70322", true));

    }

    @Given("payload to create a employee by providing all required parameter datas")
    public void payloadToCreateAEmployeeByProvidingAllRequiredParameterDatas() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token))
                .body(Payloads.addEmployee("Dev" + fname, "Ls" + lname, "perr" + email, Phone, "M", "12-01-2022", "hindu", "", "", "izy" + code, "", "Inactive", "Contract", "\"\"", "+91-", "04-01-1999", "", "", "", "izy70322", false));
    }

    @Given("payload to create a employee by providing all required parameter datas and JobType as Temporary")
    public void payloadToCreateAEmployeeByProvidingAllRequiredParameterDatasAndJobTypeAsTemporary() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token))
                .body(Payloads.addEmployee("Dev" + fname, "Ls" + lname, "perr" + email, Phone, "M", "12-01-2022", "hindu", "", "", "izy" + code, "", "Inactive", "Temporary", "\"\"", "+91-", "04-01-1999", "", "", "", "izy70322", false));
    }

    @When("user calls create employee API with POST http request")
    public void userCallsCreateEmployeeAPIWithPOSTHttpRequest() {
        validation_responseObj = reqSpec.post("/api/v3/employee");
    }

    @Then("validate response code and response message for successfull employee creation userid")
    public void validateResponseCodeAndResponseMessageForSuccessfullEmployeeCreationUserid() {
        validation_responseObj.then().log().all();
        ValidatableResponse re = validation_responseObj.then().log().all().spec(responseSpecification(200)).body("message", equalTo("Employee Created Successfully."));
        EmployeeIDs.add(0, getJsonPath(validation_responseObj, "data.id"));
        EmployeeCodes.add(0, getJsonPath(validation_responseObj, "data.code"));
        EmployeeEmails.add(0, getJsonPath(validation_responseObj, "data.email"));
        Employeephones.add(0, getJsonPath(validation_responseObj, "data.phone"));
        EmployeeType.add(0, getJsonPath(validation_responseObj, "data.personType"));
        EmployeeFirstName.add(0, getJsonPath(validation_responseObj, "data.firstName"));
        EmployeeLastName.add(0, getJsonPath(validation_responseObj, "data.lastName"));
        EmployeeJobType.add(0, getJsonPath(validation_responseObj, "data.jobType"));
        EmployeeDesignationId.add(0, getJsonPath(validation_responseObj, "data.designationId"));
        EmployeeDepartmentId.add(0, getJsonPath(validation_responseObj, "data.departmentId"));
        EmployeeSiteId.add(0, getJsonPath(validation_responseObj, "data.siteId"));
        EmployeeStatus.add(0, getJsonPath(validation_responseObj, "data.status"));
        EmployeeUserIds.add(0, getJsonPath(validation_responseObj, "data.userId"));
    }

    @Then("validate response code and response message for successfull employee creation")
    public void validateResponseCodeAndResponseMessageForSuccessfullEmployeeCreation() {
        ValidatableResponse re = validation_responseObj.then().log().all().spec(responseSpecification(200)).body("message", equalTo("Employee Created Successfully."));
        EmployeeIDs.add(1, getJsonPath(validation_responseObj, "data.id"));
        EmployeeCodes.add(1, getJsonPath(validation_responseObj, "data.code"));
        EmployeeEmails.add(1, getJsonPath(validation_responseObj, "data.email"));
        Employeephones.add(1, getJsonPath(validation_responseObj, "data.phone"));
        EmployeeType.add(1, getJsonPath(validation_responseObj, "data.personType"));
        EmployeeFirstName.add(1, getJsonPath(validation_responseObj, "data.firstName"));
        EmployeeLastName.add(1, getJsonPath(validation_responseObj, "data.lastName"));
        EmployeeJobType.add(1, getJsonPath(validation_responseObj, "data.jobType"));
        EmployeeDesignationId.add(1, getJsonPath(validation_responseObj, "data.designationId"));
        EmployeeDepartmentId.add(1, getJsonPath(validation_responseObj, "data.departmentId"));
        // EmployeeSiteId.add(1, getJsonPath(validation_responseObj, "data.siteId"));
        EmployeeStatus.add(1, getJsonPath(validation_responseObj, "data.status"));

    }

    @When("user calls filter Employee API with POST http request")
    public void userCallsFilterEmployeeAPIWithPOSTHttpRequest() {
        validation_responseObj = reqSpec.post("/api/v3/employees/list");
    }

    @Then("validate response code and response message for successfull fiter the Employee")
    public void validateResponseCodeAndResponseMessageForSuccessfullFiterTheEmployee() {
        List<String> id = validation_responseObj.jsonPath().getList("data.employees.id");
        List<String> code = validation_responseObj.jsonPath().getList("data.employees.code");
        List<String> fname = validation_responseObj.jsonPath().getList("data.employees.firstName");
        List<String> lname = validation_responseObj.jsonPath().getList("data.employees.lastName");
        List<String> email = validation_responseObj.jsonPath().getList("data.employees.email");
        List<String> phone = validation_responseObj.jsonPath().getList("data.employees.phone");
        List<String> status = validation_responseObj.jsonPath().getList("data.employees.status");
        int totalCount = validation_responseObj.jsonPath().get("data.totalCount");
        int currentPage = validation_responseObj.jsonPath().get("data.currentPage");
        int totalPages = validation_responseObj.jsonPath().get("data.totalPages");
        int pageSize = validation_responseObj.jsonPath().get("data.pageSize");
        validation_responseObj.then().log().all().spec(responseSpecification(200))
                .body("message", equalTo("Success."))
                .body("data.totalCount", equalTo(totalCount))
                .body("data.currentPage", equalTo(currentPage))
                .body("data.totalPages", equalTo(totalPages))
                .body("data.pageSize", equalTo(pageSize))
                .body("data.employees.id", equalTo(id))
                .body("data.employees.code", equalTo(code))
                .body("data.employees.firstName", equalTo(fname))
                .body("data.employees.lastName", equalTo(lname))
                .body("data.employees.email", equalTo(email))
                .body("data.employees.phone", equalTo(phone))
                .body("data.employees.status", equalTo(status));

    }

    @Given("payload to filter a Employee by EmployeeId")
    public void payloadToFilterAEmployeeByEmployeeId() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("id", EmployeeIDs.get(0));
    }

    @Given("payload to filter a Employee by FirstName")
    public void payloadToFilterAEmployeeByFirstName() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("firstName", EmployeeFirstName.get(0));
    }

    @Given("payload to filter a Employee by LastName")
    public void payloadToFilterAEmployeeByLastName() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("lastName", EmployeeLastName.get(0));
    }

    @Given("payload to filter a Employee by Phone")
    public void payloadToFilterAEmployeeByPhone() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("phone", Employeephones.get(0));
    }

    @Given("payload to filter a Employee by Employee Code")
    public void payloadToFilterAEmployeeByEmployeeCode() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("code", EmployeeCodes.get(0));
    }

    @Given("payload to filter a Employee by Email")
    public void payloadToFilterAEmployeeByEmail() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("email", EmployeeEmails.get(0));
    }

    @Given("payload to filter a Employee by DepartmentId")
    public void payloadToFilterAEmployeeByDepartmentId() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("departmentId", EmployeeDepartmentId.get(0));
    }

    @Given("payload to filter a Employee by UserId")
    public void payloadToFilterAEmployeeByUserId() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("userId", EmployeeUserIds.get(0));
    }

    @Given("payload to filter a Employee by DesignationId")
    public void payloadToFilterAEmployeeByDesignationId() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("designationId", EmployeeDesignationId.get(0));
    }

    @Given("payload to filter a Employee by SiteId")
    public void payloadToFilterAEmployeeBySiteId() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("siteId", EmployeeSiteId.get(0));
    }

    @Given("payload to filter a Employee by Page Size as Zero")
    public void payloadToFilterAEmployeeByPageSizeAsZero() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("pageSize", 0);
    }

    @Given("payload to filter a Employee by Page Number")
    public void payloadToFilterAEmployeeByPageNumber() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("pageNumber", "1");
    }

    @Given("payload to filter a Employee by passing Status as {string}")
    public void payloadToFilterAEmployeeByPassingStatusAs(String arg0) {
        if (arg0.equalsIgnoreCase("active")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("status", arg0.toUpperCase());
        } else if (arg0.equalsIgnoreCase("inactive")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("status", arg0.toUpperCase());
        }

    }
    //Delete Employee

    @Given("payload to delete created employee based on id")
    public void payloadToDeleteCreatedEmployeeBasedOnId() throws InterruptedException {
        validation_responseObj.then().log().all();
        List<String> id = validation_responseObj.jsonPath().getList("data.employees.id");
        System.out.println(id);
        System.out.println(id.size());
        for (int i = 0; i < id.size(); i++) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token));
            validation_responseObj = reqSpec.delete("api/v3/employee/" + id.get(i));
            validation_responseObj.then().log().all().body("message", equalTo("Employee Deleted Successfully."));
        }
    }


    @Given("payload to filter a Employee by passing JobType as {string}")
    public void payloadToFilterAEmployeeByPassingJobTypeAs(String arg0) {
        if (arg0.equalsIgnoreCase("Permanent")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("jobType", arg0.toUpperCase());
        } else if (arg0.equalsIgnoreCase("Contract")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("jobType", arg0.toUpperCase());
        } else if (arg0.equalsIgnoreCase("Temporary")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token)).queryParam("jobType", arg0.toUpperCase());
        }
    }

    @Given("payload to filter a Employee by passing invalid employeeId")
    public void payloadToFilterAEmployeeByPassingInvalidEmployeeId() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("id", properties.getProperty("invalidEmpId"));
    }

    @Given("payload to filter a Employee by passing invalid first name")
    public void payloadToFilterAEmployeeByPassingInvalidFirstName() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("firstName", properties.getProperty("invalidFirstName"));
    }

    @Given("payload to filter a Employee by passing invalid last name")
    public void payloadToFilterAEmployeeByPassingInvalidLastName() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("lastName", properties.getProperty("invalidLastName"));
    }

    @Given("payload to filter a Employee by passing invalid phone")
    public void payloadToFilterAEmployeeByPassingInvalidPhone() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("phone", properties.getProperty("invalidPhone"));
    }

    @Given("payload to filter a Employee by passing invalid employee code")
    public void payloadToFilterAEmployeeByPassingInvalidEmployeeCode() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("code", properties.getProperty("invalidPersonCode"));
    }

    @Given("payload to filter a Employee by passing invalid email")
    public void payloadToFilterAEmployeeByPassingInvalidEmail() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("email", properties.getProperty("invalidEmailId"));
    }

    @Given("payload to filter a Employee by passing invalid departmentId")
    public void payloadToFilterAEmployeeByPassingInvalidDepartmentId() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("departmentId", properties.getProperty("invalidDepartmentId"));
    }

    @Given("payload to filter a Employee by passing invalid userId")
    public void payloadToFilterAEmployeeByPassingInvalidUserId() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("userId", properties.getProperty("invalidUserId"));
    }

    @Given("payload to filter a Employee by passing invalid designation Id")
    public void payloadToFilterAEmployeeByPassingInvalidDesignationId() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("designationId", properties.getProperty("invalidDesignationId"));
    }

    @Given("payload to filter a Employee by passing invalid siteId")
    public void payloadToFilterAEmployeeByPassingInvalidSiteId() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("siteId", properties.getProperty("invalidSiteId"));
    }

    @Then("validate response code and response message for unsuccessfull fiter the Employee")
    public void validateResponseCodeAndResponseMessageForUnsuccessfullFiterTheEmployee() {
        validation_responseObj.then().log().all().spec(responseSpecification(200))
                .body("message", equalTo("Success."))
                .body("data.totalCount", equalTo(0))
                .body("data.currentPage", equalTo(1))
                .body("data.totalPages", equalTo(0))
                .body("data.pageSize", equalTo(0));
    }

    @Given("payload to filter a Employee by Multiple Employee Id")
    public void payloadToFilterAEmployeeByMultipleEmployeeId() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("id", EmployeeIDs.get(0)).queryParam("id", EmployeeIDs.get(1));

    }

    @Given("payload to filter a Employee by Multiple User Id")
    public void payloadToFilterAEmployeeByMultipleUserId() {
        reqSpec = given().log().all().
                spec(requestSpecification1("Bearer " + Company_token)).queryParam("userId", EmployeeUserIds.get(0)).queryParam("id", EmployeeUserIds.get(0));

    }

    @Given("payload to filter a Employee by {string} AND {string} with Operator {string}")
    public void payloadToFilterAEmployeeByANDWithOperator(String arg0, String arg1, String arg2) {

        if (arg0.equalsIgnoreCase("employeeId") && arg1.equalsIgnoreCase("firstName")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("firstName", EmployeeFirstName.get(0));

        } else if (arg0.equalsIgnoreCase("employeeId") && arg1.equalsIgnoreCase("lastName")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("firstName", EmployeeLastName.get(0));

        } else if (arg0.equalsIgnoreCase("employeeId") && arg1.equalsIgnoreCase("phone")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("phone", Employeephones.get(0));

        } else if (arg0.equalsIgnoreCase("employeeId") && arg1.equalsIgnoreCase("email")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("email", EmployeeEmails.get(0));

        } else if (arg0.equalsIgnoreCase("employeeId") && arg1.equalsIgnoreCase("departmentId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("departmentId", EmployeeDepartmentId.get(0));

        } else if (arg0.equalsIgnoreCase("employeeId") && arg1.equalsIgnoreCase("designationId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("designationId", EmployeeDesignationId.get(0));

        } else if (arg0.equalsIgnoreCase("employeeId") && arg1.equalsIgnoreCase("userId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("userId", EmployeeUserIds.get(0));
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("employeeId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("firstName", EmployeeFirstName.get(0))
                    .queryParam("id", EmployeeIDs.get(0));

        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("lastName")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("firstName", EmployeeFirstName.get(0))
                    .queryParam("lastName", EmployeeLastName.get(0));

        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("phone")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("firstName", EmployeeFirstName.get(0))
                    .queryParam("phone", Employeephones.get(0));

        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("email")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("firstName", EmployeeFirstName.get(0))
                    .queryParam("email", EmployeeEmails.get(0));

        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("departmentId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("firstName", EmployeeFirstName.get(0))
                    .queryParam("departmentId", EmployeeDepartmentId.get(0));

        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("designationId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("firstName", EmployeeFirstName.get(0))
                    .queryParam("designationId", EmployeeDesignationId.get(0));

        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("EmployeeCode")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("firstName", EmployeeFirstName.get(0))
                    .queryParam("code", EmployeeCodes.get(0));

        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("siteId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("firstName", EmployeeFirstName.get(0))
                    .queryParam("siteId", EmployeeSiteId.get(0));

        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("userId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("firstName", EmployeeFirstName.get(0))
                    .queryParam("userId", EmployeeUserIds.get(0));

        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("employeeId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("id", EmployeeIDs.get(0));

        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("firstName")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("firstName", EmployeeFirstName.get(0));

        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("phone")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("phone", Employeephones.get(0));

        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("email")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("email", EmployeeEmails.get(0));

        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("departmentId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("departmentId", EmployeeDepartmentId.get(0));

        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("designationId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("designationId", EmployeeDesignationId.get(0));

        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("EmployeeCode")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("code", EmployeeCodes.get(0));

        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("siteId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("siteId", EmployeeSiteId.get(0));

        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("userId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("userId", EmployeeUserIds.get(0));

        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("employeeId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("id", EmployeeIDs.get(0));

        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("firstName")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("firstName", EmployeeFirstName.get(0));

        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("lastName")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("lastName", EmployeeLastName.get(0));

        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("email")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("email", EmployeeEmails.get(0));

        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("departmentId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("departmentId", EmployeeDepartmentId.get(0));

        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("designationId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("designationId", EmployeeDesignationId.get(0));

        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("EmployeeCode")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("code", EmployeeCodes.get(0));

        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("siteId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("siteId", EmployeeSiteId.get(0));

        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("userId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("userId", EmployeeUserIds.get(0));
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("EmployeeId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("email", EmployeeUserIds.get(0))
                    .queryParam("Id", EmployeeIDs.get(0));

        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("EmployeeId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("userId", EmployeeUserIds.get(0))
                    .queryParam("Id", EmployeeIDs.get(0));
        }

    }

    @Given("payload to filter a Employee by valid {string} AND invalid {string}")
    public void payloadToFilterAEmployeeByValidANDInvalid(String arg0, String arg1) {
        if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("EmployeeId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("firstName", EmployeeUserIds.get(0))
                    .queryParam("Id", properties.getProperty("invalidEmpId"));
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("lastName")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("firstName", EmployeeUserIds.get(0))
                    .queryParam("lastName", properties.getProperty("invalidLastName"));
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("Phone")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("firstName", EmployeeUserIds.get(0))
                    .queryParam("phone", properties.getProperty("invalidPhone"));
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("email")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("firstName", EmployeeUserIds.get(0))
                    .queryParam("email", properties.getProperty("invalidEmailId"));
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("EmployeeCode")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("firstName", EmployeeUserIds.get(0))
                    .queryParam("code", properties.getProperty("invalidPersonCode"));
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("departmentId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("firstName", EmployeeUserIds.get(0))
                    .queryParam("departmentId", properties.getProperty("invalidDepartmentId"));
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("designationId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("firstName", EmployeeUserIds.get(0))
                    .queryParam("designationId", properties.getProperty("invalidDesignationId"));
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("userId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("firstName", EmployeeUserIds.get(0))
                    .queryParam("userId", properties.getProperty("invalidUserId"));
        } else if (arg0.equalsIgnoreCase("EmployeeId") && arg1.equalsIgnoreCase("FirstName")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("firstName", properties.getProperty("invalidFirstName"));
        } else if (arg0.equalsIgnoreCase("EmployeeId") && arg1.equalsIgnoreCase("lastName")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("lastName", properties.getProperty("invalidLastName"));
        } else if (arg0.equalsIgnoreCase("EmployeeId") && arg1.equalsIgnoreCase("Phone")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("phone", properties.getProperty("invalidPhone"));
        } else if (arg0.equalsIgnoreCase("EmployeeId") && arg1.equalsIgnoreCase("email")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("email", properties.getProperty("invalidEmailId"));
        } else if (arg0.equalsIgnoreCase("EmployeeId") && arg1.equalsIgnoreCase("EmployeeCode")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("code", properties.getProperty("invalidPersonCode"));
        } else if (arg0.equalsIgnoreCase("EmployeeId") && arg1.equalsIgnoreCase("departmentId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("departmentId", properties.getProperty("invalidDepartmentId"));
        } else if (arg0.equalsIgnoreCase("EmployeeId") && arg1.equalsIgnoreCase("designationId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("designationId", properties.getProperty("invalidDesignationId"));
        } else if (arg0.equalsIgnoreCase("EmployeeId") && arg1.equalsIgnoreCase("userId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("userId", properties.getProperty("invalidUserId"));
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("EmployeeId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("id", properties.getProperty("invalidEmpId"));
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("firstName")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("firstName", properties.getProperty("invalidFirstName"));
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("Phone")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("phone", properties.getProperty("invalidPhone"));
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("email")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("email", properties.getProperty("invalidEmailId"));
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("EmployeeCode")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("code", properties.getProperty("invalidPersonCode"));
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("departmentId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("departmentId", properties.getProperty("invalidDepartmentId"));
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("designationId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("designationId", properties.getProperty("invalidDesignationId"));
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("userId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("userId", properties.getProperty("invalidUserId"));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("EmployeeId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("id", properties.getProperty("invalidEmpId"));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("firstName")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("firstName", properties.getProperty("invalidFirstName"));

        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("lastName")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("lastName", properties.getProperty("invalidLastName"));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("email")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("email", properties.getProperty("invalidEmailId"));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("EmployeeCode")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("code", properties.getProperty("invalidPersonCode"));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("departmentId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("departmentId", properties.getProperty("invalidDepartmentId"));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("designationId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("designationId", properties.getProperty("invalidDesignationId"));
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("userId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("userId", properties.getProperty("invalidUserId"));
        } else if (arg0.equalsIgnoreCase("Employeecode") && arg1.equalsIgnoreCase("EmployeeId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("code", EmployeeCodes.get(0))
                    .queryParam("id", properties.getProperty("invalidEmpId"));
        } else if (arg0.equalsIgnoreCase("Employeecode") && arg1.equalsIgnoreCase("firstName")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("code", EmployeeCodes.get(0))
                    .queryParam("firstName", properties.getProperty("invalidFirstName"));

        } else if (arg0.equalsIgnoreCase("Employeecode") && arg1.equalsIgnoreCase("lastName")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("code", EmployeeCodes.get(0))
                    .queryParam("lastName", properties.getProperty("invalidLastName"));

        } else if (arg0.equalsIgnoreCase("Employeecode") && arg1.equalsIgnoreCase("email")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("code", EmployeeCodes.get(0))
                    .queryParam("email", properties.getProperty("invalidEmailId"));

        } else if (arg0.equalsIgnoreCase("Employeecode") && arg1.equalsIgnoreCase("phone")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("code", EmployeeCodes.get(0))
                    .queryParam("phone", properties.getProperty("invalidPhone"));

        } else if (arg0.equalsIgnoreCase("Employeecode") && arg1.equalsIgnoreCase("departmentId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("code", EmployeeCodes.get(0))
                    .queryParam("departmentId", properties.getProperty("invalidDepartmentId"));

        } else if (arg0.equalsIgnoreCase("Employeecode") && arg1.equalsIgnoreCase("designationId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("code", EmployeeCodes.get(0))
                    .queryParam("designationId", properties.getProperty("invalidDesignationId"));

        } else if (arg0.equalsIgnoreCase("Employeecode") && arg1.equalsIgnoreCase("userId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("code", EmployeeCodes.get(0))
                    .queryParam("userId", properties.getProperty("invalidUserId"));
        } else if (arg0.equalsIgnoreCase("designationId") && arg1.equalsIgnoreCase("EmployeeId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("designationId", EmployeeDesignationId.get(0))
                    .queryParam("id", properties.getProperty("invalidEmpId"));
        } else if (arg0.equalsIgnoreCase("designationId") && arg1.equalsIgnoreCase("firstName")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("designationId", EmployeeDesignationId.get(0))
                    .queryParam("firstName", properties.getProperty("invalidFirstName"));

        } else if (arg0.equalsIgnoreCase("designationId") && arg1.equalsIgnoreCase("lastName")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("designationId", EmployeeDesignationId.get(0))
                    .queryParam("lastName", properties.getProperty("invalidLastName"));

        } else if (arg0.equalsIgnoreCase("designationId") && arg1.equalsIgnoreCase("email")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("designationId", EmployeeDesignationId.get(0))
                    .queryParam("email", properties.getProperty("invalidEmailId"));

        } else if (arg0.equalsIgnoreCase("designationId") && arg1.equalsIgnoreCase("phone")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("designationId", EmployeeDesignationId.get(0))
                    .queryParam("phone", properties.getProperty("invalidPhone"));

        } else if (arg0.equalsIgnoreCase("designationId") && arg1.equalsIgnoreCase("departmentId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("designationId", EmployeeDesignationId.get(0))
                    .queryParam("departmentId", properties.getProperty("invalidDepartmentId"));

        } else if (arg0.equalsIgnoreCase("designationId") && arg1.equalsIgnoreCase("EmployeeCode")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("designationId", EmployeeDesignationId.get(0))
                    .queryParam("code", properties.getProperty("invalidPersonCode"));

        } else if (arg0.equalsIgnoreCase("designationId") && arg1.equalsIgnoreCase("userId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("designationId", EmployeeDesignationId.get(0))
                    .queryParam("userId", properties.getProperty("invalidUserId"));
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("EmployeeId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("email", EmployeeEmails.get(0))
                    .queryParam("id", properties.getProperty("invalidEmpId"));
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("firstName")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("email", EmployeeEmails.get(0))
                    .queryParam("firstName", properties.getProperty("invalidFirstName"));

        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("lastName")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("email", EmployeeEmails.get(0))
                    .queryParam("lastName", properties.getProperty("invalidLastName"));

        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("designationId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("email", EmployeeEmails.get(0))
                    .queryParam("designationId", properties.getProperty("invalidDesignationId"));

        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("phone")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("email", EmployeeEmails.get(0))
                    .queryParam("phone", properties.getProperty("invalidPhone"));

        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("departmentId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("email", EmployeeEmails.get(0))
                    .queryParam("departmentId", properties.getProperty("invalidDepartmentId"));

        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("EmployeeCode")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("email", EmployeeEmails.get(0))
                    .queryParam("code", properties.getProperty("invalidPersonCode"));

        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("userId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("email", EmployeeEmails.get(0))
                    .queryParam("userId", properties.getProperty("invalidUserId"));
        } else if (arg0.equalsIgnoreCase("departmentId") && arg1.equalsIgnoreCase("EmployeeId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("departmentId", EmployeeDepartmentId.get(0))
                    .queryParam("id", properties.getProperty("invalidEmpId"));
        } else if (arg0.equalsIgnoreCase("departmentId") && arg1.equalsIgnoreCase("firstName")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("departmentId", EmployeeDepartmentId.get(0))
                    .queryParam("firstName", properties.getProperty("invalidFirstName"));

        } else if (arg0.equalsIgnoreCase("departmentId") && arg1.equalsIgnoreCase("lastName")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("departmentId", EmployeeDepartmentId.get(0))
                    .queryParam("lastName", properties.getProperty("invalidLastName"));

        } else if (arg0.equalsIgnoreCase("departmentId") && arg1.equalsIgnoreCase("designationId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("departmentId", EmployeeDepartmentId.get(0))
                    .queryParam("designationId", properties.getProperty("invalidDesignationId"));

        } else if (arg0.equalsIgnoreCase("departmentId") && arg1.equalsIgnoreCase("phone")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("departmentId", EmployeeDepartmentId.get(0))
                    .queryParam("phone", properties.getProperty("invalidPhone"));

        } else if (arg0.equalsIgnoreCase("departmentId") && arg1.equalsIgnoreCase("email")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("departmentId", EmployeeDepartmentId.get(0))
                    .queryParam("email", properties.getProperty("invalidEmailId"));

        } else if (arg0.equalsIgnoreCase("departmentId") && arg1.equalsIgnoreCase("EmployeeCode")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("departmentId", EmployeeDepartmentId.get(0))
                    .queryParam("code", properties.getProperty("invalidPersonCode"));

        } else if (arg0.equalsIgnoreCase("departmentId") && arg1.equalsIgnoreCase("userId")) {
            reqSpec = given().log().all().spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("operator", "AND")
                    .queryParam("departmentId", EmployeeDepartmentId.get(0))
                    .queryParam("userId", properties.getProperty("invalidUserId"));
        }

    }

    @Given("payload to filter a Employee with case-insensitive {string} and case-sensitive {string} when case-sensitive is {string} and operator is {string}")
    public void payloadToFilterAEmployeeWithCaseInsensitiveAndCaseSensitiveWhenCaseSensitiveIsAndOperatorIs(String arg0, String arg1, String caseSensitive, String operator) {
        if (arg0.equalsIgnoreCase("firstname") && arg1.equalsIgnoreCase("lastname") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", EmployeeFirstName.get(0).toLowerCase())
                    .queryParam("lastName", EmployeeLastName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("firstname") && arg1.equalsIgnoreCase("employeeCode") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", EmployeeFirstName.get(0).toLowerCase())
                    .queryParam("code", EmployeeCodes.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("firstname") && arg1.equalsIgnoreCase("email") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", EmployeeFirstName.get(0).toLowerCase())
                    .queryParam("email", EmployeeEmails.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("email") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastname", EmployeeLastName.get(0).toLowerCase())
                    .queryParam("email", EmployeeEmails.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("EmployeeCode") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastname", EmployeeLastName.get(0).toLowerCase())
                    .queryParam("code", EmployeeCodes.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("lastname") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastname", EmployeeLastName.get(0).toLowerCase())
                    .queryParam("firstName", EmployeeFirstName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("EmployeeCode") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("EmployeeCode", EmployeeCodes.get(0).toLowerCase())
                    .queryParam("firstName", EmployeeFirstName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("EmployeeCode") && arg1.equalsIgnoreCase("lastName") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("EmployeeCode", EmployeeCodes.get(0).toUpperCase())
                    .queryParam("lastName", EmployeeLastName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("EmployeeCode") && arg1.equalsIgnoreCase("email") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("EmployeeCode", EmployeeCodes.get(0).toLowerCase())
                    .queryParam("email", EmployeeEmails.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", EmployeeEmails.get(0).toLowerCase())
                    .queryParam("firstName", EmployeeFirstName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("lastName") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", EmployeeEmails.get(0).toLowerCase())
                    .queryParam("lastName", EmployeeLastName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("EmployeeCode") && caseSensitive.equals("false") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", EmployeeEmails.get(0).toLowerCase())
                    .queryParam("code", EmployeeCodes.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("lastName") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", EmployeeFirstName.get(0).toLowerCase())
                    .queryParam("lastName", EmployeeLastName.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("EmployeeCode") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", EmployeeFirstName.get(0).toLowerCase())
                    .queryParam("code", EmployeeCodes.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("Email") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", EmployeeFirstName.get(0).toLowerCase())
                    .queryParam("email", EmployeeEmails.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", EmployeeLastName.get(0).toLowerCase())
                    .queryParam("firstName", EmployeeFirstName.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("EmployeeCode") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", EmployeeLastName.get(0).toLowerCase())
                    .queryParam("code", EmployeeCodes.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("Email") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", EmployeeLastName.get(0).toLowerCase())
                    .queryParam("email", EmployeeEmails.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("EmployeeCode") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("code", EmployeeCodes.get(0).toLowerCase())
                    .queryParam("firstName", EmployeeFirstName.get(0).toUpperCase()).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("EmployeeCode") && arg1.equalsIgnoreCase("lastName") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("code", EmployeeCodes.get(0).toLowerCase())
                    .queryParam("lastName", EmployeeLastName.get(0).toUpperCase()).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("EmployeeCode") && arg1.equalsIgnoreCase("Email") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("code", EmployeeCodes.get(0).toLowerCase())
                    .queryParam("email", EmployeeEmails.get(0).toUpperCase()).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("Email") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", EmployeeEmails.get(0).toLowerCase())
                    .queryParam("firstName", EmployeeFirstName.get(0).toUpperCase()).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("Email") && arg1.equalsIgnoreCase("lastName") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", EmployeeEmails.get(0).toLowerCase())
                    .queryParam("lastName", EmployeeLastName.get(0).toUpperCase()).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("Email") && arg1.equalsIgnoreCase("Employeecode") && caseSensitive.equals("true") && operator.equals("AND")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", EmployeeEmails.get(0).toLowerCase())
                    .queryParam("code", EmployeeCodes.get(0).toUpperCase()).queryParam("caseSensitive", true)
                    .queryParam("operator", "AND");
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("LastName") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", EmployeeFirstName.get(0).toLowerCase())
                    .queryParam("lastName", EmployeeLastName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("EmployeeCode") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", EmployeeFirstName.get(0).toLowerCase())
                    .queryParam("code", EmployeeCodes.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("Email") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", EmployeeFirstName.get(0).toLowerCase())
                    .queryParam("email", EmployeeEmails.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", EmployeeLastName.get(0).toLowerCase())
                    .queryParam("firstName", EmployeeFirstName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("email") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", EmployeeLastName.get(0).toLowerCase())
                    .queryParam("email", EmployeeEmails.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("EmployeeCode") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", EmployeeLastName.get(0).toLowerCase())
                    .queryParam("code", EmployeeCodes.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("EmployeeCode") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("code", EmployeeLastName.get(0).toLowerCase())
                    .queryParam("firstName", EmployeeFirstName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("EmployeeCode") && arg1.equalsIgnoreCase("email") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("code", EmployeeLastName.get(0).toLowerCase())
                    .queryParam("email", EmployeeEmails.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("EmployeeCode") && arg1.equalsIgnoreCase("lastName") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("code", EmployeeLastName.get(0).toLowerCase())
                    .queryParam("lastName", EmployeeLastName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", EmployeeEmails.get(0).toLowerCase())
                    .queryParam("firstName", EmployeeFirstName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("EmployeeCode") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", EmployeeEmails.get(0).toLowerCase())
                    .queryParam("code", EmployeeCodes.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("lastName") && caseSensitive.equals("false") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", EmployeeEmails.get(0).toLowerCase())
                    .queryParam("lastName", EmployeeLastName.get(0)).queryParam("caseSensitive", false)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", EmployeeLastName.get(0).toLowerCase())
                    .queryParam("firstName", EmployeeFirstName.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("EmployeeCode") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("code", EmployeeCodes.get(0).toLowerCase())
                    .queryParam("firstName", EmployeeFirstName.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("Email") && arg1.equalsIgnoreCase("firstName") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", EmployeeEmails.get(0).toLowerCase())
                    .queryParam("firstName", EmployeeFirstName.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("lastName") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", EmployeeFirstName.get(0).toLowerCase())
                    .queryParam("lastName", EmployeeLastName.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("EmployeeCode") && arg1.equalsIgnoreCase("lastName") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("code", EmployeeCodes.get(0).toLowerCase())
                    .queryParam("lastName", EmployeeLastName.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("Email") && arg1.equalsIgnoreCase("lastName") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", EmployeeEmails.get(0).toLowerCase())
                    .queryParam("lastName", EmployeeLastName.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("EmployeeCode") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", EmployeeFirstName.get(0).toLowerCase())
                    .queryParam("code", EmployeeCodes.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("EmployeeCode") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", EmployeeLastName.get(0).toLowerCase())
                    .queryParam("code", EmployeeCodes.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("Email") && arg1.equalsIgnoreCase("EmployeeCode") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", EmployeeEmails.get(0).toLowerCase())
                    .queryParam("code", EmployeeCodes.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("email") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", EmployeeFirstName.get(0).toLowerCase())
                    .queryParam("email", EmployeeEmails.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("email") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", EmployeeLastName.get(0).toLowerCase())
                    .queryParam("email", EmployeeEmails.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("EmployeeCode") && arg1.equalsIgnoreCase("email") && caseSensitive.equals("true") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("code", EmployeeCodes.get(0).toLowerCase())
                    .queryParam("email", EmployeeEmails.get(0)).queryParam("caseSensitive", true)
                    .queryParam("operator", "OR");
        }

    }

    @Given("payload to filter a Employee by {string} OR {string} with Operator {string}")
    public void payloadToFilterAEmployeeByORWithOperator(String arg0, String arg1, String operator) {
        if (arg0.equalsIgnoreCase("EmployeeId") && arg1.equalsIgnoreCase("firstName") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("firstName", EmployeeFirstName.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("EmployeeId") && arg1.equalsIgnoreCase("lastName") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("lastName", EmployeeLastName.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("EmployeeId") && arg1.equalsIgnoreCase("phone") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("phone", Employeephones.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("EmployeeId") && arg1.equalsIgnoreCase("email") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("email", EmployeeEmails.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("EmployeeId") && arg1.equalsIgnoreCase("EmployeeCode") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("code", EmployeeCodes.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("EmployeeId") && arg1.equalsIgnoreCase("designationId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("designationId", EmployeeDesignationId.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("EmployeeId") && arg1.equalsIgnoreCase("departmentId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("departmentId", EmployeeDepartmentId.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("EmployeeId") && arg1.equalsIgnoreCase("userId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("userId", EmployeeUserIds.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("EmployeeId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", EmployeeFirstName.get(0))
                    .queryParam("id", EmployeeIDs.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("lastName") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", EmployeeFirstName.get(0))
                    .queryParam("lastName", EmployeeLastName.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("phone") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", EmployeeFirstName.get(0))
                    .queryParam("phone", Employeephones.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("email") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", EmployeeFirstName.get(0))
                    .queryParam("email", EmployeeEmails.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("EmployeeCode") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", EmployeeFirstName.get(0))
                    .queryParam("code", EmployeeCodes.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("designationId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", EmployeeFirstName.get(0))
                    .queryParam("designationId", EmployeeDesignationId.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("departmentId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", EmployeeFirstName.get(0))
                    .queryParam("departmentId", EmployeeDepartmentId.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("firstName") && arg1.equalsIgnoreCase("userId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("firstName", EmployeeFirstName.get(0))
                    .queryParam("userId", EmployeeUserIds.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("EmployeeId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("id", EmployeeIDs.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("firstName") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("firstName", EmployeeFirstName.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("phone") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("phone", Employeephones.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("email") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("email", EmployeeEmails.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("EmployeeCode") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("code", EmployeeCodes.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("designationId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("designationId", EmployeeDesignationId.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("departmentId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("departmentId", EmployeeDepartmentId.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("userId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("userId", EmployeeUserIds.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("lastName") && arg1.equalsIgnoreCase("siteId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("lastName", EmployeeLastName.get(0))
                    .queryParam("siteId", EmployeeSiteId.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("EmployeeId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("id", EmployeeIDs.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("firstName") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("firstName", EmployeeFirstName.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("lastName") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("lastName", EmployeeLastName.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("email") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("email", EmployeeEmails.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("EmployeeCode") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("code", EmployeeCodes.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("designationId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("designationId", EmployeeDesignationId.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("departmentId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("departmentId", EmployeeDepartmentId.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("userId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("userId", EmployeeUserIds.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("phone") && arg1.equalsIgnoreCase("siteId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("phone", Employeephones.get(0))
                    .queryParam("siteId", EmployeeSiteId.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("EmployeeId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", EmployeeEmails.get(0))
                    .queryParam("id", EmployeeIDs.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("firstName") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", EmployeeEmails.get(0))
                    .queryParam("firstName", EmployeeFirstName.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("lastName") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", EmployeeEmails.get(0))
                    .queryParam("lastName", EmployeeLastName.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("phone") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", EmployeeEmails.get(0))
                    .queryParam("phone", Employeephones.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("EmployeeCode") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", EmployeeEmails.get(0))
                    .queryParam("code", EmployeeCodes.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("designationId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", EmployeeEmails.get(0))
                    .queryParam("designationId", EmployeeDesignationId.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("departmentId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", EmployeeEmails.get(0))
                    .queryParam("departmentId", EmployeeDepartmentId.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("userId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", EmployeeEmails.get(0))
                    .queryParam("userId", EmployeeUserIds.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("email") && arg1.equalsIgnoreCase("siteId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("email", EmployeeEmails.get(0))
                    .queryParam("siteId", EmployeeSiteId.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("designationId") && arg1.equalsIgnoreCase("EmployeeId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("designationId", EmployeeDesignationId.get(0))
                    .queryParam("id", EmployeeIDs.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("designationId") && arg1.equalsIgnoreCase("firstName") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("designationId", EmployeeDesignationId.get(0))
                    .queryParam("firstName", EmployeeFirstName.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("designationId") && arg1.equalsIgnoreCase("lastName") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("designationId", EmployeeDesignationId.get(0))
                    .queryParam("lastName", EmployeeLastName.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("designationId") && arg1.equalsIgnoreCase("phone") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("designationId", EmployeeDesignationId.get(0))
                    .queryParam("phone", Employeephones.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("designationId") && arg1.equalsIgnoreCase("EmployeeCode") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("designationId", EmployeeDesignationId.get(0))
                    .queryParam("code", EmployeeCodes.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("designationId") && arg1.equalsIgnoreCase("email") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("designationId", EmployeeDesignationId.get(0))
                    .queryParam("email", EmployeeEmails.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("designationId") && arg1.equalsIgnoreCase("departmentId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("designationId", EmployeeDesignationId.get(0))
                    .queryParam("departmentId", EmployeeDepartmentId.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("designationId") && arg1.equalsIgnoreCase("userId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("designationId", EmployeeDesignationId.get(0))
                    .queryParam("userId", EmployeeUserIds.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("departmentId") && arg1.equalsIgnoreCase("EmployeeId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("departmentId", EmployeeDepartmentId.get(0))
                    .queryParam("id", EmployeeIDs.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("departmentId") && arg1.equalsIgnoreCase("firstName") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("departmentId", EmployeeDepartmentId.get(0))
                    .queryParam("firstName", EmployeeFirstName.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("departmentId") && arg1.equalsIgnoreCase("lastName") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("departmentId", EmployeeDepartmentId.get(0))
                    .queryParam("lastName", EmployeeLastName.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("departmentId") && arg1.equalsIgnoreCase("phone") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("departmentId", EmployeeDepartmentId.get(0))
                    .queryParam("phone", Employeephones.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("departmentId") && arg1.equalsIgnoreCase("EmployeeCode") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("departmentId", EmployeeDepartmentId.get(0))
                    .queryParam("code", EmployeeCodes.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("departmentId") && arg1.equalsIgnoreCase("email") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("departmentId", EmployeeDepartmentId.get(0))
                    .queryParam("email", EmployeeEmails.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("departmentId") && arg1.equalsIgnoreCase("designationId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("departmentId", EmployeeDepartmentId.get(0))
                    .queryParam("designationId", EmployeeDesignationId.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("departmentId") && arg1.equalsIgnoreCase("userId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("departmentId", EmployeeDepartmentId.get(0))
                    .queryParam("userId", EmployeeUserIds.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("departmentId") && arg1.equalsIgnoreCase("siteId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("departmentId", EmployeeDepartmentId.get(0))
                    .queryParam("siteId", EmployeeSiteId.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("EmployeeId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("userId", EmployeeUserIds.get(0))
                    .queryParam("id", EmployeeIDs.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("firstName") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("userId", EmployeeUserIds.get(0))
                    .queryParam("firstName", EmployeeFirstName.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("lastName") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("userId", EmployeeUserIds.get(0))
                    .queryParam("lastName", EmployeeLastName.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("phone") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("userId", EmployeeUserIds.get(0))
                    .queryParam("phone", Employeephones.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("EmployeeCode") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("userId", EmployeeUserIds.get(0))
                    .queryParam("code", EmployeeCodes.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("email") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("userId", EmployeeUserIds.get(0))
                    .queryParam("email", EmployeeEmails.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("designationId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("userId", EmployeeUserIds.get(0))
                    .queryParam("designationId", EmployeeDesignationId.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        } else if (arg0.equalsIgnoreCase("userId") && arg1.equalsIgnoreCase("departmentId") && operator.equals("OR")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("userId", EmployeeUserIds.get(0))
                    .queryParam("departmentId", EmployeeDepartmentId.get(0).toLowerCase())
                    .queryParam("operator", "OR");
        }


    }

    @Given("payload to filter a Employee by passing toggleKeytoURL is {string}")
    public void payloadToFilterAEmployeeByPassingToggleKeytoURLIs(String arg0) {
        if (arg0.equalsIgnoreCase("true")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("id", EmployeeIDs.get(1))
                    .queryParam("toggleKeyToURL", "true");
        } else if (arg0.equalsIgnoreCase("false")) {
            reqSpec = given().log().all().
                    spec(requestSpecification1("Bearer " + Company_token))
                    .queryParam("id", EmployeeIDs.get(0))
                    .queryParam("toggleKeyToURL", "false");
        }
    }

    @Given("payload to delete created site based on id")
    public void payloadToDeleteCreatedSiteBasedOnId() {
        validation_responseObj.then().log().all();
        validation_responseObj=given().log().all().spec(requestSpecification3("Bearer " + Company_token)).queryParam("casCade",0)
                .get("/api/v3/site/list");
        List<String> id = validation_responseObj.jsonPath().getList("data.sites.id");
        System.out.println("sites : "+id);
        System.out.println("total no. of sites available : "+id.size());

//        for (int i = 0; i < id.size(); i++) {
//
//            reqSpec = given().log().all().
//                    spec(requestSpecification3("Bearer " + Company_token));
//            validation_responseObj=reqSpec.delete("api/v3/address/" + id.get(i));
//            validation_responseObj = reqSpec.delete("api/v3/site/" + id.get(i));
//            validation_responseObj.then().log().all();
//
//            }
        }


    @Given("payload to create a site and user by providing create user as true")
    public void payloadToCreateASiteAndUserByProvidingCreateUserAsTrue() {
        reqSpec = given().log().all().
                spec(requestSpecification3("Bearer " + Company_token))
                .body(Payloads.addSite("Per6364838948374" + fname, "847374978944Per" + lname));
    }

    @When("user calls create site API with POST http request")
    public void userCallsCreateSiteAPIWithPOSTHttpRequest() {
        validation_responseObj = reqSpec.post("api/v3/site");
        validation_responseObj.then().log().all();

    }

    @Then("validate response code and response message for successfull site creation userid")
    public void validateResponseCodeAndResponseMessageForSuccessfullSiteCreationUserid() {
        validation_responseObj.then().log().all().spec(responseSpecification(200));
    }
}

