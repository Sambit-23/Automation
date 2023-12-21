package files;

import java.util.HashMap;

public class EmployeePayload {

	public static String addEmployee(String FirstName, String gender, String joinDate, String EmpIDOnDevice)
	{
		return "{\r\n" + 
				"  \"employee\": {\r\n" + 
				"    \"firstName\": \""+FirstName+"\",\r\n" + 
				"    \"gender\": \""+gender+"\",\r\n" + 
				"    \"joinDate\": \""+joinDate+"\",\r\n" + 
				"    \"employeeIdOnDevice\": \""+EmpIDOnDevice+"\"\r\n" + 
				" }\r\n" + 
				"}";
	}
	
	public static String updateEmployee(String empID, String FirstName, String gender, String joinDate, String EmpIDOnDevice)
	{
		return "{\r\n" + 
				"  \"employee\": {\r\n" + 
				"    \"id\": \""+empID+"\",\r\n" + 
				"    \"firstName\": \""+FirstName+"\",\r\n" + 
				"    \"gender\": \""+gender+"\",\r\n" + 
				"    \"joinDate\": \""+joinDate+"\",\r\n" + 
				"    \"employeeIdOnDevice\": \""+EmpIDOnDevice+"\"\r\n" + 
				"  }\r\n" + 
				"}";
	}
	
	public static String createEmployee(HashMap<String, String> data)
	{
		
		return "[\r\n"
				+ "  {\r\n"
				+ "    \"firstName\": \""+data.get("fname")+"\",\r\n"
				+ "    \"lastName\": \""+data.get("lname")+"\",\r\n"
				+ "    \"nickName\": \"swxc\",\r\n"
				+ "    \"gender\": \"M\",\r\n"
				+ "    \"religion\": \"Hindu\",\r\n"
				+ "    \"dateOfBirth\": \"19-06-1993\",\r\n"
				+ "    \"departmentId\": \"\",\r\n"
				+ "    \"designationId\": \"\",\r\n"
				+ "    \"manager\": {\r\n"
				+ "      \"id\": \"\",\r\n"
				+ "      \"code\": \"\"\r\n"
				+ "    },\r\n"
				+ "    \"employeeCode\": \""+data.get("employeeIdOnDevice")+"\",\r\n"
				+ "    \"type\": \"Permanent\",\r\n"
				+ "    \"resignReason\": \"Not happy\",\r\n"
				+ "    \"resignType\": \"Sacked\",\r\n"
				+ "    \"joinDate\": \"19-06-2020\",\r\n"
				+ "    \"resignDate\": \"10-02-2021\",\r\n"
				+ "    \"createUser\": true,\r\n"
				+ "    \"isVerified\": true,\r\n"
				+ "    \"profilePhoto\": \"BASE64String\",\r\n"
				+ "    \"email\": \""+data.get("email")+"\",\r\n"
				+ "    \"phone\": \""+data.get("PhoneNumber")+"\",\r\n"
				+ "    \"password\": \""+data.get("password")+"\"\r\n"
				+ "  }\r\n"
				+ "]";
		
	}
	
	public static String createEmployee(HashMap<String, String> data, String fname, String id, String deptID, String desgnID)
	{
		return "{\r\n"
				+ "  \"firstName\": \""+fname+"\",\r\n"
				+ "  \"lastName\": \""+data.get("lname")+"\",\r\n"
				+ "  \"nickName\": \"Gopal\",\r\n"
				+ "  \"gender\": \"M\",\r\n"
				+ "  \"religion\": \"Hindu\",\r\n"
				+ "  \"dateOfBirth\": \"19-06-1993\",\r\n"
				+ "  \"departmentId\": \""+deptID+"\",\r\n"
				+ "  \"designationId\": \""+desgnID+"\",\r\n"
				+ "  \"manager\": {\r\n"
				+ "    \"id\": \"\",\r\n"
				+ "    \"code\": \"\"\r\n"
				+ "  },\r\n"
				+ "  \"employeeCode\": \""+data.get("employeeIdOnDevice")+"\",\r\n"
				+ "  \"type\": \"Permanent\",\r\n"
				+ "  \"resignReason\": \"Not happy\",\r\n"
				+ "  \"resignType\": \"Sacked\",\r\n"
				+ "  \"joinDate\": \"19-06-2020\",\r\n"
				+ "  \"resignDate\": \"10-02-2021\",\r\n"
				+ "  \"isVerified\": true,\r\n"
				+ "  \"profilePhoto\": \"BASE64String\",\r\n"
				+ "  \"email\": \""+data.get("email")+"\",\r\n"
				+ "  \"phone\": \""+data.get("PhoneNumber")+"\",\r\n"
				+ "  \"password\": \""+data.get("password")+"\"\r\n"
				+ "}";
		
		
		
		
		
		
	}
}
