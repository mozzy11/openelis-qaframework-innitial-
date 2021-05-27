package org.openelisglobal.qaframework;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
// defining ordered by name features folder
features = {"src/test/resources/features"},
// defining the definition steps package
glue = "org.openelisglobal.qaframework.automation", plugin = {
		"html:target/index.html", "message:target/cucumber.ndjson"}, monochrome = true)
public class RunTest {

	public class HOOK {
		public static final String SELENIUM = "@selenium";
		public static final String LOGIN = "@login";
		public static final String SELENIUM_LOGIN = SELENIUM + " and " + LOGIN;
	}
}