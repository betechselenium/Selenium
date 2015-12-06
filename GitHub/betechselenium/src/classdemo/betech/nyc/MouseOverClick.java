package classdemo.betech.nyc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOverClick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

			WebDriver driver = new FirefoxDriver(); // Create FF Driver
			driver.manage().window().maximize(); // Maximize the window
			driver.navigate().to("https://www.thinkwithgoogle.com/"); // Open Yahoo mail page
																// direct
			
			String mainMenuXpath = "//*[@id='twg-header']/div/div/nav/ul/li[1]/span";
			
			String subMenuXpathMicro = "//*[@id='twg-header']/div/div/nav/ul/li[1]/ul/li[2]/a";
			String subMenuXpathVideo = "//*[@id='twg-header']/div/div/nav/ul/li[1]/ul/li[3]/a";
			String subMenuXpath = "//*[@id='twg-header']/div/div/nav/ul/li[1]/ul/li[4]/a";
			
			
			mouseOverClick(driver, mainMenuXpath, subMenuXpathVideo );
			mouseOverClick(driver, mainMenuXpath, subMenuXpathMicro );
			mouseOverClick(driver, mainMenuXpath, subMenuXpath );
			
			
	}

	private static void mouseOverClick(WebDriver driver, String mainMenuXpath, String subMenuXpath) {
		Actions action = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath(mainMenuXpath));
		WebElement subMenuLink = driver.findElement(By.xpath(subMenuXpath));
		action.moveToElement(mainMenu).moveToElement(subMenuLink).click().build().perform();
	}
}
