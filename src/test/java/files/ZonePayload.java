package files;

public class ZonePayload {

	public static String addAddress(String name, String description, String siteID, String parentZoneID)
	{
		return "{\r\n" + 
				"  \"name\": \"Test\",\r\n" + 
				"  \"description\": \"hhhhh\",\r\n" + 
				"  \"siteId\": \"4028840f758cc60901758cccb47d0001\",\r\n" + 
				"  \"parentZone\": {\r\n" + 
				"    \"id\": \"4028840f758cfbec01758cffc5100000\"\r\n" + 
				"  }\r\n" + 
				"}";
	}
	
	public static String updateAddress(String zoneId, String name, String description, String siteID, String parentID)
	{
		return "{\r\n" + 
				"  \"id\": \"4028840f758cfbec01758cffc5100000\",\r\n" + 
				"  \"name\": \"Test\",\r\n" + 
				"  \"description\": \"D9J6\",\r\n" + 
				"  \"siteId\": \"4028840f758cc60901758cccb47d0001\",\r\n" + 
				"  \"parentZone\": {\r\n" + 
				"    \"id\": \"4028840f758cfbec01758cffc5100000\"\r\n" + 
				"  }\r\n" + 
				"}";
	}
}
