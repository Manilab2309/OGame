package ogame.services;

import ogame.util.Browser;
import ogame.util.Constants;
import ogame.webpages.AccountPage;
import ogame.webpages.LoginPage;
import ogame.webpages.HubLoginPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static java.util.concurrent.TimeUnit.SECONDS;

public class LoginImpl implements LoginService {

    WebDriver driver;

    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(LoginImpl.class);

    public LoginImpl(WebDriver driver) {
        this.driver = driver;
    }

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
