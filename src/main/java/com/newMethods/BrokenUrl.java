package com.newMethods;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BrokenUrl {
	

	WebDriver driver=null;
	WebDriverWait wait=null;
	
	@Parameters("browsersname")
	@BeforeClass
	public void beforeClass(@Optional("chrome")String browsersname ) {
		
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
//		Hack Code for run chrome browser in  latest version 111
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		
		if(browsersname.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(co);
		}
		else if(browsersname.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver ();
		}
		else if(browsersname.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			 
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
	
		
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://demo.nopcommerce.com/");
		//driver.get("https://www.google.co.in/");	
		driver.manage().window().maximize();
	}
	
	@Test
	public void testBrokenUrl() {
		
		Response response=null;
		
		List<WebElement> anchors =driver.findElements(By.xpath("//a"));
		
		 for (WebElement webElement : anchors) {
			 
			String url =webElement.getAttribute("href");
//			System.out.println(url);
		
			
			response=RestAssured.given().get(url);
			
			if(response.getStatusCode()==200) {
				System.out.println("Unbroken url : " +url);
			}
			
			else{
				System.out.println("Broken url : " +url);
				assertEquals(response.getStatusCode(),200);
				
				
			}
			
			
		}
		
	}

}
