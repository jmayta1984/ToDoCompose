package pe.edu.upc.todoapp.data.repository

import pe.edu.upc.todoapp.data.local.TaskDao
import pe.edu.upc.todoapp.data.models.Task
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val taskDao: TaskDao
) {

    fun fetchAll() = taskDao.fetchAll()

    fun fetchById(id: Int) = taskDao.fetchById(id)

    suspend fun insert(vararg task: Task) = taskDao.insert(*task)

    suspend fun update(vararg task: Task) = taskDao.update(*task)
}