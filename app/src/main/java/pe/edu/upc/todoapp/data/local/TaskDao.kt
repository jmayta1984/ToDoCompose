package pe.edu.upc.todoapp.data.local

import androidx.room.*
import pe.edu.upc.todoapp.data.models.Task

@Dao
interface TaskDao {

    @Query("select * from tasks")
    suspend fun fetchAll(): MutableList<Task>

    @Query("select * from tasks where id =:id")
    suspend fun fetchById(id: Int): Task

    @Insert
    suspend fun insert(vararg task: Task)

    @Delete
    suspend fun delete(vararg task: Task)

    @Update
    suspend fun update(vararg task: Task)
}