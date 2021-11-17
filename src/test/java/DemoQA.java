import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DemoQA {
	
	public WebDriver driver;

	@Before
	public void setUP() {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

		driver = new ChromeDriver();


		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();


		driver.get("https://demoqa.com/automation-practice-form");
	}

	@Test
	public void testDemoqa() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,5);

		WebElement firstName = driver.findElement(By.id("firstName"));
		WebElement lastName = driver.findElement(By.id("lastName"));
		WebElement email = driver.findElement(By.id("userEmail"));
		WebElement mobile = driver.findElement(By.id("userNumber"));
		WebElement dateBirth = driver.findElement(By.id("dateOfBirthInput"));


		WebElement currentAddres = driver.findElement(By.id("currentAddress"));
		WebElement buttonSubmit = driver.findElement(By.id("submit"));

		wait.until(ExpectedConditions.elementToBeClickable(By.id("firstName")));
		firstName.sendKeys("Francisco");
		lastName.sendKeys("Leon");
		email.sendKeys("javiier.leoon15@gmail.com");
		containsText("Other").click();
		mobile.sendKeys("3004855663");
		dateBirth.click();
		Select moth = new Select (driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
		Select year = new Select (driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
		Thread.sleep(1000);
		moth.selectByIndex(3);
		Thread.sleep(1000);
		year.selectByValue("1999");
		Thread.sleep(1000);
		dayCalendar("10").click();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='subjectsInput']"))).sendKeys("Commerce");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'subjects-auto-complete__menu')]"))).click();

		containsText("Sports").click();
		containsText("Music").click();
		currentAddres.sendKeys("QA");
		containsText("Select State").click();
		containsText("NCR").click();
		containsText("Select City").click();
		containsText("Delhi").click();
		buttonSubmit.click();
		Thread.sleep(2000);


		Assert.assertTrue(driver.findElement(By.id("example-modal-sizes-title-lg")).isDisplayed());

	}

	public WebElement containsText(String hobbies) {
		return driver.findElement(By.xpath("//*[contains(text(), '" + hobbies + "')]"));
	}
	public WebElement dayCalendar(String day) {
		return driver.findElement(By.xpath("(//div[@role='option' and text()='"+day+"'])[1]"));
	}
	@After
	public void quitDriver() {
		
		driver.quit();
		
	}
}
