
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingList {
    // Create an ArrayList to store shopping items
    ArrayList<String> items = new ArrayList<>();
    // Create an ArrayList to store item amounts
    ArrayList<Double> amounts = new ArrayList<>();

    // Function to add items to the list
    public void addToList(String item, double amount) {
        items.add(item);
        amounts.add(amount);
        System.out.println(item + " added to the shopping list.");
    }

    // Function to remove items from the list
    // if user wants to make adjustment to its shopping list
    public void removeFromList(String item) {
        int index = items.indexOf(item);
        if (index >= 0) {
            items.remove(index);
            amounts.remove(index);
            System.out.println(item + " removed from the shopping list.");
        } else {
            System.out.println(item + " not found in the shopping list.");
        }
    }

    // Function to display the list
    public void displayList() {
        if (items.size() == 0) {
            System.out.println("The shopping list is empty.");
        } else {
            System.out.println("Shopping list:");
            for (int i = 0; i < items.size(); i++) {
                System.out.println(items.get(i) + ": $" + amounts.get(i));
            }
        }
    }

    // Function to compute and display the total expenses
    public void displayTotalExpenses() {
        double total = 0;
        for (double amount : amounts) {
            total += amount;
        }
        System.out.println("Total expenses: $" + total);
    }

    // Function to get the total expenses
    private double getTotalExpenses() {
        double total = 0;
        for (double amount : amounts) {
            total += amount;
        }
        return total;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingList myShoppingList = new ShoppingList();

        while (true) {
            System.out.println("Enter '1' to add an item, '2' to remove an item, '3' to display the list, '4' to view total expenses, or '5' to quit:");
            int command = scanner.nextInt();
            scanner.nextLine();

            if (command == 1) {
                System.out.println("Enter an item to add to the shopping list:");
                String item = scanner.nextLine();
                System.out.println("Enter the amount for " + item + ":");
                double amount = 0;
                boolean validInput = false;
                while (!validInput) {
                    try {
                        amount = Double.parseDouble(scanner.nextLine());
                        if (amount > 60 - myShoppingList.getTotalExpenses()) {
                            System.out.println("Amount exceeds remaining budget of $" + (60 - myShoppingList.getTotalExpenses()) + ". Please enter a smaller amount:");
                        } else {
                            validInput = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid amount:");
                    }
                }
                myShoppingList.addToList(item, amount);
            } else if (command == 2) {
                System.out.println("Enter an item to remove from the shopping list:");
                String item = scanner.nextLine();
                myShoppingList.removeFromList(item);
            } else if (command == 3) {
                myShoppingList.displayList();
            } else if (command == 4) {
                myShoppingList.displayTotalExpenses();
            } else if (command == 5) {
            	 System.out.println("Thank you for shopping. Goodbye!");
                break;
            } else {
                System.out.println("Invalid command. Please try again.");
                scanner.close();
            }
        }
    }
    
}
