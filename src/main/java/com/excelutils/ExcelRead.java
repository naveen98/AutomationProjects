package com.excelutils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelRead {
	@Test
	public static String[][] readExcel(String filePath, String sheetName) {

		// initializing temporary as null
		String[][] data = null;
		
		// path of the excel sheet
		try (FileInputStream fis = new FileInputStream(filePath);
				
				// opening workbook
				Workbook workbook = WorkbookFactory.create(fis)) {
			
			// getting sheet
			Sheet sh = workbook.getSheet(sheetName);
			
			// counts the row and columns and print it
			int rowCount = sh.getPhysicalNumberOfRows();

			int colCount = sh.getRow(0).getPhysicalNumberOfCells();
			System.out.println(rowCount + " " + colCount);

			// storing the data 2D
			data = new String[rowCount][colCount];

			// Start from index 0 and loop
			for (int i = 0; i < rowCount; i++) {
				Row row = sh.getRow(i);
				System.out.println(row);

				// row not =null means it will exceute loop until the cells
				if (row != null) {
					for (int c = 0; c < colCount; c++) {
						Cell cell = row.getCell(c);
						System.out.println(cell);

						// cell not = null means tosrting format checking the spaces and give data
						data[i][c] = (cell != null) ? cell.toString().trim() : "";

					}

				}
			}

			// check the exception input and output
		} catch (IOException e) {
			e.printStackTrace();
		}
		// returns the data
		return data;
	}

}
