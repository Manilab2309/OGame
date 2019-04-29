package ogame.application;

import ogame.exceptions.OGameNoSuchWebElementException;
import ogame.services.ActionsImpl;
import ogame.services.LoginImpl;
import ogame.util.Browser;
import ogame.util.Constants;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OGameApplication {

    /** Browser */
    private static WebDriver driver = Browser.launch();

    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(OGameApplication.class);

    public static void main(String[] args) {

        logger.info(Constants.Messages.OGAME_LOGO);

        /** Login OGame Page */
        LoginImpl login = new LoginImpl(driver);
        login.logInOGame();

        logger.info(Constants.Messages.OGAME_DEBUG_PREFIX + "Lobby cargado");

        ActionsImpl actions = new ActionsImpl(driver);
        try{
            logger.info(Constants.Messages.OGAME_DEBUG_PREFIX + "Comprobando amenaza...");
            actions.checkStatus();
        } catch(OGameNoSuchWebElementException exc){
            logger.info(Constants.Messages.OGAME_DEBUG_PREFIX + "SISTEMAS SIN AMENAZAS");
        }

        driver.quit();

    }
}
