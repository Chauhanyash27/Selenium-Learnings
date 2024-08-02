package Pages;

import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class DemoPage {

    WebDriver driver;

    public DemoPage(WebDriver driver){
        this.driver= driver;
    }

    public void openGooglePage() throws IOException {
        driver.get("https://www.google.com/");
    }
}
