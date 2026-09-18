package expense_tracker;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ExpenseManager manager = new ExpenseManager();

    public static void main(String[] args) {

        boolean running = true;

        System.out.println("====================================");
        System.out.println("       STUDENT EXPENSE TRACKER      ");
        System.out.println("====================================");

        while (running) {

            displayMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addExpense();
                    break;

                case 2:
                    manager.viewExpenses();
                    break;

                case 3:
                    String keyword = readString(
                            "Enter search keyword: "
                    );
                    manager.searchExpense(keyword);
                    break;

                case 4:
                    int id = readInt(
                            "Enter expense ID to delete: "
                    );
                    manager.deleteExpense(id);
                    break;

                case 5:
                    manager.generateSummary();
                    break;

                case 6:
                    running = false;
                    System.out.println(
                            "\nThank you for using Student Expense Tracker!"
                    );
                    break;

                default:
                    System.out.println(
                            "\nInvalid choice. Please try again."
                    );
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. Add Expense");
        System.out.println("2. View All Expenses");
        System.out.println("3. Search Expense");
        System.out.println("4. Delete Expense");
        System.out.println("5. Generate Summary Report");
        System.out.println("6. Exit");
        System.out.println("===============================");
    }

    private static void addExpense() {

        String description = readString(
                "Enter expense description: "
        );

        double amount;

        while (true) {
            amount = readDouble("Enter expense amount: ");

            if (amount > 0) {
                break;
            }

            System.out.println(
                    "Amount must be greater than zero."
            );
        }

        System.out.println("\nSelect Category:");
        System.out.println("1. Food");
        System.out.println("2. Transport");
        System.out.println("3. Education");
        System.out.println("4. Entertainment");
        System.out.println("5. Shopping");
        System.out.println("6. Other");

        int categoryChoice = readInt("Enter category choice: ");

        String category;

        switch (categoryChoice) {
            case 1:
                category = "Food";
                break;
            case 2:
                category = "Transport";
                break;
            case 3:
                category = "Education";
                break;
            case 4:
                category = "Entertainment";
                break;
            case 5:
                category = "Shopping";
                break;
            case 6:
                category = "Other";
                break;
            default:
                category = "Other";
                System.out.println(
                        "Invalid category. Assigned as Other."
                );
        }

        manager.addExpense(description, amount, category);
    }

    private static int readInt(String message) {

        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid input. Please enter a number."
                );
            }
        }
    }

    private static double readDouble(String message) {

        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid amount. Please try again."
                );
            }
        }
    }

    private static String readString(String message) {

        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty() && !input.contains("|")) {
                return input;
            }

            System.out.println(
                    "Input cannot be empty or contain '|'."
            );
        }
    }
}
