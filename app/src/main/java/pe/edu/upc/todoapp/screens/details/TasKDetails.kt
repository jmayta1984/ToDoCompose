package pe.edu.upc.todoapp.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pe.edu.upc.todoapp.data.models.Task

@Composable
fun TaskDetails(
    viewModel: TaskDetailsViewModel,
    pressOnBack: () -> Unit
) {

    var name by remember { mutableStateOf("") }
    val task: Task? by viewModel.task.observeAsState()

    task?.let {
        name = it.name
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {

                if (task != null) {
                    viewModel.update(Task(task!!.id, name))
                } else {
                    viewModel.insert(Task(0, name))
                }

                pressOnBack()
            }) {
                Icon(Icons.Filled.Done, "")
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(4.dp),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = name,
                onValueChange = { name = it },
                label = { Text("Task") })
        }
    }
}