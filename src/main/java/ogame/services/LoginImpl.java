package ogame.services;

import ogame.util.Browser;
import ogame.util.Constants;
import ogame.webpages.AccountPage;
import ogame.webpages.LoginPage;
import ogame.webpages.HubLoginPage;
import org.openqa.selenium.WebDriver;


import static java.util.concurrent.TimeUnit.SECONDS;

public class LoginImpl implements LoginI {

    /** Browser */
    WebDriver driver = Browser.launch();

    /** Logger */
   // private static final Logger logger = LoggerFactory.getLogger(LoginImpl.class);

    public void logInOGame() {

        LoginPage loginPage = new LoginPage(driver);

        driver.get("https://es.ogame.gameforge.com/");

        loginPage.getCookiePolicyBtn().click();
        loginPage.getTabEntrar().click();
        loginPage.getTxtEmail().sendKeys(Constants.Credentials.OGAME_USERMAIL);
        loginPage.getTxtPass().sendKeys(Constants.Credentials.OGAME_USERPASS);
        loginPage.getEntrarBtn().click();

        driver.manage().timeouts().setScriptTimeout(5,SECONDS);

        HubLoginPage hubLoginPage = new HubLoginPage(driver);
        hubLoginPage.getCookiePolicyBtn().click();
        hubLoginPage.getJugarBtn().click();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.getCookiePolicyBtn().click();
        accountPage.getJugarBtn().click();

    }

    public void logOutOGame() {

    }
}
