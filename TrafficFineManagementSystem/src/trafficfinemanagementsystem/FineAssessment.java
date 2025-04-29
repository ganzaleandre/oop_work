
package trafficfinemanagementsystem;


public class FineAssessment extends TrafficRecord {

    public FineAssessment(DriverViolationInfo info) {
        super(info);
    }

    @Override
    public void assessFine() {
        double amount;
        switch (info.getViolationType().toUpperCase()) {
            case "SPEEDING":
                amount = 50000;
                break;
            case "RED_LIGHT":
                amount = 80000;
                break;
            case "NO_HELMET":
                amount = 30000;
                break;
            case "DUI":
                amount = 150000;
                break;
            default:
                System.out.println("Unrecognized violation type.");
                return;
        }
        info.setFineAmount(amount);

        System.out.println("Fine Assessed:");
        System.out.println("Driver: " + info.getDriverName() + ", Violation: " + info.getViolationType());
        System.out.println("Fine Amount: " + info.getFineAmount() + " RWF");
    }

    @Override
    public void recordViolation() {}
    @Override
    public void processPayment() {}
}

