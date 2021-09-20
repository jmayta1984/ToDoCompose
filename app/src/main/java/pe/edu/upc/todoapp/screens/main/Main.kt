package pe.edu.upc.todoapp.screens.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.edu.upc.todoapp.Routes
import pe.edu.upc.todoapp.screens.tasks.Home
import pe.edu.upc.todoapp.screens.details.TaskDetails

@Composable
fun Main() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {

        composable(Routes.Home.route) {
            Home(navController) {
                navController.navigate("${Routes.TaskDetails.route}/$it")
            }
        }

        composable(
            route = Routes.TaskDetails.routeWithArgument,
            arguments = listOf(
                navArgument(Routes.TaskDetails.argument) { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt(Routes.TaskDetails.argument)
            if (id != null) {
                TaskDetails(id) {
                    navController.navigateUp()
                }
            }
        }
    }
}