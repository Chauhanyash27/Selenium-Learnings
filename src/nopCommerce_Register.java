import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import static org.openqa.selenium.By.xpath;

public class nopCommerce_Register {

    private static WebDriver driver;
    private static String registerNavItem;
    private static String firstName;
    private static String lastName;
    private static String dateOfBirthDay;
    private static String dateOfBirthMonth;
    private static String dateOfBirthYear;
    private static String email;
    private static String companyName;
    private static String password;
    private static String confirmPassword;
    private static String registerButton;

    static {
        try {
            registerNavItem = String.format("//a[@class='%s']",xpathIdentifier(0));
            firstName =String.format("//*[@id='%s']",xpathIdentifier(1));
            lastName = String.format("//*[@id='%s']",xpathIdentifier(2));
            dateOfBirthDay = String.format("//select[@name='%s']",xpathIdentifier(3));
            dateOfBirthMonth= String.format("//select[@name='%s']",xpathIdentifier(4));
            dateOfBirthYear = String.format("//select[@name='%s']",xpathIdentifier(5));
            email =String.format("//*[@id='%s']",xpathIdentifier(6));
            companyName = String.format("//*[@id='%s']",xpathIdentifier(7));
            password = String.format("//*[@id='%s']",xpathIdentifier(8));
            confirmPassword = String.format("//*[@id='%s']",xpathIdentifier(9));
            registerButton = String.format("//button[@id='%s']",xpathIdentifier(10));;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static public String xpathIdentifier(int index) throws IOException {

        ArrayList<String > dataArray2 = new ArrayList<>();
        String filePath="C:\\Users\\Yashchauhan\\IdeaProjects\\Data Driven Framework\\TestData_Register.xlsx";
        int Rows=ExcelFileHandling.getRowCount(filePath,"Sheet1");

        for(int i=1;i<=Rows;i++){
            dataArray2.add(ExcelFileHandling.getCellData(filePath, "Sheet1", i, 0));
        }
        return dataArray2.get(index);
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        String filePath="C:\\Users\\Yashchauhan\\IdeaProjects\\Data Driven Framework\\TestData_Register.xlsx";

        int totalRows=ExcelFileHandling.getRowCount(filePath,"TestData");

        int totalColumns = ExcelFileHandling.getColumnCount(filePath,"TestData",0);

        ArrayList<String > dataArray = new ArrayList<>();

        for(int i=1;i<=totalRows;i++){

                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                driver.get("https://demo.nopcommerce.com/");

                for(int j=0;j<totalColumns;j++){
                        dataArray.add(ExcelFileHandling.getCellData(filePath,"TestData",i,j));
                }

                driver.findElement(xpath(registerNavItem)).click();

                driver.findElement(xpath("//input[@id='gender-"+dataArray.get(0)+"']")).click();

                driver.findElement(xpath(firstName)).sendKeys(dataArray.get(1));

                driver.findElement(xpath(lastName)).sendKeys(dataArray.get(2));

                Select Day = new Select(driver.findElement(xpath(dateOfBirthDay)));
                String dobDay=(dataArray.get(3)).substring(0,(dataArray.get(3)).indexOf("."));
                Day.selectByVisibleText(dobDay);

                Select Month = new Select(driver.findElement(xpath(dateOfBirthMonth)));
                Month.selectByVisibleText(dataArray.get(4));

                Select Year = new Select(driver.findElement(xpath(dateOfBirthYear)));
                String dobYear=(dataArray.get(5)).substring(0,(dataArray.get(5)).indexOf("."));
                Year.selectByVisibleText(dobYear);

                driver.findElement(xpath(email)).sendKeys(dataArray.get(6));

                driver.findElement(xpath(companyName)).sendKeys(dataArray.get(7));

                driver.findElement(xpath(password)).sendKeys(dataArray.get(8));

                driver.findElement(xpath(confirmPassword)).sendKeys(dataArray.get(9));

                driver.findElement(xpath(registerButton)).click();

                Thread.sleep(2000);
                driver.close();

                dataArray.clear();

        }

    }
}
