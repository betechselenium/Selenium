package testng.betech.nyc;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class TestNGTest1 {
    public static WebDriver driver;
	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}

	
	
	@Test
	public void createAccountGmail() {
		System.out.println("Create Account On Gmail");
		driver.navigate().to("https://accounts.google.com/");
		driver.findElement(By.id("link-signup")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Betech");
		driver.findElement(By.id("LastName")).sendKeys("Selenium");
		System.out.println("Create Account On Gmail End");
	}
	
	@Ignore
	public void applyBetech() {
		System.out.println("Apply Betech");
		driver.navigate().to("http://betech.nyc/");
		driver.findElement(By.linkText("APPLY")).click();
		driver.findElement(By.id("firstname")).sendKeys("Betech");
		driver.findElement(By.id("lastname")).sendKeys("Selenium");
		System.out.println("Apply Betech End");
	}
	
	@Test
	public void contactBetech() {
		System.out.println("Contact Betech");
		driver.navigate().to("http://betech.nyc/");
		driver.findElement(By.linkText("CONTACT US")).click();
		driver.findElement(By.id("firstname")).sendKeys("Betech");
		driver.findElement(By.id("lastname")).sendKeys("Selenium");
	}
  

}
