package hotelmanagementsystem;

public abstract class HotelService {

    protected GuestInfo guestInfo;

    public HotelService(GuestInfo guestInfo) {
        this.guestInfo = guestInfo;
    }

    public abstract void bookRoom();
    public abstract void checkoutGuest();
    public abstract void generateBill();

}
