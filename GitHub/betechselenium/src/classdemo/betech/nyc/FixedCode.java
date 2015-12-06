package classdemo.betech.nyc;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FixedCode {

	public static void main(String[] args) throws IOException {

		for (int j = 0; j < 5; j++) {

			WebDriver driver = new FirefoxDriver();
			driver.navigate().to("http://www.betech.nyc");

			// Store all links in "allLinks" variable
			List<WebElement> allLinks = driver.findElements(By.tagName("a"));
			int countlink = allLinks.size();// Get number How many links on that
											// page

			System.out.print("Total count link are:" + countlink);

			for (int i = 0; i < countlink; i++) {// Looping
				/// if there is apply link
				if (allLinks.get(i).getText().trim().equalsIgnoreCase("aPpLy")) {
					// then click on APPLY link
					driver.findElement(By.linkText("APPLY")).click();
					break; // if condition match then exit from loop
				}

			}

			Random random = new Random();

			File getScrenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(getScrenShot,
					new File("C:\\Users\\Betech\\Desktop\\betech" + random.nextInt(1000) + ".jpg"));

		}
	}

}