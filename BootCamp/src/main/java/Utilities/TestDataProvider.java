package Utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
		
		readExcelData excel = new readExcelData();
		
		/*
		 * Method m --> Java Reflections API
		 * Method class returns the current method being executed by JVM
		 * .getName() method returns the name of the current method being executed as a String
		 */
		
		
		@DataProvider(name="commonDataProvider")
		public Object [][] getTestData(Method m) throws Exception{
			Object [][] testData = excel.readExcelData("C:\\Programming Related\\GIT\\FrameWorkDevelopmentExercises\\src\\test\\resources\\TwitterAccount\\TwitterAccountTestData.xlsx", "LoginTest");
			
			return testData;
		}
}
