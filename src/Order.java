import java.util.UUID;

public class Order {
    private UUID orderId;
    private static int counter = 0;
    private int orderNumber;
    private Cart cartToOrder;
    private int orderSum;

    public Order(Cart cartToOrder) {
        this.orderId = UUID.randomUUID();
        counter++;
        this.orderNumber = counter;
        this.cartToOrder = cartToOrder;
        this.orderSum = cartToOrder.getCartSum();
    }

    public UUID getOrderId() {
        return orderId;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Cart getCartToOrder() {
        return cartToOrder;
    }

    public void showOrderDetail() {
        System.out.println("Заказ №" + this.orderNumber);
        // вывод шапки Корзины
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("|%-20s  |  %7s  |  %7s  |  %7s |%n", "Наименование товара", "Количество", "Цена/за ед.", "Общая стоимость");
        System.out.println("--------------------------------------------------------------------------");

        int total = 0;

        for (Product product : this.getCartToOrder().getProductsInCart()) {
            System.out.printf(
                    "|%-20s  |  %10s  |  %11s  |  %15s |%n",
                    product.getProductName(),
                    product.getInCartCount(),
                    product.getProductPrice(),
                    (product.getInCartCount() * product.getProductPrice())
            );
            total += (product.getInCartCount() * product.getProductPrice());
        }
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%73s", "Итого " + total + " руб.");
    }

    public int getOrderSum() {
        return this.orderSum;
    }
}
