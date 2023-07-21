package commonfunctionspackage;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import requestRepositaryPackage.Post_Req_Repositary;

public class API_common_function
{
	
	public static int response_statuscode(String baseURI,String Resource,String requestbody)
	{
		RestAssured.baseURI = baseURI;
		int statuscode = given().header("Content-Type","application/json").body(requestbody).when().post(Resource)
				.then().extract().statusCode();
		
		//step 2.1:without log all
		return statuscode;
		
	}
	public static int response_body(String baseURI,String Resource,String requestbody) {
		RestAssured.baseURI = baseURI;
		
		//step 2.1:without log all
		String responsebody = given().header("Content-Type","application/json").body(requestbody).when().post(Resource).then().extract().response().asString();
		return responsebody;
		
		

}
}