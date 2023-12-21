$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/Organization.feature");
formatter.feature({
  "name": "Organization Service V3 API Testing",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Organization"
    },
    {
      "name": "@Regression"
    }
  ]
});
formatter.scenario({
  "name": "Generate client token",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Organization"
    },
    {
      "name": "@Regression"
    },
    {
      "name": "@PC"
    },
    {
      "name": "@Smoke"
    },
    {
      "name": "@Regression"
    },
    {
      "name": "@Department"
    },
    {
      "name": "@Designation"
    },
    {
      "name": "@Visitor"
    },
    {
      "name": "@Employee12"
    },
    {
      "name": "@12"
    },
    {
      "name": "@123"
    },
    {
      "name": "@12345"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "payload to generate a client token",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.Organization.payload_to_generate_a_client_token()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user calls generate client token API with POST http request",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.Organization.user_calls_generate_client_token_api_with_post_http_request()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate response code and response message for successfull generation of client token",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.Organization.validate_response_code_and_response_message_for_successfull_generation_of_client_token()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Generate company token",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Organization"
    },
    {
      "name": "@Regression"
    },
    {
      "name": "@SC"
    },
    {
      "name": "@Smoke"
    },
    {
      "name": "@Regression"
    },
    {
      "name": "@Department"
    },
    {
      "name": "@Designation"
    },
    {
      "name": "@Visitor"
    },
    {
      "name": "@Employee12"
    },
    {
      "name": "@12"
    },
    {
      "name": "@123"
    },
    {
      "name": "@12345"
    },
    {
      "name": "@s"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "payload to generate a company token",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.Organization.payload_to_generate_a_company_token()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user calls generate company token API with POST http request",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.Organization.user_calls_generate_company_token_with_post_http_request()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate response code and response message for successfull generation of company token",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.Organization.validate_response_code_and_response_message_for_successfull_generation_of_company_token()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify Person with person type of Employee create is successfull when all required parameter data\u0027s are provided",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Organization"
    },
    {
      "name": "@Regression"
    },
    {
      "name": "@TC_15500"
    },
    {
      "name": "@Person"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "payload to create a Person with person type of employee by providing all required parameter datas",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.Organization.payload_to_create_a_person_with_person_type_of_employee_by_providing_all_required_parameter_datas()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user calls create Person API with POST http request",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.Organization.user_calls_create_person_api_with_post_http_request()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate response code and response message for successfull Person creation with person type of employee",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.Organization.validate_response_code_and_response_message_for_successfull_person_creation_with_person_type_of_Employee()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "verify profile photo key is refecting in the response when togglekey is passed as false",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Organization"
    },
    {
      "name": "@Regression"
    },
    {
      "name": "@TC_600"
    },
    {
      "name": "@personFilter"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "payload to filter a Person by passing toggleKeytoURL is \"false\"",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.Organization.payloadToFilterAPersonByPassingToggleKeytoURLIs(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user calls filter person API with POST http request",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.Organization.user_Calls_Filter_Person_API_With_POST_Http_Request()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate response code and profile photo key",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.Organization.validateResponseCodeAndProfilePhotoKey()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: 1 expectation failed.\nJSON path data.profilePhotoKey doesn\u0027t match.\nExpected: not null\n  Actual: null\n\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:490)\r\n\tat org.codehaus.groovy.reflection.CachedConstructor.invoke(CachedConstructor.java:72)\r\n\tat org.codehaus.groovy.reflection.CachedConstructor.doConstructorInvoke(CachedConstructor.java:59)\r\n\tat org.codehaus.groovy.runtime.callsite.ConstructorSite$ConstructorSiteNoUnwrap.callConstructor(ConstructorSite.java:84)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallConstructor(CallSiteArray.java:59)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:263)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:277)\r\n\tat io.restassured.internal.ResponseSpecificationImpl$HamcrestAssertionClosure.validate(ResponseSpecificationImpl.groovy:493)\r\n\tat io.restassured.internal.ResponseSpecificationImpl$HamcrestAssertionClosure$validate$1.call(Unknown Source)\r\n\tat io.restassured.internal.ResponseSpecificationImpl.validateResponseIfRequired(ResponseSpecificationImpl.groovy:674)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:566)\r\n\tat org.codehaus.groovy.runtime.callsite.PlainObjectMetaMethodSite.doInvoke(PlainObjectMetaMethodSite.java:43)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoMetaMethodSite$PogoCachedMethodSiteNoUnwrapNoCoerce.invoke(PogoMetaMethodSite.java:193)\r\n\tat org.codehaus.groovy.runtime.callsite.PogoMetaMethodSite.callCurrent(PogoMetaMethodSite.java:61)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:185)\r\n\tat io.restassured.internal.ResponseSpecificationImpl.body(ResponseSpecificationImpl.groovy:261)\r\n\tat io.restassured.specification.ResponseSpecification$body$1.callCurrent(Unknown Source)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallCurrent(CallSiteArray.java:51)\r\n\tat io.restassured.specification.ResponseSpecification$body$1.callCurrent(Unknown Source)\r\n\tat io.restassured.internal.ResponseSpecificationImpl.body(ResponseSpecificationImpl.groovy:108)\r\n\tat io.restassured.internal.ValidatableResponseOptionsImpl.body(ValidatableResponseOptionsImpl.java:244)\r\n\tat io.restassured.internal.ValidatableResponseImpl.super$2$body(ValidatableResponseImpl.groovy)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:566)\r\n\tat org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:107)\r\n\tat groovy.lang.MetaMethod.doMethodInvoke(MetaMethod.java:323)\r\n\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1268)\r\n\tat org.codehaus.groovy.runtime.ScriptBytecodeAdapter.invokeMethodOnSuperN(ScriptBytecodeAdapter.java:144)\r\n\tat io.restassured.internal.ValidatableResponseImpl.body(ValidatableResponseImpl.groovy:298)\r\n\tat io.restassured.internal.ValidatableResponseImpl.body(ValidatableResponseImpl.groovy)\r\n\tat stepDefinitions.Organization.validateResponseCodeAndProfilePhotoKey(Organization.java:9196)\r\n\tat ✽.validate response code and profile photo key(file:///D:/Automation/Organization_v3.0/src/test/java/features/Organization.feature:7729)\r\n",
  "status": "failed"
});
formatter.scenario({
  "name": "Verify Employee delete is successfull based on employee code",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Organization"
    },
    {
      "name": "@Regression"
    },
    {
      "name": "@TC_0000"
    },
    {
      "name": "@DeleteEmployee"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "payload to delete created employee based on id",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.Organization.payloadToDeleteCreatedEmployeeBasedOnId()"
});
formatter.result({
  "status": "passed"
});
});