package com.joann.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.joann.base.BaseClass;

public class CommonUtils extends BaseClass {
	
	public static ChromeOptions getChromeDesiredCapabilities() {
		LoggingPreferences logs = new LoggingPreferences();
		logs.enable(LogType.DRIVER, Level.OFF);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
		// capabilities.setCapability(CapabilityType.PROXY, Params.PROXY);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-web-security");
		chromeOptions.addArguments("--test-type");
		chromeOptions.addArguments("--disable-notifications");
		chromeOptions.addArguments("disable-popup-blocking");
		capabilities.setCapability("chrome.verbose", false);
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		chromeOptions.merge(capabilities);
		return chromeOptions;
	}
	
	

	// function to generate a random string of length n
	public static String getAlphaNumericString() {

		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 5; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	// Time stamp generate
	public String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	public static final int pageLoadTime = 20;

	// Date generation
	public static void dateGenerator() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss");
		String date = sf.format(new Date());
		System.out.println(date);
	}

	// SCREENSHOT
	public String takeScreenshot(String filename) throws IOException {

		try {
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String filePath = (System.getProperty("user.dir") + "//Screenshots//" + filename + ".png");
			FileUtils.copyFile(file, new File(filePath));
			return filePath;
		} catch (WebDriverException e) {
			log.error(e.getMessage());
			return null;
		}
	}

	// TAKES SCREEN SHOT AND ATTACH TIME
	public static String getScreenshot(String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		// if we need screenshot with report then add this
		// String destination = System.getProperty("user.dir") + "/Screenshots/" +
		// screenshotName + dateName + ".png";

		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

/*	// FLUENT WAIT
	@SuppressWarnings("deprecation")
	public WebElement fluentWait(WebDriver driver, By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}

		});

		return element;
	}*/

	// WAIT FOR AN ELEMENT AND RETURN IT
	public WebElement waitAndReturnElement(By locator) {
		WebDriverWait waitone = new WebDriverWait(driver, 600);
		WebElement elementone = waitone.until(ExpectedConditions.presenceOfElementLocated(locator));
		return elementone;
	}

	// WAIT FOR LIST OF ELEMENT AND RETURN IT
	public List<WebElement> waitAndReturnElementMultiple(By locator) {
		WebDriverWait waitone = new WebDriverWait(driver, 20);
		List<WebElement> listOfWebelement = waitone.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		return listOfWebelement;
	}

	// WAIT FOR PAGE TO LOAD
	public void waitForPageLoad() {
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);

	}

	// CLICK AN ELEMENT BY JAVASCRIPT
	public void clickElementByJs(By locator) {
		WebElement we = waitAndReturnElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", we);

	}

	// CLICK AN ELEMENT BY JAVASCRIPT
	public void clickElementByJsW(WebElement w) {
		// WebElement we = waitAndReturnElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", w);

	}

	// SELECT BY VALUE
	public void selectByValue(String value, By locator) {
		WebElement we = waitAndReturnElement(locator);
		Select s = new Select(we);
		s.selectByValue(value);
	}

	// SELECT BY VISIBLE TEXT
	public void selectByVisibleText(String text, By locator) {
		WebElement we = waitAndReturnElement(locator);
		Select s = new Select(we);
		s.selectByVisibleText(text);
	}

	// COUNT NUMBER OF OPTIONS IN SELECT DROPDOWN
	public int numberOfOptionsInSelectDropDown(By locator) {
		WebElement we = waitAndReturnElement(locator);
		Select s = new Select(we);
		int size = s.getOptions().size();
		return size;
	}

	// PRINT ALL OPTIONS IN SELECT DROPDOWN
	public void printAllOptionsInSelectDropDown(By locator) {
		WebElement we = waitAndReturnElement(locator);
		Select s = new Select(we);
		List<WebElement> list = s.getOptions();
		for (WebElement w : list) {
			System.out.println("The options are  " + w);
		}

	}

	// ELEMENT IS DISPLAYED
	public boolean isDisplayed(By locator) {
		WebElement we = waitAndReturnElement(locator);
		boolean status = we.isDisplayed();
		return status;
	}

