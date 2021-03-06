package ogame.services;

import ogame.util.Constants;
import ogame.webpages.AccountPage;
import ogame.webpages.HubLoginPage;
import ogame.webpages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class LoginImpl implements LoginService {

    private WebDriver driver;

    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(LoginImpl.class);

    public LoginImpl(WebDriver driver) {
        this.driver = driver;
    }

    public void logInOGame() {

        LoginPage loginPage = new LoginPage(driver);

        logger.info(Constants.Messages.OGAME_DEBUG_PREFIX + "Accediendo a OGame...");
        driver.get("https://es.ogame.gameforge.com/");

        loginPage.getTabEntrar().click();
        loginPage.getTxtEmail().sendKeys(Constants.Credentials.OGAME_USERMAIL);
        loginPage.getTxtPass().sendKeys(Constants.Credentials.OGAME_USERPASS);
        loginPage.getEntrarBtn().click();

        logger.info(Constants.Messages.OGAME_DEBUG_PREFIX + "Credenciales validadas...");

        driver.manage().timeouts().setScriptTimeout(15,SECONDS);

        HubLoginPage hubLoginPage = new HubLoginPage(driver);
        hubLoginPage.getJugarBtn().click();
        logger.info(Constants.Messages.OGAME_DEBUG_PREFIX + "Accediendo a cuentas...");

        //driver.get("https://lobby.ogame.gameforge.com/es_ES/accounts");

        driver.manage().timeouts().setScriptTimeout(5,SECONDS);
        AccountPage accountPage = new AccountPage(driver);
        accountPage.getJugarBtn().click();

        logger.info(Constants.Messages.OGAME_DEBUG_PREFIX + "Accediendo a Lobby...");

    }

    public void logOutOGame() {

    }
}
