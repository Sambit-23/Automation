package files;

public class SiteTypePayload {

	public static String addSiteType(String id, String siteTypeCode, String sitetypeName, String description)
	{
		return "[\r\n"
				+ "  {\r\n"
				+ "    \"code\": \""+siteTypeCode+"\",\r\n"
				+ "    \"name\": \""+sitetypeName+"\",\r\n"
				+ "    \"description\": \""+description+"\"\r\n"
				+ "  }\r\n"
				+ "]";
	}
	
	public static String updateSiteType(String siteTypeID, String siteTypeCode, String siteTypeName, String description )
	{
		return "{\r\n"
				+ "  \"id\": \""+siteTypeID+"\",\r\n"
				+ "  \"code\": \""+siteTypeCode+"\",\r\n"
				+ "  \"name\": \""+siteTypeName+"\",\r\n"
				+ "  \"description\": \""+description+"\"\r\n"
				+ "}";
	}
}
