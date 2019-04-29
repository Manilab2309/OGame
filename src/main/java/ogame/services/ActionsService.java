package ogame.services;

import ogame.exceptions.OGameNoSuchWebElementException;

public interface ActionsService {

    /** Check if your planet is under attack*/
    void checkStatus() throws OGameNoSuchWebElementException;

    /** Get out full fleet with full resources*/
    void fleetEvacuation();

    /** Send an email notification */
    void sendMailMessage();

}
