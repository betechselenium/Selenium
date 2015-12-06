/**
 * 
 */
package selenium.keyword.driven.betech.nyc;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Owner
 *
 */
public class KeywordUtils {

	public static int getRowNumTestStep, getColNumTestStep, getRowNumTestCase, getColNumTestCase;
	public static String[][] xlData;

	/**
	 * Open browser and navigate URL
	 * 
	 * @param driver
	 * @param URL
	 */
	public static String navigateToSite(WebDriver driver, String URL) {
		String navigateToSite = null;
		try{
			driver.navigate().to(URL);
			navigateToSite = "Pass";
		} catch (NoSuchElementException e){
			e.getMessage();
			navigateToSite = "Fail";
		}
		return navigateToSite;
	}

	/**
	 * Click on Link by Link id
	 * 
	 * @param driver
	 * @param linkId
	 * @return 
	 */
	public static String linkClickByLinkId(WebDriver driver, String linkId) {
		String linkClickByLinkId = null;
		try {
			driver.findElement(By.id(linkId)).click();
			linkClickByLinkId = "Pass";
		} catch (NoSuchElementException e) {
			linkClickByLinkId = "Fail";
		}
		return linkClickByLinkId;
	}

	/**
	 * Enter data in edit field
	 * 
	 * @param driver
	 * @param fieldIdValue
	 * @param enterValue
	 * @return 
	 */
	public static String typeInEditFieldById(WebDriver driver, String fieldIdValue, String enterValue) {
		String typeInEditFieldById = null;
		try {
			driver.findElement(By.id(fieldIdValue)).clear();
			driver.findElement(By.id(fieldIdValue)).sendKeys(enterValue);
			typeInEditFieldById = "Pass";
		} catch (NoSuchElementException e) {
			e.getMessage();
			return typeInEditFieldById = "Fail";
		}
		return typeInEditFieldById;
	}

	/**
	 *  Enter data in edit field
	 * 
	 * @param driver
	 * @param fieldXpathValue
	 * @param enterValue
	 * @return
	 */
	public static String typeInEditFieldByXpath(WebDriver driver, String fieldXpathValue, String enterValue) {
		String typeInEditFieldByXpath = null;
		try {
			driver.findElement(By.xpath(fieldXpathValue)).clear();
			driver.findElement(By.xpath(fieldXpathValue)).sendKeys(enterValue);
			typeInEditFieldByXpath = "Pass";
		} catch (NoSuchElementException e) {
			typeInEditFieldByXpath = "Fail";
		}
		return typeInEditFieldByXpath;
	}

	/**
	 * Enter data in edit field
	 * 
	 * @param driver
	 * @param passObjectByName
	 * @param EnterText
	 * @throws Exception
	 */
	public static String typeInEditFieldByName(WebDriver driver, String passObjectByName, String EnterText) throws Exception {
		String typeInEditFieldByName = null;
		try {
			driver.findElement(By.name(passObjectByName)).clear();
			driver.findElement(By.name(passObjectByName)).sendKeys(EnterText);
			typeInEditFieldByName = "Pass";
		} catch (NoSuchElementException e) {
			typeInEditFieldByName = "Fail";
			e.getMessage();
		}
		return typeInEditFieldByName;
	}

	/**
	 * Enter data in edit field
	 * 
	 * @param driver
	 * @param passObjectByClassName
	 * @param EnterText
	 * @throws Exception
	 */
	public static String typeInEditFieldByClassName(WebDriver driver, String passObjectByClassName, String EnterText) throws Exception {
		String typeInEditFieldByClassName = null;
		try {
			driver.findElement(By.className(passObjectByClassName)).clear();
			driver.findElement(By.className(passObjectByClassName)).sendKeys(EnterText);
			typeInEditFieldByClassName = "Pass";
		} catch (NoSuchElementException e) {
			typeInEditFieldByClassName = "Fail";
			e.getMessage();
		}
		return typeInEditFieldByClassName;
	}
	
	/**
	 * Click on Button
	 * 
	 * @param driverVariable
	 * @param enterObjectIdHere
	 * @throws Exception
	 * @return
	 */
    public static String  buttonClickById(WebDriver driver, String enterObjectIdHere) throws Exception {
    	String buttonClickById = null;
		try {
			driver.findElement(By.id(enterObjectIdHere)).click();
			buttonClickById = "Pass";
		} catch (NoSuchElementException e) {
			e.getMessage();
			buttonClickById = "Fail";
		}
    	return buttonClickById;
    }

