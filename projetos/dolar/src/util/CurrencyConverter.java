package util;

public class CurrencyConverter {
    public static final double PERCENTAGE = 1.06;

    public static double payment(double price, double buyingDollars) {
        return price * buyingDollars * PERCENTAGE;
    }

}
