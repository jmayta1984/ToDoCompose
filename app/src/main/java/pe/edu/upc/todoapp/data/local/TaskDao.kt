package pe.edu.upc.todoapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import pe.edu.upc.todoapp.data.models.Task

@Dao
interface TaskDao {

    @Query("select * from tasks")
    fun fetchAll(): LiveData<List<Task>>

    @Query("select * from tasks where id =:id")
    fun fetchById(id: Int): LiveData<Task>

    @Insert
    suspend fun insert(vararg task: Task)

    @Delete
    suspend fun delete(vararg task: Task)

    @Update
    suspend fun update(vararg task: Task)
}