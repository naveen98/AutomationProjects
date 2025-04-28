package com.xlutils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	public static FileInputStream fi;
	public static Workbook wb;
	public static Sheet sh;
	public static Row row;
	public static Cell cell;

	// reading all rows from excel

	public static int getrowcount(String xlfilepath, String sheetname) throws IOException {
		fi = new FileInputStream(xlfilepath);
		wb = WorkbookFactory.create(fi);
		sh = wb.getSheet(sheetname);

		// get the number of physically used rows not empty rows
		int rowCount = sh.getPhysicalNumberOfRows();
		// wb.close();
		// fi.close();
		System.out.println(rowCount);
		return rowCount;

	}

	// reading all cells from excel

	public static int getcellcount(String xlfilepath, String sheetname, int rownum) throws IOException {

		fi = new FileInputStream(xlfilepath);
		wb = WorkbookFactory.create(fi);
		sh = wb.getSheet(sheetname);
		row = sh.getRow(rownum);

		// Returns the number of columns in the first row
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;

	}

	// reading data from excell

	public static String[][] getcelldata(String xlfilepath, String sheetname) throws IOException {

		fi = new FileInputStream(xlfilepath);

		wb = WorkbookFactory.create(fi);

		sh = wb.getSheet(sheetname);

		int totalrow = sh.getPhysicalNumberOfRows();

		int totalcols = sh.getRow(0).getLastCellNum();

		DataFormatter formatter = new DataFormatter();

		String data[][] = new String[totalrow - 1][totalcols];

		for (int i = 1; i < totalrow; i++) {

			Row row = sh.getRow(i);
			if (row == null) {

				for (int j = 0; j < totalcols; j++) {

					data[i - 1][j] = "";
				}
				continue;
			}
			for (int j = 0; j < totalcols; j++) {

				Cell col = row.getCell(j);

				data[i - 1][j] = (col != null) ? formatter.formatCellValue(col) : "";

			}
		}
		fi.close();
		return data;

	}

	// Write data into excel
	public static void writecelldata(String xlfilepath, String sheetname, int rownum, int cellnum, String data)
			throws EncryptedDocumentException, IOException {

		fi = new FileInputStream(xlfilepath);
		wb = WorkbookFactory.create(fi);
	    sh=wb.getSheet(sheetname);
	    
	    
	    Row row= sh.getRow(rownum);
	    if(row==null) {
	    	
	    
	    row=sh.createRow(rownum);
	    
	    }
	    Cell cell=row.getCell(cellnum);
	    if(cell==null) {
	    	
	    	cell=row.createCell(cellnum);
	
	    cell.setCellValue(data);
	   }
	    
	    fi.close();
	    
	    FileOutputStream fos = new FileOutputStream(xlfilepath);
	    wb.write(fos);
	    fos.close();
	   fos.close();
	    

	}

}
