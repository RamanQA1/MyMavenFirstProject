package com.newMethods;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearningClass_1 {
	
	WebDriver driver=null;
	WebDriverWait wait=null;
	
	
	@BeforeClass
	public void beforeClass(@Optional("chrome")String browsersname ) {

//        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();

		
		if(browsersname.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browsersname.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver ();
		}
		else if(browsersname.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			 
//			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
	
		
		
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	
	@Test
      public void registrationPage() {
		

			driver.findElement(By.name("q")).sendKeys("demo.nopcommerce.com" +Keys.ENTER);
			driver.findElement(By.xpath("//h3[text()='nopCommerce demo store']")).click();
			System.out.println(driver.getTitle());
			driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
			boolean display1=driver.findElement(By.xpath("//h1[text()='Register']")).isDisplayed();
		    Assert.assertEquals(display1, true);
			String pageurl= driver.getCurrentUrl();
			assertEquals(pageurl, "https://demo.nopcommerce.com/register?returnUrl=%2F");
			driver.findElement(By.id("gender-male")).click();
			driver.findElement(By.id("FirstName")).sendKeys("Raman");
			driver.findElement(By.id("LastName")).sendKeys("Thakur");
			
			Select sel= new Select(driver.findElement(By.name("DateOfBirthDay")));
			sel.selectByValue("21");
			 sel= new Select(driver.findElement(By.name("DateOfBirthMonth")));
			sel.selectByValue("3");
			 sel= new Select(driver.findElement(By.name("DateOfBirthYear")));
			sel.selectByValue("1993");
			
			driver.findElement(By.id("Email")).sendKeys("raman123@gmail.com");
			driver.findElement(By.id("Company")).sendKeys("I3inosoft");
			driver.findElement(By.id("Password")).sendKeys("Raman1122");
			driver.findElement(By.id("ConfirmPassword")).sendKeys("Raman1122");
			driver.findElement(By.id("register-button")).click();
			boolean display2=driver.findElement(By.xpath("//div[text()='Your registration completed']")).isDisplayed();
			assertEquals(display2,true);
//			driver.quit();
			
			
	}
	
	@Test
	public void loginPage() {
		
		driver.findElement(By.name("q")).sendKeys("demo.nopcommerce.com" +Keys.ENTER);
		driver.findElement(By.xpath("//h3[text()='nopCommerce demo store']")).click();
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		System.out.println(driver.getTitle());
		String expectedTitle="nopCommerce demo store. Login";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
		boolean display= driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']")).isDisplayed();
		assertEquals(display, true);
		driver.findElement(By.id("Email")).sendKeys("ramgmail.com");
		driver.findElement(By.id("Password")).sendKeys("Raman1122");
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		
		SoftAssert softassert=new SoftAssert();
		
		// Error msg validation
		String actualmsg= driver.findElement(By.id("Email-error")).getText();
		String expectedmsg="Wrong emai"; //assert fail
		softassert.assertEquals(actualmsg, expectedmsg);
		
		// Border Validation
		String actualborder= driver.findElement(By.id("Email")).getCssValue("border");
		String expectedborder="0.8px solid rgb(204, 204, 204)"; //convert hex value to rgb by google
		softassert.assertEquals(actualborder,expectedborder);
		
		driver.quit();
		softassert.assertAll();  // it will throw exception in end when assertion is failed.
	}
	
	

}
