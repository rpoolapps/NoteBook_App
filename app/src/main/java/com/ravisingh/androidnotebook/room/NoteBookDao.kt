package com.ravisingh.androidnotebook.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ravisingh.androidnotebook.model.Notebook

@Dao
interface NoteBookDao {

    @Insert
    suspend fun insert(notebook: Notebook)

    @Delete
    suspend fun delete(notebook: Notebook)

    @Query("SELECT * FROM Notebook")
    suspend fun getAllNoteBook(): List<Notebook>
}