package com.joann.pages;

import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.joann.base.BaseClass;

public class StrategyPage extends BaseClass {


	WebDriver ldriver;

	public StrategyPage(WebDriver rdriver)

	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	By chkboxSelectAll = By.xpath("//span[text()='ARTICLE']//parent::div//parent::div//preceding-sibling::span");
	By paintBrushStep4 = By.id("step4PaintBrush");
	By dateScreen4DateRange1 =By.id("datepicker-trigger-massSelect1");
	By drpMerchHierarchySelection = By.xpath("//select[starts-with(@id,'__BVID__')]");
	By txtMerchHierarchyMapping = By.xpath("//div[contains(text(),'Select Merch Cat')] ");
	By txtWeightage1 = By.xpath("//input[@placeholder='weight 1']");
	
	By dateMonthOfDateRange1= By.xpath("//input[@id='datepicker-trigger-massSelect1']//parent::div/div/div[2]/div/div/div/select[1]");
	By dateYearOdDateRange1=By.xpath("//input[@id='datepicker-trigger-massSelect1']//parent::div/div/div[2]/div/div/div/select[2]");	
	
	
	
	
	
	public void clickScreen4SelectAllArticleCheckBox() {
		
		
		WebElement w1=cu.waitAndReturnElement(chkboxSelectAll);
		cu.clickElementByJsW(w1);
		//cu.clickElementByJs(btnCreateAllocation);

		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();",driver.findElement(
		 * btnCreateAllocation));
		 */

	}
	
	
	public void clickScreen4PaintBrush() {
		
		
		WebElement w2=cu.waitAndReturnElement(paintBrushStep4);
		cu.clickElementByJsW(w2);
		//cu.clickElementByJs(btnCreateAllocation);

		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();",driver.findElement(
		 * btnCreateAllocation));
		 */

	}
	
	
	
	public void setDateRange1() throws InterruptedException
	{
		driver.findElement(By.id("datepicker-trigger-massSelect1")).click();
		Thread.sleep(2000);
		cu.selectByValue("October",dateMonthOfDateRange1);
		Thread.sleep(2000);
		cu.selectByValue("2018", dateYearOdDateRange1);
		driver.findElement(By.xpath("//*[@id=\"airbnb-style-datepicker-wrapper-09983\"]/div[2]/div/div[2]/table/tbody/tr/td/"
				+ "button[contains(text(),'1')]")).click();
		
	}
	
	public void setInputs(String hierarchy) throws InterruptedException {
		
		
	//	WebElement w2=cu.waitAndReturnElement(dateScreen4DateRange1);
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("document.getElementById('datepicker-trigger-massSelect1').value='11/01/2018 - 11/01/2019';");
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[text()='Apply']")).click();
		//cu.clickElementByJsW(w2);
		//cu.clickElementByJs(btnCreateAllocation);

		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();",driver.findElement(
		 * btnCreateAllocation));
		 */
		
		cu.selectByValue(hierarchy, drpMerchHierarchySelection);
		Thread.sleep(2000);
		driver.findElement(txtMerchHierarchyMapping).click();
		Thread.sleep(2000);
		//driver.findElement(txtMerchHierarchyMapping).sendKeys("170002");
		//robot.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(txtWeightage1).sendKeys("50");
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		

	}
	
}
