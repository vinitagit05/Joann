package com.joann.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.joann.base.BaseClass;
import com.joann.pages.CreateAllocationPage;
import com.joann.utilities.CommonUtils;

public class TC_Article_Selection_009 extends BaseClass {
	
	@Test
	public void articleSelectionScreen() throws InterruptedException
	{
		testLevelLog.get().assignCategory("Regression_Test_Suite");

		log=Logger.getLogger(TC_Article_Selection_009.class);
		
		cap=new CreateAllocationPage(driver);

		login(); // LOGIN TO TOOL AND PERFORM REQUIRED ACTIONS

		Thread.sleep(1000);
		cap.clickCreateAllocationButton();
        log.info("Create allocation button clicked");
        testLevelLog.get().info("Create allocation button clicked");
		
		Thread.sleep(1000);
		
		String allocationName="NclAutomationScript "+CommonUtils.getAlphaNumericString();
		cap.setAllocationName(allocationName);
        log.info("Allocation name "+allocationName+" entered");
        testLevelLog.get().info("Allocation name"+allocationName+" entered");
		
		Thread.sleep(1000);

		cap.selectPush("INITIAL");
		Thread.sleep(1000);
		log.info("selected initial push");
		  testLevelLog.get().info("selected initial push");

		cap.uploadFile("C:\\Users\\nandeesh.cl\\Desktop\\Framework\\JoannTestNGProd\\TestData\\5 articles.xlsx");
		Thread.sleep(1000);
		log.info("input file uploaded");
		  testLevelLog.get().info("input file uploaded");

	    cap.clickNext1();
	    Thread.sleep(1000);
	    log.info("screen 1 next button clicked");
	    testLevelLog.get().info("screen 1 next button clicked");
	    
	    cap.clickNext2();
	    Thread.sleep(1000);
	    log.info("screen 2 next button clicked");
	    testLevelLog.get().info("screen 2 next button clicked");
	    
	    Thread.sleep(1000);
	    
	    boolean status=cap.checkScreen3Displayed();
		Assert.assertEquals(true, status,"Something went moving to screen 2");
		log.info("reached screen 3 successfully");
		testLevelLog.get().info("reached screen 3 successfully");
	}
	
	

}
