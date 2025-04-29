package hotelmanagementsystem;

public class RoomBooking extends HotelService {

    public RoomBooking(GuestInfo guestInfo) {
        super(guestInfo);
    }

    @Override
    public void bookRoom() {
        if (guestInfo.getStayDays() < 1 || guestInfo.getStayDays() > 30) {
            System.out.println("Error: Stay duration must be between 1 and 30 days.");
            return;
        }
        if (!guestInfo.getRoomStatus().equals("AVAILABLE")) {
            System.out.println("Error: Room is not available for booking.");
            return;
        }
        guestInfo.setRoomStatus("OCCUPIED");
        System.out.println("Booking confirmed for " + guestInfo.getGuestName() + " (" + guestInfo.getGuestId()
                + "). Room is now OCCUPIED.");
    }

    @Override
    public void checkoutGuest() {
    }

    @Override
    public void generateBill() {
    }

}
