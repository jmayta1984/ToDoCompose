package pe.edu.upc.todoapp.screens.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.edu.upc.todoapp.data.models.Task
import pe.edu.upc.todoapp.data.repository.TaskRepository
import javax.inject.Inject

@HiltViewModel
class TaskDetailsViewModel @Inject constructor(
    private val taskRepository: TaskRepository

) : ViewModel() {

    private var _task: LiveData<Task> = MutableLiveData()
    val task: LiveData<Task> get() = _task

    fun fetchById(id: Int) {
        _task = taskRepository.fetchById(id)
    }

    fun insert(task: Task) {
        viewModelScope.launch {
            taskRepository.insert(task)
        }

    }

    fun update(task: Task) {
        viewModelScope.launch {
            taskRepository.update(task)
        }

    }
}