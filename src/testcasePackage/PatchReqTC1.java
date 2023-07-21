package testcasePackage;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import requestrepository.Patchrepository;

public class PatchReqTC1 {
	

	public static String runner()
			{
				String local = "";
				for(int i=0;i<3;i++)
				{
					int respstatuscode = PatchReqTC1.fetchstatuscode();
					if(respstatuscode == 200)
					{
						String respbody = PatchReqTC1.fetchresponsebody();
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
				
				int statuscode=RestAssured.given().header("Content-Type","application/json").body(Patchrepository.PatchTC1())
				.when().patch("api/users/2").then().extract().response().getStatusCode();
				return statuscode;
			}
				
				
				public static String fetchresponsebody()
				{
					RestAssured.baseURI="https://reqres.in/";
					
					String responsebody = RestAssured.given().header("Content-Type","application/json").body(Patchrepository.PatchTC1())
							.when().patch("api/users/2").then().extract().response().getBody().asString();
					
					JsonPath jsp = new JsonPath(responsebody);
					String name = jsp.getString("name");
					//String job = jsp.getString("job");
					Assert.assertEquals(name,"morpheus");
					
					
					return responsebody;
				}

		}


		





