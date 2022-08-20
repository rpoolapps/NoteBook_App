package com.ravisingh.androidnotebook.room

import androidx.room.*
import com.ravisingh.androidnotebook.model.Notebook

@Dao
interface NoteBookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(notebook: Notebook)

    @Delete
    fun delete(notebook: Notebook)

    @Query("SELECT * FROM Notebook")
    fun getAllNoteBook(): List<Notebook>
}