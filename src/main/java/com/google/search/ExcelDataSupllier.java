package com.google.search;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.reporters.jq.Main;

public class ExcelDataSupllier {

	@DataProvider(name = "Cred")
	public String[][] getData() throws Exception {

		File excelFile = new File(
				"C:\\Users\\Shivam\\eclipse-workspace\\MyMavenFirstProject\\ExcelFiles\\Testdata.xlsx");
		System.out.println(excelFile.exists());

		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		System.out.println(sheet.getPhysicalNumberOfRows());
		System.out.println(sheet.getLastRowNum());

		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfColumns = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[noOfRows - 1][noOfColumns];

		for (int i = 0; i < noOfRows - 1; i++) {
			for (int j = 0; j < noOfColumns; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
			}
			workbook.close();
			fis.close();

		}
		return data;

	}

}
