import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class groceryTest {

    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:/Users/gustavo.santos/Documents/JUnit/chromedriver.exe");
        driver  = new ChromeDriver();
        driver.get("https://www.grocerycrud.com/v1.x/demo/bootstrap_theme");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testChallengeOne(){
        WebElement element = driver.findElement(By.id("switch-version-select"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Bootstrap V4 Theme");
        driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[1]/a")).click();
        driver.findElement(By.id("field-customerName")).sendKeys("Teste Sicredi");
        driver.findElement(By.id("field-contactLastName")).sendKeys("Teste");
        driver.findElement(By.id("field-contactFirstName")).sendKeys("Gustavo BLima");
        driver.findElement(By.id("field-phone")).sendKeys("51 9999-9999");
        driver.findElement(By.id("field-addressLine1")).sendKeys("Av Assis Brasil, 3970");
        driver.findElement(By.id("field-addressLine2")).sendKeys("Torre D");
        driver.findElement(By.id("field-city")).sendKeys("Porto Alegre");
        driver.findElement(By.id("field-state")).sendKeys("RS");
        driver.findElement(By.id("field-postalCode")).sendKeys("R91000-000");
        driver.findElement(By.id("field-country")).sendKeys("Brasil");
        driver.findElement(By.id("field_salesRepEmployeeNumber_chosen")).click();
        driver.findElement(
                By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/div/input")).sendKeys("Fixter", Keys.ENTER);
        driver.findElement(By.id("field-creditLimit")).sendKeys("200");

        driver.findElement(By.id("form-button-save")).click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(".//*[text() = 'Your data has been successfully stored into the database. ']")));
        Assert.assertTrue(driver.findElement(
                By.xpath(".//*[text() = 'Your data has been successfully stored into the database. ']")).isDisplayed());


    }

    @After
    public void tearDown(){driver.quit();}


}
