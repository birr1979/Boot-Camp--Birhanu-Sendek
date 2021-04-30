package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.testng.annotations.DataProvider;


public class readExcelData {

	public  static Object[][] readExcelData(String testDataFilePath,String sheetName) throws Exception {

		
		File filepath=new File(testDataFilePath);
		FileInputStream fis=new FileInputStream(filepath);
		//WorkbookFatory is a replacement of XSSFWorkbook/or HSSFWorkbook
		Workbook workbook =WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet(sheetName);
		//row count
		int rowCount=sheet.getLastRowNum();
//		System.out.println("Row Count"+rowCount);
		//column count
		int colCount=sheet.getRow(0).getLastCellNum();
//		System.out.println("Column count"+colCount);
//		System.out.println("*******************************************");
		//Create a 2D array of the objects based on the size of the excel sheet
		Object[][]data=new Object[rowCount][colCount];
		
		//Iterate through each row in the sheet
		for(int row=0;row<rowCount;row++) {
			//iterate through cell column
			for(int col=0;col<colCount;col++) {
				//get the cell in the row
				Cell cell= sheet.getRow(row+1).getCell(col);
				
				//Determine the cell type the type of data to retrive the approprate cell data 
				//and store it in the 2D array
				
				switch(cell.getCellType() ) {
				case STRING:
					data[row][col]=cell.getStringCellValue();
					break;
				case NUMERIC: 
					data[row][col]=NumberToTextConverter.toText(cell.getNumericCellValue());
									break;
				case BLANK:
					data[row][col]=cell.getCellType().BLANK; //"BLANK CELL";
					break;
				default:
					data[row][col]=cell.getStringCellValue();
				}
//				System.out.println(data[row][col]);
				
			}
			System.out.println("Test Data Received from Excel File.");

		}
		
		
		return data;
		
	}
	
	
	
	//Common Data Provider 
	  
	  /*
		 * Method m --> Java Reflections API
		 * Method class returns the current method being executed by JVM
		 * .getName() method returns the name of the current method being executed as a String
		 */
		
	
	@DataProvider(name="commonDataProvider")
	public Object[][] getData(Method m) throws Exception{
		readExcelData data= new readExcelData();
		return data.readExcelData("C:\\Programming Related\\NEW WORKSPACE\\BootCamp\\src\\test\\resources\\ExcelData\\TwitterAccountTestData.xlsx", m.getName());
		
		
	}
	
//	public static void main(String[] args) throws Exception {
//		readExcelData testData= new readExcelData();
//		testData.readExcelData("C:\\Programming Related\\GIT\\FrameWorkDevelopmentExercises\\src\\test\\resources\\TwitterAccount\\TwitterAccountTestData.xlsx", "LoginTest");
//		
//	}
	
	
	
	
}
