package classdemo.betech.nyc;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
/**
 * @author Betech
 *
 */
public class ExcelReadAndWrite2 {

	public static int getRowNum, getColNum;
	public static String[][] xlData;

	public static void main(String[] args) throws IOException {
		readExcelFile("C:\\BETECHSelenium\\ExcelFile\\ReadData.xls", 0);

		WebDriver driver = new FirefoxDriver(); // Create FF Driver
		driver.manage().window().maximize(); // Maximize the window
		driver.navigate().to("https://login.yahoo.com"); // Open Yahoo mail page
		driver.findElement(By.id("login-signup")).click();
		for (int i = 1; i < getRowNum; i++) {
			
			typeInEditFieldById("Enter first name", driver, "first-name", i, 0);
			typeInEditFieldById("Enter last name", driver, "last-name", i, 1);
			typeInEditFieldById("Enter username", driver, "user-name", i, 2);
			typeInEditFieldById("Enter password", driver, "password", i, 3);
			typeInEditFieldById("Enter mobile number", driver, "mobile", i, 4);
			new Select(driver.findElement(By.id("month"))).selectByVisibleText(xlData[i][5]);
			new Select(driver.findElement(By.id("day"))).selectByVisibleText(xlData[i][6]);
			new Select(driver.findElement(By.id("year"))).selectByVisibleText(xlData[i][7]);
			driver.findElement(By.id("female")).click();
			typeInEditFieldById("Enter mobile reference", driver, "mobile-rec", i, 9);
			typeInEditFieldById("Enter relationship", driver, "relationship", i, 10);
			driver.findElement(By.xpath("//body")).sendKeys(Keys.F5);
		}
		driver.close();

	}

	/**
	 * 
	 * @param stepName
	 * @param driver
	 * @param fieldId
	 * @param rowNum
	 * @param colNum
	 */
	private static void typeInEditFieldById(String stepName, WebDriver driver, String fieldId, int rowNum, int colNum) {
		driver.findElement(By.id(fieldId)).sendKeys(xlData[rowNum][colNum]);
	}

	/**
	 * 
	 * @param xlFilePath
	 * @param sheetNumber
	 * @throws IOException
	 */
	private static void readExcelFile(String xlFilePath, int sheetNumber) throws IOException {
		File xlPath = new File(xlFilePath);
		FileInputStream xlStream = new FileInputStream(xlPath);
		HSSFWorkbook wb = new HSSFWorkbook(xlStream);
		HSSFSheet xlSheet = wb.getSheetAt(sheetNumber);// get Sheet2
		getRowNum = xlSheet.getLastRowNum() + 1; // Get Row
		getColNum = xlSheet.getRow(0).getLastCellNum();/// Get Last
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
	 * 
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

}
