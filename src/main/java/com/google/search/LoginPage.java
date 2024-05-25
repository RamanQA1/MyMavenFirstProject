package com.google.search;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {

	

	@Test(dataProvider = "Cred", dataProviderClass = ExcelDataSupllier.class)
	public void login(String UserName, String Password) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys(UserName);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		boolean disp=driver.findElement(By.xpath("//span[@class=\"oxd-topbar-header-breadcrumb\"]//h6")).isDisplayed();
		Assert.assertEquals(disp,true);
		
		String validURL=driver.getCurrentUrl();
		assertEquals(validURL,"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		Thread.sleep(5000);
		driver.quit();

	}

}
