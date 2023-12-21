package Utils;

import java.util.HashMap;

import Payloads.Payloads;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matcher;
import org.junit.Assert;

public class ReusableFunctions extends Payloads {

    Utils functions = new Utils();
    Response response;
    RequestSpecification baseReq;
    ResponseSpecification res;

    protected final static HashMap<String, String> data = new HashMap<String, String>();

    public RequestSpecification requestSpecification(String token) {
        baseReq = new RequestSpecBuilder().setBaseUri("https://organization-staging.minervaiotdev.com/").
                setContentType(ContentType.JSON).
                addHeader("Authorization", "Bearer " + token).addHeader("Accept-Language", "en").build();
        return baseReq;

    }

    public void visitor_response_validation(String firstName, String lastName, String nickname, String gender, String code, String personType, String email, String Phone, String Religion, boolean isRestricted, String visitorCompanyName, Response validation_responseObj, String DateOfBirth) {
        Assert.assertEquals(firstName, functions.getJsonPath(validation_responseObj, "data.firstName"));
        Assert.assertEquals(lastName, functions.getJsonPath(validation_responseObj, "data.lastName"));
        Assert.assertEquals(nickname, functions.getJsonPath(validation_responseObj, "data.nickName"));
        Assert.assertEquals(gender, functions.getJsonPath(validation_responseObj, "data.gender"));
        Assert.assertEquals(code, functions.getJsonPath(validation_responseObj, "data.code"));
        Assert.assertEquals(personType, functions.getJsonPath(validation_responseObj, "data.personType"));
        Assert.assertEquals(DateOfBirth, functions.getJsonPath(validation_responseObj, "data.dateOfBirth"));
        Assert.assertEquals(email, functions.getJsonPath(validation_responseObj, "data.email"));
        Assert.assertEquals(Phone, functions.getJsonPath(validation_responseObj, "data.phone"));
        Assert.assertEquals(Religion, functions.getJsonPath(validation_responseObj, "data.religion"));
        Assert.assertEquals(isRestricted, functions.getJsonPath(validation_responseObj, "data.isRestricted"));
        Assert.assertEquals(visitorCompanyName, functions.getJsonPath(validation_responseObj, "data.visitorCompanyName"));
    }

    public void person_validation(String email, String code, String contact, String firstName, Response validation_responseObj, String lastName, String nickname, String gender, String DateOfBirth, String personType, String Religion, boolean isRestricted, String visitorCompanyName, String joinDate, String jobType) {
        Assert.assertEquals(firstName, functions.getJsonPath(validation_responseObj, "data.firstName"));
        Assert.assertEquals(lastName, functions.getJsonPath(validation_responseObj, "data.lastName"));
        Assert.assertEquals(nickname, functions.getJsonPath(validation_responseObj, "data.nickName"));
        Assert.assertEquals(gender, functions.getJsonPath(validation_responseObj, "data.gender"));
        Assert.assertEquals(email, functions.getJsonPath(validation_responseObj, "data.email"));
        Assert.assertEquals(code, functions.getJsonPath(validation_responseObj, "data.code"));
        Assert.assertEquals(contact, functions.getJsonPath(validation_responseObj, "data.phone"));
        Assert.assertEquals(DateOfBirth, functions.getJsonPath(validation_responseObj, "data.dateOfBirth"));
        Assert.assertEquals(personType, functions.getJsonPath(validation_responseObj, "data.personType"));
        Assert.assertEquals(Religion, functions.getJsonPath(validation_responseObj, "data.religion"));
        Assert.assertEquals(joinDate, functions.getJsonPath(validation_responseObj, "data.joinDate"));
        Assert.assertEquals(isRestricted, functions.getJsonPath(validation_responseObj, "data.isRestricted"));
        Assert.assertEquals(visitorCompanyName, functions.getJsonPath(validation_responseObj, "data.visitorCompanyName"));
        Assert.assertEquals(jobType, functions.getJsonPath(validation_responseObj, "data.jobType"));
    }


}
	
	
	
	

