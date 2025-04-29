
package trafficfinemanagementsystem;

public class DriverViolationInfo {

    private String driverId;
    private String driverName;
    private String vehiclePlate;
    private String violationType;
    private double fineAmount;
    private String paymentStatus = "UNPAID";

    public DriverViolationInfo(String driverId, String driverName, String vehiclePlate, String violationType) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.vehiclePlate = vehiclePlate;
        this.violationType = violationType;
    }

    // Getters
    public String getDriverId() {
        return driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public String getViolationType() {
        return violationType;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    // Setters
    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public void setViolationType(String violationType) {
        this.violationType = violationType;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

}
