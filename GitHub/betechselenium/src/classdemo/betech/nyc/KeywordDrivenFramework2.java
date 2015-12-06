package classdemo.betech.nyc;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 */

/**
 * @author Betech
 *
 */
public class KeywordDrivenFramework2 {

	public static int getRowNumTC, getColNum, getRowNumTS;
	public static String[][] getDataTC, getDataTS;
	public static String keywordName, inputData1, designStep, inputData2;
	public static WebDriver driver;

	// public static WebDriver driver;
	/**
	 * @param argsc
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String... args) throws IOException, InterruptedException {

//		driver = new FirefoxDriver();
//		driver.manage().window().maximize();
		/**
		 * Chrome Driver
		 */
		 File file = new File("C:\\BETECHSelenium\\SeleniumJarFile\\chromedriver.exe");
		 System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		// Get File

		ProjectUtils.readExcelTestCase("C:\\BETECHSelenium\\ExcelFile\\ReadData.xls", "TestCaseSheet");
		getRowNumTC = ProjectUtils.getRowNumTestCase;
		System.out.println("Get Row Number from Test Case: " + getRowNumTC);
		getDataTC = ProjectUtils.xlData;

		ProjectUtils.readExcelTestStep("C:\\BETECHSelenium\\ExcelFile\\ReadData.xls", "TestStepSheet");
		getRowNumTS = ProjectUtils.getRowNumTestStep;
		System.out.println("Get Row Number from Test Step: " + getRowNumTS);
		getDataTS = ProjectUtils.xlData;

		/// Loop TC Sheet How many rows in the sheet
		for (int i = 0; i < getRowNumTC; i++) {

			// If Execution write = Run

			if (getDataTC[i][1].equalsIgnoreCase("Run")) {

				for (int j = 0; j < getRowNumTS; j++) {

					if (getDataTC[i][0].equalsIgnoreCase(getDataTS[j][0])) {

						designStep = getDataTS[j][1].trim();
						keywordName = getDataTS[j][2].trim();
						inputData1 = getDataTS[j][3].trim();
						inputData2 = getDataTS[j][4].trim();

						// System.out.println("Test case name: " +
						// testCaseData[i][0] + "\tDesign Step: " + testStepData[j][1]
						// + "\tKeyword Name: " + keywordName + "\tFirst Input:
						// " + inputData1);

						executeKeyword();
					}

				}

			}

		}

	}

	/**
	 * Create function for Execute keyword
	 * 
	 * @throws InterruptedException
	 */
	public static void executeKeyword() throws InterruptedException {
		if (keywordName.equalsIgnoreCase("navigateToSite")) {
			ProjectUtils.navigateToSite(driver, inputData1);
		}
		if (keywordName.equalsIgnoreCase("clickLinkByLinkText")) {
			ProjectUtils.clickLinkByLinkText(driver, inputData1);
		}
		if (keywordName.equalsIgnoreCase("typeInEditFieldById")) {
			ProjectUtils.typeInEditFieldById(designStep, driver, inputData1, inputData2);
		}
	}

}
