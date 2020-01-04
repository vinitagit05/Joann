package com.joann.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.joann.base.BaseClass;
import com.joann.pages.LoginPage;
import com.joann.utilities.XLUtils;

public class TC_LoginTestDD_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginTest(String uname, String pwd) throws InterruptedException, IOException {
		
	//	testLevelLog.get().assignAuthor("Nandeesh CL");
		testLevelLog.get().assignCategory("Regression_Test_Suite");

		driver.get(prop.getProperty("url")); // OPEN URL
		log.info("URL"+prop.getProperty("url")+" launched");
		testLevelLog.get().info("URL"+prop.getProperty("url")+" launched");

		LoginPage lp = new LoginPage(driver); // CREATE OBJECT FOR LOGIN PAGE (POC)

		lp.setUserName(uname); // ENTER USERNAME
		log.info("Username " + uname + " Entered");
		testLevelLog.get().info("Username " + uname + " Entered");

		Thread.sleep(2000);

		lp.setPassword(pwd); // ENTER PASSWORD
		log.info("Password " + pwd + " Entered");
		testLevelLog.get().info("Password " + pwd + " Entered");
		
		Thread.sleep(2000);

		lp.clickLogin(); // CLICK ON LOGIN
		// log.info("*****Login button Clicked*****");

		Thread.sleep(2000);

		// Thread.sleep(2000);

		boolean status = lp.checkText();

		if (status) {
			log.info("Entered Home Page Successfully with valid credentials");
			testLevelLog.get().info("Entered Home Page Successfully with valid credentials");
			Assert.assertTrue(true); // VERIFY TEXT PRESENT IN HOMEPAGE
		} else {

			log.info("Wrong Credentials Cannot able to enter to Home page");
			testLevelLog.get().info("Wrong Credentials Cannot able to enter to Home page");
			// captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
		}

	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/TestData/testD.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j); // 1,0
			}
		}

		return logindata;

	}

}
