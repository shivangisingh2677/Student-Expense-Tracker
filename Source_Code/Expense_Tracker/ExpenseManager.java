package expense_tracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {

    private List<Expense> expenses;
    private int nextId;

    public ExpenseManager() {
        expenses = FileManager.loadExpenses();
        nextId = 1;

        for (Expense expense : expenses) {
            if (expense.getId() >= nextId) {
                nextId = expense.getId() + 1;
            }
        }
    }

    public void addExpense(String description, double amount,
                            String category) {

        Expense expense = new Expense(
                nextId++,
                description,
                amount,
                category,
                LocalDate.now()
        );

        expenses.add(expense);
        FileManager.saveExpenses(expenses);

        System.out.println("\nExpense added successfully!");
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("\nNo expenses recorded.");
            return;
        }

        System.out.println("\n===== ALL EXPENSES =====");

        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    public void searchExpense(String keyword) {
        boolean found = false;

        System.out.println("\n===== SEARCH RESULTS =====");

        for (Expense expense : expenses) {
            if (expense.getDescription()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())) {

                System.out.println(expense);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching expenses found.");
        }
    }

    public void deleteExpense(int id) {
        Expense foundExpense = null;

        for (Expense expense : expenses) {
            if (expense.getId() == id) {
                foundExpense = expense;
                break;
            }
        }

        if (foundExpense != null) {
            expenses.remove(foundExpense);
            FileManager.saveExpenses(expenses);
            System.out.println("\nExpense deleted successfully!");
        } else {
            System.out.println("\nExpense ID not found.");
        }
    }

    public void generateSummary() {
        if (expenses.isEmpty()) {
            System.out.println("\nNo data available for summary.");
            return;
        }

        double total = 0;

        Map<String, Double> categoryTotals = new HashMap<>();

        for (Expense expense : expenses) {
            total += expense.getAmount();

            categoryTotals.put(
                    expense.getCategory(),
                    categoryTotals.getOrDefault(
                            expense.getCategory(), 0.0
                    ) + expense.getAmount()
            );
        }

        System.out.println("\n===== EXPENSE SUMMARY =====");
        System.out.printf("Total Expenses: ₹%.2f%n", total);

        System.out.println("\nCategory-wise Breakdown:");

        for (Map.Entry<String, Double> entry :
                categoryTotals.entrySet()) {

            System.out.printf(
                    "%s: ₹%.2f%n",
                    entry.getKey(),
                    entry.getValue()
            );
        }
    }
}
