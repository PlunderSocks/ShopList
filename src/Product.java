import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Product implements Soldable {

    private final UUID productId;
    private String productName;
    private int productPrice;
    private int inCartCount = 0;

    public Product(String productName, int productPrice) {
        this.productId = UUID.randomUUID();
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public UUID getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public int getInCartCount() {
        return inCartCount;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public void setInCartCount(int inCartCount) {
        this.inCartCount = inCartCount;
    }

    // вывод в консоль списка товаров
    static public void showProductList(String listTitle, ArrayList<Product> productsInSale) {
        // Выводим Список Продуктов в консоль
        System.out.println(listTitle);
        if (productsInSale.size() > 0) {
            for (int i = 0; i < productsInSale.size(); i++) {
                System.out.println("| " + (i + 1) + " | " + productsInSale.get(i).getProductName()
                        + " | " + productsInSale.get(i).getProductPrice() + " руб/шт. | ");
            }
        } else {
            System.out.println("Список Продуктов пуст!");
        }
    }

    @Override
    public String toString() {
        return "Product { " +
                " productId = " + productId +
                ", productName = '" + productName + '\'' +
                ", productPrice = '" + productPrice +
                "'} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getProductPrice() == product.getProductPrice() && getProductId().equals(product.getProductId())
                && getProductName().equals(product.getProductName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getProductName(), getProductPrice());
    }
}