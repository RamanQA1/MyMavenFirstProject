'package com.newMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GridRemoteExecution {
	
	RemoteWebDriver driver=null;
	WebDriverWait wait=null;
	DesiredCapabilities cap=null;
	
	@BeforeClass
	public void beforeClass(@Optional("chrome")String browsersname ) throws MalformedURLException {


		cap = new DesiredCapabilities();
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();

		
		if(browsersname.equalsIgnoreCase("chrome")) {
			ChromeOptions option=new ChromeOptions();
			option.setAcceptInsecureCerts(true);
			option.addArguments("--incognito");
			cap.merge(option);
			
		}
		else if(browsersname.equalsIgnoreCase("edge")) {
			EdgeOptions option=new EdgeOptions();
			option.setAcceptInsecureCerts(true);
			option.addArguments("--incognito");
			cap.merge(option);
		}
		else if(browsersname.equalsIgnoreCase("firefox")) {
			EdgeOptions option=new EdgeOptions();
			option.setAcceptInsecureCerts(true);
			option.addArguments("InPrivate");
			cap.merge(option);
			
		}
		
		driver=new RemoteWebDriver( new URL(""),cap);
		
		
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}

}
