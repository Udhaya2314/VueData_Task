package TaskCase;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageTask extends GoBOSS {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		System.out.println("The browser is launched successfully");
		driver.get("https://www.vuedata.com/index.html");
		System.out.println("The url is launched successfully");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		PageFactory.initElements(driver, GoBOSS.class);
		System.out.println(GoBOSS.goboss(driver).getAttribute("class"));
		GoBOSS.readmoreclick(driver).click();
		GoBOSS.requestdemo(driver);
		driver.navigate().to("https://www.vuedata.com/index.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		
		PageFactory.initElements(driver, dbDass.class);
		dbDass.db_dassview(driver);
		dbDass.db_dassactions(driver);
		
		JavascriptExecutor jexecutor = (JavascriptExecutor)driver;
		jexecutor.executeScript("window.open('https://in.linkedin.com/', '_blank');");
		String linkedinwindow = driver.getWindowHandle();
		Set<String> linkedinwindows = driver.getWindowHandles();
		for(String allwindows:linkedinwindows) {
			driver.switchTo().window(allwindows);
		}
		PageFactory.initElements(driver, Linkedin_Actions.class);
		Linkedin_Actions.linkedinlogin(driver);
		Linkedin_Actions.companyprofile(driver);
//		Linkedin_Actions.applyjob(driver);
		
		driver.switchTo().window(linkedinwindow);
	
	}

}
