package testclasspackage;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.time.LocalDate;
import commonfunctionspackage.API_common_function;
import commonfunctionspackage.utility_commonfunctions;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import requestRepositaryPackage.Post_Req_Repositary;

public class Post_TC_1 
{

	public static void execute() throws IOException 
	{
		for(int i=0;i<5;i++) 
		{
			
			int res_status_code = API_common_function.response_statuscode(Post_Req_Repositary.base_URI(),Post_Req_Repositary.Post_resource(),
					Post_Req_Repositary.Post_Req_Tc1());
			if(res_status_code==201) 
		
					String response_Body = API_common_function.response_body(Post_Req_Repositary.base_URI(),Post_Req_Repositary.
							Post_resource(),Post_Req_Repositary.Post_Req_Tc1());
			System.out.println(response_Body);
					Post_TC_1.validator(response_Body,res_status_code);
					utility_commonfunctions.evidencefilecreator("Post_TC_1", Post_Req_Repositary.Post_Req_Tc1(),response_Body);
					System.out.println(res_status_code);
					break;
			}
			else 
			{
					System.out.println("correct status code is not found hence retrying the API");
			}
				
		}
	
		public static void validator(String response_Body,int res_status_code,String requestbody) {
			//step3:parse the response body
		JsonPath jp = new JsonPath(response_Body);
		
		String res_name = jp.get("name");
		String res_job = jp.get("job");
		String res_id = jp.get("id");
		String res_createdAt = jp.get("createdAt");
		//step4:validate response body parameter
		//Assert.assertEquals(res_name, "morpheus");
		//Assert.assertEquals(res_job, "leader");
		//Assert.assertNotNull(res_id, "assertion error", "id parameter is not null");

		//extract data from createdat parameter
		String actual_date = res_createdAt.substring(0,10);
		String current_date = LocalDate.now().toString();
		//Assert.assertEquals(actual_date,current_date);
		
	}
}
