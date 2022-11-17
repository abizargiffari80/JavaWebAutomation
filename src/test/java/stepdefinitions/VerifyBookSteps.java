package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyBookSteps {

	WebDriver driver = null;

	GetterSetter data = new GetterSetter();
	GetterSetter dataVerify = new GetterSetter();

	@Given("User go to page books")
	public void user_go_to_page_books() {
		System.out.println("User buka link search book");

		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is : " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.navigate().to("https://demoqa.com/books");

	}

	@When("User at Books store page")
	public void user_at_books_store_page() {
		driver.getPageSource().contains("Book Store");
	}

	@When("User search book Git Pocket Guide")
	public void user_search_book_git_pocket_guide() {
		driver.findElement(By.id("searchBox")).sendKeys("Git Pocket Guide");
		driver.findElement(By.id("searchBox")).sendKeys(Keys.ENTER);
	}

	@When("User click book Git Pocket Guide")
	public void user_click_book_git_pocket_guide() {
		data.setTittle(driver.findElement(By.id("see-book-Git Pocket Guide")).getText());
		data.setAuthor(driver.findElement(By.cssSelector(
				"#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div.books-wrapper > div.ReactTable.-striped.-highlight > div.rt-table > div.rt-tbody > div:nth-child(1) > div > div:nth-child(3)"))
				.getText());
		data.setPublisher(driver.findElement(By.cssSelector(
				"#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div.books-wrapper > div.ReactTable.-striped.-highlight > div.rt-table > div.rt-tbody > div:nth-child(1) > div > div:nth-child(4)"))
				.getText());
		System.out.println(data.toString());
		driver.findElement(By.id("see-book-Git Pocket Guide")).click();
	}

	@Then("User see Git Pocket Guide")
	public void user_see_git_pocket_guide() {
		dataVerify.setTittle(driver.findElement(By.cssSelector("#title-wrapper > div.col-md-9.col-sm-12")).getText());
		dataVerify.setAuthor(driver.findElement(By.cssSelector("#author-wrapper > div.col-md-9.col-sm-12")).getText());
		dataVerify.setPublisher(
				driver.findElement(By.cssSelector("#publisher-wrapper > div.col-md-9.col-sm-12")).getText());

		System.out.println("data = " + data);
		System.out.println("dataVerify = " + dataVerify);

		System.out.println("dataTittle = " + data.getTittle().equals(dataVerify.getTittle()));
		System.out.println("dataAuthor = " + data.getAuthor().equals(dataVerify.getAuthor()));
		System.out.println("dataPublisher = " + data.getPublisher().equals(dataVerify.getPublisher()));

		if (data.getTittle().equals(dataVerify.getTittle()) && data.getAuthor().equals(dataVerify.getAuthor())
				&& data.getPublisher().equals(dataVerify.getPublisher())) {
			System.out.println("Data sesuai");
			driver.close();
			driver.quit();
		} else {
			System.out.println("Data tidak sesuai");
		}

	}

}
