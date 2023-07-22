package com.example.project2_todolistapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


// Dao -> data access object -> This helps to access the database in an easy manner
@Dao
interface TodoDao {
// CRUD operation
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTodo(todo: Todo)

    @Query("Select * from notes_table")
    fun fetchAllTodos(): MutableList<Todo>
}