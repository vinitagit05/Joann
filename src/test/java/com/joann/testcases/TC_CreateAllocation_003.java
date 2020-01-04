package com.joann.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.joann.base.BaseClass;
import com.joann.pages.CreateAllocationPage;
import com.joann.utilities.CommonUtils;

public class TC_CreateAllocation_003 extends BaseClass {

	@Test
	public void createNewAllocation() throws InterruptedException {
		
		//testLevelLog.get().assignAuthor("Nandeesh CL");
		testLevelLog.get().assignCategory("Regression_Test_Suite");

		log=Logger.getLogger(TC_CreateAllocation_003.class);
		
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
	    
	    cap.clickNext3();
	    Thread.sleep(1000);
	    log.info("screen 3 next button clicked");
	    testLevelLog.get().info("screen 3 next button clicked");
	    
	   /* cap.clickNext2();
	    Thread.sleep(10000);
	    
	    
	    cap.clickNext3();
	    Thread.sleep(20000);*/
	    
	    /*cap.clickbtnRunAlgorithm();
	    Thread.sleep(50000);
	    
	    cap.clicNext5();
	    Thread.sleep(20000);*/
	    
	    cap.clickbtnRunAlgorithm();
	    Thread.sleep(1000);
	    log.info("screen 4 algo button clicked");
	    testLevelLog.get().info("screen 4 algo button clicked");
	    
	    
	    cap.clicNext5();
	    Thread.sleep(1000);
	    log.info("screen 5 next button clicked");
	    testLevelLog.get().info("screen 5 next button clicked");
	    
	    cap.clicbtnFinish();
	    Thread.sleep(1000);
	    log.info("screen 6 next button clicked");
	    testLevelLog.get().info("screen 6 next button clicked");
	    
	    Thread.sleep(1000);
	    
		

	    boolean status=cap.checkllocationColumnNameDisplayed();
		Assert.assertEquals(true, status,"Something went wrong while creating Allocation");
		log.info("New allocation "+allocationName+" created successfully");
		  testLevelLog.get().info("New allocation "+allocationName+" created successfully");
	    // Assert.assertTrue(false);

	}

}
