/**
 * 
 */
package selenium.keyword.driven.betech.nyc;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author Owner
 *
 */
public class Execution {

	public static int getTestCaseRowCount, getColNum, getTestStepRowCount;
	public static String[][] testCaseData, testStepData, xlData, setDataTS, setDataTC;
	public static String browserName, keywordName, inputData1, designStep, inputData2;
	public static WebDriver driver;

	/**
	 * @param argsc
	 * @throws Exception 
	 */
	public static void main(String... args) throws Exception {

		long testStartTime = (System.currentTimeMillis() / 1000);
		String testStepResult = null, testCaseResult = null, keywordFlag = null;

		/**
		 * Read Test Case Sheet from Excel by using readExcelTestCase method
		 * from ExcelUtils.java file
		 */
		ExcelUtils.readExcelTestCase("C:\\BETECHSelenium\\ExcelFile\\TestCaseSuite.xls", "TestCaseSheet");
		getTestCaseRowCount = ExcelUtils.getRowNumTestCase;
		testCaseData = ExcelUtils.xlData;

		/**
		 * Read Test Step Sheet from Excel by using readExcelTestStep method
		 * from ExcelUtils.java file
		 */
		ExcelUtils.readExcelTestStep("C:\\BETECHSelenium\\ExcelFile\\TestCaseSuite.xls", "TestStepSheet");
		getTestStepRowCount = ExcelUtils.getRowNumTestStep;
		testStepData = ExcelUtils.xlData;
		
		/**
		 * i represent for TestCaseSheet row
		 */
		for (int i = 1; i < getTestCaseRowCount; i++) { //Loop until count row number from TestCaseSheet 
			if (testCaseData[i][1].equalsIgnoreCase("Run")) { // TestCaseSheet Column [i][B] value "Run" 
				
				/**
				 * j represent for TestStepSheet row
				 */
				for (int j = 1; j < getTestStepRowCount; j++) { //Loop until count row number from TestStepSheet 
					if (testCaseData[i][0].equalsIgnoreCase(testStepData[j][0])) {  // TestCaseSheet Column [i][A] value ==  TestStepSheet Column [j][A] value "Run"
						browserName = testCaseData[i][2];   // Get value from Test Case Sheet cell [j][C]
						
						designStep = testStepData[j][1].trim();   // Get value from TestStepSheet cell [j][B]
						keywordName = testStepData[j][2].trim();   // Get value from TestStepSheet cell [j][C]
						inputData1 = testStepData[j][3].trim();   // Get value from TestStepSheet cell [j][D]
						inputData2 = testStepData[j][4].trim();  // Get value from TestStepSheet Column [j][E]

						keywordFlag = executeKeyword();
						if (keywordFlag.equalsIgnoreCase("Fail")) {
							testStepResult = "Fail";
						} else if (keywordFlag.equalsIgnoreCase("Pass")) {
							testStepResult = "Pass";
						}
						testStepData[j][5] = testStepResult;

						if (testStepResult.equals("Fail")) {
							testCaseResult = "Fail";
						}else {
							testCaseResult = "Pass";
						}
					}
				}
				testCaseData[i][3] = testCaseResult;
			}
		}
		driver.quit();
		ExcelUtils.writeTestStepResult("C:\\BETECHSelenium\\ExcelFile\\TestStepResult.xls",testStepData, "TestStepResultSheet");
		ExcelUtils.writeTestCaseResult("C:\\BETECHSelenium\\ExcelFile\\TestCaseResult.xls",testCaseData, "TestCaseResultSheet");
		System.out.println("-----------------------------------Test Run Complete-----------------------------------");
		long testFinishTime = (System.currentTimeMillis() / 1000);
		System.out.println("Total execution time: " + ((testFinishTime - testStartTime)) + " Seconds");
	}

