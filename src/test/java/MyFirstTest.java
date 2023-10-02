import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
    public class MyFirstTest{
        @Test
        public void testSearch(){
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");

            String title = driver.getTitle();
            Assert.assertEquals(title, "Web form");

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

            WebElement textBox = driver.findElement(By.name("my-text"));
            WebElement submitButton = driver.findElement(By.cssSelector("button"));

            textBox.sendKeys("Selenium");
            submitButton.click();

            WebElement message = driver.findElement(By.id("message"));
            String value = message.getText();
            Assert.assertEquals(value, "Received!");

            driver.quit();
        }
        @Test
        public void testCorrectLogin() throws InterruptedException {
            WebDriver driver = new ChromeDriver();
            driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");

            WebElement login = driver.findElement(By.name("username"));
            login.sendKeys("12345");

            WebElement password = driver.findElement(By.name("password"));
            password.sendKeys("54321");

            Thread.sleep(3000);

            WebElement button = driver.findElement(By.xpath("//*[@id='loginPanel']/form/div[3]/input"));
            button.click();

            WebElement page = driver.findElement(By.className("title"));
            String value = page.getText();

            Assert.assertEquals(value, "Accounts Overview");

            driver.quit();
    }
}
