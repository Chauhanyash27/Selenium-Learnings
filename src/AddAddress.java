import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AddAddress {
     WebDriver driver;
    @Test
    public void userLogin() {

        driver.findElement(By.xpath("//a[@class='ico-login']")).click();

        driver.findElement(By.xpath("//input[@class='email']")).sendKeys("yash10@mailinator.com");

        driver.findElement(By.xpath("//input[@class='password']")).sendKeys("password");

        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();

        driver.findElement(By.xpath("//a[@class=\"ico-account\"]")).click();
        driver.findElement(By.xpath("//div[@class='listbox']//ul//li[2]//a")).click();

    }
}
