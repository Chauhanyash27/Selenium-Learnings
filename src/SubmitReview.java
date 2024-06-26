import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class SubmitReview extends NopCommerce_Login{

    public void writeReview(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div[4]/div[2]/div[1]/div"))).click().perform();
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"review-form\"]/form/div[1]/div"))).perform();
        driver.findElement(By.xpath("//input[@class=\"review-title\"]")).sendKeys("Testing review");
        driver.findElement(By.xpath("//textarea[@class=\"review-text\"]")).sendKeys("Testing Comment field");
        driver.findElement(By.xpath("//input[@value=\"5\"]")).click();
        driver.findElement(By.xpath("//button[@name=\"add-review\"]")).click();

        if(driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p")).isDisplayed()){
            System.out.println("Product review has been added");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SubmitReview obj = new SubmitReview();
        obj.userLogin();
        obj.writeReview();
    }
}