    /**
     *  Click on Button
     * 
     * @param driver
     * @param enterObjectNameHere
     * @throws Exception
     */
    public static String buttonClickByName(WebDriver driver, String enterObjectNameHere) throws Exception {
    	String buttonClickByName = null;
		try {
			driver.findElement(By.name(enterObjectNameHere)).click();
			buttonClickByName = "Pass";
		} catch (NoSuchElementException e) {
			buttonClickByName = "Fail";
			e.getMessage();
		}
    	return buttonClickByName;
    }

    /**
     * Click on Button
     * 
     * @param dirver
     * @param enterObjectClassNameHere
     * @return 
     * @throws Exception
     */
    public static String buttonClickByClassName(WebDriver dirver, String enterObjectClassNameHere) throws Exception {
    	String buttonClickByClassName = null;
		try {
			dirver.findElement(By.className(enterObjectClassNameHere)).click();
			buttonClickByClassName = "Pass";
		} catch (NoSuchElementException e) {
			buttonClickByClassName = "Fail";
			e.getMessage();
		}
    	return buttonClickByClassName;
    }

    /**
     * Click on Button By Link Text
     * 
     * @param driver
     * @param enterObjectLinkTextHere
     * @return 
     * @throws Exception
     */
    public static String buttonClickByLinkText(WebDriver driver, String enterObjectLinkTextHere) throws Exception {
    	String buttonClickByLinkText = null;
		try {
			driver.findElement(By.linkText(enterObjectLinkTextHere)).click();
			buttonClickByLinkText = "Pass";
		} catch (NoSuchElementException e) {
			buttonClickByLinkText = "Fail";
		}
    	return buttonClickByLinkText;
    }

	/**
	 * Click on Button By CSS Selector
	 * 
	 * @param driver
	 * @param enterObjectCssSelectorHere
	 * @return 
	 * @throws Exception
	 */
    public static String buttonClickByCssSelector(WebDriver driver, String enterObjectCssSelectorHere) throws Exception {
    	String buttonClickByCssSelector = null;
		try {
			driver.findElement(By.cssSelector(enterObjectCssSelectorHere)).click();
			buttonClickByCssSelector = "Pass";
		} catch (NoSuchElementException e) {
			buttonClickByCssSelector = "Fail";
			e.getMessage();
		}
    	return buttonClickByCssSelector;
    }

    /**
     *  Click on Button By Xpath
     * 
     * @param driver
     * @param enterObjectXpathHere
     * @return 
     * @throws Exception
     */
    public static String buttonClickByXpath(WebDriver driver, String enterObjectXpathHere) throws Exception {
    	String buttonClickByXpath = null;
		try {
			driver.findElement(By.xpath(enterObjectXpathHere)).click();
			buttonClickByXpath = "Pass";
		} catch (NoSuchElementException e) {
			buttonClickByXpath = "Fail";
		}
    	return buttonClickByXpath;
    }

    /**
     * Click on Link By Id
     * 
     * @param driver
     * @param enterObjectIdHere
     * @return 
     * @throws Exception
     */
    public static String linkClickById(WebDriver driver, String enterObjectIdHere) throws Exception {
    	String linkClickById = null;
		try {
			driver.findElement(By.id(enterObjectIdHere)).click();
			linkClickById = "Pass";
		} catch (NoSuchElementException e) {
			linkClickById = "Fail";
			e.getMessage();
		}
    	return linkClickById;
    }
    
    /**
     * Click on Link By Name
     * 
     * @param driver
     * @param enterObjectNameHere
     * @return 
     * @throws Exception
     */
    public static String linkClickByName(WebDriver driver, String enterObjectNameHere) throws Exception {
        String linkClickByName = null;
		try {
			driver.findElement(By.name(enterObjectNameHere)).click();
			linkClickByName = "Pass";
		} catch (NoSuchElementException e) {
			linkClickByName = "Fail";
			e.getMessage();
		}
        return linkClickByName;
    }

    /**
     * Click on Link By Class Name
     * 
     * @param driver
     * @param enterObjectClassNameHere
     * @return 
     * @throws Exception
     */
    public static String linkClickByClassName(WebDriver driver, String enterObjectClassNameHere) throws Exception {
    	String linkClickByClassName = null;
		try {
			driver.findElement(By.name(enterObjectClassNameHere)).click();
			linkClickByClassName = "Pass";
		} catch (NoSuchElementException e) {
			linkClickByClassName = "Fail";
			e.getMessage();
		}
    	return linkClickByClassName;
    }

