package com.newMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWindowHandles_2 {
	
	@Test
	public void handleBrowserWindows() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.freecodecamp.org/news/how-to-use-html-to-open-link-in-new-tab/");
		String oneWindowId =driver.getWindowHandle();
		
		
		driver.findElement(By.xpath("//a[text()='freeCodeCamp'][@target='_blank']")).click();
		
		Set<String> windowsIDs=driver.getWindowHandles();
		
		ArrayList<String> windowIDsList=new ArrayList(windowsIDs);
		
		String parentWindow=windowIDsList.get(0);
		String childWindow=windowIDsList.get(1);
		
		System.out.println( parentWindow);
		System.out.println( childWindow);
		
		driver.switchTo().window(childWindow);
		
		driver.findElement(By.xpath("//span[@class='login-btn-text'][text()='Sign in']")).click();
		  boolean display = driver.findElement(By.id("email")).isDisplayed();
		Assert.assertEquals(display, true);
		
		driver.close();
		
		
		
	}

}
