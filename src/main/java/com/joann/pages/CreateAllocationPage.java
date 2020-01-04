package com.joann.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.joann.base.BaseClass;

public class CreateAllocationPage extends BaseClass {

	WebDriver ldriver;

	public CreateAllocationPage(WebDriver rdriver)

	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	// LOCATORS
	//screen 1 create allocation button
	//By btnCreateAllocation = By.xpath("//button[contains(text(),'Create New Allocation')]");
	By btnCreateAllocation = By.id("createAllocationButton");
	
	
	//screen 1 fields
	By txtAllocationName = By.xpath("//input[@placeholder='Allocation Name']");
	By drpPush = By.xpath("//select[@placeholder='Push']");
	By txtComments = By.id("exampleInput2");
	By txtFileUpload = By.id("buyUploadFile");
	
	//screen 1 next button
	//By btnNext1 = By.xpath("//button[contains(text(),'Next')]");
	By btnNext1 = By.id("step1NextButton");
	
	//screen 2 next button
	//By btnNext2 = By.xpath("//button[text()='Next'][@tabindex='-1']");
	By btnNext2 = By.id("step2NextButton");
	
	//screen 3 next button
	//By btnNext3 = By.xpath("//button[text()='Next'][@tabindex='-1'][@class='wizard-btn wizard-footer-right btn-save']");
	By btnNext3 = By.id("step3NextButton");
	
	//screen 4 algo button
	//By btnRunAlgorithm = By.xpath("//button[text()='Run Algorithm'][@tabindex='-1']");
	By btnRunAlgorithm = By.id("step4NextButton");
	
	//screen 5 next button
	//By btnNext5 = By.xpath("//button[text()='Next'][@tabindex='-1']");
	By btnNext5 = By.id("step5NextButton");
	
	//screen 6 finish button
	//By btnFinish = By.xpath("//button[text()='Finish'][@tabindex='-1']");
	By btnFinish = By.id("step6NextButton");
	
	//dashboard sap text name
	By txtColumnHeader = By.xpath("//span[text()='SAP Upload']");
	
	//dashboard allocation name
	By txtAlocationFieldName=By.xpath("//span[text()='Allocation Name']");
	
	
	By txtArticleSelectionName=By.xpath("//strong[text()='Article Selection']");
	By txtStoreSelectionName =By.xpath("//strong[text()='Store Selection']");
    By txtAllocationStratergyName=By.xpath("//strong[text()='Allocation Strategy']");
    By txtFinalizeAllocationName=By.xpath("//strong[text()='Finalize Allocation']");
    By txtAllocationReportName=By.xpath("//strong[text()='Allocation Report']");
    
  
	// ACTIONS
	public void clickCreateAllocationButton() {
		
		
		WebElement w1=cu.waitAndReturnElement(btnCreateAllocation);
		cu.clickElementByJsW(w1);
		//cu.clickElementByJs(btnCreateAllocation);

		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();",driver.findElement(
		 * btnCreateAllocation));
		 */

	}

	public void setAllocationName(String aname) {
		
		WebElement w2=cu.waitAndReturnElement(txtAllocationName);
		//ldriver.findElement(txtAllocationName).sendKeys(aname);
		w2.sendKeys(aname);
	}

	public void selectPush(String push) {
		
		WebElement w3=cu.waitAndReturnElement(drpPush);
		Select s = new Select(w3);
		s.selectByVisibleText(push);
	}

	public void setComment(String comment) {
		
		WebElement w4=cu.waitAndReturnElement(txtComments);
		w4.sendKeys(comment);
	}

	public void uploadFile(String path) {
		
		WebElement w5=cu.waitAndReturnElement(txtFileUpload);
		w5.sendKeys(path);

	}

	public void clickNext1() {
		
		WebElement w6=cu.waitAndReturnElement(btnNext1);
		cu.clickElementByJsW(w6);
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ldriver.findElement(btnNext1));*/

	}

	public void clickNext2() {
		
		WebElement w7=cu.waitAndReturnElement(btnNext2);
		cu.clickElementByJsW(w7);
		//cu.clickElementByJs(btnNext2);
		/*
		 * WebElement newbtnNext2 = CommonUtils.waitAndReturnElement(btnNext2);
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();", newbtnNext2);
		 */

	}

	public void clickNext3() {
		
		WebElement w8=cu.waitAndReturnElement(btnNext3);
		cu.clickElementByJsW(w8);
		// cu.clickElementByJs(btnNext3);
		/*
		 * WebElement newbtnNext2 = CommonUtils.waitAndReturnElement(btnNext2);
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();", newbtnNext2);
		 */

		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();", driver.findElement(btnNext3));
		 */

		//ldriver.findElement(btnNext3).click();

	}

	public void clickbtnRunAlgorithm() {
		
		WebElement w9=cu.waitAndReturnElement(btnRunAlgorithm);
		cu.clickElementByJsW(w9);
		//cu.clickElementByJs(btnRunAlgorithm);
		/*
		 * WebElement newbtnNext2 = CommonUtils.waitAndReturnElement(btnNext2);
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();", newbtnNext2);
		 */

	}

	public void clicNext5() {
		
		WebElement w10=	cu.waitAndReturnElement(btnNext5);
		cu.clickElementByJsW(w10);
		//cu.clickElementByJs(btnNext5);
		/*
		 * WebElement newbtnNext2 = CommonUtils.waitAndReturnElement(btnNext2);
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();", newbtnNext2);
		 */

	}
	
	public void clicbtnFinish() {
		
		WebElement w11=	cu.waitAndReturnElement(btnFinish);
		cu.clickElementByJsW(w11);
		//cu.clickElementByJs(btnFinish);
		/*
		 * WebElement newbtnNext2 = CommonUtils.waitAndReturnElement(btnNext2);
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();", newbtnNext2);
		 */

	}
	
