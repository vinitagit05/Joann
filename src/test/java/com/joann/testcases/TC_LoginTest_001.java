package com.joann.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.joann.base.BaseClass;
import com.joann.pages.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException, IOException {
		
	//	testLevelLog.get().assignAuthor("Nandeesh CL");
		testLevelLog.get().assignCategory("Regression_Test_Suite");
		
		

		//log.info("*****Login Verification Started*****");

		driver.get(prop.getProperty("url")); // OPEN URL
		log.info("URL"+prop.getProperty("url")+" launched");
		testLevelLog.get().info("URL"+prop.getProperty("url")+" launched");

		LoginPage lp = new LoginPage(driver); // CREATE OBJECT FOR LOGIN PAGE (POC)
	//	log.info("*****Created Object for LoginPage*****");

		lp.setUserName(prop.getProperty("username")); // ENTER USERNAME
		log.info("user name "+prop.getProperty("username")+" enetred");
		testLevelLog.get().info("user name "+prop.getProperty("username")+" enetred");
		
		lp.setPassword(prop.getProperty("password")); // ENTER PASSWORD
		log.info("Password"+prop.getProperty("password") +" Entered");
		testLevelLog.get().info("Password"+prop.getProperty("password") +" entered");

		lp.clickLogin(); // CLICK ON LOGIN
		log.info("Login button Clicked");

		Thread.sleep(1000);

		boolean status = lp.checkText();
	

		if (status) {
			
			Assert.assertTrue(true); // VERIFY TEXT PRESENT IN HOMEPAGE
			log.info("Entered Home Page Successfully ");
			testLevelLog.get().info("Entered Home Page Successfully ");

		} else {

			testLevelLog.get().info("Entered Home Page Failed ");
			//log.info("Wrong Credentials Cannot able to enter to Home page");
			//captureScreen(driver, "loginTest");
			Assert.assertTrue(false);

		}

		//log.info("*****Login Verification Completed SUccessfully*****");

	}

}
