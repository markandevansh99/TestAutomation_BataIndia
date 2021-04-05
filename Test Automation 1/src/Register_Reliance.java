import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Register_Reliance {
	
public static void main(String[] args) throws InterruptedException {  
 
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91935\\Desktop\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();  

		  driver.navigate().to("https://www.bata.in/"); 
		  driver.manage().window().maximize();
		  
		   
		  WebElement signup = driver.findElement(By.id("signup"));
		 signup.click();
		  
		  
		  
		 WebElement name = driver.findElement(By.id("regFirstName"));
		 name.sendKeys("Devansh Markan");
		 
		 WebElement email = driver.findElement(By.id("reguserName"));
		 email.sendKeys("500068980@stu.upes.ac.in");
		 
		 
		 WebElement pass = driver.findElement(By.id("regpassword"));
		 pass.sendKeys("devansh");
		 
		 
		 WebElement phone = driver.findElement(By.id("regmobile"));
		 phone.sendKeys("9560383161");
		 
		 WebElement code = driver.findElement(By.id("countryCode"));
		 code.click();
		 
		 code.click();
		 
		 WebElement gender = driver.findElement(By.xpath("//*[@id=\"userRegistrationForm\"]/div[7]/div[1]/label"));
		 gender.click();
		 
		 WebElement otp = driver.findElement(By.id("generateOtp"));
		 otp.click();
		 
		 
		 
		 
	}

}



	
	

