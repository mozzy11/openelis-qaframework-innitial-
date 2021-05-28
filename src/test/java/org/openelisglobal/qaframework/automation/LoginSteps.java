package org.openelisglobal.qaframework.automation;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertNotNull;

import org.openelisglobal.qaframework.RunTest;

public class LoginSteps extends Steps {

	@After(RunTest.HOOK.SELENIUM)
	public void destroy() {
		quit();
	}

	private void enterUsername(String username) {
		driver.findElement(By.id("loginName")).sendKeys(username);
	}

	private void enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	private WebElement getLoginButton() {
		return getElement(By.id("submitButton"));
	}

	private WebElement getLogOutLink() {
		return getElement(By.id("logout-form"));
	}

	@Given("User visits login page")
	public void visitLoginPage() throws Exception {
		goToLoginPage();
	}

	@When("User enters {string} username")
	public void anyUsername(String username) {
		if ("setupUser".equals(username)) {
			username = testProperties.getUsername();
		}
		enterUsername(username);
	}

	@And("User enters {string} password")
	public void anyPassword(String password) {
		if ("setupPass".equals(password)) {
			password = testProperties.getPassword();
		}
		enterPassword(password);
	}

	@And("User Logs in")
	public void userLogsIn() {
		getLoginButton().click();
	}

	@Then("System Evaluates Login {string}")
	public void evaluateLogin(String status) {
		if (status.trim().endsWith("true")) {
			assertNotNull(getLogOutLink());
		} else if (status.trim().endsWith("false")) {
			assertNotNull(getLoginButton());
		}
	}
}
