package classdemo.betech.nyc;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 */

/**
 * @author Betech
 *
 */
public class CopyOfKeywordDrivenFramework {

	public static int getRowNumTC, getColNum, getRowNumTS;
	public static String[][] getDataTC, getDataTS, testStepResultData, testCaseResultData;
	public static String keywordName, inputData1, designStep, inputData2, executionFlag, testStepResult, testCaseResult;
	public static WebDriver driver;

	// public static WebDriver driver;
	/**
	 * @param argsc
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String... args) throws IOException, InterruptedException {

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		// Get File

		ProjectUtils.readExcelTestCase("C:\\BETECHSelenium\\ExcelFile\\ReadData.xls", "TestCaseSheet");
		getRowNumTC = ProjectUtils.getRowNumTestCase;
		getDataTC = ProjectUtils.xlData;

		ProjectUtils.readExcelTestStep("C:\\BETECHSelenium\\ExcelFile\\ReadData.xls", "TestStepSheet");
		getRowNumTS = ProjectUtils.getRowNumTestStep;
		getDataTS = ProjectUtils.xlData;
		
//		String testCaseResult = "C:\\BETECHSelenium\\ExcelFile\\Result.xls", "TestStepSheet";
//		getTestStepRowCount = ProjectUtils.getRowNum;
//		testStepData = ProjectUtils.xlData;

		/// Loop TC Sheet How many rows in the sheet
		for (int i = 0; i < getRowNumTC; i++) {
			testCaseResult = "Pass";
			if (getDataTC[i][1].equalsIgnoreCase("Run")) {
System.out.println(getDataTC[i][1]);
				for (int j = 0; j < getRowNumTS; j++) {
					testStepResult = "Pass";
					if (getDataTC[i][0].equalsIgnoreCase(getDataTS[j][0])) {
						System.out.println(getDataTC[i][0]);
						System.out.println(getDataTS[j][0]);

						designStep  = getDataTS[j][1].trim();
						keywordName = getDataTS[j][2].trim();
						inputData1  = getDataTS[j][3].trim();
						inputData2  = getDataTS[j][4].trim();

						executionFlag = executeKeyword();
						if (executionFlag.equalsIgnoreCase("Fail")) {
							testStepResult = "Fail";
						}
						testStepResultData[j][5] = testStepResult;

						if (testStepResult.equalsIgnoreCase("Fail")) {
							testCaseResult = "Fail";
						}
					}

				}
				
				testCaseResultData[i][2] = testCaseResult;

			}

		}
//		writeTestCaseResult(testCaseResult, testCaseResultData, "TestCaseResult");
	}

	/**
	 * Create function for Execute keyword
	 * 
	 * @throws InterruptedException
	 */
	public static String executeKeyword() throws InterruptedException {
        String keywordReturn;
        keywordReturn = "Pass";
		
		if (keywordName.equalsIgnoreCase("navigateToSite")) {
			keywordReturn = ProjectUtils.navigateToSite(driver, inputData1);
		}
		if (keywordName.equalsIgnoreCase("clickLinkByLinkText")) {
			keywordReturn = ProjectUtils.clickLinkByLinkText(driver, inputData1);
		}
		if (keywordName.equalsIgnoreCase("typeInEditFieldById")) {
			keywordReturn =  ProjectUtils.typeInEditFieldById(designStep, driver, inputData1, inputData2);
		}
		return keywordReturn;
	}
	
//    public static void writeTestCaseResult(String excel_Path, String[][] xldata, String resultSheet) throws Exception {
//        //print("Inside XL Write");
//        File file = new File(excel_Path);
//        HSSFWorkbook workBook = new HSSFWorkbook();
//        HSSFSheet xl_sheet = workBook.createSheet(resultSheet);
//        for (int xlRow = 0; xlRow < testCaseRows; xlRow++) {
//            HSSFRow row = xl_sheet.createRow(xlRow);
//            for (int xlCol = 0; xlCol < testCaseCols; xlCol++) {
//                HSSFCell cell = row.createCell(xlCol);
//                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
//                cell.setCellValue(xldata[xl_Row][xlCol]);
//            }
//            FileOutputStream file_Out = new FileOutputStream(file); 
//            workBook.write(file_Out);
//            file_Out.flush();
//        }
//    }

	public static String VerifyText(WebDriver browser, String fxPath, String expectedContent) {
        try {
            String actulContent = browser.findElement(By.xpath(fxPath)).getText();
            if (actulContent.equals(expectedContent)) {
                return "Pass";
            } else {
                return "Fail";
            }
        } catch (NoSuchElementException e) {
            return "Fail";
        }
    }
	
}
