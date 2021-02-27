package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BasicPage {

	public SearchResultPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}

	public List<WebElement> getListOfProducts() {
		return this.driver.findElements(By.xpath("//*[@class='product-name']/a"));
	}

	public List<String> getListOfProductsText(){
		ArrayList<String> listOfProductText = new ArrayList<String>();
		
		for (int i = 0; i < this.getListOfProducts().size(); i++) {
			 String productName = this.getListOfProducts().get(i).getText();
			 listOfProductText.add(productName);
		}
		 return listOfProductText;
	}
	
	public double getNumberOfResults() {
		return this.getListOfProducts().size();
	}
}
