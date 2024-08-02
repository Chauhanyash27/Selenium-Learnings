package Tests;

import Pages.DemoPage;
import Utilities.Base;
import org.testng.annotations.Test;
import java.io.IOException;

public class HF_001_DisplayGooglePage extends Base {

    DemoPage obj_Google;

    @Test
    public void GooglePageDisplay() throws IOException {
        obj_Google = new DemoPage(driver);
        obj_Google.openGooglePage();
    }
}
