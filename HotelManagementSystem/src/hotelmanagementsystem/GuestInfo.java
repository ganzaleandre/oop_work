package hotelmanagementsystem;

public class GuestInfo {

    private String guestId;
    private String guestName;
    private String roomType;
    private int stayDays;
    private String roomStatus;

    public GuestInfo(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.roomType = roomType.toUpperCase();
        this.stayDays = stayDays;
        this.roomStatus = roomStatus.toUpperCase();
    }

    public String getGuestId() {
        return guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getStayDays() {
        return stayDays;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus.toUpperCase();
    }
}
