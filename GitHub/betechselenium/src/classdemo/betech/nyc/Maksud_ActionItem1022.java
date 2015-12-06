package classdemo.betech.nyc;
import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Maksud_ActionItem1022 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver(); // Create FF Driver
		driver.manage().window().maximize(); // Maximize the window
		/*driver.navigate().to("https://www.yahoo.com"); // Open Browser with
														// Yahoo.com
		//driver.findElement(By.linkText("Mail")).click(); // Click on "Mail"
*/		
		driver.navigate().to("https://login.yahoo.com"); // Open Yahoo mail page direct 

		List<WebElement> allLinks = driver.findElements(By.tagName("a")); // get
																			// the
																			// list
																			// of
																			// links
																			// by
																			// tagname

		int countLink = allLinks.size(); // Count all links
		System.out.println("Total Links are :" + countLink);

		for (int i = 0; i < countLink; i++) {// Looping for new Sign up link

			// if there is "Sign up for a new account" link
			if (allLinks.get(i).getText().trim().equalsIgnoreCase("Sign up for a new account")) {
				// then click on "Sign up for a new account" link
				driver.findElement(By.id("login-signup")).click();
				break; // if condition match then exit from loop
			}

		}
		Thread.sleep(10000); // wait 10 second before enter data into edit field

		driver.findElement(By.id("first-name")).sendKeys("ABC");
		driver.findElement(By.id("last-name")).sendKeys("XYZ");
		driver.findElement(By.id("user-name")).sendKeys("ABC.X_Y123");
		driver.findElement(By.id("password")).sendKeys("asdf1234");
		driver.findElement(By.id("show-password")).click();
		driver.findElement(By.id("mobile")).sendKeys("3478655432");
		driver.findElement(By.id("male")).click();
		driver.findElement(By.id("mobile-rec")).sendKeys("8008655432");
		driver.findElement(By.id("relationship")).sendKeys("Home");
		
		
		
		List<WebElement> allOption = driver.findElements(By.tagName("select")); // get
		// the
		// list
		// of
		// links
		// by
		// tagname

int countOption = allOption.size(); // Count all links
System.out.println("Total Option are :" + countOption);
	
for (int j = 0; j < countOption; j++) {// Looping for new Sign up link

String optionName = allOption.get(j).getText();
System.out.println(optionName);

}

		
//		birthDate(Dattable.value())
		
		birthDate(driver, "June", "11", "1990");

		File getScrenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(getScrenShot, new File("C:\\ScreenShots.jpg"));

		
//		driver.close();
	}

	private static void birthDate(WebDriver driver, String month, String day, String year) {
		new Select(driver.findElement(By.id("month"))).selectByVisibleText(month);
		new Select(driver.findElement(By.id("day"))).selectByVisibleText(day);
		new Select(driver.findElement(By.id("year"))).selectByVisibleText(year);
	}

}
