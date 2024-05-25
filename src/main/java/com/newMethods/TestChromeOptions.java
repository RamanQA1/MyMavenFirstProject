package com.newMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestChromeOptions {
	
	WebDriver driver=null;
	WebDriverWait wait=null;
	
	
	@BeforeClass
	public void beforeClass(@Optional("chrome")String browsersname ) {

		
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();

		
		if(browsersname.equalsIgnoreCase("chrome")) {
			
			ChromeOptions option=new ChromeOptions();
			option.setAcceptInsecureCerts(true);
			option.addArguments("--incognito");
//			option.setHeadless(true);
			
			
			driver = new ChromeDriver(option);
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
	}
	
		@Test
		public void priceRangeSlider() {
			
			driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
			WebElement min_slider=driver.findElement(By.xpath("//span[1]"));
			
			System.out.println("Location of min slider" +min_slider.getLocation()); //(59, 250)
			System.out.println("Height and width of min slider" +min_slider.getSize());  //(21, 21)
			
			Actions action = new Actions(driver);
			action.dragAndDropBy(min_slider, 100, 0).build().perform();
			
			System.out.println("Location of min slider" +min_slider.getLocation());
			
			
			WebElement max_slider=driver.findElement(By.xpath("//span[2]"));
			action.dragAndDropBy(max_slider, -100, 0).build().perform();
			
			
			
		}

	}

