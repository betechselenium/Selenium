/**
 * Excel Read and Write
 */
package junit.betech.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @author Owner
 *
 */
public class ExcelUtils {
	public static int  getRowNumTestStep, getColNumTestStep, getRowNumTestCase, getColNumTestCase;
	public static String[][] xlData;

	/**
	 * Read Test Case from Excel TestCaseSheet
	 * 
	 * @param xlFilePath
	 * @param sheetName
	 * @throws IOException
	 */
	static void readExcelTestCase(String xlFilePath, String sheetName) throws IOException {
		File xlPath = new File(xlFilePath);
		FileInputStream xlStream = new FileInputStream(xlPath);
		@SuppressWarnings("resource")
		HSSFWorkbook wb = new HSSFWorkbook(xlStream);
		HSSFSheet xlSheet = wb.getSheet(sheetName);// Get Sheet Name
		getRowNumTestCase = xlSheet.getLastRowNum() + 1; // Get Row
		getColNumTestCase = xlSheet.getRow(0).getLastCellNum();// / Get Last column
		xlData = new String[getRowNumTestCase][getColNumTestCase]; // Declare the
		for (int i = 0; i < getRowNumTestCase; i++) { // Looping until last row
			HSSFRow row = xlSheet.getRow(i); // Number of row
			for (int j = 0; j < getColNumTestCase; j++) { // Looping until last column
				HSSFCell col = row.getCell(j);// Number of Column
				String xlCellValue = convertToString(col); // ConvertCell value
				xlData[i][j] = xlCellValue;
			}
		}
	}
	
	/**
	 * Read Test Step(Design Step) from Excel TestStepSheet
	 * 
	 * @param xlFilePath
	 * @param sheetName
	 * @throws IOException
	 */
	static void readExcelTestStep(String xlFilePath, String sheetName) throws IOException {
		File xlPath = new File(xlFilePath);
		FileInputStream xlStream = new FileInputStream(xlPath);
		@SuppressWarnings("resource")
		HSSFWorkbook wb = new HSSFWorkbook(xlStream);
		HSSFSheet xlSheet = wb.getSheet(sheetName);// Get Sheet Name
		getRowNumTestStep = xlSheet.getLastRowNum() + 1; // Get Row
		getColNumTestStep = xlSheet.getRow(0).getLastCellNum();// / Get Last
		xlData = new String[getRowNumTestStep][getColNumTestStep]; // Declare the
		for (int k = 0; k < getRowNumTestStep; k++) { // Looping until last row
			HSSFRow row = xlSheet.getRow(k); // Number of row
			for (int m = 0; m < getColNumTestStep; m++) { // Looping until last column
				HSSFCell col = row.getCell(m);// Number of Column
				String xlCellValue = convertToString(col); // ConvertCell value
				xlData[k][m] = xlCellValue;
			}
		}
	}

	/**
	 * Excel cell Convert To String
	 * 
	 * @param cell
	 * @return
	 */
	private static String convertToString(HSSFCell cell) {
		int cellType = cell.getCellType();
		Object returnResult;
		switch (cellType) {
		case HSSFCell.CELL_TYPE_BLANK:
			returnResult = "-";
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			returnResult = cell.getBooleanCellValue();
			break;
		case HSSFCell.CELL_TYPE_ERROR:
			throw new RuntimeException("There is some error");
		case HSSFCell.CELL_TYPE_FORMULA:
			throw new RuntimeException("System doesn't allow formula");
		case HSSFCell.CELL_TYPE_NUMERIC:
			returnResult = cell.getNumericCellValue();
			break;
		case HSSFCell.CELL_TYPE_STRING:
			returnResult = cell.getStringCellValue();
			break;
		default:
			throw new RuntimeException("There no cell type like: " + cellType);
		}
		return returnResult.toString();
	}

	/**
	 * Write Test Step(Design Step) to Excel
	 * 
	 * @param xlFilePath
	 * @param xlData
	 * @throws IOException
	 */
	static void writeTestStepResult(String xlFilePath, String xlData[][], String sheetName) throws IOException {
		File file = new File(xlFilePath); 
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet xlSheet = wb.createSheet(sheetName);// Create Sheet Name
		for (int n = 0; n < getRowNumTestStep; n++) { // Looping until last row
			HSSFRow row = xlSheet.createRow(n); // Number of row
			for (int p = 0; p < getColNumTestStep; p++) { // Looping until last column
				HSSFCell col = row.createCell(p);// Number of Column
				col.setCellType(HSSFCell.CELL_TYPE_STRING);
				col.setCellValue(xlData[n][p]);
			}
			FileOutputStream writeStream = new FileOutputStream(file);
			wb.write(writeStream);
			writeStream.flush();
			wb.close();
		}
	}

	/**
	 * Write Test Case to Excel
	 * 
	 * @param xlFilePath
	 * @param xlData
	 * @throws IOException
	 */
	static void writeTestCaseResult(String xlFilePath, String xlData[][], String sheetName) throws IOException {
		File file = new File(xlFilePath); 
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet xlSheet = wb.createSheet(sheetName);// Create Sheet Name
		for (int x = 0; x < getRowNumTestCase; x++) { // Looping until last row
			HSSFRow row = xlSheet.createRow(x); // Number of row
			for (int y = 0; y <getColNumTestCase ; y++) { // Looping until last column
				HSSFCell col = row.createCell(y);// Number of Column
				col.setCellType(HSSFCell.CELL_TYPE_STRING);
				col.setCellValue(xlData[x][y]);
			}
			FileOutputStream writeStream = new FileOutputStream(file);
			wb.write(writeStream);
			writeStream.flush();
			wb.close();
		}
	}

}