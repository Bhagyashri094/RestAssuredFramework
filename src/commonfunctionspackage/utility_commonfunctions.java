package commonfunctionspackage;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;


public class utility_commonfunctions {
	public static void evidencefilecreator(String filename,String requestbody,String responsebody) throws IOException 
	{
		File newfile = new File("C:\\Users\\Varsha\\Desktop\\RestAssured" +filename+".txt");
		System.out.println("A New text file cretaed to record requested response of API:"  +newfile.getName());
		FileWriter datawrite = new FileWriter(newfile);
		datawrite.write("request body:" +requestbody+ "\n\n");
		datawrite.write("response body:" +responsebody+ "\n\n");
		datawrite.close();
		System.out.println("request body and response body are saved in : " +newfile.getName());
	}
	public static ArrayList<String> readdataexcel(String sheetname,String testcasename) throws IOException
	{
		ArrayList<String> ArrayData = new ArrayList<String>();
		//step1:create object of file input stream
		FileInputStream fis = new FileInputStream("C:\\Users\\Varsha\\Desktop\\RestAssured\\testdata.xlsx");
		//step2:access the excel file
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//step3:access the sheet name
		int countofsheet = workbook.getNumberOfSheets();
		for(int i=0;i<countofsheet;i++)
		{
			String filesheetname = workbook.getSheetName(i);
			if(filesheetname.equalsIgnoreCase(sheetname))
			{
				//step4:access the row from where the data is suppose to be fetch
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row>  rows = sheet .iterator();
				Row r=rows.next();
				while(rows.hasNext())
				{
					if(r.getCell(1).getStringCellValue().equalsIgnoreCase(testcasename))
					{
						Iterator<Cell> cellvalues=r.cellIterator();
						while(cellvalues.hasNext())
						{
							String testdata = cellvalues.next().getStringCellValue();
							ArrayData.add(testdata);
							
						}
						
					}
						
				}
			}
		}
		return ArrayData;
	}
	
	

}
