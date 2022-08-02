package com.ravisingh.androidnotebook.room

import androidx.room.*
import com.ravisingh.androidnotebook.model.Notebook

@Dao
interface NoteBookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(notebook: Notebook)

    @Delete
    suspend fun delete(notebook: Notebook)

    @Query("SELECT * FROM Notebook")
    suspend fun getAllNoteBook(): List<Notebook>
}