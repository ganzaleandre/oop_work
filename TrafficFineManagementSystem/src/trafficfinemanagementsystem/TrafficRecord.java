package trafficfinemanagementsystem;


public abstract class TrafficRecord {

    protected DriverViolationInfo info;

    public TrafficRecord(DriverViolationInfo info) {
        this.info = info;
    }

    public abstract void recordViolation();

    public abstract void assessFine();

    public abstract void processPayment();
    
}
