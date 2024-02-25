package FlipkartTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Flipkart.OrderProductPage;
import RahulShettyAcademy.TestComponents.FlipkartBase;


public class OrderTest extends FlipkartBase {
	
	WebDriver driver = startDriver();
	
	@Test
	public void findLowestPriceProduct() throws InterruptedException {
		OrderProductPage orderProduct = new OrderProductPage(driver);
		orderProduct.sortProductsList("phone");
		orderProduct.getProductListPrice();
		orderProduct.fnGetSecondLowestInPrice();
	}
}
