package model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Flight
import androidx.compose.material.icons.filled.FoodBank
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.LocalGasStation
import androidx.compose.material.icons.filled.Movie
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Expense(
    val id: Long = -1,
    val amount: Double,
    val category: ExpenseCategory,
    val description: String
) {
    val icon = category.icon
    val color = category.color
}

enum class ExpenseCategory(val icon: ImageVector, val color: Color) {
    GROCERIES(Icons.Default.FoodBank, Color.Cyan),
    HOUSE(Icons.Default.Home, Color.Magenta),
    UTILITIES(Icons.Default.Lightbulb, Color.Yellow),
    PARTY(Icons.Default.Fastfood, Color.Red),
    COFFEE(Icons.Default.Coffee, Color.Green),
    TRANSPORTATION(Icons.Default.LocalGasStation, Color.Blue),
    ENTERTAINMENT(Icons.Default.Movie, Color.Gray),
}
