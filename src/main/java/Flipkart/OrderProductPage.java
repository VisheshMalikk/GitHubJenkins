package Flipkart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.abstractComponents.FlipkartAbstractClass;

public class OrderProductPage extends FlipkartAbstractClass {

	WebDriver driver;
	Set<Integer> hashSet = new HashSet<Integer>();

	public OrderProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@title='Search for Products, Brands and More']")
	WebElement flipkartSearchInput;

	@FindBy(xpath = "//div[text() = 'Price -- Low to High']")
	WebElement sortProductsLowToHigh;

	@FindBy(xpath = "//div[contains(@class, 'WHN')]")
	List<WebElement> listOfProducts;

	By referenceElement = By.xpath("//div[contains(@class, 'MIXNux')]");

	public void sortProductsList(String productName) throws InterruptedException {
		flipkartSearchInput.sendKeys(productName);
		flipkartSearchInput.sendKeys(Keys.RETURN);
		sortProductsLowToHigh.click();
		Thread.sleep(4000);
	}

	public Set<Integer> getProductListPrice() {
		try {
			fnWaitForElementToAppear(referenceElement);
			for (WebElement productPrice : listOfProducts) {
				String price = productPrice.getText().replace("₹", "").trim();
				int intPrice = Integer.valueOf(price);
				hashSet.add(intPrice);
			}
		} catch (Exception ex) {
			System.out.println("Something wrong : while getting product price :" + ex.getMessage());
		}
		return hashSet;
	}

	public void fnGetSecondLowestInPrice() {
		Set<Integer> productsPrice = getProductListPrice();
		List<Integer> newList = new ArrayList<Integer>(productsPrice);
		//Collections.sort method is sorting the elements of ArrayList in ascending order
		Collections.sort(newList);
		System.out.println("Second lowest price of a mobile : " + newList.get(1));
	}

}
