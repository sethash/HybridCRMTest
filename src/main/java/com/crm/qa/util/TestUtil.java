package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long page_load_timeout = 20;
	public static long implicit_wait = 10;
	static String TestDataSheetPath = "C:\\Users\\ashish\\eclipse-workspace\\HybridCrmtest\\src\\main\\java\\com\\crm\\qa\\testdata\\TestData.xlsx";
	static Workbook book;
	public static void SwitchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file = null;
		try {
			 file = new FileInputStream(TestDataSheetPath);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Sheet sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i =0;i<sheet.getLastRowNum();i++)
		{
			for(int k =0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}

}
