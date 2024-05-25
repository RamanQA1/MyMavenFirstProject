package MyAmazonProject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonShopping {

	@Test
	public void amazon() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

		driver.get("https://www.google.co.in/");
		WebElement xx = driver.findElement(By.name("q"));
		xx.sendKeys("Amazon" + Keys.ENTER);

		driver.findElement(By.xpath("//h3[normalize-space()='Amazon.in']")).click();
		
//		String optionToSelect= "mens jeans pants";
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mens Jeans");
		Thread.sleep(5000);
		
		
		
		// For Dynamic drop down and collect all the elements in drop down
		List<WebElement> hh =driver.findElements(By.xpath("//div[@id=\"nav-flyout-searchAjax\"]"));
		System.out.println(hh.size());
		
		for (WebElement webElement : hh) {
			Thread.sleep(7000);
			String pop = webElement.getText();
		
			System.out.println("pop is : " + pop );
			
			if(pop.contains("mens jeans pants")) {
				Thread.sleep(7000);
				webElement.click();
			System.exit(1);
			}
			
		}
	}
}
		
		
		
		
		
//		driver.findElement(By.xpath("//div[@aria-label='mens jeans']")).click();
//		driver.findElement(By.xpath("//img[@alt=\"Pepe Jeans Men's Regular Jeans\"]")).click();
//
//		Set<String> WindowIds = driver.getWindowHandles();
//
//		ArrayList<String> WindowIdList = new ArrayList(WindowIds);
//		String parentWindow = WindowIdList.get(0);
//		String childWindow = WindowIdList.get(1);
//		
//		driver.switchTo().window(childWindow);
//		driver.findElement(By.id("add-to-cart-button")).click();
//		driver.findElement(By.xpath("//a[@href='/cart?ref_=sw_gtc']")).click();
//		





