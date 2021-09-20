package pe.edu.upc.todoapp

sealed class Routes(val route: String) {
    object Home : Routes("Home")
    object TaskDetails : Routes("TaskDetails"){
        const val routeWithArgument: String = "TaskDetails/{taskId}"
        const val argument: String = "taskId"

        const val routeWithoutArgument: String = "TaskDetails/0"
    }
}