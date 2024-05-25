package MyFlipkartProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart_Flow {
	@Test
	public void flipkartCheck() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://pharmeasy.in/");

		driver.findElement(By.xpath("//input[@placeholder='Search medicines/Healthcare products ']")).sendKeys("para");
		List<WebElement> allElements =driver.findElements(By.xpath(
				"//div[@class=\"Typeahead_results__y95O9 MedicineSearch_results__vsEUo MedicineSearch_results--withButton__dXPWq\"]"));
		for (WebElement pp : allElements) {
			String allNames =pp.getText();
			System.out.println(allNames);
			//body/div[@id='__next']/div[@id='mainContainerCT']/div[@class='searchRootMain']/div[@class='searchContainer']/div[@class='searchBx']/div[1]
		}

	}

}
