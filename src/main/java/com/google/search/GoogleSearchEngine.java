package com.google.search;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchEngine {

	WebDriver driver = null;
	WebDriverWait wait = null;

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Parameters("browsersname")
	@BeforeClass
	public void beforeClass(String browsersname) {

		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();

		if (browsersname.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browsersname.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browsersname.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else {

			driver = new ChromeDriver();
		}

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test(description = "All test cases working fine")
	public void googleSearch() throws InterruptedException {

//		driver.findElement(By.name("q")).sendKeys("Selenium" +Keys.ENTER);
		driver.findElement(By.name("q")).sendKeys("Selenium");
//		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("btnK")));
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.xpath("//h3[text()=\"Selenium\"]")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h1[text()=\"Selenium automates browsers. That's it!\"]")));
		System.out.println(driver.getCurrentUrl());  // for printing url on console
		String pageurl = driver.getCurrentUrl();  // for assertion the page url..
		assertEquals(pageurl, "https://www.selenium.dev/");
		boolean display = driver.findElement(By.xpath("//h1[text()=\"Selenium automates browsers. That's it!\"]"))
				.isDisplayed();
		assertEquals(display, true);
		driver.findElement(By.className("DocSearch-Button-Placeholder")).click();
		driver.findElement(By.id("docsearch-input")).sendKeys("Grid");
//		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mark[text()='Grid']")));
		driver.findElement(By.xpath("//mark[text()='Grid']")).click();
		String gurl = driver.getCurrentUrl();
		assertEquals(gurl, "https://www.selenium.dev/documentation/grid/");
		boolean display1 = driver.findElement(By.xpath("//h1[text()=\"Grid\"]")).isDisplayed();
		assertEquals(display1, true);

		driver.navigate().back();
		assertEquals(pageurl, "https://www.selenium.dev/");

//		Thread.sleep(1000);
		driver.navigate().refresh();
		assertEquals(pageurl, "https://www.selenium.dev/");

//		Thread.sleep(1000);
		driver.navigate().forward();
		assertEquals(gurl, "https://www.selenium.dev/documentation/grid/");

//		Thread.sleep(1000);
		driver.findElement(By.id("Layer_1")).click();
		assertEquals(pageurl, "https://www.selenium.dev/");

	}

}
