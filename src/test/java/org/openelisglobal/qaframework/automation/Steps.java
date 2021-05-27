package org.openelisglobal.qaframework.automation;
import static org.junit.Assert.fail;

import org.openelisglobal.qaframework.automation.page.HomePage;
import org.openelisglobal.qaframework.automation.page.LoginPage;
import org.openelisglobal.qaframework.automation.page.TestProperties;
import org.openelisglobal.qaframework.automation.test.ApplicationTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Steps extends ApplicationTestBase {
	protected TestProperties testProperties = TestProperties.instance();
	protected LoginPage loginPage;
	protected String firstPatientIdentifier;
	protected By patientHeaderId = By.cssSelector("div.identifiers span");

	public Steps() {
		try {
			startWebDriver();
			loginPage = getLoginPage();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	protected void quit() {
		if (driver != null) {
			driver.quit();
		}
	}

	protected WebElement getElement(By elementBy) {
		try {
			return driver.findElement(elementBy);
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	protected boolean textExists(String text) {
		return driver.findElements(
				By.xpath("//*[contains(text(),'" + text + "')]")).size() > 0;
	}

	protected void initiateWithLogin() {
		goToLoginPage();
		goToLoginPage().login(testProperties.getUsername(),
				testProperties.getPassword(), testProperties.getLocation());
		homePage = (HomePage) new HomePage(loginPage).waitForPage();
	}
}
