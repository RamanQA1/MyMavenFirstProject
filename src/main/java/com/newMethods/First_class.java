package com.newMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class First_class {
	
	@Test
	public void DynamicTable() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Shivam/OneDrive/Documents/MyTestingSite.html");
		
		int XX =driver.findElements(By.xpath("//table[@border=\"1\"]//tr")).size();//Give number of rows in table...
		
		System.out.println(XX);
		
		int XC=driver.findElements(By.xpath("//table[@border=\"1\"]//tr[1]//th")).size();//Give Column Size....
		System.out.println(XC);
		
		driver.findElement(By.xpath("//td[text()=\"Pooja\"]/following-sibling::td[2][text()=\"QA\"]")).click();
		
		
	}
	
	

}
