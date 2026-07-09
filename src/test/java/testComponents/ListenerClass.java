package testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ExtentReporterNG;

import java.io.IOException;

public class ListenerClass extends BaseClass implements ITestListener {

    ExtentReports reports = ExtentReporterNG.getReport();
    ExtentTest test;
    //WebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
        test = reports.createTest("Test 1");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        //getting driver
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        test.fail(result.getThrowable());
        String filePath = null;

        // getting screenshot of failed testcase
        try {
            filePath = getScreenshot(result.getMethod().getMethodName(), driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());

    }

    @Override
    public void onFinish(ITestContext context) {
        reports.flush();
    }
}
