import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Product> productsInSale = new ArrayList<>(); // новый список Продуктов в продаже

        productsInSale.add(new Product("Хлеб", 100));
        productsInSale.add(new Product("Яблоки", 200));
        productsInSale.add(new Product("Молоко", 300));
        productsInSale.add(new Product("Мясо", 450));
        productsInSale.add(new Product("Рыба", 750));
        productsInSale.add(new Product("Соль", 70));
        productsInSale.add(new Product("Сахар", 130));

        Cart userCart = new Cart(); // новая Корзина

        User user = new User(); // новый пользователь

        user.setOrdersList(new ArrayList<>()); // добавляем список Заказов Пользователя


        // Главный цикл
        while (true) {

            Product.showProductList("\nСписок возможных товаров для покупки", productsInSale);
            actionList();

            System.out.println("Please, select option : ");
            String inputString = scanner.nextLine();

            if (inputString.equals("end") || inputString.equals("exit") || inputString.equals("close")) {
                System.out.println("\nПрограмма завершена!");
                System.out.println("\nВаша корзина:");
                userCart.showProductsInCart(false); // показать Корзину
                System.out.println("\nВаши заказы:");
                user.showUserOrders(); // показать Заказы Пользователя
                break;
            } else if (inputString.equals("show")) {
                System.out.println(userCart.getCartTitle());
                userCart.showProductsInCart(false);
            } else if (inputString.equals("clear")) {
                if (userCart.clearCart()) {
                    System.out.println("Корзина очищена!\n");
                } else {
                    System.out.println("Ошибка очистки Корзины!\n");
                }
            } else if (inputString.equals("allorders")) {
                user.showUserOrders();
            } else if (inputString.equals("order")) {
                if(userCart.getProductsInCart().size() > 0) {
                    user.addOrderInOrderList(new Order(userCart));
                    System.out.println("Оформлен новый Заказ на сумму " + userCart.getCartSum() + " руб.!");
                    userCart.clearCart();
                    System.out.println("Корзина очищена!\n");
                } else {
                    System.out.println("Нет Продуктов в Корзине для оформления Заказа!");
                    System.out.println("Добавьте Продукты в Корзину!\n");
                }

            } else {
                String[] arr = inputString.split("\\s");
                int productNumber = Integer.parseInt(arr[0]) - 1; // номер Продукта
                int productCount = Integer.parseInt(arr[1]); // количество Продукта
                // добавили товар в Корзину;
                if(productNumber >= 0 && productNumber <= productsInSale.size()) {
                    userCart.addProduct(productsInSale.get(productNumber), productCount);
                    System.out.println("Продукт '" + productsInSale.get(productNumber).getProductName()
                            + "' в количестве " + productCount + " добавлен в Корзину!");
                } else {
                    System.out.println("Нет товара с таким номером!");
                }

            }

        }
    }

    public static void actionList() {
        StringBuilder actionList = new StringBuilder();
        actionList.append("Выберите товар и количество или:\n");
        actionList.append("`show` - показать Корзину\n");
        actionList.append("`clear` - очистить Корзину\n");
        actionList.append("------------------------------\n");
        actionList.append("`allorders` - показать Заказы\n");
        actionList.append("`order` - оформить Заказ\n");
        actionList.append("------------------------------\n");
        actionList.append("`end` - для выхода из программы\n");
        System.out.println(actionList);
    }

}
