package Ekart.TestComponents;

import org.testng.ITestListener;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Ekart.Resources.ExtentReporterNg;
import Ekart.TestComponents.BaseTest;
public class Listeners extends BaseTest implements ITestListener{
	 ExtentReports extent = ExtentReporterNg.getReportObject();
	    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	    @Override
	    public void onTestStart(ITestResult result) {
	        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
	        extentTest.set(test);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        extentTest.get().log(Status.PASS, "Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        extentTest.get().log(Status.FAIL, "Test Failed");
	        extentTest.get().fail(result.getThrowable());

	        WebDriver driver = null;
	        try {
	            driver = (WebDriver) result.getTestClass().getRealClass()
	                    .getField("driver")
	                    .get(result.getInstance());
	        } catch (Exception e) {
	            System.out.println("Could not get driver instance: " + e.getMessage());
	            e.printStackTrace();
	        }

	        String filePath = null;
	        try {
	            filePath = getScreenshot(result.getMethod().getMethodName(), driver);
	            if (filePath != null) {
	                extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	                extentTest.get().log(Status.INFO, "Screenshot saved at: " + filePath);
	            } else {
	                extentTest.get().log(Status.WARNING, "Screenshot path is null.");
	            }
	        } catch (Exception e) {
	            System.out.println("Screenshot capture failed: " + e.getMessage());
	            extentTest.get().log(Status.WARNING, "Screenshot capture failed: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        extentTest.get().log(Status.SKIP, "Test Skipped: " + result.getThrowable());
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // Optional: implement if needed
	    }

	    @Override
	    public void onStart(ITestContext context) {
	        // Optional: implement if needed
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }

}
