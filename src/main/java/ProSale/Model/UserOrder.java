package ProSale.Model;


public class UserOrder {
    private User user;
    private String nameRoomOrder;
    private GuestOrder timeOrder;

    public void UserOrder(User user, String nameRoomOrder, GuestOrder timeOrder) {
        this.user = user;
        this.nameRoomOrder = nameRoomOrder;
        this.timeOrder = timeOrder;
    }

}
