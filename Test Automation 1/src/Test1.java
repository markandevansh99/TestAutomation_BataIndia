
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1 {
	static WebDriver Driver;
	static String baseUrl = "https://www.bata.in/";
	static String driverPath = "C:\\Users\\91935\\Desktop\\chromedriver.exe";
	
	
	public static void main(String args[]) throws IOException{
		FileInputStream fis = new FileInputStream("C:\\Users\\91935\\Downloads\\TestAutomation.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet login = wb.getSheet("Sheet1");
	    System.out.println(login+"login");
		for(int count = 1;count<=login.getLastRowNum();count++)
		{
			XSSFRow row = login.getRow(count);
			String username;
			if ((row.getCell(0).getCellType())== CellType.NUMERIC) {
				username = row.getCell(0).getRawValue();
			}
			else {
				username = row.getCell(0).toString();
			}
			String pwd = row.getCell(1).toString();
			System.out.println("name: " + username + "\npassword:" + pwd);
			runTest(username,pwd);
		}
	}
	
	private static void runTest(String username, String pwd) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",driverPath);
		Driver = new ChromeDriver();
		Driver.get(baseUrl);
		Driver.manage().window().maximize();
		Driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div[2]/div[3]/div/ul/li[4]/div/a[1]")).click();
		WebElement email = Driver.findElement(By.id("loginId"));
		email .sendKeys(username);
		
		WebElement password = Driver.findElement(By.id("password"));
		password .sendKeys(pwd);
		
		WebElement enterr = Driver.findElement(By.id("login_Id"));
		enterr.click();
		
	}

}