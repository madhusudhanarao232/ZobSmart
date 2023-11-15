package SeleniumScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Booking {
	@Test
	public void booking() throws InterruptedException {
		// disabling the notifications
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		// set up chrome browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(option);
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// login to booking.com
		driver.get("https://www.booking.com/");
		Actions action=new Actions(driver);
		// perform click operation
		Thread.sleep(2000);
		action.click().perform();
		// Entering Where are you going? details
		WebElement place = driver.findElement(By.xpath("//input[@name='ss']"));
		place.sendKeys("bangalore");

		//entering date   
		WebElement dateicon = driver.findElement(By.xpath("//div[@data-testid='searchbox-dates-container']/span[@aria-hidden]"));

		action.click(dateicon).perform();
		// Selecting Check in Date
		driver.findElement(By.xpath("//span[@aria-label='11 November 2023']")).click();
		// Selecting Check out Date
		driver.findElement(By.xpath("//span[@aria-label='12 November 2023']")).click();

		//selecting child from drop down
		driver.findElement(By.xpath("//button[@data-testid='occupancy-config']")).click();
		// adding a child
		driver.findElement(By.xpath("//label[text()='Children']/ancestor::div[@class='a7a72174b8']//button[contains(@class,'f4d78af12a')]")).click();
		WebElement age = driver.findElement(By.xpath("//select[@name='age']"));
		Select s=new Select(age);
		s.selectByValue("5");
		// click on done button
		//driver.findElement(By.xpath("//span[text()='Done']/parent::button")).click();
		// click on Search button
		driver.findElement(By.xpath("//span[text()='Search']/parent::button")).click();

		// Assertion
		String exp="properties found";
		WebElement act = driver.findElement(By.xpath("//div/h1"));
		Assert.assertEquals(act.getText().contains(exp), true,"\u001B[1m"+"\u001B[31m"+" FAILED........"+"\u001B[0m");
		System.out.println("\u001B[1m"+"\u001B[32m"+"Assertion is PASSED........."+"\u001B[0m");
		driver.close();
	}
	//}
	//org.openqa.selenium.ElementClickInterceptedException
	@Test
	public void main() 
	{ 
		System.out.println('j' + 'a' + 'v' + 'a'); 
	} 

	@Test
	public void Code(){
		Integer num1 = 127; // 100 ---> 0 is op    	-128 to 127 the byte range
		Integer num2 = 127; // up to 127 0 is the op

		if(num1 == num2){
			System.out.println(0);
		}
		else{
			System.out.println(1);
		}
	}
	@Test
	public void check() {
		String s1 = "Java";  
		String s2 = "Java";  
		StringBuilder sb1 = new StringBuilder();  
		sb1.append("Ja").append("va");  
		System.out.println(s1 == s2);  
		System.out.println(s1.equals(s2));  
		System.out.println(sb1.toString() == s1);  
		System.out.println(sb1.toString().equals(s1));
	}
}