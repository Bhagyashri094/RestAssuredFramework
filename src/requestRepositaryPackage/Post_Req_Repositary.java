package requestRepositaryPackage;

import java.io.IOException;
import java.util.ArrayList;

import commonfunctionspackage.utility_commonfunctions;

public class Post_Req_Repositary {
	public static String base_URI(){
		String baseURI = "https://reqres.in/";
		return baseURI;
		
	}
	
	public static String Post_resource()
	{
		String resource = "/api/users";
		return resource;
	}
	
	public static String Post_Req_Tc1() throws IOException
	{
		ArrayList<String> data = utility_commonfunctions.readdataexcel("Post_Test_Data"," Post_TC_1");
		String req_name=data.get(1);
		String req_job=data.get(2);
		String requestBody = "{\r\n"
				+ "    \r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		return requestBody;
				
	}
	public static String Post_Req_Tc2() throws IOException
	{
		ArrayList<String> data = utility_commonfunctions.readdataexcel("Post_Test_Data"," Post_TC_2");
		String req_name=data.get(1);
		String req_job=data.get(2);
		String requestBody = "{\r\n"
				+ "    \r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		return requestBody;
				
	}
	
	public static String Post_Req_Tc3() throws IOException
	{
		ArrayList<String> data = utility_commonfunctions.readdataexcel("Post_Test_Data"," Post_TC_3");
		String req_name=data.get(1);
		String req_job=data.get(2);
		String requestBody = "{\r\n"
				+ "    \r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		return requestBody;
				
	}
	public static String Post_Req_Tc4() throws IOException
	{
		ArrayList<String> data = utility_commonfunctions.readdataexcel("Post_Test_Data"," Post_TC_4");
		String req_name=data.get(1);
		String req_job=data.get(2);
		String requestBody = "{\r\n"
				+ "    \r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \"" +req_job+"\"\r\n"
				+ "}";
		return requestBody;
				
	}

}
