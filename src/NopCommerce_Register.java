import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class NopCommerce_Register extends BaseClass {

    public void UserRegister(){
        browserInitiator();
        driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
        driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();

        driver.findElement(By.xpath("//*[@id='gender-male']")).click();

        driver.findElement(By.xpath("//*[@id='FirstName']")).sendKeys("Yash");

        driver.findElement(By.xpath("//*[@id='LastName']")).sendKeys("Chauhan");

        driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("yash@mailinator.com");

        Select dateofBirthDay = new Select(driver.findElement(By.cssSelector("select[name=\"DateOfBirthDay\"]")));
        dateofBirthDay.selectByIndex(27);

        Select dateofBirthMonth = new Select(driver.findElement(By.cssSelector("select[name=\"DateOfBirthMonth\"]")));
        dateofBirthMonth.selectByIndex(11);

        Select dateofBirthYear = new Select(driver.findElement(By.cssSelector("select[name=\"DateOfBirthYear\"]")));
        dateofBirthYear.selectByValue("2000");

        driver.findElement(By.xpath("//*[@id='Company']")).sendKeys("Infostride");

        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("123456");

        driver.findElement(By.xpath("//*[@id='ConfirmPassword']")).sendKeys("123456");

        driver.findElement(By.xpath("//button[@id='register-button']")).click();

        driver.close();
    }

    public static void main(String[] args) {

        NopCommerce_Register obj = new NopCommerce_Register();
        obj.UserRegister();
    }
}

