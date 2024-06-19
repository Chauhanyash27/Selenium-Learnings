import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NopCommerce_Login {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://demo.nopcommerce.com/");

        driver.findElement(By.xpath("//a[@class='ico-login']")).click();

        driver.findElement(By.xpath("//input[@class='email']")).sendKeys("yash@mailinator.com");

        driver.findElement(By.xpath("//input[@class='password']")).sendKeys("123456");

        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
    }
}
