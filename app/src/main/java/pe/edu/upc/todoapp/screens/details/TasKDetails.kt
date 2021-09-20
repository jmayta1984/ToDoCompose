package pe.edu.upc.todoapp.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import pe.edu.upc.todoapp.data.local.AppDatabase
import pe.edu.upc.todoapp.data.models.Task

@Composable
fun TaskDetails(
    id: Int,
    pressOnBack: () -> Unit
) {
    val context = LocalContext.current
    val composableScope = rememberCoroutineScope()
    var name by remember { mutableStateOf("") }

    if (id > 0)
        LaunchedEffect(key1 = Unit, block = {
            name = AppDatabase.getInstance(context).taskDao().fetchById(id).name
        })

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                composableScope.launch {
                    AppDatabase.getInstance(context).taskDao().apply {
                        if (id == 0) {
                            insert(Task(id, name))
                        } else {
                            update(Task(id, name))
                        }
                    }
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