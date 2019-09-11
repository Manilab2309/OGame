package ogame.entity;

public class Event {

    String originFleet;
    String arrivalTime;
    String destination;

    public Event(String originFleet, String arrivalTime, String destination) {
        this.originFleet = originFleet;
        this.arrivalTime = arrivalTime;
        this.destination = destination;
    }

    public String getOriginFleet() {
        return originFleet;
    }

    public void setOriginFleet(String originFleet) {
        this.originFleet = originFleet;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
