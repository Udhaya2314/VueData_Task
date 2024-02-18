package TaskCase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class dbDass {
	
	public static WebElement db_dassview(WebDriver driver) throws InterruptedException, IOException {
		WebElement dbdass_word = driver.findElement(By.xpath("//h3[text()='DB-DaaS']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", dbdass_word);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='https://www.db-daas.com/'][normalize-space()='Learn More']")).click();
		System.out.println(driver.getTitle());
		TakesScreenshot sshot = (TakesScreenshot)driver;
		File sourcefile = sshot.getScreenshotAs(OutputType.FILE);
		File destinationfile = new File("C:\\Udhaya Selinium\\Selinium WorkSpace\\LearningSelenium\\test-output\\Db_DASS3.png");
		FileHandler.copy(sourcefile, destinationfile);
		if(destinationfile.exists()) {
			System.out.println("The file is succesfully stored in the required path"+ destinationfile);
		}
		else {
			System.err.println("Please check whether the file is stored or not");
		}
		return dbdass_word;
	}
	
	public static WebElement db_dassactions(WebDriver driver) {
		driver.findElement(By.xpath("//a[@href='#buy']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Vidhya");
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Shree");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("shree123@gmail.com");
		driver.findElement(By.xpath("//input[@id='phone_number']")).sendKeys("6383123456");
		driver.findElement(By.xpath("//input[@name='company_name']")).sendKeys("Bla_Bla");
		List<WebElement> dbdaasrole =  driver.findElements(By.xpath("//select[@name='select_role']"));
		for(WebElement roles: dbdaasrole) {
			System.out.println(roles.getText());
		}
		WebElement selectroles = driver.findElement(By.xpath("//select[@name='select_role']"));
		Select select = new Select(selectroles);
		select.selectByIndex(5);
		List<WebElement> dbdaascountry =  driver.findElements(By.xpath("//select[@name='select_country']"));
		for(WebElement country: dbdaascountry) {
			System.out.println(country.getText());
		}
		WebElement selectcountry = driver.findElement(By.xpath("//select[@name='select_country']"));
		Select select_con = new Select(selectcountry);
		select_con.selectByIndex(2);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		return null;
		
	}

}
