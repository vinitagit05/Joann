package com.joann.utilities;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.joann.base.BaseClass;


public class Extentmanager extends BaseClass {
	
	private static ExtentReports extent;
	//private static ExtentTest test;
	private static ExtentHtmlReporter htmlReporter;
	//private static String filePath = "./extentreport.html";


	public static ExtentReports GetExtent(String filePath) {
		if (extent != null) {
			return extent;
		} else {
			extent = new ExtentReports();
			extent.attachReporter(Extentmanager.getHtmlReporter(filePath));
			//extent.setSystemInfo("Host Name", "Rahul@Java");
			
			extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
			return extent;
		}
	}

	public static ExtentHtmlReporter getHtmlReporter(String filePath) {

		htmlReporter = new ExtentHtmlReporter(filePath);
		//htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("JAM Regression Test Report");
		htmlReporter.config().setReportName("JOANN Allocate Smart Regression Test Report");
	//	htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		
	//	htmlReporter.setAppendExisting(false);
		htmlReporter.loadXMLConfig("./Configuration/extentConfig.xml");

		return htmlReporter;
		
	}

}
