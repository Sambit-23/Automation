package files;

public class AddressTypePayload{

	public static String addAddressType(String id, String sitetypeName, String siteTypeCode, String description)
	{
		return "[\r\n"
				+ "  {\r\n"
				+ "    \"name\": \""+sitetypeName+"\",\r\n"
				+ "    \"code\": \""+siteTypeCode+"\",\r\n"
				+ "    \"description\": \""+description+"\"\r\n"
				+ "  }\r\n"
				+ "]";
	}
	
	public static String updateAddressType(String addrTypeID, String addrTypeCode, String addrTypeName, String description )
	{
		
		return "{\r\n"
				+ "  \"id\": \""+addrTypeID+"\",\r\n"
				+ "  \"name\": \""+addrTypeName+"\",\r\n"
				+ "  \"code\": \""+addrTypeCode+"\",\r\n"
				+ "  \"description\": \""+description+"\"\r\n"
				+ "}";
	}
}
