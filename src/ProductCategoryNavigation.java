import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ProductCategoryNavigation extends NopCommerce_Login{
    public void CategoryNavigation() throws InterruptedException {

        int categoriesCount = driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li")).size();

        for(int i=1;i<=categoriesCount;i++) {
            Thread.sleep(3000);
            driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+i+"]/a")).click();
            List<WebElement> subcategories=driver.findElements(By.xpath("//div[@class=\"item-grid\"]//div[@class=\"item-box\"]"));
            if ((i == 1 || i ==2 || i== 3) && subcategories.size()==3){
                System.out.println("All subcategories are displayed");
            }
            else if (subcategories.size()==3){
                switch (i){
                    case 4:
                        System.out.println("All digital downloads items are displayed ");break;
                    case 5:
                        System.out.println("All books items are displayed");break;
                    case 6:
                        System.out.println("All jewelry items are displayed");break;
                    case 7:
                        System.out.println("All Gift card items are displayed");break;
                }
            }
            else {System.out.println("All subcategories/items are not displayed");}
            subcategories.clear();
        }
}

    public void subcategoryNavigation() throws InterruptedException {

        Actions action= new Actions(driver);

        for(int i=1;i<=3;i++){
            int subcategoryCount = driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+i+"]/ul/li/a")).size();
            for(int j=1;j<=subcategoryCount;j++){
                Thread.sleep(3000);
                WebElement categoryHover = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+i+"]"));
                action.moveToElement(categoryHover).perform();
                driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+i+"]/ul/li["+j+"]/a")).click();
                itemsDisplayVerification(i);
            }
        }
    }

    public void itemsDisplayVerification(int i){
        List<WebElement> subcategoryItems = driver.findElements(By.xpath("//div[@class=\"item-grid\"]/child::div"));
        int numberOfItems = subcategoryItems.size();
        if(i==1){
            switch(numberOfItems){
                case 3:
                    System.out.println("All desktops/Software items are displayed"); break;
                case 6:
                    System.out.println("All notebooks items are displayed"); break;
                default:
                    System.out.println("All items not displayed");
                }
        }
        if(i==2){
            if(numberOfItems==3) System.out.println("All items are displayed");
            else System.out.println("All items not displayed");
            }
        if(i==3){
            switch(numberOfItems){
                case 3:
                    System.out.println("All Shoes/Accessories  items are displayed"); break;
                case 4:
                    System.out.println("All Clothing items are displayed"); break;
                default:
                    System.out.println("All items not displayed");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ProductCategoryNavigation obj1 = new ProductCategoryNavigation();
        browserInitiator();
        obj1.subcategoryNavigation();
    }
}