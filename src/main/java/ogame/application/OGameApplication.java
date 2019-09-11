package ogame.application;

import ogame.exceptions.OGameNoSuchWebElementException;
import ogame.services.ActionsImpl;
import ogame.services.LoginImpl;
import ogame.util.Browser;
import ogame.util.Constants;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.concurrent.TimeUnit.SECONDS;


public class OGameApplication {

    /** Browser */
    private static WebDriver driver = Browser.launch();

    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(OGameApplication.class);

    public static void main(String[] args) {

        try {
            logger.info(Constants.Messages.OGAME_LOGO);

            /** Login OGame Page */
            LoginImpl login = new LoginImpl(driver);
            login.logInOGame();

            driver.manage().timeouts().setScriptTimeout(5,SECONDS);

            logger.info(Constants.Messages.OGAME_DEBUG_PREFIX + "Lobby cargado");
            driver.navigate().to("https://s160-es.ogame.gameforge.com/game/index.php?page=overview&relogin=1");

            driver.manage().timeouts().setScriptTimeout(5,SECONDS);

            ActionsImpl actions = new ActionsImpl(driver);

            // actions.test();

            try {
                logger.info(Constants.Messages.OGAME_DEBUG_PREFIX + "Comprobando amenaza...");
                actions.checkStatus();
            } catch (OGameNoSuchWebElementException exc) {
                logger.info(Constants.Messages.OGAME_DEBUG_PREFIX + "SISTEMAS SIN AMENAZAS");
            }

            driver.quit();

        }catch (Exception e){
            logger.info(Constants.Messages.OGAME_DEBUG_PREFIX + "Se ha producido un error, se cierra el Driver de Chrome");
            driver.quit();
        }

    }
}
