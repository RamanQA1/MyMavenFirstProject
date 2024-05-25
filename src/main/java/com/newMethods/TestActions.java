package com.newMethods;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestActions {

	WebDriver driver = null;
	WebDriverWait wait = null;

	@Parameters("browsersname")
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browsersname) {

		WebDriverManager.chromedriver().setup();

		if (browsersname.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browsersname.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browsersname.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {

			driver = new ChromeDriver();
		}

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void testDraggable() throws InterruptedException {

//		driver.findElement(By.xpath("//a[text()='Draggable']")).click();  [it also work]
		driver.findElement(By.linkText("Draggable")).click();
		
		// To find out how many iframes are present in the page.
		// use Size() methode and print..
		//System.out.println(driver.findElements(By.tagName("iframe")).size());

		driver.switchTo().frame(0);
		WebElement source = driver.findElement(By.id("draggable"));
		Actions action = new Actions(driver);
//		Thread.sleep(3000);
//		action.contextClick(source).build().perform();  //Perform Right Click Action....
		Thread.sleep(3000);
		action.dragAndDropBy(source, 160, 190).build().perform();
		driver.quit();
		// Important Note: if you perform actions outside the iframe after you complete your work in iframes 
		// you need to switch the default window.
		// Syntax is= driver.switchTo().defaultContent();

	}

	@Test
	public void testdropable() {

		driver.findElement(By.linkText("Droppable")).click();
		driver.switchTo().frame(0);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		String actual = source.getText();
		assertEquals(actual, "Drag me to my target");
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();
		driver.quit();
	}

	@Test
	public void resizable() {

		driver.findElement(By.linkText("Resizable")).click();
		driver.switchTo().frame(0);
//		[very important xpath Below]
		WebElement source = driver.findElement(By.xpath("//*[@style =\"z-index: 90;\"][3]"));
		Actions action = new Actions(driver);

		action.clickAndHold(source).moveByOffset(100, 160).release().perform();
		driver.quit();
	}

	@Test
	public void testSelectable() {

		driver.findElement(By.linkText("Selectable")).click();
		driver.switchTo().frame(0);
		WebElement two = driver.findElement(By.xpath("//li[text()=\"Item 2\"]"));
		WebElement four = driver.findElement(By.xpath("//li[text()=\"Item 4\"]"));
		WebElement six = driver.findElement(By.xpath("//li[text()=\"Item 6\"]"));
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).click(two).click(four).click(six).build().perform();
		boolean highlight = driver.findElement(By.cssSelector("li.ui-selected")).isEnabled();
		Assert.assertEquals(highlight, true);
		driver.quit();
	}

	@Test

	public void testMenu() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.linkText("Menu")).click();
		driver.switchTo().frame(0);
		WebElement mainmenu = driver.findElement(By.id("ui-id-9"));
		WebElement submenu = driver.findElement(By.id("ui-id-10"));

		Actions action = new Actions(driver);
		action.moveToElement(mainmenu).pause(Duration.ofSeconds(2)).moveToElement(submenu).build().perform();

		boolean highlight = driver.findElement(By.cssSelector("div.ui-state-active")).isEnabled();
		Assert.assertEquals(highlight, true);
		driver.quit();
	}

	@Test(description = "Assert use ? ")
	public void datepicker() {
		driver.get("https://jqueryui.com");
		driver.findElement(By.xpath("//a[text() =\"Datepicker\"]")).click();

		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();

		while (true) {

			WebElement month = driver.findElement(By.className("ui-datepicker-month"));
			WebElement year = driver.findElement(By.className("ui-datepicker-year"));

			if (month.equals("February") && year.equals("2022")) {

				driver.findElement(By.xpath("//a[@data-date='21']")).click();
				break;

			}

			else {

				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			}

		}

	}

	@Test
	public void testFileUpload() throws IOException {

		driver.get("https://demo.guru99.com/test/upload/");
		driver.findElement(By.id("uploadfile_0")).sendKeys("C:\\Users\\Shivam\\OneDrive\\Documents\\BrokenUrl.java");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("submitbutton")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//center[text()='has been successfully uploaded.']")));
		boolean successmsg = driver.findElement(By.xpath("//center[text()='has been successfully uploaded.']"))
				.isDisplayed();
		Assert.assertEquals(successmsg, true);
//		
//		 // Convert web driver object to TakeScreenshot  // 1 method
//		TakesScreenshot scrShot = ((TakesScreenshot) driver);  // chromedriver 100 method --> 1 
//		
//		// Call getScreenshotAs method to create image file
//		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//
//		String fileWithPath = "./Screenshot/image-2.jpeg";
//		// Move image file to new destination
//		File DestFile = new File(fileWithPath);
//		// Copy file at destination
//		FileUtils.copyFile(SrcFile, DestFile);	
//		

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/img1.jpg");

		FileUtils.copyFile(sourceFile, destFile);
		System.out.println("Screenshot saved successfully");

	}

	@Test
	public void priceRangeSlider() throws IOException {

		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		WebElement min_slider = driver.findElement(By.xpath("//span[1]"));

		System.out.println("Location of min slider" + min_slider.getLocation()); // (59, 250)
		System.out.println("Height and width of min slider" + min_slider.getSize()); // (21, 21)

		Actions action = new Actions(driver);
		action.dragAndDropBy(min_slider, 100, 0).build().perform();

		System.out.println("Location of min slider" + min_slider.getLocation());

		WebElement max_slider = driver.findElement(By.xpath("//span[2]"));
		action.dragAndDropBy(max_slider, -100, 0).build().perform();

		TakesScreenshot shot = (TakesScreenshot) driver;
		File source = shot.getScreenshotAs(OutputType.FILE);
		File destination = new File("./AllScreenshots/image2.jpg");
		FileUtils.copyFile(source, destination);

		System.out.println("Screenshot Sucessful taken");

	}

	@Test
	public void testTooltip() throws IOException {
		driver.findElement(By.linkText("Tooltip")).click();
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

		String attr = driver.findElement(By.id("age")).getAttribute("title");

		Assert.assertEquals(attr, "We ask for your age only for statistical purposes.");

		String text = driver.findElement(By.xpath("//body/p[5]")).getText();

		Assert.assertEquals(text, "Hover the field to see the tooltip.");

		driver.findElement(By.id("age")).sendKeys("25");
	}

}
