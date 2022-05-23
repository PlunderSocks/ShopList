import java.util.ArrayList;
import java.util.UUID;

public class Cart {

    private final UUID cartId;
    private String cartTitle;
    private ArrayList<Product> productsInCart;

    // создать Корзину
    public Cart() {
        this.cartId = UUID.randomUUID();
        this.productsInCart = new ArrayList<>();
    }

    public Cart(String cartTitle) {
        this.cartId = UUID.randomUUID();
        this.cartTitle = cartTitle;
        this.productsInCart = new ArrayList<>();
    }

    public UUID getCartId() {
        return cartId;
    }

    public ArrayList<Product> getProductsInCart() {
        return productsInCart;
    }

    public String getCartTitle() {
        if (this.cartTitle != null) {
            return cartTitle;
        } else {
            return "Корзина";
        }
    }

    // Продукт с таким productId уже есть в Корзине?
    public boolean isProductInCart(UUID productId) {
        for (int i = 0; i < productsInCart.size(); i++) { // перебираем все продукты в Корзине
            if (productId.equals(productsInCart.get(i).getProductId())) return true;
        }
        return false;
    }

    // Вернуть Продукт из списка Продуктов в Корзине по productId
    public Product returnProductFromCartByProductId(UUID productId) {
        for (int i = 0; i < productsInCart.size(); i++) { // перебираем все продукты в Корзине
            if (productId.equals(productsInCart.get(i).getProductId())) {
                return productsInCart.get(i);
            }
        }
        return null;
    }


    // добавить Продукт в Корзину
    public void addProduct(Product product, int amount) {
        UUID productId = product.getProductId();
        if (isProductInCart(productId)) {
            int productCount = returnProductFromCartByProductId(productId).getInCartCount();
            returnProductFromCartByProductId(productId).setInCartCount(productCount + amount);
        } else {
            product.setInCartCount(amount);
            productsInCart.add(product);
        }
    }

    // показать продукты в Корзине
    public boolean showProductsInCart(boolean showProductId) {
        if (this.productsInCart.size() > 0) {
            // вывод шапки Корзины
            System.out.println("--------------------------------------------------------------------------");
            System.out.printf("|%-20s  |  %7s  |  %7s  |  %7s |%n", "Наименование товара", "Количество", "Цена/за ед.", "Общая стоимость");
            System.out.println("--------------------------------------------------------------------------");

            int total = 0;
            for (Product product : this.productsInCart) {
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
            return true;
        } else {
            System.out.println("Нет Продуктов в Корзине!");
            return false;
        }
    }

    // Вернуть сумму товаров в Корзине
    public int getCartSum() {
        int total = 0;
        for (Product product : this.productsInCart) {
            total += (product.getInCartCount() * product.getProductPrice());
        }
        return total;
    }

    // Очистить Корзину
    public boolean clearCart() {
        this.productsInCart.clear();
        if (productsInCart.size() == 0) return true;
        return false;
    }

    @Override
    public String toString() {
        return "Cart { " +
                "cartId = " + cartId +
                ", productsInCart = " + productsInCart +
                " } ";
    }
}
