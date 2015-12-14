package ru.st.selenium;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.Test;

import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;

public class AddNewUser extends TestBase {

	@Test
	public void addNewUserOK() {
		String username = "user" + System.currentTimeMillis();
		User user = new User()
				.setLogin(username)
				.setPassword("password")
				.setEmail(username + "@test.com");
		
		app.getUserHelper().loginAs(ADMIN);
		app.getUserHelper().createUser(user);
		app.getUserHelper().logout();
		app.getUserHelper().loginAs(user);
		assertTrue(app.getUserHelper().isLoggedInAs(user));
	}
}