	/**
	 * Create function for Execute keyword
	 * 
	 * @return
	 * @throws Exception 
	 */
	public static String executeKeyword() throws Exception {
		String keywordReturn;
		keywordReturn = null;
		
		if (keywordName.equalsIgnoreCase("navigateToSite")) {
			if (browserName.equalsIgnoreCase("Chrome")) {
				File chromPath = new File("C:\\BETECHSelenium\\SeleniumJarFile\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", chromPath.getAbsolutePath());
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("IE") || browserName.equalsIgnoreCase("Internet Explorer")) {
				File iePath = new File("C:\\BETECHSelenium\\SeleniumJarFile\\IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", iePath.getAbsolutePath());
				driver = new InternetExplorerDriver();
			} else if (browserName.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			}
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				System.out.println(designStep);
				keywordReturn = KeywordUtils.navigateToSite(driver, inputData1);
		}
		if (keywordName.equalsIgnoreCase("buttonClickByClassName")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.buttonClickByClassName(driver, inputData1);	
		}
		if (keywordName.equalsIgnoreCase("buttonClickByCssSelector")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.buttonClickByCssSelector(driver, inputData1);	
		}
		if (keywordName.equalsIgnoreCase("buttonClickById")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.buttonClickById(driver, inputData1);	
		}
		if (keywordName.equalsIgnoreCase("buttonClickByLinkText")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.buttonClickByLinkText(driver, inputData1);	
		}
		if (keywordName.equalsIgnoreCase("buttonClickByXpath")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.buttonClickByXpath(driver, inputData1);	
		}
		if (keywordName.equalsIgnoreCase("buttonClickByName")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.buttonClickByName(driver, inputData1);	
		}
		if (keywordName.equalsIgnoreCase("linkClickByClassName")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.linkClickByClassName(driver, inputData1);
		}
		if (keywordName.equalsIgnoreCase("linkClickByCssSelector")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.linkClickByCssSelector(driver, inputData1);
		}
		if (keywordName.equalsIgnoreCase("linkClickById")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.linkClickById(driver, inputData1);
		}
		if (keywordName.equalsIgnoreCase("linkClickByLinkText")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.linkClickByLinkText(driver, inputData1);
		}
		if (keywordName.equalsIgnoreCase("linkClickByName")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.linkClickByName(driver, inputData1);
		}
		if (keywordName.equalsIgnoreCase("linkClickByPartialLinkText")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.linkClickByPartialLinkText(driver, inputData1);
		}
		if (keywordName.equalsIgnoreCase("linkClickByXpath")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.linkClickByXpath(driver, inputData1);
		}
		if (keywordName.equalsIgnoreCase("linkClickByLinkId")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.linkClickByLinkId(driver, inputData1);
		}
		if (keywordName.equalsIgnoreCase("selectByClassName")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.selectByClassName(driver, inputData1, inputData2);
		}
		if (keywordName.equalsIgnoreCase("selectByCssSelector")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.selectByCssSelector(driver, inputData1, inputData2);
		}
		if (keywordName.equalsIgnoreCase("selectById")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.selectById(driver, inputData1, inputData2);
		}
		if (keywordName.equalsIgnoreCase("selectByName")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.selectByName(driver, inputData1, inputData2);
		}
		if (keywordName.equalsIgnoreCase("selectByXpath")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.selectByXpath(driver, inputData1, inputData2);
		}
		if (keywordName.equalsIgnoreCase("typeInEditFieldByClassName")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.typeInEditFieldByClassName(driver, inputData1, inputData2);
		}
		if (keywordName.equalsIgnoreCase("typeInEditFieldById")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.typeInEditFieldById(driver, inputData1, inputData2);
		}
		if (keywordName.equalsIgnoreCase("typeInEditFieldByName")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.typeInEditFieldByName(driver, inputData1, inputData2);
		}
		if (keywordName.equalsIgnoreCase("typeInEditFieldByXpath")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.typeInEditFieldByXpath(driver, inputData1, inputData2);
		}
		if (keywordName.equalsIgnoreCase("verifyTextById")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.verifyTextById(driver, inputData1, inputData2);
		}
		if (keywordName.equalsIgnoreCase("verifyTextByXpath")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.verifyTextByXpath(driver, inputData1, inputData2);
		}
		if (keywordName.equalsIgnoreCase("mouseOverClickById")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.mouseOverClickById(driver, inputData1, inputData2);
		}
		if (keywordName.equalsIgnoreCase("mouseOverClickByXpath")) {
			System.out.println(designStep);
			keywordReturn = KeywordUtils.mouseOverClickByXpath(driver, inputData1, inputData2);
		}
		return keywordReturn;
	}

}
