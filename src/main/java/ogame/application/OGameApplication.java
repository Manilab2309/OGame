package ogame.application;

import ogame.services.ActionsImpl;
import ogame.services.LoginImpl;
import ogame.util.Browser;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OGameApplication {

    /** Browser */
    private static WebDriver driver = Browser.launch();

    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(OGameApplication.class);

    public static void main(String[] args) {

       // logger.info("OGAME!!!");
       // logger.info(Constants.Messages.OGAME_LOGO);

        /** Login OGame Page */
        LoginImpl login = new LoginImpl(driver);
        login.logInOGame();



        ActionsImpl actions = new ActionsImpl(driver);
        actions.checkStatus();

        //actions.sendMailMessage();



    }
}
