# Student Expense Tracker

## Overview

Student Expense Tracker is a Java-based console application that helps users record, manage, search, and analyze their daily expenses.

The project demonstrates Object-Oriented Programming, file handling, collections, modular design, input validation, and exception handling in Java.

## Features

* Add new expenses
* Assign expenses to categories
* View all expenses
* Search expenses by description
* Delete expenses using ID
* Generate total expense summaries
* Generate category-wise expense reports
* Store data locally in a text file
* Validate user inputs
* Handle invalid menu choices

## Functional Modules

### 1. Expense Management

* Add expenses
* View expenses
* Delete expenses

### 2. Search and Categorization

* Search expenses by description
* Categorize expenses into predefined categories

### 3. Reporting and Analytics

* Calculate total expenses
* Display category-wise spending

### 4. Data Persistence

* Save expenses to a local file
* Load expenses when the application starts

## Technologies Used

* Java
* Object-Oriented Programming
* Java Collections Framework
* File Handling
* Exception Handling
* Java Time API
* Git and GitHub

## Requirements

* Java JDK 8 or above
* Any Java-compatible IDE or terminal
* Git (optional, for version control)

## Project Structure

```text
StudentExpenseTracker/
│
├── README.md
├── statement.md
│
├── src/
│   └── expense_tracker/
│       ├── Main.java
│       ├── Expense.java
│       ├── ExpenseManager.java
│       └── FileManager.java
│
└── data/
    └── expenses.txt
```

## How to Run

### Step 1: Clone the Repository

```bash
git clone <>
```


```

## Sample Menu

```text
========== MAIN MENU ==========
1. Add Expense
2. View All Expenses
3. Search Expense
4. Delete Expense
5. Generate Summary Report
6. Exit
===============================
```

## Data Storage

Expense records are stored in:

```text
data/expenses.txt
```

The file is automatically created when the first expense is saved.

## Testing

The application can be tested using the following scenarios:

| Test Case                  | Expected Result                           |
| -------------------------- | ----------------------------------------- |
| Add valid expense          | Expense is added                          |
| Enter negative amount      | Validation message displayed              |
| View expenses when empty   | No expenses message                       |
| Search existing keyword    | Matching expenses displayed               |
| Search unavailable keyword | No matching expenses message              |
| Delete valid ID            | Expense removed                           |
| Delete invalid ID          | Error message displayed                   |
| Generate report            | Total and category-wise summary displayed |
| Invalid menu choice        | Invalid choice message                    |
| Restart application        | Previously saved data is loaded           |

## Future Enhancements

* Monthly budget limits
* Graphical user interface
* Database integration
* Export reports to CSV
* User login system
* Monthly and yearly analytics

