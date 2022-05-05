import java.util.ArrayList;

public class Order {
  private ArrayList<Double> itemsPrice;
  private java.util.ArrayList<Double> itemsQuantity;
  private double taxRate;
  
  public Order() {
    itemsPrice = new ArrayList<>();
    itemsQuantity = new ArrayList<>();
  }
  
  public void addItem(double price, double quantity, double percentTaxRate) {
    itemsPrice.add(price);
    itemsQuantity.add(quantity);
    this.taxRate = percentTaxRate / 100;
  }
  
  public void addItem(double price, double quantity) {
    itemsPrice.add(price);
    itemsQuantity.add(quantity);
  }
  
  public void setTaxRate(double percentTaxRate) {
    this.taxRate = percentTaxRate / 100;
  }
  
  public void setTaxRate(String state) {
    if (state.equalsIgnoreCase("UT")) taxRate = 0.06_85;
    else if (state.equalsIgnoreCase("NV")) taxRate = 0.08_00;
    else if (state.equalsIgnoreCase("TX")) taxRate = 0.06_25;
    else if (state.equalsIgnoreCase("AL")) taxRate = 0.04_00;
    else if (state.equalsIgnoreCase("CA")) taxRate = 0.08_25;
    else taxRate = 0.08_25;
  }
  
  public ArrayList<Double> getItemsPrice() {
    return itemsPrice;
  }
  
  public ArrayList<Double> getItemsQuantity() {
    return itemsQuantity;
  }
  
  public double getTotal() {
    double total = 0;
    
    for (int i = 0; i < itemsPrice.size(); i++) {
      total += itemsPrice.get(i) * itemsQuantity.get(i);
    }
    
    return total;
  }
  
  public double getTotalAfterDiscountAndTax() {
    double totalWithDiscount = getTotalAfterDiscount();
    
    return totalWithDiscount + (totalWithDiscount * taxRate);
  }
  
  public double getTotalAfterDiscount() {
    double total = getTotal();
    double discount;
    
    if (total >= 50_000) discount = 0.15;
    else if (total >= 10_000) discount = 0.10;
    else if (total >= 7_000) discount = 0.07;
    else if (total >= 5_000) discount = 0.05;
    else if (total >= 1_000) discount = 0.03;
    else discount = 0;
    
    return total - (total * discount);
  }
  
  
}
