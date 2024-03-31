import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.ExpenseManager
import model.Expense

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExpensesScreen() {

    val colors = getColorTheme()

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        stickyHeader {
            Column(
                modifier = Modifier.background(colors.background)
            ) {
                ExpensesTotalHeader(103.52)
                AllExpensesHeader()
            }
        }

        items(ExpenseManager.fakeExpenses) { expense ->
            ExpenseItem(expense = expense) {

            }
        }
    }
}

@Composable
fun ExpensesTotalHeader(total: Double) {
    Card(shape = RoundedCornerShape(30), backgroundColor = Color.Black, elevation = 5.dp) {
        Box(
            modifier = Modifier.fillMaxWidth().padding(16.dp).height(130.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                "$$total",
                style = MaterialTheme.typography.h6,
                color = Color.White,
                fontSize = 30.sp
            )
            Text(
                modifier = Modifier.align(Alignment.CenterEnd),
                text = "USD",
                color = Color.Gray
            )
        }
    }
}

@Composable
fun AllExpensesHeader() {
    val colors = getColorTheme()
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "All Expenses",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.weight(1f),
            fontSize = 20.sp,
            color = colors.textColor
        )
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(20),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
            enabled = false
        ) {
            Text("View All", style = MaterialTheme.typography.body1)
        }
    }
}

@Composable
fun ExpenseItem(expense: Expense, onExpenseClick: (Expense) -> Unit) {
    val colors = getColorTheme()
    Card(
        modifier = Modifier.padding(8.dp).fillMaxWidth().clickable {
            onExpenseClick(expense)
        },
        shape = RoundedCornerShape(20),
        elevation = 10.dp,
        backgroundColor = colors.background
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(65.dp).padding(8.dp),
                shape = RoundedCornerShape(20),
                color = expense.color.copy(alpha = 0.6f)
            ) {
                Image(
                    imageVector = expense.icon,
                    contentDescription = expense.description,
                    colorFilter = ColorFilter.tint(Color.White),
                    contentScale = ContentScale.Crop,
                )
            }
            Column(
                modifier = Modifier.padding(start = 8.dp).weight(1f)
            ) {
                Text(
                    text = expense.category.name,
                    style = MaterialTheme.typography.h6,
                    color = colors.textColor,
                    fontSize = 18.sp
                )
                Text(
                    text = expense.description,
                    style = MaterialTheme.typography.body1,
                    color = Color.Gray
                )
            }
            Text(
                text = "$${expense.amount}",
                style = MaterialTheme.typography.h6,
                color = colors.textColor,
                fontSize = 18.sp,
                modifier = Modifier.padding(end = 16.dp)
            )
        }

    }
}
