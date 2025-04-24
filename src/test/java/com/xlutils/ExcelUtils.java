package com.xlutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

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
        int rowCount = sh.getPhysicalNumberOfRows();  
     //   wb.close();
   //     fi.close();
        System.out.println(rowCount);
        return rowCount;

	}

	// reading all cells from excel

	public static int getcellcount(String xlfilepath, String sheetname, int rownum) throws IOException {

		fi = new FileInputStream(xlfilepath);
		wb = WorkbookFactory.create(fi);
		sh = wb.getSheet(sheetname);
		row = sh.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;

	}
	
	//reading data from excell
	
	public static String [] [] getcelldata(String xlfilepath,String sheetname) throws IOException {
		
		
		    fi = new FileInputStream(xlfilepath);
		  
	        wb = WorkbookFactory.create(fi);
	        
	        sh = wb.getSheet(sheetname);
	        
	        int  totalrow = sh.getPhysicalNumberOfRows();
	    
	        int  totalcols = sh.getRow(0).getLastCellNum();
	      
	        String data[][]=new String[totalrow-1][totalcols];
	      
	        for(int i=1;i<totalrow;i++) {
	    	  
	    	   Row row=sh.getRow(i);
	    	    if(row==null)
	    	       {
	    		  
	    	  
	    	   for(int j=0;j<totalcols;j++) {
	    		  
	    		  data[i-1][j]="";
	    	  }
	    	  continue;
	    	  }
	    	  for(int j=0;j<totalcols;j++) {

	    		  Cell col=row.getCell(j);
	    		  
	    		  
	    		  data[i-1][j]=(col!=null)?col.toString():"";
	    	  }
	      }
	        return data;
		
		
	}

}
