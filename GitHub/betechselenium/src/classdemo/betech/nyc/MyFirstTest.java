package classdemo.betech.nyc;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstTest {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.betech.nyc/");

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		
		
		
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			
			
			
			try {
				if ("APPLY".equals(driver.findElement(By.linkText("APPLY")).getText()))
					break;
			} catch (Exception e) {

			}
		
			finally
			{
				
			}
			Thread.sleep(50000000);
		}

		
		
		
		
		
		
		int countLink = allLinks.size();
		System.out.println("Total count fields are: " + countLink);

		for (int i = 0; i < countLink; i++) {
			// if allLinks.get(i).getText() == " APPLY";
			if (allLinks.get(i).getText().equalsIgnoreCase("apply")) {
				// Then click on apply link
				driver.findElement(By.linkText("APPLY")).click();
				break;
			}
		}

		driver.findElement(By.id("firstname")).sendKeys("Betech");
		driver.findElement(By.id("lastname")).sendKeys("Selenium");
		driver.findElement(By.id("email")).sendKeys("selenium.betech@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("34651234");
		driver.findElement(By.id("zipcode")).sendKeys("11218");
		driver.findElement(By.id("city")).sendKeys("Brooklyn");
		driver.findElement(By.id("state")).sendKeys("New York");

		driver.close();

	}

	private static void fail(String string) {

	}
}
