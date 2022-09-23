package com.example.crud_mvvm.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    //if we set a Todo with the same id it will replace it
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)

    @Query("SELECT * FROM todo WHERE id = :id")
    suspend fun getTodoByID(id: Int): Todo?

    //FLow - we get real-time updates as soon as
    @Query("SELECT * FROM todo")
    fun getTodos(): Flow<List<Todo>>
}