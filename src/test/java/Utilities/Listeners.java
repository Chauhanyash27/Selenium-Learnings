package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import static Utilities.Base.driver;

public class Listeners implements ITestListener  {

    public ExtentReports extentReports;
    public ExtentSparkReporter sparkReporter;
    public ExtentTest extentTest;

    public void onStart(ITestContext context) {
        extentReports = new ExtentReports();
        sparkReporter = new ExtentSparkReporter("./Reports/TestReport.html");
        sparkReporter.config().setDocumentTitle("Testing Report");
        sparkReporter.config().setReportName("NopCommerce Testing Report");
        sparkReporter.config().setTheme(Theme.DARK);
        extentReports.attachReporter(sparkReporter);
    }

    public void onTestSuccess(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.PASS,"Test Case PASSED");
    }

    public void onTestFailure(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.FAIL,"Test Case FAILED");
        String screenshotCode = captureScreenshot();
        extentTest.addScreenCaptureFromBase64String(screenshotCode,"Screenshot for failure");
        extentTest.fail(result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.SKIP,"Test Case Skipped");
    }

    public void onFinish(ITestContext context){
        extentReports.flush();
    }

    public String captureScreenshot() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        String imgBase64Code = takesScreenshot.getScreenshotAs(OutputType.BASE64);
        return imgBase64Code;
    }
}
