package com.joann.utilities;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.joann.base.BaseClass;

public class TestListeners extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {

		// create node in middle of the report for each test method(test case) with that
		// test case method name
		ExtentTest test = classLevelLog.get().createNode(result.getName());
		testLevelLog.set(test);

		// log info in report: that test case has been started in the report in that
		// node starting
		testLevelLog.get().log(Status.INFO,
				"<b>" + " Execution of Test Case:- " + result.getName() + " Started" + "</b>");

	}

	public void onTestSuccess(ITestResult result) {
		//Print sucessfull message with bold and green color background
		String successMessage = "<b>" + "This Test Case is Passed" + "</b>";
		Markup m = MarkupHelper.createLabel(successMessage, ExtentColor.GREEN);
		testLevelLog.get().pass(m);
		
		testLevelLog.get().log(Status.INFO,
				"<b>" + " Execution of Test Case:- " + result.getName() + " Finished" + "</b>");
		
		

	}

	public void onTestFailure(ITestResult result) {

		//Get the exception of the failure method and store in exceptionMessage variable
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());

		// click icon to see exception details
		testLevelLog.get()
				.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
						+ "</font>" + "</b >" + "</summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details>"
						+ " \n");

		// Print failure message in red color background
		String failureLogg = "This Test case got Failed";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testLevelLog.get().log(Status.FAIL, m);
	/*	try {
			testLevelLog.get().fail("Something went wrong").addScreenCaptureFromPath("C:\\Users\\nandeesh.cl\\Desktop\\Framework\\JoannTestNGProd\\Screenshots/"+target.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
        //We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method. 			
      
        
        
     //To add it in the extent report 
        try {
        	String screenshotPath=   CommonUtils.getScreenshot(result.getName());
			testLevelLog.get().fail("Please find below attached Screenshot").addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


        testLevelLog.get().log(Status.INFO,
				"<b>" + " Execution of Test Case:- " + result.getName() + " Finished" + "</b>");
		

	}

	public void onTestSkipped(ITestResult result) {
		
		//Print skipped message
		testLevelLog.get().skip("</b >"+"This test Case got Skipped"+"</b >");
		
		testLevelLog.get().log(Status.INFO,
				"<b>" + " Execution of Test Case:- " + result.getName() + " Finished" + "</b>");
		

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
	
		extentReport.flush();

	}

}
