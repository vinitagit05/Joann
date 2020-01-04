package com.joann.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.joann.pages.CreateAllocationPage;
import com.joann.pages.LoginPage;
import com.joann.pages.StrategyPage;
import com.joann.utilities.CommonUtils;
import com.joann.utilities.Extentmanager;

public class BaseClass {

	// For Report generation

	// For Extent Report: Create object for ExtentReport class
	public static ExtentReports extentReport;

	// Create two variable classLevelLogger/ testLevelLogger of type ThreadLevel
	// class

	// Convert variable to Thread Local variable so only one thread(Variable) can
	// write into report

	// To create LhS node
	// crating object for Thread Local class of type Extent test

	public static ThreadLocal<ExtentTest> classLevelLog = new ThreadLocal<ExtentTest>(); // LHS Node create
	public static ThreadLocal<ExtentTest> testLevelLog = new ThreadLocal<ExtentTest>(); // Test case Log
	public static WebDriver driver; // FOR WEBDRIVER
	public static Properties prop; // FOR PROPERTY FILE
	public static Logger log; // FOR LOGS
	public static LoginPage lp; // FOR LOGIN PAGE
	public static CreateAllocationPage cap; // FOR CREATE ALLOCATION PAGE
	public static Actions act;
	public static CommonUtils cu;
	public static File source;
	public static File target;
	public static StrategyPage strategyPage;
	public static Robot robot;

	@BeforeSuite
	public void beforeSuite() {
		extentReport = Extentmanager.GetExtent("./TestReports/JAM_Regression_Test_Report.html");
	}

	@BeforeClass
	@Parameters("browser")
	public void setup(String br) throws IOException, AWTException {
		// READING PROPERTY FILE
		prop = new Properties();
		FileInputStream configfile = new FileInputStream(
				System.getProperty("user.dir") + "\\Configuration\\config.properties");
		prop.load(configfile);

		// LOG4J PROPERTY FILE LOAD
		log = Logger.getLogger(BaseClass.class);
		PropertyConfigurator.configure("./Configuration/log4j.properties");

		// CHECK ON WHICH BROWSER TO OPEN
		if (br.equals("chrome")) {
			// OPENING CHROME DRIVER
			// System.setProperty("webdriver.chrome.driver",prop.getProperty("chromepath"));
			// WebDriverManager.chromedriver().version("77.0.3865.120").setup();
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		//ChromeOptions options = new ChromeOptions();
			ChromeOptions options=CommonUtils.getChromeDesiredCapabilities();
			options.setHeadless(true);
			driver = new ChromeDriver(options);
		}

		else if (br.equals("firefox")) {
			// OPENING FIREFOX DRIVER
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}

		// MAXIMIZE SCREEN AND DELITING COOKIES
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// For Action Class
		act = new Actions(driver);

		// FOR COMMON UTILS
		cu = new CommonUtils();

		// Extent report:LHS node for each class
		// getClass().getSimpleName(): gives class name
		// create class at lhs of the report for each class
		ExtentTest test = extentReport.createTest(getClass().getSimpleName());
		classLevelLog.set(test);
		
		 robot=new Robot();
		

	}

	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			driver.quit(); // CLOSE THE BROWSER
		}
		}
		

	@BeforeMethod
	public void beforeMethod(Method method) {
		log.info(method.getName() + " started execution");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == 2) {
			log.info("status is failed");
		} else {
			log.info("status is passed");
		}

		log.info(result.getName() + " finished execution");
	}


	// LOGIN METHOD
	public void login() {
		
		driver.get(prop.getProperty("url"));
		lp = new LoginPage(driver);
		lp.setUserName(prop.getProperty("username"));
		log.info("username entered");


		lp.setPassword(prop.getProperty("password"));
		log.info("password entered");

		lp.clickLogin();
		log.info("login button clicked");

	}

}
