package Tests;

import org.testng.annotations.Test;

public class MealItemTest extends BasicTest {

	
	@Test
	public void addMealToCartTest(){
		this.driver.navigate().to(this.baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		locationPopupPage.closePopup();
		mealPage.addMealToCart("3");
	}
}
