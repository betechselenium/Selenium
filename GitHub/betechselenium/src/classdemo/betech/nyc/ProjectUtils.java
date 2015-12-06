package classdemo.betech.nyc;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProjectUtils {

	public static int  getRowNumTestStep, getColNumTestStep, getRowNumTestCase, getColNumTestCase;
	public static String[][] xlData;

	//

	public static void typeInEditFieldByIdStatic(String stepName, WebDriver driver, String fieldId, int rowNum, int colNum) {
		driver.findElement(By.id(fieldId)).sendKeys(xlData[rowNum][colNum]);
	}

	public void typeInEditFieldByIdWithoutStatic(String stepName, WebDriver driver, String fieldId, int rowNum, int colNum) {
		driver.findElement(By.id(fieldId)).sendKeys(xlData[rowNum][colNum]);
	}

	public static void selectById(WebDriver driver, String data, String selectItem) {
		new Select(driver.findElement(By.id(data))).selectByVisibleText(selectItem);
	}

	public static void selectByXpath(WebDriver driver, String data, String selectItem) {
		driver.findElement(By.xpath(data)).sendKeys(selectItem);
	}

	public static void selectById(WebDriver driver, String data, int rowNum, int colNum) {
		new Select(driver.findElement(By.id(data))).selectByVisibleText(xlData[rowNum][colNum]);
	}

/**
 * 	Read Test Case from Excel TestCaseSheet
 * @param xlFilePath
 * @param sheetName
 * @throws IOException
 */
	static void readExcelTestCase(String xlFilePath, String sheetName) throws IOException {
		File xlPath = new File(xlFilePath);
		FileInputStream xlStream = new FileInputStream(xlPath);
		@SuppressWarnings("resource")
		HSSFWorkbook wb = new HSSFWorkbook(xlStream);
		HSSFSheet xlSheet = wb.getSheet(sheetName);// get Name
		getRowNumTestCase = xlSheet.getLastRowNum() + 1; // Get Row
		getColNumTestCase = xlSheet.getRow(0).getLastCellNum();// / Get Last
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
 * @param xlFilePath
 * @param sheetName
 * @throws IOException
 */
	static void readExcelTestStep(String xlFilePath, String sheetName) throws IOException {
		File xlPath = new File(xlFilePath);
		FileInputStream xlStream = new FileInputStream(xlPath);
		@SuppressWarnings("resource")
		HSSFWorkbook wb = new HSSFWorkbook(xlStream);
		HSSFSheet xlSheet = wb.getSheet(sheetName);// get Name
		getRowNumTestStep = xlSheet.getLastRowNum() + 1; // Get Row
		getColNumTestStep = xlSheet.getRow(0).getLastCellNum();// / Get Last
		xlData = new String[getRowNumTestStep][getColNumTestStep]; // Declare the
		for (int i = 0; i < getRowNumTestStep; i++) { // Looping until last row
			HSSFRow row = xlSheet.getRow(i); // Number of row
			for (int j = 0; j < getColNumTestStep; j++) { // Looping until last column
				HSSFCell col = row.getCell(j);// Number of Column
				String xlCellValue = convertToString(col); // ConvertCell value
				xlData[i][j] = xlCellValue;
			}
		}
	}

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

	public static String navigateToSite(WebDriver driver, String URL) {
		try {
			driver.navigate().to(URL);
			return "Pass";
		} catch (NoSuchElementException e) {
			e.getMessage();
			return "Fail";
		}
	}


	public static String clickLinkByLinkText(WebDriver driver, String linkTextName) {
		driver.findElement(By.linkText(linkTextName)).click();
		return linkTextName;
	}

	public static String typeInEditFieldById(String designStep, WebDriver driver, String fieldIdValue, String enterValue) {
		String typeInEditFieldById = "Pass";
		try {
			driver.findElement(By.id(fieldIdValue)).sendKeys(enterValue);
		} catch (NoSuchElementException e) {
			typeInEditFieldById =  "Fail";
			System.out.println(e.getMessage());
		}
		return typeInEditFieldById;
	}

	public static String clickLinkById(WebDriver driver, String linkId) {
		String clickLinkById ="Pass";
		try {
			driver.findElement(By.id(linkId)).click();
		} catch (NoSuchElementException e) {
			clickLinkById = "Fail";
			System.out.println(e.getMessage());
		}
		return clickLinkById;
	}
	
	static void writeTestStepResult(String xlFilePath, String xlData[][], String sheetName) throws IOException {
		File file = new File(xlFilePath); 
		@SuppressWarnings("resource")
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet xlSheet = wb.createSheet(sheetName);// Create Sheet Name
		for (int i = 0; i < getRowNumTestStep; i++) { // Looping until last row
//			System.out.println("WriteTestStep Row: " + getRowNumTestStep);
			HSSFRow row = xlSheet.createRow(i); // Number of row
			for (int j = 0; j < getColNumTestStep; j++) { // Looping until last column
//				System.out.println("WriteTestStep Col: " + getColNumTestStep);
				HSSFCell col = row.createCell(j);// Number of Column
				col.setCellType(HSSFCell.CELL_TYPE_STRING);
				col.setCellValue(xlData[i][j]);
			}
			FileOutputStream writeStream = new FileOutputStream(file);
			wb.write(writeStream);
			writeStream.flush();
		}
	}
	
	static void writeTestCaseResult(String xlFilePath, String xlData[][]) throws IOException {
		File file = new File(xlFilePath); 
		@SuppressWarnings("resource")
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet xlSheet = wb.createSheet("TestCaseResult");// Create Sheet Name
		for (int i = 0; i < getRowNumTestCase; i++) { // Looping until last row
//			System.out.println("WriteTestCase Row: " + getRowNumTestCase);
			
			HSSFRow row = xlSheet.createRow(i); // Number of row
			for (int j = 0; j <getColNumTestCase ; j++) { // Looping until last column
//				System.out.println("WriteTestCase Row: " + getColNumTestCase);
				HSSFCell col = row.createCell(j);// Number of Column
				col.setCellType(HSSFCell.CELL_TYPE_STRING);
				col.setCellValue(xlData[i][j]);
			}
			FileOutputStream writeStream = new FileOutputStream(file);
			wb.write(writeStream);
			writeStream.flush();
		}
	}

}
