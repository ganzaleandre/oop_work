package hotelmanagementsystem;

public class Billing extends HotelService {

    public Billing(GuestInfo guestInfo) {
        super(guestInfo);
    }

    @Override
    public void generateBill() {
        int ratePerNight;
        switch (guestInfo.getRoomType()) {
            case "STANDARD":
                ratePerNight = 50000;
                break;
            case "DELUXE":
                ratePerNight = 80000;
                break;
            case "SUITE":
                ratePerNight = 120000;
                break;
            default:
                System.out.println("Invalid room type.");
                return;
        }
        int totalCost = guestInfo.getStayDays() * ratePerNight;

        System.out.println("\n----- BILL SUMMARY -----");
        System.out.println("Guest Name : " + guestInfo.getGuestName());
        System.out.println("Guest ID   : " + guestInfo.getGuestId());
        System.out.println("Room Type  : " + guestInfo.getRoomType());
        System.out.println("Stay Days  : " + guestInfo.getStayDays());
        System.out.println("Total Cost : " + totalCost + " RWF");
        System.out.println("------------------------");
    }

    @Override
    public void bookRoom() {
    }

    @Override
    public void checkoutGuest() {
    }

}