	// ELEMENT IS SELECTED
	public boolean isSelected(By locator) {
		WebElement we = waitAndReturnElement(locator);
		boolean status = we.isSelected();
		return status;
	}

	// ELEMENT IS ENABLED
	public boolean isEnabled(By locator) {
		WebElement we = waitAndReturnElement(locator);
		boolean status = we.isEnabled();
		return status;
	}

	// IS PRESENT
	public boolean isPresent(By locator) {

		int size = driver.findElements(locator).size();
		if (size > 0) {
			return true;
		} else {
			return false;
		}

	}

	// BOOT STRAP DROPDOWN SELECT OPTION :CLICK ON SPECIFIC ELEMENT
	public void selectOptionInBootstrapDropdown(By locator, String option) {
		// List<WebElement> list=driver.findElements(locator);

		List<WebElement> list = waitAndReturnElementMultiple(locator);
		for (WebElement e : list) {
			String opt = e.getText();
			if (opt.equals(option)) {
				e.click();
				break;
			}
		}

	}

	// BOOTSTRAP DROPDOWN PRINT OPTIONS
	public void printAllOptionInBootstrapDropdown(By locator) {
		// List<WebElement> list=driver.findElements(locator);

		List<WebElement> list = waitAndReturnElementMultiple(locator);
		System.out.println("Total number of options are " + list.size());
		for (WebElement e : list) {
			String option = e.getText();
			System.out.println("The options are " + option);
		}

	}

	// AUTOSUGGESTIVE DROPDOWN SELECTION BASED ON COMPLETE TEXT
	public void selectOptionInAutosuggestiveDropdown(By locator, String option) {
		WebElement we = waitAndReturnElement(locator);
		we.sendKeys(option);
		we.sendKeys(Keys.RETURN); // CLICK ON ENTER AFTER ENTERING TEXT
	}

	// OPEN LINK IN NEW TAB
	public void opensingleLinkInNewTab(By locator) {
		WebElement we = waitAndReturnElement(locator);
		String newClick = Keys.chord(Keys.CONTROL, Keys.ENTER);
		we.sendKeys(newClick);
	}

	// OPEN MULTIPLE LINK IN NEW TAB
	public void openMultipleLinkInNewTab(By locator) {
		List<WebElement> list = waitAndReturnElementMultiple(locator);
		String newClick = Keys.chord(Keys.CONTROL, Keys.ENTER);
		for (WebElement e : list) {
			e.sendKeys(newClick);
		}
	}

	// COUNT TOTAL NUMBER OF LINKS AND PRINT THEM
	public void linkCount(By locator) {
		List<WebElement> l = waitAndReturnElementMultiple(locator);
		System.out.println("Number of Links are " + l.size());
		for (WebElement e : l) {
			System.out.println(e.getText());
		}
	}

	// fILE DOWNLOAD VERIFICATION
	public boolean isFileExist(String location) {
		File f = new File(location);
		if (f.exists()) {
			return true;
		}

		else {
			return false;
		}
	}

	// Browser profile

	/*
	 * // File upload using Sikuli public static void fileUpload(By locator, String
	 * filePath) throws FindFailed, InterruptedException { WebElement we =
	 * waitAndReturnElement(locator); we.click(); Thread.sleep(9000); Pattern
	 * fileNameTextBox = new Pattern(prop.getProperty("fileNameTb")); Pattern
	 * openButton = new Pattern(prop.getProperty("openBtn"));
	 * 
	 * Screen s = new Screen();
	 * 
	 * s.type(fileNameTextBox, filePath); s.click(openButton); }
	 */

	// CLICK ELEMENT
	public void waitAndClickElement(By locator) {

		WebElement we = waitAndReturnElement(locator);
		we.click();

	}

