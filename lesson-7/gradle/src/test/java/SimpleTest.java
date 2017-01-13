import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class SimpleTest {

    private static WebDriver driver;


    @Before
    public  void openBrowser(){
        driver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver");
    }

    @Test
    public  void signin(){

        driver.get("http://jacekokrojek.github.io/jak-to-zrobic-w-js/signup.html");
        String title = driver.getTitle();
        assertEquals("Protractor workshop | Sign up", title);

        WebElement element = driver.findElement(By.id("usernamesignup"));
        element.sendKeys("UserTest!");

        WebElement element2 = driver.findElement(By.id("emailsignup"));
        element2.sendKeys("email@signup.pl");

        WebElement element3 = driver.findElement(By.id("passwordsignup"));
        element3.sendKeys("123456");

        WebElement element4 = driver.findElement(By.id("passwordsignup_confirm"));
        element4.sendKeys("123456");

        WebElement button = driver.findElement(By.cssSelector(".signin > a:nth-child(1)"));
        button.click();
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}