	/**
	 * Click on link by LinkText name
	 * 
	 * @param driver
	 * @param linkTextName
	 * @return 
	 */
	public static String linkClickByLinkText(WebDriver driver, String linkTextName) {
		String clickLinkByLinkText = null;
		try {
			driver.findElement(By.linkText(linkTextName)).click();
			clickLinkByLinkText = "Pass";
		} catch (NoSuchElementException e) {
			clickLinkByLinkText = "Fail";
		}
		return clickLinkByLinkText;
	}

    /**
     * Click on Link By Partial Link Text
     * 
     * @param driver
     * @param enterObjectLinkTextHere
     * @return 
     * @throws Exception
     */
	public static String linkClickByPartialLinkText(WebDriver driver, String enterObjectLinkTextHere) throws Exception {
		String linkClickByPartialLnikText = null;
		try {
			driver.findElement(By.partialLinkText(enterObjectLinkTextHere)).click();
			linkClickByPartialLnikText = "Pass";
		} catch (NoSuchElementException e) {
			linkClickByPartialLnikText = "Fail";
			e.getMessage();
		}
		return linkClickByPartialLnikText;
	}

    /**
     * Click on Link By CSS Selector
     * 
     * @param driver
     * @param enterObjectCssHere
     * @return 
     * @throws Exception
     */
    public static String linkClickByCssSelector(WebDriver driver, String enterObjectCssHere) throws Exception {
    	String linkClickByCssSelector = null;
    	try {
            driver.findElement(By.cssSelector(enterObjectCssHere)).click();
            linkClickByCssSelector = "Pass";
    	} catch (NoSuchElementException e) {
    		linkClickByCssSelector = "Fail";
    		e.getMessage();
    	}
    	return linkClickByCssSelector;
    }

    /**
     * Click on Link By Xpath
     * 
     * @param driver
     * @param putXpathHere
     * @return 
     * @throws Exception
     */
	public static String linkClickByXpath(WebDriver driver, String putXpathHere) throws Exception {
		String linkClickByXpath = null;
		try {
			driver.findElement(By.xpath(putXpathHere)).click();
			linkClickByXpath = "Pass";
		} catch (NoSuchElementException e) {
			linkClickByXpath = "Fail";
			e.getMessage();
		}
		return linkClickByXpath;
	}

	/**
	 * Select option from drop down By Id
	 * 
	 * @param driver
	 * @param objectId
	 * @param selectItem
	 * @return 
	 */
	public static String selectById(WebDriver driver, String objectId, String selectItem) {
		String selectById = null;
		try {
			new Select(driver.findElement(By.id(objectId))).selectByVisibleText(selectItem);
			selectById = "Pass";
		} catch (NoSuchElementException e) {
			selectById = "Fail";
			e.getMessage();
		}
		return selectById;
	}

	/**
	 * Select option from drop down By Name
	 * 
	 * @param driver
	 * @param putObjectName
	 * @param typeTextExactlyObjectShow
	 * @return 
	 * @throws Exception
	 */
    public static String selectByName(WebDriver driver, String putObjectName, String typeTextExactlyObjectShow) throws Exception {
    	String selectByName = null;
    	try {
    		new Select(driver.findElement(By.name(putObjectName))).selectByVisibleText(typeTextExactlyObjectShow);
    		selectByName = "Pass";
    	} catch (NoSuchElementException e) {
    		selectByName = "Fail";
    		e.getMessage();
    	}
    	return selectByName;
    }

    /**
     * Select option from drop down By Class Name
     * 
     * @param driver
     * @param putObjectName
     * @param typeTextExactlyObjectShow
     * @return 
     * @throws Exception
     */
    public static String selectByClassName(WebDriver driver, String putObjectName, String typeTextExactlyObjectShow) throws Exception {
    	String selectByClassName = null;
    	try {
            new Select(driver.findElement(By.name(putObjectName))).selectByVisibleText(typeTextExactlyObjectShow);
            selectByClassName = "Pass";
    	} catch (NoSuchElementException e) {
    		selectByClassName = "Fail";
    		e.getMessage();
    	}
    	return selectByClassName;
    }

