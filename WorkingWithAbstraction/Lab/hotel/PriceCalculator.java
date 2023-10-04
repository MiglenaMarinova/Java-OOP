package WorkingWithAbstraction.Lab.hotel;

public class PriceCalculator {

    public static double calculatePrice (double pricePerDay, int days, Season season, DiscountType discountType){
        double priceAllDays = pricePerDay * days;
        priceAllDays = priceAllDays * season.getValue();
        priceAllDays -= priceAllDays * (discountType.getPercent() / 100);

        return priceAllDays;
    }

}
