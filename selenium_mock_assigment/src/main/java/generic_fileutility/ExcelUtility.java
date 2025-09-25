package generic_fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDatafromExcelfile(String name, int row, int cell) throws Throwable {
		FileInputStream fis = new FileInputStream("./testdata/flipkart.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(name).getRow(row).getCell(cell).getStringCellValue();
		wb.close();
		return data;
	}

	public int getDataFromExcelFile(String SheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./testdata/flipkart.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(SheetName).getLastRowNum();
		wb.close();
		return rowCount;

	}

	public void getDataToExcelFile(String SheetName, int rowNum, int celNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./testdata/flipkart.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		 Row row = sh.getRow(rowNum);
		 Cell cell = row.createCell(celNum);
		
		
		cell.setCellType(CellType.STRING);
		cell.setCellValue(data);

		FileOutputStream fos = new FileOutputStream("./testdata/flipkart.xlsx");
		wb.write(fos);
		wb.close();

	}

}
