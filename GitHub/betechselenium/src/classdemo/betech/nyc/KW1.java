package classdemo.betech.nyc;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 */

/**
 * @author Betech
 *
 */
public class KW1 {

	public static int getRowNum, getColNum;
	public static String[][] getData;
//	public static WebDriver driver;
	/**
	 * @param argsc
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String... args) throws IOException, InterruptedException {
		// Get File

		ProjectUtils.readExcelTestCase("C:\\BETECHSelenium\\ExcelFile\\ReadData.xls", "Sheet1");
		
		getRowNum = ProjectUtils.getRowNumTestCase;
//		System.out.println(getRowNum);
		
    getData = ProjectUtils.xlData;
//		System.out.println(getData[1][1]);


		for (int i = 1; i < getRowNum; i++) {
			
//			WebDriver driver = new FirefoxDriver(); // Create FF Driver
//			driver.manage().window().maximize(); // Maximize the window
//			driver.navigate().to("https://login.yahoo.com"); // Open Yahoo mail page
//			// direct
//			Thread.sleep(3000);
//			driver.findElement(By.id("login-signup")).click();
//			
////			ProjectUtils abc = new ProjectUtils();
//					
//			ProjectUtils.typeInEditFieldByIdStatic("Enter first name", driver, "first-name", i, 0);
//			ProjectUtils.typeInEditFieldByIdStatic("Enter last name", driver, "last-name", i, 1);
//			ProjectUtils.typeInEditFieldByIdStatic("Enter username", driver, "user-name", i, 2);
//			ProjectUtils.typeInEditFieldByIdStatic("Enter password", driver, "password", i, 3);
//			ProjectUtils.typeInEditFieldByIdStatic("Enter mobile number", driver, "mobile", i, 4);
//			
//			
//			ProjectUtils.selectById(driver, "month", getData[i][5]);
//			ProjectUtils.selectById(driver, "day", i, 6);
//			ProjectUtils.selectById(driver, "year", getData[i][7]);
//
//			driver.findElement(By.id("female")).click();
//
//			ProjectUtils.typeInEditFieldByIdStatic("Enter mobile reference", driver, "mobile-rec", i, 9);
//			ProjectUtils.typeInEditFieldByIdStatic("Enter relationship", driver, "relationship", i, 10);
//			driver.navigate().refresh();
//			Thread.sleep(3000);
//			driver.close();
			
			WebDriver driver = new FirefoxDriver(); // Create FF Driver
			driver.manage().window().maximize(); // Maximize the window
			driver.navigate().to("https://accounts.google.com/"); // Open Yahoo mail page
			// direct
			Thread.sleep(3000);
			driver.findElement(By.linkText("Create account")).click();
//			ProjectUtils abc = new ProjectUtils();
					
			ProjectUtils.typeInEditFieldByIdStatic("Enter first name", driver, "FirstName", i, 0);
			ProjectUtils.typeInEditFieldByIdStatic("Enter last name", driver, "LastName", i, 1);
			ProjectUtils.typeInEditFieldByIdStatic("Enter username", driver, "GmailAddress", i, 2);
			ProjectUtils.typeInEditFieldByIdStatic("Enter password", driver, "Passwd", i, 3);
			ProjectUtils.typeInEditFieldByIdStatic("Enter password", driver, "PasswdAgain", i, 3);
			ProjectUtils.typeInEditFieldByIdStatic("Enter mobile number", driver, "RecoveryPhoneNumber", i, 4);
			
			ProjectUtils.typeInEditFieldByIdStatic("Enter Date number", driver, "BirthDay", i, 6);
			ProjectUtils.typeInEditFieldByIdStatic("Enter year number", driver, "BirthYear", i, 7);
			
//			ProjectUtils.selectById(driver, ":0", getData[i][5]);
			try {
				ProjectUtils.selectByXpath(driver, "//div[contains(text()='" + getData[i][5]+"')]", getData[i][5] );
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			finally {
				System.out.println("Finally close the dirver");
				driver.close();
			}
			

//			driver.findElement(By.id("female")).click();
//
//			ProjectUtils.typeInEditFieldByIdStatic("Enter mobile reference", driver, "mobile-rec", i, 9);
//			ProjectUtils.typeInEditFieldByIdStatic("Enter relationship", driver, "relationship", i, 10);
//			driver.navigate().refresh();
//			Thread.sleep(3000);
//			driver.close();
			
		}

	}



}
