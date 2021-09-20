package pe.edu.upc.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import pe.edu.upc.todoapp.screens.main.Main
import pe.edu.upc.todoapp.ui.theme.TodoAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoAppTheme {
                Main()
            }
        }
    }
}



