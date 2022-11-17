package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SelectMenuSteps {

	WebDriver driver = null;

	@Given("User go to https:\\/\\/demoqa.com\\/select-menu")
	public void user_go_to_https_demoqa_com_select_menu() {
		System.out.println("User buka link select menu");

		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is : " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();

		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.navigate().to("https://demoqa.com/select-menu");
	}

	@When("User in select menu page")
	public void user_in_select_menu_page() {
		driver.getPageSource().contains("Select Menu");
	}

	@And("User choose select value Another root option")
	public void user_choose_select_value_another_root_option() {
		System.out.println("User pilih another root option");
		driver.findElement(By.id("withOptGroup")).click();
		driver.findElement(By.id("react-select-2-input")).sendKeys("Another root option");
		driver.findElement(By.id("react-select-2-input")).sendKeys(Keys.ENTER);
	}

	@And("User choose select one Other")
	public void user_choose_select_one_other() {
		System.out.println("User pilih other");
		driver.findElement(By.id("selectOne")).click();
		driver.findElement(By.id("react-select-3-input")).sendKeys("Other");
		driver.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);
	}

	@And("User choose old style select menu Aqua")
	public void user_choose_old_style_select_menu_aqua() throws InterruptedException {
		System.out.println("User pilih Aqua");
		driver.findElement(By.id("oldSelectMenu")).click();
		for (int i = 0; i < 11; i++) {
			driver.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
		}
		driver.switchTo().activeElement().sendKeys(Keys.ENTER);
		// driver.findElement(By.cssSelector("#oldSelectMenu >
		// option:nth-child(11)")).click();
		Thread.sleep(6000);
	}

	@And("User choose multi select drop down all color")
	public void user_choose_multi_select_drop_down_all_color() throws InterruptedException {
		System.out.println("User pilih semua warna");
		driver.findElement(By.cssSelector("#selectMenuContainer > div:nth-child(7) > div > div > div")).click();

		// Thread.sleep(2000);
		for (int i = 0; i < 4; i++) {
			driver.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);
		}
		Thread.sleep(2000);
	}

	@Then("User success input all select menu")
	public void user_success_input_all_select_menu() {
		System.out.println("User berhasil select semua");
		driver.close();
		driver.quit();
	}

}
