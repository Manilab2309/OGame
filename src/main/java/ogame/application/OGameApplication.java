package ogame.application;

import ogame.services.LoginImpl;
import ogame.util.Constants;

public class OGameApplication {

    /** Logger */
   // private static final Logger logger = LoggerFactory.getLogger(OGameApplication.class);

    public static void main(String[] args) {

       // logger.info("OGAME!!!");
       // logger.info(Constants.Messages.OGAME_LOGO);

        /** Login OGame Page */
        LoginImpl login = new LoginImpl();
        login.logInOGame();



    }
}
