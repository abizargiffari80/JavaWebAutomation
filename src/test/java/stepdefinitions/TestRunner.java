package stepdefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features",
		glue = { "stepdefinitions" },
		monochrome = true,
		plugin = {"pretty", "html:target/HtmlReports/report.html",
				"json:target/JSONReports/report.json",
				"junit:target/JUnitReports/report.xml" },
		tags = "@CaseSelectMenu") //untuk milih mau feature apa yg dijalanin, pakai tag

public class TestRunner {

}
