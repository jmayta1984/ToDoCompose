package pe.edu.upc.todoapp.screens.main

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.edu.upc.todoapp.Routes
import pe.edu.upc.todoapp.screens.tasks.Home
import pe.edu.upc.todoapp.screens.details.TaskDetails
import pe.edu.upc.todoapp.screens.details.TaskDetailsViewModel
import pe.edu.upc.todoapp.screens.tasks.HomeViewModel

@Composable
fun Main() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {

        composable(Routes.Home.route) {
            val viewModel = hiltViewModel<HomeViewModel>()
            Home(
                viewModel,
                navController) {
                navController.navigate("${Routes.TaskDetails.route}/$it")
            }
        }

        composable(
            route = Routes.TaskDetails.routeWithArgument,
            arguments = listOf(
                navArgument(Routes.TaskDetails.argument) { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val viewModel = hiltViewModel<TaskDetailsViewModel>()
            val id =
                backStackEntry.arguments?.getInt(Routes.TaskDetails.argument) ?: return@composable

            viewModel.fetchById(id)

            TaskDetails(viewModel) {
                navController.navigateUp()
            }

        }
    }
}