import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Check_enabled {
	
	String baseUrl="https://www.bata.in/";
	String driverPath="C:\\\\Users\\\\91935\\\\Desktop\\\\chromedriver.exe";
	WebDriver driver;		//these variables should be declared outside any test function to be accessible everywhere in class
	static ExtentReports report = new ExtentReports("C:\\Users\\91935\\Documents\\SEM-6\\Test Automation\\BataReport_forCheckingenabledbuttons.html");
	static ExtentTest test;
	//BeforeTest is executed before test cases
	
	@BeforeTest
	public void browserLaunch(){
		System.setProperty("webdriver.chrome.driver",driverPath);
		driver=new ChromeDriver(); 
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public static void StartingReport(Method result)
	{
		test = report.startTest("BataReport - " + result.getName());
	}
	
	
	
	@Test(priority=1)
	public void CheckMyCart(){
		  WebElement checkingmycart =  driver.findElement(By.linkText("My cart"));
		  checkingmycart.isEnabled();
		  test.log(LogStatus.INFO,"Checking whether My Cart option is enabled or not!");
			if(driver.findElement(By.linkText("My cart")) != null) {
				test.log(LogStatus.PASS,"My Cart option is present");
			}
			else {
				test.log(LogStatus.FAIL,"My Cart Option not working! Failed!");
			}
	}
	
	@Test(priority=2)
	public void SearchBataLogo(){
		  WebElement Batalogo =  driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div[1]/ul/li[2]/a"));
		  Batalogo.isEnabled();
		  test.log(LogStatus.INFO,"Checking Bata Front Page Logo logo");
			if(driver.findElement(By.id("/html/body/div[1]/header/div[1]/div[1]/ul/li[2]/a")) != null) {
				test.log(LogStatus.PASS,"Logo is Present!");
			}
			else {
				test.log(LogStatus.FAIL,"Logo is Missing!");
			}
	}

	@Test(priority=3)
	public void OrderTracking(){
		  WebElement OrderTrackingoption =  driver.findElement(By.linkText("Track order"));
		  OrderTrackingoption.isEnabled();
		  test.log(LogStatus.INFO,"Checking if Order Tracking button is enabled or not!");
			if(driver.findElement(By.linkText("Track order")) != null) {
				test.log(LogStatus.PASS,"Pass! Order Tracking is successfully working!");
			}
			else {
				test.log(LogStatus.FAIL,"Order Tracking option is not working! Resolve it soon!");
			}
	}
	
	@Test(priority=4)
	public void CheckSearchBarExistance(){
		  WebElement checkingSearchBar =  driver.findElement(By.id("keywordText"));
		  checkingSearchBar.isEnabled();
		  test.log(LogStatus.INFO,"Checking Search Box");
			if(driver.findElement(By.id("keywordText")) != null) {
				test.log(LogStatus.PASS,"Search Box is active");
			}
			else {
				test.log(LogStatus.FAIL,"Check failed! Search Box is not working!");
			}
	}

	@Test(priority=5)
	public void CheckBrand(){
		  WebElement checkbrand =  driver.findElement(By.linkText("BRANDS"));
		  checkbrand.isEnabled();
		  test.log(LogStatus.INFO,"Checking Brand Button");
			if(driver.findElement(By.linkText("BRANDS")) != null) {
				test.log(LogStatus.PASS,"Brand button is successfully working!");
			}
			else {
				test.log(LogStatus.FAIL,"Brand is not working!");
			}
	}
	
	@Test(priority=6)
	public void CheckSale(){
		  WebElement checkingsale =  driver.findElement(By.linkText("SALE"));
		  checkingsale.isEnabled();
		  test.log(LogStatus.INFO,"Checking SALE Button");
			if(driver.findElement(By.linkText("SALE")) != null) {
				test.log(LogStatus.PASS,"Check successful! Succesfully working!");
			}
			else {
				test.log(LogStatus.FAIL,"Check failed! Sale Button not working properly!");
			}
	}
	
	@Test(priority=7)
	public void CheckStoreLocator(){
		  WebElement CheckingLocator =  driver.findElement(By.linkText("STORE LOCATOR"));
		  CheckingLocator.isEnabled();
		  test.log(LogStatus.INFO,"Checking Store Locator Button");
			if(driver.findElement(By.linkText("STORE LOCATOR")) != null) {
				test.log(LogStatus.PASS,"Check is successful! Working properly.");
			}                                                                       
			else {
				test.log(LogStatus.FAIL,"Check failed! Button not working!");
			}
	}

	@AfterMethod
	public void endReport1() {
		report.endTest(test);
		report.flush();
	}
	
//	@AfterTest
//	public void destroySession(){
//		driver.close();
//	}
}

	


