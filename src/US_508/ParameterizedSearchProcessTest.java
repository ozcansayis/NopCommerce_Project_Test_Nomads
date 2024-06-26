package US_508;

import POM.*;
import Utility.BaseDriverParameter;
import org.testng.Assert;
import org.testng.annotations.*;

public class ParameterizedSearchProcessTest extends BaseDriverParameter {
    @Test(groups = {"UITesting", "Search", "Smoke", "Regression"}, priority = 8)
    @Parameters({"searchText"})
    public void TC_508(String text) {
        LoginContent lc = new LoginContent();
        HomePageContent hpc = new HomePageContent();
        myClick(lc.loginButton);
        mySendKeys(lc.email, "testnomads201@gmail.com");
        mySendKeys(lc.password, "testnomads");
        myClick(lc.loginButton2);
//        mySendKeys(hpc.searchBox, text + Keys.ENTER);
        mySendKeys(hpc.searchBox, text);
        myClick(hpc.searchButton);
        Assert.assertEquals(hpc.productTitle.getText(), text, "The product title does not include the search term 'Adobe Photoshop CS4'.");
    }
}
