package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchBookSteps {

	WebDriver driver = null;

	@Given("User go to https:\\/\\/demoqa.com\\/books")
	public void user_go_to_https_demoqa_com_books() {
		System.out.println("User buka link search book");

		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is : " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.navigate().to("https://demoqa.com/books");

	}

	@When("User in Book Store page")
	public void user_in_book_store_page() {
		driver.getPageSource().contains("Book Store");
	}

	@When("User search book qa engineer")
	public void user_search_book_qa_engineer() {
		driver.findElement(By.id("searchBox")).sendKeys("qa engineer");
		driver.findElement(By.id("searchBox")).sendKeys(Keys.ENTER);

	}

	@Then("User see No rows found")
	public void user_see_no_rows_found() throws InterruptedException {
		driver.getPageSource().contains("No rows found");
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
