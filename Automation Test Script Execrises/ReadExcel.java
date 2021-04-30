package automationTestScriptExecrises;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;



public class ReadExcel {

	public Object[][] ReadExcelData(String FilePath, String SheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream(FilePath);
		Workbook workbook= WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet(SheetName);
		int rows =sheet.getLastRowNum();
		int columns=sheet.getRow(0).getLastCellNum();

		//create the data provider here
		Object [][] CarsTestData= new Object[rows][columns];

		//Iterate through the rows
		for (int row=0;row<rows;row++) {
			for(int column=0;column<columns;column++) {
				Cell cell=sheet.getRow(row+1).getCell(column);

				switch (cell.getCellType()) {
				case STRING:
					CarsTestData[row][column]=cell.getStringCellValue();
					break;
				case NUMERIC: 
					CarsTestData[row][column]=NumberToTextConverter.toText(cell.getNumericCellValue());
					break;
				default:
					CarsTestData[row][column]=cell.getStringCellValue();
					break;
				}
//				System.out.println(CarsTestData[row][column]);
			}
			
		}
		return CarsTestData;
	




	}
	
//	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		ReadExcel testData= new ReadExcel();
//		testData.ReadExcelData("C:\\Programming Related\\GIT\\FrameWorkDevelopmentExercises\\src\\test\\resources\\TwitterAccount\\TwitterAccountTestData.xlsx", "LoginTest");
//		
//	}

}
