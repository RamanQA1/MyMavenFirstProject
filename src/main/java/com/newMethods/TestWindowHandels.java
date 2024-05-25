package com.newMethods;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestWindowHandels {
	

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://www.freecodecamp.org/");	
		driver.get("https://www.freecodecamp.org/news/how-to-use-html-to-open-link-in-new-tab/");	
		driver.manage().window().maximize();

}
	@Test
	public void testWindowHandles() {
		
//		driver.findElement(By.className("login-btn-text")).click();
		
		
//		Dont use this coding go for another coding

		String win1 = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[text()='freeCodeCamp'][@target='_blank']")).click();
		
		Set<String> names =  driver.getWindowHandles(); // it stores unique name 
		
		names.remove(win1);
		
		String win2 = (String) names.toArray()[0];
	
		driver.switchTo().window(win2);
		
		driver.findElement(By.xpath("//span[@class='login-btn-text'][text()='Sign in']")).click();
		  boolean display = driver.findElement(By.id("email")).isDisplayed();
		Assert.assertEquals(display, true);
		
		driver.close();
		
		driver.switchTo().window(win1);
		
	  boolean pdisplay =	driver.findElement(By.id("nav-donate")).isDisplayed();
		Assert.assertEquals(pdisplay, true);
		
		driver.close();
		
	}
	
}
