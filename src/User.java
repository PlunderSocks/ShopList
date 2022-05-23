import java.util.ArrayList;
import java.util.UUID;

public class User {

    private UUID userId;
    private String name;
    private ArrayList<Order> ordersList;

    public User() {
        this.userId = UUID.randomUUID();
    }

    public UUID getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Order> getOrdersList() {
        return ordersList;
    }

    public void showUserOrders() {
        if(this.ordersList.size()>0) {
            for (Order order: this.ordersList) {
                System.out.println("| " + order.getOrderNumber() + " | " + order.getOrderSum() + " руб. |");
            }
        } else {
            System.out.println("Нет оформленных заказов!");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrdersList(ArrayList<Order> ordersList) {
        this.ordersList = ordersList;
    }

    public void addOrderInOrderList(Order order) {
        this.ordersList.add(order);
    }
}
