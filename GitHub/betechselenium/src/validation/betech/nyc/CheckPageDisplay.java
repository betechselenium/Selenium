package validation.betech.nyc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckPageDisplay {
	public static WebDriver driver;
	public static void main(String[] args) {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://accounts.google.com/");
		
		/**
		 * Get "Sign in with your Google Account" text
		 */
		String signWithGoogleText = driver.findElement(By.className("hidden-small")).getText();
		System.out.println("Get Text: " + signWithGoogleText);
		
		/**
		 * Get "Sign in with your Google Account" text display
		 */
		boolean isSignWithGoogleDisplay = driver.findElement(By.className("hidden-small")).isDisplayed();
		System.out.println("is text display? " + isSignWithGoogleDisplay);
		
		/**
		 * Get "Sign in with your Google Account" text enable
		 */
		boolean isSignWithGoogleEnabled = driver.findElement(By.className("hidden-small")).isEnabled();
		System.out.println("is text enabled? " + isSignWithGoogleEnabled);
		
		/**
		 * Check Next button enable
		 */
		boolean isNextButtonEnable = driver.findElement(By.id("next")).isEnabled();
		System.out.println("is Next button enabled? " + isNextButtonEnable);
		
		/**
		 * Check Next button selected
		 */
		boolean isNextButtonSelected = driver.findElement(By.id("next")).isSelected();
		System.out.println("is Next button selected? " + isNextButtonSelected);
		
		/**
		 * Check "create account" link selected
		 */
		boolean isCreateAccountLinkSelected = driver.findElement(By.id("link-signup")).isSelected();
		System.out.println("is create account selected? " + isCreateAccountLinkSelected);
	}

}
