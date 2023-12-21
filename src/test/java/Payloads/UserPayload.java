package Payloads;

public class UserPayload {
	public static String addUser(String FName, String LName, String Contact,String email, String password, String companyID, String roleID)
	{
		
		return "{\r\n"
				+ "  \"firstName\": \""+FName+"\",\r\n"
				+ "  \"lastName\": \""+LName+"\",\r\n"
				+ "  \"email\": \""+email+"\",\r\n"
				+ "  \"phone\": \""+Contact+"\",\r\n"
				+ "  \"verified\": true,\r\n"
				+ "  \"password\": \""+password+"\"\r\n"
				+ "}";
		
		
		
	}

	public static String updateUser(String FName, String LName, String Contact,String email, String password, String companyID, String roleID)
	{

		return "{\n" +
				"  \"firstName\": \""+FName+"\",\n" +
				"  \"lastName\": \""+LName+"\",\n" +
				"  \"nickName\": \"axz\",\n" +
				"  \"dateOfBirth\": \"15-12-1992\",\n" +
				"  \"gender\": \"male\",\n" +
				"  \"profilePhoto\": \"base64EncodedString\",\n" +
				"  \"email\": \""+email+"n\",\n" +
				"  \"phone\": \"+91-9878654321\",\n" +
				"  \"verified\": true,\n" +
				"  \"password\": \""+password+"\"\n" +
				"}";
	}
	
	
}
