import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class SortingFunctionality extends BaseClass {

    public void sortByFunction(){
        Select sortOrder = new Select(driver.findElement(By.xpath("//*[@id=\"products-orderby\"]")));
        sortOrder.selectByIndex(2);

        String productLenovo= driver.findElement(By.xpath("//div[@data-productid=\"3\"]/div[2]//a")).getText();
        System.out.println(productLenovo);
        System.out.println((productLenovo.contains("Lenovo")) ? "Order sorted by Name: Z to A":"Order not sorted correctly");

    }
}
