package Listeners;

import Utils.ExtentReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private final ExtentReportManager reportManager = new ExtentReportManager();


    @Override
    public void onStart(ITestContext context) {
        System.out.println("[INFO] Test suite started: " + context.getName());
        reportManager.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("[INFO] Test suite finished: " + context.getName());
        reportManager.onFinish(context);
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("[INFO] Starting test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("[PASS] " + result.getName());
        reportManager.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("[FAIL] " + result.getName());
        reportManager.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("[SKIP] " + result.getName());
        reportManager.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not commonly used
    }
}
