package commonmethod;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Extractor {
	

	           public ArrayList<String> getData(String Sheetname ,String TestCaseName) throws IOException
			{
				ArrayList<String> dataArray = new ArrayList<String>();
				
				//Step 1 : Create FileInputStream object with (data excel file name + location as argument) to access the data excel file
				FileInputStream fis = new FileInputStream("C://Rest_Data_Driven//Data_Driven.xlsx");
				
				//Step 2 : Create XSSFWorkbook object pass FileInputStream object (fis) as argument
				XSSFWorkbook ExcelFile = new XSSFWorkbook(fis); 			
				
				//Step 3 : Fetch count and name of sheets available in the excel file.
				int count = ExcelFile.getNumberOfSheets();
				
				// Step 4 : Get access to the row from which we need to fetch the data
				for (int i=0; i<count; i++)
				{
					if(ExcelFile.getSheetName(i).equals(Sheetname))
					{
						XSSFSheet Sheet = ExcelFile.getSheetAt(i);
						Iterator<Row> rowsofsheet=Sheet.iterator();				
						Row Firstrow=rowsofsheet.next();
						Iterator<Cell> Cellofrow=Firstrow.cellIterator();
						
						int a=0 ;
						int column=0;
						
						while(Cellofrow.hasNext())
						{						
							Cell Cellvalue=Cellofrow.next();						
							if(Cellvalue.getStringCellValue().equals("TC_Name"))
							{
								column=a;
								System.out.println("column from which the test case is fetched is :" +column);
							}
							a++;
						}
						while(rowsofsheet.hasNext())
						{
							Row r=rowsofsheet.next();
							if(r.getCell(column).getStringCellValue().equals(TestCaseName))
							{
								Iterator<Cell> cv=r.cellIterator();
								while(cv.hasNext())
								{
									String data=cv.next().getStringCellValue();								
									dataArray.add(data);
								}
								
							}
						}
					}
				
		
			}
				return dataArray;		
			}	
	}



