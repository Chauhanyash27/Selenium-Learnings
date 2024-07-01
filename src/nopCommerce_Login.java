import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

public class nopCommerce_Login {

    private static WebDriver driver;
    private static String loginNavItem = "//a[@class='ico-login']";
    private static String emailField = "//input[@class='email']";
    private static String passwordField = "//input[@class='password']";
    private static String loginButton = "//button[@class='button-1 login-button']";
    private static String logoutButton ="//a[@class='ico-logout']";

    public static void multipleUserLogin() throws InterruptedException, IOException {

        String filePath = System.getProperty("user.dir") + "\\Test Data\\TestData.xlsx";

        int totalRows = ExcelFileHandling.getRowCount(filePath, "LoginCredentials");

        int totalColumns = ExcelFileHandling.getColumnCount(filePath, "LoginCredentials", 0);

        ArrayList<String> data = new ArrayList<>();

        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                data.add(ExcelFileHandling.getCellData(filePath, "LoginCredentials", i, j));
            }

            driver.findElement(By.xpath(loginNavItem)).click();

            driver.findElement(By.xpath(emailField)).sendKeys(data.get(0));

            driver.findElement(By.xpath(passwordField)).sendKeys(data.get(1));

            driver.findElement(By.xpath(loginButton)).click();

            Thread.sleep(2000);

            driver.findElement(By.xpath(logoutButton)).click();
            data.clear();
        }
        driver.close();
    }

    public static String utilityData(String key) throws IOException {

        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\Test Data\\Utility.properties");

        Properties obj_property = new Properties();
        obj_property.load(file);

        file.close();

        return obj_property.getProperty(key);
    }

    public static void singleUserLogin() throws IOException {

        driver.findElement(By.xpath(loginNavItem)).click();

        driver.findElement(By.xpath(emailField)).sendKeys(utilityData("email"));

        driver.findElement(By.xpath(passwordField)).sendKeys(utilityData("password"));

        driver.findElement(By.xpath(loginButton)).click();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demo.nopcommerce.com/");

        singleUserLogin();

    }
}
