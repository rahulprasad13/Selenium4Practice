package Selenium4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumFeatures {
	
	//@Test
	public void screenshotTest() throws IOException{
		
		//You can take screenshots of specific elements
		//You can open new tabs
		//You can open new windows
		//You can capture the location of webpage using getRect() method
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/");
		driver.manage().window().maximize();
		
		WebElement logo=driver.findElement(By.xpath("//img[@class='nav-logo']"));
		
		
		File SrcFile=logo.getScreenshotAs(OutputType.FILE);
		File destFile=new File("logo.png");
		FileUtils.copyFile(SrcFile, destFile);
		driver.quit();
		
		}
	//@Test
	public void openNewTab() throws InterruptedException{
		
WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/");
		Thread.sleep(3000);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://alto-qa.kinesso-apps.com");
		driver.quit();		
		
	}
	
	//@Test
	public void openNewWindow() throws InterruptedException{
		
WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/");
		Thread.sleep(3000);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.navigate().to("https://alto-qa.kinesso-apps.com");
		driver.quit();
	}
	
	@Test
	public void Location() throws InterruptedException{
		
WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/");
		driver.manage().window().maximize();



		//Workaround to minimize the window
		//driver.manage().window().setPosition(new Point(-2000, 0));
		
		WebElement logo=driver.findElement(By.xpath("//img[@class='nav-logo']"));
		
		System.out.println("Height"+logo.getRect().getDimension().getHeight());
		System.out.println("Width"+logo.getRect().getDimension().getWidth());
		System.out.println("X Location"+logo.getRect().getX());
		System.out.println("Y Location"+logo.getRect().getY());
		driver.quit();
		
		
		
	}
}
