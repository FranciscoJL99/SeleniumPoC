import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.fail;


public class AutomationPractice {

    public WebDriver driver;

    @Before
    public void setUP() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void testDemoqa(){
        WebDriverWait wait = new WebDriverWait(driver, 15);

        WebElement searchs = driver.findElement(By.id("search_query_top"));
        WebElement buttonSearchs = driver.findElement(By.name("submit_search"));


        searchs.sendKeys("Printed Summer Dress");
        buttonSearchs.click();

        try
        {
            if((driver.findElements(By.xpath("//p[@class='alert alert-warning']")).size() == 0)){
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Printed Summer Dress')]"))).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Submit"))).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2[1]")));
                Assert.assertEquals("Product successfully added to your shopping cart", driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2[1]")).getText());
            }
        }
        catch(Exception e)
        {
            fail("La busqueda a realizar no tienes resultados");
        }
    }

    @After
    public void quitDriver() {

        driver.quit();

    }
}
