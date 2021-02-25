package Tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProfileTest extends BasicTest {

	private SoftAssert sa = new SoftAssert();

	@Test
	public void editProfileTest() throws InterruptedException {

		this.driver.navigate().to(this.baseUrl + "/guest-user/login-form");
		locationPopupPage.closePopup();
		loginPage.loginMember(this.customer, this.password);

		sa.assertEquals(notificationSistemPage.getMessageText(), "Login Successfull",
				"[ERROR] The message did not appear.");

		this.driver.navigate().to(this.baseUrl + "/member/profile");
		profilePage.changeAllInfo("Jelena", "Bajat", "Bulevar", "06405021", "18000", "India", "Goa", "Betora");

		sa.assertEquals(notificationSistemPage.getMessageText(), "Setup Successful",
				"[ERROR] The message did not appear.");

		authPage.logoutMember();

		sa.assertEquals(notificationSistemPage.getMessageText(), "Logout Successfull!",
				"[ERROR] The message did not appear.");
		sa.assertAll();
	}

	@Test
	public void changeProfileImageTest() throws IOException {

		this.driver.navigate().to(this.baseUrl + "/guest-user/login-form");
		locationPopupPage.closePopup();
		loginPage.loginMember(this.customer, this.password);

		sa.assertEquals(notificationSistemPage.getMessageText(), "Login Successfull",
				"[ERROR] The message did not appear.");

		this.driver.navigate().to(this.baseUrl + "/member/profile");
		String imgPath = new File("img/V.jpg").getCanonicalPath();
		profilePage.uploadImage(imgPath);

		sa.assertEquals(notificationSistemPage.getMessageText(), "Profile Image Uploaded Successfully",
				"[ERROR] The message did not appear.");

		notificationSistemPage.waitMessageToDisappear();
		profilePage.deleteImage();

		sa.assertEquals(notificationSistemPage.getMessageText(), "Profile Image Deleted Successfully",
				"[ERROR] The message did not appear.");

		notificationSistemPage.waitMessageToDisappear();
		authPage.logoutMember();

		sa.assertEquals(notificationSistemPage.getMessageText(), "Logout Successfull!",
				"[ERROR] The message did not appear.");
		sa.assertAll();
	}
}
