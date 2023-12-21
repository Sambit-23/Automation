package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import files.CompanyPayload;
import files.UserPayload;
import files.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Authorization extends Utils {
	static RequestSpecification reqSpec;
	static Response validation_responseObj;
	static Response responseObj;
	 WebDriver driver;
	final static String company_code="COM86548";
	final static String clientID="7143f07ce29146509eabe7c55dfa55dd";
	final static String clientSecret="tjYlUgCPA2x07BTppXYVbJHiytU4aqWP1fIwlqqrscl3kAaPkBCdrJei5PrfV5BOKNxFUITiOvbqrMh7yHVuAc9f7sBHkcRUpVHgyodtNT3uNK8rhP5Zoi6sG8vab5XM";
	static ValidatableResponse validateresponseOBJ;
	static String response;
	static String oAuthToken;
	static String adminToken;
	static String companyID;
	static String userID;
	final String fname = RandomStringUtils.randomAlphabetic(6);
	final String lname = RandomStringUtils.randomAlphabetic(6);
	final String contact = RandomStringUtils.randomNumeric(10);
	final String email = RandomStringUtils.randomAlphabetic(6);
	static String AdminRoleID="402894d77640b61b017640b629140000";
	static String VendorRoleID="402894d77640b61b017640b6291c0001";
	static String EmployeeRoleID="402894d77640b61b017640b6291c0002";

//	@Given("^user has client id and client secret$")
//    public void user_has_client_id_and_client_secret() throws Throwable {
//		List<String> getData = Utils.retreiveClientDetails(driver);
//		clientID=getData.get(0).toString();
//		clientSecret = getData.get(1).toString();
//		
//		System.out.println("Client ID is : "+clientID);
//		System.out.println("Client Secret is : "+clientSecret);
//
//    }

	@Given("^payload to \"([^\"]*)\" in Authorization service$")
    public void payload_to_something_in_authorization_service(String strArg1) throws Throwable {
        switch(strArg1)
        {
        	case "generate oAuth Token":
        		reqSpec = given().log().all().spec(requestSpecification("Authorization_Token"))
        				.header("Content-Type","application/x-www-form-urlencoded")
                        .auth().preemptive()
                        .basic(clientID, clientSecret)
                        //.basic("7143f07ce29146509eabe7c55dfa55dd", "tjYlUgCPA2x07BTppXYVbJHiytU4aqWP1fIwlqqrscl3kAaPkBCdrJei5PrfV5BOKNxFUITiOvbqrMh7yHVuAc9f7sBHkcRUpVHgyodtNT3uNK8rhP5Zoi6sG8vab5XM")
                        .formParam("grant_type", "password")
                        .formParam("username", "nanigopal@zkteco.in")
                        .formParam("password", "Gop@!1498")
                        .formParam("Scope", "READ");     	
        		break;
        		
        	case "create a company":
        		System.out.println(company_code+" will be used as company code");
        		reqSpec = given().log().all().spec(requestSpecification("Authorization")).log().all().header("Content-Type","application/json").header("Authorization", "Bearer " + oAuthToken)
        				.body(CompanyPayload.addCompany(company_code, "ZKTeCo", "GKTco@zk.in", "0802576647",
        						"ACT2001", "BLR,KAR", "BLR", "Karnataka", "India", "560048"));  	
        		break;
        		
        	case "verify a company":
        		reqSpec = given().log().all().spec(requestSpecification("Authorization"))
        				.header("Content-Type","application/json")
        				.header("Authorization", "Bearer " + oAuthToken )
        				.body("{\n"
        						+ "  \"companyId\": \""+companyID+"\"\n"
        						+ "}");
        		break;
        		
        	case "list companies":
        		reqSpec = given().log().all().spec(requestSpecification("Authorization"))
        				.header("Content-Type","application/json").header("Authorization", "Bearer " + adminToken)
        				.queryParam("pageNumber", "1");
        		break;
        		
        	case "create a user":
        		
        		reqSpec = given().log().all().spec(requestSpecification("Authorization"))
        				.header("Content-Type","application/json").header("Authorization", "Bearer " + adminToken)
        				.body(UserPayload.addUser(fname, lname, contact, email+"@zk.in", "admin123", companyID, EmployeeRoleID));
        		break;
        		
        	case "retrieve company details":
        		reqSpec = given().spec(requestSpecification("Authorization"))
        				.header("Content-Type","application/json").header("Authorization", "Bearer " + adminToken);
        		break;
        		
        	case "retrieve user details":
        		reqSpec = given().log().all().spec(requestSpecification("Authorization"))
        				.header("Content-Type","application/json")
        				.header("Authorization", "Bearer "+adminToken)
        				;
        		break;
        		
        	case "join a company":
        		reqSpec = given().log().all().spec(requestSpecification("Authorization"))
        		.header("Content-Type","application/json").header("Authorization", "Bearer " + adminToken)
        		.body(CompanyPayload.joinCompany(companyID, userID));
        		break;
        		
        	case "users in a company":
        		reqSpec = given().log().all().spec(requestSpecification("Authorization"))
        		.header("Content-Type","application/json").header("Authorization", "Bearer " + adminToken)
        		.queryParam("companyId", "");
        		break;
        		
        	case "update company details":
        		reqSpec = given().log().all().spec(requestSpecification("Authorization"))
        				.header("Content-Type","application/json")
        				.header("Authorization", "Bearer " + adminToken)
        				.body(CompanyPayload.updateCompany(company_code, companyID, "APITesCompany", "new_email@zk.in", "0802826648", "AC2120", "BLR,KAR", "BLR", "Karnataka", "India", "560048"));      		
        		break;
        		
        	case "delete a company":
        		reqSpec = given().log().all().spec(requestSpecification("Authorization"))
        				.header("Content-Type","application/json")
        				.header("Authorization", "Bearer " + adminToken);
        		break;
        		
        	case "assign user role":
        		reqSpec = given().log().all().spec(requestSpecification("Authorization"))
        				.header("Authorization", "Bearer " + adminToken)
        				.header("Content-Type","application/json")
        				.body("[\n" + 
        						"  {\n" + 
        						"    \"userId\": \""+userID+"\",\n" + 
        						"    \"roleId\": \""+EmployeeRoleID+"\"\n" + 
        						"  }\n" + 
        						"]");
        		break;
        		
        	case "get logged user":
        		reqSpec = given().log().all().spec(requestSpecification("Authorization"))
        				.header("Content-Type","application/json")
        				.header("Authorization", "Bearer " + adminToken);
        		break;
        		
        }
        	
    }


	@When("^user calls \"([^\"]*)\" in Authorization with \"([^\"]*)\" http request$")
    public void user_calls_something_in_authorization_with_something_http_request(String strArg1, String strArg2) throws Throwable {
    	switch (strArg1) {
		case "generate oAuth Token API":
			validation_responseObj = reqSpec.post("oauth/token");
			break;
    	
    	case "create company API":
    		validation_responseObj = reqSpec.post("company");
    		break;
    		
    	case "verify company API":
    		validation_responseObj = reqSpec.when().put("user/company");
    		break;
    		
    	case "get company API":
    		validation_responseObj = reqSpec.when().get("company");
    		break;
    		
    	case "create user API":
    		validation_responseObj = reqSpec.when().post("user");
    		break;
    		
    	case "retrieve company API":
    		validation_responseObj = reqSpec.when().get("company/"+companyID);
    		break;
    		
    	case "retrieve user API":
    		validation_responseObj = reqSpec.when().get("user/"+userID);
    		break;
    		
    	case "join company API":
    		validation_responseObj = reqSpec.when().post("/user/company");
    		break;
    		
    	case "users in a company API":
    		validation_responseObj = reqSpec.when().get("/user/company");
    		break;
    		
    	case "update company API":
    		validation_responseObj = reqSpec.when().put("company/+companyID");
    		break;
    		
    	case "delete company API":
    		validation_responseObj = reqSpec.when().delete("company/"+companyID);
    		break;
    		
    	case "assign user role API":
    		validation_responseObj = reqSpec.when().post("/user/role");
    		break;
    		
    	case "get logged user API":
    		validation_responseObj = reqSpec.when().get("user");
    		break;
	}
    }

    @Then("^validate response code for \"([^\"]*)\" in Authorization$")
    public void validate_response_code_for_something_in_authorization(String strArg1) throws Throwable {
    	switch (strArg1) {
		case "generating oAuth token":
			responseObj=validation_responseObj.then().log().all().assertThat().statusCode(200).extract().response();
        	oAuthToken=getJsonPath(responseObj, "access_token");
        	System.out.println("oAuth Token : "+oAuthToken);
			break;
			
		case "creating a company":
			responseObj=validation_responseObj.then().log().all().assertThat().statusCode(200).extract().response();
			companyID=getJsonPath(responseObj, "data.companyId");
        	System.out.println("Company id is : "+companyID);
			break;
			
		case "verifying a company":
			responseObj=validation_responseObj.then().log().all().assertThat().statusCode(200).extract().response();
			adminToken=getJsonPath(responseObj, "data.access_token");
        	System.out.println("Admin Token is : "+adminToken);
			break;
			
		case "getting list of company":
		case "retrieving user details":
		case "retrieving company details":
		case "user to join a company":
		case "users in a company":
		case "updating company details":
		case "assigning role to user":
		case "getting logged user":
			responseObj=validation_responseObj.then().log().all().assertThat().statusCode(200).extract().response();
			break;
			
		case "creating a user":
			responseObj=validation_responseObj.then().log().all().assertThat().statusCode(200).extract().response();
			userID=getJsonPath(responseObj, "data.userId");
        	System.out.println("User ID is : "+userID);
			break;
		case "deleting a company":
			responseObj=validation_responseObj.then().log().all().assertThat().statusCode(200).extract().response();
			data.clear();
			break;
    	}
    }

    @And("^validate message in response body for \"([^\"]*)\" in Authorization$")
    public void validate_message_in_response_body_for_something_in_authorization(String strArg1) throws Throwable {
    	switch (strArg1) {
		case "generating oAuth token":
			assertEquals(getJsonPath(responseObj, "token_type"), "bearer");
			break;
    	
    	default:
    		assertEquals(getJsonPath(responseObj, "msg"), "SUCCESS");
			break;
			
	}
    }

}
