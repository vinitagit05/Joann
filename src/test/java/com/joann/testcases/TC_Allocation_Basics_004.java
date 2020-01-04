package com.joann.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.joann.base.BaseClass;
import com.joann.pages.CreateAllocationPage;
import com.joann.utilities.CommonUtils;

@Test
 public class TC_Allocation_Basics_004 extends BaseClass {
	
	public void allocationBasicScreen() throws InterruptedException 
	{
		testLevelLog.get().assignCategory("Regression_Test_Suite");
		
		log=Logger.getLogger(TC_Allocation_Basics_004.class);
		
		cap=new CreateAllocationPage(driver);

		login(); // LOGIN TO TOOL AND PERFORM REQUIRED ACTIONS

		Thread.sleep(1000);
		cap.clickCreateAllocationButton();
        log.info("Create allocation button clicked");
        testLevelLog.get().info("Create allocation button clicked");
		
		Thread.sleep(1000);
		
		String allocationName="NclAutomationScript"+CommonUtils.getAlphaNumericString();
		cap.setAllocationName(allocationName);
        log.info("Allocation name "+allocationName+" entered");
        testLevelLog.get().info("Allocation name "+allocationName+" entered");
        
		Thread.sleep(1000);

		cap.selectPush("INITIAL");
		Thread.sleep(2000);
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
	    
	    boolean status=cap.checkScreen2Displayed();
		Assert.assertEquals(true, status,"Something went moving to screen 2");
		log.info("reached screen 2 successfully");
		testLevelLog.get().info("reached screen 2 successfully");
	    // Assert.assertTrue(false);
	    
	    
		
	}
	
	
	
	

}
