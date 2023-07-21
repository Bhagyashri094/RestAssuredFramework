package testcasePackage;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetReqTC1 {
	
	public static String runnerTC()
	{
		for (int i=0;i<=4;i++)
		{
		 int statuscode=GetReqTC1.FetchstatuscodeTC1();	
		 if (statuscode == 200)
		 {
			 String responsebody=GetReqTC1.FetchresponsebodyTC1();
			 break;
		 }
		 else
		 {
			 System.out.println("correct status code not found");
		 }
		}
		return GetReqTC1.FetchresponsebodyTC1();
	}
	
	public static int FetchstatuscodeTC1()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		int statuscode=RestAssured.given().when().get("api/users?page=2").then().extract().response().getStatusCode();
		
	    return statuscode;
	}

	public static String FetchresponsebodyTC1()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		String responsebody=RestAssured.given().when().get("api/users?page=2").then().extract().response().getBody().asString();
		
		JsonPath jsp=new JsonPath(responsebody);
		String page = jsp.getString("page");
		String per_page = jsp.getString("per_page");
		String total = jsp.getString("total");
		String total_pages = jsp.getString("total_pages");
		String Id1 = jsp.getString("data[0].id");
		String Email1 = jsp.getString("data[0].email");
		String Firstname = jsp.getString("data[0].first_name");
		String Lastname = jsp.getString("data[0].last_name");
		String Avatar = jsp.getString("data[0].avatar");
		
		Assert.assertNotEquals(page,null);
		Assert.assertNotEquals(per_page,null);
		Assert.assertNotEquals(total,null);
		Assert.assertNotEquals(total_pages,null);
		Assert.assertNotEquals(Id1,null);
		Assert.assertNotEquals(Email1,null);
		Assert.assertNotEquals(Firstname,null);
		Assert.assertNotEquals(Lastname,null);
		Assert.assertNotEquals(Avatar,null);
		
		return responsebody;
		
		}
}