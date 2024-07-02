import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import java.time.Duration;

public class MyAccountNavigation {
    static WebDriver driver;

    @Test(priority = 1)
    public static void browserInitiator(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://demo.nopcommerce.com/");
    }

    @Test(priority=2)
    public void userLogin() {

        driver.findElement(By.xpath("//a[@class='ico-login']")).click();

        driver.findElement(By.xpath("//input[@class='email']")).sendKeys("yash10@mailinator.com");

        driver.findElement(By.xpath("//input[@class='password']")).sendKeys("password");

        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();

    }

    @Test(priority = 3)
    public void accountNavigation() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class=\"ico-account\"]")).click();
        int accountCount = driver.findElements(By.xpath("//div[@class=\"listbox\"]//ul//li")).size();
        for (int i = 1; i <= accountCount; i++) {
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@class='listbox']//ul//li[" + i + "]//a")).click();
        }
        driver.close();
    }

}