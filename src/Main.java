import java.util.ArrayList;
import java.util.Collections;

record Customer(String name, ArrayList<Double> transactions) {}
record Bank(String bankName, ArrayList<Customer> customers) {
  public void addCustomer(Customer customer) {
    if (!customers.contains(customer)) {
      customers.add(customer);
    } else {
      System.out.println("Customer already exists...");
    }
  }

  public void addCustomerTransaction(String customerName, double transaction) {
    int index = customers.indexOf(customerName);
    customers.get(index).transactions().add(transaction);
  }

  public void printStatement(String customerName) {
    int index = customers.indexOf(customerName);
    String customer = customers.get(index).name();
    ArrayList<Double> transactions = customers.get(index).transactions();

    System.out.printf("%s's transactions: \n", customer);
    System.out.println(transactions);
  }
}

public class Main {
  public static void main(String[] args) {

    Customer c1 = new Customer("Emmanuel", addTransactions(22.0, 120.0, -115.20, 250.5));
    Customer c2 = new Customer("Philip", addTransactions(55.20, 220.00, -93.25));
    Customer c3 = new Customer("Mike", addTransactions(12.0, 55.0, 100.0));

    System.out.println(c1);

    Bank chaseBank = new Bank("Chase Bank", addCustomers(c1, c2));
    chaseBank.addCustomer(c3);
    chaseBank.addCustomerTransaction("Mike", -25.70);
    chaseBank.printStatement("Emmanuel");
  }

  public static ArrayList<Double> addTransactions(double... transactions) {
    ArrayList<Double> list = new ArrayList<>();

    for (double transaction : transactions) {
      list.add(transaction);
    }
    return list;
  }

  public static ArrayList<Customer> addCustomers(Customer... customers) {
    ArrayList<Customer> list = new ArrayList<>();

    Collections.addAll(list, customers);
    return list;
  }
}