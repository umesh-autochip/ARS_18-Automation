package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static Utils.ExtentReportManager.REPORT_FOLDER_PATH;

public class BrowserSetup {
    protected  WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;


    @BeforeSuite
    public void setUpExtent() {
        if (extent == null) {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            String reportPath = REPORT_FOLDER_PATH + File.separator + "Test-Report-" + timeStamp + ".html";

            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setDocumentTitle("Automation Execution Report");
            reporter.config().setReportName("Functional Test Results");
            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Executed By", System.getProperty("user.name"));
            extent.setSystemInfo("Environment", "QA");
        }
    }

    @BeforeClass
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://34.131.129.205:8069/web/login?redirect=%2Fodoo%3F");
        //test = extent.createTest(method.getName());
    }
    @BeforeMethod
    public void createTest(Method method) {
        test = extent.createTest(method.getName());
    }
/*
    @AfterMethod
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
                String screenshotPath = captureScreen(result.getName());
                test.addScreenCaptureFromPath(screenshotPath);
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                test.log(Status.PASS, "Test Passed");
            } else {
                test.log(Status.SKIP, "Test Skipped");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   @AfterClass
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }*/

    @AfterSuite
    public void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }


    public String captureScreen(String testName) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String screenshotDir = REPORT_FOLDER_PATH + File.separator + "Screenshots";
        File dir = new File(screenshotDir);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filePath = screenshotDir + File.separator + testName + "_" + timeStamp + ".png";
        FileHandler.copy(srcFile, new File(filePath));
        return filePath;
    }
}