//	Dashboard  check
	public boolean checkllocationColumnNameDisplayed()
	{
		WebElement w12=cu.waitAndReturnElement(txtAlocationFieldName);
		//boolean statusAllocationColumnName= cu.isDisplayed(txtAlocationFieldName);
		boolean statusAllocationColumnName=    w12.isDisplayed();
		return statusAllocationColumnName;
	}
	
//Screen 2 check
	public boolean checkScreen2Displayed()
	{
		WebElement w13=cu.waitAndReturnElement(txtArticleSelectionName);
		//boolean statusArticleSelectionName= cu.isDisplayed(txtArticleSelectionName);
		boolean statusArticleSelectionName=w13.isDisplayed();
		return statusArticleSelectionName;
	}
	
	
	//Screen 3 check
	public boolean checkScreen3Displayed()
	{
		WebElement w14=cu.waitAndReturnElement(txtStoreSelectionName);
		//boolean statusStoreSelectionName= cu.isDisplayed(txtStoreSelectionName);
		boolean statusStoreSelectionName=w14.isDisplayed();
		return statusStoreSelectionName;
	}
	
	//Screen 4 check
	public boolean checkScreen4Displayed()
	{
		WebElement w15=cu.waitAndReturnElement(txtAllocationStratergyName);
		//boolean statusAllocationStratergyName= cu.isDisplayed(txtAllocationStratergyName);
		boolean statusAllocationStratergyName=w15.isDisplayed();
		return statusAllocationStratergyName;
	}
	
	//Screen 5 check
	public boolean checkScreen5Displayed()
	{
		WebElement w16=cu.waitAndReturnElement(txtFinalizeAllocationName);
		//boolean statustxtFinalizeAllocationName= cu.isDisplayed(txtFinalizeAllocationName);
		boolean statustxtFinalizeAllocationName=w16.isDisplayed();
		return statustxtFinalizeAllocationName;
	}
	
	//Screen 6 check
	public boolean checkScreen6Displayed()
	{
		WebElement w17=cu.waitAndReturnElement(txtAllocationReportName);
		//boolean statustxtAllocationReportName= cu.isDisplayed(txtAllocationReportName);
		boolean statustxtAllocationReportName= w17.isDisplayed();
		return statustxtAllocationReportName;
	}
	

}
