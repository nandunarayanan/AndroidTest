/*****************************************************************************
 * File Name 	: ExcelUtils.java
 * 
 * Version		: 0.1
 * 
 * Author		: Bastin
 * 
 * Type			:(Test Scripts/Libraries) Libraries
 * 
 * Description	: This .java file is written for the Excel Utility file.
 * 				  This file will be reused at different places.
 * 
 * Test cases	: NA
 *****************************************************************************/
package utility;
/*Inclusion of required libraries*/
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;

//import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*Below class contains the utility class for different excel funtions*/
public class ExcelUtils 
{
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	//private static XSSFRow Row;
	/*****************************************************************************
	 * Function/Test Name  : setExcelFile
	 * 
	 * Test ID	  		   : NA
	 * 
	 * Type		           :NA
	 * 
	 * Group	           :NA
	 * 
	 * Description         : This function helps in setting the excel file
	 *****************************************************************************/	
	public static void setExcelFile(String Path,String SheetName) throws Exception 
	{
		try 
		{
		// Open the Excel file
		FileInputStream ExcelFile = new FileInputStream(Path);

		// Access the required test data sheet
		ExcelWBook = new XSSFWorkbook(ExcelFile);

		ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} 
		catch (Exception e)
		{
			System.out.println("Exception: " + e);
			throw (e);
		}
	}
	

	/*****************************************************************************
	 * Function/Test Name  : getTableArray
	 * 
	 * Test ID	  		   : NA
	 * 
	 * Type		           :NA
	 * 
	 * Group	           :NA
	 * 
	 * Description         : This function helps returning the whole content
	 * 						 as a table
	 *****************************************************************************/
	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception 
	{
		String[][] tabArray = null;
		
		try
		{
			FileInputStream ExcelFile = new FileInputStream(FilePath);
			 
		    // Access the required test data sheet
		 
		    ExcelWBook = new XSSFWorkbook(ExcelFile);
		 
		    ExcelWSheet = ExcelWBook.getSheet(SheetName);
		 
		    int startRow = 1;
		 
		    int startCol = 1;
		 
		    int ci,cj;
		 
		    int totalRows = getRowCountInSheet();
		    		 
		    // you can write a function as well to get Column count
		 
		    int totalCols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
		    
		    		 
		    tabArray=new String[totalRows][totalCols];
		 
		    ci=0;
		 
		    for (int i=startRow;i<=totalRows;i++, ci++) 
		    {        
		      
			    cj=0;
			 
			    for (int j=startCol;j<=totalCols;j++, cj++)
			    {			 
				    tabArray[ci][cj]=String.valueOf(getCellData(i,j));				 
				    System.out.println(tabArray[ci][cj]); 
			    }
		    }
		}
		
		catch (FileNotFoundException e)
		{
			 
			System.out.println("Could not read the Excel sheet");			 
			e.printStackTrace();
		 
		}
		catch (IOException e)
		{			 
			System.out.println("Could not read the Excel sheet");			 
			e.printStackTrace();		 
		}
		return(tabArray);
	}

	/*****************************************************************************
	 * Function/Test Name  : getCellData
	 * 
	 * Test ID	  		   : NA
	 * 
	 * Type		           :NA
	 * 
	 * Group	           :NA
	 * 
	 * Description         : This function helps in getting the cell data
	 *****************************************************************************/
	public static String getCellData(int RowNum, int ColNum) throws Exception 
	{
		try
		{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			Cell.setCellType(CellType.STRING);
			CellType type = Cell.getCellType();			
			 
			 if  (type == CellType.BLANK) 
			 {			 
				 return "";			 
			 }
			 else
			 {			                
				 String CellData = Cell.getStringCellValue();				 
				 return CellData;			 
			 }
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());			 
			e.printStackTrace();	
		}
		return null;
	}
	/*****************************************************************************
	 * Function/Test Name  : getTestCaseName
	 * 
	 * Test ID	  		   : NA
	 * 
	 * Type		           :NA
	 * 
	 * Group	           :NA
	 * 
	 * Description         : This function helps This function helps in 
	 * 						 finding test case name in the row
	 *****************************************************************************/
	public static String getTestCaseName(String TC_Name) 
	{
		try
		{
			
		}
		catch(Exception e)
		{
			System.out.println("Error Message:-"+e.getMessage());
		}
		return null;
	}

	/*****************************************************************************
	 * Function/Test Name  : getRowContains
	 * 
	 * Test ID	  		   : NA
	 * 
	 * Type		           :NA
	 * 
	 * Group	           :NA
	 * 
	 * Description         : This function helps in finding row with pattern
	 *****************************************************************************/
	public static int getRowContains(String TC_Name, int row_no) 
	{
		try
		{
			
		}
		catch(Exception e)
		{
			System.out.println("Error Message:-"+e.getMessage());
		}
		return 0;
	}

	/*****************************************************************************
	 * Function/Test Name  : getRowCountInSheet
	 * 
	 * Test ID	  		   : NA
	 * 
	 * Type		           :NA
	 * 
	 * Group	           :NA
	 * 
	 * Description         : This function helps in counting the valid row no
	 *****************************************************************************/
	public static int getRowCountInSheet()
	{
	    int rowcount = ExcelWSheet.getLastRowNum()-ExcelWSheet.getFirstRowNum();
	    return rowcount;
	 }

	/*****************************************************************************
	 * Function/Test Name  : setCellValue
	 * 
	 * Test ID	  		   : NA
	 * 
	 * Type		           :NA
	 * 
	 * Group	           :NA
	 * 
	 * Description         : This function helps in setting value in the cell
	 *****************************************************************************/
	 public void setCellValue(int rowNum,int cellNum,String cellValue,String excelFilePath) throws IOException 
	 {		 
			//creating a new cell in row and setting value to it      
			 ExcelWSheet.getRow(rowNum).createCell(cellNum).setCellValue(cellValue);
			    
			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			ExcelWBook.write(outputStream);		
	  }	
}

