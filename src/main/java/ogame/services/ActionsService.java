package ogame.services;

public interface ActionsService {

    /** Check if your planet is under attack*/
    String checkStatus();

    /** Get out full fleet with full resources*/
    void fleetEvacuation();

    /** Send an email notification */
    void sendMailMessage();

}
