package classdemo.betech.nyc;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * 
 */

/**
 * @author Betech
 *
 */
public class KeywordDrivenFramework {

	public static int getRowNumTC, getColNum, getRowNumTS;
	public static String[][] getDataTC, getDataTS, xlData, setDataTS, setDataTC;
	public static String keywordName, inputData1, designStep, inputData2;
	public static WebDriver driver;

	// public static WebDriver driver;
	/**
	 * @param argsc
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String... args) throws IOException, InterruptedException {
		String testStepResult, testCaseResult, keywordFlag;
		// System.getProperty("webdriver.ie.driver",
		// "C:\\BETECHSelenium\\SeleniumJarFile\\IEDriverServer.exe");
//		driver = new FirefoxDriver();
//		driver.manage().window().maximize();

		/**
		 * IEDriver
		 */
		 File file = new File("C:\\BETECHSelenium\\SeleniumJarFile\\IEDriverServer.exe");
		 System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		 driver = new InternetExplorerDriver();
		 driver.manage().window().maximize();

		/**
		 * Chrome Driver
		 */
		// File file = new File("C:\\BETECHSelenium\\SeleniumJarFile\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		// driver = new ChromeDriver();
		// driver.manage().window().maximize();
		// Get File

		ProjectUtils.readExcelTestCase("C:\\BETECHSelenium\\ExcelFile\\ReadData.xls", "TestCaseSheet");
		getRowNumTC = ProjectUtils.getRowNumTestCase;
		getDataTC = ProjectUtils.xlData;
		setDataTC = ProjectUtils.xlData;

		ProjectUtils.readExcelTestStep("C:\\BETECHSelenium\\ExcelFile\\ReadData.xls", "TestStepSheet");
		getRowNumTS = ProjectUtils.getColNumTestStep;
		getDataTS = ProjectUtils.xlData;
		setDataTS = ProjectUtils.xlData;
		/// Loop TC Sheet How many rows in the sheet

		for (int i = 0; i < getRowNumTC; i++) { //Count row number from TestCaseSheet

			testCaseResult = "Pass";
			if (getDataTC[i][1].equalsIgnoreCase("Run")) { // TestCaseSheet Column [i][B] value "Run"


				for (int j = 0; j < getRowNumTS; j++) { //Count row number from TestStepSheet

					if (getDataTC[i][0].equalsIgnoreCase(getDataTS[j][0])) {  // TestCaseSheet Column [i][A] value ==  TestStepSheet Column [j][A] value "Run"
						
						designStep = getDataTS[j][1].trim();  // Get value from TestStepSheet Column [j][B]
						keywordName = getDataTS[j][2].trim(); // Get value from TestStepSheet Column [j][C]
						inputData1 = getDataTS[j][3].trim();  // Get value from TestStepSheet Column [j][D]
						inputData2 = getDataTS[j][4].trim();  // Get value from TestStepSheet Column [j][E]

						testStepResult = "Pass";
						keywordFlag = "Pass";
						
						keywordFlag = executeKeyword();
						try{

						// executeKeywrod method Fail then send Fail to TestStep
						if (keywordFlag.equalsIgnoreCase("Fail")) {
							testStepResult = "Fail";
						}
					
						setDataTS[j][5] = testStepResult;
						if (testStepResult.equals("Fail")) {
							testCaseResult = "Fail";
						} 
						}catch(NoSuchElementException e){
							System.out.println(e.getMessage());
						}
					}
					ProjectUtils.writeTestStepResult("C:\\BETECHSelenium\\ExcelFile\\TestStepResult.xls", setDataTS, "TestStepResult");
				}
			}
			setDataTC[i][2] = testCaseResult;
//				testCaseData[i][2] = testCaseResult;
		}
		ProjectUtils.writeTestCaseResult("C:\\BETECHSelenium\\ExcelFile\\TestCaseResult.xls", setDataTC);
	}

	/**
	 * Create function for Execute keyword
	 * 
	 * @return
	 * 
	 * @throws InterruptedException
	 */
	public static String executeKeyword() throws InterruptedException {
		String methodReturn;
		methodReturn = " ";

		if (keywordName.equalsIgnoreCase("navigateToSite")) {
			try{
				ProjectUtils.navigateToSite(driver, inputData1);
			}catch(Exception e){
				methodReturn = "Fail";
				System.out.println(e.getMessage());
			}
		}
		if (keywordName.equalsIgnoreCase("clickLinkByLinkText")) {
			try{
				ProjectUtils.clickLinkByLinkText(driver, inputData1);
			}catch(Exception e){
				methodReturn = "Fail";
				System.out.println(e.getMessage());
			}
		}
		if (keywordName.equalsIgnoreCase("typeInEditFieldById")) {
			try{
				ProjectUtils.typeInEditFieldById(designStep, driver, inputData1, inputData2);
			}catch(Exception e){
				methodReturn = "Fail";
				System.out.println(e.getMessage());
				
			}
		}
		if (keywordName.equalsIgnoreCase("clickLinkById")) {
			try{
				ProjectUtils.clickLinkById(driver, inputData1);
			}catch(Exception e){
				methodReturn = "Fail";
				System.out.println(e.getMessage());
				
			}
		}
		return methodReturn;
	}

}
