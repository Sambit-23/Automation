package Payloads;

import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class Payloads {
	
private String RandomData = RandomStringUtils.randomAlphabetic(5);

	public static String addEmployee(String firstName,String lastName,String email,String phone,String gender, String joinDate,String religion,String departmentIdOrCode, String designationIdOrCode,String code ,String profilePhoto, String status,String jobType,String siteId,String phoneCountrycode,String dateofBirth,String resignType,String resignReason,String resignDate,String employeeIdOnDevice,boolean createUser)
	{

		return "{\r\n"
				+ "  \"firstName\": \""+firstName+"\",\r\n"
				+ "  \"lastName\": \""+lastName+"\",\r\n"
				+ "  \"email\": \""+email+"\",\r\n"
				+ " \"phoneCountryCode\": \""+phoneCountrycode+"\",\r\n"
		        + "  \"dateOfBirth\": \""+dateofBirth+"\",\r\n"
				+ "  \"phone\": \""+phone+"\",\r\n"
				+ "  \"gender\": \""+gender+"\",\r\n"
				+ "  \"joinDate\": \""+joinDate+"\",\r\n"
				+ "  \"religion\": \""+religion+"\",\r\n"
				+ "  \"departmentIdOrCode\": \""+departmentIdOrCode+"\",\r\n"
				+ "  \"designationIdOrCode\": \""+designationIdOrCode+"\",\r\n"
				+ "  \"code\": \""+code+"\",\r\n"
				+ "  \"profilePhoto\": \""+profilePhoto+"\",\r\n"
				+ "  \"status\": \""+status+"\",\r\n"
				+ "  \"jobType\": \""+jobType+"\",\r\n"
				+ "  \"resignType\": \""+resignType+"\",\r\n"
				+ "  \"resignReason\": \""+resignReason+"\",\r\n"
				+ "  \"resignDate\": \""+resignDate+"\",\r\n"
				+ "  \"employeeIdOnDevice\": \""+employeeIdOnDevice+"\",\r\n"
				+ "  \"createUser\": "+createUser+",\r\n"
				+ "  \"siteId\": "+siteId+"\r\n"
				+ "}";
	}
	
	public static String addOrUpdateDepartmentOrDesignation(String code,String name,String description,String parentIdOrCode)
	{
		return "{\r\n"
				+ "  \"code\": \""+code+"\",\r\n"
				+ "  \"name\": \""+name+"\",\r\n"
				+ "  \"description\": \""+description+"\",\r\n"
				+ "  \"parentIdOrCode\": \""+parentIdOrCode+"\"\r\n"
				+ "}";
	}
	
	public static String addmultipleDepartmentOrDesignation(String code,String name,String description,String parentIdOrCode,String code1,String name1,String description1,String parentIdOrCode1)
	{	
		return "[\r\n"
				+ "  {\r\n"
				+ "    \"code\": \""+code+"\",\r\n"
				+ "    \"name\": \""+name+"\",\r\n"
				+ "    \"description\": \""+description+"\",\r\n"
				+ "    \"parentIdOrCode\": \""+parentIdOrCode+"\"\r\n"
				+ "  },\r\n"
				+ "   {\r\n"
				+ "    \"code\": \""+code1+"\",\r\n"
				+ "    \"name\": \""+name1+"\",\r\n"
				+ "    \"description\": \""+description1+"\",\r\n"
				+ "    \"parentIdOrCode\": \""+parentIdOrCode1+"\"\r\n"
				+ "  }\r\n"
				+ "]";
	}
	
	public static String UpdatemultipleDepartmentOrDesignation(String id,String code,String name,String description,String parentIdOrCode,String id1,String code1,String name1,String description1,String parentIdOrCode1)
	{	
		return "[\r\n"
				+ "  {\r\n"
				+ "    \"id\": \""+id+"\",\r\n"
				+ "    \"code\": \""+code+"\",\r\n"
				+ "    \"name\": \""+name+"\",\r\n"
				+ "    \"description\": \""+description+"\",\r\n"
				+ "    \"parentIdOrCode\": \""+parentIdOrCode+"\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"id\": \""+id1+"\",\r\n"
				+ "    \"code\": \""+code1+"\",\r\n"
				+ "    \"name\": \""+name1+"\",\r\n"
				+ "    \"description\": \""+description1+"\",\r\n"
				+ "    \"parentIdOrCode\": \""+parentIdOrCode1+"\"\r\n"
				+ "  }\r\n"
				+ "]";
	}

	public static String addOrUpdateMultipleEmployees(String id1,String firstName,String lastName,String code,String email,String phoneCountryCode,String phone,String gender,String dateOfBirth,String jobType,String resignType,String resignReason,String resignDate,String joinDate,String profilePhoto,String departmentIdOrCode,String designationIdOrCode,String status,String siteId,String employeeIdOnDevice,boolean createUser,String id2,String firstName1,String lastName1,String code1,String email1,String phoneCountryCode1,String phone1,String gender1,String dateOfBirth1,String jobType1,String resignType1,String resignReason1,String resignDate1,String joinDate1,String profilePhoto1,String departmentIdOrCode1,String designationIdOrCode1,String status1,String siteId1,String employeeIdOnDevice1,boolean createUser1){
		return "[\n" +
				"  {\n" +
				"    \"id\": \""+id1+"\",\n" +
				"    \"firstName\": \""+firstName+"\",\n" +
				"    \"lastName\": \""+lastName+"\",\n" +
				"    \"code\": \""+code+"\",\n" +
				"    \"email\": \""+email+"\",\n" +
				"    \"religion\": \"indian\",\n" +
				"    \"phoneCountryCode\": \""+phoneCountryCode+"\",\n" +
				"    \"phone\": \""+phone+"\",\n" +
				"    \"gender\": \""+gender+"\",\n" +
				"    \"dateOfBirth\": \""+dateOfBirth+"\",\n" +
				"    \"jobType\": \""+jobType+"\",\n" +
				"    \"resignType\": \""+resignType+"\",\n" +
				"    \"resignReason\": \""+resignReason+"\",\n" +
				"    \"resignDate\": \""+resignDate+"\",\n" +
				"    \"joinDate\": \""+joinDate+"\",\n" +
				"    \"profilePhoto\": \""+profilePhoto+"\",\n" +
				"    \"departmentIdOrCode\": \""+departmentIdOrCode+"\",\n" +
				"    \"designationIdOrCode\": \""+designationIdOrCode+"\",\n" +
				"    \"status\": \""+status+"\",\n" +
				"    \"siteId\": "+siteId+",\n" +
				"    \"employeeIdOnDevice\": \""+employeeIdOnDevice+"\",\n" +
				"    \"createUser\": "+createUser+"\n" +
				"  },\n" +
				"  {\n" +
				"    \"id\": \""+id2+"\",\n" +
				"    \"firstName\": \""+firstName1+"\",\n" +
				"    \"lastName\": \""+lastName1+"\",\n" +
				"    \"code\": \""+code1+"\",\n" +
				"    \"email\": \""+email1+"\",\n" +
				"    \"religion\": \"indian\",\n" +
				"    \"phoneCountryCode\": \""+phoneCountryCode1+"\",\n" +
				"    \"phone\": \""+phone1+"\",\n" +
				"    \"gender\": \""+gender1+"\",\n" +
				"    \"dateOfBirth\": \""+dateOfBirth1+"\",\n" +
				"    \"jobType\": \""+jobType1+"\",\n" +
				"    \"resignType\": \""+resignType1+"\",\n" +
				"    \"resignReason\": \""+resignReason1+"\",\n" +
				"    \"resignDate\": \""+resignDate1+"\",\n" +
				"    \"joinDate\": \""+joinDate1+"\",\n" +
				"    \"profilePhoto\": \""+profilePhoto1+"\",\n" +
				"    \"departmentIdOrCode\": \""+departmentIdOrCode1+"\",\n" +
				"    \"designationIdOrCode\": \""+designationIdOrCode1+"\",\n" +
				"    \"status\": \""+status1+"\",\n" +
				"    \"siteId\": "+siteId1+",\n" +
				"    \"employeeIdOnDevice\": \""+employeeIdOnDevice1+"\",\n" +
				"    \"createUser\": "+createUser1+"\n" +
				"  }\n" +
				"]";
	}

	public static String addPerson(String firstName,String lastName,String nickName,String gender,String personIdOnDevice,String code,String dateOfBirth,String personType,String email,String phoneCountryCode,String phone,String joinDate,String jobType,String siteId,String religion,String departmentIdOrCode,String designationIdOrCode,String status,boolean createUser,String profilePhoto,boolean isResticted,String visitorCompanyName)
	{
       return "{\n" +
			   "  \"firstName\": \""+firstName+"\",\n" +
			   "  \"lastName\": \""+lastName+"\",\n" +
			   "  \"nickName\": \""+nickName+"\",\n" +
			   "  \"gender\": \""+gender+"\",\n" +
			   "  \"personIdOnDevice\": \""+personIdOnDevice+"\",\n" +
			   "  \"code\": \""+code+"\",\n" +
			   "  \"dateOfBirth\": \""+dateOfBirth+"\",\n" +
			   "  \"personType\": \""+personType+"\",\n" +
			   "  \"email\": \""+email+"\",\n" +
			   "  \"phoneCountryCode\": \""+phoneCountryCode+"\",\n" +
			   "  \"phone\": \""+phone+"\",\n" +
			   "  \"joinDate\": \""+joinDate+"\",\n" +
			   "  \"jobType\": \""+jobType+"\",\n" +
			   "  \"siteId\": "+siteId+",\n" +
			   "  \"religion\": \""+religion+"\",\n" +
			   "  \"departmentIdOrCode\": \""+departmentIdOrCode+"\",\n" +
			   "  \"designationIdOrCode\": \""+designationIdOrCode+"\",\n" +
			   "  \"status\": \""+status+"\",\n" +
			   "  \"createUser\": "+createUser+",\n" +
			   "  \"profilePhoto\": \""+profilePhoto+"\",\n" +
			   "  \"isResticted\": "+isResticted+",\n" +
			   "  \"visitorCompanyName\": \""+visitorCompanyName+"\"\n" +
			   "}";
	}
	
	public static String switchCompany(String username,String password,String CompanyId) 
	{
		return "{\r\n"
				+ "\"userName\": \""+username+"\",\r\n"
				+ "	\"password\": \""+password+"\",\r\n"
				+ "	\"companyIdorCode\": \""+CompanyId+"\"\r\n"
				+ "}";
	}
	
	public static String addOrUpdateVisitor(String firstname,String lastname,String nickname,String gender,String code,String dateOfBirth,String visitorIdOnDevice,String email,String phoneCountryCode,String phone,String religion,String profilePhoto,String visitorCompanyName,Boolean isRestricted ) {
		return "{\r\n"
				+ "  \"firstName\": \""+firstname+"\",\r\n"
				+ "  \"lastName\": \""+lastname+"\",\r\n"
				+ "  \"nickName\": \""+nickname+"\",\r\n"
				+ "  \"gender\": \""+gender+"\",\r\n"
				+ "  \"code\": \""+code+"\",\r\n"
				+ "  \"dateOfBirth\": \""+dateOfBirth+"\",\r\n"
				+ "  \"visitorIdOnDevice\": \""+visitorIdOnDevice+"\",\r\n"
				+ "  \"email\": \""+email+"\",\r\n"
				+ "  \"phoneCountryCode\": \""+phoneCountryCode+"\",\r\n"
				+ "  \"phone\": \""+phone+"\",\r\n"
				+ "  \"religion\": \""+religion+"\",\r\n"
				+ "  \"profilePhoto\": \""+profilePhoto+"\",\r\n"
				+ "  \"visitorCompanyName\": \""+visitorCompanyName+"\",\r\n"
				+ "  \"isRestricted\": "+isRestricted+"\r\n"
				+ "}";
	}

	public static String addorupdatePersonIdentification(String employeeIdOrCode,String personIdTypeIdOrCode,String idNumber,String validFrom,String validTo)
	{
		return "{\n" +
				"  \"employeeIdOrCode\": "+employeeIdOrCode+",\n"+
				"  \"personIdTypeIdOrCode\": "+personIdTypeIdOrCode+",\n" +
				"  \"idNumber\": "+idNumber+",\n" +
				"  \"validFrom\": "+validFrom+",\n" +
				"  \"validTo\": "+validTo+"\n" +
				"}";
	}

	public static String addSite(String Name,String code)
	{
		return  "{\n" +
				"  \"name\": \""+Name+"\",\r\n" +
				"  \"code\": \""+code+"\"\r\n" +
				"}";
	}
	
}
