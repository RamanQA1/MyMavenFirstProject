package com.google.search;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail_project {

	@Test
	public void railBokking() throws InterruptedException {

		// connecting with webdriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

		// going to erail website, clearing the existing input in text field and
		// entering DEL
		driver.get(" https://erail.in/");
		driver.findElement(By.id("txtStationFrom")).click();
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).clear();
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).sendKeys("DEL");

	 	// finding the fourth element when typing DEL inside the input field, then
		// printing it
		WebElement element = driver.findElement(By.xpath("//div[contains(@id,'Autocomplete_')]/div[4]"));
		String text = element.getText();
		System.out.println("4th element is : " + text);
		element.click();

		// looping all the elements from the drop down list of the "FROM" field and
		// storing them in a list
		List<WebElement> listOfFromFieldElements = driver
				.findElements(By.xpath("//div[contains(@id,'Autocomplete_')]/div"));

		for (WebElement webElement : listOfFromFieldElements) {
			Thread.sleep(3000);
			String allElements = webElement.getText();

			System.out.println( allElements);

		}
		driver.findElement(By.xpath("//input[@title='Select Departure date for availability']")).click();
		driver.findElement(By.xpath("(//td[contains(text(),'26')])[2]")).click();

	}

}
