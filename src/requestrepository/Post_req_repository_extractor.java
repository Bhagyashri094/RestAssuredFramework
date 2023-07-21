package requestrepository;
import java.io.IOException;
import java.util.ArrayList;

import commonmethod.Extractor;


public class Post_req_repository_extractor {
	

	
        static Extractor Excldata = new Extractor();
		public static String postTC1() throws IOException
		{
			ArrayList inputdata=Excldata.getData("Post_Req_Data","PostReqTC1");
			String name=(String) inputdata.get(1);
			String job=(String) inputdata.get(2);
			System.out.println(name);
			System.out.println(job);
			
			return"{\r\n"
					+ "    \"name\": \""+name+"\",\r\n"
					+ "    \"job\": \""+job+"\"\r\n"
					+ "}";
		}
		public static String postTC2() throws IOException
		{
			return"{\r\n"
					+ "    \"name\": \"Varsha\",\r\n"
					+ "    \"job\": \"leader\"\r\n"
					+ "}";
		}
	}




