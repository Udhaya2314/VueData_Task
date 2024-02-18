package TaskCase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoBOSS {
	
	public static WebElement goboss(WebDriver driver) {
		WebElement bosslocation = driver.findElement(By.xpath("//h3[text()='Go-BOSS']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", bosslocation);
		return bosslocation;
	}

	public static WebElement readmoreclick(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		WebElement readmorelocation = driver.findElement(By.xpath("//a[@href='https://www.go-boss.com/'][normalize-space()='Learn More']"));
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("arguments[0].scrollIntoView(true)", readmorelocation);
		System.out.println(driver.getTitle());
		return readmorelocation;
	}
	
	public static WebElement requestdemo(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("(//a[@href='index.html#registerSubmit'][text()='Request a demo'])[2]")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Udhaya");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Karthik");
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("udhaya12we3@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9834123456");
		driver.findElement(By.xpath("//input[@placeholder='Company Name']")).sendKeys("Vue_Data");
		List<WebElement> jobrole= driver.findElements(By.xpath("//select[@id='roles']"));
		for(WebElement element:jobrole) {
			System.out.println(element.getText());
		}
		WebElement selectrole = driver.findElement(By.xpath("//select[@id='roles']"));
		Select dropdown = new Select(selectrole);
		dropdown.selectByIndex(2);
		List<WebElement> country= driver.findElements(By.xpath("//select[@id='country']"));
		for(WebElement elements:country) {
			System.out.println(elements.getText());
		}
		WebElement selectcountry = driver.findElement(By.xpath("//select[@id='country']"));
		Select countrydropdown = new Select(selectcountry);
		countrydropdown.selectByIndex(2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
//		submitbtn.click();
//		Duration duration = Duration.ofSeconds(5);
//		 WebDriverWait wait = new WebDriverWait(driver, duration);
//	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(((By)submitbtn)));
//	        wait.until(ExpectedConditions.elementToBeClickable(element));
//	        element.click();
	       
		return null;
	}
}
