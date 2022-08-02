package com.ravisingh.androidnotebook.repository

import android.content.Context
import com.ravisingh.androidnotebook.model.Notebook
import com.ravisingh.androidnotebook.room.NoteBookDatabase

class NoteBookRepo  {

    suspend fun insert(context:Context,notebook: Notebook){
        NoteBookDatabase.get(context).getNoteBookDao().insert(notebook)
    }

    suspend fun delete(context:Context,notebook: Notebook){
        NoteBookDatabase.get(context).getNoteBookDao().delete(notebook)
    }

    suspend fun getAllNotebooks(context:Context):List<Notebook>{
        return NoteBookDatabase.get(context).getNoteBookDao().getAllNoteBook()
    }

}