package pe.edu.upc.todoapp.screens.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pe.edu.upc.todoapp.data.models.Task
import pe.edu.upc.todoapp.data.repository.TaskRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val taskRepository: TaskRepository
) : ViewModel() {
    private var _tasks: LiveData<List<Task>> = MutableLiveData()
    val tasks: LiveData<List<Task>> get() = _tasks

    fun fetchAll() {
        _tasks = taskRepository.fetchAll()
    }
}
