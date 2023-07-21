package testcasePackage;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class DeleteReqTC1 {
	
	

public static String runner()
				{
					String local = "";
					for(int i=0;i<3;i++)
					{
						int respstatuscode = DeleteReqTC1.fetchstatuscode();
						if(respstatuscode == 204)
						{
							String respbody = DeleteReqTC1.fetchresponsebody();
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
					
					int statuscode=RestAssured.given().body("")
					.when().delete("api/users/2").then().extract().response().getStatusCode();
					return statuscode;
				}
					
					
					public static String fetchresponsebody()
					{
						RestAssured.baseURI="https://reqres.in/";
						
						String responsebody = RestAssured.given().body("")
								.when().delete("api/users/2").then().extract().response().getBody().asString();
						
						JsonPath jsp = new JsonPath(responsebody);
						int statuscode=RestAssured.given().body("")
						.when().delete("api/users/2").then().extract().response().getStatusCode();
						
						Assert.assertEquals(statuscode,204);
						//System.out.println(statuscode);
						
						return responsebody;
					}

			}


		
