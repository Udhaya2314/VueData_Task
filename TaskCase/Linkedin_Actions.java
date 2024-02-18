package TaskCase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import net.bytebuddy.asm.Advice.Enter;

public class Linkedin_Actions {
	
	public static WebElement linkedinlogin(WebDriver driver) throws InterruptedException {
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		WebElement clickgoogle = driver.findElement(By.xpath("//span[@class='nsm7Bb-HzV7m-LgbsSe-BPrWId']"));
//		jse.executeScript("arguments[0].scrollIntoView(true)", clickgoogle);
//		clickgoogle.click();
//		String loginwindow = driver.getWindowHandle();
//		Set<String> loginwindows = driver.getWindowHandles();
//		for(String allwindows:loginwindows) {
//			driver.switchTo().window(allwindows);
//		}
//		driver.findElement(By.xpath("//div[normalize-space()='Udhaya Karthik']")).click();
//		System.out.println(driver.getTitle());
		
		
		driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("ukspart55@gmail.com");
		driver.findElement(By.xpath("//input[@autocomplete='current-password']")).sendKeys("udhaya2134");
		driver.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']")).click();
		
		WebElement jobsearchfield = driver.findElement(By.xpath("//input[@class='search-global-typeahead__input']"));
		jobsearchfield.sendKeys("VueData");
		jobsearchfield.sendKeys(Keys.ENTER);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[@role='link'][normalize-space()='Jobs']")).click();
		return null;		
	}
	
	public static WebElement companyprofile(WebDriver driver) throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//a[@class='app-aware-link '][normalize-space()='VueData']")).click();
		driver.findElement(By.xpath("(//a[starts-with(@id, 'ember')])[6] ")).click();
		TakesScreenshot shot = (TakesScreenshot)driver;
		File sourcefile = shot.getScreenshotAs(OutputType.FILE);
		File destinationfile = new File("C:\\Udhaya Selinium\\Selinium WorkSpace\\LearningSelenium\\Output_Screenshots\\Jobs.png");
		FileHandler.copy(sourcefile, destinationfile);
		if(destinationfile.exists()) {
			System.out.println("The jobs screesnhot is exist please verify that for the later use");
		}
		else {
			System.out.println("Please check on the source file whether the screenshot is taken or not");
		}
		WebElement jobalert = driver.findElement(By.xpath("//span[text()='Create job alert']"));
		if(jobalert.isDisplayed()) {
			jobalert.click();
			String linkedintab = driver.getWindowHandle();
			Set<String> jobalerttab = driver.getWindowHandles();
			for(String tabs:jobalerttab) {
				driver.switchTo().window(tabs);
			}
			Thread.sleep(1000);
			WebElement jobtitle = driver.findElement(By.xpath("//input[@placeholder='Job title (ex: Retail Sales Manager)']"));
			jobtitle.sendKeys("RPA Engineer");
			Thread.sleep(1000);
			jobtitle.sendKeys(Keys.DOWN);
			Thread.sleep(1000);
			jobtitle.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			WebElement location = driver.findElement(By.xpath("//input[@placeholder='Job location (ex: City, state, zip code or country)'] "));
			location.sendKeys("Chennai");
			Thread.sleep(1000);
			location.sendKeys(Keys.DOWN);
			Thread.sleep(1000);
			location.sendKeys(Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
			//driver.findElement(By.xpath("//span[text()='Hybrid']")).click();
			driver.findElement(By.xpath("(//span[@class='artdeco-button__text'][text()='Create job alert'])[1]")).click();
		}
		else {
			System.out.println("The Create JOB ALERT is not displayed, please check the posted jobs");
		}
		return null;
	}
	
	public static WebElement applyjob(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement imglink = driver.findElement(By.xpath("(//img[starts-with(@id, 'ember')])[3]"));
		imglink.click();
		String imagesrc = imglink.getAttribute("src");
		System.out.println(imagesrc);
		String actuallink = "https://media.licdn.com/dms/image/C560BAQExiTWvp4kvYQ/company-logo_100_100/0/1649949268672/vuedata_logo?e=1715212800&amp;v=beta&amp;t=oNJabElkGCyMRTgCUL3_wjOlZHEET2vfCocSNkzse30";
		if(imagesrc.contains(actuallink)) {
			System.out.println("The link taken from the Website is matched perfectly proceed with the next steps");
//			driver.findElement(By.xpath("(//img[starts-with(@id, 'ember')])[3]")).click();
		}
		else {
			System.err.println("The link is not equal please check on the actual link and imagesrc");
		}
		WebElement status = driver.findElement(By.xpath("//a[@href='/jobs/tracker/applied/'][text()='See application']"));
		String applystatus = status.getText();
		System.out.println(applystatus);
		
		if(applystatus.contains("See Application")) {
			System.out.println("The Job is already applied so please check for the other jobs");
		}
		else {
			System.out.println("There is an arrival of new job so please apply for it");
			driver.findElement(By.xpath("//button[@id='ember1850']//span[@class='artdeco-button__text'][normalize-space()='Easy Apply']")).click();
		}
		return null;
		
	}

}
