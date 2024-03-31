package domain

import data.ExpenseManager
import model.Expense
import model.ExpenseCategory

class ExpenseRepositoryImpl: ExpenseRepository {


    override suspend fun getAllExpenses() = ExpenseManager.getAllExpenses()


    override suspend fun addExpense(expense: Expense) {
        ExpenseManager.addNewExpense(expense)
    }

    override suspend fun removeExpense(expense: Expense) {
        TODO("Not yet implemented")
    }

    override suspend fun updateExpense(expense: Expense) {
        ExpenseManager.onEditExpense(expense)
    }

    override suspend fun getExpenseById(id: Long): Expense? {
        return ExpenseManager.getExpenseById(id)
    }

    override suspend fun getCategories(): List<ExpenseCategory> {
        return ExpenseManager.getCategories()
    }
}