package commonmethod;

import java.io.FileInputStream;	
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_data_Extractor {
	
	public ArrayList<String> getData(String TestCaseName) throws IOException
		{
		
		ArrayList<String> dataArray = new ArrayList<String>();
		
		//Step 1 : Create FileInputStream object with (data excel file name + location as argument) to access the data excel file
		FileInputStream fis=new FileInputStream("C://Rest_Data_Driven//Data_Driven.xlsx");
		//System.out.println("Step 1");
		
		//Step 2 : Create XSSFWorkbook object pass FileInputStream object (fis) as argument
		XSSFWorkbook Excelfile = new XSSFWorkbook(fis);
		//System.out.println("Step 2");
		
		//Step 3 : Fetch count & name of sheets available in the excel file.
		int count= Excelfile.getNumberOfSheets();

		System.out.println("Number of sheets available " +count);
		for(int i=0;i<count;i++)
		{
		   XSSFSheet sheet = Excelfile.getSheetAt(i);
		   System.out.println(sheet.getSheetName());
		}
		
		
		// Step 4 : Get access to the row from which we need to fetch the data
		for (int i=0; i<count; i++)

		{
			
			if(Excelfile.getSheetName(i).equals("Post_Req_Data")) //EXCEL FILE NAME
			{
				System.out.println("requested sheet found");
				XSSFSheet Sheet = Excelfile.getSheetAt(i); //data sheet
				Iterator<Row> rowsofsheet=Sheet.iterator();
				Row Firstrow=rowsofsheet.next();
				Iterator<Cell> Cellofrow=Firstrow.cellIterator();
				
				
				int a=0 ;
				int column=0;
				
				while(Cellofrow.hasNext())
				{
					System.out.println("inside while loop");
					Cell Cellvalue=Cellofrow.next();
					System.out.println(Cellvalue.getStringCellValue());
					if(Cellvalue.getStringCellValue().equals("Filed_Names"))
					{
						column=a;
						System.out.println("column from which the test case is fetched is :" +column);
		
					}
					a++;
				}
				while(rowsofsheet.hasNext())
				{
					Row r=rowsofsheet.next();
					if(r.getCell(column).getStringCellValue().equals("PostReqTC")) //TEST CASE NAME
					{
						Iterator<Cell> cv=r.cellIterator();
						while(cv.hasNext())
						{
							String data=cv.next().getStringCellValue();
							System.out.println(data);
							
						}
						
					}
				}
			}
		}
		
		dataArray.add("String");
		return dataArray;
	}

}
