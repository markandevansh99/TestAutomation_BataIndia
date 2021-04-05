

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class InsideBata{

	String baseUrl="https://www.bata.in/";
	String driverPath="C:\\\\\\\\Users\\\\\\\\91935\\\\\\\\Desktop\\\\\\\\chromedriver.exe";
	WebDriver driver;		//these variables should be declared outside any test function to be accessible everywhere in class
	static ExtentReports report = new ExtentReports("C:\\\\Users\\\\91935\\\\Documents\\\\SEM-6\\\\Test Automation\\\\BataReport_forSearchingItems.html");
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
	public static void startReport1(Method result)
	{
		test = report.startTest("BataReport - " + result.getName());
	}
	
	@Test(priority=1)
	public void Searchinput(){
		  driver.findElement(By.id("keywordText")).sendKeys("White sneakers for men");
		  test.log(LogStatus.INFO,"Sending data to be searched");
			if(driver.findElement(By.id("keywordText")) != null) {
				test.log(LogStatus.PASS,"Test Passed! Searched! ");
			}
			else {
				test.log(LogStatus.FAIL,"Searching failed!");
			}
	}
	
	@Test(priority=2)
	public void searchingrequiredproduct(){

		driver.findElement(By.id("txtSearchBtn")).click();
		test.log(LogStatus.INFO,"Clicking on Search");
		if(driver.findElement(By.id("txtSearchBtn")) != null) {
			test.log(LogStatus.PASS,"Search is successful. Result is displayed!");
		}
		else {
			test.log(LogStatus.FAIL,"Search is not displayed! Failed!");
		}
	}
	
	@Test(priority=3)
	public void SelectShoes(){

		driver.findElement(By.id("pageUrl_1465235")).click();
		test.log(LogStatus.INFO,"Selecting a pair of shoes.");
		if(driver.findElement(By.id("pageUrl_1465235")) != null) {
			test.log(LogStatus.PASS,"White Sneakers is searched! Successful!");
		}
		else {
			test.log(LogStatus.FAIL,"White Sneakers not displayed! Unsuccessful!");
		}
	}
	
	@Test(priority=4)
	public void ImagevisibilityCheck(){

		 WebElement photo =  driver.findElement(By.id("img-zoom"));
		  photo.isEnabled();
		  test.log(LogStatus.INFO,"Checking Shoes Image");
			if(driver.findElement(By.id("img-zoom")) != null) {
				test.log(LogStatus.PASS,"Shoes Image is there!");
			}
			else {
				test.log(LogStatus.FAIL,"Searching failed!");
			}
	}
	
	@Test(priority=5)
	public void MRPAvailable() {
		boolean isMRPdisplayed = driver.findElement(By.id("priceWithisDiscdisplayY")).isDisplayed();
		System.out.println(isMRPdisplayed);
		test.log(LogStatus.INFO,"Checking if MRP is present!");
		if(driver.findElement(By.id("priceWithisDiscdisplayY")) != null) {
			test.log(LogStatus.PASS,"MRP of Sneakers is visible!");
		}
		else {
			test.log(LogStatus.FAIL,"Failed! MRP is not visible!");
		}
	}
	
	@Test(priority=6)
	public void AddtoCartAvailable() {
		WebElement isAddtoCartdisplayed = driver.findElement(By.id("sapAddToCartBtn"));
		isAddtoCartdisplayed.isEnabled();
		test.log(LogStatus.INFO,"Checking if Add to Cart option is valid!");
		if(driver.findElement(By.id("sapAddToCartBtn")) != null) {
			test.log(LogStatus.PASS,"Passed! Add to Cart option is running!");
		}
		else {
			test.log(LogStatus.FAIL,"Failed! Unsuccessful.");
		}
	}
	
	
	@Test(priority=7)
	public void SizeSelect(){
		  WebElement sizeselect =  driver.findElement(By.id("size_1688396_8891043080_03932_5017X999"));
		  sizeselect.click();
		  test.log(LogStatus.INFO,"Clicking size of the shoes");
			if(driver.findElement(By.id("size_1688396_8891043080_03932_5017X999")) != null) {
				test.log(LogStatus.PASS,"Shoes size is picked!");
			}
			else {
				test.log(LogStatus.FAIL,"Shoe size is not picked! Unsuccessful.");
			}
	}
	
	@Test(priority=8)
	public void AddingtoCart(){
		  WebElement cartadd =  driver.findElement(By.id("sapAddToCartBtn"));
		  cartadd.click();
		  test.log(LogStatus.INFO,"Add the selected shoes to the Cart");
			if(driver.findElement(By.id("sapAddToCartBtn")) != null) {
				test.log(LogStatus.PASS,"Selected shoes are added to cart!");
			}
			else {
				test.log(LogStatus.FAIL,"Selected shoes are not added to cart! Failed.");
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