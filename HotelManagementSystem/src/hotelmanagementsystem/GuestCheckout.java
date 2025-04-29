package hotelmanagementsystem;

public class GuestCheckout extends HotelService {

    public GuestCheckout(GuestInfo guestInfo) {
        super(guestInfo);
    }

    @Override
    public void checkoutGuest() {
        if (guestInfo.getRoomStatus().equals("AVAILABLE")) {
            System.out.println("Error: Room is already available. No guest to checkout.");
            return;
        }
        guestInfo.setRoomStatus("AVAILABLE");
        System.out.println("Guest " + guestInfo.getGuestName() + " (" + guestInfo.getGuestId()
                + ") has been checked out. Room is now AVAILABLE.");
    }

    @Override
    public void bookRoom() {
    }

    @Override
    public void generateBill() {
    }
}
