package Tests;

import org.testng.annotations.Test;

public class TestPage extends BasicTest {

	@Test
	public void testTest() throws InterruptedException {
		this.driver.navigate().to(this.baseUrl + "/member/profile");
		locationPopupPage.closePopup();
		loginPage.getEmail().clear();
		loginPage.getPassword().clear();
		loginPage.loginMember(this.customer, this.password);
		profilePage.changeAllInfo("jjj", "bbb", "asd", "123", "123", "India", "Goa", "Aldona");
	
	}
}