	// SWITCH TO FRAME
	public void waitForFrameAndSwitch(By locator) {
		WebDriverWait waitone = new WebDriverWait(driver, 1000);
		waitone.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));

	}

	// SWITCH TO FRAME BY NAME
	public void switchToFrameByName(String value) {
		driver.switchTo().frame(value);

	}

	// SWITCH TO FRAME BY ID
	public void switchToFrameById(String value) {
		driver.switchTo().frame(value);

	}

	// SWITCH TO FRAME BY INDEX
	public void switchToFrameByIndex(int value) {
		driver.switchTo().frame(value);

	}

	// SWITCH TO DEFAULT CONTENT FROM FRAME
	public void switchFromFrameToMainWindow() {
		driver.switchTo().defaultContent();

	}

	// GET ELEMENT TEXT VALUE
	public String getBackendAttributeText(By locator) {
		WebDriverWait waitone = new WebDriverWait(driver, 10);
		String eleAttribute = waitone.until(ExpectedConditions.presenceOfElementLocated(locator)).getText();
		return eleAttribute;

	}

	// GET AATTRIBUTE VALUE OF AN ELEMENT
	public String getBackendAttributeValue(By locator) {
		WebDriverWait waitone = new WebDriverWait(driver, 10);
		String eleAttribute = waitone.until(ExpectedConditions.presenceOfElementLocated(locator)).getAttribute("value");
		return eleAttribute;

	}

	// TO MOVE TO SPECIFIC ELEMENT
	public void moveToElement(By locator) {

		WebElement we = waitAndReturnElement(locator);
		act.moveToElement(we).click().build().perform();

	}

	// RIGHT CLICK
	public void mouseHover(By locator) {
		WebElement we = waitAndReturnElement(locator);
		act.contextClick(we).build().perform();
	}

	// DOUBLE CLICK
	public void doubleClick(By locator) {
		WebElement we = waitAndReturnElement(locator);
		act.doubleClick(we).build().perform();
	}

	// DRAG AND DROP
	public void dragAndDrop(By source, By target) {
		WebElement we1 = waitAndReturnElement(source);
		WebElement we2 = waitAndReturnElement(target);
		act.dragAndDrop(we1, we2).build().perform();
	}

	// SCROLL PAGE TILL SPECIFIC ELEMENT FOUND
	public void slideTillElementFound(By locator) {
		WebElement we = waitAndReturnElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", we);

	}

	// ACCEPT ALERT
	public void allertAccept() {
		driver.switchTo().alert().accept();
	}

	// CANCEL ALERT
	public void allertDismiss() {
		driver.switchTo().alert().dismiss();
	}

	// OBTAIN TEXT FROM ALERT
	public String allertTextFetch() {
		String text = driver.switchTo().alert().getText();
		return text;
	}

	// SEND TEXT TO ALERT
	public void allertTextSend(String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	// SWITCH TO CHILD WINDOW
	public void switchToChildWindow() {

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		while (it.hasNext()) {
			// String parent = it.next();
			String child = it.next();
			driver.switchTo().window(child);
			driver.manage().window().maximize();
		}
	}

	// SWITCH TO PARENT WINDOW
	public void switchToParentWindow() {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		while (it.hasNext()) {
			String parent = it.next();
			driver.switchTo().window(parent);
			driver.manage().window().maximize();
		}

	}

	// MOVE BACK FROM CHILD TO PARENT WINDOW
	public void defaultWindow() {
		driver.switchTo().defaultContent();
	}

	// Date picker 1
	public void selectDateBasic(String month, String date, By monthFieldLocator, By arrowLocator, By dateFieldLocator) {
		// month selection
		while (true) {
			String text = driver.findElement(monthFieldLocator).getText();
			if (text.equals(month)) {
				break;
			} else {
				driver.findElement(arrowLocator).click();
			}
		}

		// date selection
		driver.findElement(dateFieldLocator).click();
	}

	// JAVASCRIP METHODS

	// FLASHING
	public void flash(WebElement element, WebDriver driver) {
		// JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 500; i++) {
			changeColor("#000000", element, driver);// 1
			changeColor(bgcolor, element, driver);// 2
		}
	}

	public void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}

	// DRAWING BORDER
	public void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	// CAPTURE TITLE OF PAGE
	public String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

	// CLICK ON ELEMENT
	public void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);

	}

	// GENERATE RUNTIME ALLERT
	public void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");

	}

	/// REFRESH PAGE
	public void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}

	// GET INNER TEXT (VISIBLE TEXT) :BASICALLY USED IN GETTING DATES IN CALENDAR
	public String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}

	// SCROLL PAGE TILL END
	public void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	// SCROLL PAGE TILL PARTICULAR ELEMENT
	public void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
