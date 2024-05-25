package com.newMethods;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectTest {
	

	WebDriver driver=null;
	WebDriverWait wait=null;
	
	@Parameters("browsersname")
	@BeforeClass
	public void beforeClass(@Optional("firefox")String browsersname ) {
		
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
		
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.get("file:///C:/Users/Shivam/OneDrive/Documents/SelectSite.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test
	public void testSelectOption() throws InterruptedException {
		
		WebElement ele=driver.findElement(By.id("pet-select"));
		
		Select sel= new Select(ele);
		
		sel.selectByVisibleText("Cat");
		System.out.println(sel.getFirstSelectedOption().getText()); // it will print selected value..
//		Thread.sleep(2000);
//		sel.selectByIndex(4);
//		Thread.sleep(2000);
//        sel.selectByValue("goldfish");
		
		}
	
	@Test
	public void testAlertPopupWindow() {
		
		driver.findElement(By.xpath("//input[@value=\"Click me\"]")).click();
		Alert alert = driver.switchTo().alert();
		String alertDisplay=alert.getText();
		assertEquals(alertDisplay,"This is an alert dialog box");
		alert.accept();
		alert.dismiss();
//		driver.findElement(By.xpath("//input[@value=\"Click me\"]")).click();
		
		
		
	}

}
