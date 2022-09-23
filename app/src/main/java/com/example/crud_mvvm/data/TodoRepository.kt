package com.example.crud_mvvm.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    suspend fun insertTodo(todo: Todo)


    suspend fun deleteTodo(todo: Todo)

    suspend fun getTodoByID(id: Int): Todo?

    fun getTodos(): Flow<List<Todo>>
}