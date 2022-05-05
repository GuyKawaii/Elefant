import java.util.Scanner;

// controller and userInterface
public class UserInterface {
  Scanner in = new Scanner(System.in);
  
  public void run() {
    Order order = new Order();
    double itemQuantity;
    double itemPrice;
    double taxRate;
    String userInput;
    boolean moreItems = true;
    
    // Order items
    do {
      System.out.print("enter number of a given item: ");
      itemQuantity = Double.parseDouble(in.nextLine());
      
      System.out.print("enter price for gien item: ");
      itemPrice = Double.parseDouble(in.nextLine());
      
      order.addItem(itemPrice, itemQuantity);
      
      System.out.print("[Enter] to continue or [M] for more items: ");
      userInput = in.nextLine();
      
      if (userInput.isBlank()) moreItems = false;
    } while (moreItems);
    
    System.out.print("enter tax-rate or state: ");
    userInput = in.nextLine();
    try {
      order.setTaxRate(Double.parseDouble(userInput));
    } catch (Exception e) {
      order.setTaxRate(userInput);
    }
    
    // calculate total:
    System.out.println(order.getTotalAfterDiscountAndTax());
  }
  
  public static void main(String[] args) {
    new UserInterface().run();
  }
}
