import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NopCommerce_ForgotPassword {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://demo.nopcommerce.com/");

        driver.findElement(By.xpath("//a[@class='ico-login']")).click();

        driver.findElement(By.xpath("//span[@class='forgot-password']//a")).click();

        driver.findElement(By.xpath("//input[@class='email']")).sendKeys("yash@mailinator.com");

        driver.findElement(By.xpath("//button[@class='button-1 password-recovery-button']")).click();

        WebElement loginValidation = driver.findElement(By.xpath("//div[@class='bar-notification success']"));
        if (loginValidation.isDisplayed()) System.out.println("Login Successful");
        else {
            System.out.println("Login unsuccessful");
        }
    }
}
