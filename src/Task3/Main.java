package Task3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Cost {
    int cost;
    final String currency = "UAN";

    public Cost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getCurrency() {
        return currency;
    }
}

class Price {
    String nameOfProduct;
    String nameOfShop;
    Cost cost;

    public Price(String nameOfProduct, String nameOfShop, Cost cost) {
        this.nameOfProduct = nameOfProduct;
        this.nameOfShop = nameOfShop;
        this.cost = cost;
    }
    public Price(){}

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public String getNameOfShop() {
        return nameOfShop;
    }

    public void setNameOfShop(String nameOfShop) {
        this.nameOfShop = nameOfShop;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public String toString() {
        return "Name of Shop - " + nameOfShop + ", name of product - " + nameOfProduct + ", cost - " + cost.getCost() + " " + cost.getCurrency();
    }
}

public class Main {
    public static void main(String[] args) {
        Price[] prices = new Price[2];
        for(int i = 0; i < prices.length; ++i) {
            prices[i] = new Price();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Name of product: ");
            prices[i].setNameOfProduct(scanner.nextLine());
            System.out.println("Name of shop: ");
            prices[i].setNameOfShop(scanner.nextLine());
            System.out.println("Cost of product: ");
            Cost cost = new Cost(scanner.nextInt());
            prices[i].setCost(cost);
        }
        Comparator<Price> priceComparator = Comparator.comparing(Price::getNameOfShop);
        Arrays.sort(prices, priceComparator);
        for(int i = 0; i < prices.length; ++i)
        {
            System.out.println(prices[i].toString());
        }
        System.out.println();
        System.out.println("Enter the name of shop to see price. Shops: ");
        for(int i = 0; i < prices.length; ++i) {
            System.out.println((i + 1) +". " + prices[i].getNameOfShop());
        }
        Scanner scanner = new Scanner(System.in);
        String buf = scanner.nextLine();
        int check = 0;
        try {
            for(int i = 0; i < prices.length; ++i) {
                if(buf.equals(prices[i].getNameOfShop())) {
                    System.out.println(prices[i].toString());
                }
                else {
                    check++;
                }
            }
            if(check == prices.length)
                throw new Exception("Wrong name of shop");
        }catch (Exception e) {
            System.out.println("Exception Handling");
            System.out.println(e.getMessage());
        }

    }
}
