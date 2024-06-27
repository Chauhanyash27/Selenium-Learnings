import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;
import java.time.Duration;

public class nopCommerce_Register {

    public static void main(String[] args) throws IOException {

        String filePath="C:\\Users\\Yashchauhan\\IdeaProjects\\Data Driven Framework\\TestData_Register.xlsx";

        int totalRows=ExcelFileHandling.getRowCount(filePath,"TestData");

        for(int i=1;i<=totalRows;i++){

                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                driver.get("https://demo.nopcommerce.com/");

                String gender = ExcelFileHandling.getCellData(filePath,"TestData",i,0);
                String firstName = ExcelFileHandling.getCellData(filePath,"TestData",i,1);
                String lastName = ExcelFileHandling.getCellData(filePath,"TestData",i,2);
                String dobDay = ExcelFileHandling.getCellData(filePath,"TestData",i,3);
                String day=dobDay.substring(0,dobDay.indexOf("."));
                String dobMonth = ExcelFileHandling.getCellData(filePath,"TestData",i,4);
                String dobYear = ExcelFileHandling.getCellData(filePath,"TestData",i,5);
                String year=dobYear.substring(0,dobYear.indexOf("."));
                String email = ExcelFileHandling.getCellData(filePath,"TestData",i,6);
                String companyName = ExcelFileHandling.getCellData(filePath,"TestData",i,7);
                String password = ExcelFileHandling.getCellData(filePath,"TestData",i,8);
                String confirmPassword = ExcelFileHandling.getCellData(filePath,"TestData",i,9);
                driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();

                driver.findElement(By.xpath("//input[@id='gender-"+gender+"']")).click();

                driver.findElement(By.xpath("//*[@id='FirstName']")).sendKeys(firstName);

                driver.findElement(By.xpath("//*[@id='LastName']")).sendKeys(lastName);

                driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(email);

                Select dateofBirthDay = new Select(driver.findElement(By.cssSelector("select[name=\"DateOfBirthDay\"]")));
                dateofBirthDay.selectByVisibleText(day);

                Select dateofBirthMonth = new Select(driver.findElement(By.cssSelector("select[name=\"DateOfBirthMonth\"]")));
                dateofBirthMonth.selectByVisibleText(dobMonth);

                Select dateofBirthYear = new Select(driver.findElement(By.cssSelector("select[name=\"DateOfBirthYear\"]")));
                dateofBirthYear.selectByVisibleText(year);

                driver.findElement(By.xpath("//*[@id='Company']")).sendKeys(companyName);

                driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);

                driver.findElement(By.xpath("//*[@id='ConfirmPassword']")).sendKeys(confirmPassword);

                driver.findElement(By.xpath("//button[@id='register-button']")).click();

                driver.close();


        }

    }
}
