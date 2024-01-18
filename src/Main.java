import java.util.ArrayList;

record Customer(String name, ArrayList<Double> transactions) {}
record Bank(String bankName, ArrayList<Customer> customers) {
  public void addCustomer(Customer customer) {
    if (!customers.contains(customer)) {
      customers.add(customer);
    } else {
      System.out.println("Customer already exists...");
    }
  }
}

public class Main {
  public static void main(String[] args) {
    Integer boxed = 5;
    int unboxed = boxed;
    System.out.println(unboxed);
  }
}