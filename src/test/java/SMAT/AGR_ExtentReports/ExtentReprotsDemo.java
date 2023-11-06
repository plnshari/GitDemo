package SMAT.AGR_ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReprotsDemo {
	ExtentReports eReport;

	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter esReporter = new ExtentSparkReporter(path);
		esReporter.config().setReportName("Agreements Testing Reports");
		esReporter.config().setDocumentTitle("Agreement ResltS");

		eReport = new ExtentReports();
		eReport.attachReporter(esReporter);
		eReport.setSystemInfo("Tester", "Hari");

	}

	@Test
	public void initialDemo() {
		
	
		ExtentTest test = eReport.createTest("Report Demo");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\plsrihar.old\\Applications - Softwares\\Selenium\\Z_Drivers\\Chrome Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("Results do not match");
		eReport.flush();
	}

}
