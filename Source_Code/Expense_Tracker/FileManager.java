package expense_tracker;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final String FILE_PATH = "data/expenses.txt";

    public static void saveExpenses(List<Expense> expenses) {
        try {
            File directory = new File("data");

            if (!directory.exists()) {
                directory.mkdir();
            }

            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(FILE_PATH));

            for (Expense expense : expenses) {
                writer.write(expense.toFileFormat());
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Error: Unable to save expenses.");
        }
    }

    public static List<Expense> loadExpenses() {
        List<Expense> expenses = new ArrayList<>();

        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return expenses;
        }

        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");

                if (data.length == 5) {
                    int id = Integer.parseInt(data[0]);
                    String description = data[1];
                    double amount = Double.parseDouble(data[2]);
                    String category = data[3];
                    LocalDate date = LocalDate.parse(data[4]);

                    expenses.add(new Expense(
                            id, description, amount, category, date
                    ));
                }
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error: Unable to load expenses.");
        }

        return expenses;
    }
}
