package classdemo.betech.nyc;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Betech
 *
 */
public class KeywordDriven {

	public static String keywordName, inputData1, inputData2, inputData3;
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {


		BetechUtils.readExcelFile("C:\\Development\\ReadData.xls", 0);
		int rowCountTC = BetechUtils.getRowNum;
		String testCaseData[][] = BetechUtils.xlData;
		System.out.println(testCaseData[1][1]);

		BetechUtils.readExcelFile("C:\\Development\\ReadData.xls", 1);
		int rowCountTS = BetechUtils.getColNum;
		String testStepData[][] = BetechUtils.xlData;
		System.out.println(testStepData[1][1]);
		
		driver = new FirefoxDriver();
		
		for (int i = 0; i < rowCountTC; i++) {
			if (testCaseData[1][1].equalsIgnoreCase("Y")) {
				for (int j = 1; j < rowCountTS; j++) {
					if (testCaseData[1][0].equalsIgnoreCase(testStepData[1][0])) {
						keywordName = testStepData[j][2].trim();
						System.out.println(keywordName);
						inputData1 = testStepData[j][3].trim();
						System.out.println(inputData1);
						try {
							executeKeyword();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	public static void executeKeyword() throws Exception {
		if (keywordName.equals("navigateToSite")) {
			BetechUtils.navigateToSite(driver, inputData1);
		}
	}
}
