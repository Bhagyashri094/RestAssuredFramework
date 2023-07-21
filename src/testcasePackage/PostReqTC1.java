
package testcasePackage;     
import org.testng.Assert;     //An import statement tells the compiler the path of a class or the entire package

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import requestrepository.Postrespository;

	
public class PostReqTC1 {
		
		public static String runner()
		{
			String local = "";
			for(int i=0;i<3;i++)
			{
				int respstatuscode = PostReqTC1.fetchstatuscode();
				if(respstatuscode == 201)
				{
					String respbody = PostReqTC1.fetchresponsebody();
					local = respbody;
					break;
				}
				else
				{
					System.out.println("Correct Statuscode Not Found Hence Retrying");
					
				}
			}
			return local;
		}
		

		public static int fetchstatuscode()
		{
			RestAssured.baseURI="https://reqres.in/";
			
			int statuscode=RestAssured.given().header("Content-Type","application/json").body(Postrespository.PostTC1())
			.when().post("api/users").then().extract().response().getStatusCode();
			
			Assert.assertEquals(statuscode,201);
			return statuscode;
		}
			
			
			public static String fetchresponsebody()
			{
				RestAssured.baseURI="https://reqres.in/";
				
				String responsebody = RestAssured.given().header("Content-Type","application/json").body(Postrespository.PostTC1())
			 .when().post("api/users").then().extract().response().getBody().asString();
				
				JsonPath jsp = new JsonPath(responsebody); //read JSON responsebody(Parse)
				String name = jsp.getString("name");
				String job = jsp.getString("job");
				
				Assert.assertEquals(name,"morpheus"); //validate the response
				
				
				return responsebody;
			}

	}



	


