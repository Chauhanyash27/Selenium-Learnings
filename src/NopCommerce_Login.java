import org.openqa.selenium.By;

public class NopCommerce_Login extends BaseClass{

    public void userLogin() throws InterruptedException {

        browserInitiator();

        driver.findElement(By.xpath("//a[@class='ico-login']")).click();

        driver.findElement(By.xpath("//input[@class='email']")).sendKeys("yash@mailinator.com");

        driver.findElement(By.xpath("//input[@class='password']")).sendKeys("123456");

        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();

    }
    public void forgotPassword() throws InterruptedException {

        browserInitiator();

        driver.findElement(By.xpath("//a[@class='ico-login']")).click();

        driver.findElement(By.xpath("//span[@class='forgot-password']//a")).click();

        driver.findElement(By.xpath("//input[@class='email']")).sendKeys("yash@mailinator.com");

        driver.findElement(By.xpath("//button[@class='button-1 password-recovery-button']")).click();

        if (driver.findElement(By.xpath("//div[@class='bar-notification success']")).isDisplayed())
            System.out.println("Login Successful");
        else {
            System.out.println("Login unsuccessful");
        }

        Thread.sleep(3000);
        driver.close();
    }

    public static void main(String[] args) throws InterruptedException {

        NopCommerce_Login obj_login = new NopCommerce_Login();
        obj_login.userLogin();
        obj_login.forgotPassword();
    }
}
