package com.newMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollActions {
	
	@Test
	public void workHard() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://artoftesting.com/");
		System.out.println(driver.getTitle());
		
	
		JavascriptExecutor jxe=(JavascriptExecutor)driver;
//		jxe.executeScript("window.scrollBy(0,800)");
//		Thread.sleep(2000);
//		jxe.executeScript("window.scrollBy(0,-200)");
//		jxe.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		WebElement source=driver.findElement(By.xpath("//h2[normalize-space()='Popular Tutorials']"));
		jxe.executeScript("arguments[0].scrollIntoView();",source);
		
		
		
	}

}
