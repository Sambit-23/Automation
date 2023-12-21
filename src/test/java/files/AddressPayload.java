package files;

public class AddressPayload {

	public static String addAddress(String l1, String l2, String l3, String country, String state, String city, String areaCode, String lat, String lon, String radius, String isDefault, String addressTypeID)
	{
		return "{\r\n" + 
				"  \"addressLine1\": \"aa\",\r\n" + 
				"  \"addressLine2\": \"aaa\",\r\n" + 
				"  \"addressLine3\": \"aaa\",\r\n" + 
				"  \"country\": \"india\",\r\n" + 
				"  \"state\": \"karnatka\",\r\n" + 
				"  \"city\": \"bangalore\",\r\n" + 
				"  \"areaCode\": \"560068\",\r\n" + 
				"  \"lattitude\": 22.33,\r\n" + 
				"  \"longitude\": 33.33,\r\n" + 
				"  \"radius\": 33.55,\r\n" + 
				"  \"isDefault\": \"true\",\r\n" + 
				"  \"addressTypeId\": \"4028840f75694132017569851d9b0003\"\r\n" + 
				"}";
	}
	
	public static String updateAddress(String addressTypeID, String siteTypeCode, String siteTypeName, String description)
	{
		return "{\r\n" + 
				"  \"id\": \""+addressTypeID+"\",\r\n" + 
				"  \"name\": \"Test\",\r\n" + 
				"  \"code\": \"D9J6\",\r\n" + 
				"  \"description\": \"dddddd\"\r\n" + 
				"}";
	}
}
