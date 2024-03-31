package domain

import model.Expense
import model.ExpenseCategory

interface ExpenseRepository {
    suspend fun getAllExpenses(): List<Expense>
    suspend fun addExpense(expense: Expense)
    suspend fun removeExpense(expense: Expense)
    suspend fun updateExpense(expense: Expense)
    suspend fun getExpenseById(id: Long): Expense?
    suspend fun getCategories(): List<ExpenseCategory>
}