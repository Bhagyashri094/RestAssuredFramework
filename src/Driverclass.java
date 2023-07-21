import java.io.IOException;
import java.util.ArrayList;

import commonmethod.Excel_data_Extractor;
import commonmethod.Extractor;
import testcasePackage.DeleteReqTC1;
import testcasePackage.GetReqTC1;
import testcasePackage.PatchReqTC1;
import testcasePackage.PostReqTC1;
import testcasePackage.PutReqTC1;

public class Driverclass 
{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		
//     String responseTC1 = PostReqTC1.runner();
//		 System.out.println(responseTC1);
//	 
//		 String responseTC2 = PatchReqTC1.runner();
//		 System.out.println(responseTC2);
//
//		 String responseTC3 = PutReqTC1.runner();
//		 System.out.println(responseTC3);
//		 
//		 String responseTC4 = DeleteReqTC1.runner();
//		 System.out.println(responseTC4);
//		 
//		 String responseTC5 = GetReqTC1.runnerTC();
//		 System.out.println(responseTC5);
		 
		

	
		Excel_data_Extractor test = new Excel_data_Extractor();
	    String PostReqTC1 = null;
		ArrayList<String> inputdata = test.getData("string");
		for(int i=0;i<inputdata.size();i++)
		{
			String Data = (String) inputdata.get(i);
			System.out.println("dataindex" +i+ "\t=\t" +Data);
		}
	}
}
		
		
		
//		String responseTC1 = PostReqTC1.runner();
//        System.out.println(responseTC1);		
//	}
//
//}



//Excel_data_Extractor Excldata = new Excel_data_Extractor();
//ArrayList inputdata = Excldata.getData("string");
//
//for (int i=0; i<inputdata.size();i++)
//{
//	String data = (String) inputdata.get(i);
//	System.out.println("data_at_index" +i+ "\t=\t" +data);
//}
//	}
//}
