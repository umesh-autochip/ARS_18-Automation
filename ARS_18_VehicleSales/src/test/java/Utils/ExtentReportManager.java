package Utils;
import Base.BrowserSetup;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    String repName;

    // Set your desired folder path for report storage
    public static final String REPORT_FOLDER_PATH =
            "C:\\Users\\autoc\\IdeaProjects\\ARS_18_VehicleSales\\Reports";

    public void onStart(ITestContext testContext) {
        // Create timestamped report name
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName = "Test-Report-" + timeStamp + ".html";

        // Ensure folder exists
        File reportDir = new File(REPORT_FOLDER_PATH);
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }

        // Set up ExtentSparkReporter
        String reportFilePath = REPORT_FOLDER_PATH + File.separator + repName;
        sparkReporter = new ExtentSparkReporter(reportFilePath);

        // Report configuration
        sparkReporter.config().setDocumentTitle("Automation Execution Report");
        sparkReporter.config().setReportName("Functional Test Results");
        sparkReporter.config().setTheme(Theme.DARK);

        // Create ExtentReports object
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // System information (basic only)
        extent.setSystemInfo("Executed By","Umesh");
        extent.setSystemInfo("Environment", "ARS18");
    }


    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.PASS, result.getName() + " executed successfully.");
    }


    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, result.getName() + " failed.");
        test.log(Status.INFO, result.getThrowable().getMessage());

        String imgPath = null;
        try {
            imgPath = new BrowserSetup().captureScreen(result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(imgPath);
    }


    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, result.getName() + " was skipped.");
    }


    public void onFinish(ITestContext testContext) {
        extent.flush();

        // Auto-open the report after test execution
        try {
            File htmlReport = new File(REPORT_FOLDER_PATH + File.separator + repName);
            if (htmlReport.exists()) {
                Desktop.getDesktop().browse(htmlReport.toURI());
            } else {
                System.err.println("❌ Report file not found: " + htmlReport.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
