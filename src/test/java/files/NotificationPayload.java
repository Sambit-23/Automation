package files;

public class NotificationPayload {

	public static String getNotificationPayload(String messageType, String MessageStatus, String messageBody, String Sender, String receivername, String ReceiverEmail, String Subject, String TemplateID, String userName, String link)
	{
		return "{\r\n" + 
				"  \"messageType\": \""+messageType+"\",\r\n" + 
				"  \"messageStatus\": \""+MessageStatus+"\",\r\n" + 
				"  \"messageBody\": \""+messageBody+"\",\r\n" + 
				"  \"sender\": \""+Sender+"\",\r\n" + 
				"  \"recipient\": {\r\n" + 
				"    \"name\": \""+receivername+"\",\r\n" + 
				"    \"address\": \""+ReceiverEmail+"\"\r\n" + 
				"  },\r\n" + 
				"  \"subject\": \""+Subject+"\",\r\n" + 
				"  \"templateId\": \""+TemplateID+"\",\r\n" + 
				"  \"templateParameter\": {\r\n" + 
				"    \"userName\": \""+userName+"\",\r\n" + 
				"    \"link\": \""+link+"\"\r\n" + 
				"  }\r\n" + 
				"}";
	}
}