    /**
     * Select option from drop down By CSS Selector
     * 
     * @param driver
     * @param putObjectCssSelector
     * @param typeTextExactlyObjectShow
     * @return 
     * @throws Exception
     */
    public static String selectByCssSelector(WebDriver driver, String putObjectCssSelector, String typeTextExactlyObjectShow) throws Exception {
    	String selectByCssSelector = null;
    	try { 
    		new Select(driver.findElement(By.cssSelector(putObjectCssSelector))).selectByVisibleText(typeTextExactlyObjectShow);
    		selectByCssSelector = "Pass";
    	} catch (NoSuchElementException e) {
    		selectByCssSelector = "Fail";
    		e.getMessage();
    	}
    	return selectByCssSelector;
    }

    /**
     * Select option from drop down By Xpath
     * 
     * @param driver
     * @param putObjectXpath
     * @param typeTextExactlyObjectShow
     * @return 
     * @throws Exception
     */
    public static String selectByXpath(WebDriver driver, String putObjectXpath, String typeTextExactlyObjectShow) throws Exception {
    	String selectByXpath = null;
    	try {
    		new Select(driver.findElement(By.xpath(putObjectXpath))).selectByVisibleText(typeTextExactlyObjectShow);
    		selectByXpath = "Pass";
    	} catch (NoSuchElementException e) {
    		selectByXpath = "Fail";
    		e.getMessage();
    	}
    	return selectByXpath;
    }

    /**
     * Verify expected value with actual value By Xpath
     * 
     * @param browser
     * @param elementXpath
     * @param expectedValue
     * @return
     */
	public static String verifyTextByXpath(WebDriver browser, String elementXpath, String expectedValue) {
		String verifyTextByXpath = null;
		try {
			String actualValue = browser.findElement(By.xpath(elementXpath)).getText().trim();
			if (actualValue.equals(expectedValue)) {
				verifyTextByXpath = "Pass";
			} else {
				verifyTextByXpath = "Fail";
			}
		} catch (NoSuchElementException e) {
			verifyTextByXpath = "Fail";
			e.getMessage();
		}
		return verifyTextByXpath;
	}

    /**
     * Verify expected value with actual value By Id
     * 
     * @param browser
     * @param elementXpath
     * @param expectedValue
     * @return
     */
	public static String verifyTextById(WebDriver browser, String elementId, String expectedValue) {
		String verifyTextById = null;
		try {
			String actualValue = browser.findElement(By.id(elementId)).getText();
			if (actualValue.equals(expectedValue)) {
				verifyTextById = "Pass";
			} else {
				verifyTextById = "Fail";
			}
		} catch (NoSuchElementException e) {
			verifyTextById = "Fail";
			e.getMessage();
		}
		return verifyTextById;
	}
	
    /**
     * Mouse over click By Xpath
     * 
     * @param driver
     * @param mainMenuXpath
     * @param subMenuXpath
     */
	public static String mouseOverClickByXpath(WebDriver driver, String mainMenuXpath, String subMenuXpath) {
		String mouseOverClickByXpath = null;
		try{
			Actions action = new Actions(driver);
			WebElement mainMenu = driver.findElement(By.xpath(mainMenuXpath));
			WebElement subMenuLink = driver.findElement(By.xpath(subMenuXpath));
			action.moveToElement(mainMenu).moveToElement(subMenuLink).click().build().perform();
			mouseOverClickByXpath = "Pass";
		} catch (NoSuchElementException e){
			mouseOverClickByXpath = "Fail";
			e.getMessage();
		}
		return mouseOverClickByXpath;
	}

    /**
     * Mouse over click By Id
     * 
     * @param driver
     * @param mainMenuXpath
     * @param subMenuXpath
     */
	public static String mouseOverClickById(WebDriver driver, String mainMenuId, String subMenuId) {
		String mouseOverClickById = null;
		try{
			Actions action = new Actions(driver);
			WebElement mainMenu = driver.findElement(By.id(mainMenuId));
			WebElement subMenuLink = driver.findElement(By.id(subMenuId));
			action.moveToElement(mainMenu).moveToElement(subMenuLink).click().build().perform();
			mouseOverClickById = "Pass";
		} catch (NoSuchElementException e){
			mouseOverClickById = "Fail";
			e.getMessage();
		}
		return mouseOverClickById;
	}

}
