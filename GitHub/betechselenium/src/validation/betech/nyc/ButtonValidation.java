package validation.betech.nyc;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ButtonValidation {
public static WebDriver driver;

public static String createAccountButtonStatus = "//*[@id='signUpForm']/button";
	public static void main(String[] args) throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.zumba.com/en-US/user/signup");
//		System.out.println(isCreateAccountButtonDisable);
//		boolean abc = false;
		if(!checkButtonStatus(createAccountButtonStatus)){ // ! = not //
			driver.findElement(By.id("first-name")).sendKeys("ABC");
			driver.findElement(By.id("last-name")).sendKeys("XYZ");
			driver.findElement(By.id("user-email")).sendKeys("XYZ@gmail.com");
			driver.findElement(By.id("username-field")).sendKeys("ABC.X_Y123");
			driver.findElement(By.id("password")).sendKeys("asdf1234");
			driver.findElement(By.id("password-confirm")).sendKeys("asdf1234");
			Thread.sleep(2000);
			/**
			 * Below code for page scro
			 */
			JavascriptExecutor jsx = (JavascriptExecutor)driver;
			jsx.executeScript("window.scrollBy(0,450)", "");
			
//			Actions actions = new Actions(driver);
//			actions.sendKeys(Keys.ARROW_DOWN).perform();
			
			driver.findElement(By.xpath("//form[@id='signUpForm']/div[9]/label/span[@class='required-star']")).click();
		} else {
			System.out.println("Button is enabled, system does not work as per requirement. ");

		}
		
		if (checkButtonStatus(createAccountButtonStatus)) {
			System.out.println("System works as expected");
		} else {
			System.out.println("System does not work as per requirement.");
		}
	

	}
	
	static boolean checkButtonStatus(String passElementXpath) {
		boolean isCreateAccountButtonEnable;
		isCreateAccountButtonEnable = driver.findElement(By.xpath(passElementXpath)).isEnabled();
		return isCreateAccountButtonEnable;
	}
}
