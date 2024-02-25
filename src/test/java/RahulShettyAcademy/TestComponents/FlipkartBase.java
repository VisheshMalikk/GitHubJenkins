package RahulShettyAcademy.TestComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Flipkart.OrderProductPage;

public class FlipkartBase {
	
	WebDriver driver;
	OrderProductPage orderProduct;
	
	public WebDriver startDriver() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\AutomationPractice\\ChromeDriver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		return driver;
		
	}
	
	/*
	 * @AfterTest public void tearDown() { driver.quit(); }
	 */

}
