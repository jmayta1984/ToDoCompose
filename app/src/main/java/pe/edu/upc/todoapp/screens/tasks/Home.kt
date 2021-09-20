package pe.edu.upc.todoapp.screens.tasks

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pe.edu.upc.todoapp.Routes
import pe.edu.upc.todoapp.data.local.AppDatabase
import pe.edu.upc.todoapp.data.models.Task

@Composable
fun Home(
    navController: NavController,
    selectTask: (Int) -> Unit
) {

    val context = LocalContext.current
    var tasks by remember { mutableStateOf(mutableListOf<Task>())}

    LaunchedEffect(key1 = Unit, block = {
        tasks = AppDatabase.getInstance(context).taskDao().fetchAll()
    })

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Routes.TaskDetails.routeWithoutArgument)
            }) {
                Icon(Icons.Filled.Add, "")
            }
        }
    ) {
        TaskList(tasks, selectTask)
    }
}

@Composable
fun TaskList(tasks: MutableList<Task>, selectTask: (Int) -> Unit) {
    LazyColumn {
        items(tasks) { task ->
            TaskRow(task, selectTask)
        }
    }
}

@Composable
fun TaskRow(task: Task, selectTask: (Int) -> Unit) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            selectTask(task.id)
        }
        .padding(8.dp)
    ) {
        Text(task.name)
    }
}
