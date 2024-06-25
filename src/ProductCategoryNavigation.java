import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductCategoryNavigation extends NopCommerce_Login{

    public void computerCategory() throws InterruptedException {
//
//        for(int i=1;i<=16;i++){
//
//            if(i==2 || i==3 || i==4 || i==) continue;
//            else{
//            Thread.sleep(3000);
//            driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//li["+i+"]//a")).click();}
//
//        }

        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();
        List<WebElement> subcategories=driver.findElements(By.xpath("//div[@class=\"item-grid\"]/div"));

        System.out.println((subcategories.size()==3) ? "All computer subcategories are displayed" : "All subcategories Not displayed");

        //Desktops
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[2]/div[1]/div/div[1]")).click();
        itemsDisplayVerification();

        Select sortOrder = new Select(driver.findElement(By.xpath("//*[@id=\"products-orderby\"]")));
        sortOrder.selectByIndex(2);

        String productLenovo= driver.findElement(By.xpath("//div[@data-productid=\"3\"]/div[2]//a")).getText();
        System.out.println(productLenovo);
        System.out.println((productLenovo.contains("Lenovo")) ? "Order sorted by Name: Z to A":"Order not sorted correctly");

        // Notebooks
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/ul/li[1]/ul/li[2]/a")).click();
        itemsDisplayVerification();
    }

    public void itemsDisplayVerification(){
        List<WebElement> subcategoryItems = driver.findElements(By.xpath("//div[@class=\"item-grid\"]/child::div"));

        int numberOfItems = subcategoryItems.size();

        switch(numberOfItems){
            case 3:
                System.out.println("All desktops items are displayed"); break;
            case 6:
                System.out.println("All notebooks items are displayed"); break;
            default:
                System.out.println("All items not displayed");
        }



    }






    public static void main(String[] args) throws InterruptedException {

        ProductCategoryNavigation obj1 = new ProductCategoryNavigation();
        obj1.browserInitator();
        obj1.computerCategory();
    }
}