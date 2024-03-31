package data

import model.Expense
import model.ExpenseCategory

object ExpenseManager {

    private var currentId = 1L
    private val expenses = mutableListOf<Expense>()
    val fakeExpenses = mutableListOf(
        Expense(currentId++, 12.0, ExpenseCategory.ENTERTAINMENT, "Lunch"),
        Expense(currentId++, 25.0, ExpenseCategory.TRANSPORTATION, "Taxi"),
        Expense(currentId++, 32.0, ExpenseCategory.ENTERTAINMENT, "Cinema"),
        Expense(currentId++, 23.54, ExpenseCategory.GROCERIES, "Supermarket"),
        Expense(currentId++, 52.12, ExpenseCategory.TRANSPORTATION, "Bus"),
        Expense(currentId++, 69.12, ExpenseCategory.PARTY, "Dinner"),
        Expense(currentId++, 73.0, ExpenseCategory.COFFEE, "Coffe shop"),
        Expense(currentId++, 73.0, ExpenseCategory.UTILITIES, "Electricity"),
        Expense(currentId++, 85.0, ExpenseCategory.TRANSPORTATION, "Metro"),
        Expense(currentId++, 96.0, ExpenseCategory.COFFEE, "Breakfast"),
        Expense(currentId++, 102.0, ExpenseCategory.TRANSPORTATION, "Train"),
        Expense(currentId++, 120.3, ExpenseCategory.HOUSE, "Rent"),
    )

    fun addNewExpense(expense: Expense) {
        fakeExpenses.add(expense.copy(id = currentId++))
    }

    fun onEditExpense(expense: Expense) {
        val index = fakeExpenses.indexOfFirst { it.id == expense.id }
        if (index != -1) {
            fakeExpenses[index] = fakeExpenses[index].copy(
                amount = expense.amount,
                category = expense.category,
                description = expense.description
            )
        }
    }

    fun getCategories(): List<ExpenseCategory> {
        return ExpenseCategory.entries
    }

    fun getExpenseById(id: Long): Expense? {
        return fakeExpenses.find { it.id == id }
    }


    fun getAllExpenses(): List<Expense> {
        return expenses
    }
}