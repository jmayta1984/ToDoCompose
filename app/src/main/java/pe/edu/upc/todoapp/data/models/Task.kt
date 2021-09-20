package pe.edu.upc.todoapp.data.models

import androidx.compose.runtime.Immutable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
@Immutable
data class Task(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "task_name")
    var name: String
)