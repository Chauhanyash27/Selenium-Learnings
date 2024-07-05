import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import java.time.Duration;

@Test
public class MyAccountNavigation {

    static String address_FirstName = "//input[@id='Address_FirstName']";
    static String address_LastName = "//input[@id='Address_LastName']";
    static String address_Email = "//input[@id='Address_Email']";
    static String address_Company = "//input[@id='Address_Company']";
    static String address_Country = "//select[@id='Address_CountryId']";
    static String address_State = "//select[@id='Address_StateProvinceId']";
    static String address_City = "//input[@id='Address_City']";
    static String address_Address = "//input[@id='Address_Address1']";
    static String address_ZipCode = "//input[@id='Address_ZipPostalCode']";
    static String address_PhoneNumber = "//input[@id='Address_PhoneNumber']";
    static String address_SaveButton = "//button[@class='button-1 save-address-button']";
    static String address_AddNewButton = "//button[@class='button-1 add-address-button']";

    static WebDriver driver;

   @BeforeClass
    public static void browserInitiator(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void userLogin() {

        driver.findElement(By.xpath("//a[@class='ico-login']")).click();

        driver.findElement(By.xpath("//input[@class='email']")).sendKeys("yash10@mailinator.com");

        driver.findElement(By.xpath("//input[@class='password']")).sendKeys("password");

        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();

        driver.findElement(By.xpath("//a[@class=\"ico-account\"]")).click();
        driver.findElement(By.xpath("//div[@class='listbox']//ul//li[2]//a")).click();

    }


    public void accountNavigation() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class=\"ico-account\"]")).click();
        int accountCount = driver.findElements(By.xpath("//div[@class=\"listbox\"]//ul//li")).size();
        for (int i = 1; i <= accountCount; i++) {
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@class='listbox']//ul//li[" + i + "]//a")).click();
        }
        driver.close();
    }

    @DataProvider()
    public Object[][] AddressData() throws IOException {
     String filePath = System.getProperty("user.dir") + "\\Test Data\\TestData.xlsx";
     int totalRows = ExcelFileHandling.getRowCount(filePath,"AddressData");
     int totalColumns = ExcelFileHandling.getColumnCount(filePath,"AddressData",1);

     Object[][] data = new Object[totalRows][totalColumns];
     for(int i=1;i<=totalRows;i++){
         for(int j=0;j<totalColumns;j++){
             data[i-1][j]=(ExcelFileHandling.getCellData(filePath,"AddressData",i,j));
         }
     }
     return data;
    }


    @Test(dataProvider = "AddressData",dependsOnMethods = "userLogin")
    public void AddAddress(String[] data) throws InterruptedException {

        driver.findElement(By.xpath(address_AddNewButton)).click();

        driver.findElement(By.xpath(address_FirstName)).sendKeys(data[0]);
        driver.findElement(By.xpath(address_LastName)).sendKeys(data[1]);
        driver.findElement(By.xpath(address_Email)).sendKeys(data[2]);
        driver.findElement(By.xpath(address_Company)).sendKeys(data[3]);

        Select select = new Select(driver.findElement(By.xpath(address_Country)));
        select.selectByVisibleText(data[4]);

        select = new Select(driver.findElement(By.xpath(address_State)));
        select.selectByVisibleText(data[5]);

        driver.findElement(By.xpath(address_City)).sendKeys(data[6]);
        driver.findElement(By.xpath(address_Address)).sendKeys(data[7]);
        driver.findElement(By.xpath(address_ZipCode)).sendKeys(data[8]);
        driver.findElement(By.xpath(address_PhoneNumber)).sendKeys(data[9]);

        driver.findElement(By.xpath(address_SaveButton)).click();

        String validationText = driver.findElement(By.xpath("//p[@class=\"content\"]")).getText();
        String actualText= "The new address has been added successfully.";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(validationText,actualText);
        softAssert.assertAll();

        Thread.sleep(3000);
    }

    @AfterClass
    public void CloseBrowser(){
       driver.quit();
    }
}