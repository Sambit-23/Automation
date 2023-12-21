package files;

public class UserPayload {

	public static String addUser(String FName, String LName, String Contact,String email, String password, String companyID, String roleID)
	{
		
		return "{\r\n" + 
				"  \"firstName\": \""+FName+"\",\r\n" + 
				"  \"lastName\": \""+LName+"\",\r\n" + 
				"  \"phone\": \""+Contact+"\",\r\n" + 
				"  \"email\": \""+email+"\",\r\n" + 
				"  \"password\": \""+password+"\",\r\n" + 
				"  \"confirmPassword\": \""+password+"\",\r\n" +
				"  \"companyId\": \""+companyID+"\",\r\n" + 
			    "  \"roleId\": \"4028d0837554163e017554164d490002\",\r\n" +
				"  \"applicationId\": [\r\n" +
				"    \"7143f07ce29146509eabe7c55dfa55dd\",\r\n" +
				"    \"mobile\"\r\n" +
				"  ]\r\n" + 
				"}";
		
		
		
	}
	
	
}
