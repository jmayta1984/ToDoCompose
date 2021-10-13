package pe.edu.upc.todoapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import pe.edu.upc.todoapp.data.local.TaskDao
import pe.edu.upc.todoapp.data.repository.TaskRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideTaskRepository(
        taskDao: TaskDao
    ): TaskRepository {
        return TaskRepository(taskDao)
    }
}