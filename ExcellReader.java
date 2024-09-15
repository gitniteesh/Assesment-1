package util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellReader {

	String FilePath;
	String FileName;
	public ExcellReader(String filePath, String fileName) {
		super();
		FilePath = filePath;
		FileName = fileName;
	}
	
	
	public int rowCount()
	{
		int row =0;
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(FilePath);
			XSSFSheet worksheet = workbook.getSheet(FileName);
			row = worksheet.getPhysicalNumberOfRows();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	
	
	public int colCount()
	{
		int col =0;
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(FilePath);
			XSSFSheet worksheet = workbook.getSheet(FileName);
			col = worksheet.getRow(0).getPhysicalNumberOfCells();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return col;
	}
	
	
	public String getdata(int row,int col)
	{
		String data = null;
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(FilePath);
			XSSFSheet worksheet = workbook.getSheet(FileName);
			data = worksheet.getRow(row).getCell(col).getStringCellValue();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
}
