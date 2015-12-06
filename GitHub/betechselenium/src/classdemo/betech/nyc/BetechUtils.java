package classdemo.betech.nyc;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;

/**
 * 
 */

/**
 * @author Betech
 *
 */
public class BetechUtils {

	public static int getRowNum, getColNum;
	public static String[][] xlData;

	/**
	 * 
	 * @param xlFilePath
	 * @param sheetNumber
	 * @throws IOException
	 */
	static void readExcelFile(String xlFilePath, int sheetNumber)
			throws IOException {

		File xlPath = new File(xlFilePath);
		// Java Stream the xl file
		FileInputStream xlStream = new FileInputStream(xlPath);
		// Workbook
		HSSFWorkbook wb = new HSSFWorkbook(xlStream);
		HSSFSheet xlSheet = wb.getSheetAt(sheetNumber);// get Sheet2
		getRowNum = xlSheet.getLastRowNum() + 1; // Get Row
		getColNum = xlSheet.getRow(0).getLastCellNum();// / Get Last
		xlData = new String[getRowNum][getColNum]; // Declare the
		for (int i = 0; i < getRowNum; i++) { // Looping until last row
			HSSFRow row = xlSheet.getRow(i); // Number of row
			for (int j = 0; j < getColNum; j++) { // Looping until last column
				HSSFCell col = row.getCell(j);// Number of Column
				String xlCellValue = convertToString(col); // ConvertCell value
				xlData[i][j] = xlCellValue;
			}
		}
		wb.close();
	}

	/**
	 * This method for convert to string(Line number 75)
	 * @param brklyn
	 * @return
	 */
	private static String convertToString(HSSFCell brklyn) {
		int cellType = brklyn.getCellType();
		Object returnResult;
		switch (cellType) {
		case HSSFCell.CELL_TYPE_BLANK:
			returnResult = "-";
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			returnResult = brklyn.getBooleanCellValue();
			break;
		case HSSFCell.CELL_TYPE_ERROR:
			throw new RuntimeException("There is some erro");
		case HSSFCell.CELL_TYPE_FORMULA:
			throw new RuntimeException("System doesn't allow formula");
		case HSSFCell.CELL_TYPE_NUMERIC:
			returnResult = brklyn.getNumericCellValue();
			break;
		case HSSFCell.CELL_TYPE_STRING:
			returnResult = brklyn.getStringCellValue();
			break;
		default:
			throw new RuntimeException("There no cell type like: " + cellType);
		}
		return returnResult.toString();
	}
	
	public static void navigateToSite(WebDriver driver, String URL){
		driver.navigate().to(URL);
	}
}
