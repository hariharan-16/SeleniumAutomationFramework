package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    public static ExtentReports getReport(){
        ExtentSparkReporter reporter = new ExtentSparkReporter("testResult/index.html");
        reporter.config().setReportName("Hariharan R");
        reporter.config().setDocumentTitle("Framework Report 1");

        ExtentReports reports = new ExtentReports();
        reports.attachReporter(reporter);
        reports.setSystemInfo("Tester", "Hariharan R");

        return reports;
    }

}
