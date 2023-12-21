package files;

public class CompanyPayload {

	public static String addCompany(String companyCode,String CompanyName, String email, String contact, String reg_no, String address, String city, String state,String Country ,String pin)
	{
		
		return "{\r\n" + 
				"  \"code\": \""+companyCode+"\",\r\n" + 
				"  \"name\": \""+CompanyName+"\",\r\n" + 
				"  \"email\": \""+email+"\",\r\n" + 
				"  \"phone\": \""+contact+"\",\r\n" + 
				"  \"registrationNumber\": \""+reg_no+"\",\r\n" + 
				"  \"address\": \""+address+"\",\r\n" + 
				"  \"city\": \""+city+"\",\r\n" + 
				"  \"state\": \""+state+"\",\r\n" + 
				"  \"country\": \""+Country+"\",\r\n" + 
				"  \"pincode\": \""+pin+"\"\r\n" + 
				"}";
		
	}
	
	public static String joinCompany(String CompanyId, String userID)
	{
		return "{\r\n" + 
				"  \"companyId\": \""+CompanyId+"\",\r\n" + 
				"  \"users\": [\r\n" + 
				"    \""+userID+"\"\r\n" + 
				"  ]\r\n" + 
				"}";
	}
	
	public static String updateCompany(String companyCode, String companyID, String companyName, String email, String contact, String reg_no, String address, String city, String state, String country, String pin)
	{
		return "{\r\n" + 
				"  \"id\": \""+companyID+"\",\r\n" + 
				"  \"code\": \""+companyCode+"\",\r\n" + 
				"  \"name\": \""+companyName+"\",\r\n" + 
				"  \"email\": \""+email+"\",\r\n" + 
				"  \"phone\": \""+contact+"\",\r\n" + 
				"  \"registrationNumber\": \""+reg_no+"\",\r\n" + 
				"  \"address\": \""+address+"\",\r\n" + 
				"  \"city\": \""+city+"\",\r\n" + 
				"  \"state\": \""+state+"\",\r\n" + 
				"  \"country\": \""+country+"\",\r\n" + 
				"  \"pincode\": \""+pin+"\"\r\n" + 
				"}";
	}
}
