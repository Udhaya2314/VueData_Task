package TaskCase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart_Task {
	
	@Test
	public void flipkartcase() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		System.out.println("The FLipkart url is launhced successfully in  the  browser");
		TakesScreenshot shot = (TakesScreenshot) driver;
		File sorucefile = shot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("C:\\Users\\rpase\\Pictures\\Screenshot\\Flipkart.png");
		FileHandler.copy(sorucefile, destfile);
		System.out.println(destfile.exists());
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement navigateelement = driver.findElement(By.xpath("//a[text()='Brand Directory']"));
		jse.executeScript("arguments[0].scrollIntoView(true)", navigateelement);
		WebElement gifts = driver.findElement(By.xpath("//a[text()='valentines day gifts']"));
		gifts.click();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		String oldwindow = driver.getWindowHandle();
		jse.executeScript("window.open('https://www.myntra.com/', '_blank');");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Set<String> newwindowhandles = driver.getWindowHandles();
		for(String element:newwindowhandles) {
			driver.switchTo().window(element);
		}
		int windowsize = driver.getWindowHandles().size();
		System.out.println("The number of windows opened is "+ windowsize);
		File sorucefile1 = shot.getScreenshotAs(OutputType.FILE);
		File destfile1 = new File("C:\\Users\\rpase\\Pictures\\Screenshot\\Myntraweb.png");
		FileHandler.copy(sorucefile1, destfile1);
		System.out.println(destfile1.exists());
//		driver.close();
		driver.switchTo().window(oldwindow);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.navigate().back();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//a[text()='Brand Directory']"))).build().perform();
		actions.click(gifts);
		System.out.println("All the actions are performed successfully");
		driver.navigate().refresh();
	}

}
